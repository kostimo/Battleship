import java.util.ArrayList;

public class Ship {
    private final int size;
    private final boolean isVertical;
    private final int[] position =new int[2]; //array with length 2 for ships (x, y) coordinates
    private final ArrayList<shipCell> shipCells;

    public Ship(int size, int x, int y, boolean isVertical)
    {
        this.size        =size;
        this.shipCells   = new ArrayList<>(size);
        this.position[0] =x;
        this.position[1] =y;
        this.isVertical =isVertical;
        fillShipCellArray();
    }

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

    public void printShipCells()
    {
        System.out.println("shipCells:");
        for (shipCell cell: shipCells) { cell.printCell(); }
    }
    public int getSize() { return size; }
    public boolean getVertical() { return isVertical; }
    public int[] getPosition() { return position; }
    public ArrayList<shipCell> getShipCells() { return shipCells; }
}
