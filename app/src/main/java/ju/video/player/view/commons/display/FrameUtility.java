package ju.video.player.view.commons.display;

import javax.swing.JFrame;

import ju.video.player.view.commons.utils.Utils;

public class FrameUtility {

	public static JFrame build(String name, int x, int y, int width, int height, boolean moveable) {
		//Utils.registerFont("Arial", 1);

		JFrame frame = new JFrame(name);
		frame.setBounds(x, y, width, height);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}

}