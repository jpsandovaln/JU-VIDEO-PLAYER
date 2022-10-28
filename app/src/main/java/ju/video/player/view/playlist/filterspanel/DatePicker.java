package ju.video.player.view.playlist.filterspanel;
 
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Calendar;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JPanel;

import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.Colors;
import ju.video.player.view.commons.Fonts;

public class DatePicker {
	int month = Calendar.getInstance().get(Calendar.MONTH);
	int year = Calendar.getInstance().get(Calendar.YEAR);;
	JLabel label = new JLabel("", JLabel.CENTER);
	String day = "";
	JDialog dialog;
	JButton[] button = new JButton[49];

	public DatePicker(DateComponentsPanel parent) {
		dialog = new JDialog();
		dialog.setModal(true);
		String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
		JPanel calendarPanel = new JPanel(new GridLayout(7, 7));
		calendarPanel.setPreferredSize(new Dimension(420, 200));

		for (int index = 0; index < button.length; index++) {
			final int selection = index;
			button[index] = new JButton();
			button[index].setFocusPainted(false);
			button[index].setForeground(Colors.COMPONETS_COLOR);
			if (index > 6)
				button[index].setBackground(Colors.SECONDARY_BACKGROUNG_COLOR);
				button[index].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						day = button[selection].getActionCommand();
						dialog.dispose();
					}
				});
			if (index < 7) {
				button[index].setBackground(Colors.PRIMARY_BACKGROUNG_COLOR);
				button[index].setText(header[index]);
			}
			calendarPanel.add(button[index]);
		}
		JPanel headerPanel = new JPanel(new BorderLayout());
		headerPanel.setBackground(Colors.SECONDARY_BACKGROUNG_COLOR);
		
		Button prevButton = new Button(" << ");
		prevButton.setBackground(Colors.SECONDARY_BACKGROUNG_COLOR);
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(month == 0) {
					month = 11;
					year--;
				} else {
					month--;
				}
				displayDate();
			}
		});
		headerPanel.add(prevButton, BorderLayout.WEST);
		label.setForeground(Colors.COMPONETS_COLOR);
		label.setFont(Fonts.COMMON_FONT);
		headerPanel.add(label, BorderLayout.CENTER);
		Button nextButton = new Button(" >> ");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(month == 11) {
					month = 0;
					year++;
				} else {
					month++;
				}
				displayDate();
			}
		});
		headerPanel.add(nextButton, BorderLayout.EAST);
		dialog.add(calendarPanel, BorderLayout.CENTER);
		dialog.add(headerPanel, BorderLayout.NORTH);
		dialog.pack();
		dialog.setLocationRelativeTo(parent);
		displayDate();
		dialog.setVisible(true);
	}

	public void displayDate() {
		for (int index = 7; index < button.length; index++) {
			button[index].setText("");
		}
		Calendar cal = Calendar.getInstance();
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		cal.set(year, month, 1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int index = 6 + dayOfWeek, day = 1; day <= daysInMonth; index++, day++) {
			button[index].setText("" + day);
			label.setText(months[month] + " " + year);
		}
		dialog.setTitle("Date Picker");
	}

	public String setPickedDate() {
		if (day.equals("")){
			return day;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, Integer.parseInt(day));
		return dateFormat.format(cal.getTime());
	}
}