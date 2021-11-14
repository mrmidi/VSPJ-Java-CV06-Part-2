package pj_gui2;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLOutput;

public class chessWindow {
    public JPanel chessPanel;
    private JTextArea chessField;
    private JButton upButton;
    private JButton leftButton;
    private JButton rightButton;
    private JButton downButton;
    private JLabel chessStatus;
    private String board;

    HraSachovniceManual game = new HraSachovniceManual();

    public chessWindow() {

        initialize();

        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HraSachovniceManual.moveUp();
                reDraw();
            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HraSachovniceManual.moveLeft();
                reDraw();
            }
        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HraSachovniceManual.moveRight();
                reDraw();
            }
        });
        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HraSachovniceManual.moveDown();
                reDraw();
            }
        });


        upButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                //System.out.println(e.getKeyCode());
                if (e.getKeyCode() == 87 || e.getKeyCode() == 38) {
                    HraSachovniceManual.moveUp();
                    reDraw();
                } else if (e.getKeyCode() == 83 || e.getKeyCode() == 40) {
                    HraSachovniceManual.moveDown();
                    reDraw();
                } else if (e.getKeyCode() == 65 || e.getKeyCode() == 37) {
                    HraSachovniceManual.moveLeft();
                    reDraw();
                } else if (e.getKeyCode() == 68 || e.getKeyCode() == 39) {
                    HraSachovniceManual.moveRight();
                    reDraw();
                }
            }
        });
    }


    private void initialize() {
        System.out.println("Initializing board...");

        game.drawGrid();
        //System.out.println(board);
        board = HraSachovniceManual.getGrid();
        chessField.setText(board);
        chessStatus.setText(game.toString());
    }
    private void reDraw() {
        game.drawGrid();
        chessField.setText(HraSachovniceManual.getGrid());
        chessStatus.setText(game.toString());
        chessPanel.transferFocus();
    }
}


