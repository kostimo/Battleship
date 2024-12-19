import java.util.ArrayList;

/**
 * This abstract class represents a ship.
 * A ship is made of several cells and can be placed horizontally or vertically by the players.
 */
public abstract class Ship {
    private final int size;
    private final boolean isVertical;
    private final int[] position =new int[2]; //array with length 2 for ships (x, y) coordinates
    private final ArrayList<shipCell> shipCells;

    /**
     * This is the constructor for a ship.
     *
     * @param size: size of the ship (number of cells)
     * @param x: x-coordinate (0 - 9)
     * @param y: y-coordinate (0 - 9)
     * @param isVertical: direction the ship is facing; if the ship is vertical, the value is true, otherwise false
     */
    public Ship(int size, int x, int y, boolean isVertical)
    {
        this.size        =size;
        this.shipCells   =new ArrayList<>(size);
        this.position[0] =x;
        this.position[1] =y;
        this.isVertical  =isVertical;
        fillShipCellArray();
    }

    /**
     * This method creates {@link shipCell}-objects, where a ship is placed.
     * The ship cells are placed horizontally or vertically on the grid depending on the direction of the ship.
     */
    private void fillShipCellArray()
    {
        if (this.isVertical)     // vertical direction
        {
            for (int i = 0; i < this.size; i++) {
                shipCell cell = new shipCell(this.position[0], this.position[1]+i);
                shipCells.add(cell);
            }
        } else                   // horizontal direction
        {
            for (int i = 0; i < this.size; i++) {
                shipCell cell = new shipCell(this.position[0] + i, this.position[1]);
                shipCells.add(cell);
            }
        }
    }

    /**
     * This method checks, if the ship is sunk.
     * A ship is sunk when every ship cell is damaged.
     *
     * @return true, if the ship is sunk, otherwise false
     */
    public boolean isSunk()
    {
        boolean isSunk = true;
        for(shipCell cell: this.shipCells)
        {
            if (!cell.getIsDamaged()) // if at least one cell is not damaged, then the ship isn't sunk yet
            {
                isSunk = false;
                break;
            }
        }
        return isSunk;
    }

    /**
     * prints ship cells
     */
    public void printShipCells()
    {
        System.out.println("shipCells:");
        for (shipCell cell: shipCells) { cell.printCell(); }
    }

    /**
     * getter for the ship size
     *
     * @return size of the ship (number of cells e.g. 2)
     */
    public int getSize() { return size; }

    /**
     * getter for the direction
     *
     * @return true for vertical or false for horizontal
     */
    public boolean getVertical() { return isVertical; }

    /**
     * getter for the position
     *
     * @return x and y coordinates
     */
    public int[] getPosition() { return position; }

    /**
     * getter for a list of the ship cells
     *
     * @return a list containing {@link shipCell}-objects
     */
    public ArrayList<shipCell> getShipCells() { return shipCells; }
}
