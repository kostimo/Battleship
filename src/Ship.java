
public class Ship {
    private int size;
    private int direction;              // 0 for horizontal, 1 for vertical
    private int[] position =new int[2]; //array with length 2 for ships (x, y) coordinates
    private int counter =0;             //for tracking a position in shipCells array
    private shipCell[] shipCells =new shipCell[size];
    private boolean isSunk =false;

    public Ship(int x, int y, int direction)
    {
        this.position[0] =x;
        this.position[1] =y;
        this.direction   =direction;
        fillShipCellArray();
    }

    private void fillShipCellArray()
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
    }

    private void addCell(shipCell cell)
    {
        shipCells[counter++] =cell;
    }

    public boolean checkShipCells()
    {
        boolean isShipSunk =true;
        for(int i=0; i<this.size; i++)
        {
            if (shipCells[i].getIsDamaged() != true) // if at least one cell is not damaged, then the ship is not sunk yet
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

    public int getSize() {
        return size;
    }
    public int getDirection() {
        return direction;
    }
    public int[] getPosition() {
        return position;
    }
}
