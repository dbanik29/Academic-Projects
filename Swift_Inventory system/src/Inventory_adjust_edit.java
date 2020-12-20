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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

public class Inventory_adjust_edit extends JFrame {
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
	 JLabel nav_top = new JLabel("");
	JLabel swift_logo = new JLabel("");
	 JLabel refreshes = new JLabel("");
	 JLabel dashboard_M = new JLabel("");
	JLabel sale_M = new JLabel("");
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
	    int no_invoice;
	    String customers_name;
	    int balance;
	    int total;
	    int cus_invoice;
	    String invoice_no;
	    int paid_no=0;
	    int unpaid_no=0;
	    String sales_status;
	    int cod_invoice=0;
	
	    static Inventory_adjust_edit frame = new Inventory_adjust_edit();
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
	private JTable table;
	private final JTextField Search = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblDate = new JLabel("Date");
	private final JLabel lblRefId = new JLabel("Ref ID");
	private final JLabel lblAmount = new JLabel("Amount");
	private final JLabel lblEmployeeId = new JLabel("Employee ID");
	private final JLabel supplier = new JLabel("");
	private final JLabel inventory_adjust = new JLabel("");
	private final JPanel panel = new JPanel();
	
    public void refresh_table(){
    	try{
			
			String s1="SELECT *  FROM inventory_adjust";
			
			PreparedStatement pst=connection.prepareStatement(s1);
			ResultSet rs=pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setRowHeight(30);
			
			pst.close();
			rs.close();
			
			//JOptionPane.showMessageDialog(null, "Show");
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
    }
	public void refresh(){
		try{
			
			String s1="SELECT Adjust_no, Product_code, Date from inventory_adjust  where Adjust_no LIKE '%" + Search.getText() + "%' or Product_code LIKE '%" + Search.getText() + "%'  or Date LIKE '%" + Search.getText() + "'";
			
			PreparedStatement pst=connection.prepareStatement(s1);
			ResultSet rs=pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setRowHeight(30);
			
			pst.close();
			rs.close();
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
	}
	public Inventory_adjust_edit() {
		connection =DatabaseConnect.DBConnectors();
		
		
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
					i=2;
				}
				else if(i%2==0){
					avater.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater2.png")));
					avater_drop.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.1.png")));
					avater_drop.setBounds(1140, -10, 160, 50);
					avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
					avater_drop1.setBounds(1140, -10, 160, 41);
					avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
					avater_drop2.setBounds(1140, -10, 160, 41);
					i=1;
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
				refreshes.setIcon(new ImageIcon(Dashboard.class.getResource("/img/refresh1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				refreshes.setIcon(new ImageIcon(Dashboard.class.getResource("/img/refresh.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					refreshes.setIcon(new ImageIcon(Dashboard.class.getResource("/img/refresh2.png")));
					refresh_table();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				refreshes.setIcon(new ImageIcon(Dashboard.class.getResource("/img/refresh1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				refreshes.setIcon(new ImageIcon(Dashboard.class.getResource("/img/refresh.png")));
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
		
		avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
		avater_drop2.setBounds(1140, -10, 160, 41);
		contentPane.add(avater_drop2);
		search_box.setFont(new Font("Tahoma", Font.ITALIC, 14));
		search_box.setBackground(new Color(0,0,0,0));
		search_box.setBounds(-955, 11, 200, 36);
		search_box.setColumns(10);
		
		contentPane.add(search_box);
		
		refreshes.setIcon(new ImageIcon(Retail_sales.class.getResource("/img/refresh.png")));
		refreshes.setBounds(200, 0, 60, 60);
		contentPane.add(refreshes);
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(10, 12, 107, 35);
		
		contentPane.add(swift_logo);
		nav_top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/nav_top.png")));
		nav_top.setBounds(0, 0, 200, 60);
		
		contentPane.add(nav_top);
		
		JLabel title = new JLabel("Inventory Adjustment Summay");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		title.setBounds(270, 17, 445, 28);
		contentPane.add(title);
		
		JLabel top = new JLabel("");
		top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/top.png")));
		top.setEnabled(false);
		top.setBounds(0, 0, 1300, 60);
		contentPane.add(top);
		
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
		inventory_adjust.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				inventory_adjust.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory_adjust2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				inventory_adjust.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory_adjust1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				inventory_adjust.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory_adjust3.png")));
				setVisible(false);
				frame.dispose();
				Inventory_adjust Inventory_adjust= new Inventory_adjust();
				Inventory_adjust.user_id.setText(user_id.getText());
				Inventory_adjust.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				inventory_adjust.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory_adjust2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				inventory_adjust.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory_adjust1.png")));
			}
		});
		dashboard_M.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
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
				frame.dispose();
				Sales Sales= new Sales();
				Sales.user_id.setText(user_id.getText());
				Sales.setVisible(true);
				if(l%2==0){
					
					l2=1;
					sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale2.png")));
					
					
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
					
					l=1;
					
				}
				else if(l%2!=0){
						l2=1;
					sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale2.png")));
					
					
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
					l=2;
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
					if(l%2!=0){
						sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale1.png")));
					
					cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash1.png")));
					cash.setBounds(0, 147, 200, 40);
					
					
					expense.setIcon(new ImageIcon(Dashboard.class.getResource("/img/expense1.png")));
					expense.setBounds(0, 187, 200, 40);
					l=2;
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
		
		
		sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale1.png")));
		sale_M.setBounds(0, 107, 200, 40);
		contentPane.add(sale_M);
		
		cash.setIcon(new ImageIcon(Customer.class.getResource("/img/cash1.png")));
		cash.setBounds(0, 147, 200, 40);
		contentPane.add(cash);
		
		expense.setIcon(new ImageIcon(Customer.class.getResource("/img/expense1.png")));
		expense.setBounds(0, 186, 200, 40);
		contentPane.add(expense);
		
		inventory.setIcon(new ImageIcon(Customer.class.getResource("/img/inventory1.png")));
		inventory.setBounds(0, 226, 200, 40);
		contentPane.add(inventory);
		
		return_inventory.setIcon(new ImageIcon(Customer.class.getResource("/img/return_inventory1.png")));
		return_inventory.setBounds(0, 265, 200, 35);
		contentPane.add(return_inventory);
		
		reports.setIcon(new ImageIcon(Customer.class.getResource("/img/report1.png")));
		reports.setBounds(0, 300, 200, 40);
		contentPane.add(reports);
		
		cost.setIcon(new ImageIcon(Customer.class.getResource("/img/cost1.png")));
		cost.setBounds(0, 340, 200, 40);
		contentPane.add(cost);
		
		accounting.setIcon(new ImageIcon(Customer.class.getResource("/img/accounting1.png")));
		accounting.setBounds(0, 380, 200, 40);
		contentPane.add(accounting);
		
		employee.setIcon(new ImageIcon(Customer.class.getResource("/img/employee1.png")));
		employee.setBounds(0, 420, 200, 40);
		contentPane.add(employee);
		border.setFont(new Font("Tahoma", Font.ITALIC, 15));
		border.setForeground(SystemColor.textInactiveText);
		border.setBounds(382, -171, 72, 17);
		
		contentPane.add(border);
		scrollPane.setBounds(218, 160, 1060, 550);
		
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.setFillsViewportHeight(true);
		table.setDefaultEditor(Object.class, null);
		table.setRowSelectionAllowed(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Eras Medium ITC", Font.PLAIN, 13));
		
		table.setBackground(new Color(230, 250, 255));
		
		table.getTableHeader().setUI(null);
		
		scrollPane.setViewportView(table);
		scrollPane.setBackground(new Color(230, 250, 255));
		scrollPane.setViewportBorder(null);
		Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		scrollPane.setBorder(emptyBorder);
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
		Search.setText("Search");
		Search.setForeground(Color.GRAY);
		Search.setFont(new Font("Futura Lt BT", Font.PLAIN, 14));
		Search.setColumns(10);
		Search.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Search.setBackground(new Color(230, 235, 255));
		Search.setBounds(218, 80, 300, 25);
		
		contentPane.add(Search);
		
		try{
			String s1="SELECT *  FROM inventory_adjust";
			
			PreparedStatement pst=connection.prepareStatement(s1);
			ResultSet rs=pst.executeQuery();
			
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setRowHeight(30);
			
			pst.close();
			rs.close();
			
			//JOptionPane.showMessageDialog(null, "Show");
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		lblDate.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		lblDate.setBounds(317, 133, 107, 14);
		
		contentPane.add(lblDate);
		lblRefId.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		lblRefId.setBounds(578, 133, 112, 14);
		
		contentPane.add(lblRefId);
		lblAmount.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		lblAmount.setBounds(823, 133, 90, 14);
		
		contentPane.add(lblAmount);
		lblEmployeeId.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		lblEmployeeId.setBounds(1080, 133, 100, 14);
		
		contentPane.add(lblEmployeeId);
		supplier.setIcon(new ImageIcon(Retail_sales.class.getResource("/img/supplier1.png")));
		supplier.setBounds(0, 460, 200, 40);
		
		contentPane.add(supplier);
		inventory_adjust.setIcon(new ImageIcon(Inventory_adjust_edit.class.getResource("/img/inventory_adjust1.png")));
		inventory_adjust.setBounds(1130, 71, 150, 41);
		
		contentPane.add(inventory_adjust);
		panel.setBorder(new MatteBorder(4, 0, 3, 0, (Color) new Color(0, 0, 51)));
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(218, 120, 1060, 35);
		
		contentPane.add(panel);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
	}
	
}

