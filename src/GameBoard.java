public class GameBoard {
    private final int ROWS =10;
    private final int COLS =10;
    private String[][] grid =new String[ROWS][COLS];
    private int shipCounter =0;        // for a tracking position in a ships array
    private Ship[] ships =new Ship[5]; //board has 5 ships on it

    public GameBoard()
    {
        //generates default grid filled with water
        for (int i=0; i<ROWS; i++)
        {
            for (int j=0; j<COLS; j++)
            {
                grid[i][j] = "~";
            }
        }
    }

    public void printBoard()
    {
        for (int i=0; i<ROWS; i++)
        {
            for (int j=0; j<COLS; j++)
            {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }

    // FUNCTION DOESNT CHECK SHIP OVERLAPPING YET
    public boolean placeShip(Ship ship) {
        switch (ship.getDirection()) {
            case 0: // if ship is horizontally
                if (ship.getPosition()[0] + ship.getSize() - 1 >= COLS || ship.getPosition()[1] >= ROWS) {
                    return false;
                } else {
                    this.addShip(ship);
                    return true;
                }
            case 1: // if ship is vertically
                if (ship.getPosition()[1] + ship.getSize() - 1 >= ROWS || ship.getPosition()[0] >= COLS) {
                    return false;
                } else {
                    this.addShip(ship);
                    return true;
                }
            default:
                return false;
        }
    }

    public void addShip(Ship ship)
    {
        ships[shipCounter++] =ship;
    }

    public boolean isHit() {
        return false;
    }
}
