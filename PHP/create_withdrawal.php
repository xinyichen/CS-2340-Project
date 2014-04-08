<?php
require 'connect.inc.php';

$query="SELECT * FROM account_information WHERE (username = '$_GET[username]' AND account_display_name = '$_GET[account_name]')";

$r = mysqli_query($con,$query) or die("Error: ".mysqli_error($con));

$row = mysqli_fetch_assoc($r);

$balance = $row['balance'];

$balance = $balance - $_GET[amount];

if ($balance >= 0) {

$sql = "UPDATE account_information SET balance = $balance WHERE (username = '$_GET[username]' AND account_display_name = '$_GET[account_name]')";

$r = mysqli_query($con,$sql) or die("Error: ".mysqli_error($con));

$query="INSERT INTO withdrawal (username, account_name, amount, category, reason, effective_date)
VALUES
('$_GET[username]','$_GET[account_name]','$_GET[amount]', '$_GET[category]', '$_GET[reason]', '$_GET[effective_date]')";
$r = mysqli_query($con,$query) or die("Error: ".mysqli_error($con));

if ($r) {
echo "<body> success </body>";
}

else {
echo "<error> rejected </error>";
}

}

else {
echo "<error> not enough balance </error>";
}

mysqli_close($con)

?>