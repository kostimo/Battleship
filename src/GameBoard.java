public class GameBoard {
    private final int ROWS =10, COLS =10;
    private String[][] grid =new String[ROWS][COLS];

    private int counter =0;                   // for tracking a position in a ships array
    private Ship[] shipsOnBoard =new Ship[5]; //board has 5 ships on it

    public GameBoard()
    {
        generateDefaultBoard();
    }

    private void generateDefaultBoard()
    {
        for (int i=0; i<ROWS; i++)
        {
            for (int j=0; j<COLS; j++)
            {
                    grid[i][j] = "~";
            }
        }
    }

//    public void updateBoard()
//    {
//        updateShipsOnBoard();
//        fillBoardWithWater();
//    }

    //fills grid with water wherever the cells are not occupied with ships
//    private void fillBoardWithWater()
//    {
//        for (int i=0; i<ROWS; i++)
//        {
//            for (int j=0; j<COLS; j++)
//            {
//                if (grid[i][j].isEmpty())
//                {
//                    grid[i][j] = "~";
//                }
//            }
//        }
//    }

    public void updateShipsOnBoard()
    {
        for (Ship ship: shipsOnBoard)     // traverses all ships on the board
        {
            shipCell[] cells = ship.getShipCells();
//            System.out.println(cells[0].getX() + " " + cells[0].getY());
            for (shipCell cell: cells)           // traverses shipCells within each ship
            {
                int x =cell.getX();
                int y =cell.getY();
                if (cell.getIsDamaged())
                {
                    this.grid[y][x] ="X";
                } else {
                    this.grid[y][x] ="■";
                }
            }
        }
    }
    public void printBoard()
    {
        System.out.print("  ");
        for (int i = 1; i <= ROWS; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();

        for (int i=0; i<ROWS; i++)
        {
            switch (i) {
                case 0:
                    System.out.print("A  ");
                    break;
                case 1:
                    System.out.print("B  ");
                    break;
                case 2:
                    System.out.print("C  ");
                    break;
                case 3:
                    System.out.print("D  ");
                    break;
                case 4:
                    System.out.print("E  ");
                    break;
                case 5:
                    System.out.print("F  ");
                    break;
                case 6:
                    System.out.print("G  ");
                    break;
                case 7:
                    System.out.print("H  ");
                    break;
                case 8:
                    System.out.print("I  ");
                    break;
                case 9:
                    System.out.print("J  ");
                    break;
                default:
                    System.out.print("   ");
            }
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

    private void addShip(Ship ship)
    {
        shipsOnBoard[counter++] =ship;
    }

    public boolean isHit() {
        return false;
    }
}
