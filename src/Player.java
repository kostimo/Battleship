import java.io.InputStream;
import java.util.Scanner;

public class Player implements PlayerAction {
    private String name;
    private GameBoard board =new GameBoard();
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
        int direction = sc.nextInt();

        switch (type)
        {
            case 'b': return new Battleship(x, y, direction);
            default: return new Destroyer(x, y, direction);
        }
    }
    @Override
    public void placeShip(Ship ship) {
        boolean success = this.board.placeShip(ship);
        if (success) System.out.println("Success! The ship is placed.");
        else System.out.println("Error! The ship couldnt be placed.");
    }

    @Override
    public boolean shoot(int x, int y) {
        return false;
    }

    public GameBoard getBoard() {
        return board;
    }
}
