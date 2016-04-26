<?php
$con=mysqli_connect("localhost","root","","ced");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
 
$email = $_GET['email'];
$password = $_GET['password'];

$sql = "UPDATE users SET password=
'$password' WHERE email='$email'";

$result = $con->query($sql);

if ($result === TRUE) {
    echo "Record updated successfully";
} else {
    echo "Error updating record: " . $conn->error;
}
//echo json_encode($emparray);

mysqli_close($con);
?>