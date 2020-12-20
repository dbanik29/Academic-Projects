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
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JCheckBox;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
public class Inventory_detail extends JFrame {
	Connection connection=null;
	JLabel user_id = new JLabel("");
	public static class MyActionListener10 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
        	
        	if(Code.getText().equals("")){
        		
        	}
        	else{
        		if(Code.getText().length()==5){
            		message1.setText("OK");
            	}
            	else{
            		message1.setText("Not OK");
            	}
        	}
        }
	}
	
	static Timer time10=new Timer(10,new MyActionListener10());
	private JPanel contentPane;
	 public static JLabel message1 = new JLabel("");
	JLabel avater_drop = new JLabel("");
	JLabel avater_drop1 = new JLabel("");
	JLabel avater_drop2 = new JLabel("");
	static String Time;
	String hour,min,sec;
	String str;
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
	 public JTextField Product_des = new JTextField();
	 
	 public JTextField Cost_des = new JTextField();
	 public static JTextField Code = new JTextField();
	 public JTextField SKU = new JTextField();
	 public JTextField Quantity = new JTextField();
	 public JTextField As_of_date = new JTextField();
	 public JTextField Cost = new JTextField();
	 public JTextField Price = new JTextField();
	 public JTextField Sale_des = new JTextField();
	 public JComboBox Category = new JComboBox();
	 public JComboBox Inventory_asset = new JComboBox();
	 
	   JLabel border = new JLabel("Name");
	    JTextField search_box = new JTextField();
	    

	    static Inventory_detail frame = new Inventory_detail();
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
	
	public ObservingTextField dateText;
	public  JComboBox Income_ac = new JComboBox();
	public  JComboBox Expense_ac = new JComboBox();
	 JTextField Product_name;
	 public  JLabel edit = new JLabel("Edit");
	 public JLabel message2 = new JLabel("");
	
    public void show(String code){
    	try{
			Code.setText(code);
			String query="SELECT * FROM Inventory Where Product_code='"+Code.getText()+"'";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			
			Product_name.setText(rs.getString("Product_name"));
			Product_des.setText(rs.getString("Product_Des"));
			SKU.setText(rs.getString("SKU"));
			Category.setSelectedItem(rs.getString("Category"));
			Quantity.setText(rs.getString("Quantity_in_hand"));
			As_of_date.setText(rs.getString("As_of_date"));
			Inventory_asset.setSelectedItem(rs.getString("Inventory_Asset_ac"));
			Price.setText(rs.getString("Sales_Rate"));
			Sale_des.setText(rs.getString("Sales_Des"));
			Income_ac.setSelectedItem(rs.getString("Income_Ac"));
			
			String q1="SELECT ((cost.Fixed_rent+cost.Fixed_utilites+cost.Fixed_equipment+cost.Variable_direct_labor+cost.Variable_utilites+cost.Variable_materiales)/(inventory.Quantity_in_hand)) as Cost ";
			String q2="FROM cost, inventory  WHERE cost.Product_code='"+Code.getText()+"'  and inventory.Product_code='"+Code.getText()+"'";
			PreparedStatement pst1=connection.prepareStatement(q1+q2);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();
			Cost.setText(rs1.getString("Cost"));
			
			pst1.close();
			rs1.close();
			
			Cost_des.setText(rs.getString("Purchasing_Des"));
			Expense_ac.setSelectedItem(rs.getString("Expense_AC"));
			
			pst.close();
			rs.close();

			
			//JOptionPane.showMessageDialog(null, "Show");
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
    }
    String[] ar = new String[31];
	
	
	int ar1=0;
	public Inventory_detail() {
		connection =DatabaseConnect.DBConnectors();
		
		
		
		
		
		
		
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	         
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		Product_des.setForeground(new Color(0, 0, 0));
		Product_des.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Product_des.setBackground(new Color(255, 255, 204));
		Product_des.setBounds(179, 181, 411, 23);
		Product_des.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Product_des.setColumns(10);
		Cost_des.setForeground(new Color(0, 0, 0));
		Cost_des.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Cost_des.setBackground(new Color(255, 255, 204));
		Cost_des.setBounds(179, 529, 411, 23);
		Cost_des.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Cost_des.setColumns(10);
		Code.setForeground(new Color(0, 0, 0));
		Code.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Code.setBackground(new Color(255, 255, 204));
		Code.setBounds(30, 114, 120, 23);
		Code.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Code.setColumns(10);
		SKU.setForeground(new Color(0, 0, 0));
		SKU.setFont(new Font("Garamond", Font.BOLD, 16));
		
		SKU.setBackground(new Color(255, 255, 204));
		SKU.setBounds(30, 181, 132, 23);
		SKU.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		SKU.setColumns(10);
		Quantity.setForeground(new Color(0, 0, 0));
		Quantity.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Quantity.setBackground(new Color(255, 255, 204));
		Quantity.setBounds(255, 248, 142, 23);
		Quantity.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Quantity.setColumns(10);
		As_of_date.setForeground(new Color(0, 0, 0));
		As_of_date.setFont(new Font("Garamond", Font.BOLD, 16));
		
		As_of_date.setBackground(new Color(255, 255, 204));
		As_of_date.setBounds(415, 248, 176, 23);
		As_of_date.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		As_of_date.setColumns(10);
		Cost.setForeground(new Color(0, 0, 0));
		
		Cost.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Cost.setBackground(new Color(255, 255, 204));
		Cost.setBounds(30, 529, 139, 23);
		Cost.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Cost.setColumns(10);
		Price.setForeground(new Color(0, 0, 0));
		Price.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Price.setBackground(new Color(255, 255, 204));
		Price.setBounds(30, 387, 139, 23);
		Price.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Price.setColumns(10);
		Sale_des.setForeground(new Color(0, 0, 0));
		Sale_des.setFont(new Font("Garamond", Font.BOLD, 16));
		
		Sale_des.setBackground(new Color(255, 255, 204));
		Sale_des.setBounds(179, 387, 412, 23);
		Sale_des.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Sale_des.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 620, 661);
		setShape(new RoundRectangle2D.Double(00, 00, 620, 661, 50, 0));
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
		
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		edit.setBounds(210, 15, 215, 28);
		
		contentPane.add(edit);
		
		JLabel cross = new JLabel("");
		cross.setIcon(new ImageIcon(Inventory_detail.class.getResource("/img/cross1.png")));
		cross.setBounds(0, 0, 60, 60);
		contentPane.add(cross);
		
		JLabel saves = new JLabel("");
		saves.setIcon(new ImageIcon(Inventory_detail.class.getResource("/img/saves1.png")));
		saves.setBounds(560, 0, 60, 60);
		contentPane.add(saves);
		
		
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
		
		
		border.setFont(new Font("Tahoma", Font.ITALIC, 15));
		border.setForeground(SystemColor.textInactiveText);
		border.setBounds(382, -171, 72, 17);
		
		contentPane.add(border);
		contentPane.add(Product_des);
		contentPane.add(Cost_des);
		contentPane.add(Code);
		contentPane.add(SKU);
		contentPane.add(Quantity);
		contentPane.add(As_of_date);
		contentPane.add(Cost);
		contentPane.add(Price);
		contentPane.add(Sale_des);
		
		JLabel product_des = new JLabel("Product Description");
		product_des.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		product_des.setBounds(179, 157, 411, 14);
		contentPane.add(product_des);
		
		JLabel cost_des = new JLabel("Cost Description");
		cost_des.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		cost_des.setBounds(179, 505, 185, 14);
		contentPane.add(cost_des);
		
		JLabel category = new JLabel("Category");
		category.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		category.setBounds(30, 224, 132, 14);
		contentPane.add(category);
		
		JLabel code = new JLabel("Product Code");
		code.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		code.setBounds(30, 90, 120, 14);
		contentPane.add(code);
		
		JLabel sku = new JLabel("SKU");
		sku.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		sku.setBounds(30, 157, 46, 14);
		contentPane.add(sku);
		
		JLabel expense_ac = new JLabel("Expense Account");
		expense_ac.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		expense_ac.setBounds(30, 578, 133, 14);
		contentPane.add(expense_ac);
		
		JLabel inventory_asset = new JLabel("Inventory Asset Account");
		inventory_asset.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		inventory_asset.setBounds(30, 291, 225, 14);
		contentPane.add(inventory_asset);
		
		JLabel quantity = new JLabel("Quantity In Hand");
		quantity.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		quantity.setBounds(255, 221, 120, 14);
		contentPane.add(quantity);
		
		JLabel as_of_date = new JLabel("As of Date");
		as_of_date.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		as_of_date.setBounds(415, 221, 98, 14);
		contentPane.add(as_of_date);
		
		JLabel cost = new JLabel("Cost");
		cost.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		cost.setBounds(30, 502, 46, 14);
		contentPane.add(cost);
		
		JLabel price = new JLabel("Price or Rate");
		price.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		price.setBounds(30, 366, 107, 14);
		contentPane.add(price);
		
		JLabel sale_des = new JLabel("Sales Description");
		sale_des.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		sale_des.setBounds(179, 366, 173, 14);
		contentPane.add(sale_des);
		
		JLabel income_ac = new JLabel("Income Account");
		income_ac.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		income_ac.setBounds(30, 425, 174, 14);
		contentPane.add(income_ac);
		Category.setForeground(new Color(0, 0, 0));
		Category.setBackground(new Color(255, 255, 204));
		Category.setFont(new Font("Garamond", Font.BOLD, 16));
		Category.setBounds(30, 248, 215, 20);
		contentPane.add(Category);
		Category.addItem("Book");
		Category.addItem("Stationary Materials");
		Category.addItem("Other");
		
		Inventory_asset.setForeground(new Color(0, 0, 0));
		Inventory_asset.setBackground(new Color(255, 255, 204));
		
		Inventory_asset.setFont(new Font("Garamond", Font.BOLD, 16));
		Inventory_asset.setBounds(30, 315, 560, 20);
		
		Inventory_asset.addItem("Inventory");
		Inventory_asset.addItem("Inventory Asset");
		
		contentPane.add(Inventory_asset);
		
		Income_ac.setForeground(new Color(0, 0, 0));
		Income_ac.setBackground(new Color(255, 255, 204));
		
		Income_ac.setFont(new Font("Garamond", Font.BOLD, 16));
		Income_ac.setBounds(30, 450, 560, 20);
		
		Income_ac.addItem("Sales of Product Income");
		Income_ac.addItem("Sales Income");
		Income_ac.addItem("Shipping Income");
		Income_ac.addItem("Uncatagorised Income");
		contentPane.add(Income_ac);
		Expense_ac.setForeground(new Color(0, 0, 0));
		Expense_ac.setBackground(new Color(255, 255, 204));
		Expense_ac.setFont(new Font("Garamond", Font.BOLD, 16));
		Expense_ac.setBounds(30, 601, 560, 20);
		Expense_ac.addItem("Cost of Sales");
		Expense_ac.addItem("Inventory Shinkage");
		contentPane.add(Expense_ac);
		saves.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					saves.setIcon(new ImageIcon(Dashboard.class.getResource("/img/saves3.png")));
					if(edit.getText()=="New Product"){
						
						if(Code.getText().equals("")&&Product_name.getText().equals("")&&Product_des.getText().equals("")&&Category.getSelectedItem().toString().equals("")||Quantity.getText().equals("")||Price.getText().equals("")||Cost.getText().equals(""))
						{
							message2.setText("Please fillup all textfield");
						}
						
						try{
							String query="insert into Inventory(Product_code,Product_name,Product_Des,SKU,Category,Quantity_in_hand,As_of_date,Inventory_Asset_ac,Sales_Rate,Sales_Des,Income_Ac,Purchasing_Cost,Purchasing_Des,Expense_AC,pic)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
							
							PreparedStatement pst=connection.prepareStatement(query);
							
							pst.setString(1, Code.getText());
							pst.setString(2, Product_name.getText());
							pst.setString(3, Product_des.getText());
							pst.setString(4, SKU.getText());
							pst.setString(5, Category.getSelectedItem().toString());
							pst.setString(6, Quantity.getText());
							pst.setString(7, As_of_date.getText());
							pst.setString(8, Inventory_asset.getSelectedItem().toString());
							pst.setString(9, Price.getText());
							pst.setString(10, Sale_des.getText());
							pst.setString(11, Income_ac.getSelectedItem().toString());
							pst.setString(12, Cost.getText());
							pst.setString(13, Cost_des.getText());
							pst.setString(14, Expense_ac.getSelectedItem().toString());
							InputStream is1 = new FileInputStream(new File(str));
							
							pst.setBlob(15, is1);
							pst.executeUpdate();
							pst.close();
							String query4="SELECT max(Adjust_no) as no FROM inventory_adjust";
							PreparedStatement pst4=connection.prepareStatement(query4);
							ResultSet rs4=pst4.executeQuery();
							rs4.next();
							
							
							int adjust=rs4.getInt("no");
							adjust++;
							pst4.close();
							rs4.close();
							
							String query1="insert into Inventory_adjust(Adjust_no,Product_Code,SKU,Product_name,Date,Quantity_in_hand,New_quantity,Change_quantity,Status)  values(?,?,?,?,?,?,?,?,?) ";
							
							PreparedStatement pst1=connection.prepareStatement(query1);
								
							
							pst1.setInt(1, adjust);
							pst1.setString(2, Code.getText());
							pst1.setString(3, SKU.getText());
							pst1.setString(4, Product_name.getText());
							pst1.setString(5, As_of_date.getText());
							pst1.setString(6, "0");
							pst1.setString(7, Quantity.getText());
							pst1.setString(8, Quantity.getText());
							pst1.setString(9, "New");
								
							pst1.execute();
							pst1.close();
							
							setVisible(false); //you can't see me!
							dispose(); //Destroy the JFrame object
							time10.stop();
							
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Successfully Create");
							Inventory.frame.refresh_table();
							//JOptionPane.showMessageDialog(null, "Data Add");
						
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
							
						}
					
					else{
						try{
							String q1="update Inventory  set ";
							String q2="Product_name='"+Product_name.getText()+"', Product_des='"+Product_des.getText()+"',SKU='"+SKU.getText()+"',";
							String q3="Category='"+Category.getSelectedItem()+"',Quantity_in_hand='"+Quantity.getText()+"',As_of_date='"+As_of_date.getText()+"',";
							String q4="Inventory_Asset_ac='"+Inventory_asset.getSelectedItem()+"',Sales_Rate='"+Price.getText()+"',Sales_Des='"+Sale_des.getText()+"',";
							String q5="Income_Ac='"+Income_ac.getSelectedItem()+"',Purchasing_Cost='"+Cost.getText()+"',Purchasing_Des='"+Cost_des.getText()+"',";
							String q6="Expense_AC='"+Expense_ac.getSelectedItem()+"' where Product_code='"+Code.getText()+"'";
							
							PreparedStatement pst=connection.prepareStatement(q1+q2+q3+q4+q5+q6);
						
							pst.execute();
							pst.close();
							
							String s1="SELECT ((cost.Fixed_rent+cost.Fixed_utilites+cost.Fixed_equipment+cost.Variable_direct_labor+cost.Variable_utilites+cost.Variable_materiales)/(inventory.Quantity_in_hand)) as Cost ";
							String s2="FROM cost, inventory  WHERE cost.Product_code='"+Code.getText()+"'  and inventory.Product_code='"+Code.getText()+"'";
							PreparedStatement pst1=connection.prepareStatement(s1+s2);
							ResultSet rs1=pst1.executeQuery();
							rs1.next();
							Cost.setText(rs1.getString("Cost"));
							
							pst1.close();
							rs1.close();
							
							String qs1="update Inventory  set Purchasing_Cost='"+Cost.getText()+"' where Product_code='"+Code.getText()+"'";
							
							PreparedStatement pst2=connection.prepareStatement(qs1);
						
							pst2.execute();
							pst2.close();
							setVisible(false); //you can't see me!
							dispose(); //Destroy the JFrame object
							time10.stop();
							
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Successfully Update");
							Inventory.frame.refresh_table();
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
		Product_name = new JTextField();
		Product_name.setForeground(new Color(0, 0, 0));
		Product_name.setFont(new Font("Garamond", Font.BOLD, 16));
		Product_name.setColumns(10);
		Product_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Product_name.setBackground(new Color(255, 255, 204));
		Product_name.setBounds(233, 114, 357, 23);
		contentPane.add(Product_name);
		
		JLabel product_name = new JLabel("Product Name");
		product_name.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		product_name.setBounds(233, 90, 357, 14);
		contentPane.add(product_name);
		message1.setForeground(new Color(0, 0, 51));
		message1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		message1.setBounds(160, 118, 66, 20);
		
		contentPane.add(message1);
		message2.setForeground(new Color(0, 0, 51));
		message2.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		message2.setBounds(30, 632, 225, 20);
		
		contentPane.add(message2);
		
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
		         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		         fileChooser.addChoosableFileFilter(filter);
		         int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             String path = selectedFile.getAbsolutePath();
		            
		             str = path;
		              }
		         else if(result == JFileChooser.CANCEL_OPTION){
		             System.out.println("No Data");
		         }
				
			}
		});
		btnNewButton.setBounds(436, 499, 89, 23);
		contentPane.add(btnNewButton);
	}
}
