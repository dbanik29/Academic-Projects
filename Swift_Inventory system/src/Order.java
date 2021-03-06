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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.qt.datapicker.DatePicker;

import net.proteanit.sql.DbUtils;

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
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

public class Order extends JFrame {
	Connection connection=null;
	JLabel user_id = new JLabel("");
	
	private JPanel contentPane;
	JLabel avater = new JLabel("");
	JLabel avater_drop = new JLabel("");
	JLabel avater_drop1 = new JLabel("");
	JLabel avater_drop2 = new JLabel("");
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
	int row;
	 JLabel nav_top = new JLabel("");
	JLabel swift_logo = new JLabel("");
	 JLabel refreshes = new JLabel("");
	 JLabel dashboard_M = new JLabel("");
	JLabel sale_M = new JLabel("");
	 JLabel invoice = new JLabel("");
	 JLabel customer = new JLabel("");
	 JLabel cash_sales = new JLabel("");
	 JLabel credit_sales = new JLabel("");
	 JLabel cod = new JLabel("");
	 JLabel retail = new JLabel("");
	 JLabel payment = new JLabel("");
	 JLabel return_invoice = new JLabel("");
	JLabel cash = new JLabel("");
	JLabel expense = new JLabel("");
	JLabel inventory = new JLabel("");
	 JLabel return_inventory = new JLabel("");
	JLabel reports = new JLabel("");
	JLabel cost = new JLabel("");
	JLabel accounting = new JLabel("");
	JLabel employee = new JLabel("");
	   JLabel border = new JLabel("Name");
	   JLabel help = new JLabel("");
	   JLabel search = new JLabel("");
	    JTextField search_box = new JTextField();
	    
	    static Order frame = new Order();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
					;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JCheckBox Check_orders = new JCheckBox("Check Orders");
	JCheckBox New_orders = new JCheckBox("New Orders");
	private ObservingTextField dateText;
	private final JTextField Search = new JTextField();
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel supplier = new JLabel("");
	private final JLabel date = new JLabel("Date");
	private final JLabel order_no = new JLabel("Order No.");
	private final JLabel label_2 = new JLabel("Customer ID");
	private final JLabel order_status = new JLabel("Order Status");
	private final JLabel create_order = new JLabel("");
	private final JCheckBox All_orders = new JCheckBox("All Orders");
	private final JCheckBox Checked_orders = new JCheckBox("Checked Orders");
	
