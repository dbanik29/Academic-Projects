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
import javax.swing.SwingConstants;

public class Expense_mass extends JFrame {
	Connection connection=null;
	JLabel user_id = new JLabel("");
	
	public JLabel Message = new JLabel("Message");
	
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
	String payment_no;
	String payer;
	String amount;
	String type;
	String employee;
	String status;
	JLabel swift_logo = new JLabel("");
	 JLabel edit = new JLabel("");
	JLabel cancel = new JLabel("");
	    

	    static Expense_mass frame = new Expense_mass();
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
	private final JLabel delete = new JLabel("");
	
	public Expense_mass() {
		connection =DatabaseConnect.DBConnectors();
		
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	         
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 220, 286);
		setShape(new RoundRectangle2D.Double(00, 00, 220, 286, 50, 50));
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getSize().height; //get the heigth of the frame
        int framelocationX=(dim.width-framewidth)/2; 
        int framelocationY=(dim.height-frameheigth)/2;
        this.setLocation(framelocationX,framelocationY);
		
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Message.setHorizontalAlignment(SwingConstants.CENTER);
		Message.setForeground(Color.WHITE);
		
		
		Message.setFont(new Font("Tahoma", Font.BOLD, 14));
		Message.setBounds(10, 69, 200, 31);
		contentPane.add(Message);
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(56, 11, 107, 35);
		
		contentPane.add(swift_logo);
		
		JLabel top = new JLabel("");
		top.setBackground(Color.LIGHT_GRAY);
		top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/top.png")));
		top.setEnabled(false);
		top.setBounds(0, 0, 220, 60);
		contentPane.add(top);
		
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(k%2!=0){
					edit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edit2.png")));
					
					k++;
				}
				else if(k%2==0){
					edit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edit2.png")));
					
					k++;
				}
				setVisible(false);
				frame.dispose(); //Destroy the JFrame object
				
				if(status=="Bill"){
					Pay_bill Pay_bill= new Pay_bill();
					Pay_bill.user_id.setText(user_id.getText());
					Pay_bill.setVisible(true);
					
					Pay_bill.show(date, payment_no, payer, amount, type);
					Pay_bill.title.setText("Expense Edit");
				}
				else if(status=="Expense"){
					Pay_expense Pay_expense= new Pay_expense();
					Pay_expense.user_id.setText(user_id.getText());
					Pay_expense.setVisible(true);
					
					Pay_expense.show(date, payment_no, employee, amount);
					Pay_expense.title.setText("Expense Edit");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				edit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edit2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				edit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edit1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(k%2!=0){
					edit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edit1.png")));
					
				}
				else if(k%2==0){
					edit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edit1.png")));
					
				}
			}
		});
		
		edit.setIcon(new ImageIcon(Customer_mass.class.getResource("/img/edit1.png")));
		edit.setBounds(35, 111, 150, 41);
		contentPane.add(edit);
		
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cancel.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cancel2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cancel.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cancel1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
				
				cancel.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cancel3.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				cancel.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cancel2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				cancel.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cancel1.png")));
			}
		});
		
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/delete2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/delete1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/delete3.png")));
				setVisible(false);
				frame.dispose(); //Destroy the JFrame object
			
				if(status=="Bill"){
					
					Message_status Message_status= new Message_status();
					Message_status.user_id.setText(user_id.getText());
					Message_status.setVisible(true);
					Message_status.Message.setText("Are you sure?");
					Message_status.class_name="Expense_D";
					Message_status.payment_no=payment_no;
				}
				else if(status=="Expense"){
					
					Message_status Message_status= new Message_status();
					Message_status.user_id.setText(user_id.getText());
					Message_status.setVisible(true);
					Message_status.Message.setText("Are you sure?");
					Message_status.class_name="Expense_D";
				}
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/delete2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/delete1.png")));
			}
		});
		cancel.setIcon(new ImageIcon(Customer_mass.class.getResource("/img/cancel1.png")));
		cancel.setBounds(35, 215, 150, 41);
		contentPane.add(cancel);
		delete.setIcon(new ImageIcon(Expense_mass.class.getResource("/img/delete1.png")));
		delete.setBounds(35, 163, 150, 41);
		
		contentPane.add(delete);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
	        
	}	
}