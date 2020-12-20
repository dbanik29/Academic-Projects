<?php
         if(isset($_POST['delete'])) {
            $dbhost = 'localhost';
            $dbuser = 'root';
            $dbpass = '';
            $conn = mysql_connect($dbhost, $dbuser, $dbpass);
            
            if(! $conn ) {
               die('Could not connect: ' . mysql_error());
            }
            
            $student_id = $_POST['student_id'];
            
            $sql = "DELETE FROM stu_details WHERE student_id = $student_id" ;
            mysql_select_db('course');
            $retval = mysql_query( $sql, $conn );
            
            if(! $retval ) {
               die('Could not delete data: ' . mysql_error());
            }
            
            echo "Deleted data successfully\n";
            
            mysql_close($conn);
         }else {
            ?>
<!DOCTYPE html>            
<html>
   <head>
      <title>Delete Instructor Record</title>
   </head>  
   <body style="background-color: #17202A;">
      <div style="width: 30%;height: 180px; margin-left: 30%;margin-top:5%;background-color: #566573;">
               <form method = "post" action = "<?php $_PHP_SELF ?>">
                  <table width = "400" border = "0" cellspacing = "1" 
                     cellpadding = "2">
                     <h1>Delete Record</h1>
                     <tr>
                        <td width = "100">Student ID : </td>
                        <td><input name = "student_id" type = "text" 
                           id = "student_id"></td>
                     </tr>
                     
                     <tr>
                        <td width = "100"> </td>
                        <td> </td>
                     </tr>
                     
                     <tr>
                        <td width = "100"> </td>
                        <td>
                           <input name = "delete" type = "submit" 
                              id = "delete" value = "Delete">
                        </td>
                     </tr>
                     
                  </table>
               </form>
               </div>
            <?php
         }
      ?>
      
   </body>
</html>
 
