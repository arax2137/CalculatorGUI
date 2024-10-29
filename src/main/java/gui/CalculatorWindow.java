package gui;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import service.CalculatorService;

import javax.swing.*;
import java.awt.*;

public class CalculatorWindow extends JFrame {

    CalculatorService calc;


    public CalculatorWindow() {
        super("Calculator");
        //setLayout(new BorderLayout());
        setLayout(new GridBagLayout());

        ButtonPanel buttonPanel = new ButtonPanel();
        RadioPanel radioPanel = new RadioPanel();
        Display display = new Display();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.gridwidth = gbc.REMAINDER;

        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(display, gbc);

        gbc.weighty = 0;
        gbc.gridy = 1;
        add(radioPanel, gbc);

        gbc.weighty = 1;
        gbc.gridy = 2;
        add(buttonPanel, gbc);

        radioPanel.addPropertyChangeListener(radioPanel.PRESSED, evt -> {
            if (radioPanel.getEnabled()) {
                buttonPanel.enableButtons();
                System.out.println("on");
                display.updateDisplay("0");
            } else {
                buttonPanel.disableButtons();
                System.out.println("off");
                display.updateDisplay("-");
            }
        });
        setSize(420,550);
        setMinimumSize(new Dimension(420,550));
        setResizable(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        calc = new CalculatorService();
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
            } else if (c.equals("%")) {
                if(calc.getCurrent() != "0" && calc.getCurrent() != "") {
                    calc.percent();
                    display.updateDisplay(calc.getCurrent());
                }
            } else if(c.equals("MRC")){
                calc.memoryRecall();
                display.updateDisplay(calc.getCurrent());
            } else if(c.equals("M-")){
                calc.memoryDelete();
            } else if(c.equals("M+")){
                calc.memoryAdd();
            }





        });

        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception e) {
            System.err.println("Exception during setting LAF");;
        }

        new CalculatorWindow();
    }

}
