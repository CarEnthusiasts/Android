<?php
$con=mysqli_connect("localhost","root","","ced");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
 
$user = $_GET['user'];
$search = $_GET['search'];
$searchname = $_GET['searchname'];
 
$result = mysqli_query($con,"INSERT INTO searches (userid,search,searchname) 
          VALUES ('$user', '$search','$searchname')");
 
if($result == true) {
    echo '{"query_result":"SUCCESS"}';
}
else{
    echo '{"query_result":"FAILURE"}';
}
mysqli_close($con);
?>