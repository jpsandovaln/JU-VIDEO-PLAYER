/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University
 */
package ju.video.player.view.commons.display;

import javax.swing.JFrame;

public class FrameUtility {

	public static JFrame build(String name, int x, int y, int width, int height, boolean moveable) {
		JFrame frame = new JFrame(name);
		frame.setBounds(x, y, width, height);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}

}