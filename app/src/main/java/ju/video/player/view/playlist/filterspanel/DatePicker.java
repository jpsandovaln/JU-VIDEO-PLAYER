/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
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
import ju.video.player.view.commons.UIColor;
import ju.video.player.view.commons.UIFont;

/**
 * It is the Date Piscker Dialog
 *
 * @author Adriana Olivera
 * @version 1.0
 */

public class DatePicker {
	private static final int WEEKDAYS = 7;
	private int month = Calendar.getInstance().get(Calendar.MONTH);
	private int year = Calendar.getInstance().get(Calendar.YEAR);;
	private JLabel label = new JLabel("", JLabel.CENTER);
	private String day = "";
	private JDialog dialog;
	private JButton[] button = new JButton[49];

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
			button[index].setForeground(UIColor.COMPONETS_COLOR);
			if (index >= WEEKDAYS) {
				button[index].setBackground(UIColor.SECONDARY_BACKGROUNG_COLOR);
				button[index].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						day = button[selection].getActionCommand();
						dialog.dispose();
					}
				});
			}
			if (index < WEEKDAYS) {
				button[index].setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
				button[index].setText(header[index]);
			}
			calendarPanel.add(button[index]);
		}
		JPanel headerPanel = new JPanel(new BorderLayout());
		headerPanel.setBackground(UIColor.SECONDARY_BACKGROUNG_COLOR);
		
		Button prevButton = new Button(" << ");
		prevButton.setBackground(UIColor.SECONDARY_BACKGROUNG_COLOR);
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
		label.setForeground(UIColor.COMPONETS_COLOR);
		label.setFont(UIFont.COMMON_FONT);
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

	/**
	 * This update the calendar of the dialog
	 */
	public void displayDate() {
		for (int index = WEEKDAYS; index < button.length; index++) {
			button[index].setText("");
		}
		Calendar cal = Calendar.getInstance();
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		cal.set(year, month, 1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int index = WEEKDAYS - 1 + dayOfWeek, day = 1; day <= daysInMonth; index++, day++) {
			button[index].setText("" + day);
			label.setText(months[month] + " " + year);
		}
		dialog.setTitle("Date Picker");
	}

	/**
	 * Create the String for the selected date in the picker
	 * 
	 * @return date selected
	 */
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