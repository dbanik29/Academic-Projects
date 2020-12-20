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

public class Loading extends JFrame {

	private JPanel contentPane;

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
	
	public static int l=0;
	
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
				frame.setVisible(false);
				
				Login login= new Login();
				login.setVisible(true);
				login.time3.start();
				
			}
        	}
        	
        }
	
	public static class MyActionListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(dol==20000){
            	l=1;
            	ani1.setLocation(-50, 0);
            	ani2.setLocation(-50, 0);
            	ani3.setLocation(-50, 0);
            	ani4.setLocation(-50, 0);
            	ani5.setLocation(-50, 0);
            	ani6.setLocation(-50, 0);
            	ani7.setLocation(-50, 0);
            	ani8.setLocation(-50, 0);
            	ani9.setLocation(-50, 0);
            	ani10.setLocation(-50, 0);
            	ani11.setLocation(-50, 0);
            	ani12.setLocation(-50, 0);
            	time2.stop();
            	time3.stop();
            	time4.stop();
            	time5.stop();
            	time6.stop();
            	time7.stop();
            	time8.stop();
            	time9.stop();
            	time10.stop();
            	time11.stop();
            	time12.stop();
            	time13.stop();
            }
        	else if(l==0){
        	dol++;
        	System.out.println("Doll  "+dol);
        	if(y1<=0){
        		ani1.setLocation(0, y1);
    	        y1++;
    	        System.out.println("2 "+y);
    	        if(y1==0){
            		x1=0;
    	        }
	        }
        	else if(y1==0){
        		x1=0;
        	}
        	else if(x1>=-428){
        		ani1.setLocation(0, x1);
        		System.out.println("1 "+x);
    	        x1--;
    	        if(x1==-428){
            		y1=-428;
            	}
        	}
        	else if(x1==-428){
        		y1=-428;
        	}
        }
        else if(dol==20000){
        	l=1;
        }
        }
	}
	
	public static class MyActionListener3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(dol==20000){
            	l=1;
            	ani1.setLocation(-50, 0);
            	ani2.setLocation(-50, 0);
            	ani3.setLocation(-50, 0);
            	ani4.setLocation(-50, 0);
            	ani5.setLocation(-50, 0);
            	ani6.setLocation(-50, 0);
            	ani7.setLocation(-50, 0);
            	ani8.setLocation(-50, 0);
            	ani9.setLocation(-50, 0);
            	ani10.setLocation(-50, 0);
            	ani11.setLocation(-50, 0);
            	ani12.setLocation(-50, 0);
            	time2.stop();
            	time3.stop();
            	time4.stop();
            	time5.stop();
            	time6.stop();
            	time7.stop();
            	time8.stop();
            	time9.stop();
            	time10.stop();
            	time11.stop();
            	time12.stop();
            	time13.stop();
            }
        	else if(l==0){
        	dol++;
        	if(y2<=0){
        		ani2.setLocation(45, y2);
    	        y2++;
    	        System.out.println("2 "+y);
    	        if(y2==0){
            		x2=0;
    	        }
	        }
        	else if(y2==0){
        		x2=0;
        	}
        	else if(x2>=-428){
        		ani2.setLocation(45, x2);
        		System.out.println("1 "+x);
    	        x2--;
    	        if(x2==-428){
            		y2=-428;
            	}
        	}
        	else if(x2==-428){
        		y2=-428;
        	}
        }
        else if(dol==20000){
        	l=1;
        }
        }
	}
	
	public static class MyActionListener4 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(dol==20000){
            	l=1;
            	ani1.setLocation(-50, 0);
            	ani2.setLocation(-50, 0);
            	ani3.setLocation(-50, 0);
            	ani4.setLocation(-50, 0);
            	ani5.setLocation(-50, 0);
            	ani6.setLocation(-50, 0);
            	ani7.setLocation(-50, 0);
            	ani8.setLocation(-50, 0);
            	ani9.setLocation(-50, 0);
            	ani10.setLocation(-50, 0);
            	ani11.setLocation(-50, 0);
            	ani12.setLocation(-50, 0);
            	time2.stop();
            	time3.stop();
            	time4.stop();
            	time5.stop();
            	time6.stop();
            	time7.stop();
            	time8.stop();
            	time9.stop();
            	time10.stop();
            	time11.stop();
            	time12.stop();
            	time13.stop();
            }
        	else if(l==0){
        	dol++;
        	if(y3<=0){
        		ani3.setLocation(90, y3);
    	        y3++;
    	        System.out.println("2 "+y);
    	        if(y3==0){
            		x3=0;
    	        }
	        }
        	else if(y3==0){
        		x3=0;
        	}
        	else if(x3>=-428){
        		ani3.setLocation(90, x3);
        		System.out.println("1 "+x);
    	        x3--;
    	        if(x3==-428){
            		y3=-428;
            	}
        	}
        	else if(x3==-428){
        		y3=-428;
        	}
        }
        else if(dol==20000){
        	l=1;
        }
        }
	}
	
	public static class MyActionListener5 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(dol==20000){
            	l=1;
            	ani1.setLocation(-50, 0);
            	ani2.setLocation(-50, 0);
            	ani3.setLocation(-50, 0);
            	ani4.setLocation(-50, 0);
            	ani5.setLocation(-50, 0);
            	ani6.setLocation(-50, 0);
            	ani7.setLocation(-50, 0);
            	ani8.setLocation(-50, 0);
            	ani9.setLocation(-50, 0);
            	ani10.setLocation(-50, 0);
            	ani11.setLocation(-50, 0);
            	ani12.setLocation(-50, 0);
            	time2.stop();
            	time3.stop();
            	time4.stop();
            	time5.stop();
            	time6.stop();
            	time7.stop();
            	time8.stop();
            	time9.stop();
            	time10.stop();
            	time11.stop();
            	time12.stop();
            	time13.stop();
            }
        	else if(l==0){
        	dol++;
        	if(y4<=0){
        		ani4.setLocation(135, y4);
    	        y4++;
    	        System.out.println("2 "+y);
    	        if(y4==0){
            		x4=0;
    	        }
	        }
        	else if(y4==0){
        		x4=0;
        	}
        	else if(x4>=-428){
        		ani4.setLocation(135, x4);
        		System.out.println("1 "+x);
    	        x4--;
    	        if(x4==-428){
            		y4=-428;
            	}
        	}
        	else if(x4==-428){
        		y4=-428;
        	}
        }
        else if(dol==20000){
        	l=1;
        }
        }
	}
	
	public static class MyActionListener6 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(dol==20000){
            	l=1;
            	ani1.setLocation(-50, 0);
            	ani2.setLocation(-50, 0);
            	ani3.setLocation(-50, 0);
            	ani4.setLocation(-50, 0);
            	ani5.setLocation(-50, 0);
            	ani6.setLocation(-50, 0);
            	ani7.setLocation(-50, 0);
            	ani8.setLocation(-50, 0);
            	ani9.setLocation(-50, 0);
            	ani10.setLocation(-50, 0);
            	ani11.setLocation(-50, 0);
            	ani12.setLocation(-50, 0);
            	time2.stop();
            	time3.stop();
            	time4.stop();
            	time5.stop();
            	time6.stop();
            	time7.stop();
            	time8.stop();
            	time9.stop();
            	time10.stop();
            	time11.stop();
            	time12.stop();
            	time13.stop();
            }
        	else if(l==0){
        	dol++;
        	if(y<=0){
        		ani5.setLocation(180, y);
    	        y++;
    	        System.out.println("2 "+y);
    	        if(y==0){
            		x=0;
    	        }
	        }
        	else if(y==0){
        		x=0;
        	}
        	else if(x>=-428){
        		ani5.setLocation(180, x);
        		System.out.println("1 "+x);
    	        x--;
    	        if(x==-428){
            		y=-428;
            	}
        	}
        	else if(x==-428){
        		y=-428;
        	}
        }
        else if(dol==20000){
        	l=1;
        }
        }
	}
	
	public static class MyActionListener7 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(dol==20000){
            	l=1;
            	ani1.setLocation(-50, 0);
            	ani2.setLocation(-50, 0);
            	ani3.setLocation(-50, 0);
            	ani4.setLocation(-50, 0);
            	ani5.setLocation(-50, 0);
            	ani6.setLocation(-50, 0);
            	ani7.setLocation(-50, 0);
            	ani8.setLocation(-50, 0);
            	ani9.setLocation(-50, 0);
            	ani10.setLocation(-50, 0);
            	ani11.setLocation(-50, 0);
            	ani12.setLocation(-50, 0);
            	time2.stop();
            	time3.stop();
            	time4.stop();
            	time5.stop();
            	time6.stop();
            	time7.stop();
            	time8.stop();
            	time9.stop();
            	time10.stop();
            	time11.stop();
            	time12.stop();
            	time13.stop();
            }
        	else if(l==0){
        	dol++;
        	if(y6<=0){
        		ani6.setLocation(225, y6);
    	        y6++;
    	        System.out.println("2 "+y6);
    	        if(y6==0){
            		x6=0;
    	        }
	        }
        	else if(y6==0){
        		x6=0;
        	}
        	else if(x6>=-428){
        		ani6.setLocation(225, x6);
        		System.out.println("1 "+x);
    	        x6--;
    	        if(x6==-428){
            		y6=-428;
            	}
        	}
        	else if(x6==-428){
        		y6=-428;
        	}
        }
        else if(dol==20000){
        	l=1;
        }
        }
	}
	
	public static class MyActionListener8 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(dol==20000){
            	l=1;
            	ani1.setLocation(-50, 0);
            	ani2.setLocation(-50, 0);
            	ani3.setLocation(-50, 0);
            	ani4.setLocation(-50, 0);
            	ani5.setLocation(-50, 0);
            	ani6.setLocation(-50, 0);
            	ani7.setLocation(-50, 0);
            	ani8.setLocation(-50, 0);
            	ani9.setLocation(-50, 0);
            	ani10.setLocation(-50, 0);
            	ani11.setLocation(-50, 0);
            	ani12.setLocation(-50, 0);
            	time2.stop();
            	time3.stop();
            	time4.stop();
            	time5.stop();
            	time6.stop();
            	time7.stop();
            	time8.stop();
            	time9.stop();
            	time10.stop();
            	time11.stop();
            	time12.stop();
            	time13.stop();
            	
            }
        	
        	else if(l==0){
        	dol++;
        	if(y7<=0){
        		ani7.setLocation(270, y7);
    	        y7++;
    	        System.out.println("2 "+y);
    	        if(y7==0){
            		x7=0;
    	        }
	        }
        	else if(y7==0){
        		x7=0;
        	}
        	else if(x7>=-428){
        		ani7.setLocation(270, x7);
        		System.out.println("1 "+x);
    	        x7--;
    	        if(x7==-428){
            		y7=-428;
            	}
        	}
        	else if(x7==-428){
        		y7=-428;
        	}
        }
        
        }
	}
	
	public static class MyActionListener9 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(dol==20000){
            	l=1;
            	ani1.setLocation(-50, 0);
            	ani2.setLocation(-50, 0);
            	ani3.setLocation(-50, 0);
            	ani4.setLocation(-50, 0);
            	ani5.setLocation(-50, 0);
            	ani6.setLocation(-50, 0);
            	ani7.setLocation(-50, 0);
            	ani8.setLocation(-50, 0);
            	ani9.setLocation(-50, 0);
            	ani10.setLocation(-50, 0);
            	ani11.setLocation(-50, 0);
            	ani12.setLocation(-50, 0);
            	time2.stop();
            	time3.stop();
            	time4.stop();
            	time5.stop();
            	time6.stop();
            	time7.stop();
            	time8.stop();
            	time9.stop();
            	time10.stop();
            	time11.stop();
            	time12.stop();
            	time13.stop();
            }
        	else if(l==0){
        	dol++;
        	if(y8<=0){
        		ani8.setLocation(315, y8);
    	        y8++;
    	        System.out.println("2ssss "+y);
    	        if(y8==0){
            		x8=0;
    	        }
	        }
        	else if(y8==0){
        		x8=0;
        	}
        	else if(x8>=-428){
        		ani8.setLocation(315, x8);
        		System.out.println("1ssss "+x);
    	        x8--;
    	        if(x8==-428){
            		y8=-428;
            	}
        	}
        	else if(x8==-428){
        		y8=-428;
        	}
        }
        else if(dol==20000){
        	l=1;
        }
        }
	}
	
	public static class MyActionListener10 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(dol==20000){
            	l=1;
            	ani1.setLocation(-50, 0);
            	ani2.setLocation(-50, 0);
            	ani3.setLocation(-50, 0);
            	ani4.setLocation(-50, 0);
            	ani5.setLocation(-50, 0);
            	ani6.setLocation(-50, 0);
            	ani7.setLocation(-50, 0);
            	ani8.setLocation(-50, 0);
            	ani9.setLocation(-50, 0);
            	ani10.setLocation(-50, 0);
            	ani11.setLocation(-50, 0);
            	ani12.setLocation(-50, 0);
            	time2.stop();
            	time3.stop();
            	time4.stop();
            	time5.stop();
            	time6.stop();
            	time7.stop();
            	time8.stop();
            	time9.stop();
            	time10.stop();
            	time11.stop();
            	time12.stop();
            	time13.stop();
            }
        	else if(l==0){
        	dol++;
        	if(y9<=0){
        		ani9.setLocation(360, y9);
    	        y9++;
    	        System.out.println("2 "+y);
    	        if(y9==0){
            		x9=0;
    	        }
	        }
        	else if(y9==0){
        		x9=0;
        	}
        	else if(x9>=-428){
        		ani9.setLocation(360, x9);
        		System.out.println("1 "+x);
    	        x9--;
    	        if(x9==-428){
            		y9=-428;
            	}
        	}
        	else if(x9==-428){
        		y9=-428;
        	}
        }
        else if(dol==20000){
        	l=1;
        }
        }
	}
	
	public static class MyActionListener11 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(dol==20000){
            	l=1;
            	ani1.setLocation(-50, 0);
            	ani2.setLocation(-50, 0);
            	ani3.setLocation(-50, 0);
            	ani4.setLocation(-50, 0);
            	ani5.setLocation(-50, 0);
            	ani6.setLocation(-50, 0);
            	ani7.setLocation(-50, 0);
            	ani8.setLocation(-50, 0);
            	ani9.setLocation(-50, 0);
            	ani10.setLocation(-50, 0);
            	ani11.setLocation(-50, 0);
            	ani12.setLocation(-50, 0);
            	time2.stop();
            	time3.stop();
            	time4.stop();
            	time5.stop();
            	time6.stop();
            	time7.stop();
            	time8.stop();
            	time9.stop();
            	time10.stop();
            	time11.stop();
            	time12.stop();
            	time13.stop();
            }
        	else if(l==0){
        	dol++;
        	if(y5<=0){
        		ani10.setLocation(405, y5);
    	        y5++;
    	        System.out.println("2 "+y);
    	        if(y5==0){
            		x5=0;
    	        }
	        }
        	else if(y5==0){
        		x5=0;
        	}
        	else if(x5>=-428){
        		ani10.setLocation(405, x5);
        		System.out.println("1 "+x);
    	        x5--;
    	        if(x5==-428){
            		y5=-428;
            	}
        	}
        	else if(x5==-428){
        		y5=-428;
        	}
        }
        else if(dol==20000){
        	l=1;
        }
        }
	}
	
	public static class MyActionListener12 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(dol==20000){
            	l=1;
            	ani1.setLocation(-50, 0);
            	ani2.setLocation(-50, 0);
            	ani3.setLocation(-50, 0);
            	ani4.setLocation(-50, 0);
            	ani5.setLocation(-50, 0);
            	ani6.setLocation(-50, 0);
            	ani7.setLocation(-50, 0);
            	ani8.setLocation(-50, 0);
            	ani9.setLocation(-50, 0);
            	ani10.setLocation(-50, 0);
            	ani11.setLocation(-50, 0);
            	ani12.setLocation(-50, 0);
            	time2.stop();
            	time3.stop();
            	time4.stop();
            	time5.stop();
            	time6.stop();
            	time7.stop();
            	time8.stop();
            	time9.stop();
            	time10.stop();
            	time11.stop();
            	time12.stop();
            	time13.stop();
            }
        	else if(l==0){
        	dol++;
        	if(y10<=0){
        		ani11.setLocation(450, y10);
    	        y10++;
    	        System.out.println("2 "+y);
    	        if(y10==0){
            		x10=0;
    	        }
	        }
        	else if(y10==0){
        		x10=0;
        	}
        	else if(x10>=-428){
        		ani11.setLocation(450, x10);
        		System.out.println("1 "+x);
    	        x10--;
    	        if(x10==-428){
            		y10=-428;
            	}
        	}
        	else if(x10==-428){
        		y10=-428;
        	}
        }
        else if(dol==20000){
        	l=1;
        }
        }
	}
	
	public static class MyActionListener13 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	if(dol==20000){
            	l=1;
            	ani1.setLocation(-50, 0);
            	ani2.setLocation(-50, 0);
            	ani3.setLocation(-50, 0);
            	ani4.setLocation(-50, 0);
            	ani5.setLocation(-50, 0);
            	ani6.setLocation(-50, 0);
            	ani7.setLocation(-50, 0);
            	ani8.setLocation(-50, 0);
            	ani9.setLocation(-50, 0);
            	ani10.setLocation(-50, 0);
            	ani11.setLocation(-50, 0);
            	ani12.setLocation(-50, 0);
            	time2.stop();
            	time3.stop();
            	time4.stop();
            	time5.stop();
            	time6.stop();
            	time7.stop();
            	time8.stop();
            	time9.stop();
            	time10.stop();
            	time11.stop();
            	time12.stop();
            	time13.stop();
            }
        	else if(l==0){
        	dol++;
        	if(y11<=0){
        		ani12.setLocation(495, y11);
    	        y11++;
    	        System.out.println("2 "+y);
    	        if(y11==0){
            		x11=0;
    	        }
	        }
        	else if(y11==0){
        		x11=0;
        	}
        	else if(x11>=-428){
        		ani12.setLocation(495, x11);
        		System.out.println("1 "+x);
    	        x11--;
    	        if(x11==-428){
            		y11=-428;
            	}
        	}
        	else if(x11==-428){
        		y11=-428;
        	}
        }
        else if(dol==20000){
        	l=1;
        }
        }
	}
	
	
	static Timer time1=new Timer(60,new MyActionListener1());
	static Timer time2=new Timer(1,new MyActionListener2());
	static Timer time3=new Timer(2,new MyActionListener3());
	static Timer time4=new Timer(4,new MyActionListener4());
	static Timer time5=new Timer(5,new MyActionListener5());
	static Timer time6=new Timer(3,new MyActionListener6());
	
	static Timer time7=new Timer(6,new MyActionListener7());
	static Timer time8=new Timer(2,new MyActionListener8());
	static Timer time9=new Timer(0,new MyActionListener9());
	static Timer time10=new Timer(1,new MyActionListener10());
	static Timer time11=new Timer(3,new MyActionListener11());
	static Timer time12=new Timer(7,new MyActionListener12());
	static Timer time13=new Timer(4,new MyActionListener13());
	
	static Loading frame = new Loading();
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					time1.start();
					time2.start();
					time3.start();
					time4.start();
					time5.start();
					time6.start();
					time7.start();
					time8.start();
					time9.start();
					time10.start();
					time11.start();
					time12.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loading() {
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
       
        
        ani1.setIcon(new ImageIcon(Loading.class.getResource("/img/dol.png")));
		ani1.setBounds(0, 0, 45, 1389);
		getContentPane().add(ani1);
        
		ani2.setIcon(new ImageIcon(Loading.class.getResource("/img/dol.png")));
		ani2.setBounds(10, 0, 45, 1389);
		getContentPane().add(ani2);
		
		ani3.setIcon(new ImageIcon(Loading.class.getResource("/img/dol.png")));
		ani3.setBounds(10, 0, 45, 1389);
		getContentPane().add(ani3);
		
		ani4.setIcon(new ImageIcon(Loading.class.getResource("/img/dol.png")));
		ani4.setBounds(10, 0, 45, 1389);
		getContentPane().add(ani4);
		
		ani5.setIcon(new ImageIcon(Loading.class.getResource("/img/dol.png")));
		ani5.setBounds(10, 0, 45, 1389);
		getContentPane().add(ani5);
		
		ani6.setIcon(new ImageIcon(Loading.class.getResource("/img/dol.png")));
		ani6.setBounds(10, 0, 45, 1389);
		getContentPane().add(ani6);
		
		ani7.setIcon(new ImageIcon(Loading.class.getResource("/img/dol.png")));
		ani7.setBounds(10, 0, 45, 1389);
		getContentPane().add(ani7);
		
		ani8.setIcon(new ImageIcon(Loading.class.getResource("/img/dol.png")));
		ani8.setBounds(10, 0, 45, 1389);
		getContentPane().add(ani8);
		
		ani9.setIcon(new ImageIcon(Loading.class.getResource("/img/dol.png")));
		ani9.setBounds(10, 0, 45, 1389);
		getContentPane().add(ani9);
		
		ani10.setIcon(new ImageIcon(Loading.class.getResource("/img/dol.png")));
		ani10.setBounds(10, 0, 45, 1389);
		getContentPane().add(ani10);
        
		ani11.setIcon(new ImageIcon(Loading.class.getResource("/img/dol.png")));
		ani11.setBounds(10, 0, 45, 1389);
		getContentPane().add(ani11);
		
		ani12.setIcon(new ImageIcon(Loading.class.getResource("/img/dol.png")));
		ani12.setBounds(10, 0, 45, 1389);
		getContentPane().add(ani12);
        
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

