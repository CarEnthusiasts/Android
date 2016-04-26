<?php
$con=mysqli_connect("localhost","root","","ced");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
 
$emailaddress = $_GET['emailaddress'];
$passWord = $_GET['password'];
 
$result = mysqli_query($con,"INSERT INTO users (email,password) 
          VALUES ('$emailaddress', '$passWord')");
 
if($result == true) {
    echo '{"query_result":"SUCCESS"}';
}
else{
    echo '{"query_result":"FAILURE"}';
}
mysqli_close($con);
?>