<?php
$con=mysqli_connect("localhost","root","","ced");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
 
$userid = $_GET['userid'];

$sql = "Select searchname From searches WHERE userid=$userid ";

$result = $conn->query($sql);

$emparray = array();
while($row =mysqli_fetch_assoc($result)){
	$emparray[] = $row;
}

echo json_encode($emparray);

mysqli_close($con);
?>