package TicTacToe;

public class Grid {
	private Square[][] squares;
	
	public Grid() { //initialize a 3x3 grid with labeled rows (A to C) and columns (1 to 3)
		squares = new Square[3][3];
		char rowV = 'A';
		for (int col = 0; col < 3; col++)
		{for (int row = 0; row < 3; row++) {
			squares[col][row] = new Square((char) (rowV + row), col + 1);
		}
			
		}
	}
	public void displayGrid() { // displays the grid with row and column labels
		System.out.println("    1   2   3");
		System.out.println("  -------------");
		for(int row = 0; row < 3; row++) {
			System.out.print((char)('A' + row) + " | ");
		for(int col = 0; col < 3; col++) {
			System.out.print(squares[col][row] + " | ");
			
		}
		System.out.println("\n  -------------");
		}
	}
public boolean isValidMove(char row, int column) {// is valid by ensuring the cell is within bounds and unoccupied
	int rIndex = row - 'A';
	int cIndex = column - 1;
	if(rIndex <0 || rIndex >= 3 || cIndex < 0 || cIndex >= 3) {
	return false;	
	}
	return !squares[cIndex][rIndex].isOccupied();
}
	public void placeSymbol(char row, int column, String symbol) {
	int rIndex = row - 'A';	
	int cIndex = column - 1;
	squares[cIndex][rIndex].setSymbol(symbol);
	}
	public boolean isFull() { // check if grid is full
		for (int col = 0; col < 3; col++) {
			for(int row = 0; row < 3; row++) {
				if(!squares[col][row].isOccupied()) {
					return false;
				}
			}
		}
		return true;
	}
	public Square getSquare(char row, int column) { // retrieves a square at specific position
		return squares[column - 1][row - 'A'];
	}
}
