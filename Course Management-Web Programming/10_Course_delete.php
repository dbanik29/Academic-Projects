<?php
         if(isset($_POST['delete'])) {
            $dbhost = 'localhost';
            $dbuser = 'root';
            $dbpass = '';
            $conn = mysql_connect($dbhost, $dbuser, $dbpass);
            
            if(! $conn ) {
               die('Could not connect: ' . mysql_error());
            }
            
            $id = $_POST['id'];
            
            $sql = "DELETE FROM course_details WHERE id = $id" ;
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
      <title>Delete Course</title>
   </head>  
   <body style="background-color: #F5CBA7;">
      <div style="width: 35%;height: 180px; margin-left: 30%;margin-top:8%;background-color:#FAD7A0;">
               <form method = "post" action = "<?php $_PHP_SELF ?>">
                  <table width = "400" border = "0" cellspacing = "1" 
                     cellpadding = "2">
                     <h1 style="font-style:italic;">Delete Record</h1>
                     <tr>
                        <td width = "100"> ID : </td>
                        <td><input name = "id" type = "text" 
                           id = "id"></td>
                     </tr>
                     
                     <tr>
                        <td width = "100"> </td>
                        <td> </td>
                     </tr>
                     
                     <tr>
                        <td width = "100"> </td>
                        <td>
                           <input style="margin-left: 20%" name = "delete" type = "submit" 
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
 
