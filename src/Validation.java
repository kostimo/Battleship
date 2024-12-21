import java.util.ArrayList;

public class Validation {
//    private boolean shootCoordinatesOuterBoard;
//    private boolean shipCoordinatesOuterBoard;
//    private boolean shipOverlapping;

    public static boolean checkShootCoordinates(int x, int y)
    {
        if (x >= 0 && x <= 9) return (y >= 'A' && y <= 'J');
        return false;
    }
    //returns true if coordinates valid
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
    public static boolean shipsOverlapping(Ship shipFromInput, ArrayList<Ship> boardShips)
    {
//      shipOverlapping =false;
        for (Ship ship: boardShips)
        {
            if (shipAndShipOverlapping(shipFromInput, ship)) return true;
        }
        return false;
    }
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
