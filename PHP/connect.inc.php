<?php
$mysql_host = "localhost";
$mysql_database = "zli342_WhereIsMyMoney";
$mysql_user = "zli342_team38";
$mysql_password = "team38";

$con = mysqli_connect($mysql_host, $mysql_user, $mysql_password, $mysql_database);

if (!$con)
{
  die("Failed to connect to MySQL: " . mysqli_connect_error());
}  
?>