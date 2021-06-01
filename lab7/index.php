<?php
session_start();
echo '<a href="/"> exit </a> <br />';
if(isset($_POST['submit'])){
    if (($_POST["captcha"] != "") && ($_POST["captcha"] == $_SESSION["rand_code"])){
        $to = $_POST['email'];
        $message = "Name: ".$_POST['name']."\n";
        $message .= "Number: ".$_POST['phone']."\n";
        $message .= "Message: ".$_POST['message']."\n";
        require_once("PHPMailer/PHPMailerAutoload.php");
        $mail = new PHPMailer();
        $mail->isSMTP();
        $mail->SMTPAuth = true;
        $mail->SMTPSecure = 'ssl';
        $mail->Host = 'smtp.gmail.com';
        $mail->Port = '465';
        $mail->isHTML();
        $mail->Username = 'natali.yur02@gmail.com';
        $mail->Password = 'Nata.2013';
        $mail->SetFrom('natali.yur02@gmail.com');
        $mail->Body = $message;
        $mail->AddAddress($to);
        $mail->Send();
    }
}

?>
<!DOCTYPE html>
<html>
<head>
    <title>Форма обратной связи</title>
</head>
<body>
  <h2>Форма обратной связи</h2>
  <form method="post">
    <fieldset>
        <legend>Оставьте сообщение:</legend>
        Ваше имя:<br>
        <input type="text" name="name" required><br>
        E-mail:<br>
        <input type="email" name="email" required><br>
        Номер телефона:<br>
        <input type="text" name="phone" required><br>
        Сообщение:<br>
        <textarea rows="10" cols="45" name="message" required></textarea><br>
        Подтверждение отправки:<br>
        <img src="./captcha.php" alt="" width="200px" height="60px"/><br>
        <input type="text" name="captcha" required><br>
        <input type="submit" name="submit" value="Отправить сообщение">
    </fieldset>
  </form>
</body>
</html>
