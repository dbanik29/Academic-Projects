<?php
$db_host = 'localhost'; // Nama Server
$db_user = 'root'; // User Server
$db_pass = ''; // Password Server
$db_name = 'course'; // Nama Database
 
$conn = mysqli_connect($db_host, $db_user, $db_pass, $db_name);
if (!$conn) {
    die ('Fail to connect to MySQL: ' . mysqli_connect_error());   
}
 
$sql = 'SELECT id, course_code, course_name, instructor, course_fee FROM course_details';
         
$query = mysqli_query($conn, $sql);
 
if (!$query) {
    die ('SQL Error: ' . mysqli_error($conn));
} 

echo '<table border="1|0">
        <thead>
            <tr>
                <th>Serial</th>
                <th>Course Code</th>
                <th>Course Name</th>
                <th>Instructor Name</th>
                <th>course_fee</th>
            </tr>
        </thead>
        <tbody>';
         
while ($row = mysqli_fetch_array($query))
{
    echo '<tr>
            <td>'.$row['id'].'</td>
            <td>'.$row['course_code'].'</td>
            <td>'.$row['course_name'].'</td>
            <td>'.$row['instructor'].'</td>
            <td>'.$row['course_fee'].'</td>
        </tr>';
}
echo '
    </tbody>      
</table>';
 
// Should we need to run this? read section VII
mysqli_free_result($query);
 
// Should we need to run this? read section VII
mysqli_close($conn);
