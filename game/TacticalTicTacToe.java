package game;

import java.util.Scanner;

import board.BigBoard;
import player.HumanPlayer;

public class TacticalTicTacToe implements GameType {

	private GameChecks gameRule = new GameChecks();
	private BigBoard playBoard = new BigBoard();
	private HumanPlayer player1 = new HumanPlayer(0, "x");
	private HumanPlayer player2 = new HumanPlayer(1, "o");
	private HumanPlayer tie = new HumanPlayer(1, "t");
	private int currentMove = 4;
	private int moveIn;
	/**
	 * A game instance of Tactical Tic Tac Toe
	 */
	public TacticalTicTacToe() {}	

	public void gameStart(Scanner playerIn) {
		gameRule.addCharacter(player1);
		gameRule.addCharacter(player2);
		playBoard.swtichBoard(currentMove);
		System.out.print("Select player to start (1/2) : ");
		gameRule.setTurn(playerIn.nextInt() - 1);
		//Run the game
		while(true) {
			//Give the round number
			System.out.println(String.format("Round %d", gameRule.getRound() + 1));
			playBoard.drawBigBoard();
			//Prompt player to make a move
			System.out.println(String.format("Its player %d's turn", gameRule.getTurn() + 1));
			
			this.prompt(playerIn);
			System.out.println("");
			//validate the move and update the most recent move
			while(!playBoard.getCurrentBoard().updateBoard(moveIn, gameRule.getCurrentPlayer())) {
				this.prompt(playerIn);
			}
			playBoard.setMostRecentMove(moveIn);
			//Check SmallBoard for a win, if one is found set owner to be the current player
			if (gameRule.checkWinState(playBoard.getCurrentBoard())) {
				playBoard.getCurrentBoard().setOwner(gameRule.getCurrentPlayer());
			}
			//If a tie is found, set the boards owner to be tie
			if(gameRule.tieFinder(playBoard.getCurrentBoard())) {
				playBoard.getCurrentBoard().setOwner(tie);
			}
			//Check for a win on the bigboard
			if(gameRule.checkWinState(playBoard)) {
				playBoard.drawBigBoard();
				System.out.println(String.format("Player %d Wins!", gameRule.getCurrentPlayer().getPlayerNum() + 1));
				break;
			}
			if(gameRule.tieFinder(playBoard)) {
				playBoard.drawBigBoard();
				System.out.println("It's a tie!");
			}
			playBoard.swtichBoard(moveIn - 1);
			//If the switched board is owned prompt player to pick next board
			while(playBoard.getCurrentBoard().isOwned()) {
				playBoard.drawBigBoard();
				System.out.println(String.format("The space is owned, select next zone player %d!", gameRule.getCurrentPlayer().getPlayerNum() + 1));
				this.prompt(playerIn);
				playBoard.swtichBoard(moveIn - 1);
			}
			gameRule.nextRound();
			gameRule.alternatePlayer();
		}
		this.reset();
		//Prompt to play again
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
		this.playBoard.reset();
		this.currentMove = 4;
		
	}
	

}
