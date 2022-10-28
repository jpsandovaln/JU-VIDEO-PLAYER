package ju.video.player.view.materialDesing.components.combobox.render;

import java.awt.Component;

import javax.swing.plaf.basic.BasicComboBoxEditor;

import ju.video.player.view.materialDesing.ResponsiveSwingMaterialDesign;

public class MaterialComboBoxEditor extends BasicComboBoxEditor {

    @Override
    public Component getEditorComponent() {
        Component component = super.getEditorComponent();
        component.setForeground(ResponsiveSwingMaterialDesign.TEXT_COLOR);
        return component;
    }
}
