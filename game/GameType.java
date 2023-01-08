package game;

import java.util.Scanner;

public interface GameType {
	/**
	 * Starts the game. And contains the games running processes
	 * @param playerIn - Scanner used to read inputs used in the game
	 */
	public void gameStart(Scanner playerIn);
	/**
	 * Prompts the player to make a move
	 * @param playerIn - Scanner used to read inputs used in the game
	 */
	public void prompt(Scanner playerIn);
	/**
	 * Asks if the user wants to play again. If yes replay the game
	 * @param playerIn - Scanner used to read inputs used in the game
	 */
	public void playAgain(Scanner playerIn);
	/**
	 * Resets the game
	 */
	public void reset();
}
