<?php
$con=mysqli_connect("localhost","root","","ced");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
 
$searchid = $_GET['searchid'];

$sql = "Select search From searches WHERE searchid=$searchid;

$result = $conn->query($sql);

$emparray = array();
while($row =mysqli_fetch_assoc($result)){
	$emparray[] = $row;
}

if(!empty($emparray){
	echo "SUCCESS");
}
else{
	echo "FAIL"
}

mysqli_close($con);
?>