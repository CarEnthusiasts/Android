<?php
$con=mysqli_connect("localhost","root","","ced");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
 
$user = $_GET['user'];


$sql = "SELECT car.carid,car.make,car.model,car.yearmade,
car.price,car.mileage,car.exterior,car.picture
 FROM car WHERE userid = '$user'";


$result = $con->query($sql);

$emparray = array();
while($row =mysqli_fetch_assoc($result)){
	$emparray[] = $row;
}
echo json_encode($emparray);

mysqli_close($con);
?>