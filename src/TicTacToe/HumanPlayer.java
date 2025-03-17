package TicTacToe;

import java.util.Scanner;

public class HumanPlayer extends Player 
{

public HumanPlayer(String name, String symbol) 
{
	super(name, symbol);
}

public void makeMove(Grid board)
{
	Scanner scanner = new Scanner (System.in);
    boolean validMove = false;
while (!validMove)
{
	System.out.print(getName()+", enter your move (e.g.: A1, B2): ");
	String input = scanner.nextLine().toUpperCase();
if (input.length()==2)
{
	char row = input.charAt(0);
	int column = Character.getNumericValue(input.charAt(1));
	if(board.isValidMove(row, column))
	{
		board.placeSymbol(row, column, getSymbol());
		validMove = true;
	}
	else {
		System.out.println("Invalid input. Please Try again");
	}
}
else {
	System.out.println("Invalid input. Use format like A1, A2.");
}
}
} 	
}

