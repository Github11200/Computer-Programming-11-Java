<?php
// Parse JSON data from the request body
$json_data = file_get_contents('php://input');
$data = json_decode($json_data, true);

// Check if JSON decoding was successful
if (json_last_error() !== JSON_ERROR_NONE) {
    die('Error parsing JSON data');
}

$account_number = $data['acct_num'] ?? '';
$pswd = $data['password'] ?? '';

$connection = new mysqli("localhost", "root", "", "root");

if ($connection->connect_error) {
    die("Connection failed: " . $connection->connect_error);
}

$table = "account";

$query = "SELECT * FROM $table WHERE acct_num = '$account_number'";

$sql = mysqli_query($connection, $query);

if (mysqli_num_rows($sql) > 0) {
    $row = mysqli_fetch_assoc($sql);
    if ($row['password'] == $pswd) {
        http_response_code(200);
        echo json_encode(array(
            "first_name" => $row['first_name'],
            "last_name" => $row['last_name'],
            "acct_num" => $row['acct_num'],
            "balance" => $row['balance'],
            "password" => $row['password'],
            "log" => $row['log']
        ));
    } else {
        http_response_code(401);
    }
} else {
    http_response_code(402);
    if (!mysqli_query($connection, $query)) {
        die('Error: ' . mysqli_error($connection));
    }
}

$connection->close();
