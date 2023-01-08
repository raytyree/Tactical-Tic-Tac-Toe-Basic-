package gameTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.BigBoard;
import game.GameChecks;
import player.HumanPlayer;

class WinConditions {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	@Test
	void testWinConditionsBigBoard() {
		GameChecks rule = new GameChecks();
		HumanPlayer a = new HumanPlayer(0, "x");
		HumanPlayer b = new HumanPlayer(1, "0");
		BigBoard mainBoard = new BigBoard();
		rule.addCharacter(a);
		rule.addCharacter(b);
		mainBoard.drawBoard();
		assertEquals(rule.checkWinState(mainBoard), false);
		}

}
