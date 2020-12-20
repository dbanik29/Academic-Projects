<?php 
require('connectdb.php');

$instructor_id=$_REQUEST['instructor_id'];
$query = "SELECT * from instructor where instructor_id='".$instructor_id."'"; 
//$query = "SELECT * from instructor where instructor_id='".$instructor_id."'";
$result = mysqli_query($con, $query) or die ( mysqli_error());
$row = mysqli_fetch_assoc($result);
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update Instructor Record</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body style="background-color: #F9E79F;>
<div class="form">
<h1 style="color: #2874A6; margin-left:85px";>Update Instructor Record</h1>
<?php
$status = "";
if(isset($_POST['new']) && $_POST['new']==1)
{
		$instructor_id=$_REQUEST['instructor_id'] ;					
		$instructor_name=$_REQUEST['instructor_name'] ;
		$address= $_REQUEST['address'] ;
		$age=$_REQUEST['age'] ;
		$email=$_REQUEST['email'] ;
		$mblNo=$_REQUEST['mblNo'] ;;
//$submittedby = $_SESSION["userinstructor_name"];
$update="update instructor set instructor_id='".$instructor_id."',instructor_name='".$instructor_name."', address='".$address."', age='".$age."', email='".$email."', mblNo='".$mblNo."' where instructor_id='".$instructor_id."'";
mysqli_query($con, $update) or die(mysqli_error());
$status = "Record Updated Successfully. </br></br><a</a>";
echo '<p style="color:#FF0000;">'.$status.'</p>';
}else {
?>
<div style="font-style: italic;font-size: 20px;">
<form name="form" method="post" action="" style="margin-left: 85px;> 
<input type="hidden" name="new" value="1" />
<input name="id" type="hidden" value="<?php echo $row['id'];?>" />
Instructor Id :<input type="text" name="instructor_id" placeholder="Enter instructor_id" required value="<?php echo $row['instructor_id'];?>"/> <br><br>
Name : <input type="text" name="instructor_name" placeholder="Enter instructor Name" required value="<?php echo $row['instructor_name'];?>" /><br><br>
Address :<input type="text" name="address" placeholder="Enter Updated address" required value="<?php echo $row['address'];?>" /><br><br>
Age : <input type="text" name="age" placeholder="Enter Age" required value="<?php echo $row['age'];?>" /><br><br>
Email :<input type="text" name="email" placeholder="Enter Email" required value="<?php echo $row['email'];?>" /><br><br>
Mobile No. :<input type="text" name="mblNo" placeholder="Enter Updated Number" required value="<?php echo $row['mblNo'];?>" /><br><br>
<p><input name="submit" type="submit" value="Update" style="margin-left: 60px" />
<a href="1_home.php" name="submit" type="submit" style="margin-left: 50px; color: #1B4F72; font-size: 15px;">Go Back</a>
</p>
</form>
<?php } ?>

</div>
</div>

</body>
</html>
