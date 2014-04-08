<?php
require 'connect.inc.php';

$query="INSERT INTO user_information (username, first_name, last_name, password, email)
VALUES
('$_GET[username]', '$_GET[first_name]', '$_GET[last_name]', '$_GET[password]','$_GET[email]')";
$r = mysqli_query($con,$query) or die("Error: ".mysqli_error($con));

if ($r) {
echo "<body> registered </body>";
}

else {
echo "rejected";
}

mysqli_close($con)

?>