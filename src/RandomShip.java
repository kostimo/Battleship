import java.util.Random;

/**
 * Represents a computer generated ship.<br>
 * It extends the {@link Ship} class and generates a ship with a random size, position, and orientation.
 */
public class RandomShip extends Ship
{
    private static final Random random = new Random();

    /**
     * Constructs a random ship with random size, coordinates, and orientation.
     */
    public RandomShip() {
        super(generateRandomSize(), generateRandomX(), generateRandomY(), generateRandomOrientation());
    }

    /**
     * Generates a random size.
     *
     * @return 2 or 4
     */
    private static int generateRandomSize() {
        return random.nextBoolean() ? 2 : 4;
    }

    /**
     * Generates a random x-coordinate.
     *
     * @return random number between 0 and 9
     */
    private static int generateRandomX() {
        return random.nextInt(10);
    }

    /**
     * Generates a random y-coordinate.
     *
     * @return random number between 0 and 9
     */
    private static int generateRandomY() {
        return random.nextInt(10);
    }

    /**
     * Generates a random orientation.
     *
     * @return true or false
     */
    private static boolean generateRandomOrientation() {
        return random.nextBoolean();
    }
}
