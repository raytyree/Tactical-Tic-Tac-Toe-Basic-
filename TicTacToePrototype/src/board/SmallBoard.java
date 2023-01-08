package board;
import player.HumanPlayer;
/**
 * @author Raymon Tyree
 *
 */
public class SmallBoard {
	/**
	 * The game board
	 */
	private String [] board = {"0","0","0","0","0","0","0","0","0"};
	/**
	 * Win status of the board
	 */
	private boolean win = false;
	/**
	 * Board owner
	 */
	private HumanPlayer owner = new HumanPlayer(2, "0");
	private int startPosition = 0;
	private int mostRecentMove;
	public SmallBoard() {
		
	}
	public SmallBoard(int startPos) {
		this.setPosition(startPos);
	}
	public SmallBoard(String [] b) {
		board = b;
	}
	/**
	 * Sets the position of the board for use on a big board
	 * @param posIn - the position to be set
	 * @return True if the position is updated
	 */
	public boolean setPosition(int posIn) {
		if(posIn > -1 && posIn < 9) {
			startPosition = posIn;
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Updates the board to display the move currently being made on the game board
	 * @param currentMove - the move being made on the current turn
	 * @return true if a change is made to the board
	 */
	public boolean updateBoard(int currentMove, HumanPlayer currentPlayer) {
		if(currentPlayer == null){
			System.out.println("ERROR: Player does not exist");
			return false;
		}
		if(currentMove < 10 && currentMove > 0) {
			
			if (moveIsValid(currentMove)) {
				board[currentMove - 1] = currentPlayer.getPlayerSymbol();
				return true;
			}
			else {
				return false;
			}
		}
		else
			System.out.print("ERROR: Desired move is out of bounds!\n"
				+ "Please select a number between 1-9\n");
		return false;
	}
	/**
	 * Generates a string that represents a line on the game board
	 * @param pos0 - first position
	 * @param pos1 - second position
	 * @param pos2 - third position
	 * @return a string composed of the 3 positions
	 */
	public String createLine(int pos0, int pos1, int pos2) {
		String out = "";
		String one = board[pos0];
		String two = board[pos1];
		String three = board[pos2];
		if(one.equals("0")) {
			one = " ";
		}
		if(two.equals("0")) {
			two = " ";
		}
		if(three.equals("0")) {
			three = " ";
		}
		out = String.format("| %s | %s | %s | ", one, 
				two, three);
		return out;
	}
	/**
	 * Checks to see if the inputed move it valid
	 * @param currentMove - The move being checked
	 * @return True if the move can be made false if else
	 */
	public boolean moveIsValid(int currentMove) {
		if (!board[currentMove - 1].equals("0")) {
			System.out.println("This space is filled, please select another");
			return false;
		}
		if (currentMove > 10) {
			return false;
		}
		return true;
	}
	/**
	 * Draws the game board
	 */
	public void drawBoard() {
		System.out.println();
		System.out.println("+-----------+");
		System.out.println(createLine(6,7,8));
		System.out.println("+-----------+");
		System.out.println(createLine(3,4,5));
		System.out.println("+-----------+");
		System.out.println(createLine(0,1,2));
		System.out.println("+-----------+");
	}
	/**
	 * Toggles the win status from true or false
	 */
	public void toggleWinStatus() {
		if (this.win) {
			this.win = false; 
		}
		else {
			win = true;
		}
	}
	/**
	 * Gets the board data
	 * @return - board array
	 */
	public String[] getBoard() {
		return this.board;
	}
	/**
	 * Gets the win status
	 * @return - Board's win status
	 */
	public boolean getWinStatus() {
		return this.win;
	}
	/**
	 * Sets the owner (winner) of the board
	 * @param owner - Player to own the board
	 * @return true if the owner is changed successfully
	 */
	public boolean setOwner(HumanPlayer owner) {
		if(owner != null) {
			this.owner = owner;
			return true;
		}
		else {
			System.out.println("");
			return false;
		}
	}
	/**
	 * Sets the most recent move on the board
	 * @param move - The move to bet set for mostRecentMove
	 * @return True if mostRecentMove is successfully changed
	 */
	public boolean setMostRecentMove(int move) {
		if(this.moveIsValid(move)) {
			mostRecentMove = move;
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Gets the most recent move made on the board
	 * @return the most recent move's location
	 */
	public int getMostRecentMove() {
		return mostRecentMove;
	}
	/**
	 * Gets the current owner of the board
	 * @return The current HumanPlayer that owns the board
	 */
	public HumanPlayer getOwner() {
		return this.owner;
	}
	/**
	 * Gets the start position of the board
	 * @return The start position of the board
	 */
	public int getStartPosition() {
		return this.startPosition;
	}
	/**
	 * Resets the board to its defaults
	 */
	public void reset() {
		this.board = new String[] {"0","0","0","0","0","0","0","0","0"};
		this.setOwner(new HumanPlayer(2, "0"));
		this.win = false;
	}
	/**
	 * Reports if the board is owned by a player
	 * @return True if the board is owned by a player
	 */
	public boolean isOwned() {
		return !this.owner.equals(new HumanPlayer(2, "0"));
	}
	@Override
	public String toString() {
		return String.format("Owner: %s\n"
				+ "Most Recent Move: %d\n"
				+ "Position: %d"
				+ "+-----------+\n%s\n"
				+ "+-----------+\n%s\n"
				+ "+-----------+\n%s\n"
				+ "+-----------+\n", owner.toString(), 
				this.getMostRecentMove(), this.getStartPosition(), this.createLine(0,1,2), 
				this.createLine(3,4,5), this.createLine(6,7,8));
	}
	@Override
	public boolean equals(Object b) {
			boolean out = false;
			
			if(b == null) {
				return out;
			}
			if(this.getClass() != b.getClass()) {
				return out;
			}
			SmallBoard boardIn = (SmallBoard) b;
			if(this.getOwner().equals(boardIn.getOwner()) && this.toString().equals(boardIn.toString())) {
				out = true;
			}
			else {
				out = false;
			}
			return out;
		}
	}

