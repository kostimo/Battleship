/**
 * Main class to start and run the Battleship game. Manages player setup, board display,
 * shooting actions, and checks for the winner in each iteration.
 */
public class Main {
    /**
     * The entry point of the Battleship game. Manages game flow, including player registration,
     * ship placement, shooting, and winner determination.
     *
     * @param args Command-line arguments (not used in this game).
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
                System.out.print("\nGreat, my captain! All ships are successfully placed!\n\n");

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

        System.out.print("\n\n---------------GAME OVER---------------\n");
    }
}