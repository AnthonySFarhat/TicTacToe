package TicTacToe;

import java.util.Scanner;

public class Main {
	public static void main(String[] atgs) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Tic-Tac-Toe.");
		System.out.println("Choose game mode:");
		System.out.println("1.Human VS Human");
		System.out.println("2.Human VS Computer");
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		Player player1, player2;
		System.out.print("Enter your name player 1: ");
		String name1 = scanner.nextLine();
		String symbol1;
		while (true) {
			System.out.print(name1 + ", choose your symbol [X or O]:");
			symbol1 = scanner.nextLine().toUpperCase();
			if(symbol1.equals(Symbol.CROSS)||symbol1.equals(Symbol.CIRCLE)){
				break;
			}
			System.out.println("Invalid symbol. Please choose [X or O].");
		}
		player1 = new HumanPlayer(name1, symbol1);
		
		if (choice == 1) {
			System.out.print("Enter your player 2: ");
			String name2 = scanner.nextLine();
			String symbol2 = symbol1.equals(Symbol.CROSS) ? Symbol.CIRCLE : Symbol.CROSS;
			player2 = new HumanPlayer(name2, symbol2);
			System.out.println(name2 + " will play as " + symbol2);
		}
		else {
			String symbol2 = symbol1.equals(Symbol.CROSS) ? Symbol.CIRCLE : Symbol.CROSS;
			player2 = new ComputerPlayer(symbol2);
			System.out.println("Player 2 is the computer and will play as " + symbol2);
		}
		
		Grid board = new Grid();
		GameOver gameOver = new GameOver();
		Player currentPlayer = player1;
		boolean endGame = false;
		
		while (!endGame) {//Game start
			board.displayGrid();
			System.out.println(currentPlayer.getName() + " it's your turn (" + currentPlayer.getSymbol() + "):");
			currentPlayer.makeMove(board);
			
			if(gameOver.checkStraightLines(board, currentPlayer.getSymbol())){
			board.displayGrid();
			gameOver.playerWins(currentPlayer.getName());
			endGame = true;
			break;
			}
		    if(gameOver.checkSquareIfFull(board)) {
		    board.displayGrid();
			System.out.println("It's a Draw.");
			endGame = true;
			break;
		    }
			currentPlayer = (currentPlayer == player1) ? player2 : player1;//Switches players turns
		}	
				
		System.out.println("Game Over. Thank you for playing.");
		scanner.close();
	}
}
