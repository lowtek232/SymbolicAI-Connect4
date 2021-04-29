package src;

public class GamePlay {
	
	int rows;
	int columns;
	private int key;
	
	//constructor
	public GamePlay(){
		rows = -1;
		columns = -1;
		key = 0;
	}
	
	//method for move expansion
	public GamePlay expansionMove(int r, int c, int k){
		GamePlay expansionMove = new GamePlay();
		expansionMove.rows = r;
		expansionMove.columns = c;
		expansionMove.key = k;
		return expansionMove;
	}
	
	//method for move comparing with MinMax
	public GamePlay compareMove(int k){
		GamePlay compareMove = new GamePlay();
		compareMove.rows = -1;
		compareMove.columns = -1;
		compareMove.key = k;
		return compareMove;
	}
	
	//method for finished move
	public GamePlay finishMove(int r, int c){
		GamePlay finishMove = new GamePlay();
		finishMove.rows = r;
		finishMove.columns = c;
		finishMove.key = -1;
		return finishMove;
	}
	
	//set rows
	public void mutateRows(int r) {
		rows = r;
	}
	
	//set columns
	public void mutateColumns(int c) {
		columns = c;
	}
	
	//set key
	public void mutateKey(int k) {
		key = k;
	}
	
	//getkey
	public int getKey() {
		return key;
	}
	
}
