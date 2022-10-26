package ju.video.player.view.materialDesing.components.buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import ju.video.player.controller.ButtonController;
import ju.video.player.view.materialDesing.ResponsiveSwingMaterialDesign;
import ju.video.player.view.materialDesing.callback.CallbackT;
import ju.video.player.view.materialDesing.components.utils.RoundedBorder;
import ju.video.player.view.materialDesing.layouts.ResponsiveLayout;
import ju.video.player.view.materialDesing.utils.Utils;

public class MaterialButton extends JButton {

	private final int RADIUS = 15;
	
	private ResponsiveLayout responsiveLayout;
	
	private RoundedButton backgroundButton;
	private JLabel textLabel;
	private Font defaultFont = Utils.getMainFont(15);
	
	private Color hoverColor;
	
	private Color primaryColor = new Color(0, 0, 0);

	@SuppressWarnings("serial")
	public MaterialButton(String text, ResponsiveLayout responsiveLayout, CallbackT eventCallback) {
		this.responsiveLayout = responsiveLayout;
		this.backgroundButton = new RoundedButton(text, defaultFont, ResponsiveSwingMaterialDesign.PRIMARY_COLOR, new Rectangle(), RADIUS, 1, eventCallback) {
			@Override
			public void repaint() {
				super.repaint();
				if (backgroundButton != null && !primaryColor.equals(ResponsiveSwingMaterialDesign.PRIMARY_COLOR)) {
					primaryColor = ResponsiveSwingMaterialDesign.PRIMARY_COLOR;

					backgroundButton.recolor(ResponsiveSwingMaterialDesign.PRIMARY_COLOR, RADIUS, true);
				}
			}
		};
		this.backgroundButton.setBorder(new RoundedBorder(RADIUS, ResponsiveSwingMaterialDesign.PRIMARY_COLOR, true));
		
		double factor = 0.9;
		
		this.hoverColor = new Color(Math.max((int)(ResponsiveSwingMaterialDesign.PRIMARY_COLOR.getRed()  *factor), 0),
	            Math.max((int)(ResponsiveSwingMaterialDesign.PRIMARY_COLOR.getGreen()*factor), 0),
	            Math.max((int)(ResponsiveSwingMaterialDesign.PRIMARY_COLOR.getBlue() *factor), 0),
	            ResponsiveSwingMaterialDesign.PRIMARY_COLOR.getAlpha());
		
		this.textLabel = new JLabel(text);
		this.textLabel.setForeground(Color.WHITE);
		this.textLabel.setFont(defaultFont);
		this.textLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.textLabel.setVerticalAlignment(SwingConstants.CENTER);
		this.textLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (eventCallback != null)
					eventCallback.done(textLabel.getText());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				primaryColor = ResponsiveSwingMaterialDesign.PRIMARY_COLOR;

				hoverColor = new Color(

					Math.max((int)(primaryColor.getRed() * factor), 0),
					Math.max((int)(primaryColor.getGreen() * factor), 0),
					Math.max((int)(primaryColor.getBlue() * factor), 0),
					primaryColor.getAlpha()
							            
				);

				backgroundButton.recolor(hoverColor, RADIUS, true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backgroundButton.recolor(ResponsiveSwingMaterialDesign.PRIMARY_COLOR, RADIUS, true);
			}
		});
		this.backgroundButton.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				textLabel.setForeground(Color.WHITE);
				backgroundButton.recolor(ResponsiveSwingMaterialDesign.PRIMARY_COLOR, 20, true);
				textLabel.setBounds(backgroundButton.getX(), backgroundButton.getY() - 2, backgroundButton.getWidth(),backgroundButton.getHeight());
			}
		});

	}

	public MaterialButton(String text, ResponsiveLayout responsiveLayout) {
		this.responsiveLayout = responsiveLayout;
		double factor = 0.9;
		this.backgroundButton = new RoundedButton(text, defaultFont, ResponsiveSwingMaterialDesign.PRIMARY_COLOR, new Rectangle(), RADIUS, 1) {
			@Override
			public void repaint() {
				super.repaint();
				if (backgroundButton != null && !primaryColor.equals(ResponsiveSwingMaterialDesign.PRIMARY_COLOR)) {
					primaryColor = ResponsiveSwingMaterialDesign.PRIMARY_COLOR;

					backgroundButton.recolor(ResponsiveSwingMaterialDesign.PRIMARY_COLOR, RADIUS, true);
				}
			}
		};
		this.hoverColor = new Color(Math.max((int)(ResponsiveSwingMaterialDesign.PRIMARY_COLOR.getRed()  *factor), 0),
				Math.max((int)(ResponsiveSwingMaterialDesign.PRIMARY_COLOR.getGreen()*factor), 0),
				Math.max((int)(ResponsiveSwingMaterialDesign.PRIMARY_COLOR.getBlue() *factor), 0),
				ResponsiveSwingMaterialDesign.PRIMARY_COLOR.getAlpha());
		this.backgroundButton.setBorder(new RoundedBorder(RADIUS, ResponsiveSwingMaterialDesign.PRIMARY_COLOR, true));
		this.textLabel = new JLabel(text);
		this.textLabel.setForeground(Color.WHITE);
		this.textLabel.setFont(defaultFont);
		this.textLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.textLabel.setVerticalAlignment(SwingConstants.CENTER);
		this.backgroundButton.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				textLabel.setForeground(Color.WHITE);
				backgroundButton.recolor(ResponsiveSwingMaterialDesign.PRIMARY_COLOR, 20, true);
				textLabel.setBounds(backgroundButton.getX(), backgroundButton.getY() - 2, backgroundButton.getWidth(),backgroundButton.getHeight());
			}
		});

	}

	public RoundedButton getComponent() {
		responsiveLayout.add(textLabel);

		return backgroundButton;
	}
	
	public void seFont(Font font) {
		this.defaultFont = font;
		this.textLabel.setFont(font);
	}
	
	public String getCaption() {
		return textLabel.getText();
	}
	
	public void setCaption(String caption) {
		this.textLabel.setText(caption);
	}
	
}
