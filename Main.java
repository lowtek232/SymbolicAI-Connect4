import java.util.Scanner;
public class Main {
    
	static int colPos
	static GameState gameBoard;
	static MinMax com;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Connect 4 Game has started");
		gameBoard = new GameState();
		gameBoard.boardPrint();
		com = new MinMax(GameState.O);
		
		while(!gameBoard.ifGameOver()){
			System.out.println();
			switch (gameBoard.lastLetterUsed) {
				case GameState.X:
					System.out.println("Computer O's turn.");
					GamePlay comMove = com.nextMove(gameBoard);
					gameBoard.makeMovement(comMove.columns, GameState.O);
					System.out.println("Computer O played on column " + (comMove.columns + 1) + ".");
					System.out.println();
					break;
				case GameState.O:
		        	System.out.println("Player X's turn.");
		        	try {
		        		do {
		    				System.out.println("\nSelect Column (1-7) to drop piece: ");
		    				colPos = in.nextInt();
		        		} while (gameBoard.isColFull(colPos - 1));
		        	} catch (Exception e) {
		        		System.out.println("\nNumber not in range of 1-7. Try again.\n");
		        		break;
		        	}
		        	gameBoard.makeMovement(colPos - 1, GameState.X);
		        	gameBoard.boardPrint();
		        	break;
				default:
					break;
		        }
			gameBoard.boardPrint();
		}

		System.out.println();
		if (gameBoard.victor == GameState.X){
		    System.out.println("The Player wins. Congratulations!");
		    System.out.println(gameBoard.victorMethod);
		}
		else if (gameBoard.victor == GameState.O){
		    System.out.println("The Computer wins. Better Luck Next time.");
		    System.out.println(gameBoard.victorMethod);
		}
		else {
		    System.out.println("Its a draw. Better luck next time.");
		}
		System.out.println("Game over.");
	}	

}
