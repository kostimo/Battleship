import java.util.ArrayList;

public class GameBoard {
    private final int ROWS =10, COLS =10;
    private final String[][] grid =new String[ROWS][COLS];
    private final ArrayList<Ship> shipsOnBoard =new ArrayList<>(5); //board has 5 ships on it

    public GameBoard()
    {
        generateDefaultBoard();
    }

    private void generateDefaultBoard()
    {
        for (int i=0; i<ROWS; i++)
        {
            for (int j=0; j<COLS; j++) { grid[i][j] ="~"; }
        }
    }
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
    public boolean areAllShipsSunk()
    {
        boolean allShipsSunk =true;
        for (Ship ship: shipsOnBoard)
        {
            if (!ship.isSunk()) allShipsSunk =false;
        }
        return allShipsSunk;
    }
    public boolean shootShip(Player player, int x, int y)
    {
        switch (grid[y][x]) {
            case "~":  return false;
            case "■":
                // traversing shipCells
                for (Ship ship : this.shipsOnBoard) {
                    for (shipCell cell : ship.getShipCells()) {
                        // there is a shipCell whose coordinates match up with the grid cell that's being shot
                        if (cell.getX() == x && cell.getY() == y) {
                            cell.setIsDamaged();
                            return true;
                        }
                    }
                }
            case "*":
                player.setSecondTry(true);
                return false;
        }
        // normally it shouldn't be executed;
        System.out.println("GameBoard.shootShip() error");
        return false;
    }
    // FUNCTION DOESNT CHECK SHIP OVERLAPPING YET
    public boolean placeShip(Ship ship) {
        // if ship is vertical
        if (ship.getVertical()) {
            if (ship.getPosition()[1] + ship.getSize() - 1 >= ROWS || ship.getPosition()[0] >= COLS) {
                return false;
            } else {
                shipsOnBoard.add(ship);
                return true;
            }
        }
        // if ship is horizontal
        else {
            if (ship.getPosition()[0] + ship.getSize() - 1 >= COLS || ship.getPosition()[1] >= ROWS) {
                return false;
            } else {
                shipsOnBoard.add(ship);
                return true;
            }
        }
    }
    public void printBoard()
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
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public int getShipsNum()
    {
        return shipsOnBoard.size();
    }
}
