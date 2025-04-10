<?php
// Parse JSON data from the request body
$json_data = file_get_contents('php://input');
$data = json_decode($json_data, true);

// Check if JSON decoding was successful
if (json_last_error() !== JSON_ERROR_NONE) {
    die('Error parsing JSON data');
}

// Extract the log string from the JSON data
$acct_num = $data['acct_num'] ?? '';
$log_string = $data['log'] ?? '';

if (empty($log_string)) {
    die('Error: Log string is empty');
}

// Database connection
$connection = new mysqli("localhost", "root", "", "root");

if ($connection->connect_error) {
    die("Connection failed: " . $connection->connect_error);
}

$table = "account";

// Insert the log string into the database
$query = "UPDATE $table SET `log` = '$log_string' WHERE `acct_num` = $acct_num";

$sql = mysqli_query($connection, $query);

if ($sql) {
    http_response_code(200);
    echo "Log entry added successfully";
} else {
    http_response_code(401);
    die('Error: ' . mysqli_error($connection));
}

$connection->close();
