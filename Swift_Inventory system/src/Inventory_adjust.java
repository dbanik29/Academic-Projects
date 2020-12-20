import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

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
import javax.swing.border.MatteBorder;

public class Inventory_adjust extends JFrame {
	Connection connection=null;
	JLabel user_id = new JLabel("");
	
	private JPanel contentPane;
	JLabel avater = new JLabel("");
	JLabel avater_drop = new JLabel("");
	JLabel avater_drop1 = new JLabel("");
	JLabel avater_drop2 = new JLabel("");
	static String Time;
	String hour,min,sec;
	static int y=0;
	static int y1=375;
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
	int change;
	int enter=0;
	JLabel company_name = new JLabel("Javandro");
	 JLabel nav_top = new JLabel("");
	 JLabel top = new JLabel("");
	JLabel swift_logo = new JLabel("");
	String companyID="011151";
	static JLabel slide = new JLabel("");
	static JLabel slide1 = new JLabel("");
	 public JTextField Adjust_date = new JTextField();
	 public JTextField Adjust_id = new JTextField();
	 public JTextField New_quantity = new JTextField();
	 
	 public JTextField Product_code = new JTextField();
	 public JTextField SKU = new JTextField();
	 public JTextField Product_name = new JTextField();
	 public JTextField Quantity_in_hand = new JTextField();
	 public JTextField Quantity_change = new JTextField();
	 String date;
	 int in_hand;
	 int row;
	 int adjust;
	
	
	 String show="no";
	   JLabel border = new JLabel("Name");
	   JLabel help = new JLabel("");
	   JLabel cross = new JLabel("");
	
	    static Inventory_adjust frame = new Inventory_adjust();
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
	private final JScrollPane scrollPane = new JScrollPane();
	public JLabel title = new JLabel("Inventory Adjust");
	private final JLabel confirm = new JLabel("");
	private final JLabel delete_row = new JLabel("");
	private final JLabel update_row = new JLabel("");
	  
