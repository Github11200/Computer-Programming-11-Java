<?php
include "utils.php";

$utils = new Utils();

$data = $utils->parse_json(file_get_contents('php://input'));

$acct_num = $data['acct_num'] ?? '';
$password = $data['password'] ?? '';
$amount = $data['amount'] ?? '';

$connection = $utils->connect_to_database("localhost", "root", "", "root");

$table = "account";
$balance = $utils->get_balance($acct_num, $password, $connection);

if ($amount > $balance) {
    http_response_code(402);
    echo json_encode(array(
        "error" => "amount",
    ));
    die("Error: Trying to withdraw too much money");
}

$query = "UPDATE account SET balance = balance - '$amount' WHERE acct_num = '$acct_num' AND password = '$password'";

$sql = mysqli_query($connection, $query);
$new_log = "\t" . date("Y.m.d.H.i.s") . "  Withdrawal Successful [$" . number_format($amount, 2) . "]\n";

$utils->log_query($new_log, $acct_num, $connection);

if ($sql) {
    http_response_code(200);
    echo json_encode(array(
        "message" => "Withdrawal successful",
    ));
} else {
    http_response_code(401);
    echo json_encode(array(
        "error" => "withdrawal",
    ));
    die('Error: ' . mysqli_error($connection));
}

$connection->close();
