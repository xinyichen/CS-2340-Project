<?php
require 'connect.inc.php';

$query="SELECT category, Sum(amount) AS subtotal FROM withdrawal 
	WHERE username = '$_GET[username]' AND effective_date >= '$_GET[start_date]' AND effective_date <= '$_GET[end_date]'
	GROUP BY category";
$result = mysqli_query($con, $query) or die("Error: ".mysqli_error($con));

if (mysqli_num_rows($result) == NULL) {
	echo "No record found";
} else {
	$total = 0;
	while ($row = mysqli_fetch_assoc($result)) { // loop n times if there are n returned rows
		$total += $row['subtotal'];
		echo 	'<category>'.$row['category'].'</category>'.
			'<subtotal>'.$row['subtotal'].'</subtotal>';
	}	
	echo 	'<category>'."Total".'</category>'.
		'<subtotal>'.$total.'</subtotal>';	
}

mysqli_close($con)

?>