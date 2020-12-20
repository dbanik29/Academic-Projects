<?php 
require('connectdb.php');

$course_code=$_REQUEST['course_code'];
$query = "SELECT * from course_details where course_code='".$course_code."'"; 

$result = mysqli_query($con, $query) or die ( mysqli_error());
$row = mysqli_fetch_assoc($result);
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update Course details</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body style="background-image: url(pic01.jpg);background-position: center; background-repeat: no-repeat;background-size: cover">
<div class="form">
<?php
$status = "";
if(isset($_POST['new']) && $_POST['new']==1)
{
		$course_code=$_REQUEST['course_code'] ;					
		$course_name=$_REQUEST['course_name'] ;
		$instructor=$_REQUEST['instructor'] ;
		$course_fee=$_REQUEST['course_fee'] ;;
//$submittedby = $_SESSION["usercourse_name"];
$update="update course_details set course_code='".$course_code."',course_name='".$course_name."', instructor='".$instructor."', course_fee='".$course_fee."' where course_code='".$course_code."'";
mysqli_query($con, $update) or die(mysqli_error());
$status = "Course Updated Successfully. </br></br><a</a>";
echo '<p style="color:#FF0000;">'.$status.'</p>';
}else {
?>
<div style="background-color: black ;width: 40%; height: 50%;margin-left: 340px;margin-top: 100px; color: #2980B9; font-size: bolder; font-style: italic;">
	<h1 style="color: #0000FF; margin-left:85px; margin-top: 25px; font-style: italic;">Update Course Details</h1>
<form name="form" method="post" action="" style="margin-left: 85px;> 
<input type="hidden" name="new" value="1" />
<input name="id" type="hidden" value="<?php echo $row['id'];?>" />
Course Code :<input type="text" name="course_code" placeholder="Enter course_code" required value="<?php echo $row['course_code'];?>" style="margin-left: 28px"/><br><br>
Course Title :<input type="text" name="course_name" placeholder="Enter Course Name" required value="<?php echo $row['course_name'];?>" style="margin-left: 33px" /><br><br>
Instructor Name :<input type="text" name="instructor" placeholder="Enter Updated Course instructor" required value="<?php echo $row['instructor'];?>" style="margin-left: 6px"/><br><br>
Course Fee :<input type="text" name="course_fee" placeholder="Enter Updated Course Fee" required value="<?php echo $row['course_fee'];?>" style="margin-left: 36px"/><br><br>
<p><input name="submit" type="submit" value="Update" style="margin-left: 80px"/>
<a href="1_home.php" name="submit" type="submit" style="margin-left: 50px; color: #2980B9; font-size: 15px;">Go Back</a><br></p>
</form>
<?php } ?>

<br /><br /><br /><br />
</div>
</div>

</body>
</html>
