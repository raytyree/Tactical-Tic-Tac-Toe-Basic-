package game;
import java.util.Scanner;

/**
 * @author Raymon Tyree
 *
 */
public class Game {

	public static void main(String[] args) {
		TicTacToe regularGame = new TicTacToe();
		TacticalTicTacToe ttttGame = new TacticalTicTacToe();
		try (Scanner playerIn = new Scanner(System.in)) {

			while(true) {
				System.out.println("\r\n"
						+ "___________.__         ___________               ___________                                                         \r\n"
						+ "\\__    ___/|__| ____   \\__    ___/____    ____   \\__    ___/___   ____                                               \r\n"
						+ "  |    |   |  |/ ___\\    |    |  \\__  \\ _/ ___\\    |    | /  _ \\_/ __ \\                                              \r\n"
						+ "  |    |   |  \\  \\___    |    |   / __ \\\\  \\___    |    |(  <_> )  ___/                                              \r\n"
						+ "  |____|   |__|\\___  >   |____|  (____  /\\___  >   |____| \\____/ \\___  >                                             \r\n"
						+ "                   \\/                 \\/     \\/                      \\/                                              \r\n"
						+ "___________                                                      __    ___________    .___.__  __  .__               \r\n"
						+ "\\__    ___/___  __ _________  ____ _____    _____   ____   _____/  |_  \\_   _____/  __| _/|__|/  |_|__| ____   ____  \r\n"
						+ "  |    | /  _ \\|  |  \\_  __ \\/    \\\\__  \\  /     \\_/ __ \\ /    \\   __\\  |    __)_  / __ | |  \\   __\\  |/  _ \\ /    \\ \r\n"
						+ "  |    |(  <_> )  |  /|  | \\/   |  \\/ __ \\|  Y Y  \\  ___/|   |  \\  |    |        \\/ /_/ | |  ||  | |  (  <_> )   |  \\\r\n"
						+ "  |____| \\____/|____/ |__|  |___|  (____  /__|_|  /\\___  >___|  /__|   /_______  /\\____ | |__||__| |__|\\____/|___|  /\r\n"
						+ "                                 \\/     \\/      \\/     \\/     \\/               \\/      \\/                         \\/ \r\n"
						+ "");
				System.out.println("Please select an option");
				System.out.println("1  - Tic Tac Toe");
				System.out.println("2 - Tactical Tic Tac Toe");
				System.out.println("quit - Quit\n");
				System.out.print("Selection: ");
				
				String option = playerIn.nextLine();
				//Start UI
				switch(option) {
				//Tic Tac Toe
				case "1": 
					regularGame.gameStart(playerIn);

					break;
				//Tactical Tic Tac Toe
				case "2":
					ttttGame.gameStart(playerIn);
					break;
				//Quit
				case "quit":
					System.out.println("Goodbye:)");
					System.exit(0);
					break;
				case "\n":
					break;
				default:
					System.out.println("Option does not exist\n\n");
					break;
				}
			}
		}
	}
}