	public void show(String value){
		Adjust_id.setText(value);
		try{
    		
			String s1=" SELECT inventory_adjust.Product_code,inventory_adjust.SKU,inventory_adjust.Product_name, inventory_adjust.Quantity_in_hand,inventory_adjust.Change_quantity,inventory_adjust.New_quantity FROM inventory_adjust where inventory_adjust.Adjust_no='"+value+"' ";
		
			PreparedStatement pst=connection.prepareStatement(s1);
			ResultSet rs=pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setRowHeight(30);
			TableColumnModel column=table.getColumnModel();
			
			column.getColumn(0).setPreferredWidth(132);
			column.getColumn(1).setPreferredWidth(146);
			column.getColumn(2).setPreferredWidth(376);
			column.getColumn(3).setPreferredWidth(116);
			column.getColumn(4).setPreferredWidth(116);
			column.getColumn(5).setPreferredWidth(114);
			
			pst.close();
			rs.close();
			
			
			//JOptionPane.showMessageDialog(null, "Show");
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		show="yes";
	}
	public void edit(String value){
		
	}
    
    
    public void refresh_table(){
    	try{
    		
			String s1=" SELECT inventory_adjust.Product_code,inventory_adjust.SKU,inventory_adjust.Product_name, inventory_adjust.Quantity_in_hand,inventory_adjust.Change_quantity,inventory_adjust.New_quantity FROM inventory_adjust where inventory_adjust.Adjust_no='"+Adjust_id.getText()+"' ";
		
			PreparedStatement pst=connection.prepareStatement(s1);
			ResultSet rs=pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setRowHeight(30);
			TableColumnModel column=table.getColumnModel();
			
			column.getColumn(0).setPreferredWidth(132);
			column.getColumn(1).setPreferredWidth(146);
			column.getColumn(2).setPreferredWidth(376);
			column.getColumn(3).setPreferredWidth(116);
			column.getColumn(4).setPreferredWidth(116);
			column.getColumn(5).setPreferredWidth(114);
			
			pst.close();
			rs.close();
			
			
			//JOptionPane.showMessageDialog(null, "Show");
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
    }
    
    
	public Inventory_adjust() {
		connection =DatabaseConnect.DBConnectors();
		try{
			String query4="SELECT max(Adjust_no) as adjust_no FROM Inventory_adjust";
			PreparedStatement pst4=connection.prepareStatement(query4);
			ResultSet rs4=pst4.executeQuery();
			rs4.next();
			
			
			adjust=rs4.getInt("adjust_no");
			System.out.println(adjust);
			pst4.close();
			rs4.close();
			
		 }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		adjust++;
		
		Adjust_id.setForeground(new Color(0, 0, 0));
		Adjust_id.setHorizontalAlignment(SwingConstants.RIGHT);
		
		Adjust_id.setText(Integer.toString(adjust));
			
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	         System.out.println(Time);
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		date = sdf.format(new Date());
		Adjust_date.setForeground(new Color(0, 0, 0));
		Adjust_date.setHorizontalAlignment(SwingConstants.RIGHT);
		Adjust_date.setText(date);
		Adjust_date.setEditable(false);
		Adjust_date.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Adjust_date.setBackground(SystemColor.control);
		Adjust_date.setBounds(344, 81, 80, 23);
		Adjust_date.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
		Adjust_date.setColumns(10);
		Adjust_id.setEditable(false);
		Adjust_id.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Adjust_id.setBackground(SystemColor.control);
		Adjust_id.setBounds(567, 81, 80, 23);
		Adjust_id.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
		Adjust_id.setColumns(10);
		New_quantity.setEditable(false);
		New_quantity.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		New_quantity.setBackground(new Color(230, 235, 255));
		New_quantity.setBounds(1061, 163, 114, 23);
		New_quantity.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		New_quantity.setColumns(10);
		New_quantity.setHorizontalAlignment(SwingConstants.RIGHT);
		Product_code.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					try{
						String query="SELECT * FROM Inventory Where Product_code='"+Product_code.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						rs.next();
						//System.out.println(rs.getMetaData().toString());
						
						Product_name.setText(rs.getString("Product_name"));
						SKU.setText(rs.getString("SKU"));
						Quantity_in_hand.setText(rs.getString("Quantity_in_hand"));
					
						pst.close();
						rs.close();
						Quantity_change.grabFocus();
					    
						}
						catch(Exception e1){
							e1.printStackTrace();
						
						}
				   }
				
			}
		});
		Product_code.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.getSelectionModel().clearSelection();
				delete_row.setBounds(-126, 225, 84, 300);
				update_row.setBounds(-1180, 225, 84, 300);
			}
		});
		Product_code.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Product_code.setBackground(new Color(230, 235, 255));
		Product_code.setBounds(125, 163, 132, 23);
		Product_code.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		Product_code.setColumns(10);
		SKU.setEditable(false);
		SKU.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		SKU.setBackground(new Color(230, 235, 255));
		SKU.setBounds(267, 163, 146, 23);
		SKU.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		SKU.setColumns(10);
		Product_name.setEditable(false);
		Product_name.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Product_name.setBackground(new Color(230, 235, 255));
		Product_name.setBounds(423, 163, 376, 23);
		Product_name.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		Product_name.setColumns(10);
		Quantity_in_hand.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Quantity_in_hand.setBackground(new Color(230, 235, 255));
		Quantity_in_hand.setBounds(809, 163, 116, 23);
		Quantity_in_hand.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		Quantity_in_hand.setColumns(10);
		Quantity_change.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					if(show=="no"){
						try{
							String query="insert into Inventory_adjust(Adjust_no,Product_Code,SKU,Product_name,Date,Quantity_in_hand,New_quantity,Change_quantity,Status)  values(?,?,?,?,?,?,?,?,?) ";
							
							PreparedStatement pst=connection.prepareStatement(query);
								
							int quantitys=Integer.parseInt(Quantity_in_hand.getText())+Integer.parseInt(Quantity_change.getText());
								pst.setString(1, Adjust_id.getText());
								pst.setString(2, Product_code.getText());
								pst.setString(3, SKU.getText());
								pst.setString(4, Product_name.getText());
								pst.setString(5, Adjust_date.getText());
								pst.setString(6, Quantity_in_hand.getText());
								pst.setInt(7, quantitys);
								pst.setString(8, Quantity_change.getText());
								pst.setString(9, "SS");
								
								pst.execute();
								pst.close();
								
								//JOptionPane.showMessageDialog(null, "Data Add");
							}
						
						catch(Exception e1){
							//JOptionPane.showMessageDialog(null, "Quantity Get");
							e1.printStackTrace();
							
						}
					}
					else if(show=="yes"){
						
						try{
							String query="insert into Inventory_adjust(Adjust_no,Product_Code,SKU,Product_name,Date,Quantity_in_hand,New_quantity,Change_quantity,Status)  values(?,?,?,?,?,?,?,?,?) ";
							
							PreparedStatement pst=connection.prepareStatement(query);
								
							int quantitys=Integer.parseInt(Quantity_in_hand.getText())+Integer.parseInt(Quantity_change.getText());
								pst.setString(1, Adjust_id.getText());
								pst.setString(2, Product_code.getText());
								pst.setString(3, SKU.getText());
								pst.setString(4, Product_name.getText());
								pst.setString(5, Adjust_date.getText());
								pst.setString(6, Quantity_in_hand.getText());
								pst.setInt(7, quantitys);
								pst.setString(8, Quantity_change.getText());
								pst.setString(9, "SS");
								
								pst.execute();
								pst.close();
								
								//JOptionPane.showMessageDialog(null, "Data Add");
							
							String q1="UPDATE inventory SET Quantity_in_hand='"+quantitys+"'  WHERE inventory.Product_Code='"+Product_code.getText()+"'";
	                      
							PreparedStatement pst1=connection.prepareStatement(q1);
						
							pst1.execute();
							
							pst1.close();
							
							//JOptionPane.showMessageDialog(null, "Data Add");
						
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
					}
						
						Product_code.setText("");
						SKU.setText("");
						Product_name.setText("");
						Quantity_in_hand.setText("");
						Quantity_change.setText("");
						
						New_quantity.setText("");
						refresh_table();
						enter=0;
						Product_code.grabFocus();
					}
					
				}
				
		});
		Quantity_change.setFont(new Font("Futura Lt BT", Font.ITALIC, 14));
		
		Quantity_change.setBackground(new Color(230, 235, 255));
		Quantity_change.setBounds(935, 163, 116, 23);
		Quantity_change.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		Quantity_change.setColumns(10);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 1300, 530);
		setShape(new RoundRectangle2D.Double(00, 00, 1300, 530, 50, 0));
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
				avater_drop.setBounds(1140, -10, 160, 50);
				avater_drop1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.2.png")));
				avater_drop1.setBounds(1140, -10, 160, 41);
				avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
				avater_drop2.setBounds(1140, -10, 160, 41);
				i=1;
				table.getSelectionModel().clearSelection();
				
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				
			}
		});
		contentPane.setBackground(new Color(230, 235, 255));
		contentPane.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(0, 0, 51)));
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
		slide.setIcon(new ImageIcon(Retail.class.getResource("/img/slide.png")));
		slide.setBounds(-1300, 0, 1300, 375);
		
		contentPane.add(slide);
		slide1.setIcon(new ImageIcon(Retail.class.getResource("/img/slide.png")));
		slide1.setBounds(-1300, 375, 1300, 375);
		
		contentPane.add(slide1);
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
		help.setIcon(new ImageIcon(Dashboard.class.getResource("/img/help.png")));
		help.setBounds(1180, 0, 60, 60);
		contentPane.add(help);
		cross.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					cross.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cross3.png")));
					setVisible(false);
					frame.dispose(); //Destroy the JFrame object
					
					Inventory_adjust_edit Inventory_adjust_edit= new Inventory_adjust_edit();
					Inventory_adjust_edit.user_id.setText(user_id.getText());
					Inventory_adjust_edit.setVisible(true);
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
				if(title.getText()=="Adjustment Edit"){
					try{
						String q1=" UPDATE inventory SET inventory.Purchasing_Cost=(SELECT (cost.Fixed_rent+cost.Fixed_utilites+cost.Fixed_equipment+cost.Variable_direct_labor+cost.Variable_utilites+cost.Variable_materiales)/ SUM(inventory_adjust.Change_quantity) FROM cost, "; 
						String q2=" inventory_adjust WHERE  inventory_adjust.Product_code=cost.Product_code AND inventory.Product_code=inventory_adjust.Product_code) "; 
						
					
							PreparedStatement pst1=connection.prepareStatement(q1+q2);
						
							pst1.execute();
							pst1.close();
							setVisible(false);
							frame.dispose(); //Destroy the JFrame object
							
							//JOptionPane.showMessageDialog(null, "edit");
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							
							Message.setVisible(true);
							Message.Message.setText("Adjust Successfully Updated");
							Inventory_adjust_edit Inventory_adjust_edit= new Inventory_adjust_edit();
							Inventory_adjust_edit.setVisible(true);
							Inventory_adjust_edit.user_id.setText(user_id.getText());
							
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
				else if(title.getText()=="Inventory Adjust"){
					try{
						String q1="UPDATE inventory SET inventory.Quantity_in_hand=Quantity_in_hand+(SELECT inventory_adjust.Change_quantity FROM inventory_adjust WHERE inventory_adjust.Adjust_no='"+adjust+"' and inventory_adjust.Product_code=inventory.Product_code), "; 
						String q2=" inventory.Purchasing_Cost=(SELECT (cost.Fixed_rent+cost.Fixed_utilites+cost.Fixed_equipment+cost.Variable_direct_labor+cost.Variable_utilites+cost.Variable_materiales)/ SUM(inventory_adjust.Change_quantity) FROM cost, "; 
						String q3=" inventory_adjust WHERE  inventory_adjust.Product_code=cost.Product_code AND inventory.Product_code=inventory_adjust.Product_code) ";
						String q4=" WHERE Product_code in (SELECT inventory_adjust.Product_code   FROM inventory_adjust  WHERE inventory_adjust.Product_code=inventory.Product_code AND inventory_adjust.Adjust_no='"+adjust+"' ) ";
					
							PreparedStatement pst1=connection.prepareStatement(q1+q2+q3+q4);
						
							pst1.execute();
							pst1.close();
							
							//JOptionPane.showMessageDialog(null, "Data Add");
							setVisible(false);
							frame.dispose(); //Destroy the JFrame object
							
							//JOptionPane.showMessageDialog(null, "edit");
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Adjust Successfull");
							Inventory_adjust_edit Inventory_adjust_edit= new Inventory_adjust_edit();
							Inventory_adjust_edit.user_id.setText(user_id.getText());
							Inventory_adjust_edit.setVisible(true);
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
		
		
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		title.setBounds(222, 16, 258, 28);
		
		contentPane.add(title);
		cross.setIcon(new ImageIcon(Invoice_create.class.getResource("/img/cross1.png")));
		cross.setBounds(0, 0, 60, 60);
		contentPane.add(cross);
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(77, 12, 107, 35);
		
		contentPane.add(swift_logo);
		top.setIcon(new ImageIcon(Invoice_create.class.getResource("/img/top.png")));
		
		
		top.setEnabled(false);
		top.setBounds(200, 0, 1049, 60);
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
		contentPane.add(Adjust_date);
		contentPane.add(Adjust_id);
		contentPane.add(New_quantity);
		contentPane.add(Product_code);
		contentPane.add(SKU);
		contentPane.add(Product_name);
		contentPane.add(Quantity_in_hand);
		contentPane.add(Quantity_change);
		
		JLabel adjust_date = new JLabel("Adjustment Date");
		adjust_date.setForeground(new Color(0, 0, 51));
		adjust_date.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		adjust_date.setBounds(222, 85, 129, 14);
		contentPane.add(adjust_date);
		
		JLabel adjust_id = new JLabel("Adjust No.");
		adjust_id.setForeground(new Color(0, 0, 51));
		adjust_id.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		adjust_id.setBounds(445, 85, 129, 14);
		contentPane.add(adjust_id);
		
		JLabel new_quantity = new JLabel("New Quantity");
		new_quantity.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		new_quantity.setBounds(1061, 139, 100, 14);
		contentPane.add(new_quantity);
		
		
		JLabel product_code = new JLabel("Product Code");
		product_code.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		product_code.setBounds(127, 139, 112, 14);
		contentPane.add(product_code);
		
		JLabel sku = new JLabel("SKU");
		sku.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		sku.setBounds(267, 139, 90, 14);
		contentPane.add(sku);
		
		JLabel product_name = new JLabel("Product Name");
		product_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		product_name.setBounds(423, 139, 149, 14);
		contentPane.add(product_name);
		
		JLabel quantity = new JLabel("Quantity in Hand");
		quantity.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		quantity.setBounds(809, 139, 116, 14);
		contentPane.add(quantity);
		
		JLabel quantity_change = new JLabel("Quantity Change");
		quantity_change.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		quantity_change.setBounds(935, 139, 122, 14);
		contentPane.add(quantity_change);
		
		scrollPane.setBounds(125, 197, 1050, 300);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		confirm.setIcon(new ImageIcon(Inventory_adjust.class.getResource("/img/confirm1.png")));
		confirm.setBounds(1011, 68, 150, 41);
		
		contentPane.add(confirm);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setDefaultEditor(Object.class, null);
		table.setRowSelectionAllowed(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Eras Medium ITC", Font.PLAIN, 13));
		
		table.setBackground(new Color(230, 250, 255));
		
		table.getTableHeader().setUI(null);
		Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		
		scrollPane.setBorder(emptyBorder2);
		
		scrollPane.setBackground(new Color(230, 250, 255));
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row=table.getSelectedRow();
				
					delete_row.setBounds(20, 197, 84, 300);
					update_row.setBounds(1198, 197, 84, 300);
				
			}
		});
		table.setTableHeader(null);
		delete_row.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				delete_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				delete_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				delete_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete3.png")));
				String value = table.getModel().getValueAt(row, 0).toString();
				String value1 = table.getModel().getValueAt(row, 4).toString();
				System.out.println(value);
				
				
				try{
					if(title.getText()=="Adjustment Edit"){
						
						String q1="UPDATE inventory SET Quantity_in_hand='"+Quantity_in_hand.getText()+"'  WHERE inventory.Product_Code='"+Product_code.getText()+"'";
	                    
						PreparedStatement pst2=connection.prepareStatement(q1);
					
						pst2.execute();
						pst2.close();
						
					}
					String query1="delete from inventory_adjust where Adjust_no='"+Adjust_id.getText()+"' and Product_Code='"+value+"'";
					
					PreparedStatement pst1=connection.prepareStatement(query1);
					
					pst1.execute();
					pst1.close();
					refresh_table();
					
					//JOptionPane.showMessageDialog(null, "Data Add");
					
				}
				catch(Exception e1){
					//JOptionPane.showMessageDialog(null, "Quantity Get");
				}
				
				delete_row.setBounds(-200, 197, 84, 300);
				update_row.setBounds(-1198, 197, 84, 300);
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				delete_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				delete_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/bdelete1.png")));
			}
		});
		
		update_row.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				update_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				update_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				update_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update3.png")));
				String value = table.getModel().getValueAt(row, 0).toString();
				String value1 = table.getModel().getValueAt(row, 4).toString();
				System.out.println(value);
				try{
					String s1="SELECT inventory_adjust.Product_code, inventory_adjust.SKU, inventory_adjust.Product_name, inventory_adjust.Quantity_in_hand";
					String s2=" FROM inventory_adjust where Adjust_no='"+Adjust_id.getText()+"' and Product_Code='"+value+"' ";
					
				
					PreparedStatement pst=connection.prepareStatement(s1+s2);
					ResultSet rs=pst.executeQuery();
					rs.next();

					Product_code.setText(rs.getString(1));
					SKU.setText(rs.getString(2));
					Product_name.setText(rs.getString(3));
					Quantity_in_hand.setText(rs.getString(4));
				
					pst.close();
					rs.close();
					
					Quantity_change.grabFocus();
					
					if(title.getText()=="Adjustment Edit"){
						
						String q1="UPDATE inventory SET Quantity_in_hand='"+Quantity_in_hand.getText()+"'  WHERE inventory.Product_Code='"+Product_code.getText()+"'";
	                    
						PreparedStatement pst2=connection.prepareStatement(q1);
					
						pst2.execute();
						pst2.close();
						
					}
					
					
					
					String query1="delete from inventory_adjust where Adjust_no='"+Adjust_id.getText()+"' and Product_Code='"+value+"'";
					
					PreparedStatement pst1=connection.prepareStatement(query1);
					
					pst1.execute();
				
					pst1.close();
					refresh_table();
					
					//JOptionPane.showMessageDialog(null, "Update");
					
				}
				catch(Exception e1){
					//JOptionPane.showMessageDialog(null, "Quantity Get");
					e1.printStackTrace();
				}
				delete_row.setBounds(-200, 197, 84, 300);
				update_row.setBounds(-1198, 197, 84, 300);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				update_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				update_row.setIcon(new ImageIcon(Dashboard.class.getResource("/img/update1.png")));
			}
		});
		JLabel lblRetailInformation = new JLabel("Adjust Information");
		lblRetailInformation.setForeground(new Color(0, 0, 51));
		lblRetailInformation.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		lblRetailInformation.setBounds(29, 83, 226, 18);
		contentPane.add(lblRetailInformation);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(4, 0, 3, 0, (Color) new Color(0, 0, 51)));
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(210, 60, 1090, 58);
		contentPane.add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(4, 0, 3, 0, (Color) new Color(0, 0, 51)));
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 60, 1300, 58);
		contentPane.add(panel);
		delete_row.setIcon(new ImageIcon(Inventory_adjust.class.getResource("/img/bdelete1.png")));
		delete_row.setBounds(-200, 197, 84, 300);
		
		contentPane.add(delete_row);
		update_row.setIcon(new ImageIcon(Inventory_adjust.class.getResource("/img/update1.png")));
		update_row.setBounds(-1195, 197, 84, 300);
		
		contentPane.add(update_row);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
		
	}
}