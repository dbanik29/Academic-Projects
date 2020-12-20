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

public class Payment_mass extends JFrame {
	Connection connection=null;
	
	public JLabel Message = new JLabel("Message");
	JLabel user_id = new JLabel("");
	
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
	String payment;
	String date;
	String customer;
	String amount;
	String transaction;
	
	JLabel swift_logo = new JLabel("");
	 JLabel edit = new JLabel("");
	JLabel cancel = new JLabel("");
	    
	
	    static Payment_mass frame = new Payment_mass();
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
	private final JLabel delete = new JLabel("");
	private final JLabel show = new JLabel("");
	
	public Payment_mass() {
		connection =DatabaseConnect.DBConnectors();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 220, 340);
		setShape(new RoundRectangle2D.Double(00, 00, 220, 340, 50, 50));
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getSize().height; //get the heigth of the frame
        int framelocationX=(dim.width-framewidth)/2; 
        int framelocationY=(dim.height-frameheigth)/2;
        this.setLocation(framelocationX,framelocationY);
		
		contentPane = new JPanel();
		
		
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
		
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(k%2!=0){
					edit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edit2.png")));
					
					k++;
				}
				else if(k%2==0){
					edit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edit2.png")));
					
					k++;
				}
				setVisible(false);
				frame.dispose(); //Destroy the JFrame object
			
				
				Payment_receive Payment_receive= new Payment_receive();
				Payment_receive.user_id.setText(user_id.getText());
				Payment_receive.setVisible(true);
				
				Payment_receive.edit(payment,date, customer, amount, transaction);
				Payment_receive.title.setText("Payment Receive Edit");
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				edit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edit2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				edit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edit1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(k%2!=0){
					edit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edit1.png")));
					
				}
				else if(k%2==0){
					edit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/edit1.png")));
					
				}
			}
		});
		
		edit.setIcon(new ImageIcon(Customer_mass.class.getResource("/img/edit1.png")));
		edit.setBounds(35, 111, 150, 41);
		contentPane.add(edit);
		
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
		
		show.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				show.setIcon(new ImageIcon(Dashboard.class.getResource("/img/show2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				show.setIcon(new ImageIcon(Dashboard.class.getResource("/img/show1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				show.setIcon(new ImageIcon(Dashboard.class.getResource("/img/show3.png")));
				setVisible(false);
				frame.dispose(); //Destroy the JFrame object
			
				Payment_receive Payment_receive= new Payment_receive();
				Payment_receive.user_id.setText(user_id.getText());
				Payment_receive.setVisible(true);
				
				Payment_receive.show(payment,date, customer, amount, transaction);
				Payment_receive.Amount.disable();
				Payment_receive.CustomerID.disable();
				Payment_receive.title.setText("Payment Receive Show");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				show.setIcon(new ImageIcon(Dashboard.class.getResource("/img/show2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				show.setIcon(new ImageIcon(Dashboard.class.getResource("/img/show1.png")));
			}
		});
		
		
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/delete2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/delete1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/delete3.png")));
				try{
					
					String query2="delete from Transactions where Payment_id='"+payment+"' and Customer_id='"+customer+"'";
					
					PreparedStatement pst2=connection.prepareStatement(query2);
					
					pst2.execute();
					pst2.close();
					//JOptionPane.showMessageDialog(null, "delete");
					setVisible(false);
					frame.dispose();
					
					Message Message= new Message();
					Message.user_id.setText(user_id.getText());
					Message.setVisible(true);
					Message.Message.setText("Successfully Delete");
					Payment Payment= new Payment();
					Payment.user_id.setText(user_id.getText());
					Payment.refresh_table();
				}
				catch(Exception e1){
					//JOptionPane.showMessageDialog(null, "Quantity Get");
					e1.printStackTrace();
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/delete2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				delete.setIcon(new ImageIcon(Dashboard.class.getResource("/img/delete1.png")));
			}
		});
		cancel.setIcon(new ImageIcon(Customer_mass.class.getResource("/img/cancel1.png")));
		cancel.setBounds(35, 268, 150, 41);
		contentPane.add(cancel);
		delete.setIcon(new ImageIcon(Payment_mass.class.getResource("/img/delete1.png")));
		delete.setBounds(35, 215, 150, 41);
		
		contentPane.add(delete);
		show.setIcon(new ImageIcon(Invoice_mass.class.getResource("/img/show1.png")));
		show.setBounds(35, 163, 150, 41);
		
		contentPane.add(show);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
	        
	}
	
}