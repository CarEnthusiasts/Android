<?php
$con=mysqli_connect("localhost","root","","ced");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
 
$make = $_GET['make'];
$model = $_GET['model'];
$yearmin = $_GET['yearmin'];
$pricemin = $_GET['pricemin'];
$mileagemin = $_GET['mileagemin'];
$cylindersmin = $_GET['cylindersmin'];
$displacementmin = $_GET['displacementmin'];
$hpmin = $_GET['hpmin'];
$tqmin = $_GET['tqmin'];
$zerosixtymin = $_GET['zerosixtymin'];
$topspeedmin = $_GET['topspeedmin'];
$sixtyzeromin = $_GET['sixtyzeromin'];
$seatsmin = $_GET['seatsmin'];
$yearmax = $_GET['yearmax'];
$pricemax = $_GET['pricemax'];
$mileagemax = $_GET['mileagemax'];
$cylindersmax = $_GET['cylindersmax'];
$displacementmax = $_GET['displacementmax'];
$hpmax = $_GET['hpmax'];
$tqmax = $_GET['tqmax'];
$zerosixtymax = $_GET['zerosixtymax'];
$topspeedmax = $_GET['topspeedmax'];
$sixtyzeromax = $_GET['sixtyzeromax'];
$seatsmax = $_GET['seatsmax'];
$exterior = $_GET['exterior'];
$interior = $_GET['interior'];
$drivetrain = $_GET['drivetrain'];
$transmission = $_GET['transmission'];
$fuel = $_GET['fuel'];
$bodytype = $_GET['bodytype'];
$tag1 = $_GET['tag1'];
$tag2 = $_GET['tag2'];
$tag3 = $_GET['tag3'];
$tag4 = $_GET['tag4'];
$tag5 = $_GET['tag5'];
$tag6 = $_GET['tag6'];
$tag7 = $_GET['tag7'];
$tag8 = $_GET['tag8'];
$tag9 = $_GET['tag9'];
$tag10 = $_GET['tag10'];

$sql = "SELECT DISTINCT car.carid,car.make,car.model,car.yearmade,
car.price,car.mileage,car.exterior,car.picture
 FROM car LEFT JOIN tags ON car.carid= tags.carid WHERE";

if (!empty($make)){	
	$sql .= " make = '$make'";
}
else{
	$sql .= " make IS NOT NULL";
}

if (!empty($model)){	
	$sql .= " AND model = '$model'";
}
else{
	$sql .= " AND model IS NOT NULL";
}

if (!empty($yearmin)){	
	$sql .= " AND yearmade >= '$yearmin'";
}

if (!empty($yearmax)){	
	$sql .= " AND yearmade <= '$yearmax'";
}

if (!empty($pricemin)){	
	$sql .= " AND price >= '$pricemin'";
}
if (!empty($pricemax)){	
	$sql .= " AND price <='$pricemax'";
}

if (!empty($mileagemin)){	
	$sql .= " AND mileage >= '$mileagemin'";
}

if (!empty($mileagemax)){	
	$sql .= " AND mileage <= '$mileagemax'";
}

if (!empty($cylindermin)){	
	$sql .= " AND cylinder >= '$cylindermin'";
}
if (!empty($cylindermax)){	
	$sql .= " AND cylinder <= '$cylindermax'";
}
if (!empty($exterior)){	
	$sql .= " AND exterior = '$exterior'";
}
if (!empty($interior)){	
	$sql .= " AND interior = '$interior'";
}
if (!empty($drivetrain)){	
	$sql .= " AND drivetrain = '$drivetrain'";
}
if (!empty($transmission)){	
	$sql .= " AND transmission = '$transmission'";
}
if (!empty($fuel)){	
	$sql .= " AND fuel = '$fuel'";
}
if (!empty($bodytype)){	
	$sql .= " AND bodytype = '$bodytype'";
}
if (!empty($seatsmin)){	
	$sql .= " AND seats >= '$seatsmin'";
}
if (!empty($seatsmax)){	
	$sql .= " AND seats <= '$seatsmax'";
}
if (!empty($hpmin)){	
	$sql .= " AND hp >= '$hpmin'";
}
if (!empty($hpmax)){	
	$sql .= " AND hp <= '$hpmax'";
}
if (!empty($tqmin)){	
	$sql .= " AND tq >= '$tqmin'";
}
if (!empty($tqmax)){	
	$sql .= " AND tq <= '$tqmax'";
}
if (!empty($displacementmin)){	
	$sql .= " AND displacement >= '$displacementmin'";
}
if (!empty($displacementmax)){	
	$sql .= " AND displacement <= '$displacementmax'";
}
if (!empty($zerosixtymin)){	
	$sql .= " AND zerosixty >= '$zerosixtymin'";
}
if (!empty($zerosixtymax)){	
	$sql .= " AND zerosixty <= '$zerosixtymax'";
}
if (!empty($sixtyzeromin)){	
	$sql .= " AND sixtyzero >= '$sixtyzeromin'";
}
if (!empty($sixtyzeromax)){	
	$sql .= " AND sixtyzero <= '$sixtyzeromax'";
}
if (!empty($topspeedmin)){	
	$sql .= " AND topspeed >= '$topspeedmin'";
}
if (!empty($sixtyzeromax)){	
	$sql .= " AND topspeed <= '$topspeedmax'";
}
if (!empty($tag1)){	
	$sql .= " AND tag = '$tag1'";
}
if (!empty($tag2)){	
	$sql .= " AND tag = '$tag2'";
}
if (!empty($tag3)){	
	$sql .= " AND tag = '$tag3'";
}
if (!empty($tag4)){	
	$sql .= " AND tag = '$tag4'";
}
if (!empty($tag5)){	
	$sql .= " AND tag = '$tag5'";
}
if (!empty($tag6)){	
	$sql .= " AND tag = '$tag6'";
}
if (!empty($tag7)){	
	$sql .= " AND tag = '$tag7'";
}
if (!empty($tag8)){	
	$sql .= " AND tag = '$tag8'";
}
if (!empty($tag9)){	
	$sql .= " AND tag = '$tag9'";
}
if (!empty($tag10)){	
	$sql .= " AND tag = '$tag10'";
}

$result = $con->query($sql);

$emparray = array();
while($row =mysqli_fetch_assoc($result)){
	$emparray[] = $row;
}
echo json_encode($emparray);

mysqli_close($con);
?>