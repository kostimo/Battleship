/**
 * Represents a specialised kind of ship with a fixed size of 2.
 * It extends the {@link Ship} class and inherits its properties and behaviors.
 */
public class Destroyer extends Ship {
    /**
     * Constructs a destroyer with a specified position and direction.
     * The size of a destroyer is 2.
     * @param x x-coordinate
     * @param y y-coordinate
     * @param isVertical true if direction is vertical, otherwise false
     */
    public Destroyer(int x, int y, boolean isVertical) {
        super(2, x, y, isVertical);
    }
}
