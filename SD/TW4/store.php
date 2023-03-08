<?php
$con = mysqli_connect("localhost", "root", "password", "db");
if(!$con)
{
	die('Could not connect: '.mysql_error());
}

$sql="INSERT INTO db.table VALUES('$_POST[name]', '$_POST[add1]', '$_POST[add2]', '$_POST[email]')";"

if(!mysqli_query($con,$sql))
{
	die('Error: '.mysqli_error());
}
echo "1 Record added";
mysqli_close($con);
?>