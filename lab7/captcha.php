<?php
  session_start();
  $number_1 = rand(1, 30);
  $number_2 = rand(1, 30);
  $_SESSION['rand_code'] = $number_1 + $number_2;
$im = imagecreatetruecolor(120, 20);
$text_color = imagecolorallocate($im, 233, 14, 91);
$white = imagecolorallocate($im, 255, 255, 255);
imagefilledrectangle($im, 0, 0, 399, 99, $white);
imagestring($im, 1, 5, 5,  "$number_1 + $number_2", $text_color);
header('Content-Type: image/jpeg');
imagejpeg($im);
imagedestroy($im);
?>
