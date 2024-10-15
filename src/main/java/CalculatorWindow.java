import javax.swing.*;
import java.awt.*;

public class CalculatorWindow extends JFrame {

    public CalculatorWindow() {
        super("Calculator");
        setLayout(new BorderLayout());
        add(new ButtonPanel(), BorderLayout.SOUTH);
        setSize(400,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorWindow();
    }

}
