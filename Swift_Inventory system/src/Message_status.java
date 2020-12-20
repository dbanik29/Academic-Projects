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

public class Message_status extends JFrame {
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
	String invoice;
	String supplier;
	String order;
	String customer;
	String code;
	JLabel swift_logo = new JLabel("");
	String class_name;
	String payment_no;
	String adjust;
	String pcode;
	String order_no;
	String suppliers;
	String employee;
	String company;
	 JLabel yes = new JLabel("");
	    
	/**
	 * Launch the application.
	 */
	    static Message_status frame = new Message_status();
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
	private final JLabel no = new JLabel("");
	
	public Message_status() {
		connection =DatabaseConnect.DBConnectors();
		
		try { 
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	         
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 220, 230);
		setShape(new RoundRectangle2D.Double(00, 00, 220, 230, 50, 50));
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
			
				
			}
		});
		
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
		
		
		
		
		yes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(k%2!=0){
					yes.setIcon(new ImageIcon(Dashboard.class.getResource("/img/yes2.png")));
					
					k++;
				}
				else if(k%2==0){
					yes.setIcon(new ImageIcon(Dashboard.class.getResource("/img/yes2.png")));
					
					k++;
				}
				
				setVisible(false);
				frame.dispose(); //Destroy the JFrame object
				
				if(class_name=="Retail")
				{
				Retail Retail= new Retail();
				Retail.user_id.setText(user_id.getText());
				Retail.setVisible(true);
				
				
				}
				else if(class_name=="Payment")
				{
					Payment_receive Payment_receive= new Payment_receive();
					Payment_receive.user_id.setText(user_id.getText());
					Payment_receive.setVisible(true);
					
					
				}
				else if(class_name=="Bill"){
					Pay_bill Pay_bill= new Pay_bill();
					Pay_bill.user_id.setText(user_id.getText());
					Pay_bill.setVisible(true);
					
				}
				else if(class_name=="Create_bill"){
					Bill_create Bill_create= new Bill_create();
					Bill_create.user_id.setText(user_id.getText());
					Bill_create.title.setText("Add Bill");
					Bill_create.setVisible(true);
					
				}
				else if(class_name=="Expense"){
					Pay_expense Pay_expense= new Pay_expense();
					Pay_expense.user_id.setText(user_id.getText());
					Pay_expense.setVisible(true);
					
				}
				else if(class_name=="Expense_D"){
					try{
						String query2="delete from Transactions where Payment_id='"+payment_no+"' ";
						
						PreparedStatement pst2=connection.prepareStatement(query2);
						
						pst2.execute();
						pst2.close();
						JOptionPane.showMessageDialog(null, "Update");
						Message Message= new Message();
						Message.user_id.setText(user_id.getText());
						Message.setVisible(true);
						Message.Message.setText("Transaction Successfully Delete");
						Expenses Expenses= new Expenses();
						Expenses.user_id.setText(user_id.getText());
						Expenses.refresh_table();
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Quantity Get");
						e1.printStackTrace();
					}
				}
					else if(class_name=="Inventory"){
						try{
							String query2="delete from Inventory where Product_code='"+code+"' ";
							
							PreparedStatement pst2=connection.prepareStatement(query2);
							
							pst2.execute();
							pst2.close();
							JOptionPane.showMessageDialog(null, "Update");
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Inventory Successfully Delete");
							Inventory Inventory= new Inventory();
							Inventory.user_id.setText(user_id.getText());
							Inventory.refresh_table();
						}
						
						
						catch(Exception e1){
							JOptionPane.showMessageDialog(null, "Quantity Get");
							e1.printStackTrace();
						}
					}
						else if(class_name=="Adjust"){
							try{
								
								String query1="delete from inventory_adjust where Adjust_no='"+adjust+"' and Product_Code='"+pcode+"'";
								
								PreparedStatement pst1=connection.prepareStatement(query1);
								
								pst1.execute();
								pst1.close();
								
								
								String q1=" UPDATE inventory SET inventory.Purchasing_Cost=(SELECT (cost.Fixed_rent+cost.Fixed_utilites+cost.Fixed_equipment+cost.Variable_direct_labor+cost.Variable_utilites+cost.Variable_materiales)/ SUM(inventory_adjust.Change_quantity) FROM cost, "; 
								String q2=" inventory_adjust WHERE  inventory_adjust.Product_code=cost.Product_code AND inventory.Product_code=inventory_adjust.Product_code) "; 
								
							
									PreparedStatement pst2=connection.prepareStatement(q1+q2);
								
									pst2.execute();
									pst2.close();
									
									JOptionPane.showMessageDialog(null, "edit");
									
								JOptionPane.showMessageDialog(null, "Update");
								Message Message= new Message();
								Message.user_id.setText(user_id.getText());
								Message.setVisible(true);
								Message.Message.setText("Adjust Successfully Delete");
								Inventory_adjust_edit Inventory_adjust_edit= new Inventory_adjust_edit();
								Inventory_adjust_edit.user_id.setText(user_id.getText());
								Inventory_adjust_edit.refresh_table();
							}
							
							
							catch(Exception e1){
								JOptionPane.showMessageDialog(null, "Quantity Get");
								e1.printStackTrace();
							}
				}
						else if(class_name=="Return"){
							Return_inventory_edit Return_inventory_edit= new Return_inventory_edit();
							Return_inventory_edit.user_id.setText(user_id.getText());
							Return_inventory_edit.setVisible(true);
						}
						else if(class_name=="Cost_D"){
								try{
								
								String query1="delete from cost where Product_Code='"+code+"'";
								
								PreparedStatement pst1=connection.prepareStatement(query1);
								
								pst1.execute();
								pst1.close();
								}
								
								catch(Exception e1){
									JOptionPane.showMessageDialog(null, "Quantity Get");
									e1.printStackTrace();
								}
								Cost.frame.refresh_table();
								Message Message= new Message();
								Message.user_id.setText(user_id.getText());
								Message.setVisible(true);
								Message.Message.setText("Cost Successfully Delete");
							
						}
				
						else if(class_name=="Supplier_D"){
							try{
							
							String query1="delete from Supplier_info where Supplier_id='"+supplier+"'";
							
							PreparedStatement pst1=connection.prepareStatement(query1);
							
							pst1.execute();
							pst1.close();
							
							String query2="delete from Supplier_address where Supplier_id='"+supplier+"'";
							
							PreparedStatement pst2=connection.prepareStatement(query2);
							
							pst2.execute();
							pst2.close();
							}
							
							catch(Exception e1){
								JOptionPane.showMessageDialog(null, "Quantity Get");
								e1.printStackTrace();
							}
							Supplier.frame.refresh_table();
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Supplier Successfully Delete");
						
					}
						else if(class_name=="Bill_D"){
							try{
							
							String query1="delete from supplier_order where S_Order_id='"+order_no+"' and Supplier_id='"+suppliers+"'";
							
							PreparedStatement pst1=connection.prepareStatement(query1);
							
							pst1.execute();
							pst1.close();
							
							}
							
							catch(Exception e1){
								JOptionPane.showMessageDialog(null, "Quantity Get");
								e1.printStackTrace();
							}
							Supplier.frame.refresh_table();
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Supplier Successfully Delete");
						
					}
				
						else if(class_name=="Employee_D"){
							try{
							
							String query1="delete from Employee_info where Company_ID='"+company+"' and Employee_id='"+employee+"'";
							
							PreparedStatement pst1=connection.prepareStatement(query1);
							
							pst1.execute();
							pst1.close();
							
							String query2="delete from Employee_address where Employee_id='"+employee+"'";
							
							PreparedStatement pst2=connection.prepareStatement(query2);
							
							pst2.execute();
							pst2.close();
							
							}
							
							catch(Exception e1){
								JOptionPane.showMessageDialog(null, "Quantity Get");
								e1.printStackTrace();
							}
							Employee.frame.refresh_table();
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Employee Successfully Delete");
						
					}
						else if(class_name=="Order_D"){
							try{
							
							String query1="delete from Orders where Order_id='"+order+"'";
							
							PreparedStatement pst1=connection.prepareStatement(query1);
							
							pst1.execute();
							pst1.close();
							
							}
							
							catch(Exception e1){
								JOptionPane.showMessageDialog(null, "Quantity Get");
								e1.printStackTrace();
							}
							Order.frame.refresh_table();
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Order Successfully Delete");
						
					}
						else if(class_name=="Invoice"){
							
								Invoice_create Invoice_create= new Invoice_create();
								Invoice_create.user_id.setText(user_id.getText());
								Invoice_create.setVisible(true);
								
						
					}
						else if(class_name=="Order"){
							Order_create Order_create= new Order_create();
							Order_create.user_id.setText(user_id.getText());
							Order_create.setVisible(true);
							
						}
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				yes.setIcon(new ImageIcon(Dashboard.class.getResource("/img/yes2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				yes.setIcon(new ImageIcon(Dashboard.class.getResource("/img/yes1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(k%2!=0){
					yes.setIcon(new ImageIcon(Dashboard.class.getResource("/img/yes1.png")));
					
					
				}
				else if(k%2==0){
					yes.setIcon(new ImageIcon(Dashboard.class.getResource("/img/yes1.png")));
					
				}
			}
		});
		
		yes.setIcon(new ImageIcon(Message_status.class.getResource("/img/yes1.png")));
		yes.setBounds(35, 111, 150, 41);
		contentPane.add(yes);
		
		no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				no.setIcon(new ImageIcon(Dashboard.class.getResource("/img/no2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				no.setIcon(new ImageIcon(Dashboard.class.getResource("/img/no1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				no.setIcon(new ImageIcon(Dashboard.class.getResource("/img/no3.png")));
				setVisible(false);
				frame.dispose(); //Destroy the JFrame object
				
				if(class_name=="Retail")
				{
					
				Retail_sales Retail_sales= new Retail_sales();
				Retail_sales.user_id.setText(user_id.getText());
				Retail_sales.setVisible(true);
				
				}
				else if(class_name=="Payment"){
					Payment.frame.setVisible(false);
					Payment.frame.dispose(); //Destroy the JFrame object
					
					Payment Payment= new Payment();
					Payment.user_id.setText(user_id.getText());
					Payment.setVisible(true);
					
					Payment.refresh_table();
				}
				else if(class_name=="Bill"){
					Expenses.frame.setVisible(false);
					Expenses.frame.dispose(); //Destroy the JFrame object
					
					Expenses Expenses= new Expenses();
					Expenses.user_id.setText(user_id.getText());
					Expenses.setVisible(true);
					
					Expenses.refresh_table();
				}
				else if(class_name=="Create_bill"){
					Bill_edit Bill_edit= new Bill_edit();
					Bill_edit.user_id.setText(user_id.getText());
					
					Bill_edit.setVisible(true);
					
				}
				else if(class_name=="Expense"){
					Expenses.frame.setVisible(false);
					Expenses.frame.dispose(); //Destroy the JFrame object
					
					Expenses Expenses= new Expenses();
					Expenses.user_id.setText(user_id.getText());
					Expenses.setVisible(true);
					
					Expenses.refresh_table();
				}
				else if(class_name=="Return"){
					Return_Inventory Return_Inventory= new Return_Inventory();
					Return_Inventory.user_id.setText(user_id.getText());
					Return_Inventory.setVisible(true);
				}
				else if(class_name=="Invoice"){
					Invoice Invoice= new Invoice();
					Invoice.user_id.setText(user_id.getText());
					Invoice.setVisible(true);
					
				}
				else if(class_name=="Order"){
					Order Order= new Order();
					Order.user_id.setText(user_id.getText());
					Order.setVisible(true);
					
				}
				
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				no.setIcon(new ImageIcon(Dashboard.class.getResource("/img/no2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				no.setIcon(new ImageIcon(Dashboard.class.getResource("/img/no1.png")));
			}
		});
		no.setIcon(new ImageIcon(Message_status.class.getResource("/img/no1.png")));
		no.setBounds(35, 163, 150, 41);
		
		contentPane.add(no);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
	        
	}
	
}