	public void refresh(){
		try{
			String s1="SELECT orders.Date, orders.Order_id, orders.Status, orders.Customer_id 	FROM orders WHERE orders.Status='New' or orders.Status='Check' and ( orders.Date LIKE '%" + Search.getText() + "%' or orders.Order_id LIKE '%" + Search.getText() + "%' or  orders.Status LIKE '%" + Search.getText() + "%' or orders.Customer_id LIKE '%" + Search.getText() + "%') GROUP by orders.Order_id";
			
			PreparedStatement pst=connection.prepareStatement(s1);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			table.setRowHeight(30);
			
			
			pst.close();
			rs.close();
			System.out.println("ssssss");
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
	}
	
	
	
	public void refresh_table(){
		try{
			String s1="SELECT orders.Date, orders.Order_id, orders.Status, orders.Customer_id 	FROM orders WHERE orders.Status='New' or orders.Status='Check' GROUP by orders.Order_id";
			
			PreparedStatement pst=connection.prepareStatement(s1);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			table.setRowHeight(30);
			
			
			pst.close();
			rs.close();
			System.out.println("ssssss");
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
	}
	
	public Order() {
		connection =DatabaseConnect.DBConnectors();
		
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	         
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
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
					i++;
				}
				else if(i%2==0){
					avater.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater2.png")));
					avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.1.png")));
					avater_drop.setBounds(1140, -10, 160, 50);
					avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
					avater_drop1.setBounds(1140, -10, 160, 41);
					avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
					avater_drop2.setBounds(1140, -10, 160, 41);
					i++;
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
		
		refreshes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				refreshes.setIcon(new ImageIcon(Customer.class.getResource("/img/refresh1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				refreshes.setIcon(new ImageIcon(Customer.class.getResource("/img/refresh.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					refreshes.setIcon(new ImageIcon(Customer.class.getResource("/img/refresh2.png")));
					refresh_table();
					New_orders.setSelected(true);
					Check_orders.setSelected(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				refreshes.setIcon(new ImageIcon(Customer.class.getResource("/img/refresh1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				refreshes.setIcon(new ImageIcon(Customer.class.getResource("/img/refresh.png")));
			}
		});
		
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
		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(s%2!=0){
					search.setIcon(new ImageIcon(Dashboard.class.getResource("/img/search2.png")));
					search_box.setBounds(900, 11, 200, 36);
					search.setBounds(1120, 0, 60, 60);
					search_box.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
					search_box.setOpaque(false);
					search_box.setBackground(new Color(0,0,0,0));
					search_box.setFocusable(true);
					System.out.println(s);
					s++;
					
				}
				else if(s%2==0){
					search.setIcon(new ImageIcon(Dashboard.class.getResource("/img/search2.png")));
					search_box.setBounds(-955, 11, 200, 36);
					search.setBounds(1120, 0, 60, 60);
					
					s++;
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				search.setIcon(new ImageIcon(Dashboard.class.getResource("/img/search2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				search.setIcon(new ImageIcon(Dashboard.class.getResource("/img/search.png")));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(s%2!=0){
					search.setIcon(new ImageIcon(Dashboard.class.getResource("/img/search.png")));
					search_box.setBounds(900, 11, 200, 36);
					search.setBounds(1120, 0, 60, 60);
					search_box.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
					search_box.setOpaque(false);
					search_box.setBackground(new Color(0,0,0,0));
				}
				else if(s%2==0){
					search.setIcon(new ImageIcon(Dashboard.class.getResource("/img/search.png")));
					search_box.setBounds(-955, 11, 200, 36);
					search.setBounds(1120, 0, 60, 60);
					
				}
			}
		});
		search.setIcon(new ImageIcon(Dashboard.class.getResource("/img/search.png")));
		search.setBounds(1120, 0, 60, 60);
		contentPane.add(search);
		search_box.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				search_box.setBounds(900, 11, 200, 36);
				search.setBounds(1120, 0, 60, 60);
				search_box.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
				search_box.setOpaque(false);
				search_box.setBackground(new Color(0,0,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		search_box.setFont(new Font("Tahoma", Font.ITALIC, 14));
		search_box.setBackground(new Color(0,0,0,0));
		search_box.setBounds(-955, 11, 200, 36);
		search_box.setColumns(10);
		
		contentPane.add(search_box);
		
		JLabel title = new JLabel("Orders");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		title.setBounds(270, 17, 463, 28);
		contentPane.add(title);
		
		refreshes.setIcon(new ImageIcon(Order.class.getResource("/img/refresh.png")));
		refreshes.setBounds(200, 0, 60, 60);
		contentPane.add(refreshes);
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(10, 12, 107, 35);
		
		contentPane.add(swift_logo);
		nav_top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/nav_top.png")));
		nav_top.setBounds(0, 0, 200, 60);
		
		contentPane.add(nav_top);
		
		JLabel top = new JLabel("");
		top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/top.png")));
		top.setEnabled(false);
		top.setBounds(0, 0, 1300, 60);
		contentPane.add(top);
		
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
		avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
		avater_drop2.setBounds(1140, -10, 160, 41);
		contentPane.add(avater_drop2);
		
		
		invoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice3.png")));
				setVisible(false);
				frame.dispose();
				Invoice Invoice=new Invoice();
				Invoice.user_id.setText(user_id.getText());
				Invoice.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice1.png")));
			}
		});
		
		customer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer3.png")));
				setVisible(false);
				frame.dispose();
				Customer Customer=new Customer();
				Customer.user_id.setText(user_id.getText());
				Customer.setVisible(true);

			}
			@Override
			public void mousePressed(MouseEvent e) {
				customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer.png")));
			}
		});
		
		cash_sales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale3.png")));
				setVisible(false);
				frame.dispose();
				Cash_sales Cash_sales= new Cash_sales();
				Cash_sales.user_id.setText(user_id.getText());
				Cash_sales.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale1.png")));
			}
		});
		
