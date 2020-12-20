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
import javax.swing.JPasswordField;
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
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class Bill_create extends JFrame {
	Connection connection=null;
	JLabel user_id = new JLabel("");
	
	private JPanel contentPane;
	
	static JLabel time = new JLabel("");
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
	int I_q;
	 JLabel nav_top = new JLabel("");
	JLabel swift_logo = new JLabel("");
	
	   JLabel border = new JLabel("Name");
	    JTextField search_box = new JTextField();
	    
	    static Bill_create frame = new Bill_create();
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
	
	public ObservingTextField dateText;
	 public JLabel title = new JLabel("Edit");
	 private JTextField Supplier_id;
	 private JTextField Supplier_name;
	 private JTextField Supplier_company;
	 private JTextField Contact_no;
	 private JTextField Email;
	  JTextField Order_no = new JTextField();
	  JTextField Date = new JTextField();
	 private JTextField Amount;
	 private JTextField Bill_no;
	 int order;
	 private final JLabel cross = new JLabel("");
	 private final JLabel saves = new JLabel("");
	
    public void show(String order_no,String suppliers, String date,String bill_no,String amount){
    	try{
			Order_no.setText(order_no);
			Date.setText(date);
			Supplier_id.setText(suppliers);
			Bill_no.setText(bill_no);
			Amount.setText(amount);
			
			//Get Supplier Details
			
				String query="SELECT * FROM Supplier_info Where Supplier_id='"+Supplier_id.getText()+"'";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				rs.next();

				Supplier_name.setText(rs.getString("Title")+" "+rs.getString("First_Name")+" "+rs.getString("Middle_Name")+" "+rs.getString("Last_Name"));
				Email.setText(rs.getString("email"));
				Contact_no.setText(rs.getString("mobile"));
			
				pst.close();
				rs.close();
				
			//JOptionPane.showMessageDialog(null, "Show");
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
    }
	public Bill_create() {
		connection =DatabaseConnect.DBConnectors();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		Date.setText(sdf.format(new Date()));
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
			time.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			time.setText(TimeAr[3]);
	         
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		try{
			String query4="SELECT max(S_Order_id) as order_no FROM supplier_order";
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
		Order_no.setText(String.valueOf(order));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 495, 338);
		setShape(new RoundRectangle2D.Double(00, 00, 495, 338, 50, 0));
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getSize().height; //get the heigth of the frame
        int framelocationX=(dim.width-framewidth)/2; 
        int framelocationY=(dim.height-frameheigth)/2;
        this.setLocation(framelocationX,framelocationY);
		
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new MatteBorder(0, 5, 5, 5, (Color) new Color(0, 0, 51)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		time.setBounds(669, 22, 225, 14);
		contentPane.add(time);
		saves.setIcon(new ImageIcon(Bill_create.class.getResource("/img/saves1.png")));
		saves.setBounds(435, 0, 60, 60);
		
		contentPane.add(saves);
		cross.setIcon(new ImageIcon(Bill_create.class.getResource("/img/cross1.png")));
		cross.setBounds(0, 0, 60, 60);
		contentPane.add(cross);
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(78, 12, 107, 35);
		
		contentPane.add(swift_logo);
		nav_top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/nav_top.png")));
		nav_top.setBounds(0, 0, 200, 60);
		
		contentPane.add(nav_top);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		title.setBounds(210, 17, 245, 28);
		
		contentPane.add(title);
		
		JLabel top = new JLabel("");
		top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/top.png")));
		top.setEnabled(false);
		top.setBounds(0, 0, 495, 60);
		contentPane.add(top);
		
		border.setFont(new Font("Tahoma", Font.ITALIC, 15));
		border.setForeground(SystemColor.textInactiveText);
		border.setBounds(382, -171, 72, 17);
		
		contentPane.add(border);
		
		saves.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					saves.setIcon(new ImageIcon(Dashboard.class.getResource("/img/saves3.png")));
					if(title.getText()=="Add Bill"){
						try{
							
							String query="insert into supplier_order(S_Order_id,Supplier_id,Date,Bill_no,Amount,Status)  values(?,?,?,?,?,?) ";
							
							PreparedStatement pst=connection.prepareStatement(query);
							pst.setString(1, Order_no.getText());
							pst.setString(2, Supplier_id.getText());
							pst.setString(3, Date.getText());
							pst.setString(4, Bill_no.getText());
							pst.setString(5, Amount.getText());
							pst.setString(6, "New");
							
							pst.execute();
							pst.close();
							
						
							setVisible(false); //you can't see me!
							dispose(); //Destroy the JFrame object
							
							
							Bill_edit.frame.refresh_table();
							Message Message= new Message();
							Message.setVisible(true);
							
							Message.Message.setText("Bill Successfully Added");
							Message_status Message_status= new Message_status();
							Message_status.user_id.setText(user_id.getText());
							Message_status.setVisible(true);
							Message_status.Message.setText("Create Bill");
							Message_status.class_name="Create_bill";
							
							//JOptionPane.showMessageDialog(null, "Data Add");
						
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
						
					}
					else if(title.getText()=="Bill Edit"){
						try{
							
							String q1=" UPDATE supplier_order SET supplier_order.Bill_no='"+Bill_no.getText()+"', supplier_order.Amount='"+Amount.getText()+"', supplier_order.Status='Updated' WHERE supplier_order.S_Order_id='"+Order_no.getText()+"'";
							
							PreparedStatement pst=connection.prepareStatement(q1);
						
							pst.execute();
							pst.close();
							
							
							setVisible(false);
							frame.dispose(); //Destroy the JFrame object
						
							Bill_edit.frame.refresh_table();
							Message Message= new Message();
							Message.setVisible(true);
							Message.Message.setText("Bill Successfully Updated");
							
							//JOptionPane.showMessageDialog(null, "Update");
							
						}
						catch(Exception e1){
							//JOptionPane.showMessageDialog(null, "Quantity Get");
							e1.printStackTrace();
						}
					}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				saves.setIcon(new ImageIcon(Dashboard.class.getResource("/img/saves2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				saves.setIcon(new ImageIcon(Dashboard.class.getResource("/img/saves1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				saves.setIcon(new ImageIcon(Dashboard.class.getResource("/img/saves2.png")));
				
			}
		});
		JLabel supplier_id = new JLabel("Supplier ID");
		supplier_id.setForeground(new Color(0, 0, 51));
		supplier_id.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		supplier_id.setBounds(31, 120, 120, 14);
		contentPane.add(supplier_id);
		
		Supplier_id = new JTextField();
		Supplier_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					if(Supplier_id.getText().length()==5){
					try{
						String query="SELECT * FROM Supplier_info Where Supplier_id='"+Supplier_id.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						rs.next();

						Supplier_name.setText(rs.getString("Title")+" "+rs.getString("First_Name")+" "+rs.getString("Middle_Name")+" "+rs.getString("Last_Name"));
						Email.setText(rs.getString("email"));
						Contact_no.setText(rs.getString("mobile"));
					
						pst.close();
						rs.close();
						Bill_no.grabFocus();
						}
						catch(Exception e1){
							
							//JOptionPane.showMessageDialog(null, "Incorrect Customer ID");
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Incorrect Supplier ID");
						}
					}
					else{
						//JOptionPane.showMessageDialog(null, "Invalid Customer ID");
						Message Message= new Message();
						Message.user_id.setText(user_id.getText());
						Message.setVisible(true);
						Message.Message.setText("Invalid Supplier ID");
					}
				
				}
				
			}
		});
		
		cross.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					cross.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cross3.png")));
					setVisible(false);
					dispose();
					Bill_edit Bill_edit= new Bill_edit();
					Bill_edit.user_id.setText(user_id.getText());
					Bill_edit.setVisible(true);
					
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
		
		Supplier_id.setForeground(new Color(0, 0, 51));
		Supplier_id.setFont(new Font("Garamond", Font.BOLD, 16));
		Supplier_id.setColumns(10);
		Supplier_id.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Supplier_id.setBackground(new Color(255, 255, 204));
		Supplier_id.setBounds(31, 142, 84, 23);
		contentPane.add(Supplier_id);
		
		JLabel supplier_name = new JLabel("Supplier Name");
		supplier_name.setForeground(new Color(0, 0, 51));
		supplier_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		supplier_name.setBounds(125, 120, 132, 14);
		contentPane.add(supplier_name);
		
		Supplier_name = new JTextField();
		Supplier_name.setForeground(new Color(0, 0, 51));
		Supplier_name.setFont(new Font("Garamond", Font.BOLD, 16));
		Supplier_name.setEditable(false);
		Supplier_name.setColumns(10);
		Supplier_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Supplier_name.setBackground(new Color(255, 255, 204));
		Supplier_name.setBounds(125, 142, 160, 23);
		contentPane.add(Supplier_name);
		
		JLabel supplier_company = new JLabel("Supplier Company");
		supplier_company.setForeground(new Color(0, 0, 51));
		supplier_company.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		supplier_company.setBounds(295, 120, 141, 14);
		contentPane.add(supplier_company);
		
		Supplier_company = new JTextField();
		Supplier_company.setForeground(new Color(0, 0, 51));
		Supplier_company.setFont(new Font("Garamond", Font.BOLD, 16));
		Supplier_company.setEditable(false);
		Supplier_company.setColumns(10);
		Supplier_company.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Supplier_company.setBackground(new Color(255, 255, 204));
		Supplier_company.setBounds(295, 142, 160, 23);
		contentPane.add(Supplier_company);
		
		Contact_no = new JTextField();
		Contact_no.setForeground(new Color(0, 0, 51));
		Contact_no.setFont(new Font("Garamond", Font.BOLD, 16));
		Contact_no.setEditable(false);
		Contact_no.setColumns(10);
		Contact_no.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Contact_no.setBackground(new Color(255, 255, 204));
		Contact_no.setBounds(295, 218, 160, 23);
		contentPane.add(Contact_no);
		
		JLabel contact_no = new JLabel("Contact No.");
		contact_no.setForeground(new Color(0, 0, 51));
		contact_no.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		contact_no.setBounds(292, 195, 96, 14);
		contentPane.add(contact_no);
		
		Email = new JTextField();
		Email.setForeground(new Color(0, 0, 51));
		Email.setFont(new Font("Garamond", Font.BOLD, 16));
		Email.setEditable(false);
		Email.setColumns(10);
		Email.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Email.setBackground(new Color(255, 255, 204));
		Email.setBounds(31, 218, 254, 23);
		contentPane.add(Email);
		
		JLabel email = new JLabel("Email");
		email.setForeground(new Color(0, 0, 51));
		email.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		email.setBounds(31, 195, 46, 14);
		contentPane.add(email);
		
		JLabel date = new JLabel("Order Date");
		date.setForeground(new Color(0, 0, 51));
		date.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		date.setBounds(30, 72, 125, 20);
		contentPane.add(date);
		
		JLabel order_no = new JLabel("Order No.");
		order_no.setForeground(new Color(0, 0, 51));
		order_no.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		order_no.setBounds(265, 72, 107, 20);
		contentPane.add(order_no);
		
		Order_no.setHorizontalAlignment(SwingConstants.RIGHT);
		Order_no.setForeground(new Color(0, 0, 51));
		Order_no.setFont(new Font("Garamond", Font.BOLD, 19));
		Order_no.setEditable(false);
		Order_no.setColumns(10);
		Order_no.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Order_no.setBackground(new Color(255, 255, 204));
		Order_no.setBounds(365, 71, 90, 23);
		contentPane.add(Order_no);
		
		Date.setHorizontalAlignment(SwingConstants.RIGHT);
		Date.setForeground(new Color(0, 0, 51));
		Date.setFont(new Font("Garamond", Font.BOLD, 19));
		Date.setEditable(false);
		Date.setColumns(10);
		Date.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Date.setBackground(new Color(255, 255, 204));
		Date.setBounds(143, 71, 96, 23);
		contentPane.add(Date);
		
		Amount = new JTextField();
		Amount.setHorizontalAlignment(SwingConstants.RIGHT);
		Amount.setForeground(new Color(0, 0, 51));
		Amount.setFont(new Font("Garamond", Font.BOLD, 16));
		Amount.setColumns(5);
		Amount.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Amount.setBackground(new Color(255, 255, 204));
		Amount.setBounds(214, 273, 241, 35);
		contentPane.add(Amount);
		
		JLabel amount = new JLabel("Amount");
		amount.setForeground(new Color(0, 0, 51));
		amount.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		amount.setBounds(214, 252, 241, 14);
		contentPane.add(amount);
		
		Bill_no = new JTextField();
		Bill_no.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Amount.grabFocus();
				}
			}
		});
		Bill_no.setHorizontalAlignment(SwingConstants.RIGHT);
		Bill_no.setForeground(new Color(0, 0, 51));
		Bill_no.setFont(new Font("Garamond", Font.BOLD, 16));
		Bill_no.setColumns(5);
		Bill_no.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Bill_no.setBackground(new Color(255, 255, 204));
		Bill_no.setBounds(31, 273, 173, 35);
		contentPane.add(Bill_no);
		
		JLabel bill_no = new JLabel("Bill No.");
		bill_no.setForeground(new Color(0, 0, 51));
		bill_no.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		bill_no.setBounds(31, 252, 107, 14);
		contentPane.add(bill_no);
		
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
	}
}