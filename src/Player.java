import java.io.InputStream;
import java.util.Scanner;

/**
 * Represents a player in the Battleship game.
 * The player can place ships and shoot at ships on the game board.
 */
public class Player implements PlayerAction {
    private String name;
    private boolean secondTry;   // in case player shoots a cell that has already been damaged
    private final GameBoard board =new GameBoard();

    /**
     * Places a ship on the player's game board.
     *
     * @param ship {@link Ship}-object
     */
    @Override
    public void placeShip(Ship ship) {
        boolean success = this.board.placeShip(ship);
        if (success) System.out.print("Success! The ship is placed.");
        else System.out.print("Error! The ship couldn't be placed.");
    }

    /**
     * Shoots at a specific position on the game board.
     * It also checks if the shot was successful, if the player has already shot there, or if it missed.
     *
     * @param x x-coordinate of the shot
     * @param y y-coordinate of the shot
     */
    @Override
    public void shoot(int x, int y) {
        this.secondTry =false;
        boolean success = this.board.shootShip(this, x, y);

        if (success)             System.out.println("Success! A ship is damaged.");
        else if (this.secondTry) System.out.println("You have already shot here earlier.\n" +
                "Please choose another area and try again.");
        else                     System.out.println("Oh no, you have missed!");
    }

    /**
     * Gets the game board
     *
     * @return current board as a {@link GameBoard}-object
     */
    public GameBoard getBoard() {
        return board;
    }

    /**
     * Sets the value of {@code secondTry} to indicate if the player is retrying a shot.
     *
     * @param secondTry true if the player gets a second shot, otherwise false
     */
    public void setSecondTry(boolean secondTry) {
        this.secondTry = secondTry;
    }

    /**
     * Gets the player's name
     *
     * @return name of the player as a {@code String}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the player as a {@code String}
     *
     * @param name the player's name
     */
    public void setName(String name) {
        this.name = name;
    }
}