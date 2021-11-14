package pj_gui2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sumWindow {
    private JButton sumButton;
    private JTextField tfA;
    private JTextField tfB;
    public JPanel sumPanel;

    public sumWindow() {
        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = 0;
                double b = 0;
                boolean isASet = false;
                boolean isBSet = false;
                try {
                    a = Double.valueOf(tfA.getText().replace(",", ".").trim());
                    isASet = true;

                } catch (Exception m) {
                    JOptionPane.showMessageDialog(null, "Your A value should be a number!");
                }
                try {
                    b = Double.valueOf(tfB.getText().replace(",", ".").trim());
                    isBSet = true;
                } catch (Exception m) {
                    JOptionPane.showMessageDialog(null, "Your B value should be a number!");
                }
                if (isASet && isBSet) {
                    JOptionPane.showMessageDialog(null, String.valueOf(a + b));
                }

            }
        });
    }
}
