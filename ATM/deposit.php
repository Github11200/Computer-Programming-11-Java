<?php
include "utils.php";

$utils = new Utils();

$data = $utils->parse_json(file_get_contents('php://input'));

$acct_num = $data['acct_num'] ?? '';
$password = $data['password'] ?? '';
$amount = $data['amount'] ?? '';

$connection = $utils->connect_to_database("localhost", "root", "", "root");

$table = "account";

$new_log = "\t" . date("Y.m.d.H.i.s") . "  Deposit Successful [$" . number_format($amount, 2) . "]\n";

$deposit_query = "UPDATE `account` SET `balance`=balance + $amount WHERE acct_num = '$acct_num' AND password = '$password'";
$deposit_sql = mysqli_query($connection, $deposit_query);

$utils->log_query($new_log, $acct_num, $connection);

if ($deposit_sql) {
    echo json_encode(array(
        "message" => "Deposit successful",
        "acct_num" => $acct_num,
        "amount" => $amount,
        "new_log" => $new_log
    ));
    http_response_code(200);
} else {
    echo json_encode(array(
        "error" => "Deposit failed",
        "acct_num" => $acct_num,
        "amount" => $amount,
        "new_log" => $new_log
    ));
    http_response_code(401);
    die('Error: ' . mysqli_error($connection));
}

$connection->close();
