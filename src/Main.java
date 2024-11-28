public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        GameBoard board1 = new GameBoard();
        Game.greeting();
        board1.printBoard();
        
        Battleship bs1 = new Battleship(0, 0, 0);
//        bs1.fillShipCellArray();
        bs1.printShipCells();

        System.out.println();

        Battleship bs2 = new Battleship(9, 0, 1);
//        bs2.fillShipCellArray();
        bs2.printShipCells();

        System.out.println();

        Battleship bs3 = new Battleship(4, 4, 0);
//        bs3.fillShipCellArray();
        bs3.printShipCells();

        System.out.println();

        Destroyer d1   = new Destroyer(0, 2, 1);
//        d1.fillShipCellArray();
        d1.printShipCells();

        System.out.println();

        Destroyer d2   = new Destroyer(8, 9, 0);
//        d2.fillShipCellArray();
        d2.printShipCells();

        System.out.println(board1.placeShip(bs1));
        System.out.println(board1.placeShip(bs2));
        System.out.println(board1.placeShip(bs3));
        System.out.println(board1.placeShip(d1));
        System.out.println(board1.placeShip(d2));

        board1.updateShipsOnBoard();
        board1.printBoard();

        /*
        * Welcome to the Battlship game! This is a game between 2 players.
        * Firstly, each player need to locate their 5 ships.
        *
        * Player 1. Please give me a type of the ship and its coordinates in form "d 3 4 0" where d - ship type, 3 and 4 - x and y coordinates, 0 - horizontal direction (1 - vertical)
                    * if location ok -> "Succeded! n ships more"
                    * otherwise      -> "Please, try again"
        *
        * player1.placeShip("d", 3, 4, 0)
        * player1.placeShip("d", 0, 9, 1)
        * player1.placeShip("b", 7, 6, 1)
        * player1.placeShip("b", 8, 4, 0)
        * player1.placeShip("d", 9, 0, 0)
        *
        * Generally we need to placeShip (to add it to the boards list of ships)
        *
        * now its players 2 turn
        *
        * */
    }
}