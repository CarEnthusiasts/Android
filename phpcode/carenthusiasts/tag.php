<?php
$con=mysqli_connect("localhost","root","","ced");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
 
$category = $_GET['category'];
$tag = $_GET['tag'];
$description = $_GET['description'];
$carid = $_GET['carid'];
 
$result = mysqli_query($con,"INSERT INTO tags (category,tag,description,carid) 
          VALUES ('$category', '$tag', '$description', '$carid')");
 
if($result == true) {
    echo '{"query_result":"SUCCESS"}';
}
else{
    echo '{"query_result":"FAILURE"}';
}
mysqli_close($con);
?>