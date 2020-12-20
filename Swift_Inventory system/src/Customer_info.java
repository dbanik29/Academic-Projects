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
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class Customer_info extends JFrame {
	Connection connection=null;
	JLabel user_id = new JLabel("");
	
	public static class MyActionListener10 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
        
        	if(CustomerID.getText().equals("")){
        		
        	}
        	else{
        		if(CustomerID.getText().length()==5){
            		message1.setText("OK");
            	}
            	else{
            		message1.setText("Not OK");
            	}
        	}
        	if(Confirm.getText().equals("")){
        		
        	}
        	else{
        		if(Confirm.getText().equals(Password.getText())){
    				message.setText("Password Match");
    			}
    			else{
    				message.setText("Password not Match");
    			}
        	}
        }
	}
	
	static Timer time10=new Timer(10,new MyActionListener10());
	private JPanel contentPane;
	JLabel avater = new JLabel("");
	JLabel avater_drop = new JLabel("");
	JLabel avater_drop1 = new JLabel("");
	JLabel avater_drop2 = new JLabel("");
	static JLabel message = new JLabel("");
	static String Time;
	String hour,min,sec;
	String status="no";
	int i=1;
	int j=1;
	int k=1;
	int k2=1;
	int l2=1;
	int l=1;
	int h=1;
	int s=1;
	int name=1;
	 JLabel nav_top = new JLabel("");
	JLabel swift_logo = new JLabel("");
	String companyID="011151";
	 public JTextField Title = new JTextField();
	 public JTextField First_name = new JTextField();
	 public JTextField Middle_name = new JTextField();
	 public JTextField Last_name = new JTextField();
	 public JTextField Suffix = new JTextField();
	 static public JTextField CustomerID = new JTextField();
	 public JTextField Email = new JTextField();
	 public static JPasswordField Password = new JPasswordField();
	 public static JPasswordField Confirm = new JPasswordField();
	 public JTextField Phone = new JTextField();
	 public JTextField Mobile = new JTextField();
	 public JTextField Fax = new JTextField();
	 public JTextField Other = new JTextField();
	 public JTextField Website = new JTextField();
	 
	 public JTextField Street1 = new JTextField();
	 public JTextField City1 = new JTextField();
	 public JTextField State1 = new JTextField();
	 public JTextField Postal1 = new JTextField();
	 public JTextField Country1 = new JTextField();
	 public JTextField Street2 = new JTextField();
	 public JTextField City2 = new JTextField();
	 public JTextField State2 = new JTextField();
	 public JTextField Postal2 = new JTextField();
	 public JTextField Country2 = new JTextField();
	 public JComboBox payment = new JComboBox();
	 public JComboBox shipping = new JComboBox();
	 public JLabel Edit = new JLabel("Customer");
	 public static JLabel message1 = new JLabel("");
	   JLabel border = new JLabel("Name");
	   JLabel help = new JLabel("");
	   JLabel search = new JLabel("");
	    JTextField search_box = new JTextField();
	    
	
	    static Customer_info frame = new Customer_info();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					time10.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private ObservingTextField dateText;
	private JTextField Company_name;
	private final JLabel message2 = new JLabel("");
	private final JLabel cross = new JLabel("");
	private final JLabel saves = new JLabel("");
	
	
    public void customer(String value){
    	try{
			CustomerID.setText(value);
			String query="SELECT * FROM Customer_info Where Customer_id='"+CustomerID.getText()+"'";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			
			CustomerID.setText(rs.getString("Customer_id"));
			Company_name.setText(rs.getString("Company_name"));
			Title.setText(rs.getString("Title"));
			First_name.setText(rs.getString("First_Name"));
			Middle_name.setText(rs.getString("Middle_Name"));
			Last_name.setText(rs.getString("Last_Name"));
			Suffix.setText(rs.getString("Suffix"));
			Email.setText(rs.getString("Email"));
			Phone.setText(rs.getString("phone_num"));
			Password.setText(rs.getString("password"));
			Mobile.setText(rs.getString("mobile"));
			Fax.setText(rs.getString("fax"));
			Other.setText(rs.getString("Other"));
			Website.setText(rs.getString("Website"));
			
			payment.setSelectedIndex(1);
			
			shipping.setSelectedIndex(0);
		
			pst.close();
			rs.close();

			String query2="SELECT * FROM Customer_address Where Customer_id='"+CustomerID.getText()+"' and Status='Billing'";
			PreparedStatement pst2=connection.prepareStatement(query2);
			ResultSet rs2=pst2.executeQuery();
			rs2.next();
			
			Street1.setText(rs2.getString("Street"));
			City1.setText(rs2.getString("City_Town"));
			State1.setText(rs2.getString("State__Province"));
			Postal1.setText(rs2.getString("Postal_Code"));
			Country1.setText(rs2.getString("Country"));
		
			pst2.close();
			rs2.close();

			String query3="SELECT * FROM Customer_address Where Customer_id='"+CustomerID.getText()+"' and Status='Shipping'";
			PreparedStatement pst3=connection.prepareStatement(query3);
			ResultSet rs3=pst3.executeQuery();
			rs3.next();
			
			Street2.setText(rs3.getString("Street"));
			City2.setText(rs3.getString("City_Town"));
			State2.setText(rs3.getString("State__Province"));
			Postal2.setText(rs3.getString("Postal_Code"));
			Country2.setText(rs3.getString("Country"));
		
			pst3.close();
			rs3.close();
			//JOptionPane.showMessageDialog(null, "Show");
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
    }
    
	public Customer_info() {
		connection =DatabaseConnect.DBConnectors();
		
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	         
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		Title.setForeground(new Color(0, 0, 51));
		Title.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Title.setBackground(new Color(255, 255, 204));
		Title.setBounds(31, 127, 80, 23);
		Title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Title.setColumns(10);
		First_name.setForeground(new Color(0, 0, 51));
		First_name.setFont(new Font("Garamond", Font.BOLD, 16));
		
		First_name.setBackground(new Color(255, 255, 204));
		First_name.setBounds(121, 127, 120, 23);
		First_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		First_name.setColumns(10);
		Middle_name.setForeground(new Color(0, 0, 51));
		Middle_name.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Middle_name.setBackground(new Color(255, 255, 204));
		Middle_name.setBounds(251, 127, 120, 23);
		Middle_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Middle_name.setColumns(10);
		Last_name.setForeground(new Color(0, 0, 51));
		Last_name.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Last_name.setBackground(new Color(255, 255, 204));
		Last_name.setBounds(381, 127, 120, 23);
		Last_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Last_name.setColumns(10);
		Suffix.setForeground(new Color(0, 0, 51));
		Suffix.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Suffix.setBackground(new Color(255, 255, 204));
		Suffix.setBounds(511, 127, 80, 23);
		Suffix.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Suffix.setColumns(10);
		CustomerID.setEditable(false);
		CustomerID.setForeground(new Color(0, 0, 51));
		CustomerID.setFont(new Font("Garamond", Font.BOLD, 16));
		
		CustomerID.setBackground(new Color(255, 255, 204));
		CustomerID.setBounds(31, 194, 120, 23);
		CustomerID.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		CustomerID.setColumns(10);
		Email.setForeground(new Color(0, 0, 51));
		Email.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Email.setBackground(new Color(255, 255, 204));
		Email.setBounds(31, 261, 560, 23);
		Email.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Email.setColumns(10);
		Password.setForeground(new Color(0, 0, 51));
		Password.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Password.setBackground(new Color(255, 255, 204));
		Password.setBounds(30, 330, 190, 23);
		Password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Password.setColumns(10);
		Confirm.setForeground(new Color(0, 0, 51));
		Confirm.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Confirm.setBackground(new Color(255, 255, 204));
		Confirm.setBounds(240, 330, 190, 23);
		Confirm.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Confirm.setColumns(10);
		
		Phone.setForeground(new Color(0, 0, 51));
		Phone.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Phone.setBackground(new Color(255, 255, 204));
		Phone.setBounds(30, 400, 173, 23);
		Phone.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Phone.setColumns(10);
		Mobile.setForeground(new Color(0, 0, 51));
		Mobile.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Mobile.setBackground(new Color(255, 255, 204));
		Mobile.setBounds(221, 400, 176, 23);
		Mobile.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Mobile.setColumns(10);
		Fax.setForeground(new Color(0, 0, 51));
		Fax.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Fax.setBackground(new Color(255, 255, 204));
		Fax.setBounds(413, 400, 178, 23);
		Fax.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Fax.setColumns(10);
		Other.setForeground(new Color(0, 0, 51));
		Other.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Other.setBackground(new Color(255, 255, 204));
		Other.setBounds(30, 469, 174, 23);
		Other.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Other.setColumns(10);
		Website.setForeground(new Color(0, 0, 51));
		Website.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Website.setBackground(new Color(255, 255, 204));
		Website.setBounds(224, 469, 367, 23);
		Website.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Website.setColumns(10);
		Street1.setForeground(new Color(0, 0, 51));
		Street1.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Street1.setBackground(new Color(255, 255, 204));
		Street1.setBounds(635, 166, 385, 23);
		Street1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Street1.setColumns(10);
		City1.setForeground(new Color(0, 0, 51));
		City1.setFont(new Font("Garamond", Font.BOLD, 16));
		
		City1.setBackground(new Color(255, 255, 204));
		City1.setBounds(635, 233, 185, 23);
		City1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		City1.setColumns(10);
		State1.setForeground(new Color(0, 0, 51));
		State1.setFont(new Font("Garamond", Font.BOLD, 16));
		
		State1.setBackground(new Color(255, 255, 204));
		State1.setBounds(830, 233, 190, 23);
		State1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		State1.setColumns(10);
		Postal1.setForeground(new Color(0, 0, 51));
		Postal1.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Postal1.setBackground(new Color(255, 255, 204));
		Postal1.setBounds(635, 300, 185, 23);
		Postal1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Postal1.setColumns(10);
		Country1.setForeground(new Color(0, 0, 51));
		Country1.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Country1.setBackground(new Color(255, 255, 204));
		Country1.setBounds(830, 300, 190, 23);
		Country1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Country1.setColumns(10);
		Street2.setForeground(new Color(0, 0, 51));
		Street2.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Street2.setBackground(new Color(255, 255, 204));
		Street2.setBounds(635, 444, 385, 23);
		Street2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Street2.setColumns(10);
		City2.setForeground(new Color(0, 0, 51));
		City2.setFont(new Font("Garamond", Font.BOLD, 16));
		
		City2.setBackground(new Color(255, 255, 204));
		City2.setBounds(635, 514, 185, 23);
		City2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		City2.setColumns(10);
		State2.setForeground(new Color(0, 0, 51));
		State2.setFont(new Font("Garamond", Font.BOLD, 16));
		
		State2.setBackground(new Color(255, 255, 204));
		State2.setBounds(830, 514, 190, 23);
		State2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		State2.setColumns(10);
		Postal2.setForeground(new Color(0, 0, 51));
		Postal2.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Postal2.setBackground(new Color(255, 255, 204));
		Postal2.setBounds(635, 584, 185, 23);
		Postal2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Postal2.setColumns(10);
		Country2.setForeground(new Color(0, 0, 51));
		Country2.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Country2.setBackground(new Color(255, 255, 204));
		Country2.setBounds(830, 584, 190, 23);
		Country2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Country2.setColumns(10);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 1050, 647);
		setShape(new RoundRectangle2D.Double(00, 00, 1050, 647, 50, 0));
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getSize().height; //get the heigth of the frame
        int framelocationX=(dim.width-framewidth)/2; 
        int framelocationY=(dim.height-frameheigth)/2;
        this.setLocation(framelocationX,framelocationY);
		
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new CompoundBorder(new MatteBorder(0, 5, 5, 5, (Color) new Color(109, 109, 109)), new MatteBorder(0, 5, 5, 5, (Color) new Color(0, 0, 51))));
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
		cross.setIcon(new ImageIcon(Customer_info.class.getResource("/img/cross1.png")));
		cross.setBounds(0, 0, 60, 60);
		
		contentPane.add(cross);
		saves.setIcon(new ImageIcon(Customer_info.class.getResource("/img/saves1.png")));
		saves.setBounds(990, 0, 60, 60);
		
		contentPane.add(saves);
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
		Edit.setForeground(Color.WHITE);
		Edit.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		Edit.setBounds(210, 17, 361, 28);
		
		contentPane.add(Edit);
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(78, 12, 107, 35);
		
		contentPane.add(swift_logo);
		nav_top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/nav_top.png")));
		nav_top.setBounds(0, 0, 200, 60);
		
		contentPane.add(nav_top);
		
		JLabel top = new JLabel("");
		top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/top.png")));
		top.setEnabled(false);
		top.setBounds(0, 0, 1300, 60);
		contentPane.add(top);
		
		
		saves.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					saves.setIcon(new ImageIcon(Dashboard.class.getResource("/img/saves3.png")));
					if(Edit.getText()=="Create New Customer"){
						
						if(CustomerID.getText().equals("")&&Title.getText().equals("")&&First_name.getText().equals("")&&Middle_name.getText().equals("")||Last_name.getText().equals("")||Phone.getText().equals("")||Password.getText().equals("")||Street1.getText().equals("")||City1.getText().equals("")||State1.getText().equals("")||Postal1.getText().equals("")||Country1.getText().equals("")||Street2.getText().equals("")||City2.getText().equals("")||State2.getText().equals("")||Postal2.getText().equals("")||Country2.getText().equals(""))
						{
							message2.setText("Please fillup all textfield");
						}
						else{	
							try{
							String query="insert into Customer_info(Customer_id,Company_name,Title,First_Name,Middle_Name,Last_Name,Suffix,Email,phone_num,password,Mobile,Fax,Other,website,Preffered_payment,Shipping_Way)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
							
							PreparedStatement pst=connection.prepareStatement(query);
							
							pst.setString(1, CustomerID.getText());
							pst.setString(2, Company_name.getText());
							pst.setString(3, Title.getText());
							pst.setString(4, First_name.getText());
							pst.setString(5, Middle_name.getText());
							pst.setString(6, Last_name.getText());
							pst.setString(7, Suffix.getText());
							pst.setString(8, Email.getText());
							pst.setString(9, Phone.getText());
							pst.setString(10, Password.getText());
							pst.setString(11, Mobile.getText());
							pst.setString(12, Fax.getText());
							pst.setString(13, Other.getText());
							pst.setString(14, Website.getText());
							pst.setString(15, payment.getSelectedItem().toString());
							pst.setString(16, shipping.getSelectedItem().toString());
							pst.execute();
							pst.close();
							
							String query1="insert into Customer_address(Customer_id,Street, City_Town,State__Province,Postal_Code,Country,Status)  values(?,?,?,?,?,?,?) ";
							
							PreparedStatement pst1=connection.prepareStatement(query1);
							
							pst1.setString(1, CustomerID.getText());
							pst1.setString(2, Street1.getText());
							pst1.setString(3, City1.getText());
							pst1.setString(4, State1.getText());
							pst1.setString(5, Postal1.getText());
							pst1.setString(6, Country1.getText());
							pst1.setString(7, "Billing");
							pst1.execute();
							pst1.close();
							String query2="insert into Customer_address(Customer_id,Street, City_Town,State__Province,Postal_Code,Country,Status)  values(?,?,?,?,?,?,?) ";
							
							PreparedStatement pst2=connection.prepareStatement(query2);
							
							pst2.setString(1, CustomerID.getText());
							pst2.setString(2, Street2.getText());
							pst2.setString(3, City2.getText());
							pst2.setString(4, State2.getText());
							pst2.setString(5, Postal2.getText());
							pst2.setString(6, Country2.getText());
							pst2.setString(7, "Shipping");
							pst2.execute();
							pst2.close();
							pst2.close();
							
							setVisible(false); //you can't see me!
							dispose(); //Destroy the JFrame object
							time10.stop();
							
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Successfully Create");
							Customer.frame.refresh_table();
						}
						catch(Exception e1){
							//JOptionPane.showMessageDialog(null, "Quantity Get");
							e1.printStackTrace();
						}
						}
					}
					else{
						try{
							String q1="update  Customer_info set Company_name='"+Company_name.getText()+"',Title='"+Title.getText()+"', First_Name='"+First_name.getText()+"',";
							String q2="Middle_Name='"+Middle_name.getText()+"', Last_Name='"+Last_name.getText()+"', Suffix='"+Suffix.getText()+"',";		
							String q3="email='"+Email.getText()+"', phone_num='"+Phone.getText()+"',password='"+Password.getText()+"', mobile='"+Mobile.getText()+"',";
							String q4="Fax='"+Fax.getText()+"', Other='"+Other.getText()+"', Website='"+Website.getText()+"', Preffered_payment='"+payment.getSelectedItem().toString()+"', Shipping_Way='"+shipping.getSelectedItem().toString()+"'";
							String q5="where Customer_id='"+CustomerID.getText()+"' ";
							
							PreparedStatement pst=connection.prepareStatement(q1+q2+q3+q4+q5);
							
							pst.execute();
							pst.close();
							
							String e12="update  Customer_address set  Street='"+Street1.getText()+"', City_Town='"+City1.getText()+"',";
							String e22="State__Province='"+State1.getText()+"', Postal_Code='"+Postal1.getText()+"', Country='"+Country1.getText()+"'";		
							
							String e42="where Customer_id='"+CustomerID.getText()+"' and Status='Billing'";
							
							PreparedStatement pst3=connection.prepareStatement(e12+e22+e42);
							
							
							pst3.execute();
							pst3.close();
							
							String e13="update  Customer_address set  Street='"+Street2.getText()+"', City_Town='"+City2.getText()+"',";
							String e23="State__Province='"+State2.getText()+"', Postal_Code='"+Postal2.getText()+"', Country='"+Country2.getText()+"'";		
							
							String e43="where Customer_ID='"+CustomerID.getText()+"' and Status='Shipping'";
							
							PreparedStatement pst4=connection.prepareStatement(e13+e23+e43);
							
							pst4.execute();
							pst4.close();
							setVisible(false); //you can't see me!
							dispose(); //Destroy the JFrame object
							time10.stop();
							
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Successfully Update");
							Customer.frame.refresh_table();
							
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
		
		cross.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					cross.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cross3.png")));
					setVisible(false);
					dispose();
					
					time10.stop();
					
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
		avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
		avater_drop2.setBounds(1140, -10, 160, 41);
		contentPane.add(avater_drop2);
		
		avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
		avater_drop2.setBounds(1140, -10, 160, 41);
		contentPane.add(avater_drop2);
		border.setFont(new Font("Tahoma", Font.ITALIC, 15));
		border.setForeground(SystemColor.textInactiveText);
		border.setBounds(382, -171, 72, 17);
		
		contentPane.add(border);
		contentPane.add(Title);
		contentPane.add(First_name);
		contentPane.add(Middle_name);
		contentPane.add(Last_name);
		contentPane.add(Suffix);
		contentPane.add(CustomerID);
		contentPane.add(Email);
		contentPane.add(Password);
		contentPane.add(Confirm);
		contentPane.add(Phone);
		contentPane.add(Mobile);
		contentPane.add(Fax);
		contentPane.add(Other);
		contentPane.add(Website);
		contentPane.add(Street1);
		contentPane.add(City1);
		contentPane.add(State1);
		contentPane.add(Postal1);
		contentPane.add(Country1);
		contentPane.add(Street2);
		contentPane.add(City2);
		contentPane.add(State2);
		contentPane.add(Postal2);
		contentPane.add(Country2);
		
		JLabel title = new JLabel("Title");
		title.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		title.setBounds(31, 103, 60, 14);
		contentPane.add(title);
		
		JLabel first_name = new JLabel("First Name");
		first_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		first_name.setBounds(121, 103, 90, 14);
		contentPane.add(first_name);
		
		JLabel middle_name = new JLabel("Middle Name");
		middle_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		middle_name.setBounds(251, 103, 96, 14);
		contentPane.add(middle_name);
		
		JLabel last_name = new JLabel("Last Name");
		last_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		last_name.setBounds(381, 103, 76, 14);
		contentPane.add(last_name);
		
		JLabel suffix = new JLabel("Suffix");
		suffix.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		suffix.setBounds(511, 103, 46, 14);
		contentPane.add(suffix);
		
		JLabel billing = new JLabel("Billing Address");
		billing.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		billing.setBounds(635, 95, 185, 25);
		contentPane.add(billing);
		
		JLabel prefered_payment = new JLabel("Prefered Payment");
		prefered_payment.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		prefered_payment.setBounds(30, 511, 132, 14);
		contentPane.add(prefered_payment);
		
		JLabel ship = new JLabel("Shipping Address");
		ship.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		ship.setBounds(635, 334, 231, 25);
		contentPane.add(ship);
		
		JLabel customerId = new JLabel("Customer ID");
		customerId.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		customerId.setBounds(31, 170, 120, 14);
		contentPane.add(customerId);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		email.setBounds(31, 237, 46, 14);
		contentPane.add(email);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		password.setBounds(30, 306, 121, 14);
		contentPane.add(password);
		
		JLabel confirm = new JLabel("Confirm Password");
		confirm.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		confirm.setBounds(240, 306, 132, 14);
		contentPane.add(confirm);
		
		JLabel shipping_via = new JLabel("Shipping Via");
		shipping_via.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		shipping_via.setBounds(340, 511, 146, 14);
		contentPane.add(shipping_via);
		
		JLabel phone = new JLabel("Phone");
		phone.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		phone.setBounds(30, 373, 46, 14);
		contentPane.add(phone);
		
		JLabel mobile = new JLabel("Mobile");
		mobile.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		mobile.setBounds(221, 373, 98, 14);
		contentPane.add(mobile);
		
		JLabel fax = new JLabel("Fax");
		fax.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		fax.setBounds(413, 373, 46, 14);
		contentPane.add(fax);
		
		JLabel other = new JLabel("Other");
		other.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		other.setBounds(30, 448, 107, 14);
		contentPane.add(other);
		
		JLabel website = new JLabel("Website");
		website.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		website.setBounds(224, 448, 100, 14);
		contentPane.add(website);
		
		JLabel street1 = new JLabel("Street");
		street1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		street1.setBounds(637, 142, 46, 14);
		contentPane.add(street1);
		
		JLabel city1 = new JLabel("City/Town");
		city1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		city1.setBounds(635, 209, 90, 14);
		contentPane.add(city1);
		
		JLabel state1 = new JLabel("State/Province");
		state1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		state1.setBounds(830, 209, 149, 14);
		contentPane.add(state1);
		
		JLabel postal1 = new JLabel("Postal Code");
		postal1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		postal1.setBounds(635, 276, 96, 14);
		contentPane.add(postal1);
		
		JLabel country1 = new JLabel("Country");
		country1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		country1.setBounds(830, 276, 96, 14);
		contentPane.add(country1);
		
		JLabel street2 = new JLabel("Street");
		street2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		street2.setBounds(637, 410, 46, 14);
		contentPane.add(street2);
		
		JLabel city2 = new JLabel("City/Town");
		city2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		city2.setBounds(635, 487, 90, 14);
		contentPane.add(city2);
		
		JLabel state2 = new JLabel("State/Province");
		state2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		state2.setBounds(830, 487, 149, 14);
		contentPane.add(state2);
		
		JLabel postal2 = new JLabel("Postal Code");
		postal2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		postal2.setBounds(635, 563, 96, 14);
		contentPane.add(postal2);
		
		JLabel country2 = new JLabel("Country");
		country2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		country2.setBounds(830, 563, 96, 14);
		contentPane.add(country2);
		payment.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Chaque", "COD", "Bank"}));
		payment.setBackground(new Color(255, 255, 204));
		payment.setFont(new Font("Garamond", Font.BOLD, 16));
		payment.setBounds(30, 539, 215, 24);
		contentPane.add(payment);
		payment.addItem("Cash");
		payment.addItem("Chaque");
		payment.addItem("COD");
		payment.addItem("Bank Transfer");
		shipping.setBackground(new Color(255, 255, 204));
		shipping.setFont(new Font("Garamond", Font.BOLD, 16));
		shipping.setBounds(340, 539, 215, 24);
		contentPane.add(shipping);
		shipping.addItem("S A Paribahan");
		shipping.addItem("Jononi Parsel");
		shipping.addItem("Sundarban");
		shipping.addItem("Ahamed");
		
		JCheckBox chckbxSameAsBilling = new JCheckBox("Same as Billing Address");
		chckbxSameAsBilling.setBackground(new Color(255, 255, 204));
		chckbxSameAsBilling.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(i%2!=0){
				
				Street2.setText(Street1.getText());
				City2.setText(City1.getText());
				State2.setText(State1.getText());
				Postal2.setText(Postal1.getText());
				Country2.setText(Country1.getText());
				i=2;
				}
				
				else if(i%2==0){
					
					Street2.setText("");
					City2.setText("");
					State2.setText("");
					Postal2.setText("");
					Country2.setText("");
					i=1;
					}
			}
		});
		chckbxSameAsBilling.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		chckbxSameAsBilling.setBounds(635, 373, 215, 23);
		contentPane.add(chckbxSameAsBilling);
		
		JLabel cus_company = new JLabel("Company Name");
		cus_company.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		cus_company.setBounds(266, 170, 120, 14);
		contentPane.add(cus_company);
		
		Company_name = new JTextField();
		Company_name.setForeground(new Color(0, 0, 51));
		Company_name.setFont(new Font("Garamond", Font.BOLD, 16));
		Company_name.setColumns(10);
		Company_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Company_name.setBackground(new Color(255, 255, 204));
		Company_name.setBounds(266, 194, 325, 23);
		contentPane.add(Company_name);
		
		
		message.setForeground(Color.RED);
		message.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		message.setBounds(440, 334, 151, 20);
		contentPane.add(message);
		message1.setForeground(new Color(0, 0, 51));
		message1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		message1.setBounds(161, 198, 96, 20);
		
		contentPane.add(message1);
		message2.setForeground(Color.RED);
		message2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		message2.setBounds(31, 579, 170, 28);
		
		contentPane.add(message2);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
		
	}
	
}