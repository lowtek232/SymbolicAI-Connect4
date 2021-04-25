import java.util.Scanner;
public class Main {
    
	static int colPos
	static GameState gameBoard;
	static MinMax com;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("New Connect 4 Game has started");
		gameBoard = new GameState();
		gameBoard.boardPrint();
		com = newMinMax(GameState.O);
		while(!gameBoard.ifGameOver()){
		        System.out.println();
				System.out.println("Select Column to drop piece");
				colPos = in.nextInt();
				gameBoard.makeMovement(colPos, GameState.player);
				gameBoard.boardPrint();
		}

		System.out.println();
		if (gameBoard.victor == GameState.X){
		    System.out.println("The Player wins. Congratulations!");
		}
		else if (gameBoard.victor == GameState.O){
		    System.out.println("The Computer wins. Better Luck Next time.");
		}
		else {
		    System.out.println("Its a draw. Better luck next time.");
		}
	}	

}
