package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioPanel extends JPanel implements ActionListener {

    private JRadioButton on;
    private JRadioButton off;
    ButtonGroup bg;
    public final String PRESSED = "pressed";
    private boolean enabled = false;


    public RadioPanel() {
        setLayout(new GridLayout(2,1));
        on = new JRadioButton("on");
        off = new JRadioButton("off");

        add(on);
        add(off);
        on.addActionListener(this);
        off.addActionListener(this);

        off.setSelected(true);

        bg = new ButtonGroup();
        bg.add(on);
        bg.add(off);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==on) {
            enabled = true;
        } else {
            enabled = false;
        }


        firePropertyChange(PRESSED, null, PRESSED);
    }

    public boolean getEnabled(){
        return enabled;
    }


}
