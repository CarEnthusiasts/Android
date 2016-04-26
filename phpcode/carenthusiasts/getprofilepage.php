<?php
$con=mysqli_connect("localhost","root","","ced");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
 
$email = $_GET['user'];


$sql = "SELECT * FROM users WHERE email = '$email'";


$result = $con->query($sql);

$emparray = array();
while($row =mysqli_fetch_assoc($result)){
	$emparray[] = $row;
}
echo json_encode($emparray);

mysqli_close($con);
?>