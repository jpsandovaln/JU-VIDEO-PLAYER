package ju.video.player.view.materialDesing.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import ju.video.player.view.materialDesing.ResponsiveSwingMaterialDesign;
import ju.video.player.view.materialDesing.components.buttons.MaterialButton;
import ju.video.player.view.materialDesing.components.combobox.ComboBox;
import ju.video.player.view.materialDesing.components.date.fields.DateField;
import ju.video.player.view.materialDesing.components.image.ImageLabel;
import ju.video.player.view.materialDesing.components.input.InputField;
import ju.video.player.view.materialDesing.components.input.PasswordField;
import ju.video.player.view.materialDesing.components.utils.ImageRoundedBorder;
import ju.video.player.view.materialDesing.display.FrameUtility;
import ju.video.player.view.materialDesing.layouts.ResponsiveLayout;
import ju.video.player.view.materialDesing.layouts.ResponsiveLayout.ResponsiveConstants;

public class Demo1_RegisterForm {

	/*
	 * 
	 * RSMDF - RESPONSIVE SWING MATERIAL DESIGN FRAMEWORK BEAULTY AND RESPONSIVE
	 * SWING COMPONENTS
	 * 
	 * COPYRIGHT BY GUSTAVO ROLIM DOS SANTOS 2020 VERSION ALPHA 1.3.0
	 * 
	 * 
	 * THIS VERSION MAY CONTAINS BUGS.
	 * 
	 * https://maxtercreations.com.br
	 * 
	 */

	public static void main(String[] args) {

		JFrame frame = FrameUtility.build("Java Responsive Swing Material Design", 0, 0, 1280, 900, true);

		ResponsiveLayout rl = new ResponsiveLayout(16, 12, frame);

		List<String> comboBoxValues = ResponsiveSwingMaterialDesign.getThemesManager().getThemes().stream().map(theme -> "Tema " + theme.getName()).collect(Collectors.toList());
		ComboBox comboBox = new ComboBox(rl, new ArrayList<>(comboBoxValues));
		comboBox.addValueChangeListener(e -> { ResponsiveSwingMaterialDesign.setCurrentTheme(comboBox.getSelectedItem().toString().replace("Tema ", ""), rl);
		});
		
		comboBox.setSelectedIndex(1);

		ImageLabel imageLabel = new ImageLabel("\\image.png", rl, 120, 120, 120);
		
		ImageRoundedBorder roundedBorder = new ImageRoundedBorder(120, ResponsiveSwingMaterialDesign.PRIMARY_COLOR);
		roundedBorder.setStroke(2);

		imageLabel.setBorder(roundedBorder);
		
		rl.add(imageLabel.getComponent(), 4, 1, ResponsiveConstants.CENTER);
		rl.addRow();
		rl.add(new InputField("Email de contato", rl).email().getComponent(), 6, 1, ResponsiveConstants.CENTER);
		rl.addRow();
		rl.add(new InputField("Telefone de contato", rl).setRequired(false).phone().getComponent(), 6, 1, ResponsiveConstants.CENTER);
		rl.addRow();
		rl.add(new PasswordField("Senha", rl).setRequired(false).getComponent(), 6, 1, ResponsiveConstants.CENTER);
		rl.addRow();
		rl.add(comboBox.getComponent(), 6, 1, ResponsiveConstants.CENTER);
		rl.addRow();
		rl.add(new DateField("Data de Nascimento", rl).setRequired(false).getComponent(), 6, 1, ResponsiveConstants.CENTER);
		rl.addRow();
		rl.add(new MaterialButton("Registrar", rl, null).getComponent(), 4, 1, ResponsiveConstants.CENTER);

		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}
