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
import javax.swing.border.MatteBorder;

public class Pay_expense extends JFrame {
	Connection connection=null;
	JLabel user_id = new JLabel("");
	
	private JPanel contentPane;
	JLabel avater_drop = new JLabel("");
	JLabel avater_drop1 = new JLabel("");
	JLabel avater_drop2 = new JLabel("");
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
	int count;
	JLabel company_name = new JLabel("Javandro");
	 JLabel nav_top = new JLabel("");
	 JLabel top = new JLabel("");
	JLabel swift_logo = new JLabel("");
	String companyID="011151";
	 public JTextField Payment_date = new JTextField();
	 public JTextField Payment_no = new JTextField();
	 public JTextField EmployeeID = new JTextField();
	 String date;
	 int in_hand;
	 int row;
	
	 
	 int order_no;
	 int Payment_id;
	
	
	   JLabel border = new JLabel("Name");
	   JLabel cross = new JLabel("");
	   JButton update = new JButton("Update");
	
	    static Pay_expense frame = new Pay_expense();
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
	private final JButton btnShow = new JButton("show");
	private final JButton Delete = new JButton("delete");
	public JLabel title = new JLabel("Expense");
	private final JLabel Payment_information = new JLabel("Payment Information");
	private JTextField Amount;
	private final JPanel panel_2 = new JPanel();
	private final JLabel confirm = new JLabel("");
	
    public void show(String date, String payment_no, String employee, String amount){
    	Payment_date.setText(date);
    	Payment_no.setText(payment_no);
    	EmployeeID.setText(employee);
    	Amount.setText(amount);
    	
    	status="yes";
    	
    }
    
