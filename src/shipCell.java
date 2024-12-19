/**
 * Represents a single part of a ship.
 * Each cell has specific coordinates and a status which tells us whether the ship cell is damaged or not.
 * This allows us to check if the ship has sunk if all of its cells are damaged.
 */
public class shipCell {
    private final int x;
    private final int y;
    private boolean isDamaged =false;

    /**
     * Constructs a ship cell at the stated coordinates.
     * Initially, the cell is not damaged.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public shipCell(int x, int y)
    {
        this.x =x;
        this.y =y;
    }

    /**
     * Prints out all the values of a ship cell.
     */
    public void printCell()
    {
        System.out.println("shipCell: " + x + " " + y + " " + isDamaged);
    }

    /**
     * Gets the status of a ship cell.
     *
     * @return true when damaged, false when not
     */
    public boolean getIsDamaged()
    {
        return isDamaged;
    }

    /**
     * Sets the ship cell state to 'damaged'.
     */
    public void setIsDamaged()
    {
        this.isDamaged =true;
    }

    /**
     * Gets the x-coordinate of the ship cell
     * @return x-coordinate
     */
    public int getX()
    {
        return this.x;
    }

    /**
     *Gets the y-coordinate of the ship cell
     *
     * @return y-coordinate
     */
    public int getY() {
        return this.y;
    }
}
