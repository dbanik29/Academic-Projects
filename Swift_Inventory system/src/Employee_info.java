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
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class Employee_info extends JFrame {
	Connection connection=null;
	JLabel user_id = new JLabel("");
	
	public static class MyActionListener10 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
        	
        }
	}
	
	private JPanel contentPane;
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
	 public JTextField Title = new JTextField();
	 public JTextField First_name = new JTextField();
	 public JTextField Middle_name = new JTextField();
	 public JTextField Last_name = new JTextField();
	 public JTextField Suffix = new JTextField();
	 
	 public JTextField EmployeeID = new JTextField();
	 public JTextField Short_note = new JTextField();
	 public JTextField Designation = new JTextField();
	 public JTextField CompanyID = new JTextField();
	 public JTextField Email = new JTextField();
	 public JPasswordField Password = new JPasswordField();
	 public JPasswordField Confirm = new JPasswordField();
	 public JTextField Gender = new JTextField();
	 public JTextField Birthday = new JTextField();
	 public JTextField Phone = new JTextField();
	 public JTextField Mobile = new JTextField();
	 public JTextField Active_date = new JTextField();
	 public JTextField Release_date = new JTextField();
	 public JTextField Salary = new JTextField();
	 
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
	 
	 JRadioButton male = new JRadioButton("Male");
	 JRadioButton female = new JRadioButton("Female");
	 
	 
	 
	 
	   JLabel border = new JLabel("Name");

	    public void show(String company, String employee){
	    	CompanyID.setText(company);
	    	EmployeeID.setText(employee);
	    	try{
				String query4="SELECT * FROM Employee_info Where Company_ID='"+CompanyID.getText()+"' and Employee_Id='"+EmployeeID.getText()+"'";
				PreparedStatement pst4=connection.prepareStatement(query4);
				ResultSet rs4=pst4.executeQuery();
				rs4.next();
				
				EmployeeID.setText(rs4.getString("Employee_Id"));
				CompanyID.setText(rs4.getString("Company_ID"));
				Title.setText(rs4.getString("Employee_Title"));
				First_name.setText(rs4.getString("Employee_First_Name"));
				Middle_name.setText(rs4.getString("Employee_Middle_Name"));
				Last_name.setText(rs4.getString("Employee_Last_Name"));
				Suffix.setText(rs4.getString("Employee_Suffix"));
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
					
					Street1.setText(rs2.getString("Street"));
					City1.setText(rs2.getString("City_Town"));
					State1.setText(rs2.getString("State__Province"));
					Postal1.setText(rs2.getString("Postal_Code"));
					Country1.setText(rs2.getString("Country"));
				
					pst2.close();
					rs2.close();

					String query3="SELECT * FROM Company_address Where Company_ID='"+CompanyID.getText()+"' and Status='Address2'";
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
				}
				else{
					String query2="SELECT * FROM Employee_address Where Employee_Id='"+EmployeeID.getText()+"' and Status='Present Address'";
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

					String query3="SELECT * FROM Employee_address Where Employee_Id='"+EmployeeID.getText()+"' and Status='Permanent Address'";
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
				}
				
			String query5="SELECT * FROM Login Where Company_ID='"+CompanyID.getText()+"' and Employee_Id='"+EmployeeID.getText()+"'";
			PreparedStatement pst5=connection.prepareStatement(query5);
			ResultSet rs5=pst5.executeQuery();
			rs5.next();
			
			Password.setText(rs5.getString("Passward"));
			
			
			pst5.close();
			rs5.close();
			//JOptionPane.showMessageDialog(null, "Save Get");
			}
			catch(Exception e1){
				//JOptionPane.showMessageDialog(null, "Quantity Get");
				e1.printStackTrace();
				
			}
		  }
	    
	    static Employee_info frame = new Employee_info();
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
	public JLabel edit = new JLabel("Employee Info");
	private final JLabel message = new JLabel("");
	private final JLabel label = new JLabel("");
	private final JLabel label_1 = new JLabel("Present Address");
	private final JLabel label_2 = new JLabel("Permanent Address");
	private final JLabel cross = new JLabel("");
	private final JLabel saves = new JLabel("");
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
	public Employee_info() {
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
		Title.setBounds(30, 114, 80, 23);
		Title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Title.setColumns(10);
		First_name.setForeground(new Color(0, 0, 51));
		First_name.setFont(new Font("Garamond", Font.BOLD, 16));
		
		First_name.setBackground(new Color(255, 255, 204));
		First_name.setBounds(120, 114, 120, 23);
		First_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		First_name.setColumns(10);
		Middle_name.setForeground(new Color(0, 0, 51));
		Middle_name.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Middle_name.setBackground(new Color(255, 255, 204));
		Middle_name.setBounds(250, 114, 120, 23);
		Middle_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Middle_name.setColumns(10);
		Last_name.setForeground(new Color(0, 0, 51));
		Last_name.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Last_name.setBackground(new Color(255, 255, 204));
		Last_name.setBounds(380, 114, 120, 23);
		Last_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Last_name.setColumns(10);
		Suffix.setForeground(new Color(0, 0, 51));
		Suffix.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Suffix.setBackground(new Color(255, 255, 204));
		Suffix.setBounds(510, 114, 80, 23);
		Suffix.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Suffix.setColumns(10);
		EmployeeID.setForeground(new Color(0, 0, 51));
		EmployeeID.setFont(new Font("Garamond", Font.BOLD, 16));
		
		EmployeeID.setBackground(new Color(255, 255, 204));
		EmployeeID.setBounds(136, 181, 93, 23);
		EmployeeID.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		EmployeeID.setColumns(10);
		Short_note.setForeground(new Color(0, 0, 51));
		Short_note.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Short_note.setBackground(new Color(255, 255, 204));
		Short_note.setBounds(302, 532, 288, 23);
		Short_note.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Short_note.setColumns(10);
		Designation.setForeground(new Color(0, 0, 51));
		Designation.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Designation.setBackground(new Color(255, 255, 204));
		Designation.setBounds(330, 181, 260, 23);
		Designation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Designation.setColumns(10);
		CompanyID.setForeground(new Color(0, 0, 51));
		CompanyID.setFont(new Font("Garamond", Font.BOLD, 16));
		
		CompanyID.setBackground(new Color(255, 255, 204));
		CompanyID.setBounds(30, 181, 96, 23);
		CompanyID.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		CompanyID.setColumns(10);
		Email.setForeground(new Color(0, 0, 51));
		Email.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Email.setBackground(new Color(255, 255, 204));
		Email.setBounds(30, 248, 560, 23);
		Email.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Email.setColumns(10);
		Password.setForeground(new Color(0, 0, 51));
		Password.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Password.setBackground(new Color(255, 255, 204));
		Password.setBounds(30, 315, 200, 23);
		Password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Password.setColumns(10);
		Confirm.setForeground(new Color(0, 0, 51));
		Confirm.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Confirm.setBackground(new Color(255, 255, 204));
		Confirm.setBounds(240, 315, 200, 23);
		Confirm.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Confirm.setColumns(10);
		Gender.setForeground(new Color(0, 0, 51));
		Gender.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Gender.setBackground(new Color(255, 255, 204));
		Gender.setBounds(182, 392, 121, 23);
		Gender.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Gender.setColumns(10);
		Birthday.setForeground(new Color(0, 0, 51));
		Birthday.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Birthday.setBackground(new Color(255, 255, 204));
		Birthday.setBounds(30, 392, 142, 23);
		Birthday.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Birthday.setColumns(10);
		Phone.setForeground(new Color(0, 0, 51));
		Phone.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Phone.setBackground(new Color(255, 255, 204));
		Phone.setBounds(30, 462, 199, 23);
		Phone.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Phone.setColumns(10);
		Mobile.setForeground(new Color(0, 0, 51));
		Mobile.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Mobile.setBackground(new Color(255, 255, 204));
		Mobile.setBounds(240, 462, 214, 23);
		Mobile.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Mobile.setColumns(10);
		Active_date.setForeground(new Color(0, 0, 51));
		Active_date.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Active_date.setBackground(new Color(255, 255, 204));
		Active_date.setBounds(30, 532, 118, 23);
		Active_date.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Active_date.setColumns(10);
		Release_date.setForeground(new Color(0, 0, 51));
		Release_date.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Release_date.setBackground(new Color(255, 255, 204));
		Release_date.setBounds(158, 532, 134, 23);
		Release_date.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Release_date.setColumns(10);
		Salary.setForeground(new Color(0, 0, 51));
		Salary.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Salary.setBackground(new Color(255, 255, 204));
		Salary.setBounds(470, 462, 120, 23);
		Salary.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Salary.setColumns(10);
		Street1.setForeground(new Color(0, 0, 51));
		Street1.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Street1.setBackground(new Color(255, 255, 204));
		Street1.setBounds(660, 154, 385, 23);
		Street1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Street1.setColumns(10);
		City1.setForeground(new Color(0, 0, 51));
		City1.setFont(new Font("Garamond", Font.BOLD, 16));
		
		City1.setBackground(new Color(255, 255, 204));
		City1.setBounds(660, 221, 185, 23);
		City1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		City1.setColumns(10);
		State1.setForeground(new Color(0, 0, 51));
		State1.setFont(new Font("Garamond", Font.BOLD, 16));
		
		State1.setBackground(new Color(255, 255, 204));
		State1.setBounds(855, 221, 190, 23);
		State1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		State1.setColumns(10);
		Postal1.setForeground(new Color(0, 0, 51));
		Postal1.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Postal1.setBackground(new Color(255, 255, 204));
		Postal1.setBounds(660, 288, 185, 23);
		Postal1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Postal1.setColumns(10);
		Country1.setForeground(new Color(0, 0, 51));
		Country1.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Country1.setBackground(new Color(255, 255, 204));
		Country1.setBounds(855, 288, 190, 23);
		Country1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Country1.setColumns(10);
		Street2.setForeground(new Color(0, 0, 51));
		Street2.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Street2.setBackground(new Color(255, 255, 204));
		Street2.setBounds(660, 391, 385, 23);
		Street2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Street2.setColumns(10);
		City2.setForeground(new Color(0, 0, 51));
		City2.setFont(new Font("Garamond", Font.BOLD, 16));
		
		City2.setBackground(new Color(255, 255, 204));
		City2.setBounds(660, 461, 185, 23);
		City2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		City2.setColumns(10);
		State2.setForeground(new Color(0, 0, 51));
		State2.setFont(new Font("Garamond", Font.BOLD, 16));
		
		State2.setBackground(new Color(255, 255, 204));
		State2.setBounds(855, 461, 190, 23);
		State2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		State2.setColumns(10);
		Postal2.setForeground(new Color(0, 0, 51));
		Postal2.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Postal2.setBackground(new Color(255, 255, 204));
		Postal2.setBounds(660, 531, 185, 23);
		Postal2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Postal2.setColumns(10);
		Country2.setForeground(new Color(0, 0, 51));
		Country2.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Country2.setBackground(new Color(255, 255, 204));
		Country2.setBounds(855, 531, 190, 23);
		Country2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Country2.setColumns(10);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 1075, 594);
		setShape(new RoundRectangle2D.Double(00, 00, 1075, 594, 50, 0));
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
		cross.setIcon(new ImageIcon(Employee_info.class.getResource("/img/cross1.png")));
		cross.setBounds(0, 0, 60, 60);
		
		contentPane.add(cross);
		saves.setIcon(new ImageIcon(Employee_info.class.getResource("/img/saves1.png")));
		saves.setBounds(1015, 0, 60, 60);
		
		contentPane.add(saves);
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(78, 12, 107, 35);
		
		contentPane.add(swift_logo);
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		edit.setBounds(210, 17, 463, 28);
		
		contentPane.add(edit);
		nav_top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/nav_top.png")));
		nav_top.setBounds(0, 0, 200, 60);
		
		contentPane.add(nav_top);
		
		JLabel top = new JLabel("");
		top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/top.png")));
		top.setEnabled(false);
		top.setBounds(0, 0, 1300, 60);
		contentPane.add(top);
		
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
		
		saves.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					saves.setIcon(new ImageIcon(Dashboard.class.getResource("/img/saves3.png")));
					if(edit.getText()=="Add New Employee"){
						try{
						
						String query3="insert into Employee_info(Employee_Id,Employee_Title,Employee_First_Name,Employee_Middle_Name,Employee_Last_Name,Employee_Suffix,Company_ID,Email,Phone_Number,Mobile,Designation,Gender,Salary,Date_of_Birth,Active_date)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
						
						PreparedStatement pst3=connection.prepareStatement(query3);
						
						pst3.setString(1, EmployeeID.getText());
						pst3.setString(2, Title.getText());
						pst3.setString(3, First_name.getText());
						pst3.setString(4, Middle_name.getText());
						pst3.setString(5, Last_name.getText());
						pst3.setString(6, Suffix.getText());
						pst3.setString(7, "coid03");
						pst3.setString(8, Email.getText());
						pst3.setString(9, Phone.getText());
						pst3.setString(10, Mobile.getText());
						pst3.setString(11, Designation.getText());
						pst3.setString(12, Gender.getText());
						pst3.setString(13, Salary.getText());
						pst3.setString(14, Birthday.getText());
						pst3.setString(15, Active_date.getText());
						
						
						pst3.execute();
						pst3.close();
						pst3.close();
						
					String query1="insert into Employee_address(Employee_Id,Street, City_Town,State__Province,Postal_Code,Country,Status)  values(?,?,?,?,?,?,?) ";
					
					PreparedStatement pst1=connection.prepareStatement(query1);
					
					pst1.setString(1, EmployeeID.getText());
					pst1.setString(2, Street1.getText());
					pst1.setString(3, City1.getText());
					pst1.setString(4, State1.getText());
					pst1.setString(5, Postal1.getText());
					pst1.setString(6, Country1.getText());
					pst1.setString(7, "Present Address");
					pst1.execute();
					pst1.close();
					
					
					String query2="insert into Employee_address(Employee_Id,Street, City_Town,State__Province,Postal_Code,Country,Status)  values(?,?,?,?,?,?,?) ";
					
					PreparedStatement pst2=connection.prepareStatement(query2);
					
					pst2.setString(1, EmployeeID.getText());
					pst2.setString(2, Street2.getText());
					pst2.setString(3, City2.getText());
					pst2.setString(4, State2.getText());
					pst2.setString(5, Postal2.getText());
					pst2.setString(6, Country2.getText());
					pst2.setString(7, "Permanent Address");
					pst2.execute();
					pst2.close();
					pst2.close();
					
					
					String query4="insert into Login(Employee_Id,Company_ID,Passward)  values(?,?,?) ";
					
					PreparedStatement pst4=connection.prepareStatement(query4);
					
					pst4.setString(1, EmployeeID.getText());
					pst4.setString(2, CompanyID.getText());
					pst4.setString(3, Password.getText());
					
					pst4.execute();
					pst4.close();
					pst4.close();
					Message Message= new Message();
					Message.setVisible(true);
					Message.Message.setText("Employee Successfully Added");
				
					//JOptionPane.showMessageDialog(null, "Data Add");
				}
				
				catch(Exception e1){
					//JOptionPane.showMessageDialog(null, "Quantity Get");
					e1.printStackTrace();
				}
					}
					else if(edit.getText()=="Edit Employee Info"){
						try{
							
							String e1="update  Employee_info set  Employee_Title='"+Title.getText()+"', Employee_First_Name='"+First_name.getText()+"',";
							String e2="Employee_Middle_Name='"+Middle_name.getText()+"', Employee_Last_Name='"+Last_name.getText()+"', Employee_Suffix='"+Suffix.getText()+"',";		
							String e3="Date_of_Birth='"+Birthday.getText()+"',Gender='"+Gender.getText()+"', Email='"+Email.getText()+"', Phone_Number='"+Phone.getText()+"', Mobile='"+Mobile.getText()+"',";
							String e4="Designation='"+Designation.getText()+"', Release_date='"+Release_date.getText()+"'";
							String e5="where Company_ID='"+CompanyID.getText()+"' and Employee_Id='"+EmployeeID.getText()+"'";
							
							PreparedStatement pst2=connection.prepareStatement(e1+e2+e3+e4+e5);
							
							
							pst2.execute();
							pst2.close();
							
							String e12="update  Employee_address set  Street='"+Street1.getText()+"', City_Town='"+City1.getText()+"',";
							String e22="State__Province='"+State1.getText()+"', Postal_Code='"+Postal1.getText()+"', Country='"+Country1.getText()+"'";		
							
							String e42="where Employee_Id='"+EmployeeID.getText()+"' and Status='Present Address'";
							
							PreparedStatement pst3=connection.prepareStatement(e12+e22+e42);
							
							
							pst3.execute();
							pst3.close();
							
							String e13="update  Employee_address set  Street='"+Street2.getText()+"', City_Town='"+City2.getText()+"',";
							String e23="State__Province='"+State2.getText()+"', Postal_Code='"+Postal2.getText()+"', Country='"+Country2.getText()+"'";		
							
							String e43="where Employee_Id='"+EmployeeID.getText()+"' and Status='Permanent Address'";
							
							PreparedStatement pst4=connection.prepareStatement(e13+e23+e43);
							
							
							pst4.execute();
							pst4.close();
							
							
							String e14="update  Login set  Passward='"+Password.getText()+"' where Company_ID='"+CompanyID.getText()+"' and Employee_Id='"+CompanyID.getText()+"'";
							
							PreparedStatement pst5=connection.prepareStatement(e14);
							
							
							pst5.execute();
							pst5.close();
							
							//JOptionPane.showMessageDialog(null, "Data Add");
							Message Message= new Message();
							Message.setVisible(true);
							Message.Message.setText("Employee Successfully Updated");
					
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
		contentPane.add(EmployeeID);
		contentPane.add(Short_note);
		contentPane.add(Designation);
		contentPane.add(CompanyID);
		contentPane.add(Email);
		contentPane.add(Password);
		contentPane.add(Confirm);
		contentPane.add(Gender);
		contentPane.add(Birthday);
		contentPane.add(Phone);
		contentPane.add(Mobile);
		contentPane.add(Active_date);
		contentPane.add(Release_date);
		contentPane.add(Salary);
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
		title.setBounds(30, 90, 60, 14);
		contentPane.add(title);
		
		JLabel first_name = new JLabel("First Name");
		first_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		first_name.setBounds(120, 90, 90, 14);
		contentPane.add(first_name);
		
		JLabel middle_name = new JLabel("Middle Name");
		middle_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		middle_name.setBounds(250, 90, 96, 14);
		contentPane.add(middle_name);
		
		JLabel last_name = new JLabel("Last Name");
		last_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		last_name.setBounds(380, 90, 76, 14);
		contentPane.add(last_name);
		
		JLabel suffix = new JLabel("Suffix");
		suffix.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		suffix.setBounds(510, 90, 46, 14);
		contentPane.add(suffix);
		
		JLabel employeeID = new JLabel("Employee ID");
		employeeID.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		employeeID.setBounds(136, 157, 93, 14);
		contentPane.add(employeeID);
		
		JLabel short_note = new JLabel("Short Notes");
		short_note.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		short_note.setBounds(302, 508, 132, 14);
		contentPane.add(short_note);
		
		JLabel designation = new JLabel("Designation");
		designation.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		designation.setBounds(330, 157, 260, 14);
		contentPane.add(designation);
		
		JLabel companyId = new JLabel("Company ID");
		companyId.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		companyId.setBounds(30, 157, 96, 14);
		contentPane.add(companyId);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		email.setBounds(30, 224, 46, 14);
		contentPane.add(email);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		password.setBounds(30, 291, 121, 14);
		contentPane.add(password);
		
		JLabel confirm = new JLabel("Confirm Password");
		confirm.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		confirm.setBounds(250, 291, 340, 14);
		contentPane.add(confirm);
		
		JLabel birthday = new JLabel("Birthday");
		birthday.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		birthday.setBounds(30, 358, 133, 14);
		contentPane.add(birthday);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		gender.setBounds(196, 358, 146, 14);
		contentPane.add(gender);
		
		JLabel phone = new JLabel("Phone");
		phone.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		phone.setBounds(30, 435, 46, 14);
		contentPane.add(phone);
		
		JLabel mobile = new JLabel("Mobile");
		mobile.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		mobile.setBounds(250, 435, 204, 14);
		contentPane.add(mobile);
		
		JLabel active_date = new JLabel("Active Date");
		active_date.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		active_date.setBounds(30, 508, 107, 14);
		contentPane.add(active_date);
		
		JLabel release_date = new JLabel("Release Date");
		release_date.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		release_date.setBounds(158, 508, 127, 14);
		contentPane.add(release_date);
		
		JLabel salary = new JLabel("Salary");
		salary.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		salary.setBounds(472, 435, 100, 14);
		contentPane.add(salary);
		
		
		JLabel street1 = new JLabel("Street");
		street1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		street1.setBounds(662, 130, 46, 14);
		contentPane.add(street1);
		
		JLabel city1 = new JLabel("City/Town");
		city1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		city1.setBounds(660, 197, 90, 14);
		contentPane.add(city1);
		
		JLabel state1 = new JLabel("State/Province");
		state1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		state1.setBounds(855, 197, 149, 14);
		contentPane.add(state1);
		
		JLabel postal1 = new JLabel("Postal Code");
		postal1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		postal1.setBounds(660, 264, 96, 14);
		contentPane.add(postal1);
		
		JLabel country1 = new JLabel("Country");
		country1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		country1.setBounds(855, 264, 96, 14);
		contentPane.add(country1);
		
		JLabel street2 = new JLabel("Street");
		street2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		street2.setBounds(662, 357, 46, 14);
		contentPane.add(street2);
		
		JLabel city2 = new JLabel("City/Town");
		city2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		city2.setBounds(660, 434, 90, 14);
		contentPane.add(city2);
		
		JLabel state2 = new JLabel("State/Province");
		state2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		state2.setBounds(855, 434, 149, 14);
		contentPane.add(state2);
		
		JLabel postal2 = new JLabel("Postal Code");
		postal2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		postal2.setBounds(660, 510, 96, 14);
		contentPane.add(postal2);
		
		JLabel country2 = new JLabel("Country");
		country2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		country2.setBounds(855, 510, 96, 14);
		contentPane.add(country2);
		male.setBackground(new Color(255, 255, 204));
		male.setForeground(new Color(0, 0, 51));
		
		
		male.setFont(new Font("Garamond", Font.BOLD, 16));
		male.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Gender.setText("Male");
				female.setSelected(false);
			}
		});
		
		
		male.setBounds(317, 381, 60, 23);
		contentPane.add(male);
		female.setBackground(new Color(255, 255, 204));
		female.setForeground(new Color(0, 0, 51));
		female.setFont(new Font("Garamond", Font.BOLD, 16));
		female.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gender.setText("Female");
				male.setSelected(false);
			}
		});
		
		
		female.setBounds(440, 381, 109, 23);
		contentPane.add(female);
		message.setForeground(new Color(0, 0, 51));
		message.setFont(new Font("Garamond", Font.BOLD, 16));
		message.setBounds(239, 184, 81, 20);
		
		contentPane.add(message);
		label.setForeground(new Color(0, 0, 51));
		label.setFont(new Font("Garamond", Font.BOLD, 16));
		label.setBounds(450, 319, 140, 20);
		
		contentPane.add(label);
		label_1.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		label_1.setBounds(660, 90, 173, 25);
		
		contentPane.add(label_1);
		label_2.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		label_2.setBounds(660, 322, 215, 25);
		
		contentPane.add(label_2);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
		
	}
}