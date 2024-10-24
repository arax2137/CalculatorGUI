package gui;

import service.CalculatorService;

import javax.swing.*;
import java.awt.*;

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
        display.updateDisplay(calc.getCurrent());
        buttonPanel.addPropertyChangeListener(buttonPanel.PRESSED, evt -> {
            String c = buttonPanel.getCharacter();

            if(c.matches("[0-9]") || c.charAt(0) == '.'){
                calc.addToCurrent(c.charAt(0));
                display.updateDisplay(calc.getCurrent());
            } else if (c.matches("[+/*-]")) {
                calc.startOperation(c.charAt(0));
                display.updateDisplay(calc.getResult());
            } else if (c.charAt(0) =='√') {
                calc.startOperation(c.charAt(0));
                calc.equals();
                display.updateDisplay(calc.getResult());
            } else if (c.charAt(0)=='=') {
                calc.equals();
                display.updateDisplay(calc.getResult());
            } else if (c.equals("AC")) {
                calc.clearAll();
                display.updateDisplay(calc.getResult());
            } else if (c.equals("CE")) {
                if (!calc.getCurrent().equals("0")) {
                    calc.clearEntry();
                    display.updateDisplay(calc.getCurrent());
                }
            } else if (c.equals("+/-")) {
                calc.changeSigns();
                display.updateDisplay(calc.getResult());
            } else if (c.equals("<-")) {
                if(calc.getCurrent() != "0" && calc.getCurrent() != ""){
                    calc.deleteFromCurrent();
                    display.updateDisplay(calc.getCurrent());
                }
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
