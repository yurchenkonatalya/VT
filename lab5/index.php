<!DOCTYPE HTML>
<html>
<body>
<form method="post">
Enter number:<br>
<input type="text" name="count" required><br>
<input type="submit">
</form>
</body>
</html>

<?php
$servername = "localhost";
$username = "root";
$password = "eliseybg7855824";
$dbname = "NewDB";

    if(isset($_POST['count'])){
        if(intval($_POST['count']) > 0){
            $MySQL = mysqli_connect($servername, $username, $password, $dbname);
            if (!$MySQL) {
                die("connection failed" . mysqli_connect_error());
            }
            $SQL = "SELECT DISTINCT `name`, `surname` FROM `users` ORDER BY RAND() LIMIT ".intval($_POST['count']);
            $request = mysqli_query($MySQL, $SQL);
            while($data = mysqli_fetch_assoc($request)){
                echo $data['name']." ".$data['surname']."<br>";
            }
            mysqli_close($MySQL);
        } else {
            echo "You need > 0 nums";
        }
    }

    echo '<a href="/"> exit </a> <br />';
    ?>
