import java.sql.*;
	import javax.swing.*;

public class DBConnector {
	
	
		
		Connection connection=null;
		
		public static Connection DBConnectors(){
			
			try{
				Class.forName("org.mysql.JDBC").newInstance();
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajaxdata", "root","");
				
				JOptionPane.showMessageDialog(null, "Connected");
				return connection;
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
				System.out.println(e);
				return null;
			}
			
		}
	}


