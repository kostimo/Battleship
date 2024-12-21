import java.util.Scanner;

/**
 * This class represents the main logic for the Battleship game.
 * It handles game flow, player interactions, ship placements, shooting actions, and determining the winner.
 * It also contains helper methods to manage the game state, such as keeping track of turns and welcoming players.
 */
public class Game {
    private static int iteration =0; //when iteration % 2 == 0, it is player 1's turn. Otherwise, player 2's

    /**
     * Increases the {@code iteration} by one to switch the players turns.
     */
    public static void increment() {
        iteration++;
    }

    /**
     * Gets the current iteration.
     *
     * @return current iteration
     */
    public static int getIteration()
    {
        return iteration;
    }

    /**
     * Prints a welcome message.
     */
    public static void welcome()
    {
        System.out.println("""
                Welcome to the Battleship game!
                This is a game between 2 players.
                First, each player needs to enter their name and then locate 5 ships.
                """);
    }

    /**
     * Prints a header showing which player's turn it is.
     * If a player name is provided, it'll also be displayed.
     *
     * @param player current player
     */
    public static void printPlayerHeader(Player player)
    {
        if (player == null) System.out.printf("------- PLAYER %d -------\n", iteration%2 == 0 ? 1 : 2);
        else System.out.printf("------- PLAYER %d: %s -------\n", iteration%2 == 0 ? 1 : 2, player.getName());
    }

    /**
     * Asks for a name of the current player and greets them.
     *
     * @param player current player
     */
    public static void askForName(Player player) {
        printPlayerHeader(null);
        System.out.print("Enter your name, capitan!\n" +
                            "-> ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        player.setName(name);
        System.out.printf("Aye Aye Captain %s!", player.getName());
    }

    /**
     * Shows the board of the stated {@code player}.
     * Depending on the value of the {@code hidden}-parameter, the ships will be visible or not.
     *
     * @param player the player whose board is to be displayed
     * @param hidden if true, the ships will be hidden, otherwise the ships will be visible
     */
    public static void showBoard(Player player, boolean hidden)
    {
        System.out.printf("\n%s's current board:\n", player.getName());
        player.getBoard().updateShipsOnBoard();
        player.getBoard().printBoard(hidden);
    }

    /**
     * Asks the player where the ship should be placed.
     * The player selects the ship type, orientation, and position or if the ship should be placed randomly.
     *
     * @param player the player whose turn it is
     * @return true if the ship is placed successfully, false otherwise
     */
    public static boolean askForShip(Player player)
    {
        Scanner sc = new Scanner(System.in);
        if (player.getBoard().getShipsNum() == 0) System.out.print("\nTime for you to create ships!");
        System.out.printf("\n%d ships left!", 5-player.getBoard().getShipsNum());
        System.out.print("""
                \nTo create a ship enter: \n[1] Ship type: Destroyer (d), Battleship (b) or
                type (r) to have a random created and placed ship
                [2] Ship orientation: Horizontal (h) or Vertical (v) \n[3] Row: (A-J) \n[4] Column: (0-9)\n
                """);

        Ship ship;

        System.out.print("Ship type: ");
        char type = sc.next().charAt(0);

        if (Character.toLowerCase(type) == 'r')
        {
            ship =new randomShip();
        } else
        {
            System.out.print("Ship orientation: ");
            char orientation = sc.next().charAt(0);
            System.out.print("Row: ");
            char row = Character.toUpperCase(sc.next().charAt(0));
            System.out.print("Column: ");
            int column = Character.getNumericValue(sc.next().charAt(0));

            // if 'b' is not recognized, a destroyer is to be created
            // if 'v' is not recognized, a ship will be horizontal
            ship = (type == 'b')
                ? new Battleship(column, (int)row-65, orientation == 'v')
                : new Destroyer(column, (int)row-65, orientation == 'v');
        }

        if (player.placeShip(ship)) return true;
        else
        {
            System.out.print("\nT r y   a g a i n\n");
            return false;
        }
    }

    /**
     * Asks the current player to enter coordinates for a shot and processes the shot on the opponent's board.
     *
     * @param currentPlayer the player making the shot
     * @param opponent the player being targeted
     */
    public static void askToShoot(Player currentPlayer, Player opponent)
    {
        System.out.print("\nMy capitan, send this pirate to the bottom!");
        System.out.print("\n(first character is the row, second - the column, without space)\n For example: a0\n");
        System.out.print("\nEnter your coordinates: ");
        Scanner sc = new Scanner(System.in);
        String input =sc.next();
        char row = Character.toUpperCase(input.charAt(0));
        int column = Character.getNumericValue(input.charAt(1));
        opponent.shoot(column, row-65, currentPlayer); // opponent's board gets shot by currentPlayer
    }

    /**
     * Congratulates the winner of the battle.
     *
     * @param winner the player who won the game
     */
    public static void greetWinner(Player winner)
    {
        System.out.print("\n@@@@@@             @@@@@@@@@@@@@@@@@@             @@@@@@");
        System.out.printf("\nCongratulations, %s, you won! It was a brilliant battle.", winner.getName());
        System.out.print("\n@@@@@@             @@@@@@@@@@@@@@@@@@             @@@@@@");
    }

    /**
     * Checks if there is a winner by looking into if all the opponents ships have sunk.
     *
     * @param players array of all players in the game
     * @return index of winner or -1 if there isn't a player yet
     */
    public static int checkWinner(Player[] players)
    {
        for (int i=0; i< players.length; i++)
        {
            if (players[i].getBoard().areAllShipsSunk()) return (i+1)%2; // returns index of winner
        }
        return -1; // when there is no winner yet
    }

    public static void placeShip(Player player)
    {

    }
}
