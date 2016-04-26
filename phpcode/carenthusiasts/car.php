<?php
$con=mysqli_connect("localhost","root","","ced");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
 
$make = $_GET['make'];
$model = $_GET['model'];
$year = $_GET['year'];
$price = $_GET['price'];
$mileage = $_GET['mileage'];
$cylinders = $_GET['cylinders'];
$displacement = $_GET['displacement'];
$hp = $_GET['hp'];
$tq = $_GET['tq'];
$zerosixty = $_GET['zerosixty'];
$topspeed = $_GET['topspeed'];
$sixtyzero = $_GET['sixtyzero'];
$seats = $_GET['seats'];
$exterior = $_GET['exterior'];
$interior = $_GET['interior'];
$drivetrain = $_GET['drivetrain'];
$transmission = $_GET['transmission'];
$fuel = $_GET['fuel'];
$bodytype = $_GET['bodytype'];
$picture = $_GET['picture'];
$useremail = $_GET['useremail'];
 
$result = mysqli_query($con,"INSERT INTO car (make,model,yearmade,price,
mileage,cylinders,displacement,hp,tq,zerosixty,sixtyzero,topspeed,seats,
exterior,interior,drivetrain,transmission,fuel,bodytype,picture,userid) 
          VALUES ('$make', '$model','$year',
		  '$price','$mileage', '$cylinders','$displacement',
		  '$hp','$tq', '$zerosixty',
		  '$sixtyzero','$topspeed','$seats', '$exterior','$interior',
		  '$drivetrain','$transmission', '$fuel','$bodytype',
		  '$picture','$useremail')");
 
$id = mysqli_insert_id($con);
if($result == true) {
    echo '{"id":'.$id.'}';
}
else{
    echo '{"id":"0"}';
}
mysqli_close($con);
?>