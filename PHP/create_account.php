<?php
require 'connect.inc.php';


$query="INSERT INTO account_information (username, account_display_name, account_full_name, balance, interest_rate)
VALUES
('$_GET[username]','$_GET[account_display_name]','$_GET[account_full_name]', '$_GET[balance]', '$_GET[interest_rate]')";
$r = mysqli_query($con,$query) or die("Error: ".mysqli_error($con));

if ($r) {
echo "<body> account created </body>";
}

else {
echo "rejected";
}

mysqli_close($con)

?>