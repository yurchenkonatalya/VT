

<html>
<head>
    <style>
    .green{
        color: green;
    }
    .blue {
        color: blue;
    }
    .red {
        color: red;
    }
    </style>
</head>
<body>
  <?php
  if(isset($_POST['comment'])){
      $text = " ".$_POST['comment']." ";
      echo $text."<br>";
      $text = preg_replace('/([A-Z][a-z]*)/', " <span class=\"green\">$0</span> ", $text);
      $text = preg_replace('/([0-9]+[.,][0-9]{1})[0-9]*/', " <span class=\"red\">$1</span> ", $text);
      $text = preg_replace('/([^A-Za-z][0-9]+[ ])/', " <span class=\"blue\">$0</span> ", $text);
     echo $text;
  }
  ?>
    <form method="post" >
        <textarea name="comment" rows="5" cols="40"></textarea><br>
        <input type="submit" name="submit"/>
</form>
</body>
</html>