		credit_sales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale3.png")));
				setVisible(false);
				frame.dispose();
				Credit_sales Credit_sales=new Credit_sales();
				Credit_sales.user_id.setText(user_id.getText());
				Credit_sales.setVisible(true);

			}
			@Override
			public void mousePressed(MouseEvent e) {
				credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale1.png")));
			}
		});
		
		cod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod3.png")));
				setVisible(false);
				frame.dispose();
				COD_sales COD_sales=new COD_sales();
				COD_sales.user_id.setText(user_id.getText());
				COD_sales.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod1.png")));
			}
		});
		
		retail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale3.png")));
				setVisible(false);
				frame.dispose();
				Retail_sales Retail_sales= new Retail_sales();
				Retail_sales.user_id.setText(user_id.getText());
				Retail_sales.setVisible(true);

			}
			@Override
			public void mousePressed(MouseEvent e) {
				retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale1.png")));
			}
		});
		
		payment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment3.png")));
				setVisible(false);
				frame.dispose();
				Payment Payment=new Payment();
				Payment.user_id.setText(user_id.getText());
				Payment.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment1.png")));
			}
		});
		
		return_invoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice3.png")));
				setVisible(false);
				frame.dispose();
				Return_invoice Return_invoice=new Return_invoice();
				Return_invoice.user_id.setText(user_id.getText());
				Return_invoice.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice1.png")));
			}
		});
		
		cash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash3.png")));
				setVisible(false);
				frame.dispose();
				Cash Cash= new Cash();
				Cash.user_id.setText(user_id.getText());
				Cash.setVisible(true);

			}
			@Override
			public void mousePressed(MouseEvent e) {
				cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash1.png")));
			}
		});
		
		
		
		expense.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				expense.setIcon(new ImageIcon(Dashboard.class.getResource("/img/expense2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				expense.setIcon(new ImageIcon(Dashboard.class.getResource("/img/expense1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				expense.setIcon(new ImageIcon(Dashboard.class.getResource("/img/expense3.png")));
				setVisible(false);
				frame.dispose();
				Expenses Expenses=new Expenses();
				Expenses.user_id.setText(user_id.getText());
				Expenses.setVisible(true);

			}
			@Override
			public void mousePressed(MouseEvent e) {
				expense.setIcon(new ImageIcon(Dashboard.class.getResource("/img/expense2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				expense.setIcon(new ImageIcon(Dashboard.class.getResource("/img/expense1.png")));
			}
		});
				
		return_inventory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				return_inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_inventory2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				return_inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_inventory1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				return_inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_inventory3.png")));
				setVisible(false);
				frame.dispose();
				Return_Inventory Return_Inventory= new Return_Inventory();
				Return_Inventory.user_id.setText(user_id.getText());
				Return_Inventory.setVisible(true);

			}
			@Override
			public void mousePressed(MouseEvent e) {
				return_inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_inventory2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				return_inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_inventory1.png")));
			}
		});
		
		reports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				reports.setIcon(new ImageIcon(Dashboard.class.getResource("/img/report2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				reports.setIcon(new ImageIcon(Dashboard.class.getResource("/img/report1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				reports.setIcon(new ImageIcon(Dashboard.class.getResource("/img/report3.png")));
				setVisible(false);
				frame.dispose();
				Report Report=new Report();
				Report.user_id.setText(user_id.getText());
				Report.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				reports.setIcon(new ImageIcon(Dashboard.class.getResource("/img/report2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				reports.setIcon(new ImageIcon(Dashboard.class.getResource("/img/report1.png")));
			}
		});
		
		cost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cost.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cost2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cost.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cost1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cost.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cost3.png")));
				setVisible(false);
				frame.dispose();
				Cost Cost=new Cost();
				Cost.user_id.setText(user_id.getText());
				Cost.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				cost.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cost2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				cost.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cost1.png")));
			}
		});
		
		accounting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				accounting.setIcon(new ImageIcon(Dashboard.class.getResource("/img/accounting2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				accounting.setIcon(new ImageIcon(Dashboard.class.getResource("/img/accounting1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accounting.setIcon(new ImageIcon(Dashboard.class.getResource("/img/accounting3.png")));
				setVisible(false);
				frame.dispose();
				Accounting Accounting= new Accounting();
				Accounting.user_id.setText(user_id.getText());
				Accounting.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				accounting.setIcon(new ImageIcon(Dashboard.class.getResource("/img/accounting2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				accounting.setIcon(new ImageIcon(Dashboard.class.getResource("/img/accounting1.png")));
			}
		});
		
		employee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				employee.setIcon(new ImageIcon(Dashboard.class.getResource("/img/employee2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				employee.setIcon(new ImageIcon(Dashboard.class.getResource("/img/employee1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				employee.setIcon(new ImageIcon(Dashboard.class.getResource("/img/employee3.png")));
				setVisible(false);
				frame.dispose();
				Employee Employee=new Employee();
				Employee.user_id.setText(user_id.getText());
				Employee.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				employee.setIcon(new ImageIcon(Dashboard.class.getResource("/img/employee2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				employee.setIcon(new ImageIcon(Dashboard.class.getResource("/img/employee1.png")));
			}
		});
		
		supplier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				supplier.setIcon(new ImageIcon(Dashboard.class.getResource("/img/supplier2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				supplier.setIcon(new ImageIcon(Dashboard.class.getResource("/img/supplier1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				supplier.setIcon(new ImageIcon(Dashboard.class.getResource("/img/supplier3.png")));
				setVisible(false);
				frame.dispose();
				Supplier Supplier=new Supplier();
				Supplier.user_id.setText(user_id.getText());
				Supplier.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				supplier.setIcon(new ImageIcon(Dashboard.class.getResource("/img/supplier2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				supplier.setIcon(new ImageIcon(Dashboard.class.getResource("/img/supplier1.png")));
			}
		});
		
		avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
		avater_drop2.setBounds(1140, -10, 160, 41);
		contentPane.add(avater_drop2);
		
		
		dashboard_M.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				frame.dispose();
				Dashboard Dashboard= new Dashboard();
				Dashboard.user_id.setText(user_id.getText());
				Dashboard.setVisible(true);
				if(k%2!=0){
					dashboard_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dashboard2.png")));
					
					k++;
				}
				else if(k%2==0){
					dashboard_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dashboard2.png")));
					
					k++;
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				dashboard_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dashboard2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				dashboard_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dashboard1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(k%2!=0){
					dashboard_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dashboard1.png")));
					
					
				}
				else if(k%2==0){
					dashboard_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dashboard1.png")));
					
					
				}
			}
		});
		
		dashboard_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dashboard1.png")));
		dashboard_M.setBounds(0, 67, 200, 40);
		contentPane.add(dashboard_M);
		
		sale_M.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				setVisible(false);
				frame.dispose();
				Sales Sales= new Sales();
				Sales.user_id.setText(user_id.getText());
				Sales.setVisible(true);
				if(l%2!=0){
					
					l2=1;
					sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale2.png")));
					invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice1.png")));
					invoice.setBounds(0, 147, 200, 35);
					
					customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer1.png")));
					customer.setBounds(0, 182, 200, 35);
					
					cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale1.png")));
					cash_sales.setBounds(0, 217, 200, 35);
					
					credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale1.png")));
					credit_sales.setBounds(0, 252, 200, 35);
					
					cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod1.png")));
					cod.setBounds(0, 287, 200, 35);
					
					retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale1.png")));
					retail.setBounds(0, 322, 200, 35);
					
					payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment1.png")));
					payment.setBounds(0, 357, 200, 35);
					
					return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice1.png")));
					return_invoice.setBounds(0, 392, 200, 35);
					
					
					cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash1.png")));
					cash.setBounds(0, 427, 200, 40);
					
					
					expense.setIcon(new ImageIcon(Dashboard.class.getResource("/img/expense1.png")));
					expense.setBounds(0, 467, 200, 40);
					
					
					inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory1.png")));
					inventory.setBounds(0, 507, 200, 40);
					
					return_inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_inventory1.png")));
					return_inventory.setBounds(0, 507, 200, 35);
					
					
					reports.setIcon(new ImageIcon(Dashboard.class.getResource("/img/report1.png")));
					reports.setBounds(0, 547, 200, 40);
					
					
					cost.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cost1.png")));
					cost.setBounds(0, 587, 200, 40);
					
					
					accounting.setIcon(new ImageIcon(Dashboard.class.getResource("/img/accounting1.png")));
					accounting.setBounds(0, 627, 200, 40);
					
					
					employee.setIcon(new ImageIcon(Dashboard.class.getResource("/img/employee1.png")));
					employee.setBounds(0, 667, 200, 40);
					
					l=2;
					
				}
				else if(l%2==0){
						l2=1;
					sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale2.png")));
					invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice1.png")));
					invoice.setBounds(0, 107, 200, 35);
					
					customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer1.png")));
					customer.setBounds(0, 107, 200, 35);
					
					cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale1.png")));
					cash_sales.setBounds(0, 107, 200, 35);
					
					credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale1.png")));
					credit_sales.setBounds(0, 107, 200, 35);
					
					cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod1.png")));
					cod.setBounds(0, 107, 200, 35);
					
					retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale1.png")));
					retail.setBounds(0, 107, 200, 35);
					
					payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment1.png")));
					payment.setBounds(0, 107, 200, 35);
					
					return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice1.png")));
					return_invoice.setBounds(0, 107, 200, 35);
					
					
					cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash1.png")));
					cash.setBounds(0, 147, 200, 40);
					
					
					expense.setIcon(new ImageIcon(Dashboard.class.getResource("/img/expense1.png")));
					expense.setBounds(0, 187, 200, 40);
					
					
					inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory1.png")));
					inventory.setBounds(0, 227, 200, 40);
					
					return_inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_inventory1.png")));
					return_inventory.setBounds(0, 227, 200, 35);
					
					
					reports.setIcon(new ImageIcon(Dashboard.class.getResource("/img/report1.png")));
					reports.setBounds(0, 267, 200, 40);
					
					
					cost.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cost1.png")));
					cost.setBounds(0, 307, 200, 40);
					
					
					accounting.setIcon(new ImageIcon(Dashboard.class.getResource("/img/accounting1.png")));
					accounting.setBounds(0, 347, 200, 40);
					
					
					employee.setIcon(new ImageIcon(Dashboard.class.getResource("/img/employee1.png")));
					employee.setBounds(0, 387, 200, 40);
					l=1;
				}
				System.out.println("l "+l+"  l2"+l2);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale1.png")));
			}
			
		});
		
		inventory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				frame.dispose();
				Inventory Inventory=new Inventory();
				Inventory.user_id.setText(user_id.getText());
				Inventory.setVisible(true);
				if(l2%2!=0){
					if(l%2==0){
						sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale1.png")));
					invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice1.png")));
					invoice.setBounds(0, 107, 200, 35);
					
					customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer1.png")));
					customer.setBounds(0, 107, 200, 35);
					
					cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale1.png")));
					cash_sales.setBounds(0, 107, 200, 35);
					
					credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale1.png")));
					credit_sales.setBounds(0, 107, 200, 35);
					
					cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod1.png")));
					cod.setBounds(0, 107, 200, 35);
					
					retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale1.png")));
					retail.setBounds(0, 107, 200, 35);
					
					payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment1.png")));
					payment.setBounds(0, 107, 200, 35);
					
					return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice1.png")));
					return_invoice.setBounds(0, 107, 200, 35);
					
					
					cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash1.png")));
					cash.setBounds(0, 147, 200, 40);
					
					
					expense.setIcon(new ImageIcon(Dashboard.class.getResource("/img/expense1.png")));
					expense.setBounds(0, 187, 200, 40);
					l=1;
					}
					
					
					inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory1.png")));
					inventory.setBounds(0, 227, 200, 40);
					
					return_inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_inventory1.png")));
					return_inventory.setBounds(0, 267, 200, 35);
					
					
					reports.setIcon(new ImageIcon(Dashboard.class.getResource("/img/report1.png")));
					reports.setBounds(0, 302, 200, 40);
					
					
					cost.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cost1.png")));
					cost.setBounds(0, 342, 200, 40);
					
					
					accounting.setIcon(new ImageIcon(Dashboard.class.getResource("/img/accounting1.png")));
					accounting.setBounds(0, 382, 200, 40);
					
					
					employee.setIcon(new ImageIcon(Dashboard.class.getResource("/img/employee1.png")));
					employee.setBounds(0, 422, 200, 40);
					
					
					l2=2;
					
				}
				else if(l2%2==0){
					
					inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory1.png")));
					inventory.setBounds(0, 227, 200, 40);
					
					return_inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_inventory1.png")));
					return_inventory.setBounds(0, 227, 200, 35);
					
					
					reports.setIcon(new ImageIcon(Dashboard.class.getResource("/img/report1.png")));
					reports.setBounds(0, 267, 200, 40);
					
					
					cost.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cost1.png")));
					cost.setBounds(0, 307, 200, 40);
					
					
					accounting.setIcon(new ImageIcon(Dashboard.class.getResource("/img/accounting1.png")));
					accounting.setBounds(0, 347, 200, 40);
					
					
					employee.setIcon(new ImageIcon(Dashboard.class.getResource("/img/employee1.png")));
					employee.setBounds(0, 387, 200, 40);
					l2=1;
				}
				System.out.println("inv"+"l "+l+"  l2"+l2);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory1.png")));
			}
			
		});
		
		
		create_order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				create_order.setIcon(new ImageIcon(Dashboard.class.getResource("/img/create_order2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				create_order.setIcon(new ImageIcon(Dashboard.class.getResource("/img/create_order1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				create_order.setIcon(new ImageIcon(Dashboard.class.getResource("/img/create_order3.png")));
				setVisible(false);
				frame.dispose();
			
				Order_create Order_create= new Order_create();
				Order_create.user_id.setText(user_id.getText());
				//Order_create.edit.setText("Add New Employee");
				Order_create.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				create_order.setIcon(new ImageIcon(Dashboard.class.getResource("/img/create_order2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				create_order.setIcon(new ImageIcon(Dashboard.class.getResource("/img/create_order1.png")));
			}
		});
		sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale1.png")));
		sale_M.setBounds(0, 107, 200, 40);
		contentPane.add(sale_M);
			
		invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice1.png")));
		invoice.setBounds(0, 107, 200, 35);
		contentPane.add(invoice);
		
		customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer1.png")));
		customer.setBounds(0, 107, 200, 35);
		contentPane.add(customer);
		
		cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale1.png")));
		cash_sales.setBounds(0, 107, 200, 35);
		contentPane.add(cash_sales);

		credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale1.png")));
		credit_sales.setBounds(0, 107, 200, 35);
		contentPane.add(credit_sales);
		
		cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod1.png")));
		cod.setBounds(0, 107, 200, 35);
		contentPane.add(cod);
		
		retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale1.png")));
		retail.setBounds(0, 107, 200, 35);
		contentPane.add(retail);
		
		payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment1.png")));
		payment.setBounds(0, 107, 200, 35);
		contentPane.add(payment);
		
		return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice1.png")));
		return_invoice.setBounds(0, 107, 200, 35);
		contentPane.add(return_invoice);
		
		cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash1.png")));
		cash.setBounds(0, 147, 200, 40);
		contentPane.add(cash);
		
		expense.setIcon(new ImageIcon(Dashboard.class.getResource("/img/expense1.png")));
		expense.setBounds(0, 187, 200, 40);
		contentPane.add(expense);
		
		inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory1.png")));
		inventory.setBounds(0, 227, 200, 40);
		contentPane.add(inventory);
		
		return_inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_inventory1.png")));
		return_inventory.setBounds(0, 227, 200, 35);
		contentPane.add(return_inventory);
		
		reports.setIcon(new ImageIcon(Dashboard.class.getResource("/img/report1.png")));
		reports.setBounds(0, 267, 200, 40);
		contentPane.add(reports);
		
		cost.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cost1.png")));
		cost.setBounds(0, 307, 200, 40);
		contentPane.add(cost);
		
		accounting.setIcon(new ImageIcon(Dashboard.class.getResource("/img/accounting1.png")));
		accounting.setBounds(0, 347, 200, 40);
		contentPane.add(accounting);
		
		employee.setIcon(new ImageIcon(Dashboard.class.getResource("/img/employee1.png")));
		employee.setBounds(0, 387, 200, 40);
		contentPane.add(employee);
		border.setFont(new Font("Tahoma", Font.ITALIC, 15));
		border.setForeground(SystemColor.textInactiveText);
		border.setBounds(382, -171, 72, 17);
		
		contentPane.add(border);
		Search.setText("Search");
		Search.setForeground(Color.GRAY);
		Search.setFont(new Font("Futura Lt BT", Font.PLAIN, 14));
		Search.setColumns(10);
		Search.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Search.setBackground(new Color(230, 235, 255));
		Search.setBounds(218, 80, 300, 25);
		
		contentPane.add(Search);
		
		Search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Search.setText("");
			}
		});
		Search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				refresh();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				refresh();
			}
			
		});
		
		scrollPane.setBounds(218, 160, 1060, 550);
		
		contentPane.add(scrollPane);
		table.setFillsViewportHeight(true);
		table.setDefaultEditor(Object.class, null);
		table.setRowSelectionAllowed(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Eras Medium ITC", Font.PLAIN, 13));
		
		table.setBackground(new Color(230, 250, 255));
		
		table.getTableHeader().setUI(null);
		Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		
		scrollPane.setBorder(emptyBorder);
		scrollPane.setViewportView(table);
		scrollPane.setBackground(new Color(230, 250, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				row=table.getSelectedRow();
				int co=table.getSelectedColumn();
				
				String order = table.getModel().getValueAt(row, 1).toString();
				String date = table.getModel().getValueAt(row, 0).toString();
				System.out.println(row+"  "+co+"  "+order);
				Order_mass Order_mass= new Order_mass();
				Order_mass.user_id.setText(user_id.getText());
				Order_mass.setVisible(true);
				Order_mass.order=order;
				Order_mass.date=date;
				
			}
		});
		
		try{
			
			String s1="SELECT orders.Date, orders.Order_id, orders.Status, orders.Customer_id 	FROM orders WHERE orders.Status='New' or orders.Status='Check' GROUP by orders.Order_id";
			
			PreparedStatement pst=connection.prepareStatement(s1);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			table.setRowHeight(30);
			
			TableColumnModel column=table.getColumnModel();
			
			pst.close();
			rs.close();
			System.out.println("ssssss");
			New_orders.setSelected(true);
			Check_orders.setSelected(true);
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		
		supplier.setIcon(new ImageIcon(Order.class.getResource("/img/supplier1.png")));
		supplier.setBounds(0, 427, 200, 40);
		
		contentPane.add(supplier);
		date.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		date.setBounds(312, 133, 77, 14);
		
		contentPane.add(date);
		order_no.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		order_no.setBounds(568, 133, 90, 14);
		
		contentPane.add(order_no);
		label_2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		label_2.setBounds(1097, 133, 96, 14);
		
		contentPane.add(label_2);
		order_status.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		order_status.setBounds(832, 133, 90, 14);
		
		contentPane.add(order_status);
		create_order.setIcon(new ImageIcon(Order.class.getResource("/img/create_order1.png")));
		create_order.setBounds(1130, 71, 150, 41);
		
		contentPane.add(create_order);
		New_orders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(New_orders.isSelected()==true){
				try{
					String s1="SELECT orders.Date, orders.Order_id, orders.Status, orders.Customer_id 	FROM orders WHERE orders.Status='New' GROUP by orders.Order_id";
					
					PreparedStatement pst=connection.prepareStatement(s1);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					table.setRowHeight(30);
					
					TableColumnModel column=table.getColumnModel();
					
					pst.close();
					rs.close();
					System.out.println("ssssss");
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				Check_orders.setSelected(false);
				All_orders.setSelected(false);
				Checked_orders.setSelected(false);
				}
				else {
					try{
						String s1="SELECT orders.Date, orders.Order_id, orders.Status, orders.Customer_id 	FROM orders WHERE orders.Status='New' or orders.Status='Check' GROUP by orders.Order_id";
						
						PreparedStatement pst=connection.prepareStatement(s1);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						table.setRowHeight(30);
						
						TableColumnModel column=table.getColumnModel();
						
						pst.close();
						rs.close();
						System.out.println("ssssss");
						}
						catch(Exception e1){
							e1.printStackTrace();
						}
				}
			}
		});
		Check_orders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Check_orders.isSelected()==true){ 
				try{
						String s1="SELECT orders.Date, orders.Order_id, orders.Status, orders.Customer_id 	FROM orders WHERE orders.Status='Check' GROUP by orders.Order_id";
						
						PreparedStatement pst=connection.prepareStatement(s1);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						table.setRowHeight(30);
						
						TableColumnModel column=table.getColumnModel();
						
						pst.close();
						rs.close();
						System.out.println("ssssss");
						}
						catch(Exception e1){
							e1.printStackTrace();
						}
				New_orders.setSelected(false);
				All_orders.setSelected(false);
				Checked_orders.setSelected(false);
				}
				else {
					try{
						String s1="SELECT orders.Date, orders.Order_id, orders.Status, orders.Customer_id 	FROM orders WHERE orders.Status='New' or orders.Status='Check' GROUP by orders.Order_id";
						
						PreparedStatement pst=connection.prepareStatement(s1);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						table.setRowHeight(30);
						
						TableColumnModel column=table.getColumnModel();
						
						pst.close();
						rs.close();
						System.out.println("ssssss");
						}
						catch(Exception e1){
							e1.printStackTrace();
						}
				}
			}
		});
		
		New_orders.setFont(new Font("Garamond", Font.BOLD, 16));
		New_orders.setBounds(546, 84, 116, 23);
		contentPane.add(New_orders);
		New_orders.setBackground(new Color(230, 235, 255));
		
		Check_orders.setFont(new Font("Garamond", Font.BOLD, 16));
		Check_orders.setBounds(669, 84, 131, 23);
		contentPane.add(Check_orders);
		Check_orders.setBackground(new Color(230, 235, 255));
		All_orders.setFont(new Font("Garamond", Font.BOLD, 16));
		All_orders.setBackground(new Color(230, 235, 255));
		All_orders.setBounds(954, 84, 131, 23);
		
		contentPane.add(All_orders);
		Checked_orders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Checked_orders.isSelected()==true){ 
					try{
							String s1="SELECT orders.Date, orders.Order_id, orders.Status, orders.Customer_id 	FROM orders WHERE orders.Status='Checked' GROUP by orders.Order_id";
							
							PreparedStatement pst=connection.prepareStatement(s1);
							ResultSet rs=pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							
							table.setRowHeight(30);
							
							TableColumnModel column=table.getColumnModel();
							
							pst.close();
							rs.close();
							System.out.println("ssssss");
							}
							catch(Exception e1){
								e1.printStackTrace();
							}
					New_orders.setSelected(false);
					Check_orders.setSelected(false);
					
					All_orders.setSelected(false);
					}
					else {
						try{
							String s1="SELECT orders.Date, orders.Order_id, orders.Status, orders.Customer_id 	FROM orders WHERE orders.Status='New' or orders.Status='Check' GROUP by orders.Order_id";
							
							PreparedStatement pst=connection.prepareStatement(s1);
							ResultSet rs=pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							
							table.setRowHeight(30);
							
							pst.close();
							rs.close();
							System.out.println("ssssss");
							}
							catch(Exception e1){
								e1.printStackTrace();
							}
					}
			}
		});
		All_orders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(All_orders.isSelected()==true){
					New_orders.setSelected(true);
					Check_orders.setSelected(true);
					Checked_orders.setSelected(true);
					All_orders.setSelected(true);
					
						try{
							String s1="SELECT orders.Date, orders.Order_id, orders.Status, orders.Customer_id 	FROM orders WHERE orders.Status='New' or orders.Status='Check' or orders.Status='Checked' GROUP by orders.Order_id";
							
							PreparedStatement pst=connection.prepareStatement(s1);
							ResultSet rs=pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							
							table.setRowHeight(30);
							
							pst.close();
							rs.close();
							System.out.println("ssssss");
							}
							catch(Exception e1){
								e1.printStackTrace();
							}
				}
				else{
					try{
						New_orders.setSelected(true);
						Check_orders.setSelected(true);
						Checked_orders.setSelected(false);
						String s1="SELECT orders.Date, orders.Order_id, orders.Status, orders.Customer_id 	FROM orders WHERE orders.Status='New' or orders.Status='Check' GROUP by orders.Order_id";
						
						PreparedStatement pst=connection.prepareStatement(s1);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						table.setRowHeight(30);
						
						pst.close();
						rs.close();
						System.out.println("ssssss");
						}
						catch(Exception e1){
							e1.printStackTrace();
						}
				}
					
					
			}
		});
		Checked_orders.setFont(new Font("Garamond", Font.BOLD, 16));
		Checked_orders.setBackground(new Color(230, 235, 255));
		Checked_orders.setBounds(802, 84, 150, 23);
		
		contentPane.add(Checked_orders);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
	}
	
}