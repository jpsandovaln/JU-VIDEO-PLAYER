package ju.video.player.view.materialDesing.components.combobox;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.UIManager;

import ju.video.player.view.materialDesing.ResponsiveSwingMaterialDesign;
import ju.video.player.view.materialDesing.callback.CallbackT;
import ju.video.player.view.materialDesing.components.combobox.render.MaterialComboBoxEditor;
import ju.video.player.view.materialDesing.components.combobox.render.MaterialComboBoxRenderer;
import ju.video.player.view.materialDesing.components.combobox.render.MaterialComboBoxUI;
import ju.video.player.view.materialDesing.layouts.ResponsiveLayout;
import ju.video.player.view.materialDesing.utils.Utils;

@SuppressWarnings({ "serial", "rawtypes" })
public class ComboBox extends JComboBox {
	@SuppressWarnings("unchecked")
	public ComboBox(ResponsiveLayout responsiveLayout, List<Object> itens) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		this.setEditor(new MaterialComboBoxEditor());
		this.setRenderer(new MaterialComboBoxRenderer());
		this.setUI(new MaterialComboBoxUI());
		for (Object obj : itens) {
			this.addItem(obj.toString());
		}
		this.setFont(Utils.getMainFont(22));
		this.setBackground(new Color(0, 0, 0, 0));
	}

	@Override
	public void repaint() {
		super.repaint();
		if (getForeground() != null && !getForeground().equals(ResponsiveSwingMaterialDesign.PRIMARY_COLOR)) {
			setForeground(ResponsiveSwingMaterialDesign.TEXT_COLOR);
		}
	}
	
	public ComboBox getComponent() {
		return this;
	}
	
	public void addValueChangeListener(CallbackT valueChangeListener) {
		this.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object item = e.getItem();
					if (valueChangeListener != null) {
						valueChangeListener.done(item);
					}
				}
			}
		});
	}
}
