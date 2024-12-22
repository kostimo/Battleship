/**
 * This interface contains possible actions for the player.
 */
public interface PlayerAction {
    /**
     * Places a ship.
     *
     * @param ship the ship to be placed
     * @return true if the ship was successfully placed, false otherwise
     */
    boolean placeShip(Ship ship);

    /**
     * Shoots at a specific position on the opponent's board.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param shootingPlayer the player who is shooting
     */
    void shoot(int x, int y, Player shootingPlayer);
}
