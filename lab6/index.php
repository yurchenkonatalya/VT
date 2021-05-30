<?php
if(isset($_GET['name']) && isset($_COOKIE[$_GET['name']])){
    setcookie($_GET['name'], null, -1);
		unset($_GET['name']);
		header("location:index.php");
	}
if(isset($_POST['submit'])){
    $cookie_name = $_POST['name'] ?? "";
    if ($cookie_name === "") {
    	exit("Необходимо ввести название cookie!");
    }

    $cookie_value = $_POST['value'] ?? "";
    if ($cookie_value === "") {
    	exit("Необходимо ввести значение cookie!");
    }

    $days = $_POST['days'] ?? "";
    if ($days === "") {
    	$days = 0;
    } elseif (!is_numeric($days)) {
    	exit("Количество дней должно быть числом!");
    }

    $hours = $_POST['hours'] ?? "";
    if ($hours === "") {
	$hours = 0;
    } elseif (!is_numeric($hours)) {
    	exit("Количество часов должно быть числом!");
    }

    $minutes = $_POST['minutes'] ?? "";
    if ($minutes === "") {
  	$minutes = 0;
  } elseif (!is_numeric($minutes)) {
    	exit("Количество минут должно быть числом!");
    }

    $seconds = $_POST['seconds'] ?? "";

    if ($seconds === "") {
    	$seconds = 0;
    } elseif (!is_numeric($seconds)) {
    	exit("Количество секунд должно быть числом!");
    }

    $SECONDS_IN_DAY = 60 * 60 * 24;
    $SECONDS_IN_HOUR = 60 * 60;
    $SECONDS_IN_MINUTE = 60;

    $time = $days * $SECONDS_IN_DAY
    	+ $hours * $SECONDS_IN_HOUR
    	+ $minutes * $SECONDS_IN_HOUR
    	+ $seconds;
    setcookie($cookie_name, $cookie_value, time() + $time);
		header("Refresh:0");
}
if (count($_COOKIE) == 0) {
	echo "<br>Список cookie в настоящее время пуст!<br>";
} else {

	echo "<br><b>Название</b> -> <b>Значение</b><br>";
	foreach ($_COOKIE as $key => $value) {
		echo '<a href="index.php?name='.$key.'">Удалить</a>  '.$key." -> ".$value."<br>";
	}
}

?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<form method="POST">
			Название cookie:<br>
				<input type="text" name="name" required /><br>
			Значение cookie:<br>
				<input type="text" name="value" required /><br>
			Время действия cookie:<br>
			Количество дней:<br>
				<input type="text" name="days"/><br>
			Количество часов:<br>
				<input type="text" name="hours"/><br>
			Количество минут:<br>
				<input type="text" name="minutes"/><br>
			Количество секунд:<br>
				<input type="text" name="seconds"/><br>
				<input name="submit" type="submit" name="button_add" value="Добавить cookie"/>
		</form>
	</body>
</html>
