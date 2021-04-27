public class Main {
    
    static int colPos;
    static GameState gameBoard;
    static MinMax com;
    
    public static void main(String[] args) {	
        com = new MinMax(State.O);
	gameBoard = new State();
        Gui gui = new Gui(gameBoard);
        while(!gameBoard.ifGameOver()) {
            System.out.println();
            switch (gameBoard.lastLetterUsed) {
                case GameState.X:
                    GamePlay comMove = com.getNextMove(gameBoard);
                    gui.replace(comMove.col);
                    gameBoard.makeMovement(comMove.col, GameState.O);
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
