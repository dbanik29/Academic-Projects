<?php
 
require('connectdb.php');

$status = "";
if(isset($_POST['new']) && $_POST['new']==1)
{
		$course_code=$_REQUEST['course_code'] ;					
		$course_name=$_REQUEST['course_name'] ;
		$instructor= $_REQUEST['instructor'] ;
		$course_fee=$_REQUEST['course_fee'] ;

//$submittedby = $_SESSION["appartment_id"];
$ins_query="insert into course_details (`course_code`,`course_name`,`instructor`,`course_fee`) 
		 VALUES ('$course_code','$course_name','$instructor','$course_fee')"; 
mysqli_query($con,$ins_query) or die(mysql_error());
$status = "Record Inserted Successfully.</br></br>";
}
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert Instructor Record</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body style="background-color: #808080;>
<div class="form">
<div style="background-color: #212F3D ;width: 40%; height: 60%;margin-left: 340px;margin-top: 100px; color: #1F618D; font-size: bold; font-style: italic;">
<h1>Add New Course</h1>
<form name="form" method="post" action="" style="margin-left: 75px;"> 
<input type="hidden" name="new" value="1" />
Course Code  : <input type="text" name="course_code" placeholder="Enter course code" required
style="margin-left: 22px"/><br><br>
Course Title : <input type="text" name="course_name" placeholder="Enter course title" required 
style="margin-left: 28px"/><br><br>
Instructor :<input type="text" name="instructor" placeholder="Enter Instructor Name" required 
style="margin-left: 46px"/><br><br>
Course Fee :<input type="text" name="course_fee" placeholder="Enter course_fee" required
style="margin-left: 35px" /><br><br>
<p><input name="submit" type="submit" value="ADD" style="margin-left: 110px;"/>
	<a href="1_home.php" name="submit" type="submit" style="margin-left: 50px; color: #2980B9">Go Back</a>
</form>
<p style="color:#FF0000;"><?php echo $status; ?></p>

<br /><br /><br /><br />
</div>
</div>
</body>
</html>
