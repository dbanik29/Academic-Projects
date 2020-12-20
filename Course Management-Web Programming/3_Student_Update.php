<?php 
require('connectdb.php');

$student_id=$_REQUEST['student_id'];
$query = "SELECT * from stu_details where student_id='".$student_id."'"; 

$result = mysqli_query($con, $query) or die ( mysqli_error());
$row = mysqli_fetch_assoc($result);
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update Student Record</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body style="background-image: url(pic01.jpg);background-position: center; background-repeat: no-repeat;background-size: cover">
<div class="form">

<?php
$status = "";
if(isset($_POST['new']) && $_POST['new']==1)
{
		$student_id=$_REQUEST['student_id'] ;					
		$name=$_REQUEST['name'] ;
		$address= $_REQUEST['address'] ;
		$department=$_REQUEST['department'] ;
		$batch=$_REQUEST['batch'] ;
		$mblNo=$_REQUEST['mblNo'] ;;
//$submittedby = $_SESSION["username"];
$update="update stu_details set student_id='".$student_id."',name='".$name."', address='".$address."', department='".$department."', batch='".$batch."', mblNo='".$mblNo."' where student_id='".$student_id."'";
mysqli_query($con, $update) or die(mysqli_error());
$status = "Record Updated Successfully. </br></br><a</a>";
echo '<p style="color:#CACFD2;">'.$status.'</p>';
}else {
?>
<div style="background-color: #717D7E;width: 50%; height: 65%; margin-left: 340px;margin-top: 60px; color: #1A5276 ; font-weight:bolder; font-style: italic;">
	<h1 style="color: #F4D03F">Update Student Record</h1>
<form name="form" method="post" action="" style="margin-left: 65px;"> 
<input type="hidden" name="new" value="1" />
<input name="id" type="hidden" value="<?php echo $row['id'];?>" />
Student Id : <input type="text" name="student_id" placeholder="Enter student_id" required value="<?php echo $row['student_id'];?>"  style="margin-left:4%;"/> <br><br>
Name :<input type="text" name="name" placeholder="Enter Name" required value="<?php echo $row['name'];?>"  style="margin-left: 10%;" /><br><br>
Address :<input type="text" name="address" placeholder="Enter Updated address" required value="<?php echo $row['address'];?>"  style="margin-left:7.5%;"/><br><br>
Department :<input type="text" name="department" placeholder="Enter department" required value="<?php echo $row['department'];?>"  style="margin-left:3%;" /><br><br>
Batch :<input type="text" name="batch" placeholder="Enter batch" required value="<?php echo $row['batch'];?>"  style="margin-left:10%;"/><br><br>
Number : <input type="text" name="mblNo" placeholder="Enter Updated Number" required value="<?php echo $row['mblNo'];?>"  style="margin-left:6.5%;" /><br><br>
<p><input name="submit" type="submit" value="Update"  style="margin-left:130px;"/>
<a href="1_home.php" name="submit" type="submit" style="margin-left: 50px; color: #212F3C">Go Back</a><p/>
</p>
</form>
<?php } ?>

<br /><br /><br /><br />
</div>
</div>

</body>
</html>
