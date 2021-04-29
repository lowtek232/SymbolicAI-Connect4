package src;

import java.util.ArrayList;
import java.util.Random;

/*
 * @ Authors: Kenny Chhoeun, Javier Meza
 */

public class miniMax {
	int maximumDepth, aiPlayerID;
	
	public miniMax(int playerID) {
		aiPlayerID = playerID;
		maximumDepth = 5;
	}
	
	// minimum method 
	public GamePlay minAlgorithm(int depth, GameState gamestate) {
		Random random = new Random();
		// check if the game has ended or reached maximum depth
		if((gamestate.ifGameOver()) || (depth == maximumDepth)) {
			// new game play object represent base move
			GamePlay primaryMove = new GamePlay();
			primaryMove = primaryMove.expansionMove(gamestate.lastPlay.rows, gamestate.lastPlay.columns, gamestate.auxiliary());
			return primaryMove;
		} else {
			ArrayList<GameState> children = new ArrayList<GameState>(gamestate.getChildren(GameState.X));
			// create another game play object that represent the minimum move
			GamePlay minimumMove = new GamePlay();
			GamePlay move;
			minimumMove = minimumMove.compareMove(2147483647);
			int size = children.size();
			for(int i=0; i<size;i++) {
				GameState child = children.get(i);
				move = maxAlgorithm(depth+1, child);
				/* for everything under the size of the children get
				 * and get the value for what is higher value the child or lower depth
				 * the one with lowest is chosen and returned
				 * 
				 */
				if(minimumMove.getKey() > move.getKey()) {
					if((move.getKey() == minimumMove.getKey())) {
						// if the values of these are the same just randomly pick one of them
						// random number 0 or 1
						if(random.nextInt(2) == 0) {
							minimumMove.mutateRows(child.lastPlay.rows);
							minimumMove.mutateColumns(child.lastPlay.columns);
							minimumMove.mutateKey(move.getKey());
						}
					} else {
						minimumMove.mutateRows(child.lastPlay.rows);
						minimumMove.mutateColumns(child.lastPlay.columns);
						minimumMove.mutateKey(move.getKey());
					}
				}
			}
			return minimumMove;
		}
	} // end of minAlgorithm function
	
	// call maxAlgorithm
	public GamePlay nextMove(GameState gamestate) {
		return maxAlgorithm(0, gamestate.expandedBoard(gamestate));
	}

	//MAXIMUM METHOD
	public GamePlay maxAlgorithm(int depth, GameState gamestate) {
		Random random = new Random();
		if((gamestate.ifGameOver()) || (depth == maximumDepth)) {
			GamePlay primaryMove = new GamePlay();
			primaryMove = primaryMove.expansionMove(gamestate.lastPlay.rows, gamestate.lastPlay.columns, gamestate.auxiliary());
			return primaryMove;
		} else {
			ArrayList<GameState> children = new ArrayList<GameState>(gamestate.getChildren(aiPlayerID));
			GamePlay maximumMove = new GamePlay();
			maximumMove = maximumMove.compareMove(-2147483648);
			for (int i=0; i < children.size(); i++) {
				GameState child = children.get(i);
				GamePlay move = minAlgorithm(depth +1, child);
				if (move.getKey() >= maximumMove.getKey()){
					if ((move.getKey()) == maximumMove.getKey()) {
						if (random.nextInt(2) == 0){
							maximumMove.mutateRows(child.lastPlay.rows);
							maximumMove.mutateColumns(child.lastPlay.columns);
							maximumMove.mutateKey(move.getKey());
							}
						} else {
						maximumMove.mutateRows(child.lastPlay.rows);
						maximumMove.mutateColumns(child.lastPlay.columns);
						maximumMove.mutateKey(move.getKey());
						}
					}
			}
			return maximumMove;
		}
	}
}
