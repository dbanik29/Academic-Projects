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
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class COD_payment extends JFrame {
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
	String date;
	JLabel swift_logo = new JLabel("");
	 String Customer_id;
	 String Total;
	 String Invoice;
	 String Employee_id;
	 
	    static COD_payment frame = new COD_payment();
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
	private final JLabel paid = new JLabel("");
	private final JLabel cancel = new JLabel("");
	public void invoice(String value){
	}
	
	public COD_payment() {
		connection =DatabaseConnect.DBConnectors();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		date = sdf.format(new Date());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 220, 220);
		setShape(new RoundRectangle2D.Double(00, 00, 220, 220, 50, 50));
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getSize().height; //get the heigth of the frame
        int framelocationX=(dim.width-framewidth)/2; 
        int framelocationY=(dim.height-frameheigth)/2;
        this.setLocation(framelocationX,framelocationY);
		
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(47, 79, 79));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(56, 11, 107, 35);
		
		contentPane.add(swift_logo);
		
		JLabel top = new JLabel("");
		top.setBackground(Color.LIGHT_GRAY);
		top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/top.png")));
		top.setEnabled(false);
		top.setBounds(0, 0, 350, 60);
		contentPane.add(top);
		
		
		Message.setForeground(Color.WHITE);
		Message.setHorizontalAlignment(SwingConstants.CENTER);
		Message.setFont(new Font("Tahoma", Font.BOLD, 14));
		Message.setBounds(10, 69, 200, 31);
		contentPane.add(Message);
		paid.setIcon(new ImageIcon(COD_payment.class.getResource("/img/cod_paid1.png")));
		paid.setBounds(35, 106, 150, 41);
		paid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				paid.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod_paid2.png")));
				try{
					
					String query6="SELECT max(Payment_id) as payment_id FROM Transactions";
					PreparedStatement pst6=connection.prepareStatement(query6);
					ResultSet rs6=pst6.executeQuery();
					rs6.next();
					
					int Payment_id=rs6.getInt("payment_id");
					
					System.out.println(Payment_id);
					pst6.close();
					rs6.close();
					
					String query5="insert into Transactions(Payment_id,Customer_id,Employee_id,Date,Type,Amount,Transaction_type,Invoice_no)  values(?,?,?,?,?,?,?,?) ";
					
					PreparedStatement pst5=connection.prepareStatement(query5);
					Payment_id++;
					pst5.setInt(1, Payment_id);
					pst5.setString(2, Customer_id);
					pst5.setString(3, user_id.getText());
					pst5.setString(4, date);
					pst5.setString(5, "Credit O");
					pst5.setString(6, Total);
					pst5.setString(7, "Cash");
					pst5.setString(8, Invoice);
					
					String q1="UPDATE order_status SET Sales_Status='COD P' where Invoice_no='"+Invoice+"'";
                  
					PreparedStatement pst1=connection.prepareStatement(q1);
				
					pst1.execute();
					pst1.close();
					pst5.execute();
					pst5.close();
					setVisible(false);
					frame.dispose(); //Destroy the JFrame object
				
					Message Message= new Message();
					Message.setVisible(true);
					Message.Message.setText("Successfully Paid");
					COD_sales.frame.refresh_table();
				 }catch (Exception e2) {
			         System.out.println("Got an exception!"); 
			         e2.printStackTrace();
			      }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				paid.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod_paid2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				paid.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod_paid1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				paid.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod_paid1.png")));
					
			}
		});
		contentPane.add(paid);
		cancel.setIcon(new ImageIcon(COD_payment.class.getResource("/img/cancel1.png")));
		cancel.setBounds(35, 158, 150, 41);
		
		contentPane.add(cancel);
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cancel.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cancel2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cancel.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cancel1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
				cancel.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cancel3.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				cancel.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cancel2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				cancel.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cancel1.png")));
			}
		});
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
	}
}