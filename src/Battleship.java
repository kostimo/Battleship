/**
 * Represents a specialised kind of ship with a fixed size of 4.
 * It extends the {@link Ship} class and inherits its properties and behaviors.
 */
public class Battleship extends Ship{
    /**
     * Constructs a battleship with a specified position and direction.
     * The size of a battleship is 4.
     * @param x x-coordinate
     * @param y y-coordinate
     * @param isVertical true if direction is vertical, otherwise false
     */
    public Battleship(int x, int y, boolean isVertical) {
        super(4, x, y, isVertical);
    }
}
