package TicTacToe;

import java.util.Random;

public class ComputerPlayer extends Player
{
public ComputerPlayer(String symbol) 
{
	super("Computer", symbol);
}

public void makeMove(Grid board)
{
	Random random = new Random ();
    boolean validMove = false;
    System.out.println("Computer is making a move...");
    
    // keep generating random moves until a valid one is found
    while(!validMove) {
    char row =(char) ('A' + random.nextInt(3));  // Random row (A to C)
    int column = random.nextInt(3)+1;    //Random column (1 to 3)
    if (board.isValidMove(row, column)){   //check if move is valid
    	board.placeSymbol(row, column, getSymbol());//place symbol
    	validMove = true;
    	System.out.println("Computer placed " + getSymbol() + " at " + row + column);
    }
    }

}
}