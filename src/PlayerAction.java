public interface PlayerAction {
    void placeShip(int x, int y, int direction);
    boolean shoot(int x, int y);
}
