package TicTacToe;

public class Square 
{
private char row;
private int column;
private String symbol;

public Square(char row, int column) {
	this.row = row;
	this.column = column;
	this.symbol = " ";
}
public String getSymbol() {
	return symbol;
}
public void setSymbol(String symbol) {
	if(this.symbol.equals(" ")) {
		this.symbol = symbol;
	}
}
public boolean isOccupied() {// check if there is a symbol in the cell
	return !symbol.equals(" ");
}
public char getRow() {
	return row;
}
public int getColumn() {
	return column;
}
public String toString() {
	return symbol;
}
}
