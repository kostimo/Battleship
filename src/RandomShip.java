import java.util.Random;

public class RandomShip extends Ship
{
    private static final Random random = new Random();
    public RandomShip() {
        super(generateRandomSize(), generateRandomX(), generateRandomY(), generateRandomOrientation());
    }
    private static int generateRandomSize() {
        return random.nextBoolean() ? 2 : 4;
    }

    private static int generateRandomX() {
        return random.nextInt(10);
    }

    private static int generateRandomY() {
        return random.nextInt(10);
    }

    private static boolean generateRandomOrientation() {
        return random.nextBoolean();
    }
}
