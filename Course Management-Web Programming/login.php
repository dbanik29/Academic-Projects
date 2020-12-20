
<!DOCTYPE html>
<html>
<head>
	<title>Admin Login page</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body style="background-image: url(pic32.jpg); background-repeat: no-repeat;
    background-size: cover">
  <div id="frm" style="background-color:#273746; color: #AAB7B8; font-style: italic; font-weight: bold; width: 23%; height: 200px; margin-left: 33%; margin-top: 7%;">
		<form action="process.php" method="POST">
				<h1>Admin Login</h1>
				<p>
				<label>Username:</label><br>
				<input type="text" id="user" name="user" />
				</p>
				<p>
				<label>Password:  </label><br>
				<input type="password" id="pass" name="pass" />
				</p>
				<p><br>
				<input type="submit" id="btn" value="Login" a href="Course_Mng/1_home.php" target="_blank" >
				</p>
				</form>
		</div>
</body>
</html>