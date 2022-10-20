package ju.video.player.view.materialDesing.components.date;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import ju.video.player.view.materialDesing.callback.CallbackT;
import ju.video.player.view.materialDesing.components.buttons.RoundedFillButton;

public abstract class DatePicker {

	protected JWindow frame;
	protected Date currentDate;
	private String characterInput = "\u2190";
	private String characterOutput = "\u2192";

	protected String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
	protected String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

	protected List<RoundedFillButton> buttons;

	protected JPanel panel;

	protected CallbackT callbackT;

	public DatePicker(CallbackT callbackT) {
		this.currentDate = new Date();
		this.callbackT = callbackT;
		buttons = new ArrayList<>();
		build();
	}

	public DatePicker(Date currentDate, CallbackT callbackT) {
		this.currentDate = currentDate;
		this.callbackT = callbackT;
		buttons = new ArrayList<>();
		build();
	}

	@SuppressWarnings("deprecation")
	public int getYear() {
		return currentDate.getYear() + 1900;
	}

	@SuppressWarnings("deprecation")
	public int getDay() {
		return currentDate.getDay();
	}

	@SuppressWarnings("deprecation")
	public int getMonth() {
		return currentDate.getMonth();
	}

	public int getDayOfWeek() {
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		return dayOfWeek;
	}

	public Date getValue() {
		return currentDate;
	}

	public Calendar getCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		return calendar;
	}

	public JLabel next, last;

	public String lastYear = new String();

	public abstract void build();

	public String getLastMonthText() {
		return "<html> <div style='text-align: center;'> <font size='5'> "+characterInput+" </font></div></html>";
	}

	public String getNextMonthText() {
		return "<html> <div style='text-align: center;'><font size='5'> "+characterOutput+" </font></div></html>";
	}
	
	public abstract void displayDays();

}
