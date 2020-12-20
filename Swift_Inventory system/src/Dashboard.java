import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.SwingConstants;
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
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

public class Dashboard extends JFrame {
	Connection connection=null;
	
	URI uri;
	
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
	JLabel dashboard_M = new JLabel("");
	JLabel sale_M = new JLabel("");
	JLabel invoice = new JLabel("");
	JLabel customer = new JLabel("");
	JLabel cash_sales = new JLabel("");
	JLabel credit_sales = new JLabel("");
	JLabel cod = new JLabel("");
	JLabel retail = new JLabel("");
	JLabel payment = new JLabel("");
	JLabel return_invoice = new JLabel("");
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
	JLabel dash_sales = new JLabel("");
	
	   static Dashboard frame = new Dashboard();
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
	private final JLabel supplier = new JLabel("");
	private final JLabel orders = new JLabel("");
	private final JLabel order_no = new JLabel("0", SwingConstants.CENTER);
	public JLabel user_id = new JLabel("");
	private final JLabel g1 = new JLabel("");
	private final JLabel g2 = new JLabel("");
	private final JLabel g3 = new JLabel("");
	private final JLabel g4 = new JLabel("");
	private final JLabel g5 = new JLabel("");
	private final JLabel g6 = new JLabel("");
	private final JLabel g7 = new JLabel("");
	private final JLabel g8 = new JLabel("");
	private final JLabel g9 = new JLabel("");
	private final JLabel g10 = new JLabel("");
	private final JLabel g11 = new JLabel("");
	private final JLabel g12 = new JLabel("");
	private final JLabel g13 = new JLabel("");
	private final JLabel g14 = new JLabel("");
	private final JLabel g15 = new JLabel("");
	private final JLabel g16 = new JLabel("");
	private final JLabel g17 = new JLabel("");
	private final JLabel g18 = new JLabel("");
	private final JLabel g19 = new JLabel("");
	private final JLabel g20 = new JLabel("");
	private final JLabel g21 = new JLabel("");
	private final JLabel g22 = new JLabel("");
	private final JLabel g23 = new JLabel("");
	private final JLabel g24 = new JLabel("");
	private final JLabel g25 = new JLabel("");
	private final JLabel g26 = new JLabel("");
	private final JLabel g27 = new JLabel("");
	private final JLabel g28= new JLabel("");
	private final JLabel g29 = new JLabel("");
	private final JLabel g30 = new JLabel("");
	private final JLabel g31 = new JLabel("");
	private final JLabel pan = new JLabel("");
	//float[] ar = new float[]{30000,35000,70000,2500,20000,100000,6500,35000,70000,3000,20000,100000,6000,35000,70000,4500,35000,70000,2000,20000,2300,20000,100000,100000,300000,504000,35000,76000,2200,25000,2860};
	float[] ar = new float[31];
	float y1,y11,y12;
	int ari=0;
	int ar1=0;
	private final JLabel taka = new JLabel("Tk. 0.00");
	private final JLabel order_check = new JLabel("");
	JLabel check_order_no = new JLabel((String) null, SwingConstants.CENTER);
	private final JLabel dash_cash = new JLabel("");
	private final JLabel dash_expenses = new JLabel("");
	private final JLabel dash_profit = new JLabel("");
	private final JLabel Cash_sales = new JLabel("");
	private final JLabel Credit_sales = new JLabel("");
	private final JLabel COD_sales = new JLabel("");
	private final JLabel Retail_sales = new JLabel("");
	private final JLabel Today = new JLabel("");
	private final JLabel Monthly = new JLabel("");
	private final JLabel Total = new JLabel("");
	private final JLabel Bank = new JLabel("");
	private final JLabel Swift = new JLabel("");
	private final JLabel Loss = new JLabel("");
	private final JLabel Profit = new JLabel("");
	private final JLabel edit = new JLabel("Dashboard");
	private final JLabel Orders = new JLabel("");
	private final JLabel sales_arrow = new JLabel("");
	
