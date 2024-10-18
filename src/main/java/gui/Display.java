package gui;

import javax.swing.*;

public class Display extends JPanel {

    JLabel textField;

    public Display() {
        textField = new JLabel("", SwingConstants.RIGHT);
        add(textField);

    }

    public void updateDisplay(String text){
        textField.setText(text);
    }
}
