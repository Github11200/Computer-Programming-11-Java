<?php

class Utils
{
    public $table = "account";

    public function parse_json($json_data)
    {
        $data = json_decode($json_data, true);
        if (json_last_error() !== JSON_ERROR_NONE) {
            throw new Exception('Error parsing JSON data: ' . json_last_error_msg());
        }
        return $data;
    }

    public function connect_to_database($host, $user, $password, $dbname)
    {
        $connection = new mysqli($host, $user, $password, $dbname);
        if ($connection->connect_error) {
            throw new Exception("Connection failed: " . $connection->connect_error);
        }
        return $connection;
    }

    public function log_query($new_log, $acct_num, $connection)
    {
        $log_query = "UPDATE `account` SET `log`=concat(log, '$new_log') WHERE acct_num = '$acct_num'";
        if (!mysqli_query($connection, $log_query)) {
            throw new Exception('Error logging query: ' . mysqli_error($connection));
        }
    }

    public function get_balance($acct_num, $password, $connection)
    {
        $find_query = "SELECT * FROM $this->table WHERE acct_num = '$acct_num' AND password = '$password'";
        $sql = mysqli_query($connection, $find_query);

        $row = mysqli_fetch_assoc($sql);
        if ($row) {
            return $row['balance'];
        } else {
            throw new Exception('Error fetching balance: ' . mysqli_error($connection));
        }
    }
}
