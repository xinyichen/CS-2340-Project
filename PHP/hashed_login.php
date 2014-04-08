<?php
require 'connect.inc.php';

$username = $_GET['username'];

$query="SELECT password FROM user_information WHERE username='".mysqli_real_escape_string($con, $username)."'";

$result = mysqli_query($con,$query) or die("Error: ".mysqli_error($con));

if(mysqli_num_rows($result) != NULL) {
	$row = mysqli_fetch_assoc($result);
	echo '<hashed_password>'.$row['password'].'</hashed_password>';
} else {
	echo "<not_found>Not Found</not_found>";
}

mysqli_close($con)

?>