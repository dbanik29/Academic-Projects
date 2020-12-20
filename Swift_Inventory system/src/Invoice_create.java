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

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
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

public class Invoice_create extends JFrame {
	Connection connection=null;
	JLabel user_id = new JLabel("");
	
	private JPanel contentPane;
	JLabel avater = new JLabel("");
	JLabel avater_drop = new JLabel("");
	JLabel avater_drop1 = new JLabel("");
	JLabel avater_drop2 = new JLabel("");
	JPanel panel = new JPanel();
	static String Time;
	int payment_no;
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
	String fault="no";
	int faults;
	JLabel company_name = new JLabel("Javandro");
	 JLabel nav_top = new JLabel("");
	 JLabel top = new JLabel("");
	JLabel swift_logo = new JLabel("");
	String companyID="011151";
	 public JTextField Invoice_date = new JTextField();
	 public JTextField Invoice_no = new JTextField();
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
	 public JComboBox sales = new JComboBox();
	 public JComboBox shipping = new JComboBox();
	 JTextArea Shipping_address = new JTextArea();
	 String date;
	 int in_hand;
	 int row;
	 int order;
	 int invoice;
	 int order_no;
	 int Payment_id;
	 String show="no";
	 String make="no";
	 String pdf;
	   JLabel border = new JLabel("Name");
	   JLabel help = new JLabel("");
	   JLabel cross = new JLabel("");
	
	    static Invoice_create frame = new Invoice_create();
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
	public JTable table;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel cus_company = new JLabel("Company Name");
	private final JTextField Company_name = new JTextField();
	public JLabel title = new JLabel("Invoice");
	 JTable table_1 = new JTable();
	 private final JButton btnNewButton = new JButton("New button");
	 private final JLabel inventory_show = new JLabel("");
	 private final JLabel CustomerInformation = new JLabel("Customer Information");
	 private final JLabel Invoice_information = new JLabel("Invoice Information");
	 private JTextField Order_nos;
	 private JLabel shipping_address;
	 private JTextField Total_amount;
	 private final JPanel panel_2 = new JPanel();
	 private final JLabel invoice_delete = new JLabel("");
	 private final JLabel invoice_update = new JLabel("");
	   JScrollPane scrollPane_1 = new JScrollPane();
	   public JLabel confirm = new JLabel("");
	   private final JLabel mpdf = new JLabel("");
	
