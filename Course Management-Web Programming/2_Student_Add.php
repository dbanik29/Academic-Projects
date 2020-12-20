<?php
 
require('connectdb.php');

$status = "";
if(isset($_POST['new']) && $_POST['new']==1)
{
		$student_id=$_REQUEST['student_id'] ;					
		$name=$_REQUEST['name'] ;
		$address= $_REQUEST['address'] ;
		$department=$_REQUEST['department'] ;
		$batch=$_REQUEST['batch'] ;
		$mblNo=$_REQUEST['mblNo'] ;

//$submittedby = $_SESSION["appartment_id"];
$ins_query="insert into stu_details (`student_id`,`name`,`address`,`department`,`batch`,`mblNo`) 
		 VALUES ('$student_id','$name','$address','$department','$batch','$mblNo')"; 
mysqli_query($con,$ins_query) or die(mysql_error());
$status = "New Record Inserted Successfully.</br></br>";
}
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert Student Record</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body style="background-image: url(pic17.jpg);background-position: center; background-repeat: no-repeat;background-size: cover">
<div class="form">

<div style="background-color: #212F3D ;width: 40%; height: 50%;margin-left: 340px;margin-top: 100px; color: #2980B9; font-size: bolder; font-style: italic;">
<h1>Add New Student</h1>
<form name="form" method="post" action="" style="margin-left: 65px;"> 
<input type="hidden" name="new" value="1" />
Student Id : <input type="text" name="student_id" placeholder="Enter Student Id" required style="margin-left:4%;"/><br><br>
Name : <input type="text" name="name" placeholder="Enter Name" required style="margin-left:10%;"/><br><br>
Address : <input type="text" name="address" placeholder="Enter Address" required style="margin-left:7%;"/><br><br>
Department : <input type="text" name="department" placeholder="Enter Department" required style="margin-left:1.5%;" /><br><br>
Batch : <input type="text" name="batch" placeholder="Batch" required style="margin-left: 10%" /><br><br>
Mobile No. : <input type="text" name="mblNo" placeholder="Enter Mobile No." required style="margin-left:2%;" /><br><br>
<p><input name="submit" type="submit" value="ADD" style="margin-left: 110px;">
<a href="1_home.php" name="submit" type="submit" style="margin-left: 50px; color: #2980B9">Go Back</a><p/>
</form>
<p style="color:#F39C12  ;"><?php echo $status; ?></p>

<br /><br /><br /><br />
</div>
</div>

</body>
</html>




