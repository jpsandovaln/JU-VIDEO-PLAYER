package ju.video.player.view.materialDesing.animation;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JComponent;

import ju.video.player.view.materialDesing.callback.Callback;
import ju.video.player.view.materialDesing.utils.Utils;

public class Animation {

	private JComponent component;
	private Point point1, point2;
	private Font font;
	private Callback callback;
	public static final int STEP = 1;
	
	public Animation(JComponent component, Point point1, Point point2) {
		this.component = component;
		this.font = Utils.getMainFont(component.getFont().getSize() - (component.getFont().getSize() / 3));
		this.point1 = point1;
		this.point2 = point2;
	}
	
	public JComponent getComponent() {
		return component;
	}
	public int getYSkipper() {
		return point1.getY() - point2.getY() < 0 ? STEP : -STEP;
	}
	public Point getPoint1() {
		return point1;
	}
	public Point getPoint2() {
		return point2;
	}
	public Font getFont() {
		return font;
	}
	public void setCallback(Callback callback) {
		this.callback = callback;
	}
	public Callback getCallback() {
		return callback;
	}
}
