package ju.video.player.view.materialDesing.components.date.fields;

import ju.video.player.view.materialDesing.layouts.ResponsiveLayout;

public class DateTimeField extends DateField {

	public DateTimeField(String caption, ResponsiveLayout responsiveLayout) {
		super(caption, responsiveLayout);
		setDateFormat("dd/MM/yyyy HH:mm:ss");
	}


}
