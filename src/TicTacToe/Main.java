package TicTacToe;

import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to Tic-Tac-Toe!");

        // Choose game mode: Human vs Human or Human vs Computer
        System.out.println("Choose game mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create players based on game mode
        Player player1, player2;

        // Get Player 1 details
        System.out.print("Enter name for Player 1: ");
        String name1 = scanner.nextLine();

        // Player 1 chooses their symbol
        String symbol1;
        while (true) {
            System.out.print(name1 + ", choose your symbol (X or O): ");
            symbol1 = scanner.nextLine().toUpperCase();
            if (symbol1.equals(Symbol.CROSS) || symbol1.equals(Symbol.CIRCLE)) {
                break;
            }
            System.out.println("Invalid symbol! Please choose either X or O.");
        }

        player1 = new HumanPlayer(name1, symbol1);

        // Assign Player 2
        if (choice == 1) {
            // Human vs Human
            System.out.print("Enter name for Player 2: ");
            String name2 = scanner.nextLine();

            // Player 2 chooses their symbol (must be different from Player 1)
            String symbol2;
            while (true) {
                System.out.print(name2 + ", choose your symbol (X or O): ");
                symbol2 = scanner.nextLine().toUpperCase();
                if ((symbol2.equals(Symbol.CROSS) || symbol2.equals(Symbol.CIRCLE)) && !symbol2.equals(symbol1)) {
                    break;
                }
                System.out.println("This symbol has already been taken. Please pick another symbol.");
            }

            player2 = new HumanPlayer(name2, symbol2);
        } else {
            // Human vs Computer
            String symbol2 = symbol1.equals(Symbol.CROSS) ? Symbol.CIRCLE : Symbol.CROSS;
            player2 = new ComputerPlayer(symbol2);
            System.out.println("Player 2 is the Computer and will play as " + symbol2);
        }

        // Initialize board and game logic
        Grid board = new Grid();
        GameOver gameOver = new GameOver();
        Player currentPlayer = player1;
        boolean gameEnded = false;

        // Main game loop
        while (!gameEnded) {
            board.displayGrid(); // Display current board state
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + "):");

            // Let the current player make a move
            currentPlayer.makeMove(board);

            // Check if the current player wins
            if (gameOver.checkStraightLines(board, currentPlayer.getSymbol())) {
                board.displayGrid();
                gameOver.playerWins(currentPlayer.getName());
                gameEnded = true;
                break;
            }

            // Check if the board is full (draw condition)
            if (gameOver.checkSquareIfFull(board)) {
                board.displayGrid();
                System.out.println("It's a draw!");
                gameEnded = true;
                break;
            }

            // Switch to the other player
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        // End message
        System.out.println("Game Over. Thanks for playing!");
        scanner.close();
    }
}

