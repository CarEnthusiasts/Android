<?php
 
mysql_connect("localhost","root","");//change server name  //pass username according your settings
 
mysql_select_db("example");// also chang the Mysql database name
 
$sql1=mysql_query("select * from login ");
 
if (!$sql1) {
 
echo "Could not successfully run query ($sql) from DB: " . mysql_error();
 
exit;
 
}
 
while($row=mysql_fetch_assoc($sql1))
 
$output[]=$row;
 
  
 
print(json_encode($output));// this will print the output in json
 
mysql_close();
 
?>