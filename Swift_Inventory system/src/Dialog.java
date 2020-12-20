import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
public class Dialog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialog frame = new Dialog();
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
	public Dialog() {
		
		
		setUndecorated(true);
	    
		setBounds(-100, -100, 440, 251);
		setShape(new RoundRectangle2D.Double(00, 00, 440, 251, 50, 50));
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getSize().height; //get the heigth of the frame
        int framelocationX=(dim.width-framewidth)/2; 
        int framelocationY=(dim.height-frameheigth)/2;
        this.setLocation(framelocationX,framelocationY);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(0,0,0,65));
		contentPane.setOpaque(true);

		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialog = new JLabel("");
		dialog.setIcon(new ImageIcon(Dialog.class.getResource("/img/dialog.png")));
		dialog.setBounds(-5, -5, 450, 261);
		contentPane.add(dialog);
	}

}
