import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

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

    public ButtonPanel() {
        super(new GridLayout(5,5));
        setPreferredSize(new Dimension(400,400));

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
        ac = new JButton("ac");
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
                numberButtons[j*i + j + 1] = new JButton(""+(j*i + j + 1));
                filler[i+1][j+1].add(numberButtons[j*i + j + 1]);
            }
        }





    }


    @Override

    public void actionPerformed(ActionEvent e) {

    }
}
