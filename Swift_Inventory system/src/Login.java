import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login extends JFrame {
	Connection connection=null;
	public  JPanel contentPane;
	
	public static int framewidth;
	public static int frameheigth;
	public static int framelocationX;
	public static int framelocationY;
	public static JLabel logAni = new JLabel("");
	public static JLabel logAni2 = new JLabel("");
	public static int logTimer1=0;
	public static int logTimer2=200;
	public static int i=0;
	public static int x;
	public static int y;
	public int userName=1;
	
	public static class MyActionListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(logTimer1>=-800&&logTimer2<=800){
        		logTimer1--;
        		logTimer2++;
        	logAni.setBounds(0, logTimer1, 400, 328);
			logAni2.setBounds(0, logTimer2, 400, 200);
			
        	}
        }
	}
	static Timer time1=new Timer(2,new MyActionListener1());
	public static class MyActionListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(logTimer2>=201&&logTimer1<=0){
        		logTimer2--;
        		logTimer1++;
        	logAni.setBounds(0, logTimer1, 400, 328);
			logAni2.setBounds(0, logTimer2, 400, 200);
			
			
        	}
        }
	}
	static Timer time2=new Timer(2,new MyActionListener2());
	
	public static class MyActionListener3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	PointerInfo a = MouseInfo.getPointerInfo();
			Point b = a.getLocation();
			x=b.x;
			y=b.y;
		//	System.out.println(x+" "+y);
			if((x>framelocationX&&x<(framelocationX+framewidth)&&y>framelocationY&&y<(framelocationY+frameheigth))){
				time1.start();
				time2.stop();
				
			}
			else if((x<framelocationX&&y>framelocationY)||
					(x>(framelocationX+framewidth)&&y>framelocationY)||
					(x>framelocationX&&y>(framelocationY+frameheigth))||
					(y<framelocationY)){
				time1.stop();
				time2.start();
				user.setText("");
				password.setText("");
				
			}
			
        }
	}
	static Timer time3=new Timer(1,new MyActionListener3());
	
	
	public final JLabel login_back = new JLabel("");
	public static JTextField user = new JTextField();
	
	public static  JPasswordField password;
	public  final JLabel login_btn = new JLabel("");
	public  final JLabel close = new JLabel("");
	static Login frame = new Login();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					time3.start();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		frame.user.setFont(new Font("Tahoma", Font.BOLD, 14));
		connection =DatabaseConnect.DBConnectors();	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	    setUndecorated(true);
	    
		setBounds(-100, -100, 400, 400);
		setShape(new RoundRectangle2D.Double(00, 00, 400, 400, 50, 50));
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		framewidth=this.getSize().width;//get the width of the frame
	    frameheigth=this.getSize().height; //get the heigth of the frame
	    framelocationX=(dim.width-framewidth)/2; 
	    framelocationY=(dim.height-frameheigth)/2;
        
        this.setLocation(framelocationX,framelocationY);
		contentPane = new JPanel();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage((Login.class.getResource("/img/arrow1.png")));
		Cursor c = toolkit.createCustomCursor(image , new Point(5,5), "img");
		contentPane.setCursor (c);
		contentPane.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		contentPane.setOpaque(false);
		contentPane.addMouseListener(new MouseAdapter() {
			
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		logAni.setIcon(new ImageIcon(Login.class.getResource("/img/log1.png")));
		logAni.setBounds(0, 0, 400, 328);
		contentPane.add(logAni);
		
		
		
		logAni2.setIcon(new ImageIcon(Login.class.getResource("/img/log2.png")));
		logAni2.setBounds(0, 200, 400, 200);
		contentPane.add(logAni2);
		
		
		user.setBounds(112, 188, 195, 20);
		user.setColumns(10);
		user.setOpaque(false);
		
		user.setBackground(new Color(0, 0, 0, 0));
		user.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
		
		contentPane.add(user);
		
		password = new JPasswordField();
		password.setBounds(112, 234, 195, 20);
		password.setOpaque(false);
		
		password.setBackground(new Color(0, 0, 0, 0));
		password.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
		contentPane.add(password);
		login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(user.getText()+password.getText());
					try{
				String query="select * from Login where Employee_id=?  and Passward=?";
				
				PreparedStatement pst=connection.prepareStatement(query);
				pst.setString(1,user.getText());
				
				pst.setString(2,password.getText());
				ResultSet rs=pst.executeQuery();
				System.out.println(pst.toString());
				int count=0;
				while(rs.next()){
					count=count+1;
				}
		//		System.out.println(user_name+password);
			///	if(user_name.getText().equals("admin"))
			//	{
				if(user.getText().equals("")&&password.getText().equals("")){
					//JOptionPane.showMessageDialog(null, "Please Field The Username and Password");
					Message Message= new Message();
					Message.user_id.setText(user.getText());
					Message.setVisible(true);
					Message.Message.setText("Please Field The Username and Password");
				}
				else if(count==1){
					setVisible(false);
					Dashboard Dashboard= new Dashboard();
					Dashboard.setVisible(true);
					Dashboard.user_id.setText(user.getText());
					Message Message= new Message();
					Message.user_id.setText(user.getText());
					Message.setVisible(true);
					Message.Message.setText("Username and Password is Correct!!!");
					//JOptionPane.showMessageDialog(null, "Username and Password is Correct!!!");
				}
				else if(count>1){
					Message Message= new Message();
					Message.user_id.setText(user.getText());
					Message.setVisible(true);
					Message.Message.setText("Duplicate Username and Password is Correct!!!");
					//JOptionPane.showMessageDialog(null, "Duplicate Username and Password is Correct!!!");
				}
				else{
					Message Message= new Message();
					Message.user_id.setText(user.getText());
					Message.setVisible(true);
					Message.Message.setText("Username and Password is Incorrect!!!");
					user.setText("");
					password.setText("");
					//JOptionPane.showMessageDialog(null, "Username and Password is Incorrect!!!");
				}
		//		}
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		login_btn.setIcon(new ImageIcon(Login.class.getResource("/img/login_btn2.png")));
		
		login_btn.setBounds(80, 280, 240, 36);
		
		contentPane.add(login_btn);
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				close.setIcon(new ImageIcon(Login.class.getResource("/img/close2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				close.setIcon(new ImageIcon(Login.class.getResource("/img/close1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		close.setIcon(new ImageIcon(Login.class.getResource("/img/close1.png")));
		close.setBounds(360, 0, 40, 40);
		
		contentPane.add(close);
		login_back.setIcon(new ImageIcon(Login.class.getResource("/img/login_back.png")));
		login_back.setBounds(0, 0, 400, 400);
		
		contentPane.add(login_back);
		
	}
}
