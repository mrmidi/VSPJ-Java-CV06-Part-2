package pj_gui2;

import java.util.Scanner;


public class HraSachovniceManual extends HraSachovnice implements Cloneable {
    //int[] pos = new int[]{0,0};
    boolean firstDraw = true;
    private static int moveCount = 0;
    private static byte size_x, size_y, actual_x, actual_y;
    private static String grid;



    //constructor w/o parameters
    public HraSachovniceManual() {
        size_x = 7;
        size_y = 7;
        actual_x = 1;
        actual_y = 1;
    }

    public static String getGrid() {
        return grid;
    }

    //constructor with parameters
    public HraSachovniceManual(byte size_x, byte size_y, byte actual_x, byte actual_y) {
        this.size_x = size_x;
        this.size_y = size_y;
        this.actual_x = actual_x;
        this.actual_y = actual_y;
        if (!test()) { //set default size and position if initialized not properly
            this.size_x = 7;
            this.size_y = 7;
            this.actual_x = 1;
            this.actual_y = 1;
        }
    }

    @Override
    public String toString() {
        return "Current position is: [" + toLetter() + "," + (this.actual_y + 1) + "]. Total moves: " + moveCount;
    }

//    public HraSachovnice(int[] pos) {
//        this.pos = pos;
//    }
//
//    public void getPos() {
//        System.out.println("Current position is: [" + toLetter() + "," + (this.pos[1] + 1) + "]");
//    }

    private String toLetter() {
        char letter = (char)(65 + this.actual_x);
        return String.valueOf(letter);
    }

    public static boolean isInBounds() {
        System.out.println("checking...");
        if (actual_x == 0 || actual_y == 0) { return false; }
        if (actual_x == size_x || actual_y == size_y) { return false; }
        return true;
    }

    public boolean test() {
        if (this.size_x <= 0 && this.size_y <= 0) {
        return false; }
        if (this.actual_x > size_x || this.actual_y > size_y) { return false; }
        return true;
    }

    public static boolean can_up() {
        if (actual_y + 1 > size_y) { return false; }
        return true;
    }

    public static boolean can_down() {
        if (actual_y - 1 < 0) { return false; }
        return true;
    }

    public static boolean can_left() {
        if (actual_x - 1 < 0) { return false; }
        return true;
    }

    public static boolean can_right() {
        if (actual_x + 1 > size_x) { return false; }
        return true;
    }

    public boolean can_move(String direction) {
        direction = direction.toLowerCase();
        if (direction.equals("up")) { return can_up(); }
        else if (direction.equals("down")) {return can_down(); }
        else if (direction.equals("left")) {return can_left(); }
        else return can_right();

    }
    //what for?!
    public boolean can_move() {
        return isInBounds();
    }

    public void nacti_direction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hit WSAD to move your figure on the board: ");
        String cmd = scanner.nextLine();
        switch (cmd) {
            case "w":
                moveUp();
                break;
            case "s":
                moveDown();
                break;
            case "a":
                moveLeft();
                break;
            case "d":
                moveRight();
                break;
        }
    }

    public static void moveRight() {
        if (can_right()) {
            actual_x++;
            moveCount++;
        }

    }
    public static void moveLeft() {
        if (can_left()) {
            actual_x--;
            moveCount++;
        }
    }
    public static void moveUp() {
        if (can_up()) {
            actual_y++;
            moveCount++;
        }
    }
    public static void moveDown() {
        if (can_down()) {
            actual_y--;
            moveCount++;
        }
    }




    //draws chessboard line by line from upper side to down
    public void drawGrid() {
        //grid = "";
        System.out.println(" -A-B-C-D-E-F-G-H-");
        grid = " -A-B-C-D-E-F-G-H-\n";
        for (int i = this.size_x; i > -1; i--) {
            drawLine(i);
        }
        //return result;
    }

    public Object clone() throws CloneNotSupportedException {
            return super.clone();
    }

    public void drawLine(int linenumber) {
        if (!this.firstDraw) { //TODO maybe clear console?
        }
        this.firstDraw = false;
        System.out.print(linenumber + 1 + "|");
        grid = grid + (linenumber + 1 + "|");
        String c = " ";
        for (int i = 0; i <= this.size_x; i++) {
            //TODO write black and white squares
            if (this.actual_y == linenumber) { //checks if figure on that row
                //System.out.println("catch");
                if (this.actual_x == i) { //check if figore on that collumn
                    c = "♕";
                } else {
                    c = " ";
                }
            }
            System.out.print(c + "|");
            grid = grid + c + "|";

        }

        System.out.println();
        grid = grid + "\n";
        System.out.println(" -----------------");
        grid = grid + " -----------------\n";
    }


    @Override
    void Execute() {
        nacti_direction();
    }
}
