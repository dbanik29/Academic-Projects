<?php
  if (isset($_POST["register"]))
  {
    $user = $_POST["username"];
    echo "welcome".$user;
  }
?>