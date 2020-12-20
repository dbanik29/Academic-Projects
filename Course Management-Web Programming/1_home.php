<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #2C3E50;
    font-weight: bolder;
    font-size: 18px;
}

li {
    float: left;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: #82E0AA;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #EAFAF1;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
</head>
<body style="background-image: url(pic14.jpg); background-repeat: no-repeat;
    background-size: cover">

<ul>
  <li><a href="">Home</a></li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Student</a>
    <div class="dropdown-content">
      <a href="2_Student_Add.php" target="_blank">Add</a>
      <a href="3_Student_Update.php" target="_blank">Update</a>
      <a href="4_Student_Delete.php" target="_blank">Delete</a>
    </div>
  </li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Instructor</a>
    <div class="dropdown-content">
      <a href="5_Instructor.php" target="_blank">Add</a>
      <a href="6_Instructor_update.php" target="_blank">Update</a>
      <a href="7_Instructor_delete.php" target="_blank">Delete</a>
    </div>
  </li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Course</a>
    <div class="dropdown-content">
      <a href="8_Course_add.php" target="_blank">Course Add</a>
      <a href="9_Course_update.php" target="_blank">Course Update</a>
      <a href="10_Course_delete.php" target="_blank">Course Delete</a>
      <a href="12_Course_details.php" target="_blank">Course Details</a>
    </div>
  </li>
<li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Registration</a>
    <div class="dropdown-content">
      <a href="11_Registration.php" target="_blank">Student Registration</a>
      <a href="13_Reg_by_admin.php" target="_blank">Registration by Admin</a>
      <a href="stu_view.php" target="_blank">Registration Details</a>
    </div>
  </li>

  <li><a href="#event">Event</a></li>
  <li><a href="#reports">Reports</a></li>
</ul>

</body>
</html>
