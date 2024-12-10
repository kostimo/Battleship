import java.io.InputStream;
import java.util.Scanner;

public class Player implements PlayerAction {
    private final String name;
    private boolean secondTry;   // in case player shoots a cell that has already been damaged
    private final GameBoard board =new GameBoard();
    public Player(String name)
    {
        this.name =name;
    }

    public Ship askForShip() {
        System.out.printf("\n%s's creating a ship. Please give a type, coordinates and direction.\n", this.name);
        System.out.print("Your input: ");
        Scanner sc = new Scanner(System.in);

        char type = sc.next().charAt(0);
        int x = sc.nextInt();
        int y = sc.nextInt();
        boolean isVertical = sc.nextBoolean();

        if (type == 'b') {
            return new Battleship(x, y, isVertical);
        }
        return new Destroyer(x, y, isVertical);
    }
    @Override
    public void placeShip(Ship ship) {
        boolean success = this.board.placeShip(ship);
        if (success) System.out.println("Success! The ship is placed.");
        else System.out.println("Error! The ship couldn't be placed.");
    }

    @Override
    public void shoot(int x, int y) {
        this.secondTry =false;
        boolean success = this.board.shootShip(this, x, y);

        if (success)             System.out.println("Success! A ship is damaged.");
        else if (this.secondTry) System.out.println("You have already shot here earlier.\n" +
                                                    "Please choose another area and try again.");
        else                     System.out.println("Oh no, you have missed!");
    }

    public GameBoard getBoard() {
        return board;
    }
    public void setSecondTry(boolean secondTry) {
        this.secondTry = secondTry;
    }
    public String getName() {
        return name;
    }
}
