import java.util.ArrayList;

/**
 * Contains methods that check if the entered coordinates for ship placement and shooting are within range and if the
 * placed ships are overlapping.
 * <p>Since all the methods are static, they can be used without creating an object of this class.</p>
 */
public class Validation {
//    private boolean shootCoordinatesOuterBoard;
//    private boolean shipCoordinatesOuterBoard;
//    private boolean shipOverlapping;

    /**
     * Checks if the shooting coordinates are within range.
     * @param x x-coordinate
     * @param y y-coordinate
     * @return true if {@code x} is between 0 and 9 and {@code y} is between 'A' and 'J', false otherwise
     */
    public static boolean checkShootCoordinates(int x, int y)
    {
        if (x >= 0 && x <= 9) return (y >= 'A'-65 && y <= 'J'-65);
        return false;
    }

    /**
     * Checks the validity of the ship placement.
     *
     * @param ship The ship that gets checked
     * @param rows number of rows on the board
     * @param cols number of columns on the board
     * @return true if the coordinates are valid, false otherwise
     */
    public static boolean checkShipCoordinates(Ship ship, int rows, int cols)
    {
        // if ship is vertical
        if (ship.getVertical()) {
            return (ship.getPosition()[1] + ship.getSize() - 1 < rows && ship.getPosition()[0] < cols &&
                    ship.getPosition()[1] >= 0                        && ship.getPosition()[0] >= 0);
        }
        // if ship is horizontal
        else return (ship.getPosition()[0] + ship.getSize() - 1 < cols && ship.getPosition()[1] < rows &&
                     ship.getPosition()[0] >=0                         && ship.getPosition()[1] >= 0);
    }

    /**
     * Checks if the new ship is overlapping with any ship on the board.
     *
     * @param shipFromInput the ship to check
     * @param boardShips list of ships already placed on the board
     * @return true if the entered ship is overlapping with another ship, otherwise false
     */
    public static boolean shipsOverlapping(Ship shipFromInput, ArrayList<Ship> boardShips)
    {
//      shipOverlapping =false;
        for (Ship ship: boardShips)
        {
            if (shipAndShipOverlapping(shipFromInput, ship)) return true;
        }
        return false;
    }

    /**
     * Checks if two ships are overlapping.
     *
     * @param shipFromInput entered ship to check
     * @param shipFromBoard already placed ship
     * @return true if the ships overlap, false otherwise
     */
    private static boolean shipAndShipOverlapping(Ship shipFromInput, Ship shipFromBoard)
    {
        for (shipCell cellInputShip: shipFromInput.getShipCells())
        {
            for (shipCell cellBoardShip: shipFromBoard.getShipCells())
            {
                if (cellInputShip.equals(cellBoardShip)) return true;
            }
        }
        return false;
    }
}
