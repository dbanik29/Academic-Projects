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

public class Invoice_mass extends JFrame {
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
	String sales_status;
	String payment_no;
	String invoice;
	String order;
	String customer;
	JLabel swift_logo = new JLabel("");
	 JLabel edit = new JLabel("");
	JLabel cancel = new JLabel("");
	    
	
	    static Invoice_mass frame = new Invoice_mass();
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
	private final JLabel return_invoice = new JLabel("");
	private final JLabel show = new JLabel("");
	
	public Invoice_mass() {
		connection =DatabaseConnect.DBConnectors();
		
		try {  
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	         
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 220, 340);
		setShape(new RoundRectangle2D.Double(00, 00, 220, 340, 50, 50));
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
				
				Invoice.frame.setVisible(false);
				Invoice.frame.dispose();
				
				Invoice_create Invoice_create= new Invoice_create();
				Invoice_create.user_id.setText(user_id.getText());
				Invoice_create.setVisible(true);
				
				Invoice_create.show(invoice);
				Invoice_create.title.setText("Invoice Edit");
				
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
		
		show.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				show.setIcon(new ImageIcon(Dashboard.class.getResource("/img/show2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				show.setIcon(new ImageIcon(Dashboard.class.getResource("/img/show1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				show.setIcon(new ImageIcon(Dashboard.class.getResource("/img/show3.png")));
				setVisible(false);
				frame.dispose(); //Destroy the JFrame object
				
				Invoice.frame.setVisible(false);
				Invoice.frame.dispose();
			
				Invoice_create Invoice_create= new Invoice_create();
				Invoice_create.user_id.setText(user_id.getText());
				Invoice_create.setVisible(true);
				
				Invoice_create.show(invoice);
				Invoice_create.Product_code.disable();
				Invoice_create.table.setEnabled(false);
				Invoice_create.confirm.setBounds(-500, -1300, 150, 41);
				Invoice_create.title.setText("Invoice Show");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				show.setIcon(new ImageIcon(Dashboard.class.getResource("/img/show2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				show.setIcon(new ImageIcon(Dashboard.class.getResource("/img/show1.png")));
			}
		});
		
		
		return_invoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return3.png")));
				try{
					String query1="UPDATE order_status SET order_status.Status='Returned' WHERE order_status.Invoice_no='"+invoice+"' ";
					
					PreparedStatement pst1=connection.prepareStatement(query1);
					
					pst1.execute();
					pst1.close();
					
					
					String q1="UPDATE inventory SET Quantity_in_hand=Quantity_in_hand +(SELECT Quantity FROM orders WHERE orders.Order_id='"+order+"' AND orders.Product_Code=inventory.Product_code) WHERE Product_Code in (SELECT orders.Product_Code ";
					String q2="  FROM orders, order_status WHERE orders.Product_Code=inventory.Product_code and orders.Order_id='"+order+"' and orders.Customer_id='"+customer+"' and order_status.Invoice_no='"+invoice+"')";
					
					PreparedStatement pst2=connection.prepareStatement(q1+q2);
					
					pst2.execute();
					pst2.close();
					
					String s3="SELECT order_status.Sales_Status FROM order_status WHERE order_status.Invoice_no='"+invoice+"' ";
					
					PreparedStatement pst3=connection.prepareStatement(s3);
					ResultSet rs3=pst3.executeQuery();
					rs3.next();
					sales_status=rs3.getString(1);
					System.out.println(sales_status);
					pst3.close();
					rs3.close();
					System.out.println(invoice);
					if(sales_status.equals("Cash")||sales_status.equals("COD P"))
					{
						System.out.println(sales_status);
						String s1="SELECT transactions.Payment_id as no FROM transactions WHERE transactions.Invoice_no='"+invoice+"' ";
						
						PreparedStatement pst=connection.prepareStatement(s1);
						ResultSet rs=pst.executeQuery();
						rs.next();
						payment_no=rs.getString("no");
						System.out.println(payment_no);
						System.out.println(invoice);
						pst.close();
						rs.close();
						String query4="delete from transactions where Payment_id='"+payment_no+"' and Invoice_no='"+invoice+"'";
						
						PreparedStatement pst4=connection.prepareStatement(query4);
						
						pst4.execute();
						pst4.close();
					}
					dispose();
					
					Message Message= new Message();
					Message.user_id.setText(user_id.getText());
					Message.setVisible(true);
					Message.Message.setText("Successfully Returned");
					Invoice.frame.user_id.setText(user_id.getText());
					Invoice.frame.refresh_table();
			}
			catch(Exception e1){
				//JOptionPane.showMessageDialog(null, "Quantity Get");
				e1.printStackTrace();
			}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return1.png")));
			}
		});
		cancel.setIcon(new ImageIcon(Customer_mass.class.getResource("/img/cancel1.png")));
		cancel.setBounds(35, 268, 150, 41);
		contentPane.add(cancel);
		return_invoice.setIcon(new ImageIcon(Invoice_mass.class.getResource("/img/return1.png")));
		return_invoice.setBounds(35, 215, 150, 41);
		
		contentPane.add(return_invoice);
		show.setIcon(new ImageIcon(Invoice_mass.class.getResource("/img/show1.png")));
		show.setBounds(35, 163, 150, 41);
		
		contentPane.add(show);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
	        
	}
}