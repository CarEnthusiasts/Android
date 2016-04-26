<?php
$con=mysqli_connect("localhost","root","","ced");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
 
$userid = $_GET['carid'];

$sql = "Select * From car c WHERE carid=$carid ";

$result = $conn->query($sql);

$emparray = array();
while($row =mysqli_fetch_assoc($result)){
	$emparray[] = $row;
}

echo json_encode($emparray);

mysqli_close($con);
?>