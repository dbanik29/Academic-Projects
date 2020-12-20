<!DOCTYPE html>
<html>
<head>
<style>
.btn {
    border: 2px solid black;
    background-color: black;
    color: black;
    padding: 9px 28px;
    font-size: 26px;
    cursor: pointer;
    width: 30%;
    position: ;

}

/* Green */
.success {
    border-color: #4CAF50;
    color: green;
    margin-left: 35%;
    margin-top: 9%;
}

.success:hover {
    background-color: #4CAF50;
    color: white;
}

/* Blue */
.info {
    border-color: #2196F3;
    color: dodgerblue;
    margin-left: 35%;
    margin-top: 4%;
}

.info:hover {
    background: #2196F3;
    color: white;
}

.a
{
	width: 90%;
	height: 500px;
}
</style>
</head>

<body style="background-image: url(pic04.jpg); background-repeat: no-repeat;
    background-size: cover">

	<div class="a">
	<h1 style="color: White; margin-left: 44%">Welcome</h1>
    <button class="btn success" onclick="location.href='login.php'"  type="button">
     Admin</button>
	<button class="btn info" onclick="location.href='Client/register.php'" type="button">Student</button>
	</div>
</body>
</html>