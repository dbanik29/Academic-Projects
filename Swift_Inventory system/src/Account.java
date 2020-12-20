import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.qt.datapicker.DatePicker;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;

public class Account extends JFrame {
	Connection connection=null;
	
	private JPanel contentPane;
	JLabel user_id = new JLabel("");
	
	
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
	 JLabel nav_top = new JLabel("");
	JLabel swift_logo = new JLabel("");
	String companyID="011151";
	 public JTextField Owner_name = new JTextField();
	 
	 public JTextField CompanyID = new JTextField();
	 public JTextField Company = new JTextField();
	 public JTextField Type_company = new JTextField();
	 public JTextField Type_account = new JTextField();
	 public JTextField Email = new JTextField();
	 public JTextField Gender = new JTextField();
	 public JTextField Birthday = new JTextField();
	 public JTextField Phone = new JTextField();
	 public JTextField Mobile = new JTextField();
	 public JTextField Fax = new JTextField();
	 public JTextField Other = new JTextField();
	 public JTextField Website = new JTextField();
	 
	 public JTextArea Address1 = new JTextArea();
	 public JTextArea Address2 = new JTextArea();
	 
	 
	 
	 
	   JLabel border = new JLabel("Name");
	   JLabel edits = new JLabel("");
	    JTextField search_box = new JTextField();
	    
	/**
	 * Launch the application.
	 */
	    static Account frame = new Account();
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
	private final JLabel address2 = new JLabel("Address 2");
	private final JLabel edit = new JLabel("Account");
	private final JLabel cross = new JLabel("");
	private Locale getLocale(String loc){
		if(loc!=null && loc.length()>0){
			return new Locale(loc);
		}
		else{
			return Locale.US;
		}
	};
	 // cell must be displayed.
    class MyTableCellRenderer extends JLabel implements TableCellRenderer {
        // This method is called each time a cell in a column
        // using this renderer needs to be rendered.
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {
            // 'value' is value contained in the cell located at
            // (rowIndex, vColIndex)

            if (isSelected) {
                // cell (and perhaps other cells) are selected

            }

            if (hasFocus) {
                // this cell is the anchor and the table has the focus
                this.setBackground(Color.blue);
                this.setForeground(Color.green);
            } else {
                this.setForeground(Color.black);
            }

            // Configure the component with the specified value
            setText(value.toString());

            // Set tool tip if desired
            // setToolTipText((String)value);

            // Since the renderer is a component, return itself
            return this;
        }

        // The following methods override the defaults for performance reasons
        public void validate() {}
        public void revalidate() {}
        protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {}
        public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {}
    }
	/**
	 * Create the frame.
	 */
    
