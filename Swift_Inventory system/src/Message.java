import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import java.net.URLConnection;
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
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingConstants;

public class Message extends JFrame {
	
	JLabel user_id = new JLabel("");
	

	
	public JPanel contentPane;
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
	JLabel swift_logo = new JLabel("");
	public JLabel Message = new JLabel("Message");
	    
	/**
	 * Launch the application.
	 */
	    static Message frame = new Message();
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
	public void invoice(String value){
		
		
	}
	
	
	
	private ObservingTextField dateText;
	public JLabel Message1 = new JLabel("Message");
	private Locale getLocale(String loc){
		if(loc!=null && loc.length()>0){
			return new Locale(loc);
		}
		else{
			return Locale.US;
		}
	};
	 // cell must be displayed.
    class MyTableCellRenderer extends JLabel implements TableCellRenderer {
        // This method is called each time a cell in a column
        // using this renderer needs to be rendered.
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {
            // 'value' is value contained in the cell located at
            // (rowIndex, vColIndex)

            if (isSelected) {
                // cell (and perhaps other cells) are selected

            }

            if (hasFocus) {
                // this cell is the anchor and the table has the focus
                this.setBackground(Color.blue);
                this.setForeground(Color.green);
            } else {
                this.setForeground(Color.black);
            }

            // Configure the component with the specified value
            setText(value.toString());

            // Set tool tip if desired
            // setToolTipText((String)value);

            // Since the renderer is a component, return itself
            return this;
        }

        // The following methods override the defaults for performance reasons
        public void validate() {}
        public void revalidate() {}
        protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {}
        public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {}
    }
	/**
	 * Create the frame.
	 */
	public Message() {
		
		
		try { 
	         
			Time=new java.util.Date().toString();
			String[] TimeAr=Time.split(" ");
	         
	        
	      }catch (Exception e) {
	         System.out.println("Got an exception!"); 
	      }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setUndecorated(true);
	    setBackground(new Color(0, 0, 0, 0));
	    
		setBounds(-100, -100, 405, 117);
		setShape(new RoundRectangle2D.Double(00, 00, 405, 117, 0, 0));
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getSize().height; //get the heigth of the frame
        int framelocationX=(dim.width-framewidth)/2; 
        int framelocationY=(dim.height-frameheigth)/2;
        this.setLocation(framelocationX,framelocationY-50);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		contentPane.setOpaque(false);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
				
			}
		});
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Message.setForeground(Color.WHITE);
		Message.setBounds(83, 28, 280, 25);
		Message.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		Message.setFont(new Font("Garamond", Font.BOLD, 16));
		contentPane.add(Message);
		swift_logo.setBounds(0, 0, 405, 117);
		
		
		
		
		
		swift_logo.setIcon(new ImageIcon(Message.class.getResource("/img/message.png")));
		
		contentPane.add(swift_logo);
		
		JLabel top = new JLabel("");
		top.setBounds(0, 0, -300, -600);
		top.setBackground(Color.LIGHT_GRAY);
		top.setIcon(new ImageIcon(Dashboard.class.getResource("/img/top.png")));
		top.setEnabled(false);
		contentPane.add(top);
		Message1.setBounds(10, 101, -280, 25);
		Message1.setHorizontalAlignment(SwingConstants.CENTER);
		Message1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		contentPane.add(Message1);
		
		user_id.setBounds(-2220, 71, 46, 14);
		contentPane.add(user_id);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
