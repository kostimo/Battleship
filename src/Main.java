/**
 * The Main class is the entry point for the Battleship game. It contains the main method
 * which orchestrates the game flow between two players. The game progresses by alternating turns,
 * where players register their names, place ships on their boards, and then take turns shooting at
 * each other's ships until one player wins.
 */
public class Main {
    /**
     * The main method that initializes the game and handles the flow of the Battleship game between two players.
     * It sets up the players, handles their registration, ship placement, and alternates turns for the gameplay.
     * The game continues until one player sinks all the opponent's ships.
     *
     * @param args the command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Game.welcome();
        while (true) {

            int iteration = Game.getIteration();
            Player currentPlayer = (iteration % 2 == 0) ? players[0] : players[1];
            Player nextPlayer =((iteration+1) % 2 == 0) ? players[0] : players[1];

            // player registration, board setup
            if (iteration < 2) {
                Game.askForName(currentPlayer);
                for (int i = 0; i < 5; i++) {
                    Game.showBoard(currentPlayer, false);
                    while (!Game.askForShip(currentPlayer)); // infinite loop til valid ship creation
                }
                Game.showBoard(currentPlayer, false);
                System.out.print("\nGreat, my capitan! All ships are successfully placed!\n\n");

                // battleship begins
            } else
            {
                // one-time message in the beginning
                if (iteration == 2) System.out.print("\n        May BATTLESHIP begin!\n");

                // printing players' boards
                Game.printPlayerHeader(currentPlayer);
                Game.showBoard(currentPlayer, false);
                System.out.print("""
                        \nOpponent's board
                                 |
                                 V""");
                Game.showBoard(nextPlayer, true);

                do {
                    Game.askToShoot(currentPlayer, nextPlayer); // nextPlayer gets shot
                }
                while (currentPlayer.isSecondTry());

                // winner checking after the turn
                int winner =Game.checkWinner(players);
                if (winner != -1)
                {
                    Game.greetWinner(players[winner]);
                    break;
                }
            }

            Game.increment();
        }

        System.out.print("\n---------------GAME OVER---------------\n");
    }
}