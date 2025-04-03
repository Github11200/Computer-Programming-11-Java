import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ServerBankAccountManager {
    HttpURLConnectionATM connection;

    ServerBankAccountManager() {
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
            JSONObject response = sendRequest("/account/exists", createJSONObject(new HashMap<>() {{
                put("acctNum", acctNum);
            }}));

            return !response.has("error");
        } catch (Exception e) {
            System.out.println("Error while checking if account exists: " + e.getMessage());
            return false;
        }
    }

    boolean checkPassword(int acctNum, String password) {
        try {
            JSONObject response = sendRequest("/account/checkPassword", createJSONObject(new HashMap<>() {{
                put("acctNum", acctNum);
                put("password", password);
            }}));

            return !response.has("error");
        } catch (Exception e) {
            System.out.println("Error while checking if account exists: " + e.getMessage());
            return false;
        }
    }

    BankAccount getAccount(int acctNum) throws Exception {
        try {
            JSONObject response = sendRequest("/account/getAccount", createJSONObject(new HashMap<>() {{
                put("acctNum", acctNum);
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
}