    public void profile(String account){
    	CompanyID.setText(account);
    	try{
			System.out.println(CompanyID);
			String query="SELECT * FROM Company_info Where Company_ID='"+CompanyID.getText()+"'";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			
			Company.setText(rs.getString("Company_name"));
			Owner_name.setText(rs.getString("Owner_Title")+" "+rs.getString("Owner_First_name")+" "+rs.getString("Owner_Middle_name")+" "+rs.getString("Owner_Last_name"));
			
			Type_company.setText(rs.getString("Company_type"));
			Type_account.setText(rs.getString("Account_type"));
			Email.setText(rs.getString("Email"));
			Phone.setText(rs.getString("Phone_number"));
			Mobile.setText(rs.getString("Mobile"));
			Fax.setText(rs.getString("Fax"));
			Other.setText(rs.getString("Others"));
			Website.setText(rs.getString("Website"));
			
			pst.close();
			rs.close();

			String query2="SELECT * FROM Company_address Where Company_ID='"+CompanyID.getText()+"' and Status='Address1'";
			PreparedStatement pst2=connection.prepareStatement(query2);
			ResultSet rs2=pst2.executeQuery();
			rs2.next();
			
			Address1.setText(rs2.getString("Street")+", "+rs2.getString("City_Town")+", "+rs2.getString("State__Province")+"\n"+rs2.getString("Postal_Code")+" "+rs2.getString("Country"));
			pst2.close();
			rs2.close();

			String query3="SELECT * FROM Company_address Where Company_ID='"+CompanyID.getText()+"' and Status='Address2'";
			PreparedStatement pst3=connection.prepareStatement(query3);
			ResultSet rs3=pst3.executeQuery();
			rs3.next();
			
			Address2.setText(rs3.getString("Street")+", "+rs3.getString("City_Town")+", "+rs3.getString("State__Province")+"\n"+rs3.getString("Postal_Code")+" "+rs3.getString("Country"));
		
			pst3.close();
			rs3.close();
			
			String query4="SELECT * FROM Employee_info Where Company_ID='"+CompanyID.getText()+"'";
			PreparedStatement pst4=connection.prepareStatement(query4);
			ResultSet rs4=pst4.executeQuery();
			rs4.next();
			
			Gender.setText(rs4.getString("Gender"));
			Birthday.setText(rs4.getString("Date_of_Birth"));
			
			pst4.close();
			rs4.close();
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
    }
	public Account() {
		connection =DatabaseConnect.DBConnectors();
		
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	         
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		Owner_name.setEditable(false);
		Owner_name.setForeground(new Color(25, 25, 112));
		Owner_name.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Owner_name.setBackground(SystemColor.menu);
		Owner_name.setBounds(42, 105, 560, 23);
		Owner_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Owner_name.setColumns(10);
		CompanyID.setEditable(false);
		CompanyID.setForeground(new Color(25, 25, 112));
		CompanyID.setFont(new Font("Garamond", Font.BOLD, 16));
		
		CompanyID.setBackground(SystemColor.menu);
		CompanyID.setBounds(42, 172, 120, 23);
		CompanyID.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		CompanyID.setColumns(10);
		Company.setEditable(false);
		Company.setForeground(new Color(25, 25, 112));
		Company.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Company.setBackground(SystemColor.menu);
		Company.setBounds(172, 172, 430, 23);
		Company.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Company.setColumns(10);
		Type_company.setEditable(false);
		Type_company.setForeground(new Color(25, 25, 112));
		Type_company.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Type_company.setBackground(SystemColor.menu);
		Type_company.setBounds(42, 239, 261, 23);
		Type_company.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Type_company.setColumns(10);
		Type_account.setEditable(false);
		Type_account.setForeground(new Color(25, 25, 112));
		Type_account.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Type_account.setBackground(SystemColor.menu);
		Type_account.setBounds(314, 239, 289, 23);
		Type_account.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Type_account.setColumns(10);
		Email.setEditable(false);
		Email.setForeground(new Color(25, 25, 112));
		Email.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Email.setBackground(SystemColor.menu);
		Email.setBounds(42, 306, 261, 23);
		Email.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Email.setColumns(10);
		Gender.setEditable(false);
		Gender.setForeground(new Color(25, 25, 112));
		Gender.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Gender.setBackground(SystemColor.menu);
		Gender.setBounds(480, 307, 122, 23);
		Gender.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Gender.setColumns(10);
		Birthday.setEditable(false);
		Birthday.setForeground(new Color(25, 25, 112));
		Birthday.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Birthday.setBackground(SystemColor.menu);
		Birthday.setBounds(314, 307, 156, 23);
		Birthday.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Birthday.setColumns(10);
		Phone.setEditable(false);
		Phone.setForeground(new Color(25, 25, 112));
		Phone.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Phone.setBackground(SystemColor.menu);
		Phone.setBounds(40, 380, 173, 23);
		Phone.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Phone.setColumns(10);
		Mobile.setEditable(false);
		Mobile.setForeground(new Color(25, 25, 112));
		Mobile.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Mobile.setBackground(SystemColor.menu);
		Mobile.setBounds(231, 380, 176, 23);
		Mobile.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Mobile.setColumns(10);
		Fax.setEditable(false);
		Fax.setForeground(new Color(25, 25, 112));
		Fax.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Fax.setBackground(SystemColor.menu);
		Fax.setBounds(423, 380, 178, 23);
		Fax.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Fax.setColumns(10);
		Other.setEditable(false);
		Other.setForeground(new Color(25, 25, 112));
		Other.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Other.setBackground(SystemColor.menu);
		Other.setBounds(40, 450, 259, 23);
		Other.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Other.setColumns(10);
		Website.setEditable(false);
		Website.setForeground(new Color(25, 25, 112));
		Website.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Website.setBackground(SystemColor.menu);
		Website.setBounds(313, 450, 289, 23);
		Website.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Website.setColumns(10);
		Address1.setEditable(false);
		Address1.setForeground(new Color(25, 25, 112));
		Address1.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Address1.setBackground(SystemColor.menu);
		Address1.setBounds(42, 528, 560, 50);
		Address1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Address1.setColumns(10);
		Address2.setEditable(false);
		Address2.setForeground(new Color(25, 25, 112));
		Address2.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Address2.setBackground(SystemColor.menu);
		Address2.setBounds(42, 620, 560, 50);
		Address2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Address2.setColumns(10);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 642, 710);
		setShape(new RoundRectangle2D.Double(00, 00, 642, 710, 50, 0));
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
			/*	if(txtName.getText()=="Name"){
					txtName.setText("");
					txtName.setBackground(new Color(240, 245, 255));
					
					}
					else{
						if(txtName.getText()!=""){
							txtName.setText("");
						txtName.setBackground(new Color(240, 245, 255));
						border.setForeground(SystemColor.desktop);
						border.setBounds(382, -175, 51, 14);
						}
						
					}*/
			
				
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				
				
			}
		});
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new CompoundBorder(new MatteBorder(0, 5, 5, 5, (Color) new Color(100, 100, 100)), new MatteBorder(0, 5, 5, 5, (Color) new Color(0, 0, 51))));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		edits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					edits.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edits3.png")));
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
					setVisible(false);
					frame.dispose();
					Sign_up Sign_up= new Sign_up();
					Sign_up.setVisible(true);
					Sign_up.profile(account);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				edits.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edits3.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				edits.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edits1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
					edits.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edits1.png")));
					
			}
		});
		edits.setIcon(new ImageIcon(Account.class.getResource("/img/edits1.png")));
		edits.setBounds(582, 0, 60, 60);
		contentPane.add(edits);
		cross.setIcon(new ImageIcon(Account.class.getResource("/img/cross1.png")));
		cross.setBounds(0, 0, 60, 60);
		
		contentPane.add(cross);
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		edit.setBounds(210, 17, 234, 28);
		
		contentPane.add(edit);
		
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(77, 12, 107, 35);
		
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
		
		avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
		avater_drop2.setBounds(1140, -10, 160, 41);
		contentPane.add(avater_drop2);
		border.setFont(new Font("Tahoma", Font.ITALIC, 15));
		border.setForeground(SystemColor.textInactiveText);
		border.setBounds(382, -171, 72, 17);
		
		contentPane.add(border);
		contentPane.add(Owner_name);
		contentPane.add(CompanyID);
		contentPane.add(Company);
		contentPane.add(Type_company);
		contentPane.add(Type_account);
		contentPane.add(Email);
		contentPane.add(Gender);
		contentPane.add(Birthday);
		contentPane.add(Phone);
		contentPane.add(Mobile);
		contentPane.add(Fax);
		contentPane.add(Other);
		contentPane.add(Website);
		contentPane.add(Address1);
		contentPane.add(Address2);
		
		cross.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					cross.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cross3.png")));
					setVisible(false);
					dispose();
					
					
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
		
		
	        String lang = null;
	       
	        final Locale locale=getLocale(lang);
		
		JLabel owner_name = new JLabel("Owner Name");
		owner_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		owner_name.setBounds(42, 74, 185, 20);
		contentPane.add(owner_name);
		
		JLabel companyID = new JLabel("Company ID");
		companyID.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		companyID.setBounds(42, 148, 107, 14);
		contentPane.add(companyID);
		
		JLabel company = new JLabel("Company Name");
		company.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		company.setBounds(172, 148, 132, 14);
		contentPane.add(company);
		
		JLabel type_company = new JLabel("Type of Company");
		type_company.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		type_company.setBounds(42, 215, 149, 14);
		contentPane.add(type_company);
		
		JLabel type_account = new JLabel("Type of Account");
		type_account.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		type_account.setBounds(314, 215, 157, 14);
		contentPane.add(type_account);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		email.setBounds(42, 282, 46, 14);
		contentPane.add(email);
		
		JLabel birthday = new JLabel("Birthday");
		birthday.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		birthday.setBounds(314, 273, 133, 14);
		contentPane.add(birthday);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		gender.setBounds(480, 273, 146, 14);
		contentPane.add(gender);
		
		JLabel phone = new JLabel("Phone");
		phone.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		phone.setBounds(40, 353, 46, 14);
		contentPane.add(phone);
		
		JLabel mobile = new JLabel("Mobile");
		mobile.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		mobile.setBounds(231, 353, 98, 14);
		contentPane.add(mobile);
		
		JLabel fax = new JLabel("Fax");
		fax.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		fax.setBounds(423, 353, 46, 14);
		contentPane.add(fax);
		
		JLabel other = new JLabel("Other");
		other.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		other.setBounds(40, 429, 46, 14);
		contentPane.add(other);
		
		JLabel website = new JLabel("Website");
		website.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		website.setBounds(313, 429, 100, 14);
		contentPane.add(website);
		
		JLabel address1 = new JLabel("Address 1");
		address1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		address1.setBounds(42, 497, 120, 20);
		contentPane.add(address1);
		address2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		address2.setBounds(44, 589, 118, 20);
		
		contentPane.add(address2);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
