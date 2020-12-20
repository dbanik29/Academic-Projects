import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import com.qt.datapicker.DatePicker;

class ObservingTextField extends JTextField implements Observer {
	    public void update(Observable o, Object arg) {
	        Calendar calendar = (Calendar) arg;
	        DatePicker dp = (DatePicker) o;
	        System.out.println("picked=" + dp.formatDate(calendar));
	        setText(dp.formatDate(calendar));
	    }
	}

