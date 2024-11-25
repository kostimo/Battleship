public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        GameBoard board1 = new GameBoard();
        GameBoard board2 = new GameBoard();

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