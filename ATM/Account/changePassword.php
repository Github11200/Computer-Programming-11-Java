<?php
include "../utils.php";

$utils = new Utils();
$data = $utils->parse_json(file_get_contents('php://input'));

$acct_num = $data['acct_num'] ?? '';
$password = $data['password'] ?? '';
$new_password = $data['new_password'] ?? '';

$connection = $utils->connect_to_database("localhost", "root", "", "root");

$table = "account";
$update_query = "UPDATE `account` SET `password`='$new_password' WHERE acct_num = '$acct_num' AND password = '$password'";
$update_query_sql = mysqli_query($connection, $update_query);

if (!$update_query_sql) {
    http_response_code(400);

    $log = "\t" . date("Y.m.d.H.i.s") . "  Reset Password Failed!\n";
    $utils->log_query($log, $acct_num, $password, $connection);

    echo json_encode(array("error" => "password_change"));
    die('Error: ' . mysqli_error($connection));
}

$log = "\t" . date("Y.m.d.H.i.s") . "  Password Changed [$acct_num]\n";
$utils->log_query($log, $acct_num, $connection);

echo json_encode(array("message" => "Password changed successfully"));
http_response_code(200);
$connection->close();
