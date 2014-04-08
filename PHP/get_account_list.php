<?php
require 'connect.inc.php';

$query="SELECT account_display_name FROM account_information WHERE username = '$_GET[username]'";
$result = mysqli_query($con, $query) or die("Error: ".mysqli_error($con));

if (mysqli_num_rows($result) == NULL) {
	echo "No accounts available";
} else {
	while($row = mysqli_fetch_assoc($result)) {
		echo '<display_name>'.$row['account_display_name'].'</display_name>';
	}
}

mysqli_close($con)

?>