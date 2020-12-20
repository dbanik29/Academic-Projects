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
import javax.swing.JTextArea;

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
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class Profile extends JFrame {
	Connection connection=null;
	
	JLabel user_id = new JLabel("");
	
	
	private JPanel contentPane;
	JLabel avater_drop = new JLabel("");
	JLabel avater_drop1 = new JLabel("");
	JLabel avater_drop2 = new JLabel("");
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
	 JLabel nav_top = new JLabel("");
	JLabel swift_logo = new JLabel("");
	String companyID="011151";
	 public JTextField Employee_name = new JTextField();
	 
	 public JTextField EmployeeID = new JTextField();
	 public JTextField Short_note = new JTextField();
	 public JTextField Designation = new JTextField();
	 public JTextField CompanyID = new JTextField();
	 public JTextField Email = new JTextField();
	 public JTextField Gender = new JTextField();
	 public JTextField Birthday = new JTextField();
	 public JTextField Phone = new JTextField();
	 public JTextField Mobile = new JTextField();
	 public JTextField Active_date = new JTextField();
	 public JTextField Release_date = new JTextField();
	 public JTextField Salary = new JTextField();
	 
	 public JTextArea Present_address = new JTextArea();
	 public JTextArea Permanent_address = new JTextArea();
	 
	 
	 
	 
	   JLabel border = new JLabel("Name");
	    
	/**
	 * Launch the application.
	 */
	    
	    public void profile(String company){
	    	CompanyID.setText(company);
	    	EmployeeID.setText(user_id.getText());
	    	try{
				String query4="SELECT * FROM Employee_info Where Company_ID='"+CompanyID.getText()+"' and Employee_Id='"+EmployeeID.getText()+"'";
				PreparedStatement pst4=connection.prepareStatement(query4);
				ResultSet rs4=pst4.executeQuery();
				rs4.next();
				
				EmployeeID.setText(rs4.getString("Employee_Id"));
				CompanyID.setText(rs4.getString("Company_ID"));
				Employee_name.setText(rs4.getString("Employee_Title")+" "+rs4.getString("Employee_First_Name")+" "+rs4.getString("Employee_Middle_Name")+" "+rs4.getString("Employee_Last_Name"));
				Email.setText(rs4.getString("Email"));
				Phone.setText(rs4.getString("Phone_Number"));
				Mobile.setText(rs4.getString("Mobile"));
				Designation.setText(rs4.getString("Designation"));
				Salary.setText(rs4.getString("Salary"));
				Gender.setText(rs4.getString("Gender"));
				Birthday.setText(rs4.getString("Date_of_Birth"));
				Active_date.setText(rs4.getString("Active_date"));
				Release_date.setText(rs4.getString("Release_date"));
				
				pst4.close();
				rs4.close();
				System.out.println(Designation.getText());
				if(Designation.getText().equals("1")){
					String query2="SELECT * FROM Company_address Where Company_ID='"+CompanyID.getText()+"' and Status='Address1'";
					PreparedStatement pst2=connection.prepareStatement(query2);
					ResultSet rs2=pst2.executeQuery();
					rs2.next();
					
					Present_address.setText(rs2.getString("Street")+", "+rs2.getString("City_Town")+", "+rs2.getString("State__Province")+"\n"+rs2.getString("Postal_Code")+" "+rs2.getString("Country"));
					
					pst2.close();
					rs2.close();

					String query3="SELECT * FROM Company_address Where Company_ID='"+CompanyID.getText()+"' and Status='Address2'";
					PreparedStatement pst3=connection.prepareStatement(query3);
					ResultSet rs3=pst3.executeQuery();
					rs3.next();
					
					Permanent_address.setText(rs3.getString("Street")+", "+rs3.getString("City_Town")+", "+rs3.getString("State__Province")+"\n"+rs3.getString("Postal_Code")+" "+rs3.getString("Country"));
				
					pst3.close();
					rs3.close();
				}
				else{
					String query2="SELECT * FROM Employee_address Where Employee_Id='"+EmployeeID.getText()+"' and Status='Present Address'";
					PreparedStatement pst2=connection.prepareStatement(query2);
					ResultSet rs2=pst2.executeQuery();
					rs2.next();
					
					Present_address.setText(rs2.getString("Street")+", "+rs2.getString("City_Town")+", "+rs2.getString("State__Province")+"\n"+rs2.getString("Postal_Code")+" "+rs2.getString("Country"));
				
					pst2.close();
					rs2.close();

					String query3="SELECT * FROM Employee_address Where Employee_Id='"+EmployeeID.getText()+"' and Status='Permanent Address'";
					PreparedStatement pst3=connection.prepareStatement(query3);
					ResultSet rs3=pst3.executeQuery();
					rs3.next();
					
					Permanent_address.setText(rs3.getString("Street")+", "+rs3.getString("City_Town")+", "+rs3.getString("State__Province")+"\n"+rs3.getString("Postal_Code")+" "+rs3.getString("Country"));
					
					pst3.close();
					rs3.close();
				}
				
			//JOptionPane.showMessageDialog(null, "Save Get");
			}
			catch(Exception e1){
				//JOptionPane.showMessageDialog(null, "Quantity Get");
				e1.printStackTrace();
				
			}
		  }
	    
	    static Profile frame = new Profile();
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
	public JLabel edit = new JLabel("Employee Infomation");
	private final JLabel label = new JLabel("");
	private final JLabel label_1 = new JLabel("Present Address");
	private final JLabel label_2 = new JLabel("Permanent Address");
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
	public Profile() {
		connection =DatabaseConnect.DBConnectors();
		
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
			time.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			time.setText(TimeAr[3]);
	         
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		Employee_name.setEditable(false);
		Employee_name.setForeground(new Color(0, 0, 51));
		Employee_name.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Employee_name.setBackground(SystemColor.controlHighlight);
		Employee_name.setBounds(45, 105, 560, 23);
		Employee_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Employee_name.setColumns(10);
		EmployeeID.setEditable(false);
		EmployeeID.setForeground(new Color(0, 0, 51));
		EmployeeID.setFont(new Font("Garamond", Font.BOLD, 16));
		
		EmployeeID.setBackground(SystemColor.controlHighlight);
		EmployeeID.setBounds(151, 172, 93, 23);
		EmployeeID.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		EmployeeID.setColumns(10);
		Short_note.setEditable(false);
		Short_note.setForeground(new Color(0, 0, 51));
		Short_note.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Short_note.setBackground(SystemColor.controlHighlight);
		Short_note.setBounds(317, 382, 288, 23);
		Short_note.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Short_note.setColumns(10);
		Designation.setEditable(false);
		Designation.setForeground(new Color(0, 0, 51));
		Designation.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Designation.setBackground(SystemColor.controlHighlight);
		Designation.setBounds(255, 172, 350, 23);
		Designation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Designation.setColumns(10);
		CompanyID.setEditable(false);
		CompanyID.setForeground(new Color(0, 0, 51));
		CompanyID.setFont(new Font("Garamond", Font.BOLD, 16));
		
		CompanyID.setBackground(SystemColor.controlHighlight);
		CompanyID.setBounds(45, 172, 96, 23);
		CompanyID.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		CompanyID.setColumns(10);
		Email.setEditable(false);
		Email.setForeground(new Color(0, 0, 51));
		Email.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Email.setBackground(SystemColor.controlHighlight);
		Email.setBounds(45, 239, 273, 23);
		Email.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Email.setColumns(10);
		Gender.setEditable(false);
		Gender.setForeground(new Color(0, 0, 51));
		Gender.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Gender.setBackground(SystemColor.controlHighlight);
		Gender.setBounds(480, 239, 125, 23);
		Gender.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Gender.setColumns(10);
		Birthday.setEditable(false);
		Birthday.setForeground(new Color(0, 0, 51));
		Birthday.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Birthday.setBackground(SystemColor.controlHighlight);
		Birthday.setBounds(328, 239, 142, 23);
		Birthday.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Birthday.setColumns(10);
		Phone.setEditable(false);
		Phone.setForeground(new Color(0, 0, 51));
		Phone.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Phone.setBackground(SystemColor.controlHighlight);
		Phone.setBounds(45, 312, 199, 23);
		Phone.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Phone.setColumns(10);
		Mobile.setEditable(false);
		Mobile.setForeground(new Color(0, 0, 51));
		Mobile.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Mobile.setBackground(SystemColor.controlHighlight);
		Mobile.setBounds(255, 312, 214, 23);
		Mobile.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Mobile.setColumns(10);
		Active_date.setEditable(false);
		Active_date.setForeground(new Color(0, 0, 51));
		Active_date.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Active_date.setBackground(SystemColor.controlHighlight);
		Active_date.setBounds(45, 382, 118, 23);
		Active_date.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Active_date.setColumns(10);
		Release_date.setEditable(false);
		Release_date.setForeground(new Color(0, 0, 51));
		Release_date.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Release_date.setBackground(SystemColor.controlHighlight);
		Release_date.setBounds(173, 382, 134, 23);
		Release_date.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Release_date.setColumns(10);
		Salary.setEditable(false);
		Salary.setForeground(new Color(0, 0, 51));
		Salary.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Salary.setBackground(SystemColor.controlHighlight);
		Salary.setBounds(485, 312, 120, 23);
		Salary.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Salary.setColumns(10);
		Present_address.setEditable(false);
		Present_address.setForeground(new Color(0, 0, 51));
		Present_address.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Present_address.setBackground(SystemColor.controlHighlight);
		Present_address.setBounds(45, 463, 560, 50);
		Present_address.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Present_address.setColumns(10);
		Permanent_address.setEditable(false);
		Permanent_address.setForeground(new Color(0, 0, 51));
		Permanent_address.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Permanent_address.setBackground(SystemColor.controlHighlight);
		Permanent_address.setBounds(45, 576, 560, 50);
		Permanent_address.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Permanent_address.setColumns(10);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 645, 666);
		setShape(new RoundRectangle2D.Double(00, 00, 645, 666, 50, 0));
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
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new CompoundBorder(new MatteBorder(0, 5, 5, 5, (Color) new Color(109, 109, 109)), new MatteBorder(0, 5, 5, 5, (Color) new Color(0, 0, 51))));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		time.setBounds(669, 22, 225, 14);
		contentPane.add(time);
		cross.setIcon(new ImageIcon(Profile.class.getResource("/img/cross1.png")));
		cross.setBounds(0, 0, 60, 60);
		
		contentPane.add(cross);
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(78, 12, 107, 35);
		
		contentPane.add(swift_logo);
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		edit.setBounds(210, 17, 350, 28);
		
		contentPane.add(edit);
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
		contentPane.add(Employee_name);
		contentPane.add(EmployeeID);
		contentPane.add(Short_note);
		contentPane.add(Designation);
		contentPane.add(CompanyID);
		contentPane.add(Email);
		contentPane.add(Gender);
		contentPane.add(Birthday);
		contentPane.add(Phone);
		contentPane.add(Mobile);
		contentPane.add(Active_date);
		contentPane.add(Release_date);
		contentPane.add(Salary);
		contentPane.add(Present_address);
		contentPane.add(Permanent_address);
		
		
		
		
	        String lang = null;
	       
	        final Locale locale=getLocale(lang);
		
		JLabel employee_name = new JLabel("Employee Name");
		employee_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		employee_name.setBounds(45, 81, 185, 14);
		contentPane.add(employee_name);
		
		JLabel employeeID = new JLabel("Employee ID");
		employeeID.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		employeeID.setBounds(151, 148, 93, 14);
		contentPane.add(employeeID);
		
		JLabel short_note = new JLabel("Short Notes");
		short_note.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		short_note.setBounds(317, 358, 132, 14);
		contentPane.add(short_note);
		
		JLabel designation = new JLabel("Designation");
		designation.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		designation.setBounds(255, 148, 350, 14);
		contentPane.add(designation);
		
		JLabel companyId = new JLabel("Company ID");
		companyId.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		companyId.setBounds(45, 148, 96, 14);
		contentPane.add(companyId);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		email.setBounds(45, 215, 46, 14);
		contentPane.add(email);
		
		JLabel birthday = new JLabel("Birthday");
		birthday.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		birthday.setBounds(328, 205, 133, 14);
		contentPane.add(birthday);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		gender.setBounds(494, 205, 146, 14);
		contentPane.add(gender);
		
		JLabel phone = new JLabel("Phone");
		phone.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		phone.setBounds(45, 285, 46, 14);
		contentPane.add(phone);
		
		JLabel mobile = new JLabel("Mobile");
		mobile.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		mobile.setBounds(255, 285, 214, 14);
		contentPane.add(mobile);
		
		JLabel active_date = new JLabel("Active Date");
		active_date.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		active_date.setBounds(45, 358, 107, 14);
		contentPane.add(active_date);
		
		JLabel release_date = new JLabel("Release Date");
		release_date.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		release_date.setBounds(173, 358, 127, 14);
		contentPane.add(release_date);
		
		JLabel salary = new JLabel("Salary");
		salary.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		salary.setBounds(487, 285, 100, 14);
		contentPane.add(salary);
		label.setForeground(new Color(0, 0, 51));
		label.setFont(new Font("Garamond", Font.BOLD, 16));
		label.setBounds(465, 310, 140, 20);
		
		contentPane.add(label);
		label_1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		label_1.setBounds(45, 427, 173, 25);
		
		contentPane.add(label_1);
		label_2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		label_2.setBounds(45, 538, 215, 25);
		
		contentPane.add(label_2);
		
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
