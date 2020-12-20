import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.qt.datapicker.DatePicker;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.UIManager;

public class Change extends JFrame {
	Connection connection=null;
	JLabel user_id = new JLabel("");
	
	private JPanel contentPane;
	static String Time;
	String hour,min,sec;
	int i=1;
	int j=1;
	int k=1;
	int k2=1;
	int l2=1;
	int l=1;
	int h=1;
	int s=1;
	int name=1;
	String date;
	JLabel swift_logo = new JLabel("");
	public String Customer_id;
	public String Ref;
	public String Employee_id;
	 
	    static Change frame = new Change();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	String value;
	public JTextField Amount;
	public JTextField Pay;
	public JTextField Change;
	public void invoice(String value){
		
	}
	
	public Change() {
		connection =DatabaseConnect.DBConnectors();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		date = sdf.format(new Date());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 314, 200);
		setShape(new RoundRectangle2D.Double(00, 00, 314, 200, 50, 50));
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getSize().height; //get the heigth of the frame
        int framelocationX=(dim.width-framewidth)/2; 
        int framelocationY=(dim.height-frameheigth)/2;
        this.setLocation(framelocationX,framelocationY);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					setVisible(false);
					frame.dispose(); //Destroy the JFrame object
			   }
			}
		});
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Amount = new JTextField();
		Amount.setForeground(new Color(0, 0, 51));
		Amount.setBackground(SystemColor.controlHighlight);
		Amount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Amount.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Amount.setBounds(108, 82, 146, 20);
		contentPane.add(Amount);
		Amount.setColumns(10);
		
		Pay = new JTextField();
		Pay.setForeground(new Color(0, 0, 51));
		Pay.setBackground(SystemColor.controlHighlight);
		Pay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Pay.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Pay.setColumns(10);
		Pay.setBounds(108, 113, 146, 20);
		contentPane.add(Pay);
		Pay.grabFocus();
		
		Change = new JTextField();
		Change.setForeground(new Color(0, 0, 51));
		Change.setBackground(SystemColor.controlHighlight);
		Change.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Change.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try{
						String q1="UPDATE inventory SET Quantity_in_hand=Quantity_in_hand -(SELECT Quantity FROM Retail_Details";
						String q2=" WHERE Retail_Details.Ref_ID='"+Ref+"' AND Retail_Details.Product_Code=inventory.Product_code) WHERE Product_Code in (SELECT Retail_Details.Product_Code ";
						String q3=" FROM Retail_Details WHERE Retail_Details.Product_Code=inventory.Product_code and Retail_Details.Ref_ID='"+Ref+"')";
                      
						PreparedStatement pst1=connection.prepareStatement(q1+q2+q3);
					
						pst1.execute();
						
						pst1.close();
						
						setVisible(false); //you can't see me!
						frame.dispose(); //Destroy the JFrame object
						
						Retail.frame.setVisible(false);
						Retail.frame.dispose();
						
						Message Message= new Message();
						Message.user_id.setText(user_id.getText());
						Message.setVisible(true);
						Message.Message.setText("Transaction Successfull");
						
						Message_status Message_status= new Message_status();
						Message_status.user_id.setText(user_id.getText());
						Message_status.setVisible(true);
						Message_status.Message.setText("New Sale");
						Message_status.class_name="Retail";
					 }catch (Exception e2) {
				         System.out.println("Got an exception!"); 
				         e2.printStackTrace();
				      }
			   }
				else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					setVisible(false);
					frame.dispose();
			   }
			}
		});
		Pay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					int s=(int) Double.parseDouble(Amount.getText());
					double c=Integer.parseInt(Pay.getText())-s;
					Change.setText(String.valueOf(c));
					Change.grabFocus();
					
				//JOptionPane.showMessageDialog(null, "Data Add");
				
			   }
				else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					setVisible(false);
			   }
			}
		});
		Change.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Change.setColumns(10);
		Change.setBounds(108, 141, 146, 20);
		contentPane.add(Change);
			
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(93, 11, 107, 35);
		
		contentPane.add(swift_logo);
		
		JLabel top = new JLabel("");
		top.setBackground(SystemColor.activeCaptionBorder);
		top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/top.png")));
		top.setEnabled(false);
		top.setBounds(0, 0, 350, 60);
		contentPane.add(top);
		
		JLabel Message = new JLabel("Message");
		Message.setForeground(new Color(0, 0, 51));
		Message.setFont(new Font("Tahoma", Font.BOLD, 14));
		Message.setBounds(30, 169, 246, 31);
		contentPane.add(Message);
		
		JLabel amount = new JLabel("Pay");
		amount.setForeground(new Color(0, 0, 51));
		amount.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		amount.setBounds(20, 81, 78, 22);
		contentPane.add(amount);
		
		JLabel pay = new JLabel("Receive");
		pay.setForeground(new Color(0, 0, 51));
		pay.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		pay.setBounds(20, 112, 78, 22);
		contentPane.add(pay);
		
		JLabel change = new JLabel("Change");
		change.setForeground(new Color(0, 0, 51));
		change.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		change.setBounds(20, 140, 78, 22);
		contentPane.add(change);
		
		JLabel lblTk_2 = new JLabel("Tk.");
		lblTk_2.setForeground(new Color(0, 0, 51));
		lblTk_2.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		lblTk_2.setBounds(264, 141, 29, 22);
		contentPane.add(lblTk_2);
		
		JLabel lblTk_1 = new JLabel("Tk.");
		lblTk_1.setForeground(new Color(0, 0, 51));
		lblTk_1.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		lblTk_1.setBounds(264, 113, 29, 22);
		contentPane.add(lblTk_1);
		
		JLabel lblTk = new JLabel("Tk.");
		lblTk.setForeground(new Color(0, 0, 51));
		lblTk.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		lblTk.setBounds(264, 82, 29, 22);
		contentPane.add(lblTk);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
	        
	}
}
