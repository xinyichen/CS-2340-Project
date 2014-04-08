<?php
require 'connect.inc.php';

$query="SELECT * FROM account_information WHERE username = '$_GET[username]'";
$result = mysqli_query($con, $query) or die("Error: ".mysqli_error($con));

if (mysqli_num_rows($result) == NULL) {
	echo "No account found";
} else {
	while ($row = mysqli_fetch_assoc($result)) { // loop n times if there are n returned rows
		echo 	'<full_name>'.$row['account_full_name'].'</full_name>'
			.'<display_name>'.$row['account_display_name'].'</display_name>'
			.'<balance>'.$row['balance'].'</balance>'
			.'<interest_rate>'.$row['interest_rate'].'</interest_rate>';
	}			
}

mysqli_close($con)

?>