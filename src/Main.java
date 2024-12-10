public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Hans");
        Game.welcome();
        player1.getBoard().printBoard(player1);

        // CREATING SHIPS
        Battleship bs1 = new Battleship(0, 0, false);
        Battleship bs2 = new Battleship(9, 0, true);
        Battleship bs3 = new Battleship(4, 4, false);
        Destroyer d1   = new Destroyer(0, 2, true);
        Destroyer d2   = new Destroyer(8, 9, false);

        // PLACING SHIPS
        player1.placeShip(bs1);
        player1.placeShip(bs2);
        player1.placeShip(bs3);
        player1.placeShip(d1);
        player1.placeShip(d2);

        // UPDATING & PRINTING PLAYER'S BOARD
        player1.getBoard().updateShipsOnBoard();
        player1.getBoard().printBoard(player1);

        // PLAYER'S INPUT TO PLACE SHIPS
//        for (int i=0; i<5; i++)
//        {
//            Ship ship = player1.askForShip();
//            ship.printShipCells();
//            player1.placeShip(ship);
//        }
//        player1.getBoard().updateShipsOnBoard();
//        player1.getBoard().printBoard();

        // PLAYER'S SHOOTING
        player1.shoot(0, 0);
        player1.getBoard().updateShipsOnBoard();
        player1.getBoard().printBoard(player1);

        player1.shoot(0, 0);
        player1.getBoard().updateShipsOnBoard();
        player1.getBoard().printBoard(player1);

        player1.shoot(1, 0);
        player1.getBoard().updateShipsOnBoard();
        player1.getBoard().printBoard(player1);

        player1.shoot(2, 0);
        player1.getBoard().updateShipsOnBoard();
        player1.getBoard().printBoard(player1);

        player1.shoot(3, 0);
        player1.getBoard().updateShipsOnBoard();
        player1.getBoard().printBoard(player1);

    }
}