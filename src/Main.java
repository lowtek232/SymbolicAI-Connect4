package src;

public class Main {
    
    static int colPos;
    static GameState gameBoard;
    static miniMax com;
    
    public static void main(String[] args) {	
        com = new miniMax(GameState.O);
	gameBoard = new GameState();
        Gui gui = new Gui(gameBoard);
        while(!gameBoard.ifGameOver()) {
            System.out.println();
            switch (gameBoard.lastLetterUsed) {
                case GameState.X:
                    GamePlay comMove = com.nextMove(gameBoard);
                    gui.replace(comMove.columns);
                    gameBoard.makeMovement(comMove.columns, GameState.O);
                    break;
                default:
                    break;
            }
        }
        if (gameBoard.victor == GameState.X){
            Wingui play = new Wingui("Player");
        }
        else if (gameBoard.victor == GameState.O){
            Wingui com = new Wingui("Com");
        }
        else{
            Wingui draw = new Wingui("Draw");
        }
    }
}
