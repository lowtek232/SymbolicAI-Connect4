import java.util.ArrayList;

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
			Gameplay mininumMove = new Gameplay();
			/* for everything under the size of the children get
			 * and get the value for what is higher value the child or lower depth
			 * the one with lowest is chosen and returned
			 * 
			 */
			
		}
		// if not then calculate all the child moves
	} // end of min function

	//MAXIMUM METHOD
	public Gameplay maxAlgorithm(int depth, GameState gamestate) {
		Random random = new Random();
		if((gameBoard.ifGameOver()) || (depth == maximumDepth)) {
			Gameplay primaryMove = new Gameplay();
			return primaryMove;
		} else {
			ArrayList<GameState> childen = new ArrayList<GameState>();
			Gameplay mininumMove = new Gameplay();
			//maximumMove = MIN_VALUE
			for (int i =0; i < children.size();i++) {
				//DETERMINE THE BEST POSSIBLE VALUE
			}
		}
		//return maximumMove
	}
}