package game;

import java.util.Scanner;

public interface GameType {
	/**
	 * Starts the game. And contains the games running processes
	 * @param playerIn - Scanner used to read inputs used in the game
	 */
	public void gameStart(Scanner playerIn);
	/**
	 * Resets the game
	 */
	public void reset();
}
