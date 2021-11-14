package pj_gui2;

import javax.swing.*;
import java.sql.SQLOutput;

public class chessWindow {
    public JPanel chessPanel;
    private JTextField chessField;
    private String board;


    public void initialize() {
        System.out.println("Initializing board...");
        HraSachovniceManual game = new HraSachovniceManual();
        System.out.println("x: " + game.actual_x);
        System.out.println("y: " + game.actual_y);
        board = game.drawGrid();
        System.out.println(board);
        chessField.setText(board);
    }
}


