package pj_gui2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chooser {
    private JButton sumNumbersButton;
    public JPanel pMain;
    private JButton chessBoardButton;
    private JButton quadraticSolverButton;

    public Chooser() {
        sumNumbersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame sum = new JFrame("Sum numbers");
                sum.setContentPane(new sumWindow().sumPanel);
                sum.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                sum.pack();
                sum.setVisible(true);
            }
        });
        quadraticSolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame quadratic = new JFrame("Quadratics solver");
                quadratic.setContentPane(new quadraticWindow().quadraticPanel);
                quadratic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                quadratic.pack();
                quadratic.setVisible(true);
            }
        });
    }
}
