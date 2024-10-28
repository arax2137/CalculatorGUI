package gui;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    JLabel textField;
    private int fontSize;

    public Display() {
        fontSize = 40;
        textField = new JLabel("-", SwingConstants.RIGHT);
        textField.setFont(new Font("Segoe UI", Font.BOLD, fontSize));


        add(textField);

    }

    public void updateDisplay(String text){
/*
        if(getSize().getWidth()<getPreferredSize().getWidth()){
            fontSize-=10;
            textField.setFont(new Font("Segoe UI", Font.BOLD, fontSize));
        } else if (getSize().getWidth()>getPreferredSize().getWidth()) {
            fontSize+=10;
            textField.setFont(new Font("Segoe UI", Font.BOLD, fontSize));
        }*/
        textField.setText(text);
    }
}
