package ju.video.player.view.commons;

import javax.swing.JComboBox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBox extends JComboBox<String> implements ItemListener {
    public ComboBox(String[] itemsList) {
        addItems(itemsList);
        setBounds(10,10,80,20);
        addItemListener(this);
    }

    private void addItems(String[] itemsList) {
        for(int index = 0; index < itemsList.length; index++) {
            addItem(itemsList[index]);
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == this) {
            //String seleccionado = (String) getSelectedItem();
            //(String) setTitle(seleccionado);
        }
    }
}
