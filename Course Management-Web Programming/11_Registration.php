<?php
 
require('connectdb.php');

$status = "";
if(isset($_POST['new']) && $_POST['new']==1)
{
		$student_id=$_REQUEST['student_id'] ;					
		$name=$_REQUEST['name'] ;
		$course_name= $_REQUEST['course_name'] ;
		$course_fee=$_REQUEST['course_fee'] ;
		$pay=$_REQUEST['pay'] ;

//$submittedby = $_SESSION["appartment_id"];
$ins_query="insert into registration (`student_id`,`name`,`course_name`,`course_fee`,`pay`) 
		 VALUES ('$student_id','$name','$course_name','$course_fee','$pay')"; 
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
<body style="background-image: url(pic09.jpg);background-position: center; background-repeat: no-repeat;background-size: cover">
<div class="form">

<div style="background-color: #212F3D ;width: 40%; height: 40%;margin-left: 200px;margin-top: 40px; color: #0000FF; font-size: bolder; font-style: italic;">
<h1 style="margin-left:85px; color: #0000FF;"> Course Regitration</h1><br>
<form name="form" method="post" action="" style="margin-left: 65px;"> 
<input type="hidden" name="new" value="1" />
Student Id : <input type="text" name="student_id" placeholder="Enter Student Id" required style="margin-left:12%;"/><br><br>
student Name : <input type="text" name="name" placeholder="Enter Name" required style="margin-left:7%;"/><br><br>
course name : <input type="text" name="course_name" placeholder="Enter course_name" required style="margin-left:7.5%;"/><br><br>
course_fee : <input type="text" name="course_fee" placeholder="Enter course_fee" required style="margin-left:11%;" /><br><br>
paid : <input type="text" name="pay" placeholder="paid amount" required style="margin-left: 20%" /><br><br><br>
<p><input name="submit" type="submit" value="Confirm" style="margin-left: 110px;">
<a href="1_home.php" name="submit" type="submit" style="margin-left: 50px; color: #0000FF">Go Back</a><p/>
</form>
<p style="color:#F39C12  ;"><?php echo $status; ?></p>

<br /><br /><br /><br />
</div>
</div>

</body>
</html>




