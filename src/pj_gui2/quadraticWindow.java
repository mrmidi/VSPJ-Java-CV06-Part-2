package pj_gui2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.commons.math3.*;
import org.apache.commons.math3.analysis.solvers.LaguerreSolver;
import org.apache.commons.math3.complex.Complex;
import java.math.*;

public class quadraticWindow {
    public JPanel quadraticPanel;
    private JButton discriminantButton;
    private JTextField tfA;
    private JTextField tfB;
    private JTextField tfC;
    private JButton complexButton;
    private JTextPane quadraticEquationsSolverEnterTextPane;

    public quadraticWindow() {
        complexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LaguerreSolver solver = new LaguerreSolver();
                double[] numbers = new double[3];

                boolean isASet = false;
                boolean isBSet = false;
                boolean isCSet = false;
                try {
                    numbers[0] = Double.valueOf(tfA.getText().replace(",", ".").trim());
                    isASet = true;

                } catch (Exception m) {
                    JOptionPane.showMessageDialog(null, "Your A value should be a number!");
                }
                try {
                    numbers[1] = Double.valueOf(tfB.getText().replace(",", ".").trim());
                    isBSet = true;
                } catch (Exception m) {
                    JOptionPane.showMessageDialog(null, "Your B value should be a number!");
                }
                try {
                    numbers[2] = Double.valueOf(tfC.getText().replace(",", ".").trim());
                    isCSet = true;
                } catch (Exception m) {
                    JOptionPane.showMessageDialog(null, "Your C value should be a number!");
                }
                if (isASet && isBSet && isCSet) {
                    Complex[] solution = solver.solveAllComplex(numbers, numbers[0]);
                    String msg = "";
                    for (Complex n:
                            solution) {
                        msg = msg + (n.getReal() + " " + plusOrMinus(n.getImaginary()) + " " + Math.abs(n.getImaginary()) + "j\n");
                        System.out.println(n.getReal() + " " + plusOrMinus(n.getImaginary()) + " " + Math.abs(n.getImaginary()) + "j");
                    }
                    JOptionPane.showMessageDialog(null, msg);
                }



            }
        });
        discriminantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] numbers = new double[3];

                boolean isASet = false;
                boolean isBSet = false;
                boolean isCSet = false;
                try {
                    numbers[0] = Double.valueOf(tfA.getText().replace(",", ".").trim());
                    isASet = true;

                } catch (Exception m) {
                    JOptionPane.showMessageDialog(null, "Your A value should be a number!");
                }
                try {
                    numbers[1] = Double.valueOf(tfB.getText().replace(",", ".").trim());
                    isBSet = true;
                } catch (Exception m) {
                    JOptionPane.showMessageDialog(null, "Your B value should be a number!");
                }
                try {
                    numbers[2] = Double.valueOf(tfC.getText().replace(",", ".").trim());
                    isCSet = true;
                } catch (Exception m) {
                    JOptionPane.showMessageDialog(null, "Your C value should be a number!");
                }
                if (isASet && isBSet && isCSet) {
                    Double d;
                    d = getDisc(numbers);
                    if (d > 0) {
                        //2 solutions
                        String result = "There is TWO roots for this equation:";
                        result =  result + "\n" + String.valueOf((numbers[0] + Math.sqrt(getDisc(numbers)))/2 * numbers[0])+ "\n" + String.valueOf((numbers[0] - Math.sqrt(getDisc(numbers)))/2 * numbers[0]);
                        JOptionPane.showMessageDialog(null, result);
                    }
                    else if (d == 0.0) {
                        //1 solution
                        String result = "There is ONE root for this equation:";
                        result = result + "\n" + String.valueOf((numbers[0] + Math.sqrt(getDisc(numbers)))/2 * numbers[0]);
                        JOptionPane.showMessageDialog(null, result);
                    }
                    else if (d < 0) {
                        //no solutions in real plane
                        String result = "No solutions in real domain. Try complex method";
                        JOptionPane.showMessageDialog(null, result);
                    }
                }
            }
        });
    }

    private String plusOrMinus(double d) {
        if (d < 0) {
            return "-";
        } else {
            return "+";
        }
    }

    private double getDisc(double[] numbers) {
        return (Math.pow(numbers[1],2) - 4 * numbers[0] * numbers[2]);
    }
}
