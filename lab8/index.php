<?php
$OS = get_os($_SERVER['HTTP_USER_AGENT']);

$servername = "localhost";
$username = "root";
$password = "Nata.2013";
$dbname = "NewDB";
$mysqli = new mysqli($servername, $username, $password, $dbname);

$result = $mysqli->query("SELECT * FROM os_usage");
$shouldAdd = true;
while ($os_row = $result->fetch_assoc()) {
  if ($OS == $os_row['os_name']) {
    $amount = $os_row['os_users_quantity'] + 1;
    $mysqli->query("UPDATE os_usage SET os_users_quantity = '".$amount."' WHERE os_name = '".$OS."';");
    $shouldAdd = false;
  }
}

if ($shouldAdd) {
  echo "add";
  $mysqli->query("INSERT INTO os_usage (`os_name`, `os_users_quantity`) VALUES ('".$OS."', 1);");
}

if (($result = $mysqli->query("SELECT * FROM os_usage ORDER BY `os_users_quantity` DESC")) && $result->num_rows != 0) {
    echo "<table border='1'>";
    echo "<tr><th>OS</th><th>Users</th></tr>";
    while ($os_row = $result->fetch_assoc()) {
        echo "<tr><td>". $os_row['os_name'] ."</td><td>". $os_row['os_users_quantity'] ."</td></tr>";
    }
    echo "</table>";
} else {
    echo "<p>There's no statistics</p>";
}
$mysqli->close();

function get_os($user_agent) {
  $os = array (
    'Windows' => 'Win',
    'Open BSD'=>'OpenBSD',
    'Sun OS'=>'SunOS',
    'Linux'=>'(Linux)|(X11)',
    'Mac OS'=>'(Mac_PowerPC)|(Macintosh)',
    'QNX'=>'QNX',
    'BeOS'=>'BeOS',
    'OS/2'=>'OS/2'
  );

  foreach($os as $key=>$value) {
    if (preg_match('#'.$value.'#i', $user_agent))
      return $key;
  }
  return 'Unknown';
}
?>
