<?php
	echo '<form action="" method="post">';
	createButton("1", "news");
	createButton("2", "about us");
	createButton("3", "profile");
	createButton("4", "clothes");
	createButton("5", "programms");
	echo '</form>';

$array1 = array();
$array2 = array();
if (isset($_POST["array1"])) {
$string = $_POST["array1"];
$array1 = explode(" ", $string);
}

if (isset($_POST["array2"])) {
$string = $_POST["array2"];
$array2 = explode(" ", $string);
}

$array = new SplFixedArray(count($array1) + count($array2));

for ($i = 0; $i < count($array1); $i++) {
	$array[$i] = $array1[$i];
}

for ($i = 0; $i < count($array2); $i++) {
	$array[count($array1) + $i] = $array2[$i];
}

for ($i = 0; $i < count($array); $i++) {
	if (is_numeric($array[$i]) && $array[$i] % 2 == 0) {
		echo $array[$i] . "<br />";
	}
}


	function createButton($name, $value){
		$color = isset($_POST["$name"])? "#A0A0A0":"#f0f0f0";
		echo '<input type="submit" name="' . "$name" . '" style="background:' . "$color" . '" value="' . "$value" . '"/>';
	}
?>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<form action="" method="post">
			<input  type="text" name="array1" />
			<br />
			<input  type="text" name="array2" />
			<br />
			<input type="submit" name=""/>
			</form>
	</body>
</html>
