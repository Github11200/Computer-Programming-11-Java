<?php
// Parse JSON data from the request body
$json_data = file_get_contents('php://input');
$data = json_decode($json_data, true);

// Check if JSON decoding was successful
if (json_last_error() !== JSON_ERROR_NONE) {
    die('Error parsing JSON data');
}

$acct_num = $data['acct_num'] ?? '';
$amount = $data['amount'] ?? '';

$connection = new mysqli("localhost", "root", "", "root");

if ($connection->connect_error) {
    die("Connection failed: " . $connection->connect_error);
}

$table = "account";

$query = "UPDATE account\n"

    . "SET balance = balance + '$amount'\n"

    . "WHERE acct_num = '$acct_num';";

$sql = mysqli_query($connection, $query);

echo $acct_num;
if ($sql) {
    http_response_code(200);
} else {
    http_response_code(401);
    die('Error: ' . mysqli_error($connection));
}

$connection->close();