	public Dashboard() {
		connection =DatabaseConnect.DBConnectors();
		
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	      
			uri = new URI("https://www.facebook.com/");
			
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		// Daily Basis Sale Graph Value 
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("M");
			String months=(sdf.format(new Date()));
		    System.out.println(months);
			String q6=" SELECT SUM(d1), dat1   FROM ((SELECT SUM(orders.Unit_price*orders.Quantity) as d1, order_status.Date as dat1,'sa' FROM orders,order_status WHERE orders.Order_id=order_status.Order_id AND order_status.Status='Ordered' and order_status.Date LIKE '%"+months+"_____' ";
			String q7=" GROUP BY order_status.Date) UNION (SELECT IFNULL(sum(retail_details.Unit_price*retail_details.Quantity),0) as d1,retail_details.Date as dat1, 're' FROM retail_details WHERE retail_details.Date LIKE '%"+months+"_____'  GROUP by retail_details.Date)) as t1 GROUP BY t1.dat1";
			PreparedStatement ps6=connection.prepareStatement(q6+q7);
			ResultSet rss6=ps6.executeQuery();
			while(rss6.next()){
				String s=rss6.getString(2);
				
				String[] parts = s.split("/");
				int date=Integer.parseInt(parts[0]);
				date--;
				System.out.println(parts[0]+" date "+parts[1]);
				ar[date]=(rss6.getFloat(1));
				//ar1++;
			}
			
			ps6.close();
			rss6.close();
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
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
		
		try{
			
			String query="SELECT COUNT( DISTINCT orders.Order_id) as orders	FROM orders WHERE orders.Status='New'";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			//System.out.println(rs.getMetaData().toString());
			
			order_no.setText(rs.getString("orders"));
			
			pst.close();
			rs.close();

			String query1="SELECT COUNT( DISTINCT orders.Order_id) as orders	FROM orders WHERE orders.Status='Check'";
			PreparedStatement pst1=connection.prepareStatement(query1);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();
			//System.out.println(rs.getMetaData().toString());
			
			check_order_no.setText(rs1.getString("orders"));
			
			pst.close();
			rs.close();
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				float max=ar[0];
				for(int i=0;i<ar.length;i++){
					if(ar[i]>max){
						max=ar[i];
					}
				}
				System.out.println("Maximum sales "+max);
				float size=1;
				if(max<10000){
					size=6;
				}
				else if(max<50000){
					size=3;
				}
				else if(max<100000){
					size=2;
				}
				else if(max<200000){
					size=(float) 1.5;
				}
				else if(max<400000){
					size=(float) 1.2;
				}
				else if(max<600000|| max>6000001){
					size=1;
				}
				
				
				for(ari=0; ari<ar.length;ari++){
					if(ar[ari]<=10000){
						float y11=(float) (10000.0/ar[ari]);
						float y12= (50/y11)*size;
						float y1=700-y12;
						System.out.println(y1+"  "+y12);
						
						if(ari==0){
							g1.setBounds(275, (int)y1, 20,(int)y12 );
							g1.setText(String.valueOf(ar[ari]));
							g1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==1){
							g2.setBounds(300, (int)y1, 20,(int)y12 );
							g2.setText(String.valueOf(ar[ari]));
							g2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==2){
							g3.setBounds(325, (int)y1, 20,(int)y12 );
							g3.setText(String.valueOf(ar[ari]));
							g3.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==3){
							g4.setBounds(350, (int)y1, 20,(int)y12 );
							g4.setText(String.valueOf(ar[ari]));
							g4.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==4){
							g5.setBounds(375, (int)y1, 20,(int)y12 );
							g5.setText(String.valueOf(ar[ari]));
							g5.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==5){
							g6.setBounds(400, (int)y1, 20,(int)y12 );
							g6.setText(String.valueOf(ar[ari]));
							g6.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==6){
							g7.setBounds(425, (int)y1, 20,(int)y12 );
							g7.setText(String.valueOf(ar[ari]));
							g7.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==7){
							g8.setBounds(450, (int)y1, 20,(int)y12 );
							g8.setText(String.valueOf(ar[ari]));
							g8.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==8){
							g9.setBounds(475, (int)y1, 20,(int)y12 );
							g9.setText(String.valueOf(ar[ari]));
							g9.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==9){
							g10.setBounds(500, (int)y1, 20,(int)y12 );
							g10.setText(String.valueOf(ar[ari]));
							g10.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						if(ari==10){
							g11.setBounds(525, (int)y1, 20,(int)y12 );
							g11.setText(String.valueOf(ar[ari]));
							g11.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==11){
							g12.setBounds(550, (int)y1, 20,(int)y12 );
							g12.setText(String.valueOf(ar[ari]));
							g12.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==12){
							g13.setBounds(575, (int)y1, 20,(int)y12 );
							g13.setText(String.valueOf(ar[ari]));
							g13.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==13){
							g14.setBounds(600, (int)y1, 20,(int)y12 );
							g14.setText(String.valueOf(ar[ari]));
							g14.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==14){
							g15.setBounds(625, (int)y1, 20,(int)y12 );
							g15.setText(String.valueOf(ar[ari]));
							g15.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==15){
							g16.setBounds(650, (int)y1, 20,(int)y12 );
							g16.setText(String.valueOf(ar[ari]));
							g16.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==16){
							g17.setBounds(675, (int)y1, 20,(int)y12 );
							g17.setText(String.valueOf(ar[ari]));
							g17.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==17){
							g18.setBounds(700, (int)y1, 20,(int)y12 );
							g18.setText(String.valueOf(ar[ari]));
							g18.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==18){
							g19.setBounds(725, (int)y1, 20,(int)y12 );
							g19.setText(String.valueOf(ar[ari]));
							g19.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==19){
							g20.setBounds(750, (int)y1, 20,(int)y12 );
							g20.setText(String.valueOf(ar[ari]));
							g20.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==20){
							g21.setBounds(775, (int)y1, 20,(int)y12 );
							g21.setText(String.valueOf(ar[ari]));
							g21.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						if(ari==21){
							g22.setBounds(800, (int)y1, 20,(int)y12 );
							g22.setText(String.valueOf(ar[ari]));
							g22.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==22){
							g23.setBounds(825, (int)y1, 20,(int)y12 );
							g23.setText(String.valueOf(ar[ari]));
							g23.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==23){
							g24.setBounds(850, (int)y1, 20,(int)y12 );
							g24.setText(String.valueOf(ar[ari]));
							g24.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==24){
							g25.setBounds(875, (int)y1, 20,(int)y12 );
							g25.setText(String.valueOf(ar[ari]));
							g25.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==25){
							g26.setBounds(900, (int)y1, 20,(int)y12 );
							g26.setText(String.valueOf(ar[ari]));
							g26.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==26){
							g27.setBounds(925, (int)y1, 20,(int)y12 );
							g27.setText(String.valueOf(ar[ari]));
							g27.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==27){
							g28.setBounds(950, (int)y1, 20,(int)y12 );
							g28.setText(String.valueOf(ar[ari]));
							g28.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==28){
							g29.setBounds(975, (int)y1, 20,(int)y12 );
							g29.setText(String.valueOf(ar[ari]));
							g29.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==29){
							g30.setBounds(1000, (int)y1, 20,(int)y12 );
							g30.setText(String.valueOf(ar[ari]));
							g30.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						else if(ari==30){
							g31.setBounds(1025, (int)y1, 20,(int)y12 );
							g31.setText(String.valueOf(ar[ari]));
							g31.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
						}
						
					}
					 if(ar[ari]<=50000&&ar[ari]>=10001){
						 float y11=(float) (50000.0/ar[ari]);
							float y12= (100/y11)*size;
							float y1=700-y12;
							System.out.println(y1+"  "+y12);
							if(ari==0){
								g1.setBounds(275, (int)y1, 20,(int)y12 );
								g1.setText(String.valueOf(ar[ari]));
								g1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==1){
								g2.setBounds(300, (int)y1, 20,(int)y12 );
								g2.setText(String.valueOf(ar[ari]));
								g2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==2){
								g3.setBounds(325, (int)y1, 20,(int)y12 );
								g3.setText(String.valueOf(ar[ari]));
								g3.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==3){
								g4.setBounds(350, (int)y1, 20,(int)y12 );
								g4.setText(String.valueOf(ar[ari]));
								g4.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==4){
								g5.setBounds(375, (int)y1, 20,(int)y12 );
								g5.setText(String.valueOf(ar[ari]));
								g5.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==5){
								g6.setBounds(400, (int)y1, 20,(int)y12 );
								g6.setText(String.valueOf(ar[ari]));
								g6.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==6){
								g7.setBounds(425, (int)y1, 20,(int)y12 );
								g7.setText(String.valueOf(ar[ari]));
								g7.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==7){
								g8.setBounds(450, (int)y1, 20,(int)y12 );
								g8.setText(String.valueOf(ar[ari]));
								g8.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==8){
								g9.setBounds(475, (int)y1, 20,(int)y12 );
								g9.setText(String.valueOf(ar[ari]));
								g9.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==9){
								g10.setBounds(500, (int)y1, 20,(int)y12 );
								g10.setText(String.valueOf(ar[ari]));
								g10.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							if(ari==10){
								g11.setBounds(525, (int)y1, 20,(int)y12 );
								g11.setText(String.valueOf(ar[ari]));
								g11.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==11){
								g12.setBounds(550, (int)y1, 20,(int)y12 );
								g12.setText(String.valueOf(ar[ari]));
								g12.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==12){
								g13.setBounds(575, (int)y1, 20,(int)y12 );
								g13.setText(String.valueOf(ar[ari]));
								g13.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==13){
								g14.setBounds(600, (int)y1, 20,(int)y12 );
								g14.setText(String.valueOf(ar[ari]));
								g14.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==14){
								g15.setBounds(625, (int)y1, 20,(int)y12 );
								g15.setText(String.valueOf(ar[ari]));
								g15.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==15){
								g16.setBounds(650, (int)y1, 20,(int)y12 );
								g16.setText(String.valueOf(ar[ari]));
								g16.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==16){
								g17.setBounds(675, (int)y1, 20,(int)y12 );
								g17.setText(String.valueOf(ar[ari]));
								g17.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==17){
								g18.setBounds(700, (int)y1, 20,(int)y12 );
								g18.setText(String.valueOf(ar[ari]));
								g18.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==18){
								g19.setBounds(725, (int)y1, 20,(int)y12 );
								g19.setText(String.valueOf(ar[ari]));
								g19.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==19){
								g20.setBounds(750, (int)y1, 20,(int)y12 );
								g20.setText(String.valueOf(ar[ari]));
								g20.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==20){
								g21.setBounds(775, (int)y1, 20,(int)y12 );
								g21.setText(String.valueOf(ar[ari]));
								g21.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							if(ari==21){
								g22.setBounds(800, (int)y1, 20,(int)y12 );
								g22.setText(String.valueOf(ar[ari]));
								g22.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==22){
								g23.setBounds(825, (int)y1, 20,(int)y12 );
								g23.setText(String.valueOf(ar[ari]));
								g23.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==23){
								g24.setBounds(850, (int)y1, 20,(int)y12 );
								g24.setText(String.valueOf(ar[ari]));
								g24.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==24){
								g25.setBounds(875, (int)y1, 20,(int)y12 );
								g25.setText(String.valueOf(ar[ari]));
								g25.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==25){
								g26.setBounds(900, (int)y1, 20,(int)y12 );
								g26.setText(String.valueOf(ar[ari]));
								g26.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==26){
								g27.setBounds(925, (int)y1, 20,(int)y12 );
								g27.setText(String.valueOf(ar[ari]));
								g27.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==27){
								g28.setBounds(950, (int)y1, 20,(int)y12 );
								g28.setText(String.valueOf(ar[ari]));
								g28.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==28){
								g29.setBounds(975, (int)y1, 20,(int)y12 );
								g29.setText(String.valueOf(ar[ari]));
								g29.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==29){
								g30.setBounds(1000, (int)y1, 20,(int)y12 );
								g30.setText(String.valueOf(ar[ari]));
								g30.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
							else if(ari==30){
								g31.setBounds(1025, (int)y1, 20,(int)y12 );
								g31.setText(String.valueOf(ar[ari]));
								g31.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
							}
					}
					 if(ar[ari]<=100000&&ar[ari]>=50001){
						 float y11=(float) (100000.0/ar[ari]);
							float y12= (150/y11)*size;
							float y1=700-y12;
							System.out.println(y1+"  "+y12);
							if(ari==0){
								g1.setBounds(275, (int)y1, 20,(int)y12 );
								g1.setText(String.valueOf(ar[ari]));
							}
							else if(ari==1){
								g2.setBounds(300, (int)y1, 20,(int)y12 );
								g2.setText(String.valueOf(ar[ari]));
							}
							else if(ari==2){
								g3.setBounds(325, (int)y1, 20,(int)y12 );
								g3.setText(String.valueOf(ar[ari]));
							}
							else if(ari==3){
								g4.setBounds(350, (int)y1, 20,(int)y12 );
								g4.setText(String.valueOf(ar[ari]));
							}
							else if(ari==4){
								g5.setBounds(375, (int)y1, 20,(int)y12 );
								g5.setText(String.valueOf(ar[ari]));
							}
							else if(ari==5){
								g6.setBounds(400, (int)y1, 20,(int)y12 );
								g6.setText(String.valueOf(ar[ari]));
							}
							else if(ari==6){
								g7.setBounds(425, (int)y1, 20,(int)y12 );
								g7.setText(String.valueOf(ar[ari]));
							}
							else if(ari==7){
								g8.setBounds(450, (int)y1, 20,(int)y12 );
								g8.setText(String.valueOf(ar[ari]));
							}
							else if(ari==8){
								g9.setBounds(475, (int)y1, 20,(int)y12 );
								g9.setText(String.valueOf(ar[ari]));
							}
							else if(ari==9){
								g10.setBounds(500, (int)y1, 20,(int)y12 );
								g10.setText(String.valueOf(ar[ari]));
							}
							if(ari==10){
								g11.setBounds(525, (int)y1, 20,(int)y12 );
								g11.setText(String.valueOf(ar[ari]));
							}
							else if(ari==11){
								g12.setBounds(550, (int)y1, 20,(int)y12 );
								g12.setText(String.valueOf(ar[ari]));
							}
							else if(ari==12){
								g13.setBounds(575, (int)y1, 20,(int)y12 );
								g13.setText(String.valueOf(ar[ari]));
							}
							else if(ari==13){
								g14.setBounds(600, (int)y1, 20,(int)y12 );
								g14.setText(String.valueOf(ar[ari]));
							}
							else if(ari==14){
								g15.setBounds(625, (int)y1, 20,(int)y12 );
								g15.setText(String.valueOf(ar[ari]));
							}
							else if(ari==15){
								g16.setBounds(650, (int)y1, 20,(int)y12 );
								g16.setText(String.valueOf(ar[ari]));
							}
							else if(ari==16){
								g17.setBounds(675, (int)y1, 20,(int)y12 );
								g17.setText(String.valueOf(ar[ari]));
							}
							else if(ari==17){
								g18.setBounds(700, (int)y1, 20,(int)y12 );
								g18.setText(String.valueOf(ar[ari]));
							}
							else if(ari==18){
								g19.setBounds(725, (int)y1, 20,(int)y12 );
								g19.setText(String.valueOf(ar[ari]));
							}
							else if(ari==19){
								g20.setBounds(750, (int)y1, 20,(int)y12 );
								g20.setText(String.valueOf(ar[ari]));
							}
							else if(ari==20){
								g21.setBounds(775, (int)y1, 20,(int)y12 );
								g21.setText(String.valueOf(ar[ari]));
							}
							if(ari==21){
								g22.setBounds(800, (int)y1, 20,(int)y12 );
								g22.setText(String.valueOf(ar[ari]));
							}
							else if(ari==22){
								g23.setBounds(825, (int)y1, 20,(int)y12 );
								g23.setText(String.valueOf(ar[ari]));
							}
							else if(ari==23){
								g24.setBounds(850, (int)y1, 20,(int)y12 );
								g24.setText(String.valueOf(ar[ari]));
							}
							else if(ari==24){
								g25.setBounds(875, (int)y1, 20,(int)y12 );
								g25.setText(String.valueOf(ar[ari]));
							}
							else if(ari==25){
								g26.setBounds(900, (int)y1, 20,(int)y12 );
								g26.setText(String.valueOf(ar[ari]));
							}
							else if(ari==26){
								g27.setBounds(925, (int)y1, 20,(int)y12 );
								g27.setText(String.valueOf(ar[ari]));
							}
							else if(ari==27){
								g28.setBounds(950, (int)y1, 20,(int)y12 );
								g28.setText(String.valueOf(ar[ari]));
							}
							else if(ari==28){
								g29.setBounds(975, (int)y1, 20,(int)y12 );
								g29.setText(String.valueOf(ar[ari]));
							}
							else if(ari==29){
								g30.setBounds(1000, (int)y1, 20,(int)y12 );
								g30.setText(String.valueOf(ar[ari]));
							}
							else if(ari==30){
								g31.setBounds(1025, (int)y1, 20,(int)y12 );
								g31.setText(String.valueOf(ar[ari]));
							}
						}
					 if(ar[ari]<=200000&&ar[ari]>=100001){
						 float y11=(float) (200000.0/ar[ari]);
							float y12= (200/y11)*size;
							float y1=700-y12;
							System.out.println(y1+"  "+y12);
							if(ari==0){
								g1.setBounds(275, (int)y1, 20,(int)y12 );
								g1.setText(String.valueOf(ar[ari]));
							}
							else if(ari==1){
								g2.setBounds(300, (int)y1, 20,(int)y12 );
								g2.setText(String.valueOf(ar[ari]));
							}
							else if(ari==2){
								g3.setBounds(325, (int)y1, 20,(int)y12 );
								g3.setText(String.valueOf(ar[ari]));
							}
							else if(ari==3){
								g4.setBounds(350, (int)y1, 20,(int)y12 );
								g4.setText(String.valueOf(ar[ari]));
							}
							else if(ari==4){
								g5.setBounds(375, (int)y1, 20,(int)y12 );
								g5.setText(String.valueOf(ar[ari]));
							}
							else if(ari==5){
								g6.setBounds(400, (int)y1, 20,(int)y12 );
								g6.setText(String.valueOf(ar[ari]));
							}
							else if(ari==6){
								g7.setBounds(425, (int)y1, 20,(int)y12 );
								g7.setText(String.valueOf(ar[ari]));
							}
							else if(ari==7){
								g8.setBounds(450, (int)y1, 20,(int)y12 );
								g8.setText(String.valueOf(ar[ari]));
							}
							else if(ari==8){
								g9.setBounds(475, (int)y1, 20,(int)y12 );
								g9.setText(String.valueOf(ar[ari]));
							}
							else if(ari==9){
								g10.setBounds(500, (int)y1, 20,(int)y12 );
								g10.setText(String.valueOf(ar[ari]));
							}
							if(ari==10){
								g11.setBounds(525, (int)y1, 20,(int)y12 );
								g11.setText(String.valueOf(ar[ari]));
							}
							else if(ari==11){
								g12.setBounds(550, (int)y1, 20,(int)y12 );
								g12.setText(String.valueOf(ar[ari]));
							}
							else if(ari==12){
								g13.setBounds(575, (int)y1, 20,(int)y12 );
								g13.setText(String.valueOf(ar[ari]));
							}
							else if(ari==13){
								g14.setBounds(600, (int)y1, 20,(int)y12 );
								g14.setText(String.valueOf(ar[ari]));
							}
							else if(ari==14){
								g15.setBounds(625, (int)y1, 20,(int)y12 );
								g15.setText(String.valueOf(ar[ari]));
							}
							else if(ari==15){
								g16.setBounds(650, (int)y1, 20,(int)y12 );
								g16.setText(String.valueOf(ar[ari]));
							}
							else if(ari==16){
								g17.setBounds(675, (int)y1, 20,(int)y12 );
								g17.setText(String.valueOf(ar[ari]));
							}
							else if(ari==17){
								g18.setBounds(700, (int)y1, 20,(int)y12 );
								g18.setText(String.valueOf(ar[ari]));
							}
							else if(ari==18){
								g19.setBounds(725, (int)y1, 20,(int)y12 );
								g19.setText(String.valueOf(ar[ari]));
							}
							else if(ari==19){
								g20.setBounds(750, (int)y1, 20,(int)y12 );
								g20.setText(String.valueOf(ar[ari]));
							}
							else if(ari==20){
								g21.setBounds(775, (int)y1, 20,(int)y12 );
								g21.setText(String.valueOf(ar[ari]));
							}
							if(ari==21){
								g22.setBounds(800, (int)y1, 20,(int)y12 );
								g22.setText(String.valueOf(ar[ari]));
							}
							else if(ari==22){
								g23.setBounds(825, (int)y1, 20,(int)y12 );
								g23.setText(String.valueOf(ar[ari]));
							}
							else if(ari==23){
								g24.setBounds(850, (int)y1, 20,(int)y12 );
								g24.setText(String.valueOf(ar[ari]));
							}
							else if(ari==24){
								g25.setBounds(875, (int)y1, 20,(int)y12 );
								g25.setText(String.valueOf(ar[ari]));
							}
							else if(ari==25){
								g26.setBounds(900, (int)y1, 20,(int)y12 );
								g26.setText(String.valueOf(ar[ari]));
							}
							else if(ari==26){
								g27.setBounds(925, (int)y1, 20,(int)y12 );
								g27.setText(String.valueOf(ar[ari]));
							}
							else if(ari==27){
								g28.setBounds(950, (int)y1, 20,(int)y12 );
								g28.setText(String.valueOf(ar[ari]));
							}
							else if(ari==28){
								g29.setBounds(975, (int)y1, 20,(int)y12 );
								g29.setText(String.valueOf(ar[ari]));
							}
							else if(ari==29){
								g30.setBounds(1000, (int)y1, 20,(int)y12 );
								g30.setText(String.valueOf(ar[ari]));
							}
							else if(ari==30){
								g31.setBounds(1025, (int)y1, 20,(int)y12 );
								g31.setText(String.valueOf(ar[ari]));
							}
						}
					 if(ar[ari]<=400000&&ar[ari]>=200001){
						 float y11=(float) (400000.0/ar[ari]);
							float y12= (250/y11)*size;
							float y1=700-y12;
							System.out.println(y1+"  "+y12);
							if(ari==0){
								g1.setBounds(275, (int)y1, 20,(int)y12 );
								g1.setText(String.valueOf(ar[ari]));
							}
							else if(ari==1){
								g2.setBounds(300, (int)y1, 20,(int)y12 );
								g2.setText(String.valueOf(ar[ari]));
							}
							else if(ari==2){
								g3.setBounds(325, (int)y1, 20,(int)y12 );
								g3.setText(String.valueOf(ar[ari]));
							}
							else if(ari==3){
								g4.setBounds(350, (int)y1, 20,(int)y12 );
								g4.setText(String.valueOf(ar[ari]));
							}
							else if(ari==4){
								g5.setBounds(375, (int)y1, 20,(int)y12 );
								g5.setText(String.valueOf(ar[ari]));
							}
							else if(ari==5){
								g6.setBounds(400, (int)y1, 20,(int)y12 );
								g6.setText(String.valueOf(ar[ari]));
							}
							else if(ari==6){
								g7.setBounds(425, (int)y1, 20,(int)y12 );
								g7.setText(String.valueOf(ar[ari]));
							}
							else if(ari==7){
								g8.setBounds(450, (int)y1, 20,(int)y12 );
								g8.setText(String.valueOf(ar[ari]));
							}
							else if(ari==8){
								g9.setBounds(475, (int)y1, 20,(int)y12 );
								g9.setText(String.valueOf(ar[ari]));
							}
							else if(ari==9){
								g10.setBounds(500, (int)y1, 20,(int)y12 );
								g10.setText(String.valueOf(ar[ari]));
							}
							if(ari==10){
								g11.setBounds(525, (int)y1, 20,(int)y12 );
								g11.setText(String.valueOf(ar[ari]));
							}
							else if(ari==11){
								g12.setBounds(550, (int)y1, 20,(int)y12 );
								g12.setText(String.valueOf(ar[ari]));
							}
							else if(ari==12){
								g13.setBounds(575, (int)y1, 20,(int)y12 );
								g13.setText(String.valueOf(ar[ari]));
							}
							else if(ari==13){
								g14.setBounds(600, (int)y1, 20,(int)y12 );
								g14.setText(String.valueOf(ar[ari]));
							}
							else if(ari==14){
								g15.setBounds(625, (int)y1, 20,(int)y12 );
								g15.setText(String.valueOf(ar[ari]));
							}
							else if(ari==15){
								g16.setBounds(650, (int)y1, 20,(int)y12 );
								g16.setText(String.valueOf(ar[ari]));
							}
							else if(ari==16){
								g17.setBounds(675, (int)y1, 20,(int)y12 );
								g17.setText(String.valueOf(ar[ari]));
							}
							else if(ari==17){
								g18.setBounds(700, (int)y1, 20,(int)y12 );
								g18.setText(String.valueOf(ar[ari]));
							}
							else if(ari==18){
								g19.setBounds(725, (int)y1, 20,(int)y12 );
								g19.setText(String.valueOf(ar[ari]));
							}
							else if(ari==19){
								g20.setBounds(750, (int)y1, 20,(int)y12 );
								g20.setText(String.valueOf(ar[ari]));
							}
							else if(ari==20){
								g21.setBounds(775, (int)y1, 20,(int)y12 );
								g21.setText(String.valueOf(ar[ari]));
							}
							if(ari==21){
								g22.setBounds(800, (int)y1, 20,(int)y12 );
								g22.setText(String.valueOf(ar[ari]));
							}
							else if(ari==22){
								g23.setBounds(825, (int)y1, 20,(int)y12 );
								g23.setText(String.valueOf(ar[ari]));
							}
							else if(ari==23){
								g24.setBounds(850, (int)y1, 20,(int)y12 );
								g24.setText(String.valueOf(ar[ari]));
							}
							else if(ari==24){
								g25.setBounds(875, (int)y1, 20,(int)y12 );
								g25.setText(String.valueOf(ar[ari]));
							}
							else if(ari==25){
								g26.setBounds(900, (int)y1, 20,(int)y12 );
								g26.setText(String.valueOf(ar[ari]));
							}
							else if(ari==26){
								g27.setBounds(925, (int)y1, 20,(int)y12 );
								g27.setText(String.valueOf(ar[ari]));
							}
							else if(ari==27){
								g28.setBounds(950, (int)y1, 20,(int)y12 );
								g28.setText(String.valueOf(ar[ari]));
							}
							else if(ari==28){
								g29.setBounds(975, (int)y1, 20,(int)y12 );
								g29.setText(String.valueOf(ar[ari]));
							}
							else if(ari==29){
								g30.setBounds(1000, (int)y1, 20,(int)y12 );
								g30.setText(String.valueOf(ar[ari]));
							}
							else if(ari==30){
								g31.setBounds(1025, (int)y1, 20,(int)y12 );
								g31.setText(String.valueOf(ar[ari]));
							}
						}
					 if(ar[ari]<=600000&&ar[ari]>=400001){
						 float y11=(float) (600000.0/ar[ari]);
							float y12= (300/y11)*size;
							float y1=700-y12;
							System.out.println(y1+"  "+y12);
							if(ari==0){
								g1.setBounds(275, (int)y1, 20,(int)y12 );
								g1.setText(String.valueOf(ar[ari]));
							}
							else if(ari==1){
								g2.setBounds(300, (int)y1, 20,(int)y12 );
								g2.setText(String.valueOf(ar[ari]));
							}
							else if(ari==2){
								g3.setBounds(325, (int)y1, 20,(int)y12 );
								g3.setText(String.valueOf(ar[ari]));
							}
							else if(ari==3){
								g4.setBounds(350, (int)y1, 20,(int)y12 );
								g4.setText(String.valueOf(ar[ari]));
							}
							else if(ari==4){
								g5.setBounds(375, (int)y1, 20,(int)y12 );
								g5.setText(String.valueOf(ar[ari]));
							}
							else if(ari==5){
								g6.setBounds(400, (int)y1, 20,(int)y12 );
								g6.setText(String.valueOf(ar[ari]));
							}
							else if(ari==6){
								g7.setBounds(425, (int)y1, 20,(int)y12 );
								g7.setText(String.valueOf(ar[ari]));
							}
							else if(ari==7){
								g8.setBounds(450, (int)y1, 20,(int)y12 );
								g8.setText(String.valueOf(ar[ari]));
							}
							else if(ari==8){
								g9.setBounds(475, (int)y1, 20,(int)y12 );
								g9.setText(String.valueOf(ar[ari]));
							}
							else if(ari==9){
								g10.setBounds(500, (int)y1, 20,(int)y12 );
								g10.setText(String.valueOf(ar[ari]));
							}
							if(ari==10){
								g11.setBounds(525, (int)y1, 20,(int)y12 );
								g11.setText(String.valueOf(ar[ari]));
							}
							else if(ari==11){
								g12.setBounds(550, (int)y1, 20,(int)y12 );
								g12.setText(String.valueOf(ar[ari]));
							}
							else if(ari==12){
								g13.setBounds(575, (int)y1, 20,(int)y12 );
								g13.setText(String.valueOf(ar[ari]));
							}
							else if(ari==13){
								g14.setBounds(600, (int)y1, 20,(int)y12 );
								g14.setText(String.valueOf(ar[ari]));
							}
							else if(ari==14){
								g15.setBounds(625, (int)y1, 20,(int)y12 );
								g15.setText(String.valueOf(ar[ari]));
							}
							else if(ari==15){
								g16.setBounds(650, (int)y1, 20,(int)y12 );
								g16.setText(String.valueOf(ar[ari]));
							}
							else if(ari==16){
								g17.setBounds(675, (int)y1, 20,(int)y12 );
								g17.setText(String.valueOf(ar[ari]));
							}
							else if(ari==17){
								g18.setBounds(700, (int)y1, 20,(int)y12 );
								g18.setText(String.valueOf(ar[ari]));
							}
							else if(ari==18){
								g19.setBounds(725, (int)y1, 20,(int)y12 );
								g19.setText(String.valueOf(ar[ari]));
							}
							else if(ari==19){
								g20.setBounds(750, (int)y1, 20,(int)y12 );
								g20.setText(String.valueOf(ar[ari]));
							}
							else if(ari==20){
								g21.setBounds(775, (int)y1, 20,(int)y12 );
								g21.setText(String.valueOf(ar[ari]));
							}
							if(ari==21){
								g22.setBounds(800, (int)y1, 20,(int)y12 );
								g22.setText(String.valueOf(ar[ari]));
							}
							else if(ari==22){
								g23.setBounds(825, (int)y1, 20,(int)y12 );
								g23.setText(String.valueOf(ar[ari]));
							}
							else if(ari==23){
								g24.setBounds(850, (int)y1, 20,(int)y12 );
								g24.setText(String.valueOf(ar[ari]));
							}
							else if(ari==24){
								g25.setBounds(875, (int)y1, 20,(int)y12 );
								g25.setText(String.valueOf(ar[ari]));
							}
							else if(ari==25){
								g26.setBounds(900, (int)y1, 20,(int)y12 );
								g26.setText(String.valueOf(ar[ari]));
							}
							else if(ari==26){
								g27.setBounds(925, (int)y1, 20,(int)y12 );
								g27.setText(String.valueOf(ar[ari]));
							}
							else if(ari==27){
								g28.setBounds(950, (int)y1, 20,(int)y12 );
								g28.setText(String.valueOf(ar[ari]));
							}
							else if(ari==28){
								g29.setBounds(975, (int)y1, 20,(int)y12 );
								g29.setText(String.valueOf(ar[ari]));
							}
							else if(ari==29){
								g30.setBounds(1000, (int)y1, 20,(int)y12 );
								g30.setText(String.valueOf(ar[ari]));
							}
							else if(ari==30){
								g31.setBounds(1025, (int)y1, 20,(int)y12 );
								g31.setText(String.valueOf(ar[ari]));
							}
						}
					 if(ar[ari]>=600001){
						 float y11=1;
							float y12= (300/y11)*size;
							float y1=700-y12;
							System.out.println(y1+"  "+y12);
							if(ari==0){
								g1.setBounds(275, (int)y1, 20,(int)y12 );
								g1.setText(String.valueOf(ar[ari]));
							}
							else if(ari==1){
								g2.setBounds(300, (int)y1, 20,(int)y12 );
								g2.setText(String.valueOf(ar[ari]));
							}
							else if(ari==2){
								g3.setBounds(325, (int)y1, 20,(int)y12 );
								g3.setText(String.valueOf(ar[ari]));
							}
							else if(ari==3){
								g4.setBounds(350, (int)y1, 20,(int)y12 );
								g4.setText(String.valueOf(ar[ari]));
							}
							else if(ari==4){
								g5.setBounds(375, (int)y1, 20,(int)y12 );
								g5.setText(String.valueOf(ar[ari]));
							}
							else if(ari==5){
								g6.setBounds(400, (int)y1, 20,(int)y12 );
								g6.setText(String.valueOf(ar[ari]));
							}
							else if(ari==6){
								g7.setBounds(425, (int)y1, 20,(int)y12 );
								g7.setText(String.valueOf(ar[ari]));
							}
							else if(ari==7){
								g8.setBounds(450, (int)y1, 20,(int)y12 );
								g8.setText(String.valueOf(ar[ari]));
							}
							else if(ari==8){
								g9.setBounds(475, (int)y1, 20,(int)y12 );
								g9.setText(String.valueOf(ar[ari]));
							}
							else if(ari==9){
								g10.setBounds(500, (int)y1, 20,(int)y12 );
								g10.setText(String.valueOf(ar[ari]));
							}
							if(ari==10){
								g11.setBounds(525, (int)y1, 20,(int)y12 );
								g11.setText(String.valueOf(ar[ari]));
							}
							else if(ari==11){
								g12.setBounds(550, (int)y1, 20,(int)y12 );
								g12.setText(String.valueOf(ar[ari]));
							}
							else if(ari==12){
								g13.setBounds(575, (int)y1, 20,(int)y12 );
								g13.setText(String.valueOf(ar[ari]));
							}
							else if(ari==13){
								g14.setBounds(600, (int)y1, 20,(int)y12 );
								g14.setText(String.valueOf(ar[ari]));
							}
							else if(ari==14){
								g15.setBounds(625, (int)y1, 20,(int)y12 );
								g15.setText(String.valueOf(ar[ari]));
							}
							else if(ari==15){
								g16.setBounds(650, (int)y1, 20,(int)y12 );
								g16.setText(String.valueOf(ar[ari]));
							}
							else if(ari==16){
								g17.setBounds(675, (int)y1, 20,(int)y12 );
								g17.setText(String.valueOf(ar[ari]));
							}
							else if(ari==17){
								g18.setBounds(700, (int)y1, 20,(int)y12 );
								g18.setText(String.valueOf(ar[ari]));
							}
							else if(ari==18){
								g19.setBounds(725, (int)y1, 20,(int)y12 );
								g19.setText(String.valueOf(ar[ari]));
							}
							else if(ari==19){
								g20.setBounds(750, (int)y1, 20,(int)y12 );
								g20.setText(String.valueOf(ar[ari]));
							}
							else if(ari==20){
								g21.setBounds(775, (int)y1, 20,(int)y12 );
								g21.setText(String.valueOf(ar[ari]));
							}
							if(ari==21){
								g22.setBounds(800, (int)y1, 20,(int)y12 );
								g22.setText(String.valueOf(ar[ari]));
							}
							else if(ari==22){
								g23.setBounds(825, (int)y1, 20,(int)y12 );
								g23.setText(String.valueOf(ar[ari]));
							}
							else if(ari==23){
								g24.setBounds(850, (int)y1, 20,(int)y12 );
								g24.setText(String.valueOf(ar[ari]));
							}
							else if(ari==24){
								g25.setBounds(875, (int)y1, 20,(int)y12 );
								g25.setText(String.valueOf(ar[ari]));
							}
							else if(ari==25){
								g26.setBounds(900, (int)y1, 20,(int)y12 );
								g26.setText(String.valueOf(ar[ari]));
							}
							else if(ari==26){
								g27.setBounds(925, (int)y1, 20,(int)y12 );
								g27.setText(String.valueOf(ar[ari]));
							}
							else if(ari==27){
								g28.setBounds(950, (int)y1, 20,(int)y12 );
								g28.setText(String.valueOf(ar[ari]));
							}
							else if(ari==28){
								g29.setBounds(975, (int)y1, 20,(int)y12 );
								g29.setText(String.valueOf(ar[ari]));
							}
							else if(ari==29){
								g30.setBounds(1000, (int)y1, 20,(int)y12 );
								g30.setText(String.valueOf(ar[ari]));
							}
							else if(ari==30){
								g31.setBounds(1025, (int)y1, 20,(int)y12 );
								g31.setText(String.valueOf(ar[ari]));
							}
						}
					 
				}
			}
		});
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
		contentPane.setBorder(new MatteBorder(0, 5, 5, 5, (Color) new Color(0, 0, 51)));
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
		search_box.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
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
		search_box.setFont(new Font("Tahoma", Font.ITALIC, 14));
		search_box.setBackground(new Color(0,0,0,0));
		search_box.setBounds(-955, 11, 200, 36);
		search_box.setColumns(10);
		
		contentPane.add(search_box);
		
		swift_logo.setIcon(new ImageIcon(Dashboard.class.getResource("/img/swift_logo.png")));
		swift_logo.setBounds(10, 12, 107, 35);
		
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
		
		
		invoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice3.png")));
				setVisible(false);
				frame.dispose();
				Invoice Invoice=new Invoice();
				Invoice.user_id.setText(user_id.getText());
				Invoice.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice1.png")));
			}
		});
		
		customer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer3.png")));
				setVisible(false);
				frame.dispose();
				Customer Customer=new Customer();
				Customer.user_id.setText(user_id.getText());
				Customer.setVisible(true);

			}
			@Override
			public void mousePressed(MouseEvent e) {
				customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer.png")));
			}
		});
		
		cash_sales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale3.png")));
				setVisible(false);
				frame.dispose();
				Cash_sales Cash_sales= new Cash_sales();
				Cash_sales.user_id.setText(user_id.getText());
				Cash_sales.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale1.png")));
			}
		});
		
		credit_sales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale3.png")));
				setVisible(false);
				frame.dispose();
				Credit_sales Credit_sales=new Credit_sales();
				Credit_sales.user_id.setText(user_id.getText());
				Credit_sales.setVisible(true);

			}
			@Override
			public void mousePressed(MouseEvent e) {
				credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale1.png")));
			}
		});
		
		cod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod3.png")));
				setVisible(false);
				frame.dispose();
				COD_sales COD_sales=new COD_sales();
				COD_sales.user_id.setText(user_id.getText());
				COD_sales.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod1.png")));
			}
		});
		
		retail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale3.png")));
				setVisible(false);
				frame.dispose();
				Retail_sales Retail_sales= new Retail_sales();
				Retail_sales.user_id.setText(user_id.getText());
				Retail_sales.setVisible(true);

			}
			@Override
			public void mousePressed(MouseEvent e) {
				retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale1.png")));
			}
		});
		
		payment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment3.png")));
				setVisible(false);
				frame.dispose();
				Payment Payment=new Payment();
				Payment.user_id.setText(user_id.getText());
				Payment.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment1.png")));
			}
		});
		
		return_invoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice3.png")));
				setVisible(false);
				frame.dispose();
				Return_invoice Return_invoice=new Return_invoice();
				Return_invoice.user_id.setText(user_id.getText());
				Return_invoice.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice1.png")));
			}
		});
		
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
		supplier.setIcon(new ImageIcon(Dashboard.class.getResource("/img/supplier1.png")));
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
		
		dash_sales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_sale2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				dash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_sale1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				dash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_sale3.png")));
				dash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_sale1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				dash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_sale2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				dash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_sale1.png")));
			}
		});
		dash_cash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dash_cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_cash2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				dash_cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_cash1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				dash_cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_cash3.png")));
				dash_cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_cash1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				dash_cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_cash2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				dash_cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_cash1.png")));
			}
		});
		
		dash_profit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dash_profit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_profit2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				dash_profit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_profit1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				dash_profit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_profit3.png")));
				dash_profit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_profit1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				dash_profit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_profit2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				dash_profit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_profit1.png")));
			}
		});
		
		
		
		dash_expenses.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_expenses1.png")));
		
		dash_expenses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dash_expenses.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_expenses2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				dash_expenses.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_expenses1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				dash_expenses.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_expenses3.png")));
				dash_expenses.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_expenses1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				dash_expenses.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_expenses2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				dash_expenses.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_expenses1.png")));
			}
		});
		avater_drop2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/avater_drop1.3.png")));
		avater_drop2.setBounds(1140, -10, 160, 41);
		contentPane.add(avater_drop2);
		
		
		dashboard_M.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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

				if(l%2!=0){
					
					l2=1;
					sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale2.png")));
					invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice1.png")));
					invoice.setBounds(0, 147, 200, 35);
					
					customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer1.png")));
					customer.setBounds(0, 182, 200, 35);
					
					cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale1.png")));
					cash_sales.setBounds(0, 217, 200, 35);
					
					credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale1.png")));
					credit_sales.setBounds(0, 252, 200, 35);
					
					cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod1.png")));
					cod.setBounds(0, 287, 200, 35);
					
					retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale1.png")));
					retail.setBounds(0, 322, 200, 35);
					
					payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment1.png")));
					payment.setBounds(0, 357, 200, 35);
					
					return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice1.png")));
					return_invoice.setBounds(0, 392, 200, 35);
					
					
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
					
					l=2;
					
				}
				else if(l%2==0){
						l2=1;
					sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale2.png")));
					invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice1.png")));
					invoice.setBounds(0, 107, 200, 35);
					
					customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer1.png")));
					customer.setBounds(0, 107, 200, 35);
					
					cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale1.png")));
					cash_sales.setBounds(0, 107, 200, 35);
					
					credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale1.png")));
					credit_sales.setBounds(0, 107, 200, 35);
					
					cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod1.png")));
					cod.setBounds(0, 107, 200, 35);
					
					retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale1.png")));
					retail.setBounds(0, 107, 200, 35);
					
					payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment1.png")));
					payment.setBounds(0, 107, 200, 35);
					
					return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice1.png")));
					return_invoice.setBounds(0, 107, 200, 35);
					
					
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
					l=1;
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
					if(l%2==0){
						sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale1.png")));
					invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice1.png")));
					invoice.setBounds(0, 107, 200, 35);
					
					customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer1.png")));
					customer.setBounds(0, 107, 200, 35);
					
					cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale1.png")));
					cash_sales.setBounds(0, 107, 200, 35);
					
					credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale1.png")));
					credit_sales.setBounds(0, 107, 200, 35);
					
					cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod1.png")));
					cod.setBounds(0, 107, 200, 35);
					
					retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale1.png")));
					retail.setBounds(0, 107, 200, 35);
					
					payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment1.png")));
					payment.setBounds(0, 107, 200, 35);
					
					return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice1.png")));
					return_invoice.setBounds(0, 107, 200, 35);
					
					
					cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash1.png")));
					cash.setBounds(0, 147, 200, 40);
					
					
					expense.setIcon(new ImageIcon(Dashboard.class.getResource("/img/expense1.png")));
					expense.setBounds(0, 187, 200, 40);
					l=1;
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
		orders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				orders.setIcon(new ImageIcon(Dashboard.class.getResource("/img/order2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				orders.setIcon(new ImageIcon(Dashboard.class.getResource("/img/order1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				orders.setIcon(new ImageIcon(Dashboard.class.getResource("/img/order3.png")));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				orders.setIcon(new ImageIcon(Dashboard.class.getResource("/img/order2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				orders.setIcon(new ImageIcon(Dashboard.class.getResource("/img/order1.png")));
			}
		});
		order_check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				order_check.setIcon(new ImageIcon(Dashboard.class.getResource("/img/order_check2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				order_check.setIcon(new ImageIcon(Dashboard.class.getResource("/img/order_check1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				order_check.setIcon(new ImageIcon(Dashboard.class.getResource("/img/order_check3.png")));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				order_check.setIcon(new ImageIcon(Dashboard.class.getResource("/img/order_check2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				order_check.setIcon(new ImageIcon(Dashboard.class.getResource("/img/order_check1.png")));
			}
		});
		
		
		sale_M.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sale1.png")));
		sale_M.setBounds(0, 107, 200, 40);
		contentPane.add(sale_M);
			
		invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/invoice1.png")));
		invoice.setBounds(0, 107, 200, 35);
		contentPane.add(invoice);
		
		customer.setIcon(new ImageIcon(Dashboard.class.getResource("/img/customer1.png")));
		customer.setBounds(0, 107, 200, 35);
		contentPane.add(customer);
		
		cash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash_sale1.png")));
		cash_sales.setBounds(0, 107, 200, 35);
		contentPane.add(cash_sales);

		credit_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/credit_sale1.png")));
		credit_sales.setBounds(0, 107, 200, 35);
		contentPane.add(credit_sales);
		
		cod.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cod1.png")));
		cod.setBounds(0, 107, 200, 35);
		contentPane.add(cod);
		
		retail.setIcon(new ImageIcon(Dashboard.class.getResource("/img/retail_sale1.png")));
		retail.setBounds(0, 107, 200, 35);
		contentPane.add(retail);
		
		payment.setIcon(new ImageIcon(Dashboard.class.getResource("/img/payment1.png")));
		payment.setBounds(0, 107, 200, 35);
		contentPane.add(payment);
		
		return_invoice.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_invoice1.png")));
		return_invoice.setBounds(0, 107, 200, 35);
		contentPane.add(return_invoice);
		
		cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cash1.png")));
		cash.setBounds(0, 147, 200, 40);
		contentPane.add(cash);
		
		expense.setIcon(new ImageIcon(Dashboard.class.getResource("/img/expense1.png")));
		expense.setBounds(0, 187, 200, 40);
		contentPane.add(expense);
		
		inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/inventory1.png")));
		inventory.setBounds(0, 227, 200, 40);
		contentPane.add(inventory);
		
		return_inventory.setIcon(new ImageIcon(Dashboard.class.getResource("/img/return_inventory1.png")));
		return_inventory.setBounds(0, 227, 200, 35);
		contentPane.add(return_inventory);
		
		reports.setIcon(new ImageIcon(Dashboard.class.getResource("/img/report1.png")));
		reports.setBounds(0, 267, 200, 40);
		contentPane.add(reports);
		
		cost.setIcon(new ImageIcon(Dashboard.class.getResource("/img/cost1.png")));
		cost.setBounds(0, 307, 200, 40);
		contentPane.add(cost);
		
		accounting.setIcon(new ImageIcon(Dashboard.class.getResource("/img/accounting1.png")));
		accounting.setBounds(0, 347, 200, 40);
		contentPane.add(accounting);
		
		employee.setIcon(new ImageIcon(Dashboard.class.getResource("/img/employee1.png")));
		employee.setBounds(0, 387, 200, 40);
		contentPane.add(employee);
		border.setFont(new Font("Tahoma", Font.ITALIC, 15));
		border.setForeground(SystemColor.textInactiveText);
		border.setBounds(382, -171, 72, 17);
		
		contentPane.add(border);
		supplier.setBounds(0, 427, 200, 40);
		
		contentPane.add(supplier);
		order_no.setForeground(Color.WHITE);
		order_no.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		order_no.setBounds(1097, 528, 46, 36);
		
		contentPane.add(order_no);
		orders.setIcon(new ImageIcon(Dashboard.class.getResource("/img/order1.png")));
		orders.setBounds(1069, 491, 100, 90);
		
		contentPane.add(orders);
		user_id.setBounds(210, 71, 72, 14);
		
		contentPane.add(user_id);
		g1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g1.getText());
				if(Float.parseFloat(g1.getText())<=50000)
					g1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g1.getText())<=50000)
					g1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		
		g2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g2.getText());
				if(Float.parseFloat(g2.getText())<=50000)
					g2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g2.getText())<=50000)
					g2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g3.getText());
				if(Float.parseFloat(g3.getText())<=50000)
					g3.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g3.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g3.getText())<=50000)
					g3.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g3.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g4.getText());
				if(Float.parseFloat(g4.getText())<=50000)
					g4.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g4.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g4.getText())<=50000)
					g4.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g4.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g5.getText());
				if(Float.parseFloat(g5.getText())<=50000)
					g5.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g5.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g5.getText())<=50000)
					g5.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g5.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g6.getText());
				if(Float.parseFloat(g6.getText())<=50000)
					g6.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g6.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g6.getText())<=50000)
					g6.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g6.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		
		g7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g7.getText());
				if(Float.parseFloat(g7.getText())<=50000)
					g7.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g7.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g7.getText())<=50000)
					g7.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g7.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g8.getText());
				if(Float.parseFloat(g8.getText())<=50000)
					g8.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g8.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g8.getText())<=50000)
					g8.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g8.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g9.getText());
				if(Float.parseFloat(g9.getText())<=50000)
					g9.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g9.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g9.getText())<=50000)
					g9.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g9.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g10.getText());
				if(Float.parseFloat(g10.getText())<=50000)
					g10.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g10.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g10.getText())<=50000)
					g10.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g10.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g11.getText());
				if(Float.parseFloat(g11.getText())<=50000)
					g11.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g11.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g11.getText())<=50000)
					g11.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g11.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		
		g12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g12.getText());
				if(Float.parseFloat(g12.getText())<=50000)
					g12.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g12.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g12.getText())<=50000)
					g12.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g12.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g13.getText());
				if(Float.parseFloat(g13.getText())<=50000)
					g13.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g13.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g13.getText())<=50000)
					g13.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g13.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g14.getText());
				if(Float.parseFloat(g14.getText())<=50000)
					g14.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g14.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g14.getText())<=50000)
					g14.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g14.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g15.getText());
				if(Float.parseFloat(g15.getText())<=50000)
					g15.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g15.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g15.getText())<=50000)
					g15.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g15.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g16.getText());
				if(Float.parseFloat(g16.getText())<=50000)
					g16.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g16.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g16.getText())<=50000)
					g16.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g16.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		
		g17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g17.getText());
				if(Float.parseFloat(g17.getText())<=50000)
					g17.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g17.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g17.getText())<=50000)
					g17.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g17.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g18.getText());
				if(Float.parseFloat(g18.getText())<=50000)
					g18.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g18.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g18.getText())<=50000)
					g18.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g18.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g19.getText());
				if(Float.parseFloat(g19.getText())<=50000)
					g19.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g19.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g19.getText())<=50000)
					g19.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g19.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g20.getText());
				if(Float.parseFloat(g20.getText())<=50000)
					g20.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g20.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g20.getText())<=50000)
					g20.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g20.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g21.getText());
				if(Float.parseFloat(g21.getText())<=50000)
					g21.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g21.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g21.getText())<=50000)
					g21.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g21.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		
		g22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g22.getText());
				if(Float.parseFloat(g22.getText())<=50000)
					g22.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g22.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g22.getText())<=50000)
					g22.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g22.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g23.getText());
				if(Float.parseFloat(g23.getText())<=50000)
					g23.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g23.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g23.getText())<=50000)
					g23.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g23.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g24.getText());
				if(Float.parseFloat(g25.getText())<=50000)
					g24.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g24.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g24.getText())<=50000)
					g24.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g24.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g25.getText());
				if(Float.parseFloat(g25.getText())<=50000)
					g25.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g25.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g25.getText())<=50000)
					g25.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g25.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g26.getText());
				if(Float.parseFloat(g26.getText())<=50000)
					g26.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g26.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g26.getText())<=50000)
					g26.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g26.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		
		g27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g27.getText());
				if(Float.parseFloat(g27.getText())<=50000)
					g27.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g27.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g27.getText())<=50000)
					g27.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g27.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g28.getText());
				if(Float.parseFloat(g28.getText())<=50000)
					g28.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g28.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g28.getText())<=50000)
					g28.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g28.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g29.getText());
				if(Float.parseFloat(g29.getText())<=50000)
					g29.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g29.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g29.getText())<=50000)
					g29.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g29.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g30.getText());
				if(Float.parseFloat(g30.getText())<=50000)
					g30.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g30.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g30.getText())<=50000)
					g30.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g30.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		
		g31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				taka.setText("Tk. "+g31.getText());
				if(Float.parseFloat(g31.getText())<=50000)
					g31.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide3.png")));
				else{
					g31.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide1.png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				taka.setText("Tk. 0");
				if(Float.parseFloat(g31.getText())<=50000)
					g31.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide2.png")));
				else{
					g31.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
				}
			}
		});
		Orders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Orders.setIcon(new ImageIcon(Dashboard.class.getResource("/img/orders2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Orders.setIcon(new ImageIcon(Dashboard.class.getResource("/img/orders1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Orders.setIcon(new ImageIcon(Dashboard.class.getResource("/img/orders3.png")));
				setVisible(false);
				frame.dispose();
				Order Order= new Order();
				Order.user_id.setText(user_id.getText());
				Order.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Orders.setIcon(new ImageIcon(Dashboard.class.getResource("/img/orders2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Orders.setIcon(new ImageIcon(Dashboard.class.getResource("/img/orders1.png")));
			}
		});
		g1.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		contentPane.add(g1);
		g2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		contentPane.add(g2);
		g3.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g3.setBounds(325, 670, 20, 30);
		contentPane.add(g3);
		g4.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g4.setBounds(350, 670, 20, 30);
		contentPane.add(g4);
		g5.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g5.setBounds(375, 670, 20, 30);
		contentPane.add(g5);
		g6.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g6.setBounds(400, 670, 20, 30);
		contentPane.add(g6);
		g7.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g7.setBounds(425, 670, 20, 30);
		contentPane.add(g7);
		g8.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g8.setBounds(450, 670, 20, 30);
		contentPane.add(g8);
		g9.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g9.setBounds(475, 670, 20, 30);
		contentPane.add(g9);
		g10.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g10.setBounds(500, 670, 20, 30);
		contentPane.add(g10);
		g11.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g11.setBounds(525, 670, 20, 30);
		contentPane.add(g11);
		g12.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g12.setBounds(550, 670, 20, 30);
		contentPane.add(g12);
		g13.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g13.setBounds(575, 670, 20, 30);
		contentPane.add(g13);
		g14.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g14.setBounds(600, 670, 20, 30);
		contentPane.add(g14);
		g15.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g15.setBounds(625, 670, 20, 30);
		contentPane.add(g15);
		g16.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g16.setBounds(650, 670, 20, 30);
		contentPane.add(g16);
		g17.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g17.setBounds(675, 670, 20, 30);
		contentPane.add(g17);
		g18.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g18.setBounds(700, 670, 20, 30);
		contentPane.add(g18);
		g19.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g19.setBounds(725, 670, 20, 30);
		contentPane.add(g19);
		g20.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g20.setBounds(750, 670, 20, 30);
		contentPane.add(g20);
		g21.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g21.setBounds(775, 670, 20, 30);
		contentPane.add(g21);
		g22.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g22.setBounds(800, 670, 20, 30);
		contentPane.add(g22);
		g23.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g23.setBounds(825, 670, 20, 30);
		contentPane.add(g23);
		g24.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g24.setBounds(850, 670, 20, 30);
		contentPane.add(g24);
		g25.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g25.setBounds(875, 670, 20, 30);
		contentPane.add(g25);
		g26.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g26.setBounds(900, 670, 20, 30);
		contentPane.add(g26);
		g27.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g27.setBounds(925, 670, 20, 30);
		contentPane.add(g27);
		g28.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g28.setBounds(950, 670, 20, 30);
		contentPane.add(g28);
		g29.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g29.setBounds(975, 670, 20, 30);
		contentPane.add(g29);
		g30.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g30.setBounds(1000, 670, 20, 30);
		contentPane.add(g30);
		g31.setIcon(new ImageIcon(Dashboard.class.getResource("/img/slide.png")));
		g31.setBounds(1025, 670, 20, 30);
		contentPane.add(g31);
		taka.setFont(new Font("Garamond", Font.BOLD, 20));
		taka.setBounds(1069, 400, 201, 23);
		
		contentPane.add(taka);
		
		pan.setIcon(new ImageIcon(Dashboard.class.getResource("/img/pan.png")));
		pan.setBounds(250, 400, 840, 323);
		
		contentPane.add(pan);
		Cash_sales.setHorizontalAlignment(SwingConstants.RIGHT);
		Cash_sales.setForeground(new Color(0, 0, 51));
		Cash_sales.setFont(new Font("Futura Lt BT", Font.BOLD, 17));
		Cash_sales.setBounds(241, 168, 225, 20);
		
		contentPane.add(Cash_sales);
		Credit_sales.setHorizontalAlignment(SwingConstants.RIGHT);
		Credit_sales.setForeground(new Color(0, 0, 51));
		Credit_sales.setFont(new Font("Futura Lt BT", Font.BOLD, 17));
		Credit_sales.setBounds(241, 231, 225, 20);
		
		contentPane.add(Credit_sales);
		COD_sales.setHorizontalAlignment(SwingConstants.RIGHT);
		COD_sales.setForeground(new Color(0, 0, 51));
		COD_sales.setFont(new Font("Futura Lt BT", Font.BOLD, 17));
		COD_sales.setBounds(241, 294, 225, 20);
		
		contentPane.add(COD_sales);
		Retail_sales.setHorizontalAlignment(SwingConstants.RIGHT);
		Retail_sales.setForeground(new Color(0, 0, 51));
		Retail_sales.setFont(new Font("Futura Lt BT", Font.BOLD, 17));
		Retail_sales.setBounds(241, 356, 225, 20);
		
		contentPane.add(Retail_sales);
		Today.setHorizontalAlignment(SwingConstants.RIGHT);
		Today.setForeground(new Color(0, 0, 51));
		Today.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		Today.setBounds(504, 182, 225, 25);
		
		contentPane.add(Today);
		Monthly.setHorizontalAlignment(SwingConstants.RIGHT);
		Monthly.setForeground(new Color(0, 0, 51));
		Monthly.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		Monthly.setBounds(504, 265, 225, 25);
		
		contentPane.add(Monthly);
		Total.setHorizontalAlignment(SwingConstants.RIGHT);
		Total.setForeground(new Color(0, 0, 51));
		Total.setFont(new Font("Futura Lt BT", Font.BOLD, 18));
		Total.setBounds(504, 348, 225, 25);
		
		contentPane.add(Total);
		Bank.setHorizontalAlignment(SwingConstants.RIGHT);
		Bank.setForeground(new Color(0, 0, 51));
		Bank.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		Bank.setBounds(770, 211, 225, 30);
		
		contentPane.add(Bank);
		Swift.setHorizontalAlignment(SwingConstants.RIGHT);
		Swift.setForeground(new Color(0, 0, 51));
		Swift.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		Swift.setBounds(770, 337, 225, 30);
		
		contentPane.add(Swift);
		Loss.setHorizontalAlignment(SwingConstants.RIGHT);
		Loss.setForeground(new Color(0, 0, 51));
		Loss.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		Loss.setBounds(1036, 337, 225, 30);
		
		contentPane.add(Loss);
		Profit.setHorizontalAlignment(SwingConstants.RIGHT);
		Profit.setForeground(new Color(0, 0, 51));
		Profit.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		Profit.setBounds(1036, 211, 225, 30);
		
		contentPane.add(Profit);
		check_order_no.setForeground(Color.WHITE);
		check_order_no.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		check_order_no.setBounds(1176, 647, 46, 36);
		
		contentPane.add(check_order_no);
		order_check.setIcon(new ImageIcon(Dashboard.class.getResource("/img/order_check1.png")));
		order_check.setBounds(1148, 610, 100, 90);
		
		contentPane.add(order_check);
		
		
		dash_sales.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_sale1.png")));
		dash_sales.setBounds(230, 80, 245, 300);
		contentPane.add(dash_sales);
		dash_cash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_cash1.png")));
		dash_cash.setBounds(760, 80, 245, 300);
		
		contentPane.add(dash_cash);
		dash_expenses.setBounds(495, 80, 245, 300);
		
		contentPane.add(dash_expenses);
		dash_profit.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash_profit1.png")));
		dash_profit.setBounds(1025, 80, 245, 300);
		
		contentPane.add(dash_profit);
		Orders.setIcon(new ImageIcon(Dashboard.class.getResource("/img/orders1.png")));
		Orders.setBounds(1090, 439, 150, 41);
		
		contentPane.add(Orders);

		//Sales
			try{
			String query="SELECT SUM(orders.Unit_price*orders.Quantity) FROM orders, order_status WHERE orders.Order_id=order_status.Order_id AND order_status.Sales_Status='Cash' AND order_status.Status='Ordered'";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			
			Cash_sales.setText("Tk. "+rs.getString(1));
			
			pst.close();
			rs.close();
			
			String query1="SELECT SUM(retail_details.Unit_price*retail_details.Quantity) FROM retail_details";
			PreparedStatement pst1=connection.prepareStatement(query1);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();
			
			Retail_sales.setText("Tk. "+rs1.getString(1));
			
			pst1.close();
			rs1.close();
			
			String query2="SELECT SUM(orders.Unit_price*orders.Quantity) FROM orders, order_status WHERE orders.Order_id=order_status.Order_id AND order_status.Sales_Status='Due' AND order_status.Status='Ordered'";
			PreparedStatement pst2=connection.prepareStatement(query2);
			ResultSet rs2=pst2.executeQuery();
			rs2.next();
			
			Credit_sales.setText("Tk. "+rs2.getString(1));
			
			pst2.close();
			rs2.close();
			
			String query3="SELECT SUM(orders.Unit_price*orders.Quantity) FROM orders, order_status WHERE orders.Order_id=order_status.Order_id AND order_status.Sales_Status='COD P' AND order_status.Status='Ordered'";
			PreparedStatement pst3=connection.prepareStatement(query3);
			ResultSet rs3=pst3.executeQuery();
			rs3.next();
			
			COD_sales.setText("Tk. "+rs3.getString(1));
			
			pst3.close();
			rs3.close();


			}
			catch(Exception e1){
				e1.printStackTrace();
			}
			//Expenses
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
				String date=(sdf.format(new Date()));
			    System.out.println(date);
			      
			String query="SELECT IFNULL(SUM(transactions.Amount),0.00) FROM transactions WHERE (transactions.Type='Debit' or  transactions.Type='Debit E' or  transactions.Type='Debit S') AND transactions.Date='"+date+"'";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			
			Today.setText("Tk. "+rs.getString(1));
			
			pst.close();
			rs.close();
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/yyyy");
			String month=(sdf1.format(new Date()));
		    System.out.println(month);
		    
			
			String query1="SELECT IFNULL(SUM(transactions.Amount),0.00) FROM transactions WHERE (transactions.Type='Debit' or  transactions.Type='Debit E' or  transactions.Type='Debit S') AND transactions.Date LIKE '___"+month+"'";
			PreparedStatement pst1=connection.prepareStatement(query1);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();
			
			Monthly.setText("Tk. "+rs1.getString(1));
			
			pst1.close();
			rs1.close();
			
			String query2="SELECT SUM(transactions.Amount) FROM transactions WHERE transactions.Type='Debit' or  transactions.Type='Debit E' or  transactions.Type='Debit S'";
			PreparedStatement pst2=connection.prepareStatement(query2);
			ResultSet rs2=pst2.executeQuery();
			rs2.next();
			
			Total.setText("Tk. "+rs2.getString(1));
			
			pst2.close();
			rs2.close();
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
			
			//Cash
			try{
						
			String query="SELECT SUM(transactions.Amount)-(SELECT SUM(transactions.Amount) FROM transactions WHERE (transactions.Type='Debit' or transactions.Type='Debit E' or transactions.Type='Debit S') AND transactions.Transaction_type='Bank') FROM transactions WHERE (transactions.Type='Credit C' or transactions.Type='Credit O' or transactions.Type='Credit') AND transactions.Transaction_type='Bank' ";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			
			Bank.setText("Tk. "+rs.getString(1));
			
			pst.close();
			rs.close();
			
			String query1="SELECT SUM(transactions.Amount)-(SELECT SUM(transactions.Amount) FROM transactions WHERE (transactions.Type='Debit' or transactions.Type='Debit E' or transactions.Type='Debit S') AND transactions.Transaction_type='Cash') FROM transactions WHERE (transactions.Type='Credit C' or transactions.Type='Credit O' or transactions.Type='Credit') AND transactions.Transaction_type='Cash' ";
			PreparedStatement pst1=connection.prepareStatement(query1);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();
			
			Swift.setText("Tk. "+rs1.getString(1));
			
			pst.close();
			rs.close();
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
			
			
			//Profit and Loss
			try{
					
			String query="SELECT (SUM(orders.Unit_price*orders.Quantity)+(SELECT SUM(retail_details.Unit_price*retail_details.Quantity) FROM retail_details))-(SELECT SUM(transactions.Amount) FROM transactions WHERE transactions.Type='Debit' or  transactions.Type='Debit E' or  transactions.Type='Debit S') FROM orders, order_status WHERE orders.Order_id=order_status.Order_id AND order_status.Status='Ordered' ";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			int profit=+rs.getInt(1);
			if(profit<0){
				int loss=profit;
				loss=loss*-1;
				Loss.setText("Tk. "+loss);
			}
			else{
				Profit.setText("Tk. "+rs.getString(1));
				Loss.setText("Tk. "+"0.00");
			}
			
			
			pst.close();
			rs.close();
			
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		
			sales_arrow.setIcon(new ImageIcon(Dashboard.class.getResource("/img/sales_arrow.png")));
			sales_arrow.setBounds(226, 427, 30, 237);
			
			contentPane.add(sales_arrow);
		
	}
}
