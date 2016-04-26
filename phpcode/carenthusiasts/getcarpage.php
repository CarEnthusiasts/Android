<?php
$con=mysqli_connect("localhost","root","","ced");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
 
$carid = $_GET['carid'];


$sql = "SELECT *  FROM car WHERE carid = '$carid'";


$result = $con->query($sql);

$emparray = array();
while($row =mysqli_fetch_assoc($result)){
	$emparray[] = $row;
}
echo json_encode($emparray);

mysqli_close($con);
?>