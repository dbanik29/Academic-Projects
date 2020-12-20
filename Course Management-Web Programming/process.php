<?php
		$username = $_POST['user'];
		$password = $_POST['pass'];
	//	$link = "<script>window.open('https://google.co.in')</script>";
		//$link = "<script>window.open('../Course_Mng/1_home.php')</script>";
        //echo $link;

		$username = stripcslashes($username);
		$password = stripcslashes($password);
		$username = mysql_real_escape_string($username);
		$password = mysql_real_escape_string($password);


		mysql_connect('localhost','root','');
		mysql_select_db('course');

		$result = mysql_query("select *from users where username ='$username' and password = '$password'")
		or die("failed to query database".mysql_errno());

		$row = mysql_fetch_array($result);
		
		if($row["username"] == $username && $row["password"] == $password){
		//	echo 'Login Sucess!!! Welcome'.$row["username"];
			header('location:../Course_Mng/1_home.php');
		}else{
			echo "failed to login";
		}
		?>

