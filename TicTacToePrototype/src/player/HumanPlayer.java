package player;
/**
 * @author Raymon Tyree
 *
 */
public class HumanPlayer {
	private boolean win = false;
	private int playerNum;
	private String playerSymbol;
	/**
	 * A player for the game
	 * @param number - Players number/ID
	 * @param symbol - Symbol that represents the player on the board
	 */
	public HumanPlayer(int number, String symbol){
		this.setNumber(number);
		this.setSymbol(symbol);
	}
	/**
	 * Sets the player number
	 * @param number - the number for the desired player
	 */
	public void setNumber(int number){
		if (number > -1 && number < 2) {
			this.playerNum = number;
		}
	}
	/**
	 * Sets the win status of the player
	 * @param status - true if a player has won
	 */
	public void setStatus(boolean status) {
		this.win = status;
	}
	/**
	 * Sets the symbol that will represent the respective player
	 * @param symbol - a one character string that represents a player
	 */
	@SuppressWarnings("null")
	public void setSymbol(String symbol) {
		if (symbol != null || !symbol.isEmpty()) {
			playerSymbol = symbol;
		}
		else {
			System.out.println("ERROR: Symbol is empty or null. Please place a valid symbol");
		}
	}
	/**
	 * Gets the players play symbol
	 * @return the players symbol in a string
	 */
	public String getPlayerSymbol(){
		return this.playerSymbol;
	}
	/** 
	 * Tells the players win status with "true" meaning a player has won
	 * @return player win status as a boolean
	 */
	public boolean getStatus(){
		return this.win;
	}
	/**
	 * Gets the player number
	 * @return the player number
	 */
	public int getPlayerNum() {
		return this.playerNum;
	}
	@Override
	public String toString() {
		return "Player " + (playerNum + 1)  + "\nSymbol " + playerSymbol;
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
		HumanPlayer player = (HumanPlayer) b;
		if(this.getStatus() == player.getStatus() && 
				this.getPlayerNum() == player.getPlayerNum() &&
				this.getPlayerSymbol().equals(player.getPlayerSymbol())) {
			out = true;
		}
		else {
			out = false;
		}
		return out;
	}
}
