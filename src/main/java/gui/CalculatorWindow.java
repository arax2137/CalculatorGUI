package gui;

import service.CalculatorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalculatorWindow extends JFrame {

    CalculatorService calc;


    public CalculatorWindow() {
        super("Calculator");
        setLayout(new BorderLayout());

        ButtonPanel buttonPanel = new ButtonPanel();
        RadioPanel radioPanel = new RadioPanel();
        Display display = new Display();

        add(buttonPanel, BorderLayout.SOUTH);
        add(radioPanel, BorderLayout.CENTER);
        add(display, BorderLayout.NORTH);

        radioPanel.addPropertyChangeListener(radioPanel.PRESSED, evt -> {
            if (radioPanel.getEnabled()) {
                buttonPanel.enableButtons();
                System.out.println("on");
            } else {
                buttonPanel.disableButtons();
                System.out.println("off");
            }
        });
        setSize(400,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        calc = new CalculatorService();

        buttonPanel.addPropertyChangeListener(buttonPanel.PRESSED, evt -> {
            String c = buttonPanel.getCharacter();

            if(c.matches("[0-9]")){
                calc.addToCurrent(c.charAt(0));
                display.updateDisplay(calc.getCurrent());
            } else if (c.matches("[+/*-]")) {
                calc.startOperation(c.charAt(0));
                display.updateDisplay(calc.getCurrent());
            } else if (c.charAt(0)=='=') {
                calc.equals();
                display.updateDisplay(calc.getResult());
            } else {
                System.out.println("is weird");
            }



        });












        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorWindow();
    }

}
