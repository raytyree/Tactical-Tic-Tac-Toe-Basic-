package game;
import player.HumanPlayer;
import arrays.ArrayTools;
import board.BigBoard;
import board.SmallBoard;
/**
 * @author Raymon Tyree
 *
 */
public class GameChecks {
	/**
	 * Number of Players
	 */
	private int players = 0;
	/**
	 * Current Turn
	 */
	private int turn = 0;
	/**
	 * Current game round
	 */
	private int round = 0;
	/**
	 * Symbol of the winner for a round
	 */
	private String winnerSymbol = "";
	/**
	 * List of players in the game
	 */
	HumanPlayer [] playerList = new HumanPlayer[10];
	/**
	 * A set of game state checks for tic tac toe variations
	 */
	public GameChecks() {}
	/**
	 * Adds a player to the playerList
	 * @param player - player to be added
	 * @return true if a player is successfully added false otherwise
	 */
	public boolean addCharacter(HumanPlayer player) {
		if(players < 10) {
			playerList[players] = player;
			players++;
			return true;
		}
		else {
			System.out.println("ERROR: Max players 10 list is FULL!");
			return false;
		}
	}
	/**
	 * Generates a list of player id's based on the player number
	 * @return list of id's
	 */
	public Integer[] generatePlayerIds() {
		Integer[] ids = new Integer[10];
		int i = 0;
		for(HumanPlayer player : playerList) {
			if(player != null) {
				ids[i] = player.getPlayerNum();
				i++;
			}
		}
		return ids;
	}
	/**
	 * Generates a list of player symbols in their respective positions
	 * @return
	 */
	public String[] generatePlayerSymbols() {
		String [] symbols = new String[10];
		int i = 0;
		for(HumanPlayer player : playerList) {
			if(player != null) {
				symbols[i] = player.getPlayerSymbol();
				i++;
			}
		}
		return symbols;
	}
	/**
	 * Loads in the current symbol of the desired player
	 * @param currentPlayer - The player symbol is being retrieved
	 * @return The player symbol string
	 */
	public String loadSymbol(int currentPlayer) {
		return this.playerList[currentPlayer].getPlayerSymbol();
	}
	/**
	 * Checks the board for a win on the board
	 * @return - true if a win has been found
	 */
	public boolean checkWinState(SmallBoard board){
		if(this.checkLine(0,1,2,board)){
			return true;
		}
		if(this.checkLine(0,4,8,board)){
			return true;
		}
		if(this.checkLine(0,3,6,board)){
			return true;
		}
		if(this.checkLine(1,4,7,board)){
			return true;
		}
		if(this.checkLine(2,5,8,board)){
			return true;
		}
		if(this.checkLine(2,4,6,board)){
			return true;
		}
		if(this.checkLine(3,4,5,board)){
			return true;
		}
		if(this.checkLine(0,1,2,board)){
			return true;
		}
		if(this.checkLine(2,5,8,board)){
			return true;
		}
		if(this.checkLine(6,7,8,board)){
			return true;
		}
		return false;
	}
	/**
	 * Checks the board for a win on the board
	 * @return - true if a win has been found
	 */
	public boolean checkWinState(BigBoard board){
		if(this.checkLine(0,1,2,board)){
			return true;
		}
		if(this.checkLine(0,4,8,board)){
			return true;
		}
		if(this.checkLine(0,3,6,board)){
			return true;
		}
		if(this.checkLine(1,4,7,board)){
			return true;
		}
		if(this.checkLine(2,5,8,board)){
			return true;
		}
		if(this.checkLine(2,4,6,board)){
			return true;
		}
		if(this.checkLine(3,4,5,board)){
			return true;
		}
		if(this.checkLine(0,1,2,board)){
			return true;
		}
		if(this.checkLine(2,5,8,board)){
			return true;
		}
		if(this.checkLine(6,7,8,board)){
			return true;
		}
		return false;
	}
	/**
	 * Checks a single line on the board for a win
	 * @param a - first position of the line
	 * @param b - second position in the line
	 * @param c - third position in the line
	 * @param board - the board being checked
	 * @return - true if a win is found
	 */
	private boolean checkLine(int a, int b, int c, SmallBoard board) {
		String [] check = board.getBoard();
		if(check[a].equals(check[b]) && check[b].equals(check[c]) && !check[c].equals("0")) {
			winnerSymbol = check[a];
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Checks a single line on the big board for a win
	 * @param a - first position of the line
	 * @param b - second position in the line
	 * @param c - third position in the line
	 * @param board - the board being checked
	 * @return - true if a win is found
	 */
	private boolean checkLine(int a, int b, int c, BigBoard board) {
		SmallBoard [] check = board.getBoards();
		if(check[a].getOwner().equals(check[b].getOwner()) && 
				check[b].getOwner().equals(check[c].getOwner()) && 
				!check[c].getOwner().getPlayerSymbol().equals("0") &&
				!check[c].getOwner().getPlayerSymbol().equals("t")) {
			winnerSymbol = check[a].getOwner().getPlayerSymbol();
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Alternates between players on the player list
	 */
	public void alternatePlayer() {
		if(turn < players - 1){
			turn++;
		}
		else {
			turn = 0;
		}
	}
	/**
	 * Gets the list of players
	 * @return - List of players
	 */
	public HumanPlayer[] getPlayerList() {
		return this.playerList;
	}
	/**
	 * Gets the current turn value
	 * @return The turn as an int
	 */
	public int getTurn() {
		return this.turn;
	}
	/**
	 * Sets the round of the current game
	 * @param round - the value for round to be set
	 * @return - true if the round was changed successfully
	 */
	public boolean setRound(int round) {
		if(round > 0) {
			this.round = round;
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Increments the round up one value
	 */
	public void nextRound() {
		round++;
	}
	/**
	 * Sets the turn field and updates the current player
	 * @param turn - The value to set turn to
	 * @return - True if the value was successfully changed
	 */
	public boolean setTurn(int turn) {
		if(turn < players) {
			this.turn = turn;
			return true;
		}
		return false;
	}
	/**
	 * Gets the current round value
	 * @return - the value of the current round as an int
	 */
	public int getRound() {
		return this.round;
	}
	/**
	 * Gets the winner symbol
	 * @return - the winner symbol as a string
	 */
	public String getWinnerSymbol() {
		return this.winnerSymbol;
	}
	/**
	 * Checks for a tie in the board
	 * @param board - the board being checked
	 * @return True if a tie is found
	 */
	public boolean tieFinder(SmallBoard board) {
		boolean out = false;
		if(board == null) {
			System.out.println("ERROR: Inputted board is NULL");
			return out;
		}
		if(!this.checkWinState(board)) {
			if(ArrayTools.findElement(board.getBoard(), "0") > -1) {
				out = false;
			}
			else {
				out = true;
			}
		}
		return out;
	}
	/**
	 * Checks for a tie in the board
	 * @param board - the board being checked
	 * @return True if a tie is found
	 */
	public boolean tieFinder(BigBoard board) {
		boolean out = false;
		if(board == null) {
			System.out.println("ERROR: Inputted board is NULL");
			return out;
		}
		String[] check = board.generateStatusSymbols();
		if(this.checkWinState(board)){
			return out;
		}
		for(String str : check) {
				if(str.equals("0")) {
					return out;
				}
				else {
					out = true;
				}
			}
			return out;
		}
	/**
	 * Returns the player currently playing in a game
	 * @return The playerPlaying
	 */
	public HumanPlayer getCurrentPlayer() {
		return this.playerList[turn];
	}
}

