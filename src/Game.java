import java.util.Scanner;

public class Game {
    private static int iteration =0; //when iteration % 2 == 0, it is player's 1 turn. Otherwise, player's 2
    public static void increment() {
        iteration++;
    }
    public static int getIteration()
    {
        return iteration;
    }

    public static void welcome()
    {
        System.out.println("""
                Welcome to the Battleship game!
                This is a game between 2 players.
                Firstly, each player need to enter their names and then locate 5 ships.
                """);
    }
    public static void printPlayerHeader(Player player)
    {
        if (player == null) System.out.printf("------- PLAYER %d -------\n", iteration%2 == 0 ? 1 : 2);
        else System.out.printf("------- PLAYER %d: %s -------\n", iteration%2 == 0 ? 1 : 2, player.getName());
    }
    public static void askForName(Player player) {
        printPlayerHeader(null);
        System.out.print("Enter your name, capitan!\n" +
                            "-> ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        player.setName(name);
        System.out.printf("Hello, %s!", player.getName());
    }
    public static void showBoard(Player player, boolean hidden)
    {
        System.out.printf("\n%s's current board:\n", player.getName());
        player.getBoard().updateShipsOnBoard();
        player.getBoard().printBoard(hidden);
    }
    public static void askForShip(Player player)
    {
        Scanner sc = new Scanner(System.in);
        if (player.getBoard().getShipsNum() == 0) System.out.print("\nTime for you to create ships!");
        System.out.printf("\n%d ships left!", 5-player.getBoard().getShipsNum());
        System.out.print("""
                \nTo create a ship enter a ship type, destroyer (d) or battleship (b),
                ship orientation, horizontal (h) or vertical (v), row (A-J) and column (0-9)\n
                """);

        System.out.print("Ship type: ");
        char type = sc.next().charAt(0);
        System.out.print("Ship orientation: ");
        char orientation = sc.next().charAt(0);
        System.out.print("Row: ");
        char row = Character.toUpperCase(sc.next().charAt(0));
        System.out.print("Column: ");
        int column = sc.nextInt();

        // i.e. by incorrect input a destroyer will simply be created
        Ship ship = (type == 'b')
                ? new Battleship(column, (int)row-65, orientation == 'v')
                : new Destroyer(column, (int)row-65, orientation == 'v');
        player.placeShip(ship);
    }
    public static void askToShoot(Player player)
    {
        System.out.print("\nMy capitan, send this bastard to the bottom!");
        System.out.print("\n(first character is the row, second - the column, without space)\n For example: a0\n");
        System.out.print("\nYour coordinates: ");
        Scanner sc = new Scanner(System.in);
        String input =sc.next();
        char row = Character.toUpperCase(input.charAt(0));
        int column = Character.getNumericValue(input.charAt(1));
        player.shoot(column, row-65);
    }
    public static void greetWinner(Player winner)
    {
        System.out.print("\n@@@@          @@@@@@@@@@@@@@@@         @@@@");
        System.out.printf("\nCongrats, %s! It was a brilliant battle.", winner.getName());
        System.out.print("\n@@@@          @@@@@@@@@@@@@@@@         @@@@");
    }
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
