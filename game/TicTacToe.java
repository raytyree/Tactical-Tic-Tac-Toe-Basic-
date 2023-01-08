/**
 * 
 */
package game;

import java.util.Scanner;

import board.SmallBoard;
import player.HumanPlayer;

/**
 * @author Raymon Tyree
 *
 */
public class TicTacToe implements GameType{

	private GameChecks gameRule = new GameChecks();
	private SmallBoard currentSmall = new SmallBoard();
	private HumanPlayer player1 = new HumanPlayer(0, "x");
	private HumanPlayer player2 = new HumanPlayer(1, "o");
	private int moveIn;
	/**
	 * Game instance of Tic Tac Toe
	 */
	public TicTacToe() {}
	public void gameStart(Scanner playerIn) {
		gameRule.addCharacter(player1);
		gameRule.addCharacter(player2);

		System.out.println("Select the player to start (1/2)");
		
		//Determines the player to start
		gameRule.setTurn(playerIn.nextInt() - 1);
		System.out.println("");
		String out = "";
		while(true) {
			System.out.print(String.format("Round %d", gameRule.getRound() + 1));
			currentSmall.drawBoard();
			//Prompt player to make a move
			System.out.print(String.format("It's player %d's turn!\n", gameRule.getTurn() + 1));
			this.prompt(playerIn);
			//Updates the board on a successful move else prompt for a valid move
			if(currentSmall.updateBoard(moveIn, gameRule.getPlayerList()[gameRule.getTurn()])) {
				//If a tie is found end the game else check for a win
				if(gameRule.tieFinder(currentSmall)) {
					out = "Its a tie!";
					currentSmall.setOwner(null);
					break;
				}
				//If a win is found give ownership of the board to the winner
				if(gameRule.checkWinState(currentSmall)) {
					currentSmall.setOwner(gameRule.getPlayerList()[gameRule.getTurn()]);
					out = String.format("Player %d Wins!", currentSmall.getOwner().getPlayerNum() + 1);

					break;
				}
				gameRule.alternatePlayer();
				gameRule.nextRound();
			}

			
		}
		currentSmall.drawBoard();
		//Present results
		System.out.println(out);
		this.playAgain(playerIn);
	}
	public void playAgain(Scanner playerIn) {
		System.out.println("Would you like to play again? (y/n)");
		
		String replay = playerIn.next();
		if(replay.equals("y")) {
			this.reset();
			this.gameStart(playerIn);
		}
		else {
			System.out.println("");
		}
	}
	public void prompt(Scanner playerIn) {
		System.out.print("Please make a move: ");
		moveIn = playerIn.nextInt();
	}
	public void reset() {
		this.gameRule = new GameChecks();
		currentSmall.reset();
	}
}
