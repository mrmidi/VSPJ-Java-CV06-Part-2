package pj_gui2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Chooser {
    private JButton sumNumbersButton;
    public JPanel pMain;
    private JButton chessBoardButton;
    private JButton quadraticSolverButton;

    WindowAdapter windowAdapter = new WindowAdapter() {
        @Override
        public void windowOpened(WindowEvent windowEvent) {
            System.out.println("Window opened: "
                    + windowEvent.getWindow().getName());
        }

        @Override
        public void windowClosed(WindowEvent windowEvent) {
            System.out.println("Window closed: "
                    + windowEvent.getWindow().getName());
        }
    };

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
        chessBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame chess = new JFrame("Chessboard");
                chess.setContentPane(new chessWindow().chessPanel);
                chess.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                chess.addWindowListener(windowAdapter);
                chess.pack();

                chess.setVisible(true);
            }
        });


    }
}
