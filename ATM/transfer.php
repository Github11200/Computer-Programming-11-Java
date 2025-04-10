<?php
include "utils.php";

$utils = new Utils();
$data = $utils->parse_json(file_get_contents('php://input'));

$acct_num = $data['acct_num'] ?? '';
$target_acct_num = $data['target_acct_num'] ?? '';
$amount = $data['amount'] ?? '';

if ($acct_num == $target_acct_num) {
    http_response_code(401);
    echo json_encode(["error" => "target_acct_num"]);
    die("You cannot transfer to your own account.");
}

$connection = $utils->connect_to_database("localhost", "root", "", "root");

$table = "account";

$withdraw_money_query = "UPDATE account SET balance = balance - '$amount' WHERE acct_num = '$acct_num'";
$deposit_money_query = "UPDATE account SET balance = balance + '$amount' WHERE acct_num = '$target_acct_num'";

$withdraw_money_query_sql = mysqli_query($connection, $withdraw_money_query);
$deposit_money_query_sql = mysqli_query($connection, $deposit_money_query);

$transfer_log = "\t" . date("Y.m.d.H.i.s") . "  Transfer [$" . number_format($amount, 2) . "]\n";
$deposit_log = "\t" . date("Y.m.d.H.i.s") . "  Deposit Successful [$" . number_format($amount, 2) . "]\n";

$utils->log_query($transfer_log, $acct_num, $connection);
$utils->log_query($deposit_log, $target_acct_num, $connection);

if ($withdraw_money_query_sql && $deposit_money_query_sql) {
    http_response_code(200);
    echo json_encode(array("message" => "Transfer successful"));
} else {
    http_response_code(400);
    echo json_encode(array("error" => "transfer"));
    die('Error: ' . mysqli_error($connection));
}

$connection->close();
