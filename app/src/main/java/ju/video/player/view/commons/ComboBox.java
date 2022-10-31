/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.commons;

import javax.swing.JComboBox;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * It is for create a comboBox with its respective features.
 *
 * @author Adriana Olivera
 * @version 1.0
 */

public class ComboBox extends JComboBox<String> implements ItemListener {

    public ComboBox(String[] itemsList) {
        addItem("All formats");
        addItems(itemsList);
        addItemListener(this);
        setBackground(UIColor.SECONDARY_BACKGROUNG_COLOR);
        setForeground(UIColor.COMPONETS_COLOR);
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    /**
     * Add a list of items to the comboBox
     *
     * @param itemsList, this is the list of formats to display in the combo box.
     */
    private void addItems(String[] itemsList) {
        for (int index = 0; index < itemsList.length; index++) {
            addItem(itemsList[index]);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == this) {
        }
    }

    /**
     * Add the option All items to the dropDown
     */
    public void addAllOption(String item) {
        this.addItem("All " + item);
    }
}
