public class Main {
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
                    Game.askForShip(currentPlayer);
                }
                Game.showBoard(currentPlayer, false);
                System.out.print("\nGreat, my capitan! All ships are successfully placed!\n\n");

            // battleship begins
            } else
            {
                // one-time message in the beginning
                if (iteration == 2) System.out.print("\nMay BATTLESHIP begin!\n");

                Game.printPlayerHeader(currentPlayer);
                Game.showBoard(currentPlayer, false);
                System.out.print("""
                        \nOpponent's board
                                 |
                                 V""");
                Game.showBoard(nextPlayer, true);

                // opponent gets shot
                do {
                    Game.askToShoot(nextPlayer);
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