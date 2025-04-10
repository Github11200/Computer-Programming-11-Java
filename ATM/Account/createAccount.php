<?php
include "../utils.php";

$utils = new Utils();
$data = $utils->parse_json(file_get_contents('php://input'));

$acct_num = $data['acct_num'] ?? '';
$password = $data['password'] ?? '';
$first_name = $data['first_name'] ?? '';
$last_name = $data['last_name'] ?? '';

$connection = $utils->connect_to_database("localhost", "root", "", "root");

$table = "account";
$insert_query = "INSERT INTO `$table`(`last_name`, `first_name`, `acct_num`, `balance`, `password`, `log`) VALUES ('$last_name','$first_name','$acct_num','0','$password','')";

$insert_query_sql = mysqli_query($connection, $insert_query);

if (!$insert_query_sql) {
    http_response_code(400);
    echo json_encode(array("error" => "account_creation"));
    die('Error: ' . mysqli_error($connection));
}

$log = "\t" . date("Y.m.d.H.i.s") . "  Account Created [$acct_num]\n";
$utils->log_query($log, $acct_num, $connection);

echo json_encode(array("message" => "successful"));
http_response_code(200);

$connection->close();
