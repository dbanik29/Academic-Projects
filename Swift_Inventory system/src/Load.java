import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Load extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static int x;
	public static int x1;
	public static int x2;
	public static int x3;
	public static int x4;
	public static int x5;
	public static int x6;
	public static int x7;
	public static int x8;
	public static int x9;
	public static int x10;
	public static int x11;
	public static int y=-428;
	public static int y1=-428;
	public static int y2=-428;
	public static int y3=-428;
	public static int y4=-428;
	public static int y5=-428;
	public static int y6=-428;
	public static int y7=-428;
	public static int y8=-428;
	public static int y9=-428;
	public static int y10=-428;
	public static int y11=-428;
	public static int dol=0;
	public static int result=20;
	
	
	public static JLabel ani1 = new JLabel("");
	public static JLabel ani2 = new JLabel("");
	public static JLabel ani3 = new JLabel("");
	public static JLabel ani4 = new JLabel("");
	public static JLabel ani5 = new JLabel("");
	public static JLabel ani6 = new JLabel("");
	public static JLabel ani7 = new JLabel("");
	public static JLabel ani8 = new JLabel("");
	public static JLabel ani9 = new JLabel("");
	public static JLabel ani10 = new JLabel("");
	public static JLabel ani11 = new JLabel("");
	public static JLabel ani12 = new JLabel("");
	
	
	static JLabel logo = new JLabel("");
	static JLabel name = new JLabel("");
	
	public static int l=1;
	
	public static class MyActionListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        
        	if(l==1){
        		
        		name.setIcon(new ImageIcon(Loading.class.getResource("/img/namel.png")));
        		l++;
	        }
        	else if(l==2){
        		name.setIcon(new ImageIcon(Loading.class.getResource("/img/namel1.png")));
        		l++;
	        }
        	else if(l==3){
        		name.setIcon(new ImageIcon(Loading.class.getResource("/img/namel2.png")));
        		l++;
	        }
        	else if(l==4){
        		name.setIcon(new ImageIcon(Loading.class.getResource("/img/namel3.png")));
        		l++;
	        }
        	else if(l==5){
        		name.setIcon(new ImageIcon(Loading.class.getResource("/img/namel4.png")));
        		l++;
	        }
        	else if(l==6){
        		name.setIcon(new ImageIcon(Loading.class.getResource("/img/namel5.png")));
        		l++;
	        }
        	else if(l==7){
        		name.setIcon(new ImageIcon(Loading.class.getResource("/img/namel6.png")));
        		l++;
	        }
        	else if(l==8){
        		name.setIcon(new ImageIcon(Loading.class.getResource("/img/namel7.png")));
        		l++;
	        }
        	else if(l==9){
        		name.setIcon(new ImageIcon(Loading.class.getResource("/img/namel8.png")));
        		l++;
	        }
        	else if(l==10){
        		name.setIcon(new ImageIcon(Loading.class.getResource("/img/namel9.png")));
        		l++;
	        }
        	else if(l==11){
        		name.setIcon(new ImageIcon(Loading.class.getResource("/img/namel10.png")));
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb1.png")));
        		
        		l++;
	        }
        	else if(l==12){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb2.png")));
        		l++;
	        }
        	else if(l==13){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb3.png")));
        		l++;
	        }
        	else if(l==14){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb4.png")));
        		l++;
	        }
        	else if(l==15){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb5.png")));
        		l++;
	        }
        	else if(l==16){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb6.png")));
        		l++;
	        }
        	else if(l==17){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb7.png")));
        		l++;
	        }
        	else if(l==18){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb8.png")));
        		l++;
	        }
        	else if(l==19){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb7.png")));
        		l++;
	        }
        	else if(l==20){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb6.png")));
        		l++;
	        }
        	else if(l==21){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb5.png")));
        		l++;
	        }
        	else if(l==22){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb4.png")));
        		l++;
	        }
        	else if(l==23){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb3.png")));
        		l++;
	        }
        	else if(l==24){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb2.png")));
        		l++;
	        }
        	else if(l==25){
        		logo.setIcon(new ImageIcon(Loading.class.getResource("/img/forweb1.png")));
        		l++;
	        }
        	if(l==26){
				time1.stop();
				if(s=="Sale"){
				frame.setVisible(false);
				Sales Sales= new Sales();
				Sales.setVisible(true);
				
				}
				else if(s=="Supplier"){
					frame.setVisible(false);
					Supplier_info Supplier_info= new Supplier_info();
					Supplier_info.setVisible(true);
			
					Supplier_info.time10.start();
					Supplier_info.show(value);
				}
				
			}
        	}
        	
        }
	
	static String s;
	static String value;
	
	
	static Timer time1=new Timer(10,new MyActionListener1());
	
	static Load frame = new Load();
	
	
	
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

	/**
	 * Create the frame.
	 */
	public Load() {
		setLocationRelativeTo(null);
	    setUndecorated(true);
	    
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
		setBounds(100, 100, 492, 492);
		
		setShape(new RoundRectangle2D.Double(0, 0, 492, 492, 500, 500));
		
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getSize().height; //get the heigth of the frame
        int framelocationX=(dim.width-framewidth)/2; 
        int framelocationY=(dim.height-frameheigth)/2;
        this.setLocation(framelocationX,framelocationY);
        getContentPane().setLayout(null);
       
        
       
        
        name.setBounds(156, 193, 180, 105);
        getContentPane().add(name);
        
        
        
        logo.setBounds(146, 124, 200, 245);
        getContentPane().add(logo);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Loading.class.getResource("/img/for100.gif")));
       
        lblNewLabel.setBounds(0, 0, 492, 492);
        getContentPane().add(lblNewLabel);
       
        
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
}

