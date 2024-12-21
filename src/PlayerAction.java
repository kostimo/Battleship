/**
 * This interface contains possible actions for the player.
 */
public interface PlayerAction {
    /**
     * Places a ship
     * @param ship {@link Ship}-object
     */
    boolean placeShip(Ship ship);

    /**
     * Shoots at a specific position.
     *
     * @param x x-coordinate of the shot
     * @param y y-coordinate of the shot
     */
    void shoot(int x, int y, Player shootingPlayer);
}
