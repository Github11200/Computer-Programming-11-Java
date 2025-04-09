import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ServerBankAccountManager {
    HttpURLConnectionATM connection;

    ServerBankAccountManager() {
        connection = new HttpURLConnectionATM();
    }

    private JSONObject createJSONObject(HashMap<String, Object> params) throws JSONException {
        JSONObject requestParams = new JSONObject();
        for (String key : params.keySet()) {
            Object value = params.get(key);
            requestParams.put(key, value);
        }

        return requestParams;
    }

    private JSONObject sendRequest(String requestURL, JSONObject requestParams) throws Exception {
        String response = connection.sendPost(requestURL, requestParams);
        return new JSONObject(response);
    }

    boolean accountExists(int acctNum) {
        try {
            JSONObject response = sendRequest("account/accountExists.php", createJSONObject(new HashMap<>() {{
                put("acct_num", acctNum);
            }}));

            return !response.has("error");
        } catch (Exception e) {
            System.out.println("Error while checking if account exists: " + e.getMessage());
            return false;
        }
    }

    boolean checkPassword(int acctNum, String password) {
        try {
            JSONObject response = sendRequest("account/checkPassword.php", createJSONObject(new HashMap<>() {{
                put("acct_num", acctNum);
                put("password", password);
            }}));

            return !response.has("error");
        } catch (Exception e) {
            System.out.println("Error while checking if account exists: " + e.getMessage());
            return false;
        }
    }

    BankAccount getAccount(int acctNum, String password) throws Exception {
        try {
            JSONObject response = sendRequest("account/getAccount.php", createJSONObject(new HashMap<>() {{
                put("acct_num", acctNum);
                put("password", password);
            }}));

            return new BankAccount(Integer.parseInt(response.get("acct_num").toString()),
                    Double.parseDouble(response.get("balance").toString()),
                    response.get("first_name").toString(),
                    response.get("last_name").toString(),
                    response.get("password").toString(),
                    response.get("log").toString());
        } catch (Exception e) {
            throw new Exception("Error while getting account: " + e.getMessage());
        }
    }

    BankAccount deposit(int acctNum, int amount, String password) throws Exception {
        try {
            JSONObject response = sendRequest("deposit.php", createJSONObject(new HashMap<>() {{
                put("acct_num", acctNum);
                put("password", password);
                put("amount", amount);
            }}));

            System.out.println(acctNum);
            System.out.println(password);
            System.out.println(response.has("error"));
            if (response.has("error")) return null;
            return getAccount(acctNum, password);
        } catch (Exception e) {
            throw new Exception("Error while depositing to account: " + e.getMessage());
        }
    }

    BankAccount withdraw(int acctNum, int amount, String password) throws Exception {
        try {
            JSONObject response = sendRequest("withdraw.php", createJSONObject(new HashMap<>() {{
                put("acct_num", acctNum);
                put("password", password);
                put("amount", amount);
            }}));

            if (response.has("error") && response.get("error").equals("amount")) throw new Exception("amount");
            else if (response.has("error") && response.get("error").equals("withdrawal"))
                throw new Exception("withdrawal");
            return getAccount(acctNum, password);
        } catch (Exception e) {
            throw new Exception("Error while withdrawing from account: " + e.getMessage());
        }
    }

    BankAccount transfer(int acctNum, int targetAcctNum, int amount, String password) throws Exception {
        try {
            JSONObject response = sendRequest("transfer.php", createJSONObject(new HashMap<>() {{
                put("acct_num", acctNum);
                put("target_acct_num", targetAcctNum);
                put("amount", amount);
            }}));

            if (response.has("error")) {
                String error = response.get("error").toString();
                if (error.equals("transfer")) throw new Exception("transfer");
            }
            return getAccount(acctNum, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    BankAccount changePassword(int acctNum, String oldPassword, String newPassword) throws Exception {
        try {
            JSONObject response = sendRequest("account/changePassword.php", createJSONObject(new HashMap<>() {{
                put("acct_num", acctNum);
                put("password", oldPassword);
                put("new_password", newPassword);
            }}));

            if (response.has("error")) throw new Exception("Could not update password!");
            return getAccount(acctNum, newPassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void createAccount(BankAccount newAccount) throws Exception {
        try {
            JSONObject response = sendRequest("account/createAccount.php", createJSONObject(new HashMap<>() {{
                put("acct_num", newAccount.getAcctNum());
                put("password", newAccount.pswd);
                put("first_name", newAccount.getFName());
                put("last_name", newAccount.getLName());
            }}));

            if (response.has("error")) throw new Exception("Could not create account!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