	public Pay_expense() {
		connection =DatabaseConnect.DBConnectors();
		try{
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
		
		Payment_id++;
		Payment_no.setForeground(new Color(0, 0, 51));
		Payment_no.setHorizontalAlignment(SwingConstants.RIGHT);
		Payment_no.setText(Integer.toString(Payment_id));
			
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	         System.out.println(Time);
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		date = sdf.format(new Date());
		Payment_date.setForeground(new Color(0, 0, 51));
		Payment_date.setHorizontalAlignment(SwingConstants.RIGHT);
		Payment_date.setText(date);
		Payment_date.setEditable(false);
		Payment_date.setFont(new Font("Futura Lt BT", Font.ITALIC, 18));
		
		Payment_date.setBackground(new Color(255, 255, 153));
		Payment_date.setBounds(155, 112, 94, 23);
		Payment_date.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Payment_date.setColumns(10);
		Payment_no.setEditable(false);
		Payment_no.setFont(new Font("Futura Lt BT", Font.ITALIC, 18));
		
		Payment_no.setBackground(new Color(255, 255, 153));
		Payment_no.setBounds(151, 143, 98, 23);
		Payment_no.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		Payment_no.setColumns(10);
		EmployeeID.setForeground(new Color(0, 0, 51));
		
		EmployeeID.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		EmployeeID.setBackground(new Color(255, 255, 153));
		EmployeeID.setBounds(271, 134, 84, 23);
		EmployeeID.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		EmployeeID.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setUndecorated(true);
	    
		setBounds(-100, -100, 385, 287);
		setShape(new RoundRectangle2D.Double(00, 00, 385, 287, 50, 0));
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
				avater_drop.setBounds(565, -10, 160, 50);
				avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
				avater_drop1.setBounds(565, -10, 160, 41);
				avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
				avater_drop2.setBounds(565, -10, 160, 41);
				i=1;
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
			
			}
		});
		contentPane.setBackground(new Color(230, 235, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cross.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					cross.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cross3.png")));
					setVisible(false);
					frame.dispose();
					
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
		title.setBounds(221, 16, 239, 28);
		
		contentPane.add(title);
		cross.setIcon(new ImageIcon(Invoice_create.class.getResource("/img/cross1.png")));
		cross.setBounds(0, 0, 60, 60);
		contentPane.add(cross);
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(77, 12, 107, 35);
		
		contentPane.add(swift_logo);
		top.setIcon(new ImageIcon(Invoice_create.class.getResource("/img/top.png")));
		
		top.setEnabled(false);
		top.setBounds(200, 0, 525, 60);
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
		
		
		border.setFont(new Font("Tahoma", Font.ITALIC, 15));
		border.setForeground(SystemColor.textInactiveText);
		border.setBounds(382, -171, 72, 17);
		
		contentPane.add(border);
		contentPane.add(Payment_date);
		contentPane.add(Payment_no);
		contentPane.add(EmployeeID);
		
		
		JLabel payment_date = new JLabel("Payment Date");
		payment_date.setForeground(new Color(0, 0, 51));
		payment_date.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		payment_date.setBounds(29, 116, 125, 20);
		contentPane.add(payment_date);
		
		JLabel payement_no = new JLabel("Payment No.");
		payement_no.setForeground(new Color(0, 0, 51));
		payement_no.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		payement_no.setBounds(29, 147, 107, 20);
		contentPane.add(payement_no);
		
		JLabel employeeId = new JLabel("Employee ID");
		employeeId.setForeground(new Color(0, 0, 51));
		employeeId.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		employeeId.setBounds(271, 112, 120, 14);
		contentPane.add(employeeId);
			Payment_information.setForeground(new Color(0, 0, 51));
			Payment_information.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
			Payment_information.setBounds(29, 68, 226, 25);
			
			contentPane.add(Payment_information);
			
			Amount = new JTextField();
			Amount.setHorizontalAlignment(SwingConstants.RIGHT);
			Amount.setForeground(new Color(0, 0, 51));
			Amount.setFont(new Font("Futura Lt BT", Font.BOLD | Font.ITALIC, 25));
			Amount.setColumns(5);
			Amount.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
			Amount.setBackground(new Color(255, 255, 153));
			Amount.setBounds(29, 239, 173, 35);
			contentPane.add(Amount);
			
			JLabel amount = new JLabel("Amount");
			amount.setForeground(new Color(0, 0, 51));
			amount.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
			amount.setBounds(29, 218, 107, 14);
			contentPane.add(amount);
			
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
					if(status=="no"){
						try{
							String query5="insert into Transactions(Payment_id,Employee_id,Date,Type,Amount,Transaction_type)  values(?,?,?,?,?,?) ";
							
							PreparedStatement pst5=connection.prepareStatement(query5);
							
							pst5.setInt(1, Payment_id);
							pst5.setString(2, EmployeeID.getText());
							pst5.setString(3, date);
							pst5.setString(4, "Debit");
							pst5.setString(5, Amount.getText());
							pst5.setString(6, "Cash");
				
							pst5.execute();
							pst5.close();
						
						//JOptionPane.showMessageDialog(null, "Data Add");
						setVisible(false);
						frame.dispose();
						
						Message Message= new Message();
						Message.user_id.setText(user_id.getText());
						Message.setVisible(true);
						Message.Message.setText("Transaction Successfull");
						Expenses Expenses= new Expenses();
						Expenses.user_id.setText(user_id.getText());
						Expenses.refresh_table();
						Message_status Message_status= new Message_status();
						Message_status.user_id.setText(user_id.getText());
						Message_status.setVisible(true);
						Message_status.Message.setText("New Expense");
						Message_status.class_name="Expense";
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
					}
					else if(status=="yes"){
						try{
							String q1="UPDATE Transactions SET Amount='"+Amount.getText()+"', Employee_id='"+EmployeeID.getText()+"', Type='Debit' WHERE Payment_id='"+Payment_no.getText()+"' ";
	                  
							PreparedStatement pst1=connection.prepareStatement(q1);
						
							pst1.execute();
							
							pst1.close();
							//JOptionPane.showMessageDialog(null, "update");
							setVisible(false);
							frame.dispose();
							
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Transaction Successfully Updated");
							Expenses Expenses= new Expenses();
							Expenses.user_id.setText(user_id.getText());
							Expenses.refresh_table();
							Message_status Message_status= new Message_status();
							Message_status.user_id.setText(user_id.getText());
							Message_status.setVisible(true);
							Message_status.Message.setText("New Expense");
							Message_status.class_name="Expense";
							}
							catch(Exception e1){
								e1.printStackTrace();
							}
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
			confirm.setIcon(new ImageIcon(Pay_expense.class.getResource("/img/confirm1.png")));
			confirm.setBounds(220, 233, 150, 41);
			
			contentPane.add(confirm);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new MatteBorder(4, 0, 3, 0, (Color) new Color(0, 0, 51)));
			panel_1.setBackground(new Color(255, 255, 153));
			panel_1.setBounds(0, 95, 385, 89);
			
			contentPane.add(panel_1);
			panel_2.setBorder(new MatteBorder(4, 0, 3, 0, (Color) new Color(0, 0, 51)));
			panel_2.setBackground(new Color(255, 255, 204));
			panel_2.setBounds(0, 60, 385, 40);
			
			contentPane.add(panel_2);
			
			JLabel Amount_pay = new JLabel("Amount to Pay");
			Amount_pay.setForeground(new Color(0, 0, 51));
			Amount_pay.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
			Amount_pay.setBounds(121, 182, 142, 25);
			contentPane.add(Amount_pay);
			
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(4, 0, 3, 0, (Color) new Color(0, 0, 51)));
			panel.setBackground(new Color(255, 255, 204));
			panel.setBounds(0, 177, 385, 35);
			contentPane.add(panel);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new MatteBorder(4, 0, 3, 0, (Color) new Color(0, 0, 51)));
			panel_3.setBackground(new Color(255, 255, 153));
			panel_3.setBounds(0, 207, 385, 80);
			contentPane.add(panel_3);
			user_id.setBounds(-2220, 71, 46, 14);
			contentPane.add(user_id);
	}
	
}