import java.util.ArrayList;
import java.util.Objects;

/**
 * This class represents the game board.
 * It is a 10 by 10 grid and can have 5 ships on it.
 */
public class GameBoard {
    private final int ROWS =10, COLS =10;
    private final String[][] grid =new String[ROWS][COLS];
    private final ArrayList<Ship> shipsOnBoard =new ArrayList<>(5); //board has 5 ships on it

    /**
     * Constructs the game board by generating a default board.
     */
    public GameBoard()
    {
        generateDefaultBoard();
    }

    /**
     * Generates an empty game board with '~' as water on each spot of the grid.
     */
    private void generateDefaultBoard()
    {
        for (int i=0; i<ROWS; i++)
        {
            for (int j=0; j<COLS; j++) { grid[i][j] ="~"; }
        }
    }

    /**
     * Updates the position of all ships to the game board.
     * This method also checks the status of every ship cell and assigns the symbol accordingly:
     * "■" -> ship present, "*" -> ship damaged, "X" -> ship sunk
     */
    public void updateShipsOnBoard()
    {
        for (Ship ship: shipsOnBoard)     // traverses all ships on the board
        {
            for (shipCell cell: ship.getShipCells())    // traverses shipCell's within each ship
            {
                int x =cell.getX();
                int y =cell.getY();
                if (ship.isSunk()) this.grid[y][x] ="X";
                else {
                    if (cell.getIsDamaged()) this.grid[y][x] = "*";
                    else this.grid[y][x] = "■";
                }
            }
        }
    }

    /**
     * Checks if all ships on the board have been sunk.
     *
     * @return true if all ships are sunk, false otherwise
     */
    public boolean areAllShipsSunk()
    {
        boolean allShipsSunk =true;
        for (Ship ship: shipsOnBoard)
        {
            if (!ship.isSunk()) allShipsSunk =false;
        }
        return allShipsSunk;
    }

    /**
     * Handles the logic for shooting at a ship on the game board, validates the shot coordinates and
     * updates the board based on whether the shot is a miss, a hit, or an invalid shot (already shot).
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param shootingPlayer the player who is making the shot
     */
    public void shootShip(int x, int y, Player shootingPlayer)
    {
        if (!Validation.checkShootCoordinates(x, y))
        {
            System.out.print("\nShooting coordinates outer the board");
            shootingPlayer.setSecondTry(true);
        } else {
            switch (grid[y][x]) {
                // player missed
                case "~":
                    grid[y][x] = "_";
                    System.out.println("Oh no, you have missed!\n\n");
                    break;
                // player shot a ship
                case "■":
                    // traversing shipCells
                    outerLoop:
                    for (Ship ship : this.shipsOnBoard) {
                        for (shipCell cell : ship.getShipCells()) {
                            // there is a shipCell whose coordinates match up with the grid cell that's being shot
                            if (cell.getX() == x && cell.getY() == y) {
                                cell.setIsDamaged();
                                System.out.println("Success! A ship is damaged.\n\n");
                                break outerLoop;
                            }
                        }
                    }
                    break;
                // player chose area that's already been shot
                case "*":
                case "_":
                    shootingPlayer.setSecondTry(true);
                    System.out.println("You have already shot here earlier.\n" +
                                       "Please choose another area and try again.\n");
                    break;
            }
        }
    }

    /**
     * Attempts to place a {@code Ship} on the board. Validates the ship's coordinates and checks for overlapping ships.
     *
     * @param ship The ship that gets placed on the board
     * @return true if the ship is successfully placed, false if the placement is invalid
     */
    public boolean placeShip(Ship ship) {
        if (!Validation.checkShipCoordinates(ship, ROWS, COLS))
        {
            System.out.print("\nInvalid coordinates: ship outer the board");
            return false;
        }
        if (Validation.shipsOverlapping(ship, shipsOnBoard))
        {
            System.out.print("\nInvalid coordinates: ships overlap");
            return false;
        }
        shipsOnBoard.add(ship);
        return true;
    }

    /**
     * Prints the current state of the game board and the labelling to the console.
     * The {@code hidden}-parameter allows the program to replace the printed ships with water to hide them
     * from the player.
     *
     * @param hidden if true, the ships will be hidden, otherwise the ships will be visible
     */
    public void printBoard(boolean hidden)
    {
        System.out.print("  ");
        for (int i = 0; i < COLS; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();

        for (int i=0; i<ROWS; i++)
        {
            switch (i) {
                case 0 -> System.out.print("A  ");
                case 1 -> System.out.print("B  ");
                case 2 -> System.out.print("C  ");
                case 3 -> System.out.print("D  ");
                case 4 -> System.out.print("E  ");
                case 5 -> System.out.print("F  ");
                case 6 -> System.out.print("G  ");
                case 7 -> System.out.print("H  ");
                case 8 -> System.out.print("I  ");
                case 9 -> System.out.print("J  ");
                default -> System.out.print("?  ");
            }
            for (int j=0; j<COLS; j++)
            {
                // if we want to hide positions of ships
                if (hidden && Objects.equals(grid[i][j], "■")) System.out.print("~  ");
                else System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * Gets the number of ships still on the board.
     *
     * @return number of ships on the board
     */
    public int getShipsNum()
    {
        return shipsOnBoard.size();
    }
}
