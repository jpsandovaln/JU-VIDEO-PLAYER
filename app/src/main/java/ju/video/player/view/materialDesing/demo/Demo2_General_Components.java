package ju.video.player.view.materialDesing.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import ju.video.player.view.materialDesing.ResponsiveSwingMaterialDesign;
import ju.video.player.view.materialDesing.components.buttons.MaterialButton;
import ju.video.player.view.materialDesing.components.check.CheckCircle;
import ju.video.player.view.materialDesing.components.combobox.ComboBox;
import ju.video.player.view.materialDesing.components.date.fields.DateField;
import ju.video.player.view.materialDesing.components.date.fields.DateTimeField;
import ju.video.player.view.materialDesing.components.input.InputField;
import ju.video.player.view.materialDesing.components.input.PasswordField;
import ju.video.player.view.materialDesing.components.input.TextArea;
import ju.video.player.view.materialDesing.display.FrameUtility;
import ju.video.player.view.materialDesing.layouts.ResponsiveLayout;

public class Demo2_General_Components {

	/*
	 * 
	 * RSMDF - RESPONSIVE SWING MATERIAL DESIGN FRAMEWORK BEAULTY AND RESPONSIVE
	 * SWING COMPONENTS
	 * 
	 * COPYRIGHT BY GUSTAVO ROLIM DOS SANTOS 2020 VERSION ALPHA 1.0.0
	 * 
	 * 
	 * THIS VERSION MAY CONTAINS BUGS.
	 * 
	 * https://maxtercreations.com.br
	 * 
	 */

	public static void main(String[] args) {

		JFrame frame = FrameUtility.build("Java Responsive Swing Material Design", 0, 0, 1280, 800, true);

		ResponsiveLayout rl = new ResponsiveLayout(12, 12, frame);

		List<String> comboBoxValues = ResponsiveSwingMaterialDesign.getThemesManager().getThemes().stream().map(theme -> "Tema " + theme.getName()).collect(Collectors.toList());
		ComboBox comboBox = new ComboBox(rl, new ArrayList<>(comboBoxValues));

		comboBox.addValueChangeListener(e -> {
			ResponsiveSwingMaterialDesign.setCurrentTheme(comboBox.getSelectedItem().toString().replace("Tema ", ""), rl);
		});

		rl.add(new InputField("Email de contato", rl).email().getComponent(), 4, 1);
		rl.add(new InputField("Telefone de contato", rl).setRequired(false).phone().getComponent(), 4, 1);
		rl.add(new InputField("Valor em reais", rl).money().getComponent(), 4, 1);
		rl.addRow();
		rl.add(new PasswordField("Senha", rl).setRequired(false).getComponent(), 4, 1);
		rl.add(comboBox.getComponent(), 4, 1);
		rl.add(new CheckCircle("Reset", callback -> {
		}, rl).setChecked(true).getComponent(), 4, 1);

		rl.add(new TextArea("Area de Texto", rl).getComponent(), 4, 1);
		rl.add(new TextArea("Area de Texto", rl).getComponent(), 6, 4);
		rl.add(new DateField("Data", rl).setRequired(false).getComponent(), 4, 1);
		rl.add(new DateTimeField("Data e Hora", rl).getComponent(), 6, 1);
		rl.addRow();
		rl.add(new MaterialButton("Clique aqui", rl, null).getComponent(), 2, 0.7);

		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}
