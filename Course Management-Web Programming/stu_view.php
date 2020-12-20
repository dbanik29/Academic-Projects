<?php
$db_host = 'localhost'; // Nama Server
$db_user = 'root'; // User Server
$db_pass = ''; // Password Server
$db_name = 'course'; // Nama Database
 
$conn = mysqli_connect($db_host, $db_user, $db_pass, $db_name);
if (!$conn) {
    die ('Fail to connect to MySQL: ' . mysqli_connect_error());   
}
 
$sql = 'SELECT id, student_id, name, course_name
        FROM stu_regis';
         
$query = mysqli_query($conn, $sql);
 
if (!$query) {
    die ('SQL Error: ' . mysqli_error($conn));
} 

echo '<table border="1|0">
        <thead>
            <tr>
                <th>Serial</th>
                <th>Student Id</th>
                <th>Name</th>
                <th>Course</th>
            </tr>
        </thead>
        <tbody>';
         
while ($row = mysqli_fetch_array($query))
{
    echo '<tr>
            <td>'.$row['id'].'</td>
            <td>'.$row['student_id'].'</td>
            <td>'.$row['name'].'</td>
            <td>'.$row['course_name'].'</td>
        </tr>';
}
echo '
    </tbody>
</table>';
 
// Should we need to run this? read section VII
mysqli_free_result($query);
 
// Should we need to run this? read section VII
mysqli_close($conn);
