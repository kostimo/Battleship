
public class Ship {
    private int size;
    private int direction;              // 0 for horizontal, 1 for vertical
    private int[] position =new int[2]; //array with length 2 for ships (x, y) coordinates
    private boolean isSunk;

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
