package TicTacToe;

public class GameOver 
{
public boolean checkStraightLines(Grid board, String symbol) {
return checkRows(board, symbol) || checkColumns(board, symbol) || checkDiagonals(board, symbol);	
} 
public void playerWins(String name) {
	System.out.println("Congratulation, " + name + "! You win!");
}
public boolean checkSquareIfFull(Grid board) {
return board.isFull();	
}
private boolean checkRows(Grid board, String symbol) {
	for(char row = 'A'; row <= 'C'; row++) {
		if(board.getSquare(row, 1).getSymbol().equals(symbol) &&
           board.getSquare(row, 2).getSymbol().equals(symbol) &&
           board.getSquare(row, 3).getSymbol().equals(symbol)) {
			return true;
		}
	} 
	return false;
}
private boolean checkColumns(Grid board, String symbol) {
	for(int col = 1; col <= 3; col++) {
		if(board.getSquare('A', col).getSymbol().equals(symbol) &&
           board.getSquare('B', col).getSymbol().equals(symbol) &&
           board.getSquare('C', col).getSymbol().equals(symbol)) {
			return true;
		}
	} 
	return false;
}
private boolean checkDiagonals(Grid board, String symbol) {
	boolean Diagonal1 = board.getSquare('A',1).getSymbol().equals(symbol) &&
	                    board.getSquare('B',2).getSymbol().equals(symbol) &&
	                    board.getSquare('C',3).getSymbol().equals(symbol);
	boolean Diagonal2 = board.getSquare('C',1).getSymbol().equals(symbol) &&
                        board.getSquare('B',2).getSymbol().equals(symbol) &&
                        board.getSquare('A',3).getSymbol().equals(symbol);
return Diagonal1 || Diagonal2;
 }
}
