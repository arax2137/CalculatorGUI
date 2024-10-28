package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {

    private JButton[] numberButtons;
    private JButton add;
    private JButton subtract;
    private JButton multiply;
    private JButton divide;
    private JButton sqrt;
    private JButton percent;
    private JButton equals;
    private JButton mplus;
    private JButton mminus;
    private JButton mrc;
    private JButton ce;
    private JButton ac;
    private JButton back;
    private JButton coma;
    private JButton sign;

    private String character;

    public static final String PRESSED = "pressed";

    public ButtonPanel() {
        GridLayout grid = new GridLayout(5,5);
        setLayout(grid);
        setPreferredSize(new Dimension(400,400));
        grid.setHgap(0);
        grid.setVgap(0);
        setBorder(BorderFactory.createEmptyBorder(0,0,5,0));

        numberButtons = new JButton[10];
        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        sqrt = new JButton("√");
        percent = new JButton("%");
        equals = new JButton("=");
        mplus = new JButton("M+");
        mminus = new JButton("M-");
        mrc = new JButton("MRC");
        ce = new JButton("CE");
        ac = new JButton("AC");
        back = new JButton("<-");
        coma = new JButton(".");
        sign = new JButton("+/-");

        JPanel[][] filler = new JPanel[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5;  j++){
                filler[i][j] = new JPanel();
                add(filler[i][j]);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3;  j++){
                numberButtons[3*i + j + 1] = new JButton(""+(3*i + j + 1));
                filler[i+1][j+1].add(numberButtons[3*i + j + 1]);
            }
        }
        filler[0][0].add(mrc);
        filler[0][1].add(mminus);
        filler[0][2].add(mplus);
        filler[0][3].add(sqrt);
        filler[0][4].add(percent);
        filler[1][0].add(back);
        filler[1][4].add(divide);
        filler[2][0].add(ce);
        filler[2][4].add(multiply);
        filler[3][0].add(ac);
        filler[3][4].add(subtract);
        filler[4][0].add(sign);
        numberButtons[0] = new JButton("0");
        filler[4][1].add(numberButtons[0]);
        filler[4][2].add(coma);
        filler[4][3].add(add);
        filler[4][4].add(equals);

        for(Component c : getComponents()){
            JPanel panel = (JPanel) c;
            JButton button = (JButton) panel.getComponents()[0];
            button.addActionListener(this);
        }

        disableButtons();

        for(Component c : getComponents()){
            JPanel panel = (JPanel) c;
            JButton button = (JButton) panel.getComponents()[0];
            button.setPreferredSize(new Dimension(74,80));

            if (!button.getText().matches("[0-9]")) {
                button.setBackground(new Color(51, 51, 51));
            } else {
                button.setBackground(new Color(61,61,61));
            }



            //button.setBackground(new Color(120,133,255));

        }





    }


    public void disableButtons(){
        for(Component c : getComponents()){
            JPanel panel = (JPanel) c;
            JButton button = (JButton) panel.getComponents()[0];
            button.setEnabled(false);
        }

    }

    public void enableButtons(){
        for(Component c : getComponents()){
            JPanel panel = (JPanel) c;
            JButton button = (JButton) panel.getComponents()[0];
            button.setEnabled(true);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        character = ((JButton) e.getSource()).getText();
        firePropertyChange(PRESSED, null, PRESSED);
    }

    public String getCharacter() {
        return character;
    }
}
