package gui;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    JLabel textField;

    public Display() {
        textField = new JLabel("", SwingConstants.RIGHT);
        textField.setFont(new Font("Segoe UI", Font.BOLD, 40));

        add(textField);

    }

    public void updateDisplay(String text){
        textField.setText(text);
    }
}
