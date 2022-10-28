package ju.video.player.view.materialDesing.theme;

import java.awt.Color;

public class ThemeModel {

    private String name;
    private Color primaryColor;
    private Color secondaryColor;
    private Color errorColor;
    private Color textColor;
    private Color backgroundColor;

    public ThemeModel(String name, Color primaryColor, Color secondaryColor, Color errorColor, Color textColor,
        Color backgroundColor) {
        super();
        this.name = name;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.errorColor = errorColor;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    public String getName() {
        return name;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public Color getErrorColor() {
        return errorColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
