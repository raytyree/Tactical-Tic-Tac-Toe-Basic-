/**
 * 
 */
package board;

import color.ANSIcolor;
import player.HumanPlayer;
/**
 * @author Raymon Tyree
 *
 */
public class BigBoard extends SmallBoard{
	
	private SmallBoard board0 = new SmallBoard(0);
	private SmallBoard board1 = new SmallBoard(1);
	private SmallBoard board2 = new SmallBoard(2);
	private SmallBoard board3 = new SmallBoard(3);
	private SmallBoard board4 = new SmallBoard(4);
	private SmallBoard board5 = new SmallBoard(5);
	private SmallBoard board6 = new SmallBoard(6);
	private SmallBoard board7 = new SmallBoard(7);
	private SmallBoard board8 = new SmallBoard(8);
	/**
	 * The player that has won and now owns the board
	 */
	HumanPlayer owner = new HumanPlayer(2, "0");
	/**
	 * Current location of a board (Mainly for use of Tactical Tic Tac Toe)
	 */
	private int currentLocation = 4;
	/**
	 * All the small boards that make up the big board
	 */
	private SmallBoard [] board = {board0, board1, board2, board3, board4, board5, board6, board7, board8};
	/**
	 * A 3x3 grid of SmallBoards with a starting position at index 4 and all small boards empty
	 */
	public BigBoard() {}
	/**
	 * A 3x3 grid of SmallBoards with a starting position at a desired location and a set of 
	 * predetermined moves on each SmallBoard
	 * @param startingLocation - Desired starting location of the board (Mainly for use of Tactical Tic Tac Toe)
	 * @param boardIn - The set of smallBoards to start the game with
	 */
	public BigBoard(int startingLocation, SmallBoard[] boardIn) {
		this.swtichBoard(startingLocation);
		this.board = boardIn;
	}
	/**
	 * Draws out the full BigBoard
	 */
	public void drawBigBoard() {
		System.out.println("+=======================================+");
		this.createBoardLine(6);
		System.out.println("+===========+=+===========+=+===========+");
		this.createBoardLine(3);
		System.out.println("+===========+=+===========+=+===========+");
		this.createBoardLine(0);
		System.out.println("+=======================================+");
	}
	/**
	 * Generates a list of the small board statuses in "board"
	 * @return - list of win statuses in an array
	 */
	public String[] generateStatusSymbols() {
		String [] out = new String[9];
		int i = 0;
		for(SmallBoard board : board) {
			out[i] = board.getOwner().getPlayerSymbol();
			i++;
		}
		return out;
	}
	/**
	 * Gets the boards data of the big board
	 * @return - boards array
	 */
	public SmallBoard[] getBoards() {
		return this.board;
	}
	/**
	 * Gets the board that is currently being played on
	 * @return The current SmallBoard being played on
	 */
	public SmallBoard getCurrentBoard() {
		return board[currentLocation];
	}
	/**
	 * Switches the current board being played on
	 * @param location - The desired board to be played on
	 * @return True if the location is successfully changed
	 */
	public boolean swtichBoard(int location) {
		if (location >= board.length) {
			System.out.println("ERROR: Desired board is out of bounds");
			return false;
		}
		this.currentLocation = location;
		return true;
	}
	/**
	 * Sets the conditions for a desired board on the big board
	 * @param boardIn - The board that sets the conditions for the target board
	 * @param targetBoard - Index of desired board
	 * @return True if the board is successfully altered
	 */
	public boolean setBoard(SmallBoard boardIn, int targetBoard) {
		if(boardIn == null) {
			System.out.println("ERROR: Board cannot be null");
			return false;
		}
		if(targetBoard < board.length) {
			board[targetBoard] = boardIn;
			return true;
		}
		else {
			System.out.println("ERROR: Desired board is out of bounds");
			return false;
		}
	}
	/**
	 * Generates a string that represents a line on the game board
	 * @param pos0 - first position
	 * @param pos1 - second position
	 * @param pos2 - third position
	 * @param startIndex - the board to start creating the line from
	 * @return a string composed of the 3 positions
	 */
	public String createFullBoardLine(int pos0, int pos1, int pos2, int startIndex) {
		String out = "";
		if(board[startIndex].equals(this.getCurrentBoard())) {
			out = ANSIcolor.GREEN_BACKGROUND + board[startIndex].createLine(pos0, pos1, pos2) + 
					ANSIcolor.BLACK_BACKGROUND;
		} else {
			out = board[startIndex].createLine(pos0, pos1, pos2);
		}
		for(int i = startIndex + 1; i < startIndex + 3; i++) {
			if(board[i].equals(this.getCurrentBoard()))
			{
				out += ANSIcolor.GREEN_BACKGROUND + board[i].createLine(pos0, pos1, pos2) 
						+ ANSIcolor.BLACK_BACKGROUND;
			} else {
				out += board[i].createLine(pos0, pos1, pos2);
			}
			//out = out.substring(0, out.length() - 2);
			
		}
		return out;
	}
	/**
	 * Prints a line of small boards from a desired index in steps of 3
	 * @param startIndex - The starting point of the print
	 */
	public void createBoardLine(int startIndex) {
		int a = 6;
		int b = 7;
		int c = 8;
		for(int i = 0; i < 3; i++) {
			System.out.println(createFullBoardLine(a, b, c, startIndex));
			if(!(i == 2))
			{
				System.out.println("|-----------| |-----------| |-----------|");
			}
			a -= 3;
			b -= 3;
			c -= 3;
		}
	}
	@Override
	public void reset() {
		this.setOwner(new HumanPlayer(2, "0"));
		for(int i = 0; i < board.length; i++) {
			this.setBoard(new SmallBoard(i), i);
		}
		this.currentLocation = 4;
	}
	@Override
	public String createLine(int pos0, int pos1, int pos2) {
		String out;
		out = String.format("| %s | %s | %s |", board[pos0].getOwner().getPlayerSymbol(), 
				board[pos1].getOwner().getPlayerSymbol(), board[pos2].getOwner().getPlayerSymbol());
		return out; 
	}
}
