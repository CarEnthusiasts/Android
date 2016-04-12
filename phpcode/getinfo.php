<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "signup";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT id, fullname, username FROM user";
$result = $conn->query($sql);

$emparray = array();
while($row =mysqli_fetch_assoc($result)){
	$emparray[] = $row;
}
echo json_encode($emparray);

$conn->close();
?>