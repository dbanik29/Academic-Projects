<?php
 
require('connectdb.php');

$status = "";
if(isset($_POST['new']) && $_POST['new']==1)
{
		$student_id=$_REQUEST['student_id'] ;					
		$name=$_REQUEST['name'] ;
		$course_name= $_REQUEST['course_name'] ;

//$submittedby = $_SESSION["appartment_id"];
$ins_query="insert into stu_regis (`student_id`,`name`,`course_name`) 
		 VALUES ('$student_id','$name','$course_name')"; 
mysqli_query($con,$ins_query) or die(mysql_error());
$status = "Registration done Successfully.</br></br>";
}
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registration</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body style="background-image: url(pic08.jpeg);background-position: center; background-repeat: no-repeat;background-size: cover">
<div class="form">

<div style="background-color:#F9E79F;width: 40%; height: 40%;margin-left: 350px;margin-top: 70px; color: #0000FF; font-size: bolder; font-style: italic;">
	<br>
<h1 style="margin-left:85px; color: #0000FF;"> Course Regitration</h1><br>
<form name="form" method="post" action="" style="margin-left: 65px;"> 
<input type="hidden" name="new" value="1" />
Student Id : <input type="text" name="student_id" required style="margin-left:12%;"/><br><br>
student Name : <input type="text" name="name" required style="margin-left:7%;"/><br><br>
course name : <input type="text" name="course_name" required style="margin-left:8.5%;"/><br><br>
<p><input name="submit" type="submit" value="Confirm" style="margin-left: 110px;">
<a href="register.php" name="submit" type="submit" style="margin-left: 50px; color: #0000FF">Back</a><p/>
</form>
<p style="color:#BA4A00;"><?php echo $status; ?></p>

<br /><br /><br /><br />
</div>
</div>

</body>
</html>
