import java.io.InputStream;
import java.util.Scanner;

public class Player implements PlayerAction {
    private String name;
    private boolean secondTry;   // in case player shoots a cell that has already been damaged
    private final GameBoard board =new GameBoard();
    @Override
    public void placeShip(Ship ship) {
        boolean success = this.board.placeShip(ship);
        if (success) System.out.print("Success! The ship is placed.");
        else System.out.print("Error! The ship couldn't be placed.");
    }
    @Override
    public void shoot(int x, int y) {
        this.secondTry =false;
        boolean success = this.board.shootShip(this, x, y);

        if (success)             System.out.println("Success! A ship is damaged.\n\n");
        else if (this.secondTry) System.out.println("You have already shot here earlier.\n" +
                                                    "Please choose another area and try again.\n");
        else                     System.out.println("Oh no, you have missed!\n\n");
    }

    public GameBoard getBoard() {
        return board;
    }
    public void setSecondTry(boolean secondTry) {
        this.secondTry = secondTry;
    }
    public boolean isSecondTry() {
        return secondTry;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