    public void orders(String orders_no){
    	System.out.println("dsds"+order);
    	Order_nos.setText(orders_no);
    	try{
    		System.out.println(order);
    		String s1="SELECT Orders.Customer_id";
    		String s2=" FROM orders WHERE Orders.Order_id='"+orders_no+"' ";
    		String s3=" and Orders.Status='New' or Orders.Status='Check'";

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
			String s3="and orders.Order_id='"+order+"' and orders.Customer_id='"+CustomerID.getText()+"' and (orders.Status='New' or Orders.Status='Check')";
		
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
    		String s1="SELECT Order_Status.Date,order_status.Order_id, orders.Customer_id,order_status.Sales_Status";
    		String s2=" FROM orders, order_status WHERE order_status.Invoice_no='"+invoice+"' ";
    		String s3="and order_status.Order_id=orders.Order_id GROUP by order_status.Order_id";

			PreparedStatement pst2=connection.prepareStatement(s1+s2+s3);
			ResultSet rs2=pst2.executeQuery();
			rs2.next();

			Invoice_date.setText(rs2.getString(1));
			CustomerID.setText(rs2.getString(3));
			sales.setSelectedItem(rs2.getString(4));
			order=(rs2.getInt(2));
			Order_nos.setText(String.valueOf(order));
			Invoice_no.setText(invoice);
			
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
			String s32="and orders.Order_id='"+Order_nos.getText()+"' and orders.Customer_id='"+CustomerID.getText()+"'";
			PreparedStatement pst1=connection.prepareStatement(s12+s22+s32);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();
			
			Total.setText(rs1.getString("sum"));
			Total_amount.setText(rs1.getString("sum"));
			
			pst1.close();
			rs1.close();
			show="yes";
			//JOptionPane.showMessageDialog(null, "Show");
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
    }
    
    public void make(String invoice){
    	System.out.println("dsds"+invoice);
    	try{
    		make="yes";
    		System.out.println(invoice);
    		String s1="SELECT Order_Status.Date,order_status.Order_id, orders.Customer_id";
    		String s2=" FROM orders, order_status WHERE order_status.Invoice_no='"+invoice+"' ";
    		String s3="and order_status.Order_id=orders.Order_id GROUP by order_status.Order_id";

			PreparedStatement pst2=connection.prepareStatement(s1+s2+s3);
			ResultSet rs2=pst2.executeQuery();
			rs2.next();

			
			CustomerID.setText(rs2.getString(3));
			order=(rs2.getInt(2));
			
			Order_nos.setText(String.valueOf(order));
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
			String s3="and orders.Order_id='"+Order_nos.getText()+"' and orders.Customer_id='"+CustomerID.getText()+"'";
		
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
			Total_amount.setText(rs1.getString("sum"));
			
			pst1.close();
			rs1.close();
			
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
			String s3="and orders.Order_id='"+Order_nos.getText()+"' and orders.Customer_id='"+CustomerID.getText()+"'";
		
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
    
    
	public Invoice_create() {
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
			
			String query5="SELECT max(Invoice_no) as invoice_no FROM Order_Status";
			PreparedStatement pst5=connection.prepareStatement(query5);
			ResultSet rs5=pst5.executeQuery();
			rs5.next();
			
			
			invoice=rs5.getInt("invoice_no");
			
			System.out.println("Invoice No. :"+invoice);
			pst5.close();
			rs5.close();
			
			String query6="SELECT max(Payment_id) as payment_id FROM Transactions";
			PreparedStatement pst6=connection.prepareStatement(query6);
			ResultSet rs6=pst6.executeQuery();
			rs6.next();
			
			
			Payment_id=rs6.getInt("payment_id");
			
			System.out.println(Payment_id);
			pst6.close();
			rs6.close();
			
			
		 }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		order++;
		invoice++;
		Invoice_no.setForeground(new Color(0, 0, 51));
		Invoice_no.setHorizontalAlignment(SwingConstants.RIGHT);
		Invoice_no.setText(Integer.toString(invoice));
			
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	         System.out.println(Time);
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		date = sdf.format(new Date());
		Invoice_date.setForeground(new Color(0, 0, 51));
		Invoice_date.setHorizontalAlignment(SwingConstants.RIGHT);
		Invoice_date.setText(date);
		Invoice_date.setEditable(false);
		Invoice_date.setFont(new Font("Futura Lt BT", Font.ITALIC, 18));
		
		Invoice_date.setBackground(SystemColor.control);
		Invoice_date.setBounds(150, 112, 98, 23);
		Invoice_date.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Invoice_date.setColumns(10);
		Invoice_no.setEditable(false);
		Invoice_no.setFont(new Font("Futura Lt BT", Font.ITALIC, 18));
		
		Invoice_no.setBackground(SystemColor.control);
		Invoice_no.setBounds(146, 148, 102, 23);
		Invoice_no.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Invoice_no.setColumns(10);
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
						sales.setSelectedItem(rs.getString("Preffered_payment"));
						
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
						PreparedStatement pst2=connection.prepareStatement(query2);
						ResultSet rs2=pst2.executeQuery();
						rs2.next();

						Shipping_address.setText(rs2.getString("Street")+"\n"+rs2.getString("City_Town")+"\n"+rs2.getString("State__Province")+"\n"+rs2.getString("Postal_Code"));
						
						pst2.close();
						rs2.close();
						
						String s1="SELECT (IFNULL(Sum(Unit_price*Quantity),0)-(SELECT IFNULL(sum(Amount),0) ";
						String s2="FROM transactions WHERE transactions.Customer_id='"+CustomerID.getText()+"' ";
						String s3="and (transactions.Type='Credit' or transactions.Type='Credit C' or transactions.Type='Credit O' or transactions.Type='Credit B'))-(SELECT IFNULL(sum(Return_inventory.Unit_price*Return_inventory.Quantity),0) as returns ";
						String s4="	FROM Return_inventory, inventory WHERE Return_inventory.Product_Code=inventory.Product_code and  Return_inventory.Customer_id='"+CustomerID.getText()+"')) as Balance FROM orders, order_status ";
						String s5="WHERE orders.Order_id=order_status.Order_id and order_status.Status='Ordered' and orders.Customer_id='"+CustomerID.getText()+"'";

						PreparedStatement pst3=connection.prepareStatement(s1+s2+s3+s4+s5);
						ResultSet rs3=pst3.executeQuery();
						rs3.next();
						
						Balance.setText(rs3.getString("Balance"));
						
						pst3.close();
						rs3.close();
						Product_code.grabFocus();
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
		Bill.setBounds(469, 131, 178, 86);
		Bill.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Bill.setColumns(1);
		Balance.setEditable(false);
		Balance.setForeground(new Color(0, 0, 51));
		Balance.setHorizontalAlignment(SwingConstants.RIGHT);
		Balance.setFont(new Font("Futura Lt BT", Font.BOLD | Font.ITALIC, 23));
		
		Balance.setBackground(SystemColor.control);
		Balance.setBounds(281, 130, 173, 30);
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
					      refresh_table();
						}
						catch(Exception e1){
							e1.printStackTrace();
							 
							Message Message= new Message();
							Message.setVisible(true);
							Message.Message.setText("Invalid Product Code");
						}
					
				   }
			}
		});
		Product_code.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.getSelectionModel().clearSelection();
				invoice_delete.setBounds(-126, 330, 84, 300);
				invoice_update.setBounds(-1180, 330, 84, 300);
				
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
						if(show=="no"){
						try{
							String query="insert into Orders(Order_id,Customer_id,Product_Code,Date,Unit_price,Quantity,Status)  values(?,?,?,?,?,?,?) ";
								
							PreparedStatement pst=connection.prepareStatement(query);
								
								pst.setInt(1, order);
								pst.setString(2, CustomerID.getText());
								pst.setString(3, Product_code.getText());
								pst.setString(4, Invoice_date.getText());
								pst.setString(5, Unit_price.getText());
								pst.setString(6, Quantity.getText());
								pst.setString(7, "Checked");
								
								pst.execute();
								pst.close();
								Product_code.setText("");
								SKU.setText("");
								Product_name.setText("");
								Unit_price.setText("");
								Quantity.setText("");
								Product_code.grabFocus();
								Amount.setText("");
								refresh_table();
								//JOptionPane.showMessageDialog(null, "Data Add");
							}
						catch(Exception e1){
							//JOptionPane.showMessageDialog(null, "Quantity Get");
							e1.printStackTrace();
							Message Message= new Message();
							Message.setVisible(true);
							Message.Message.setText("Sorry, Product is already taken");
							Product_code.setText("");
							SKU.setText("");
							Product_name.setText("");
							Unit_price.setText("");
							Quantity.setText("");
							Product_code.grabFocus();
							Amount.setText("");
							Product_code.grabFocus();
						}
						}
						else if(show=="yes"){
							try{
								String query="insert into Orders(Order_id,Customer_id,Product_Code,Date,Unit_price,Quantity,Status)  values(?,?,?,?,?,?,?) ";
									
								PreparedStatement pst=connection.prepareStatement(query);
									
									pst.setInt(1, order);
									pst.setString(2, CustomerID.getText());
									pst.setString(3, Product_code.getText());
									pst.setString(4, Invoice_date.getText());
									pst.setString(5, Unit_price.getText());
									pst.setString(6, Quantity.getText());
									pst.setString(7, "Checked");
									pst.execute();
									pst.close();
									
									String q1="UPDATE inventory SET Quantity_in_hand=Quantity_in_hand -(SELECT Quantity FROM orders";
									String q2=" WHERE orders.Order_id='"+order+"' AND orders.Product_Code=inventory.Product_code)WHERE Product_Code in (SELECT orders.Product_Code ";
									String q3="FROM orders WHERE orders.Product_Code=inventory.Product_code and orders.Order_id='"+order+"' and orders.Customer_id='"+CustomerID.getText()+"')";
			                      
									PreparedStatement pst1=connection.prepareStatement(q1+q2+q3);
								
									pst1.execute();
									pst1.close();
									Product_code.setText("");
									SKU.setText("");
									Product_name.setText("");
									Unit_price.setText("");
									Quantity.setText("");
									Product_code.grabFocus();
									Amount.setText("");
									refresh_table();
									//JOptionPane.showMessageDialog(null, "yes  Data Add");
								}
							catch(Exception e1){
								//JOptionPane.showMessageDialog(null, "Quantity Get");
								e1.printStackTrace();
								Message Message= new Message();
								Message.user_id.setText(user_id.getText());
								Message.setVisible(true);
								Message.Message.setText("Sorry, Product is already taken");
								Product_code.setText("");
								SKU.setText("");
								Product_name.setText("");
								Unit_price.setText("");
								Quantity.setText("");
								Product_code.grabFocus();
								Amount.setText("");
								Product_code.grabFocus();
							}
						}
					}
					
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
			avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.1.png")));
				avater_drop.setBounds(1140, -10, 160, 50);
				avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
				avater_drop1.setBounds(1140, -10, 160, 41);
				avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
				avater_drop2.setBounds(1140, -10, 160, 41);
				i=1;
				table.getSelectionModel().clearSelection();
				
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.1.png")));
				avater_drop.setBounds(1140, -10, 160, 50);
				avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
				avater_drop1.setBounds(1140, -10, 160, 41);
				avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
				avater_drop2.setBounds(1140, -10, 160, 41);
				i=1;
				
			}
		});
		contentPane.setBackground(new Color(230, 235, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		avater.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(i%2!=0){
					avater.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater2.png")));
					avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.1.png")));
					avater_drop.setBounds(1140, 58, 160, 50);
					avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
					avater_drop1.setBounds(1140, 106, 160, 41);
					avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
					avater_drop2.setBounds(1140, 147, 160, 41);
					i=2;
				}
				else if(i%2==0){
					avater.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater2.png")));
					avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.1.png")));
					avater_drop.setBounds(1140, -10, 160, 50);
					avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
					avater_drop1.setBounds(1140, -10, 160, 41);
					avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
					avater_drop2.setBounds(1140, -10, 160, 41);
					i=1;
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				avater.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				avater.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(i%2!=0){
					avater.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater1.png")));
					avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.1.png")));
					avater_drop.setBounds(1140, 58, 160, 50);
					avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
					avater_drop1.setBounds(1140, 106, 160, 41);
					avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
					avater_drop2.setBounds(1140, 147, 160, 41);
					
				}
				else if(i%2==0){
					avater.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater1.png")));
					avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.1.png")));
					avater_drop.setBounds(1140, -10, 160, 50);
					avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
					avater_drop1.setBounds(1140, -10, 160, 41);
					avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
					avater_drop2.setBounds(1140, -10, 160, 41);
					
				}
			}
		});
		avater.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater.png")));
		avater.setBounds(1240, 0, 60, 60);
		contentPane.add(avater);
		
		
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
		help.setBounds(1180, 0, 60, 60);
		contentPane.add(help);
		cross.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					cross.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cross3.png")));
					setVisible(false);
					frame.dispose();
					
					Invoice Invoice=new Invoice();
					Invoice.user_id.setText(user_id.getText());
					Invoice.setVisible(true);
					
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
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		title.setBounds(221, 17, 233, 28);
		
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
		
		avater_drop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop2.1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop3.1.png")));
				String account="";
				try{
					
					String query="SELECT Company_ID FROM Login Where Employee_id='"+user_id.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					rs.next();
					account=rs.getString(1);
					
					pst.close();
					rs.close();

					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				
				Account Account= new Account();
				Account.setVisible(true);
				Account.profile(account);
				Account.user_id.setText(user_id.getText());
			}
			@Override
			public void mousePressed(MouseEvent e) {
				avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop2.1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.1.png")));
			}
		});
		avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.1.png")));
		avater_drop.setBounds(1140, -10, 160, 50);
		contentPane.add(avater_drop);
		
		avater_drop1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop2.2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop3.2.png")));
				String company="";
				try{
					
					String query="SELECT Company_ID FROM Login Where Employee_id='"+user_id.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					rs.next();
					company=rs.getString(1);
					
					pst.close();
					rs.close();

					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				
				Profile Profile= new Profile();
				Profile.user_id.setText(user_id.getText());
				Profile.setVisible(true);
				Profile.profile(company);
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop2.2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
			}
		});
		avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
		avater_drop1.setBounds(1140, -10, 160, 41);
		contentPane.add(avater_drop1);
		
		avater_drop2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop2.3.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop3.3.png")));
				System.exit(0);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop2.3.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
			}
		});
		
		invoice_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				invoice_delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				invoice_delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				invoice_delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete3.png")));
				String value = table.getModel().getValueAt(row, 0).toString();
				System.out.println(value);
				
				invoice_delete.setBounds(-126, 330, 84, 300);
				invoice_update.setBounds(-1180, 330, 84, 300);
				
				if(show=="no"){
				try{
					
					String query1="delete from orders where Order_id='"+order+"' and Product_Code='"+value+"'";
					
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
				else if(show=="yes"){
					try{
						
						String q1="UPDATE inventory SET Quantity_in_hand = Quantity_in_hand + (SELECT Quantity FROM orders WHERE orders.Order_id='"+order+"'";
						String q2=" and orders.Product_Code='"+value+"')  WHERE Product_Code in (SELECT orders.Product_code ";
						String q3=" FROM orders  WHERE  orders.Order_id='"+order+"'  AND orders.Product_Code='"+value+"')";
                      
						PreparedStatement pst1=connection.prepareStatement(q1+q2+q3);
					
						pst1.execute();
						
						pst1.close();
						
						
						String query2="delete from orders where Order_id='"+order+"' and Product_Code='"+value+"'";
						
						PreparedStatement pst2=connection.prepareStatement(query2);
						
						pst2.execute();
						
						
						pst2.close();
						refresh_table();
						
						
						
						
						//JOptionPane.showMessageDialog(null, "yess Add");

					}
					catch(Exception e1){
						//JOptionPane.showMessageDialog(null, "Quantity Get");
					}
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				invoice_delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				invoice_delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete1.png")));
			}
		});
		
		invoice_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				invoice_update.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				invoice_update.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				invoice_update.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update3.png")));
				String value = table.getModel().getValueAt(row, 0).toString();
				System.out.println(value);
				invoice_update.setBounds(-126, 330, 84, 300);
				invoice_update.setBounds(-1180, 330, 84, 300);
				if(show=="no"){
				try{
					String s1="SELECT inventory.Product_code, inventory.SKU, inventory.Product_name,  orders.Unit_price, orders.Quantity, orders.Unit_price*orders.Quantity";
					String s2=" FROM orders, inventory WHERE orders.Product_Code=inventory.Product_code ";
					String s3="and orders.Order_id='"+order+"' and orders.Customer_id='"+CustomerID.getText()+"' and orders.Product_Code='"+value+"'";
				
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
					
					
					String query1="delete from orders where Order_id='"+order+"' and Product_Code='"+value+"'";
					
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
				else if(show=="yes"){
					try{
						String s1="SELECT inventory.Product_code, inventory.SKU, inventory.Product_name,  orders.Unit_price, orders.Quantity, orders.Unit_price*orders.Quantity";
						String s2=" FROM orders, inventory WHERE orders.Product_Code=inventory.Product_code ";
						String s3="and orders.Order_id='"+order+"' and orders.Customer_id='"+CustomerID.getText()+"' and orders.Product_Code='"+value+"'";
					
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
						
						String q1="UPDATE inventory SET Quantity_in_hand = Quantity_in_hand + (SELECT Quantity FROM orders WHERE orders.Order_id='"+order+"'";
						String q2=" and orders.Product_Code='"+value+"')  WHERE Product_Code in (SELECT orders.Product_code ";
						String q3=" FROM orders  WHERE  orders.Order_id='"+order+"'  AND orders.Product_Code='"+value+"')";
                      
						PreparedStatement pst1=connection.prepareStatement(q1+q2+q3);
					
						pst1.execute();
						
						pst1.close();
						
						
						String query2="delete from orders where Order_id='"+order+"' and Product_Code='"+value+"'";
						
						PreparedStatement pst2=connection.prepareStatement(query2);
						
						pst2.execute();
						
						
						pst2.close();
						
						
						//JOptionPane.showMessageDialog(null, "Update");
						

					}
					catch(Exception e1){
						//JOptionPane.showMessageDialog(null, "Quantity Get");
						e1.printStackTrace();
					}
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				invoice_update.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				invoice_update.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update1.png")));
			}
		});
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
				if(show=="no")
				{
					try{
						String q12="SELECT COUNT(orders.Product_Code) FROM orders  WHERE orders.Product_Code in (SELECT inventory.Product_code FROM inventory WHERE inventory.Quantity_in_hand<orders.Quantity) AND orders.Order_id='"+order+"'";
						
						PreparedStatement pst11=connection.prepareStatement(q12);
						ResultSet rs11=pst11.executeQuery();
						rs11.next();
							 faults=(rs11.getInt(1));
							System.out.println(faults);
						
						pst11.close();
						rs11.close();
				    }
					catch(Exception e1){
						//JOptionPane.showMessageDialog(null, "Quantity Get");
						e1.printStackTrace();
					}
					if(faults<1)
					{
						
					
				try{
					
						String query="insert into Order_Status(Invoice_no,Order_id,Employee_id,Status,Sales_Status, Date)  values(?,?,?,?,?,?) ";
						
						PreparedStatement pst=connection.prepareStatement(query);
						
						pst.setInt(1, invoice);
						pst.setInt(2, order);
						pst.setString(3, "dd");
						pst.setString(4, "Ordered");
						pst.setString(5, sales.getSelectedItem().toString());
						pst.setString(6, Invoice_date.getText());
						
						
						pst.execute();
						pst.close();
						
						
						String q1="UPDATE inventory SET Quantity_in_hand=Quantity_in_hand -(SELECT Quantity FROM orders";
						String q2=" WHERE orders.Order_id='"+order+"' AND orders.Product_Code=inventory.Product_code)WHERE Product_Code in (SELECT orders.Product_Code ";
						String q3="FROM orders WHERE orders.Product_Code=inventory.Product_code and orders.Order_id='"+order+"' and orders.Customer_id='"+CustomerID.getText()+"')";
                      
						PreparedStatement pst1=connection.prepareStatement(q1+q2+q3);
					
						pst1.execute();
						
						pst1.close();
						if(make=="no"){
							String q11="UPDATE orders SET Status='Checked' WHERE Order_id='"+order+"' and Customer_id='"+CustomerID.getText()+"' and (Status='New' or Status='Check')";
		                      
							PreparedStatement pst2=connection.prepareStatement(q11);
						
							pst2.execute();
							
							pst2.close();
						}
						
						
						if(sales.getSelectedItem()=="Cash"){
							String query5="insert into Transactions(Payment_id,Customer_id,Employee_id,Date,Type,Amount,Transaction_type, Invoice_no)  values(?,?,?,?,?,?,?,?) ";
							
							PreparedStatement pst5=connection.prepareStatement(query5);
							Payment_id++;
							pst5.setInt(1, Payment_id);
							pst5.setString(2, CustomerID.getText());
							pst5.setString(3, user_id.getText());
							pst5.setString(4, date);
							pst5.setString(5, "Credit C");
							pst5.setString(6, Total.getText());
							pst5.setString(7, "Cash");
							pst5.setString(8, Invoice_no.getText());
							
							pst5.execute();
							pst5.close();
							
						}
						if(sales.getSelectedItem()=="Cash"){
						Message Message= new Message();
						Message.user_id.setText(user_id.getText());
						Message.setVisible(true);
						Message.Message.setText("Invoice Successfully Created");
						Message.Message1.setText("Transaction Successfull");
						Invoice.frame.refresh_table();
						}
						else{
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Invoice Successfully Created");
							Invoice.frame.refresh_table();
						}
						//JOptionPane.showMessageDialog(null, "Data Add");
						setVisible(false);
						dispose();
						
						Message_status Message_status= new Message_status();
						Message_status.user_id.setText(user_id.getText());
						Message_status.Message.setText("Are you sure?");
						Message_status.setVisible(true);
						Message_status.class_name="Invoice";
						
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
					}
					else{
						Message Message= new Message();
						Message.user_id.setText(user_id.getText());
						Message.setVisible(true);
						Message.Message.setText("Sorry, Some Item is Limited. Check Inventory");
					}
				}
				else if(show=="yes"){
					if(sales.getSelectedItem().equals("Cash")||sales.getSelectedItem().equals("COD P")){
						try
						{
						String s111="SELECT transactions.Payment_id as no FROM transactions WHERE transactions.Invoice_no='"+Invoice_no.getText()+"' ";
						
						PreparedStatement pst11=connection.prepareStatement(s111);
						ResultSet rs11=pst11.executeQuery();
						rs11.next();
						payment_no=rs11.getInt("no");
						System.out.println(payment_no);
						System.out.println("gggggg"+Invoice_no.getText());
						pst11.close();
						rs11.close();
						
						
						String q11="UPDATE transactions SET transactions.Amount='"+Total.getText()+"' WHERE transactions.Invoice_no='"+Invoice_no.getText()+"' and transactions.Customer_id='"+CustomerID.getText()+"' and transactions.Payment_id='"+payment_no+"'";
	                      
						PreparedStatement pst2=connection.prepareStatement(q11);
					
						pst2.execute();
						
						pst2.close();
						
						if(sales.getSelectedItem()=="Cash"){
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Re-Invoice Successfully Created");
							Message.Message1.setText("Transaction Successfully Updated");
							Invoice.frame.refresh_table();
							}
							else{
								Message Message= new Message();
								Message.user_id.setText(user_id.getText());
								Message.setVisible(true);
								Message.Message.setText("Re-Invoice Successfully Created");
								Invoice.frame.refresh_table();
							}
						
						//JOptionPane.showMessageDialog(null, "Data Add");
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
						
					}
					else{
						Message Message= new Message();
						Message.user_id.setText(user_id.getText());
						Message.setVisible(true);
						Message.Message.setText("Re-Invoice Successfully Created");
						Invoice.frame.refresh_table();
					}
					dispose();
				
					Message_status Message_status= new Message_status();
					Message_status.user_id.setText(user_id.getText());
					Message_status.Message.setText("Are you sure?");
					Message_status.setVisible(true);
					Message_status.class_name="Invoice";
					
				}
				
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
		
		mpdf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mpdf.setIcon(new ImageIcon(Dashboard.class.getResource("/img/pdf2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mpdf.setIcon(new ImageIcon(Dashboard.class.getResource("/img/pdf1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				mpdf.setIcon(new ImageIcon(Dashboard.class.getResource("/img/pdf3.png")));
				Document document=new Document();
				String s=Invoice_no.getText();
				pdf=s +"Invoice.pdf";
				
					PdfWriter writer = null;
				
					try {
						writer = PdfWriter.getInstance(document, new FileOutputStream(pdf));
						
					} catch (FileNotFoundException | DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    try {
			    	
			    	document.open();
					
					 document.setPageSize(PageSize.LETTER);
					 document.addHeader("MY Invoice", "New");
					 
					 PdfPTable table3=new PdfPTable(1);
						float[] columnWidths3 = new float[] {300f};
						table3.setWidths(columnWidths3);
						table3.setTotalWidth(350f);
					 
						PdfPCell T1=new PdfPCell((new Paragraph("CUSTOMER INVOICE",FontFactory.getFont(FontFactory.HELVETICA_BOLD,18))));
						T1.setHorizontalAlignment(Element.ALIGN_CENTER);
						T1.setVerticalAlignment(Element.ALIGN_CENTER);;
						T1.setPadding(3);
						
						table3.getDefaultCell().setBorder(PdfPCell.BOTTOM |PdfPCell.TOP);
						table3.addCell(T1);
						table3.setSpacingAfter(10f);
						document.add(table3);
					 
					 Image img = Image.getInstance(Order.class.getResource("/img/logo_png.jpg"));
						
						img.scaleToFit(235.5f, 38.5f);
						img.setSpacingAfter(30f);
						img.setAlignment(1);
						document.add(img);
						 Paragraph ps5 = new Paragraph("17 Elephant Road, Dhaka-1205. \n Mobile: +88 01741 89 40 38, +88 01911 38 21 62 \n E-mail: info@javandro.com \n Website: www.javandro.com",FontFactory.getFont(FontFactory.HELVETICA,11));
						 ps5.setAlignment(1);
						 ps5.setSpacingAfter(5f);
						 document.add(ps5);
						
					 
					 
					 Paragraph ps1 = new Paragraph("Customer Information ",FontFactory.getFont(FontFactory.HELVETICA_BOLD,14));
					 ps1.setAlignment(1);
					 ps1.setSpacingAfter(5f);
					 document.add(ps1);
					
					 	PdfPTable table2=new PdfPTable(2);
						float[] columnWidths2 = new float[] {30f, 100f};
						table2.setWidths(columnWidths2);
						table2.setTotalWidth(350f);
					 
						PdfPCell C1=new PdfPCell((new Paragraph("Customer Name: ",FontFactory.getFont(FontFactory.HELVETICA_BOLD,10))));
						PdfPCell C2=new PdfPCell((new Paragraph(""+Customer_name.getText(),FontFactory.getFont(FontFactory.HELVETICA,10))));
						PdfPCell C3=new PdfPCell((new Paragraph("Compnay Name: ",FontFactory.getFont(FontFactory.HELVETICA_BOLD,10)))); 
						PdfPCell C4=new PdfPCell((new Paragraph(""+Company_name.getText(),FontFactory.getFont(FontFactory.HELVETICA,10))));
						PdfPCell C5=new PdfPCell((new Paragraph("Contact No. : ",FontFactory.getFont(FontFactory.HELVETICA_BOLD,10))));
						PdfPCell C6=new PdfPCell((new Paragraph(""+Contact_no.getText(),FontFactory.getFont(FontFactory.HELVETICA,10))));
						PdfPCell C7=new PdfPCell((new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA,10))));
						PdfPCell C8=new PdfPCell((new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA,10))));
						
						C1.setPadding(3);
						C2.setPadding(3);
						C3.setPadding(3);
						C4.setPadding(3);
						C5.setPadding(3);
						C6.setPadding(3);
						C7.setPadding(3);
						C8.setPadding(3);
						
						C1.setBorder(17);
						C2.setBorder(17);
						C3.setBorder(0);
						C4.setBorder(0);
						
						C5.setBorder(0);
						C6.setBorder(0);
						C7.setBorder(17);
						C8.setBorder(17);
						C8.setMinimumHeight(5f);
						C8.setMinimumHeight(5f);
						table2.addCell(C1);
						table2.addCell(C2);
						table2.addCell(C3);
						table2.addCell(C4);
						table2.addCell(C5);
						table2.addCell(C6);
						table2.addCell(C7);
						table2.addCell(C8);
						
						
						document.add(table2);
					 
					 	PdfPTable table1=new PdfPTable(3);
						float[] columnWidths5 = new float[] {80f, 80f,80f};
						table1.setWidths(columnWidths5);
						table1.setTotalWidth(350f);
						
						
						PdfPCell P1=new PdfPCell((new Paragraph("Billing To: \n",FontFactory.getFont(FontFactory.HELVETICA_BOLD,11)))); 
						PdfPCell P2=new PdfPCell((new Paragraph("Shipping To: \n",FontFactory.getFont(FontFactory.HELVETICA_BOLD,11)))); 
						PdfPCell P5=new PdfPCell((new Paragraph("Invoice Summary \n",FontFactory.getFont(FontFactory.HELVETICA_BOLD,11))));
						PdfPCell P3=new PdfPCell((new Paragraph(""+Bill.getText(),FontFactory.getFont(FontFactory.HELVETICA,10))));
						PdfPCell P4=new PdfPCell((new Paragraph(""+Shipping_address.getText(),FontFactory.getFont(FontFactory.HELVETICA,10))));
						PdfPCell P6=new PdfPCell((new Paragraph("Invoice Date: "+Invoice_date.getText()+"\nInvoice No.: "+Invoice_no.getText()+"\nOrder No.: "+Order_nos.getText(),FontFactory.getFont(FontFactory.HELVETICA,10))));
						PdfPCell P7=new PdfPCell((new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA,10))));
						PdfPCell P8=new PdfPCell((new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA,10))));
						PdfPCell P9=new PdfPCell((new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA,10))));
						
						P3.setPadding(7);
						P4.setPadding(7);
						P6.setPadding(7);
						
						P1.setMinimumHeight(20f);
						P2.setMinimumHeight(20f);
						P5.setMinimumHeight(20f);
						P3.setMinimumHeight(15f);
						P4.setMinimumHeight(15f);
						P6.setMinimumHeight(15f);
						
						P1.setBorder(17);
						P2.setBorder(17);
						P5.setBorder(17);
						P3.setBorder(17);
						P4.setBorder(17);
						P6.setBorder(17);
						P7.setBorder(17);
						P8.setBorder(17);
						P9.setBorder(17);
						
						table1.addCell(P1);
						table1.addCell(P2);
						table1.addCell(P5);
						table1.addCell(P3);
						table1.addCell(P4);
						table1.addCell(P6);
						table1.addCell(P7);
						table1.addCell(P8);
						table1.addCell(P9);
						
						document.add(table1);
						
						
						
					//	document.add(new Paragraph(new Date().toString()));
						 Paragraph ps2 = new Paragraph("Invoice Details ",FontFactory.getFont(FontFactory.HELVETICA_BOLD,14));
						 ps2.setAlignment(1);
						 ps2.setSpacingAfter(5f);
						 document.add(ps2);
						PdfPTable table=new PdfPTable(4);
						
				        
						float[] columnWidths = new float[] {70f, 20f, 20f, 20f};
						table.setWidths(columnWidths);
						
						table.setTotalWidth(170f);
						table.spacingBefore();
						
						PdfPCell cell1 = new PdfPCell(new Paragraph("Product Name",FontFactory.getFont(FontFactory.HELVETICA_BOLD,12)));
						cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell1.setVerticalAlignment(Element.ALIGN_CENTER);;
						cell1.setBackgroundColor(BaseColor.GRAY);
						PdfPCell cell2 = new PdfPCell(new Paragraph("Quantity",FontFactory.getFont(FontFactory.HELVETICA_BOLD,12)));
						cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell2.setVerticalAlignment(Element.ALIGN_CENTER);;
						cell2.setBackgroundColor(BaseColor.GRAY);
						PdfPCell cell3 = new PdfPCell(new Paragraph("Unit Price",FontFactory.getFont(FontFactory.HELVETICA_BOLD,12)));
						cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell3.setVerticalAlignment(Element.ALIGN_CENTER);;
						cell3.setBackgroundColor(BaseColor.GRAY);
						PdfPCell cell4 = new PdfPCell(new Paragraph("Total Price",FontFactory.getFont(FontFactory.HELVETICA_BOLD,12)));
						cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell4.setVerticalAlignment(Element.ALIGN_CENTER);;
						cell4.setBackgroundColor(BaseColor.GRAY);
						
						
						table.getDefaultCell().setBorder(PdfPCell.BOTTOM);
						
						
						table.addCell(cell1);
						table.addCell(cell2);
						table.addCell(cell3);
						table.addCell(cell4);
					//	table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
						 table.setTotalWidth(520);
						 
						   table.setLockedWidth(true);
						float[] columnWidths1 = new float[] {70f, 20f, 20f, 20f};
						table.setWidths(columnWidths1);
						
						String q1="SELECT inventory.Product_code, inventory.SKU, inventory.Product_name,  orders.Unit_price, orders.Quantity, orders.Unit_price*orders.Quantity";
						String q2=" FROM orders, inventory WHERE orders.Product_Code=inventory.Product_code ";
						String q3="and orders.Order_id='"+order+"' and orders.Customer_id='"+CustomerID.getText()+"'";
					
						PreparedStatement pst=connection.prepareStatement(q1+q2+q3);
						ResultSet rs=pst.executeQuery();
						
						while(rs.next()){
							table.addCell(new Phrase(""+rs.getString(3), FontFactory.getFont(FontFactory.HELVETICA, 11)));
							table.addCell(new Phrase(""+rs.getString(5), FontFactory.getFont(FontFactory.HELVETICA, 11)));
							table.addCell(new Phrase(""+rs.getString(4), FontFactory.getFont(FontFactory.HELVETICA, 11)));
							table.addCell(new Phrase(""+rs.getString(6), FontFactory.getFont(FontFactory.HELVETICA, 11)));
						}
						
						pst.close();
						rs.close();
						
						
						
						
						document.add(table);
						
						PdfPTable table5=new PdfPTable(2);
						
				        
						float[] columnWidths10 = new float[] {70f, 20f };
						table5.setWidths(columnWidths10);
						
						table5.setTotalWidth(170f);
						table5.spacingBefore();
						
						Paragraph ps15 = new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA_BOLD,5));
						ps15.setAlignment(1);
						ps15.setSpacingAfter(5f);
						 document.add(ps15);
						
						PdfPCell cell15 = new PdfPCell(new Paragraph("Total Amount",FontFactory.getFont(FontFactory.HELVETICA_BOLD,12)));
						cell15.setHorizontalAlignment(Element.ALIGN_RIGHT);
						cell15.setVerticalAlignment(Element.ALIGN_CENTER);;
						cell15.setBackgroundColor(BaseColor.GRAY);
						PdfPCell cell25 = new PdfPCell(new Paragraph(Total.getText(),FontFactory.getFont(FontFactory.HELVETICA_BOLD,12)));
						cell25.setHorizontalAlignment(Element.ALIGN_RIGHT);
						cell25.setVerticalAlignment(Element.ALIGN_CENTER);;
						cell25.setBackgroundColor(BaseColor.GRAY);
						
						table.getDefaultCell().setBorder(PdfPCell.BOTTOM);
						cell15.setPadding(3);
						cell25.setPadding(3);
						
						
						cell15.setBorder(17);
						cell25.setBorder(17);
						
						table5.addCell(cell15);
						table5.addCell(cell25);
						
					
						table5.setTotalWidth(520);
						 
						table5.setLockedWidth(true);
						
						document.add(table5);
						
					 	Barcode128 code128 = new Barcode128();
					    code128.setGenerateChecksum(true);
					    code128.setCode("1234554321");    
			
			    	document.add(new Paragraph(new Date().toString()));
					document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
					
					
					document.newPage();
					
					/////////////////////////next page
					 document.setPageSize(PageSize.LETTER);
					 document.addHeader("MY Invoice", "New");
					 
					 PdfPTable table32=new PdfPTable(1);
						float[] columnWidths32 = new float[] {300f};
						table32.setWidths(columnWidths32);
						table32.setTotalWidth(350f);
					 
						PdfPCell T12=new PdfPCell((new Paragraph("CALAN",FontFactory.getFont(FontFactory.HELVETICA_BOLD,18))));
						T12.setHorizontalAlignment(Element.ALIGN_CENTER);
						T12.setVerticalAlignment(Element.ALIGN_CENTER);;
						T12.setPadding(3);
						
						table32.getDefaultCell().setBorder(PdfPCell.BOTTOM |PdfPCell.TOP);
						table32.addCell(T12);
						table32.setSpacingAfter(10f);
						document.add(table32);
					 
					 Image img2 = Image.getInstance(Order.class.getResource("/img/logo_png.jpg"));
						
					 img2.scaleToFit(235.5f, 38.5f);
					 img2.setSpacingAfter(30f);
					 img2.setAlignment(1);
						document.add(img2);
						 Paragraph ps52 = new Paragraph("17 Elephant Road, Dhaka-1205. \n Mobile: +88 01741 89 40 38, +88 01911 38 21 62 \n E-mail: info@javandro.com \n Website: www.javandro.com",FontFactory.getFont(FontFactory.HELVETICA,11));
						 ps52.setAlignment(1);
						 ps52.setSpacingAfter(5f);
						 document.add(ps52);
					
						 Paragraph ps12 = new Paragraph("Customer Information ",FontFactory.getFont(FontFactory.HELVETICA_BOLD,14));
						 ps12.setAlignment(1);
						 ps12.setSpacingAfter(5f);
						 document.add(ps12);
						
						 	PdfPTable table22=new PdfPTable(2);
							float[] columnWidths22 = new float[] {30f, 100f};
							table22.setWidths(columnWidths22);
							table22.setTotalWidth(350f);
						 
							PdfPCell C12=new PdfPCell((new Paragraph("Customer Name: ",FontFactory.getFont(FontFactory.HELVETICA_BOLD,10))));
							PdfPCell C22=new PdfPCell((new Paragraph(""+Customer_name.getText(),FontFactory.getFont(FontFactory.HELVETICA,10))));
							PdfPCell C32=new PdfPCell((new Paragraph("Compnay Name: ",FontFactory.getFont(FontFactory.HELVETICA_BOLD,10)))); 
							PdfPCell C42=new PdfPCell((new Paragraph(""+Company_name.getText(),FontFactory.getFont(FontFactory.HELVETICA,10))));
							PdfPCell C52=new PdfPCell((new Paragraph("Contact No. : ",FontFactory.getFont(FontFactory.HELVETICA_BOLD,10))));
							PdfPCell C62=new PdfPCell((new Paragraph(""+Contact_no.getText(),FontFactory.getFont(FontFactory.HELVETICA,10))));
							PdfPCell C72=new PdfPCell((new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA,10))));
							PdfPCell C82=new PdfPCell((new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA,10))));
							
							C12.setPadding(3);
							C22.setPadding(3);
							C32.setPadding(3);
							C42.setPadding(3);
							C52.setPadding(3);
							C62.setPadding(3);
							C72.setPadding(3);
							C82.setPadding(3);
							
							C12.setBorder(17);
							C22.setBorder(17);
							C32.setBorder(0);
							C42.setBorder(0);
							
							C52.setBorder(0);
							C62.setBorder(0);
							C72.setBorder(17);
							C82.setBorder(17);
							C82.setMinimumHeight(5f);
							C82.setMinimumHeight(5f);
							table22.addCell(C12);
							table22.addCell(C22);
							table22.addCell(C32);
							table22.addCell(C42);
							table22.addCell(C52);
							table22.addCell(C62);
							table22.addCell(C72);
							table22.addCell(C82);
							
							document.add(table22);
					
							PdfPTable table12=new PdfPTable(3);
							float[] columnWidths52 = new float[] {80f, 80f,80f};
							table12.setWidths(columnWidths52);
							table12.setTotalWidth(350f);
							
							
							PdfPCell P12=new PdfPCell((new Paragraph("Billing To: \n",FontFactory.getFont(FontFactory.HELVETICA_BOLD,11)))); 
							PdfPCell P22=new PdfPCell((new Paragraph("Shipping To: \n",FontFactory.getFont(FontFactory.HELVETICA_BOLD,11)))); 
							PdfPCell P52=new PdfPCell((new Paragraph("Invoice Summary \n",FontFactory.getFont(FontFactory.HELVETICA_BOLD,11))));
							PdfPCell P32=new PdfPCell((new Paragraph(""+Bill.getText(),FontFactory.getFont(FontFactory.HELVETICA,10))));
							PdfPCell P42=new PdfPCell((new Paragraph(""+Shipping_address.getText(),FontFactory.getFont(FontFactory.HELVETICA,10))));
							PdfPCell P62=new PdfPCell((new Paragraph("Invoice Date: "+Invoice_date.getText()+"\nInvoice No.: "+Invoice_no.getText()+"\nOrder No.: "+Order_nos.getText(),FontFactory.getFont(FontFactory.HELVETICA,10))));
							PdfPCell P72=new PdfPCell((new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA,10))));
							PdfPCell P82=new PdfPCell((new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA,10))));
							PdfPCell P92=new PdfPCell((new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA,10))));
							
							P32.setPadding(7);
							P42.setPadding(7);
							P62.setPadding(7);
							
							P12.setMinimumHeight(20f);
							P22.setMinimumHeight(20f);
							P52.setMinimumHeight(20f);
							P32.setMinimumHeight(15f);
							P42.setMinimumHeight(15f);
							P62.setMinimumHeight(15f);
							
							P12.setBorder(17);
							P22.setBorder(17);
							P52.setBorder(17);
							P32.setBorder(17);
							P42.setBorder(17);
							P62.setBorder(17);
							P72.setBorder(17);
							P82.setBorder(17);
							P92.setBorder(17);
							
							table12.addCell(P12);
							table12.addCell(P22);
							table12.addCell(P52);
							table12.addCell(P32);
							table12.addCell(P42);
							table12.addCell(P62);
							table12.addCell(P72);
							table12.addCell(P82);
							table12.addCell(P92);
							
							document.add(table12);
							
							 Paragraph ps22 = new Paragraph("Invoice Details ",FontFactory.getFont(FontFactory.HELVETICA_BOLD,14));
							 ps22.setAlignment(1);
							 ps22.setSpacingAfter(5f);
							 document.add(ps22);
							PdfPTable table25=new PdfPTable(2);
							
					        
							float[] columnWidths25 = new float[] {70f, 20f};
							table25.setWidths(columnWidths25);
							
							table25.setTotalWidth(170f);
							table25.spacingBefore();
							
							PdfPCell cell12 = new PdfPCell(new Paragraph("Product Name",FontFactory.getFont(FontFactory.HELVETICA_BOLD,12)));
							cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
							cell12.setVerticalAlignment(Element.ALIGN_CENTER);;
							cell12.setBackgroundColor(BaseColor.GRAY);
							PdfPCell cell22 = new PdfPCell(new Paragraph("Quantity",FontFactory.getFont(FontFactory.HELVETICA_BOLD,12)));
							cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
							cell22.setVerticalAlignment(Element.ALIGN_CENTER);;
							cell22.setBackgroundColor(BaseColor.GRAY);
							
							table25.getDefaultCell().setBorder(PdfPCell.BOTTOM);
							
							
							table25.addCell(cell12);
							table25.addCell(cell22);
							
							table25.setTotalWidth(520);
							 
							table25.setLockedWidth(true);
							float[] columnWidths125 = new float[] {70f, 20f};
							table25.setWidths(columnWidths125);
							
							String q12="SELECT inventory.Product_code, inventory.SKU, inventory.Product_name,  orders.Unit_price, orders.Quantity, orders.Unit_price*orders.Quantity";
							String q22=" FROM orders, inventory WHERE orders.Product_Code=inventory.Product_code ";
							String q32="and orders.Order_id='"+order+"' and orders.Customer_id='"+CustomerID.getText()+"'";
						
							PreparedStatement pst2=connection.prepareStatement(q12+q22+q32);
							ResultSet rs2=pst2.executeQuery();
							
							while(rs2.next()){
								
								table25.addCell(new Phrase(""+rs2.getString(3), FontFactory.getFont(FontFactory.HELVETICA, 11)));
								table25.addCell(new Phrase(""+rs2.getString(5), FontFactory.getFont(FontFactory.HELVETICA, 11)));
								
							}
							
							pst2.close();
							rs2.close();
							
							document.add(table25);
							
					Barcode128 code129 = new Barcode128();
					code129.setGenerateChecksum(true);
					code129.setCode("1234554321");    
		
		    	document.add(new Paragraph(new Date().toString()));
				document.add(code129.createImageWithBarcode(writer.getDirectContent(), null, null));
					document.close();
					Message Message= new Message();
					Message.user_id.setText(user_id.getText());
					Message.setVisible(true);
					Message.Message.setText("Pdf Created");
				} catch (Exception es) {
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				mpdf.setIcon(new ImageIcon(Dashboard.class.getResource("/img/pdf2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mpdf.setIcon(new ImageIcon(Dashboard.class.getResource("/img/pdf1.png")));
			}
		});
		
		avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
		avater_drop2.setBounds(1140, -10, 160, 41);
		contentPane.add(avater_drop2);
		border.setFont(new Font("Tahoma", Font.ITALIC, 15));
		border.setForeground(SystemColor.textInactiveText);
		border.setBounds(382, -171, 72, 17);
		
		contentPane.add(border);
		contentPane.add(Invoice_date);
		contentPane.add(Invoice_no);
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
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				row=table_1.getSelectedRow();
				int co=table_1.getSelectedColumn();
				
				String code = table_1.getModel().getValueAt(row, 0).toString();
				String name = table_1.getModel().getValueAt(row, 1).toString();
				String price = table_1.getModel().getValueAt(row, 2).toString();
				Product_code.setText(code);
				Product_name.setText(name);
				Unit_price.setText(price);
				Quantity.grabFocus();
				
			}
		});
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
		
		JLabel invoice_date = new JLabel("Invoice Date");
		invoice_date.setForeground(new Color(0, 0, 51));
		invoice_date.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		invoice_date.setBounds(29, 116, 107, 14);
		contentPane.add(invoice_date);
		
		JLabel sales_status = new JLabel("Sales Status");
		sales_status.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		sales_status.setBounds(828, 641, 132, 14);
		contentPane.add(sales_status);
		
		JLabel invoice_no = new JLabel("Invoice No.");
		invoice_no.setForeground(new Color(0, 0, 51));
		invoice_no.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		invoice_no.setBounds(29, 152, 107, 14);
		contentPane.add(invoice_no);
		
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
		
		JLabel shipping_via = new JLabel("Shipping Via");
		shipping_via.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		shipping_via.setBounds(615, 641, 203, 14);
		
		contentPane.add(shipping_via);
		
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
		billing_address.setBounds(469, 106, 120, 14);
		contentPane.add(billing_address);
		
		JLabel balance = new JLabel("Balance");
		balance.setForeground(new Color(0, 0, 51));
		balance.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		balance.setBounds(281, 106, 107, 14);
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
		sales.setBackground(new Color(240, 248, 255));
		sales.setFont(new Font("Futura Lt BT", Font.PLAIN, 13));
		sales.setBounds(828, 665, 126, 20);
		contentPane.add(sales);
		sales.addItem("Cash");
		sales.addItem("Due");
		sales.addItem("COD");
		shipping.setBackground(new Color(240, 248, 255));
		
		shipping.setFont(new Font("Futura Lt BT", Font.PLAIN, 13));
		shipping.setBounds(615, 665, 203, 20);
		contentPane.add(shipping);
		shipping.addItem("S A Paribahan");
		shipping.addItem("Jononi Parsel");
		shipping.addItem("Sundarban");
		shipping.addItem("Ahamed");
		scrollPane.setBounds(122, 330, 1050, 300);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		contentPane.add(scrollPane);
		
		table = new JTable();
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
				
					invoice_delete.setBounds(20, 330, 84, 300);
					invoice_update.setBounds(1195, 330, 84, 300);
			}
			
		});
		
		
		
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
		    @Override
		    public Component getTableCellRendererComponent(JTable table,
		            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

		        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

		        
		        int rows=0;
				int total_row=table.getRowCount();
				try{
				String q12="SELECT orders.Product_Code FROM orders  WHERE orders.Product_Code in (SELECT inventory.Product_code FROM inventory WHERE inventory.Quantity_in_hand<orders.Quantity) AND orders.Order_id='"+order+"'";
				
				PreparedStatement pst11=connection.prepareStatement(q12);
				ResultSet rs11=pst11.executeQuery();
				while(rs11.next())
				{
					String code=(rs11.getString(1));
					for(rows=0; rows<total_row;rows++){
						String codes = table.getModel().getValueAt(rows, 0).toString();
						if(code.equals(codes)){
							
							 setBackground(Color.RED);
							 setForeground(new Color(230, 250, 255));   
							 fault="yes";
							
							}
						else {
				            setBackground(table.getBackground());
				            setForeground(table.getForeground());
				        }
							
						}
					}
				
				pst11.close();
				rs11.close();
		    }
			catch(Exception e1){
				//JOptionPane.showMessageDialog(null, "Quantity Get");
				e1.printStackTrace();
			}
		            
		        return this;
		    }   
		});
		
		
		table.setTableHeader(null);
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
			table_1.setBounds(855, 330, 424, 300);
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
		
		inventory_show.setIcon(new ImageIcon(Invoice_create.class.getResource("/img/inventory_show1.png")));
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
		CustomerInformation.setBounds(857, 70, 226, 18);
		contentPane.add(CustomerInformation);
		CustomerInformation.setForeground(new Color(0, 0, 51));
		CustomerInformation.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		inventory_show.setBounds(122, 641, 150, 41);
		
		contentPane.add(inventory_show);
		
		JLabel order_No = new JLabel("Order No.");
		order_No.setForeground(new Color(0, 0, 51));
		order_No.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		order_No.setBounds(29, 193, 107, 14);
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
		Order_nos.setBounds(146, 192, 102, 23);
		contentPane.add(Order_nos);
		Invoice_information.setForeground(new Color(0, 0, 51));
		Invoice_information.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		Invoice_information.setBounds(29, 71, 226, 18);
		
		contentPane.add(Invoice_information);
		
		
		Shipping_address.setForeground(new Color(0, 0, 51));
		Shipping_address.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		Shipping_address.setEditable(false);
		Shipping_address.setColumns(1);
		Shipping_address.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Shipping_address.setBackground(SystemColor.control);
		Shipping_address.setBounds(655, 131, 178, 86);
		contentPane.add(Shipping_address);
		
		shipping_address = new JLabel("Shipping Address");
		shipping_address.setForeground(new Color(0, 0, 51));
		shipping_address.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		shipping_address.setBounds(655, 106, 120, 14);
		contentPane.add(shipping_address);
		
		Total_amount = new JTextField();
		Total_amount.setEditable(false);
		Total_amount.setHorizontalAlignment(SwingConstants.RIGHT);
		Total_amount.setForeground(new Color(0, 0, 51));
		Total_amount.setFont(new Font("Futura Lt BT", Font.BOLD | Font.ITALIC, 23));
		Total_amount.setColumns(5);
		Total_amount.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Total_amount.setBackground(SystemColor.control);
		Total_amount.setBounds(281, 189, 173, 30);
		contentPane.add(Total_amount);
		
		JLabel total_amount = new JLabel("Invoice Total");
		total_amount.setForeground(new Color(0, 0, 51));
		total_amount.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		total_amount.setBounds(281, 168, 107, 14);
		contentPane.add(total_amount);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(4, 0, 3, 0, (Color) new Color(0, 0, 51)));
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(0, 95, 1300, 145);
		
		contentPane.add(panel_1);
		panel_2.setBorder(new MatteBorder(4, 0, 3, 0, (Color) new Color(0, 0, 51)));
		panel_2.setBackground(new Color(255, 255, 204));
		panel_2.setBounds(0, 60, 1300, 40);
		
		contentPane.add(panel_2);
		invoice_delete.setIcon(new ImageIcon(Invoice_create.class.getResource("/img/bdelete1.png")));
		invoice_delete.setBounds(20, -330, 84, 300);
		
		contentPane.add(invoice_delete);
		invoice_update.setIcon(new ImageIcon(Invoice_create.class.getResource("/img/update1.png")));
		invoice_update.setBounds(1195, -330, 84, 300);
		
		contentPane.add(invoice_update);
		confirm.setIcon(new ImageIcon(Invoice_create.class.getResource("/img/confirm1.png")));
		confirm.setBounds(450, 642, 150, 41);
		
		contentPane.add(confirm);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
		mpdf.setIcon(new ImageIcon(Invoice_create.class.getResource("/img/pdf1.png")));
		mpdf.setBounds(286, 643, 150, 41);
		
		contentPane.add(mpdf);
	}
	
}
