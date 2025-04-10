<?php
$json_data = file_get_contents('php://input');
$data = json_decode($json_data, true);

if (json_last_error() !== JSON_ERROR_NONE) {
    die('Error parsing JSON data');
}

$acct_num = $data['acct_num'] ?? '';

$connection = new mysqli("localhost", "root", "", "root");

if ($connection->connect_error) {
    die("Connection failed: " . $connection->connect_error);
}

$table = "account";

$query = "SELECT * FROM $table WHERE EXISTS (SELECT `acct_num` FROM $table where `acct_num` = $acct_num);";
$sql = mysqli_query($connection, $query);

if (mysqli_num_rows($sql) == 0) {
    http_response_code(404);
    $connection->close();
    echo json_encode(["error" => false]);
    die("Invalid account number.");
}

http_response_code(200);
echo json_encode(array(
    "exists" => true
));

$connection->close();
