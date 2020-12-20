import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.qt.datapicker.DatePicker;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.print.attribute.AttributeSet;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class Order_create extends JFrame {
	Connection connection=null;
	
	JTextArea Shipping_address = new JTextArea();
	JLabel user_id = new JLabel("");
	
	private JPanel contentPane;
	JPanel panel = new JPanel();
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
	int count;
	JLabel company_name = new JLabel("Javandro");
	 JLabel nav_top = new JLabel("");
	 JLabel top = new JLabel("");
	JLabel swift_logo = new JLabel("");
	String companyID="011151";
	 public JTextField Order_date = new JTextField();
	 public JTextField CustomerID = new JTextField(6);
	 
	 public JTextField Email = new JTextField();
	 public JTextField Contact_no = new JTextField();
	 public JTextField Customer_name = new JTextField();
	 public JTextArea Bill = new JTextArea();
	 public JTextField Balance = new JTextField();
	 public JTextField Amount = new JTextField();
	 public JTextField Total = new JTextField();
	 
	 public JTextField Product_code = new JTextField();
	 public JTextField SKU = new JTextField();
	 public JTextField Product_name = new JTextField();
	 public JTextField Unit_price = new JTextField();
	 public JTextField Quantity = new JTextField();
	 String date;
	 int in_hand;
	 int row;
	 int order;
	 int invoice;
	 int order_no;
	 int Payment_id;
	 String show="no";
	 String pdf;
	   JLabel border = new JLabel("Name");
	   JLabel help = new JLabel("");
	   JLabel cross = new JLabel("");
	   JButton update = new JButton("Update");
	
	    static Order_create frame = new Order_create();
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
	
	private ObservingTextField dateText;
	private JTable table;
	private final JButton btnShow = new JButton("show");
	private final JButton Delete = new JButton("delete");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel cus_company = new JLabel("Company Name");
	private final JTextField Company_name = new JTextField();
	public JLabel title = new JLabel("Order");
	 JTable table_1 = new JTable();
	 private final JLabel CustomerInformation = new JLabel("Customer Information");
	 private final JLabel Order_information = new JLabel("Order Information");
	 private JTextField Order_nos;
	 private JLabel shipping_address;
	 private final JPanel panel_2 = new JPanel();
	 private JLabel order_date;
	 private final JScrollPane scrollPane_1 = new JScrollPane();
	 private final JLabel delete_row = new JLabel("");
	 private final JLabel update_row = new JLabel("");
	 public JTextField Order_amount = new JTextField();
	 private final JLabel inventory_show = new JLabel("");
	 private final JLabel confirm = new JLabel("");;
	
    public void orders(String orders_no, String date){
    	System.out.println("dsds"+order);
    	Order_nos.setText(orders_no);
    	Order_date.setText(date);
    	try{
    		System.out.println(order);
    		String s1="SELECT Orders.Customer_id";
    		String s2=" FROM orders WHERE Orders.Order_id='"+orders_no+"' ";
    		String s3=" and (Orders.Status='New' or Orders.Status='Check')";

			PreparedStatement pst2=connection.prepareStatement(s1+s2+s3);
			ResultSet rs2=pst2.executeQuery();
			rs2.next();

			
			CustomerID.setText(rs2.getString(1));
			order=Integer.parseInt(orders_no);
			
			
			pst2.close();
			rs2.close();
			
			String query="SELECT * FROM Customer_info Where Customer_id='"+CustomerID.getText()+"'";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();

			Customer_name.setText(rs.getString("Title")+" "+rs.getString("First_Name")+" "+rs.getString("Middle_Name")+" "+rs.getString("Last_Name"));
			Email.setText(rs.getString("email"));
			Contact_no.setText(rs.getString("mobile"));
			
			pst.close();
			rs.close();

			String query1="SELECT * FROM Customer_address Where Customer_id='"+CustomerID.getText()+"' and Status='Billing'";
			PreparedStatement pst1=connection.prepareStatement(query1);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();

			Bill.setText(rs1.getString("Street")+"\n"+rs1.getString("City_Town")+"\n"+rs1.getString("State__Province")+"\n"+rs1.getString("Postal_Code"));
			
			pst1.close();
			rs1.close();
			
			String query2="SELECT * FROM Customer_address Where Customer_id='"+CustomerID.getText()+"' and Status='Shipping'";
			PreparedStatement pst10=connection.prepareStatement(query2);
			ResultSet rs10=pst10.executeQuery();
			rs10.next();

			Shipping_address.setText(rs10.getString("Street")+"\n"+rs10.getString("City_Town")+"\n"+rs10.getString("State__Province")+"\n"+rs10.getString("Postal_Code"));
			
			pst10.close();
			rs10.close();

			
			String s11="SELECT (IFNULL(Sum(Unit_price*Quantity),0)-(SELECT IFNULL(sum(Amount),0) ";
			String s21=" FROM transactions WHERE transactions.Customer_id='"+CustomerID.getText()+"' ";
			String s31=" and (transactions.Type='Credit' or transactions.Type='Credit C' or transactions.Type='Credit O' or transactions.Type='Credit B'))-(SELECT IFNULL(sum(Return_inventory.Unit_price*Return_inventory.Quantity),0) as returns ";
			String s41="	FROM Return_inventory, inventory WHERE Return_inventory.Product_Code=inventory.Product_code and  Return_inventory.Customer_id='"+CustomerID.getText()+"')) as Balance FROM orders, order_status ";
			String s51=" WHERE orders.Order_id=order_status.Order_id and order_status.Status='Ordered' and orders.Customer_id='"+CustomerID.getText()+"'";

			PreparedStatement pst3=connection.prepareStatement(s11+s21+s31+s41+s51);
			ResultSet rs3=pst3.executeQuery();
			rs3.next();
			
			Balance.setText(rs3.getString("Balance"));
			
			
			pst3.close();
			rs3.close();
			
			}
			catch(Exception e1){
				
				//JOptionPane.showMessageDialog(null, "Customer ID");
				e1.printStackTrace();
			}
    	try{
			String s1="SELECT inventory.Product_code, inventory.SKU, inventory.Product_name,  orders.Unit_price, orders.Quantity, orders.Unit_price*orders.Quantity";
			String s2=" FROM orders, inventory WHERE orders.Product_Code=inventory.Product_code ";
			String s3="and orders.Order_id='"+Order_nos.getText()+"' and orders.Customer_id='"+CustomerID.getText()+"' and (orders.Status='New' or orders.Status='Check')";
		
			PreparedStatement pst=connection.prepareStatement(s1+s2+s3);
			ResultSet rs=pst.executeQuery();
			
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setRowHeight(30);
			TableColumnModel column=table.getColumnModel();
			
			column.getColumn(0).setPreferredWidth(132);
			column.getColumn(1).setPreferredWidth(146);
			column.getColumn(2).setPreferredWidth(422);
			column.getColumn(3).setPreferredWidth(96);
			column.getColumn(4).setPreferredWidth(90);
			column.getColumn(5).setPreferredWidth(114);
			
			pst.close();
			rs.close();

			String s12="SELECT sum(orders.Unit_price*orders.Quantity) as sum";
			String s22=" FROM orders, inventory WHERE orders.Product_Code=inventory.Product_code ";
			String s32="and orders.Order_id='"+Order_nos.getText()+"' and orders.Customer_id='"+CustomerID.getText()+"'";
			PreparedStatement pst1=connection.prepareStatement(s12+s22+s32);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();
			
			Total.setText(rs1.getString("sum"));
			
			
			pst1.close();
			rs1.close();
			
			//JOptionPane.showMessageDialog(null, "Show");
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
    }
    
    public void show(String invoice){
    	System.out.println("dsds"+invoice);
    	try{
    		System.out.println(invoice);
    		String s1="SELECT Order_Status.Date,order_status.Order_id, orders.Customer_id";
    		String s2=" FROM orders, order_status WHERE order_status.Invoice_no='"+invoice+"' ";
    		String s3="and order_status.Order_id=orders.Order_id GROUP by order_status.Order_id";

			PreparedStatement pst2=connection.prepareStatement(s1+s2+s3);
			ResultSet rs2=pst2.executeQuery();
			rs2.next();

			Order_date.setText(rs2.getString(1));
			CustomerID.setText(rs2.getString(3));
			order=(rs2.getInt(2));
			
			
			pst2.close();
			rs2.close();
			
			String query="SELECT * FROM Customer_info Where Customer_id='"+CustomerID.getText()+"'";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();

			Customer_name.setText(rs.getString("Title")+" "+rs.getString("First_Name")+" "+rs.getString("Middle_Name")+" "+rs.getString("Last_Name"));
			Email.setText(rs.getString("email"));
			Contact_no.setText(rs.getString("mobile"));
			
			pst.close();
			rs.close();

			
		
			String query1="SELECT * FROM Customer_address Where Customer_id='"+CustomerID.getText()+"' and Status='Billing'";
			PreparedStatement pst1=connection.prepareStatement(query1);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();

			Bill.setText(rs1.getString("Street")+" "+rs1.getString("City_Town")+" "+rs1.getString("State__Province")+" "+rs1.getString("Postal_Code"));
			
			pst1.close();
			rs1.close();

			
			String s11="SELECT (IFNULL(Sum(Unit_price*Quantity),0)-(SELECT IFNULL(sum(Amount),0) ";
			String s21="FROM transactions WHERE transactions.Customer_id='"+CustomerID.getText()+"' ";
			String s31="and transactions.Type='Debit')) as Balance FROM orders, order_status ";
			String s41="WHERE orders.Order_id=order_status.Order_id and order_status.Status='Ordered' and orders.Customer_id='"+CustomerID.getText()+"'";

			PreparedStatement pst3=connection.prepareStatement(s11+s21+s31+s41);
			ResultSet rs3=pst3.executeQuery();
			rs3.next();
			
			Balance.setText(rs3.getString("Balance"));
			
			
			pst3.close();
			rs3.close();
			
			}
			catch(Exception e1){
				
				//JOptionPane.showMessageDialog(null, "Customer ID");
				e1.printStackTrace();
			}
    	try{
			String s1="SELECT inventory.Product_code, inventory.SKU, inventory.Product_name,  orders.Unit_price, orders.Quantity, orders.Unit_price*orders.Quantity";
			String s2=" FROM orders, inventory WHERE orders.Product_Code=inventory.Product_code ";
			String s3="and orders.Order_id='"+order+"' and orders.Customer_id='"+CustomerID.getText()+"'";
		
			PreparedStatement pst=connection.prepareStatement(s1+s2+s3);
			ResultSet rs=pst.executeQuery();
			
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setRowHeight(30);
			TableColumnModel column=table.getColumnModel();
			
			column.getColumn(0).setPreferredWidth(132);
			column.getColumn(1).setPreferredWidth(146);
			column.getColumn(2).setPreferredWidth(422);
			column.getColumn(3).setPreferredWidth(96);
			column.getColumn(4).setPreferredWidth(90);
			column.getColumn(5).setPreferredWidth(114);
			
			pst.close();
			rs.close();

			String s12="SELECT sum(orders.Unit_price*orders.Quantity) as sum";
			String s22=" FROM orders, inventory WHERE orders.Product_Code=inventory.Product_code ";
			String s32="and orders.Order_id='"+order+"' and orders.Customer_id='"+CustomerID.getText()+"'";
			PreparedStatement pst1=connection.prepareStatement(s12+s22+s32);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();
			
			Total.setText(rs1.getString("sum"));
			Order_amount.setText(rs1.getString("sum"));
			
			pst1.close();
			rs1.close();
			show="yes";
			//JOptionPane.showMessageDialog(null, "Show");
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
    }
    
    public void refresh_table(){
    	try{
			String s1="SELECT inventory.Product_code, inventory.SKU, inventory.Product_name,  orders.Unit_price, orders.Quantity, orders.Unit_price*orders.Quantity";
			String s2=" FROM orders, inventory WHERE orders.Product_Code=inventory.Product_code ";
			String s3="and orders.Order_id='"+order+"' and orders.Customer_id='"+CustomerID.getText()+"'";
		
			PreparedStatement pst=connection.prepareStatement(s1+s2+s3);
			ResultSet rs=pst.executeQuery();
			
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setRowHeight(30);
			TableColumnModel column=table.getColumnModel();
			
			column.getColumn(0).setPreferredWidth(132);
			column.getColumn(1).setPreferredWidth(146);
			column.getColumn(2).setPreferredWidth(422);
			column.getColumn(3).setPreferredWidth(96);
			column.getColumn(4).setPreferredWidth(90);
			column.getColumn(5).setPreferredWidth(114);
			
			pst.close();
			rs.close();
			String s12="SELECT sum(orders.Unit_price*orders.Quantity) as sum";
			String s22=" FROM orders, inventory WHERE orders.Product_Code=inventory.Product_code ";
			String s32="and orders.Order_id='"+order+"' and orders.Customer_id='"+CustomerID.getText()+"'";
			PreparedStatement pst1=connection.prepareStatement(s12+s22+s32);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();

			
			Total.setText(rs1.getString("sum"));
			Order_amount.setText(rs1.getString("sum"));
			
			pst1.close();
			rs1.close();
			//JOptionPane.showMessageDialog(null, "Show");
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
    }
    
    
	public Order_create() {
		connection =DatabaseConnect.DBConnectors();
		try{
			String query4="SELECT max(Order_id) as order_no FROM Orders";
			PreparedStatement pst4=connection.prepareStatement(query4);
			ResultSet rs4=pst4.executeQuery();
			rs4.next();
			
			
			order=rs4.getInt("order_no");
			System.out.println(order);
			pst4.close();
			rs4.close();
			
			
		 }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		order++;
		invoice++;
			
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	         System.out.println(Time);
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		date = sdf.format(new Date());
		Order_date.setForeground(new Color(0, 0, 51));
		Order_date.setHorizontalAlignment(SwingConstants.RIGHT);
		Order_date.setText(date);
		Order_date.setEditable(false);
		Order_date.setFont(new Font("Futura Lt BT", Font.ITALIC, 18));
		
		Order_date.setBackground(SystemColor.control);
		Order_date.setBounds(150, 117, 107, 23);
		Order_date.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Order_date.setColumns(10);
		CustomerID.setForeground(new Color(0, 0, 51));
		CustomerID.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent arg0) {
					if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					if(CustomerID.getText().length()==5){
					try{
						String query="SELECT * FROM Customer_info Where Customer_id='"+CustomerID.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						rs.next();

						Customer_name.setText(rs.getString("Title")+" "+rs.getString("First_Name")+" "+rs.getString("Middle_Name")+" "+rs.getString("Last_Name"));
						Email.setText(rs.getString("email"));
						Contact_no.setText(rs.getString("mobile"));
						
						
						pst.close();
						rs.close();

						
					
						String query1="SELECT * FROM Customer_address Where Customer_id='"+CustomerID.getText()+"' and Status='Billing'";
						PreparedStatement pst1=connection.prepareStatement(query1);
						ResultSet rs1=pst1.executeQuery();
						rs1.next();

						Bill.setText(rs1.getString("Street")+"\n"+rs1.getString("City_Town")+"\n"+rs1.getString("State__Province")+"\n"+rs1.getString("Postal_Code"));
						
						pst1.close();
						rs1.close();

						
						String s1="SELECT (IFNULL(Sum(Unit_price*Quantity),0)-(SELECT IFNULL(sum(Amount),0) ";
						String s2="FROM transactions WHERE transactions.Customer_id='"+CustomerID.getText()+"' ";
						String s3="and (transactions.Type='Credit' or transactions.Type='Credit C' or transactions.Type='Credit O' or transactions.Type='Credit B'))-(SELECT IFNULL(sum(Return_inventory.Unit_price*Return_inventory.Quantity),0) as returns ";
						String s4="	FROM Return_inventory, inventory WHERE Return_inventory.Product_Code=inventory.Product_code and  Return_inventory.Customer_id='"+CustomerID.getText()+"')) as Balance FROM orders, order_status ";
						String s5="WHERE orders.Order_id=order_status.Order_id and order_status.Status='Ordered' and orders.Customer_id='"+CustomerID.getText()+"'";

						PreparedStatement pst2=connection.prepareStatement(s1+s2+s3+s4+s5);
						ResultSet rs2=pst2.executeQuery();
						rs2.next();
						
						Balance.setText(rs2.getString("Balance"));
						
						pst2.close();
						rs2.close();
						
						}
						catch(Exception e1){
							
							//JOptionPane.showMessageDialog(null, "Incorrect Customer ID");
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Incorrect Customer ID");
						}
					}
					else{
						//JOptionPane.showMessageDialog(null, "Invalid Customer ID");
						Message Message= new Message();
						Message.user_id.setText(user_id.getText());
						Message.setVisible(true);
						Message.Message.setText("Invalid Customer ID");
					}
					
				   }
			}
		});
		CustomerID.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		CustomerID.setBackground(SystemColor.control);
		CustomerID.setBounds(855, 134, 84, 23);
		CustomerID.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		CustomerID.setColumns(10);
		Email.setForeground(new Color(0, 0, 51));
		Email.setEditable(false);
		Email.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Email.setBackground(SystemColor.control);
		Email.setBounds(855, 194, 254, 23);
		Email.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Email.setColumns(10);
		Contact_no.setForeground(new Color(0, 0, 51));
		Contact_no.setEditable(false);
		Contact_no.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Contact_no.setBackground(SystemColor.control);
		Contact_no.setBounds(1119, 194, 160, 23);
		Contact_no.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Contact_no.setColumns(10);
		Customer_name.setForeground(new Color(0, 0, 51));
		Customer_name.setEditable(false);
		Customer_name.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Customer_name.setBackground(SystemColor.control);
		Customer_name.setBounds(949, 134, 160, 23);
		Customer_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Customer_name.setColumns(10);
		Bill.setForeground(new Color(0, 0, 51));
		Bill.setEditable(false);
		Bill.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Bill.setBackground(SystemColor.control);
		Bill.setBounds(464, 142, 178, 86);
		Bill.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Bill.setColumns(1);
		Balance.setEditable(false);
		Balance.setForeground(new Color(0, 0, 51));
		Balance.setHorizontalAlignment(SwingConstants.RIGHT);
		Balance.setFont(new Font("Futura Lt BT", Font.BOLD | Font.ITALIC, 25));
		
		Balance.setBackground(SystemColor.control);
		Balance.setBounds(281, 133, 173, 30);
		Balance.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Balance.setColumns(5);
		Amount.setEditable(false);
		Amount.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Amount.setBackground(new Color(230, 235, 255));
		Amount.setBounds(1058, 292, 114, 23);
		Amount.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		Amount.setColumns(10);
		Amount.setHorizontalAlignment(SwingConstants.RIGHT);
		Total.setEditable(false);
		Total.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Total.setBackground(new Color(230, 235, 255));
		Total.setBounds(1058, 641, 114, 23);
		Total.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		Total.setColumns(10);
		Total.setHorizontalAlignment(SwingConstants.RIGHT);
		Product_code.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					try{
						String query="SELECT * FROM Inventory Where Product_code='"+Product_code.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						rs.next();
						
						Product_name.setText(rs.getString("Product_name"));
						SKU.setText(rs.getString("SKU"));
						Unit_price.setText(rs.getString("Sales_Rate"));
						in_hand=Integer.parseInt((rs.getString("Quantity_in_hand")));
						pst.close();
						rs.close();
						Quantity.grabFocus();
						
						}
						catch(Exception e1){
							e1.printStackTrace();
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Invalid Product Code");
						}
					
				      
				      refresh_table();
				   }
			}
		});
		Product_code.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.getSelectionModel().clearSelection();
				Delete.setBounds(-126, 578, 90, 30);
				update.setBounds(-1180, 344, 90, 30);
			}
		});
		Product_code.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Product_code.setBackground(new Color(230, 235, 255));
		Product_code.setBounds(122, 292, 132, 23);
		Product_code.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		Product_code.setColumns(10);
		SKU.setEditable(false);
		SKU.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		SKU.setBackground(new Color(230, 235, 255));
		SKU.setBounds(264, 292, 146, 23);
		SKU.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		SKU.setColumns(10);
		Product_name.setEditable(false);
		Product_name.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Product_name.setBackground(new Color(230, 235, 255));
		Product_name.setBounds(420, 292, 422, 23);
		Product_name.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		Product_name.setColumns(10);
		Unit_price.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Unit_price.setBackground(new Color(230, 235, 255));
		Unit_price.setBounds(852, 292, 96, 23);
		Unit_price.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		Unit_price.setColumns(10);
		Quantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try{
						String query="SELECT * FROM Inventory Where Product_code='"+Product_code.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						rs.next();
						//System.out.println(rs.getMetaData().toString());
						
						Product_name.setText(rs.getString("Product_name"));
						SKU.setText(rs.getString("SKU"));
						Unit_price.setText(rs.getString("Sales_Rate"));
						in_hand=Integer.parseInt((rs.getString("Quantity_in_hand")));
						pst.close();
						rs.close();
						}
						catch(Exception e1){
							e1.printStackTrace();
						}
					if(in_hand<Integer.parseInt(Quantity.getText())){
						
						Message Message= new Message();
						Message.user_id.setText(user_id.getText());
						Message.setVisible(true);
						Message.Message.setText("Stock Qunatity in Hand: "+in_hand);
					}
					else if(Integer.parseInt(Quantity.getText())==0){
						Message Message= new Message();
						Message.user_id.setText(user_id.getText());
						Message.setVisible(true);
						Message.Message.setText("Sorry Quantity will not zero");
					}
					else if(in_hand>=Integer.parseInt(Quantity.getText())){
						Amount.setText(String.valueOf(Double.parseDouble(Unit_price.getText())*Integer.parseInt(Quantity.getText())));
						
						try{
							String query="insert into Orders(Order_id,Customer_id,Product_Code,Date,Unit_price,Quantity,Status)  values(?,?,?,?,?,?,?) ";
								
							PreparedStatement pst=connection.prepareStatement(query);
								
								pst.setInt(1, order);
								pst.setString(2, CustomerID.getText());
								pst.setString(3, Product_code.getText());
								pst.setString(4, Order_date.getText());
								pst.setString(5, Unit_price.getText());
								pst.setString(6, Quantity.getText());
								pst.setString(7, "Check");
								
								pst.execute();
								pst.close();
								
								//JOptionPane.showMessageDialog(null, "Data Add");
							}
						catch(Exception e1){
							//JOptionPane.showMessageDialog(null, "Quantity Get");
							e1.printStackTrace();
							
						}
						
					}
					Product_code.setText("");
					SKU.setText("");
					Product_name.setText("");
					Unit_price.setText("");
					Quantity.setText("");
					Product_code.grabFocus();
					Amount.setText("");
					refresh_table();
				}
			}
		});
		Quantity.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Quantity.setBackground(new Color(230, 235, 255));
		Quantity.setBounds(958, 292, 90, 23);
		Quantity.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		Quantity.setColumns(10);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setUndecorated(true);
	    
		setBounds(-100, -100, 1300, 750);
		setShape(new RoundRectangle2D.Double(00, 00, 1300, 750, 50, 0));
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getSize().height; //get the heigth of the frame
        int framelocationX=(dim.width-framewidth)/2; 
        int framelocationY=(dim.height-frameheigth)/2;
        this.setLocation(framelocationX,framelocationY);
		
		contentPane = new JPanel();
		
		contentPane.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
	
				table.getSelectionModel().clearSelection();
				
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
			
				i=1;
				
			}
		});
		contentPane.setBackground(new Color(230, 235, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(h%2!=0){
					help.setIcon(new ImageIcon(Dashboard.class.getResource("/img/help2.png")));
					
					h++;
				}
				else if(h%2==0){
					help.setIcon(new ImageIcon(Dashboard.class.getResource("/img/help2.png")));
					
					h++;
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				help.setIcon(new ImageIcon(Dashboard.class.getResource("/img/help2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				help.setIcon(new ImageIcon(Dashboard.class.getResource("/img/help.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(h%2!=0){
					help.setIcon(new ImageIcon(Dashboard.class.getResource("/img/help.png")));
					
					
				}
				else if(h%2==0){
					help.setIcon(new ImageIcon(Dashboard.class.getResource("/img/help.png")));
					
					
				}
			}
		});
		help.setIcon(new ImageIcon(Dashboard.class.getResource("/img/help.png")));
		help.setBounds(1240, 0, 60, 60);
		contentPane.add(help);
		cross.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					cross.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cross3.png")));
					setVisible(false);
					dispose();
				
					Order Order= new Order();
					Order.user_id.setText(user_id.getText());
					Order.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				cross.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cross3.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cross.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cross1.png")));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(s%2!=0){
					cross.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cross1.png")));
					
				}
				else if(s%2==0){
					cross.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cross1.png")));
					
				}
			}
		});
		confirm.setIcon(new ImageIcon(Order_create.class.getResource("/img/confirm1.png")));
		confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				confirm.setIcon(new ImageIcon(Dashboard.class.getResource("/img/confirm2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				confirm.setIcon(new ImageIcon(Dashboard.class.getResource("/img/confirm1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				confirm.setIcon(new ImageIcon(Dashboard.class.getResource("/img/confirm3.png")));
				Message_status Message_status= new Message_status();
				Message_status.user_id.setText(user_id.getText());
				Message_status.Message.setText("Are you sure?");
				Message_status.setVisible(true);
				Message_status.class_name="Order";
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				confirm.setIcon(new ImageIcon(Dashboard.class.getResource("/img/confirm2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				confirm.setIcon(new ImageIcon(Dashboard.class.getResource("/img/confirm1.png")));
			}
		});
		delete_row.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				delete_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				delete_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				delete_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete3.png")));
				String value = table.getModel().getValueAt(row, 0).toString();
				System.out.println(value);
				
				delete_row.setBounds(-126, 330, 84, 300);
				delete_row.setBounds(-1180, 330, 84, 300);
				
				try{
					String query1="delete from orders where Order_id='"+Order_nos.getText()+"' and Product_Code='"+value+"'";
					
					PreparedStatement pst1=connection.prepareStatement(query1);
					
					pst1.execute();
					pst1.close();
					refresh_table();
					
					//JOptionPane.showMessageDialog(null, "Data Add");
				}
				catch(Exception e1){
					//JOptionPane.showMessageDialog(null, "Quantity Get");
				}
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				delete_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				delete_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete1.png")));
			}
		});
		
		update_row.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				update_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				update_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				update_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update3.png")));
				String value = table.getModel().getValueAt(row, 0).toString();
				System.out.println(value);
				update_row.setBounds(-126, 330, 84, 300);
				update_row.setBounds(-1180, 330, 84, 300);
				try{
					String s1="SELECT inventory.Product_code, inventory.SKU, inventory.Product_name,  orders.Unit_price, orders.Quantity, orders.Unit_price*orders.Quantity";
					String s2=" FROM orders, inventory WHERE orders.Product_Code=inventory.Product_code ";
					String s3="and orders.Order_id='"+Order_nos.getText()+"' and orders.Customer_id='"+CustomerID.getText()+"' and orders.Product_Code='"+value+"'";
				
					PreparedStatement pst=connection.prepareStatement(s1+s2+s3);
					ResultSet rs=pst.executeQuery();
					rs.next();

					Product_code.setText(rs.getString(1));
					SKU.setText(rs.getString(2));
					Product_name.setText(rs.getString(3));
					Unit_price.setText(rs.getString(4));
					Quantity.setText(rs.getString(5));
					Amount.setText(rs.getString(6));
					
					pst.close();
					rs.close();
					Quantity.grabFocus();
					String query1="delete from orders where Order_id='"+Order_nos.getText()+"' and Product_Code='"+value+"'";
					
					PreparedStatement pst1=connection.prepareStatement(query1);
					
					pst1.execute();
					pst1.close();
					//JOptionPane.showMessageDialog(null, "Update");
				}
				catch(Exception e1){
					//JOptionPane.showMessageDialog(null, "Quantity Get");
					e1.printStackTrace();
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				update_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				update_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update1.png")));
			}
		});
		
		inventory_show.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(s==0){
					panel.setBounds(855, 330, 455, 300);
					s=1;
				}
				else{
					panel.setBounds(-855, 330, 455, 300);
					s=0;
				}
			}
		});
		
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		title.setBounds(221, 17, 191, 28);
		
		contentPane.add(title);
		cross.setIcon(new ImageIcon(Invoice_create.class.getResource("/img/cross1.png")));
		cross.setBounds(0, 0, 60, 60);
		contentPane.add(cross);
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(77, 12, 107, 35);
		
		contentPane.add(swift_logo);
		top.setIcon(new ImageIcon(Invoice_create.class.getResource("/img/top.png")));
		
		top.setEnabled(false);
		top.setBounds(200, 0, 1049, 60);
		contentPane.add(top);
		nav_top.setBackground(new Color(245, 245, 220));
		nav_top.setForeground(new Color(210, 105, 30));
		nav_top.setIcon(new ImageIcon(Invoice_create.class.getResource("/img/inv_nav_top.png")));
		nav_top.setBounds(0, 0, 1300, 60);
		
		contentPane.add(nav_top);
		company_name.setForeground(new Color(255, 255, 255));
		company_name.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		company_name.setBounds(307, 9, 132, 35);
		
		contentPane.add(company_name);
		
		
		border.setFont(new Font("Tahoma", Font.ITALIC, 15));
		border.setForeground(SystemColor.textInactiveText);
		border.setBounds(382, -171, 72, 17);
		
		contentPane.add(border);
		contentPane.add(Order_date);
		contentPane.add(CustomerID);
		contentPane.add(Email);
		contentPane.add(Contact_no);
		contentPane.add(Customer_name);
		contentPane.add(Bill);
		contentPane.add(Balance);
		contentPane.add(Amount);
		contentPane.add(Total);
		contentPane.add(Product_code);
		contentPane.add(SKU);
		contentPane.add(Product_name);
		contentPane.add(Unit_price);
		contentPane.add(Quantity);
		
		panel.setBounds(855, 330, 455, 300);
		contentPane.add(panel);
		
		panel.add(scrollPane_1);
		scrollPane_1.setBounds(855, 330, 424, 300);
		scrollPane_1.setViewportView(table_1);
		table_1.setFillsViewportHeight(true);
		table_1.setDefaultEditor(Object.class, null);
		table_1.setRowSelectionAllowed(true);
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setFont(new Font("Eras Medium ITC", Font.PLAIN, 13));
		
		table_1.setBackground(new Color(230, 250, 155));
		
		table_1.getTableHeader().setUI(null);
		Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		
		scrollPane_1.setBorder(emptyBorder);
		
		scrollPane_1.setBackground(new Color(230, 250, 155));
		
		
		order_date = new JLabel("Order Date");
		order_date.setForeground(new Color(0, 0, 51));
		order_date.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		order_date.setBounds(29, 121, 107, 14);
		contentPane.add(order_date);
		
		JLabel customerId = new JLabel("Customer ID");
		customerId.setForeground(new Color(0, 0, 51));
		customerId.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		customerId.setBounds(855, 112, 120, 14);
		contentPane.add(customerId);
		
		JLabel email = new JLabel("Email");
		email.setForeground(new Color(0, 0, 51));
		email.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		email.setBounds(855, 171, 46, 14);
		contentPane.add(email);
		
		JLabel contact_no = new JLabel("Contact No.");
		contact_no.setForeground(new Color(0, 0, 51));
		contact_no.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		contact_no.setBounds(1116, 171, 96, 14);
		contentPane.add(contact_no);
		
		JLabel customer_name = new JLabel("Customer Name");
		customer_name.setForeground(new Color(0, 0, 51));
		customer_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		customer_name.setBounds(949, 112, 132, 14);
		contentPane.add(customer_name);
		
		JLabel billing_address = new JLabel("Billing Address");
		billing_address.setForeground(new Color(0, 0, 51));
		billing_address.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		billing_address.setBounds(464, 112, 120, 14);
		contentPane.add(billing_address);
		
		JLabel balance = new JLabel("Balance");
		balance.setForeground(new Color(0, 0, 51));
		balance.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		balance.setBounds(281, 112, 107, 14);
		contentPane.add(balance);
		
		JLabel amount = new JLabel("Amount");
		amount.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		amount.setBounds(1058, 268, 100, 14);
		contentPane.add(amount);
		
		JLabel total = new JLabel("Total");
		total.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		total.setBounds(988, 645, 60, 14);
		contentPane.add(total);
		
		
		JLabel product_code = new JLabel("Product Code");
		product_code.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		product_code.setBounds(124, 268, 112, 14);
		contentPane.add(product_code);
		
		JLabel sku = new JLabel("SKU");
		sku.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		sku.setBounds(264, 268, 90, 14);
		contentPane.add(sku);
		
		JLabel product_name = new JLabel("Product Name");
		product_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		product_name.setBounds(420, 268, 149, 14);
		contentPane.add(product_name);
		
		JLabel unit_price = new JLabel("Unit Price");
		unit_price.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		unit_price.setBounds(852, 268, 96, 14);
		contentPane.add(unit_price);
		
		JLabel quantity = new JLabel("Quantity");
		quantity.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		quantity.setBounds(958, 268, 96, 14);
		contentPane.add(quantity);
		scrollPane.setBounds(122, 330, 1050, 300);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		
		table.setFillsViewportHeight(true);
		table.setDefaultEditor(Object.class, null);
		table.setRowSelectionAllowed(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Eras Medium ITC", Font.PLAIN, 13));
		
		table.setBackground(new Color(230, 250, 255));
		
		table.getTableHeader().setUI(null);
		Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		
		scrollPane.setBorder(emptyBorder2);
		
		scrollPane.setBackground(new Color(230, 250, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row=table.getSelectedRow();
				
				delete_row.setBounds(20, 330, 84, 300);
				update_row.setBounds(1195, 330, 84, 300);
		
			}
			
		});
		table.setTableHeader(null);
		
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value = table.getModel().getValueAt(row, 0).toString();
				System.out.println(value);
				
				Delete.setBounds(-126, 578, 90, 30);
				update.setBounds(-1180, 344, 90, 30);
				
				try{
					String query1="delete from orders where Order_id='"+Order_nos.getText()+"' and Product_Code='"+value+"'";
					
					PreparedStatement pst1=connection.prepareStatement(query1);
					
					pst1.execute();
					pst1.close();
					refresh_table();
					
					//JOptionPane.showMessageDialog(null, "Data Add");
				}
				catch(Exception e1){
					//JOptionPane.showMessageDialog(null, "Quantity Get");
				}
			}
		});
		Delete.setBounds(-126, 472, 90, 30);
		
		contentPane.add(Delete);
		
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = table.getModel().getValueAt(row, 0).toString();
				System.out.println(value);
				Delete.setBounds(-126, 578, 90, 30);
				update.setBounds(-1180, 344, 90, 30);
				
				try{
					String s1="SELECT inventory.Product_code, inventory.SKU, inventory.Product_name,  orders.Unit_price, orders.Quantity, orders.Unit_price*orders.Quantity";
					String s2=" FROM orders, inventory WHERE orders.Product_Code=inventory.Product_code ";
					String s3="and orders.Order_id='"+Order_nos.getText()+"' and orders.Customer_id='"+CustomerID.getText()+"' and orders.Product_Code='"+value+"'";
				
					PreparedStatement pst=connection.prepareStatement(s1+s2+s3);
					ResultSet rs=pst.executeQuery();
					rs.next();

					Product_code.setText(rs.getString(1));
					SKU.setText(rs.getString(2));
					Product_name.setText(rs.getString(3));
					Unit_price.setText(rs.getString(4));
					Quantity.setText(rs.getString(5));
					Amount.setText(rs.getString(6));
					
					pst.close();
					rs.close();
					Quantity.grabFocus();
					String query1="delete from orders where Order_id='"+Order_nos.getText()+"' and Product_Code='"+value+"'";
					
					PreparedStatement pst1=connection.prepareStatement(query1);
					
					pst1.execute();
					pst1.close();
					//JOptionPane.showMessageDialog(null, "Update");
				}
				catch(Exception e1){
					//JOptionPane.showMessageDialog(null, "Quantity Get");
					e1.printStackTrace();
				}
			}
		});
		update.setBounds(-1180, 344, 89, 30);
		contentPane.add(update);
		
		
		Order_amount.setHorizontalAlignment(SwingConstants.RIGHT);
		Order_amount.setForeground(new Color(0, 0, 51));
		Order_amount.setFont(new Font("Futura Lt BT", Font.BOLD | Font.ITALIC, 25));
		Order_amount.setEditable(false);
		Order_amount.setColumns(5);
		Order_amount.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Order_amount.setBackground(SystemColor.menu);
		Order_amount.setBounds(281, 195, 173, 30);
		contentPane.add(Order_amount);
		
		JLabel order_amount = new JLabel("Amount");
		order_amount.setForeground(new Color(0, 0, 51));
		order_amount.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		order_amount.setBounds(281, 174, 107, 14);
		contentPane.add(order_amount);
		
		
		cus_company.setForeground(new Color(0, 0, 51));
		cus_company.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		cus_company.setBounds(1119, 112, 142, 14);
		
		contentPane.add(cus_company);
		Company_name.setForeground(new Color(0, 0, 51));
		Company_name.setEditable(false);
		Company_name.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		Company_name.setColumns(10);
		Company_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Company_name.setBackground(SystemColor.control);
		Company_name.setBounds(1119, 134, 160, 23);
		
		contentPane.add(Company_name);
		
		try{
			
			String q1="SELECT inventory.Product_code,inventory.Product_name, inventory.Quantity_in_hand,inventory.Sales_Rate FROM inventory"; 
			 
			PreparedStatement pst=connection.prepareStatement(q1);
			ResultSet rs=pst.executeQuery();
			
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
			table_1.setRowHeight(30);
			TableColumnModel column=table_1.getColumnModel();
			column.getColumn(0).setPreferredWidth(50);
			column.getColumn(1).setPreferredWidth(200);
			column.getColumn(2).setPreferredWidth(40);
			column.getColumn(3).setPreferredWidth(50);
		
			pst.close();
			rs.close();
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		CustomerInformation.setBounds(857, 70, 226, 18);
		contentPane.add(CustomerInformation);
		CustomerInformation.setForeground(new Color(0, 0, 51));
		CustomerInformation.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		
		JLabel order_No = new JLabel("Order No.");
		order_No.setForeground(new Color(0, 0, 51));
		order_No.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		order_No.setBounds(29, 186, 107, 14);
		contentPane.add(order_No);
		
		Order_nos = new JTextField();
		
		Order_nos.setText(String.valueOf(order));
		Order_nos.setHorizontalAlignment(SwingConstants.RIGHT);
		Order_nos.setForeground(new Color(0, 0, 51));
		Order_nos.setFont(new Font("Futura Lt BT", Font.ITALIC, 18));
		Order_nos.setEditable(false);
		Order_nos.setColumns(10);
		Order_nos.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Order_nos.setBackground(SystemColor.control);
		Order_nos.setBounds(146, 182, 111, 23);
		contentPane.add(Order_nos);
		Order_information.setForeground(new Color(0, 0, 51));
		Order_information.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		Order_information.setBounds(29, 71, 226, 18);
		
		contentPane.add(Order_information);
		
		
		Shipping_address.setForeground(new Color(0, 0, 51));
		Shipping_address.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		Shipping_address.setEditable(false);
		Shipping_address.setColumns(1);
		Shipping_address.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Shipping_address.setBackground(SystemColor.control);
		Shipping_address.setBounds(650, 142, 178, 86);
		contentPane.add(Shipping_address);
		
		shipping_address = new JLabel("Shipping Address");
		shipping_address.setForeground(new Color(0, 0, 51));
		shipping_address.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		shipping_address.setBounds(650, 112, 120, 14);
		contentPane.add(shipping_address);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(4, 0, 3, 0, (Color) new Color(0, 0, 51)));
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(0, 95, 1300, 145);
		
		contentPane.add(panel_1);
		panel_2.setBorder(new MatteBorder(4, 0, 3, 0, (Color) new Color(0, 0, 51)));
		panel_2.setBackground(new Color(255, 255, 204));
		panel_2.setBounds(0, 60, 1300, 40);
		
		contentPane.add(panel_2);
		delete_row.setIcon(new ImageIcon(Order_create.class.getResource("/img/bdelete1.png")));
		delete_row.setBounds(-200, 330, 84, 300);
		
		contentPane.add(delete_row);
		update_row.setIcon(new ImageIcon(Order_create.class.getResource("/img/update1.png")));
		update_row.setBounds(-1195, 330, 84, 300);
		
		contentPane.add(update_row);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
		inventory_show.setIcon(new ImageIcon(Order_create.class.getResource("/img/inventory_show1.png")));
		inventory_show.setBounds(122, 641, 150, 41);
		
		contentPane.add(inventory_show);
		confirm.setBounds(281, 641, 150, 41);
		
		contentPane.add(confirm);
	}
}