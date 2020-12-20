import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DatabaseConnect {
	Connection connection=null;
	
	public static Connection DBConnectors(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/swift", "root","");
			
			//JOptionPane.showMessageDialog(null, "Connected");
			return connection;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
}
