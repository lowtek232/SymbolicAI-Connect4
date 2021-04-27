import java.util.ArrayList;
import java.util.Random;

/*
 * @ Authors: Kenny Chhoeun, Javier Meza
 */

public class miniMax {
	int maximumDepth, aiPlayerID;
	
	public miniMax(int playerID) {
		aiPlayerID = playerID;
	}
	
	// minimum method 
	public Gameplay minAlgorithm(int depth, GameState gamestate) {
		Random random = new Random();
		// check if the game has ended or reached maximum depth
		if((gameBoard.ifGameOver()) || (depth == maximumDepth)) {
			// new gameplay object represent base move
			Gameplay primaryMove = new Gameplay();
			return primaryMove.expansionMove();
		} else {
			ArrayList<GameState> childen = new ArrayList<GameState>();
			// create another gameplay object that represenet the mininum move
			Gameplay minimumMove = new Gameplay();
			Gameplay move;
			minumumMove = minumumMove.compareMove(2147483647);
			int size = children.size();
			for(int i=0; i<size;i++) {
				GameState child = children.get(i);
				move = max(child, depth+1);
				/* for everything under the size of the children get
				 * and get the value for what is higher value the child or lower depth
				 * the one with lowest is chosen and returned
				 * 
				 */
				if(minimumMove.key() > move.key()) {
					if((move.key() == minimumMove.key())) {
						// if the values of these are the same just randomly pick one of them
						// random number 0 or 1
						if(random.nextInt(2) == 0) {
							minimumMove.mutateRows(child.lastPlay.row);
							minimumMove.mutateColumns(child.lastPlay.col);
							minimumMove.mutateKey(child.getKey());
						}
					} else {
						minimumMove.mutateRows(child.lastPlay.row);
						minimumMove.mutateColumns(child.lastPlay.col);
						minimumMove.mutateKey(child.getKey());
					}
				}
			}
			return minimumMove;
		}
	} // end of min function

	//MAXIMUM METHOD
	public GamePlay maxAlgorithm(int depth, GameState gamestate) {
		Random random = new Random();
		if((gameBoard.ifGameOver()) || (depth == maximumDepth)) {
			GamePlay primaryMove = new GamePlay();
			return primaryMove;
		} else {
			ArrayList<GameState> childen = new ArrayList<GameState>();
			GamePlay maximumMove = new GamePlay();
			maximumMove = maximumMove.compareMove(-2147483648);
			for (int i=0; i < children.size(); i++) {
				GameState child = childen.get(i);
				GamePlay move = min(child, depth +1);
				if (move.getValue() >= maximumMove.key()){
					if ((move.key()) == maximumMove.key())) {
						if (random.nextInt(2) == 0){
							maximumMove.mutateRows(child.lastPlay.rows);
							maximumMove.mutateColumns(child.lastPlay.columns);
							maximumMove.mutateKey(move.key());
							}
						} else {
						maximumMove.mutateRows(child.lastPlay.rows);
						maximumMove.mutateColumns(child.lastPlay.columns);
						maximumMove.mutateKey(move.key());
						}
					}
			}
			return maximumMove;
		}
	}
}