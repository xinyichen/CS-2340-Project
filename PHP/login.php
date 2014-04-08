<?php
require 'connect.inc.php';

$username = $_GET['username'];
$password = $_GET['password'];

//$query="SELECT 'username' FROM 'user_information' WHERE 'username'='".mysqli_real_escape_string($username)."' AND 'password'='".mysqli_real_escape_string($password)."'";

$query="SELECT username FROM user_information WHERE username='".mysqli_real_escape_string($con, $username)."' AND password='".mysqli_real_escape_string($con, $password)."'";

//$query="SELECT username FROM user_information WHERE username= '$_GET[username]' AND password = '$_GET[password]'";

$r = mysqli_query($con,$query) or die("Error: ".mysqli_error($con));

if(mysqli_fetch_array($r))
  {
  echo "<body> Found </body>";
  }
  else {
  echo "Not Found or incorrect password";
  }

mysqli_close($con)

?>