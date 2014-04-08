<?php

$mysql_host = "localhost";
$mysql_database = "zli342_test";
$mysql_user = "zli342_test";
$mysql_password = "pass123";

$con = mysqli_connect($mysql_host, $mysql_user, $mysql_password, $mysql_database);

if (!$con)
{
  die("Failed to connect to MySQL: " . mysqli_connect_error());
}  

$waittime = 0;
$r = mysqli_query($con,"SELECT CURRENT_TIMESTAMP FROM `table`") or die("Error: ".mysqli_error($con));
		$row = mysqli_fetch_assoc($r);
$CURRENT_TIMESTAMP = $row['CURRENT_TIMESTAMP'];

$delete = "DELETE FROM `table` WHERE `timestamp`+ '20 minute' < CURRENT_TIMESTAMP";
$count = "SELECT COUNT( * ) FROM  `table`";
$getDevice = "SELECT  timestamp, time FROM `table` WHERE `device` = '$_GET[device]'";
$insert =  "INSERT INTO `zli342_test`.`table` (`device`, `timestamp`, `frequency`, `time`) VALUES ('$_GET[device]', CURRENT_TIMESTAMP, '1', '$waittime'*100 + 200);";
$latest = "select timestamp, time from `table` where timestamp = (select max(timestamp) from `table`)";

//$r = mysqli_query($con,$delete) or die("Error: ".mysqli_error($con));

$r = mysqli_query($con,$getDevice) or die("Error: ".mysqli_error($con));
if (mysqli_num_rows($r) == NULL) {
	$r = mysqli_query($con,$count) or die("Error: ".mysqli_error($con));
		$row = mysqli_fetch_assoc($r);
		$numberofppl = $row['COUNT( * )'];
		if ($numberofppl == 0){
		$waittime = 0;
		} else {
		$r = mysqli_query($con,$latest) or die("Error: ".mysqli_error($con));
		$row = mysqli_fetch_assoc($r);
		
		$calcwaittime = "SELECT (TIMESTAMP - CURRENT_TIMESTAMP + time)/60 as diff FROM  `table` where timestamp = (select max(timestamp) from `table`)";
		$r = mysqli_query($con,$calcwaittime) or die("Error: ".mysqli_error($con));
		$row = mysqli_fetch_assoc($r);
		$waittime = ceil($row['diff']);
		if ($waittime < 0 ) { 
		$waittime = 0; 
		}
		} 
		$insert =  "INSERT INTO `zli342_test`.`table` (`device`, `timestamp`, `frequency`, `time`) VALUES ('$_GET[device]', CURRENT_TIMESTAMP, '1', '$waittime'*60 + 120);";
		$r = mysqli_query($con,$insert) or die("Error: ".mysqli_error($con));

	}
	 else {
		$r = mysqli_query($con,$getDevice) or die("Error: ".mysqli_error($con));
		$waittime = $row['timestamp'] + $row['time']-CURRENT_TIMESTAMP;
		if ($waittime <0 ) { 
		$waittime = 0; 		
		}
		}


echo "<body>".$waittime."</body>";

mysqli_close($con);

?>