package blockchainGUI;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeListener;

public class RadioButtonWithImage extends JPanel {

JRadioButton radio = new JRadioButton();
JLabel image;

public RadioButtonWithImage(Icon icon) {
    image = new  JLabel(icon);
    add(radio);
    add(image);
}

public void addToButtonGroup(ButtonGroup group) {
    group.add(radio);
}

public void addActionListener(ActionListener listener) {
    radio.addActionListener(listener);
}

public void addChangeListener(ChangeListener listener) {
    radio.addChangeListener(listener);
}

public Icon getImage() {
    return image.getIcon();
}

public void setImage(Icon icon) {
    image.setIcon(icon);
}

} // end class RadioButtonWithImage