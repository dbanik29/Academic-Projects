<?php
 
require('connectdb.php');

$status = "";
if(isset($_POST['new']) && $_POST['new']==1)
{
		$instructor_id=$_REQUEST['instructor_id'] ;					
		$instructor_name=$_REQUEST['instructor_name'] ;
		$address= $_REQUEST['address'] ;
		$age=$_REQUEST['age'] ;
		$email=$_REQUEST['email'] ;
		$mblNo=$_REQUEST['mblNo'] ;

//$submittedby = $_SESSION["appartment_id"];
$ins_query="insert into instructor (`instructor_id`,`instructor_name`,`address`,`age`,`email`,`mblNo`) 
		 VALUES ('$instructor_id','$instructor_name','$address','$age','$email','$mblNo')"; 
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
<body style="background-color: #145A32;>
<div class="form">
<div style="background-color: #82E0AA ;width: 40%; height: 60%;margin-left: 340px;margin-top: 100px; color: #1F618D; font-size: bold; font-style: italic;">
<h1>Add New Instructor</h1>
<form name="form" method="post" action="" style="margin-left: 75px;"> 
<input type="hidden" name="new" value="1" />
Instructor Id : <input type="text" name="instructor_id" placeholder="Enter Instructor Id" required/><br><br>
Name : <input type="text" name="instructor_name" placeholder="Enter Name" required /><br><br>
Address :<input type="text" name="address" placeholder="Enter Address" required /><br><br>
Age :<input type="text" name="age" placeholder="Enter Age" required /><br><br>
Email :<input type="text" name="email" placeholder="Enter Email" required /><br><br>
Mobile No. :<input type="text" name="mblNo" placeholder="Enter contact No" required /><br><br>
<p><input name="submit" type="submit" value="ADD" style="margin-left: 110px;"/>
	<a href="1_home.php" name="submit" type="submit" style="margin-left: 50px; color: #2980B9">Go Back</a>
</form>
<p style="color:#FF0000;"><?php echo $status; ?></p>

<br /><br /><br /><br />
</div>
</div>
</body>
</html>
