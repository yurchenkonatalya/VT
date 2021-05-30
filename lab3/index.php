<?php

if(isset($_POST['path'])){
    $count = scaning($_POST['path']);
    echo "Size: $count byte";
}

function scaning($dir) {
    $count = 0;
    $dirs = scandir($dir);

    unset($dirs[array_search('.', $dirs, true)]);
    unset($dirs[array_search('..', $dirs, true)]);

    if (count($dirs) < 1)
        return;

    echo '<table style="margin-left: 50px;">';
    foreach($dirs as $files){
        echo '<tr><td>' . $files;
        if(is_dir($dir . '/' . $files))
					$count += scaning($dir . '/' . $files);
				else
					$count += filesize($dir . '/' . $files);
        echo '</td></tr>';
    }
    echo '</table>';
    return $count;
}

?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    <form  method="post">
        <input type="text" name="path" placeholder="Directory"/><br><br>
        <input type="submit" value="Scan">
    </form>
  </body>
</html>
