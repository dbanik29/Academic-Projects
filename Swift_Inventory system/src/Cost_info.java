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
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class Cost_info extends JFrame {
	Connection connection=null;
	JLabel user_id = new JLabel("");
	

	private JPanel contentPane;

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
	int I_q;
	 JLabel nav_top = new JLabel("");
	JLabel swift_logo = new JLabel("");
	String companyID="011151";
	 public JTextField Rent = new JTextField();
	 public JTextField Code = new JTextField();
	 public JTextField Date = new JTextField();
	 
	   JLabel border = new JLabel("Name");
	    JTextField search_box = new JTextField();
	    
	
	    static Cost_info frame = new Cost_info();
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
	
	public ObservingTextField dateText;
	 private final JLabel rent = new JLabel("Rent");
	 private final JTextField Direct_labor = new JTextField();
	 private final JLabel direct_labor = new JLabel("Direct Labor");
	 private final JLabel variable_cost = new JLabel("Variable Cost");
	 private final JLabel utilities = new JLabel("Utilites");
	 private final JLabel utilities1 = new JLabel("Utilities");
	 private final JTextField Utilities1 = new JTextField();
	 private final JTextField Utilities = new JTextField();
	 private final JLabel equipment = new JLabel("Equipment");
	 private final JLabel materials = new JLabel("Materials");
	 private final JTextField Materials = new JTextField();
	 private final JTextField Equipment = new JTextField();
	 private final JLabel tfc = new JLabel("Total Fixed Cost");
	 private final JTextField TFC = new JTextField();
	 private final JLabel tvc = new JLabel("Total Variable Cost");
	 private final JTextField TVC = new JTextField();
	 private final JLabel total_cost = new JLabel("Total Cost");
	 private final JTextField Total_cost = new JTextField();
	 public JLabel title = new JLabel("Edit");
	 private final JLabel saves = new JLabel("");
	 private final JLabel cross = new JLabel("");
	
    public void show(String code, String date){
    	try{
			Code.setText(code);
			Date.setText(date);
			String query="SELECT * FROM Cost Where Product_code='"+Code.getText()+"'";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			
			Date.setText(rs.getString("Date"));
			Rent.setText(rs.getString("Fixed_rent"));
			Utilities.setText(rs.getString("Fixed_utilites"));
			Equipment.setText(rs.getString("Fixed_equipment"));
			Direct_labor.setText(rs.getString("Variable_direct_labor"));
			Utilities1.setText(rs.getString("Variable_utilites"));
			Materials.setText(rs.getString("Variable_materiales"));
			TFC.setText(String.valueOf(Double.parseDouble(Rent.getText())+Double.parseDouble(Utilities.getText())+Double.parseDouble(Equipment.getText())));
			TVC.setText(String.valueOf(Double.parseDouble(Direct_labor.getText())+Double.parseDouble(Utilities1.getText())+Double.parseDouble(Materials.getText())));
			Total_cost.setText(String.valueOf(Double.parseDouble(TFC.getText())+Double.parseDouble(TVC.getText())));

			
			pst.close();
			rs.close();

			//JOptionPane.showMessageDialog(null, "Show");
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
    }
	public Cost_info() {
		connection =DatabaseConnect.DBConnectors();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		
		Date.setText(sdf.format(new Date()));
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
			time.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			time.setText(TimeAr[3]);
	         
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		Rent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		Rent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					TFC.setText(String.valueOf(Double.parseDouble(Rent.getText())));
					
					Utilities.grabFocus();
				}
				
			}
		});
		
		Utilities.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					TFC.setText(String.valueOf(Double.parseDouble(Rent.getText())+Double.parseDouble(Utilities.getText())));
					Equipment.grabFocus();
				}
				
			}
		});
		
		Equipment.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					TFC.setText(String.valueOf(Double.parseDouble(Rent.getText())+Double.parseDouble(Utilities.getText())+Double.parseDouble(Equipment.getText())));
					
					Direct_labor.grabFocus();
				}
				
			}
		});
		
		Direct_labor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					TVC.setText(String.valueOf(Double.parseDouble(Direct_labor.getText())));
					
					Utilities1.grabFocus();
				}
				
			}
		});
		
		Utilities1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					TVC.setText(String.valueOf(Double.parseDouble(Direct_labor.getText())+Double.parseDouble(Utilities1.getText())));
					
					Materials.grabFocus();
				}
				
			}
		});
		
		Materials.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					TVC.setText(String.valueOf(Double.parseDouble(Direct_labor.getText())+Double.parseDouble(Utilities1.getText())+Double.parseDouble(Materials.getText())));
					Total_cost.setText(String.valueOf(Double.parseDouble(TFC.getText())+Double.parseDouble(TVC.getText())));
					
				}
				
			}
		});
		
		
		Rent.setHorizontalAlignment(SwingConstants.RIGHT);
		Rent.setFont(new Font("Futura Lt BT", Font.ITALIC, 16));
		
		Rent.setBackground(new Color(255, 250, 205));
		Rent.setBounds(30, 204, 122, 23);
		Rent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Rent.setColumns(10);
		Code.setFont(new Font("Futura Lt BT", Font.ITALIC, 16));
		
		Code.setBackground(new Color(255, 250, 205));
		Code.setBounds(30, 114, 120, 23);
		Code.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Code.setColumns(10);
		Date.setFont(new Font("Futura Lt BT", Font.ITALIC, 16));
		
		Date.setBackground(new Color(255, 250, 205));
		Date.setBounds(345, 114, 120, 23);
		Date.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Date.setColumns(10);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 495, 380);
		setShape(new RoundRectangle2D.Double(00, 00, 495, 380, 50, 0));
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getSize().height; //get the heigth of the frame
        int framelocationX=(dim.width-framewidth)/2; 
        int framelocationY=(dim.height-frameheigth)/2;
        this.setLocation(framelocationX,framelocationY);
		
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new MatteBorder(0, 5, 5, 5, (Color) new Color(0, 0, 51)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		time.setBounds(669, 22, 225, 14);
		contentPane.add(time);
		
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(78, 12, 107, 35);
		
		contentPane.add(swift_logo);
		saves.setIcon(new ImageIcon(Cost_info.class.getResource("/img/saves1.png")));
		saves.setBounds(435, 0, 60, 60);
		
		contentPane.add(saves);
		cross.setIcon(new ImageIcon(Cost_info.class.getResource("/img/cross1.png")));
		cross.setBounds(0, 0, 60, 60);
		
		contentPane.add(cross);
		nav_top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/nav_top.png")));
		nav_top.setBounds(0, 0, 200, 60);
		
		contentPane.add(nav_top);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		title.setBounds(210, 17, 245, 28);
		
		contentPane.add(title);
		
		JLabel top = new JLabel("");
		top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/top.png")));
		top.setEnabled(false);
		top.setBounds(0, 0, 495, 60);
		contentPane.add(top);
		
		border.setFont(new Font("Tahoma", Font.ITALIC, 15));
		border.setForeground(SystemColor.textInactiveText);
		border.setBounds(382, -171, 72, 17);
		
		contentPane.add(border);
		contentPane.add(Rent);
		contentPane.add(Code);
		contentPane.add(Date);
		
		
		JLabel fixed_cost = new JLabel("Fixed Cost");
		fixed_cost.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		fixed_cost.setBounds(30, 148, 122, 20);
		contentPane.add(fixed_cost);
		
		JLabel code = new JLabel("Product Code");
		code.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		code.setBounds(30, 90, 120, 14);
		contentPane.add(code);
		
		JLabel date = new JLabel("Date");
		date.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		date.setBounds(345, 90, 46, 14);
		contentPane.add(date);
		
		saves.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					saves.setIcon(new ImageIcon(Dashboard.class.getResource("/img/saves3.png")));
					if(title.getText()=="New Item Cost"){
						try{
							
							String query="insert into Cost(Product_code,Date,Fixed_rent,Fixed_utilites,Fixed_equipment,Variable_direct_labor,Variable_utilites,Variable_materiales,Status)  values(?,?,?,?,?,?,?,?,?) ";
							
							PreparedStatement pst=connection.prepareStatement(query);
							
							pst.setString(1, Code.getText());
							pst.setString(2, Date.getText());
							pst.setString(3, Rent.getText());
							pst.setString(4, Utilities.getText());
							pst.setString(5, Equipment.getText());
							pst.setString(6, Direct_labor.getText());
							pst.setString(7, Utilities1.getText());
							pst.setString(8, Materials.getText());
							pst.setString(9, "st");
							
							pst.execute();
							pst.close();
							
							String qs1=" UPDATE inventory SET inventory.Purchasing_Cost=(SELECT (cost.Fixed_rent+cost.Fixed_utilites+cost.Fixed_equipment+cost.Variable_direct_labor+cost.Variable_utilites+cost.Variable_materiales)/ SUM(inventory_adjust.Change_quantity) FROM cost, ";
							String qs2=" inventory_adjust WHERE  inventory_adjust.Product_code=cost.Product_code AND inventory.Product_code=inventory_adjust.Product_code) WHERE Product_code='"+Code.getText()+"' ";
							
							PreparedStatement pst2=connection.prepareStatement(qs1+qs2);
						
							pst2.execute();
							pst2.close();
							
							setVisible(false);
							frame.dispose(); 
							
							Cost.frame.refresh_table();
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Cost Successfully Added");
							
							
							//JOptionPane.showMessageDialog(null, "Data Add");
						
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
						
					}
					else if(title.getText()=="Edit Cost"){
						try{
							String q1="update Cost  set ";
							String q2="Date='"+Date.getText()+"', Fixed_rent='"+Rent.getText()+"',Fixed_utilites='"+Utilities.getText()+"',";
							String q3=" Fixed_equipment='"+Equipment.getText()+"',Variable_direct_labor='"+Direct_labor.getText()+"',Variable_utilites='"+Utilities1.getText()+"',";
							String q4=" Variable_materiales='"+Materials.getText()+"' where Product_code='"+Code.getText()+"'";
							
							PreparedStatement pst=connection.prepareStatement(q1+q2+q3+q4);
						
							pst.execute();
							pst.close();
							
							String qs1=" UPDATE inventory SET inventory.Purchasing_Cost=(SELECT (cost.Fixed_rent+cost.Fixed_utilites+cost.Fixed_equipment+cost.Variable_direct_labor+cost.Variable_utilites+cost.Variable_materiales)/ SUM(inventory_adjust.Change_quantity) FROM cost, ";
							String qs2=" inventory_adjust WHERE  inventory_adjust.Product_code=cost.Product_code AND inventory.Product_code=inventory_adjust.Product_code) WHERE Product_code='"+Code.getText()+"' ";
							
							PreparedStatement pst1=connection.prepareStatement(qs1+qs2);
						
							pst1.execute();
							pst1.close();
							setVisible(false);
							frame.dispose(); //Destroy the JFrame object
							
							Cost.frame.refresh_table();
							Message Message= new Message();
							Message.user_id.setText(user_id.getText());
							Message.setVisible(true);
							Message.Message.setText("Cost Successfully Added");
							
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
		rent.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		rent.setBounds(30, 179, 122, 14);
		
		contentPane.add(rent);
		Direct_labor.setHorizontalAlignment(SwingConstants.RIGHT);
		Direct_labor.setFont(new Font("Futura Lt BT", Font.ITALIC, 16));
		Direct_labor.setColumns(10);
		Direct_labor.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Direct_labor.setBackground(new Color(255, 250, 205));
		Direct_labor.setBounds(179, 204, 122, 23);
		
		contentPane.add(Direct_labor);
		direct_labor.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		direct_labor.setBounds(179, 179, 122, 14);
		
		contentPane.add(direct_labor);
		variable_cost.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		variable_cost.setBounds(179, 148, 156, 20);
		
		contentPane.add(variable_cost);
		utilities.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		utilities.setBounds(30, 238, 122, 14);
		
		contentPane.add(utilities);
		utilities1.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		utilities1.setBounds(179, 238, 122, 14);
		
		contentPane.add(utilities1);
		Utilities1.setHorizontalAlignment(SwingConstants.RIGHT);
		Utilities1.setFont(new Font("Futura Lt BT", Font.ITALIC, 16));
		Utilities1.setColumns(10);
		Utilities1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Utilities1.setBackground(new Color(255, 250, 205));
		Utilities1.setBounds(179, 263, 122, 23);
		
		contentPane.add(Utilities1);
		Utilities.setHorizontalAlignment(SwingConstants.RIGHT);
		Utilities.setFont(new Font("Futura Lt BT", Font.ITALIC, 16));
		Utilities.setColumns(10);
		Utilities.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Utilities.setBackground(new Color(255, 250, 205));
		Utilities.setBounds(30, 263, 122, 23);
		
		contentPane.add(Utilities);
		equipment.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		equipment.setBounds(30, 297, 122, 14);
		
		contentPane.add(equipment);
		materials.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		materials.setBounds(179, 297, 122, 14);
		
		contentPane.add(materials);
		Materials.setHorizontalAlignment(SwingConstants.RIGHT);
		Materials.setFont(new Font("Futura Lt BT", Font.ITALIC, 16));
		Materials.setColumns(10);
		Materials.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Materials.setBackground(new Color(255, 250, 205));
		Materials.setBounds(179, 322, 122, 23);
		
		contentPane.add(Materials);
		Equipment.setHorizontalAlignment(SwingConstants.RIGHT);
		Equipment.setFont(new Font("Futura Lt BT", Font.ITALIC, 16));
		Equipment.setColumns(10);
		Equipment.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Equipment.setBackground(new Color(255, 250, 205));
		Equipment.setBounds(30, 322, 122, 23);
		
		contentPane.add(Equipment);
		tfc.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		tfc.setBounds(326, 179, 139, 14);
		
		contentPane.add(tfc);
		TFC.setEditable(false);
		TFC.setHorizontalAlignment(SwingConstants.RIGHT);
		TFC.setFont(new Font("Futura Lt BT", Font.ITALIC, 16));
		TFC.setColumns(10);
		TFC.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		TFC.setBackground(new Color(255, 250, 205));
		TFC.setBounds(326, 204, 139, 23);
		
		contentPane.add(TFC);
		tvc.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		tvc.setBounds(324, 238, 141, 14);
		
		contentPane.add(tvc);
		TVC.setEditable(false);
		TVC.setHorizontalAlignment(SwingConstants.RIGHT);
		TVC.setFont(new Font("Futura Lt BT", Font.ITALIC, 16));
		TVC.setColumns(10);
		TVC.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		TVC.setBackground(new Color(255, 250, 205));
		TVC.setBounds(324, 263, 141, 23);
		
		contentPane.add(TVC);
		total_cost.setFont(new Font("Futura Lt BT", Font.BOLD, 14));
		total_cost.setBounds(324, 297, 141, 14);
		
		contentPane.add(total_cost);
		Total_cost.setEditable(false);
		Total_cost.setHorizontalAlignment(SwingConstants.RIGHT);
		Total_cost.setFont(new Font("Futura Lt BT", Font.ITALIC, 16));
		Total_cost.setColumns(10);
		Total_cost.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		Total_cost.setBackground(new Color(255, 250, 205));
		Total_cost.setBounds(324, 322, 141, 23);
		
		contentPane.add(Total_cost);
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
	}
}