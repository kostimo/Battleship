
public class Ship {
    private int size;
    private int direction;              // 0 for horizontal, 1 for vertical
    private int[] position =new int[2]; //array with length 2 for ships (x, y) coordinates
    private int counter =0;             //for tracking a position in shipCells array
    private shipCell[] shipCells;
    private boolean isSunk =false;

    public Ship(int size, int x, int y, int direction)
    {
        this.size        =size;
        this.shipCells   = new shipCell[size];
        this.position[0] =x;
        this.position[1] =y;
        this.direction   =direction;
        fillShipCellArray();
    }

    public void fillShipCellArray()
    {
        if (this.direction == 0)       // horizontal direction
        {
            for (int i = 0; i < this.size; i++) {
                shipCell cell = new shipCell(this.position[0] + i, this.position[1]);
                addCell(cell);
            }
        } else if (this.direction == 1) // vertical direction
        {
            for (int i = 0; i < this.size; i++) {
                shipCell cell = new shipCell(this.position[0], this.position[1]+i);
                addCell(cell);
            }
        }
        System.out.println("array filled");
    }

    private void addCell(shipCell cell)
    {
        shipCells[this.counter++] =cell;
    }

    public boolean checkShipCells()
    {
        boolean isShipSunk =true;
        for(int i=0; i<this.size; i++)
        {
            if (!shipCells[i].getIsDamaged()) // if at least one cell is not damaged, then the ship isn't sunk yet
            {
                isShipSunk =false;
            }
        }
        if (isShipSunk)
        {
            this.isSunk =true;
        }

        return isSunk;
    }

    public void printShipCells()
    {
        System.out.println("shipCells:");
        for (shipCell cell: shipCells) { cell.printCell(); }
    }
    public int getSize() { return size; }
    public int getDirection() { return direction; }
    public int[] getPosition() { return position; }
    public shipCell[] getShipCells() { return shipCells; }
}
