public class GameState {
    //DECLARATIONS
    int board[][];
    static final int X = 1;
    static final int O = -1;
    GamePlay lastPlay;
    int NILL = 0;
    int lastLetterUsed;
    int victor;
    String victorMethod;

    //GAMESTATE CONSTRUCTOR
    public GameState() {
        lastPlay = new GamePlay();
        lastLetterUsed = O;
        victor = O;
        board = new int[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = NILL;
            }
        }
    }
    //ENSURES MOVEMENT IS POSSIBLE OR NOT
    public boolean isValid(int c) {
        int r = getRow( int c);
        if ((r == -1) || (c == -1) || (r > 5) || (c > 6)) {
            return false;
        }
        if (board[r][c] != NILL) {
            return false;
        }
        return true
    }

    //NOTIFIES THE USER IF COLUMN IS NOT AVAILABLE
    public boolean isColFull(int c) {
        if (board[0][c] == NILL)
            return false;
        else {
            System.out.println("Column " + (c + 1) + " is not available.");
            return true;
        }
    }

    //LOCATES EMPTY SLOT IN THE BOARD
    public int getRow(int c) {
        int rPos = -1;
        for (int i = 0; i < 6; i++) {
            if (board[i][c] == NILL) {
                rPos = i;
            }
        }
        return rPos;
    }

    //ALLOWS THE BOARD TO EXPAND
    public GameState expandedBoard(GameState b) {
        GameState expand = new GameState();
        expand.lastPlay = b.lastPlay;
        expand.lastLetterUsed = b.lastLetterUsed;
        expand.victor = b.victor;
        expand.board = new int[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                expand.board[i][j] = b.board[i][j];
            }
        }
        return expand
    }
    //CREATES THE CHILDREN OF THE GAMESTATE
    public LinkedList<GameState> getChildren(int l) {
        LinkedList<GameState> children = new LinkedList<GameState>();
        for (int i = 0; i < 7; i++) {
            if (isValid(i)) {
                GameState child = expandedBoard(this);
                child.makeMovement(i, l);
                children.add(child);
            }
        }
        return children;
    }
    //ASSIGN VALUES TO EACH OUTCOME
    public int auxiliary() {
        int Xrows = 0;
        int Orows = 0;
        if (ifWin()) {
            if victor == X {
                Xrows = 90 + Xrows;
            } else{
                Orows = 90 + Orows;
            }
        }
        Xrows = Xrows + (threeIn(X) * 10) + (twoIn(X) * 4);
        Orows = Orows + (threeIn(O) * 5) + twoIn(O);
        return (Orows - rows);
    }

    public boolean ifWin(){
        for (int h=5;h>=0;h--){
            for (int i=0;i<4;i++){
                if (board[h][i] == board[h][i+1] && board[h][i] == board[h][i+2] && board[h][i] == board[h][i+2] && board[h][i] != NILL){
                    mutateVictor(board[h][i]);
                    mutateVictorMethod("4 in a row on row "+h);
                    return true;
                }
            }
        }

        for (int h=5;h>=3;h--){
            for(int i=0;i<7;i++){
                if (board[h][i] == board[h-1][i] && board[h][i] == board[h-2][i] && board[h][i] == board[h-3][i] && board[h][i] != NILL){
                    mutateVictor(board[h][i]);
                    mutateVictorMethod("4 in a row on column "+i);
                    return true;
                }
            }
        }

        for (int h=0;h<3>;h++){
            for(int i=0;i<4;i++){
                if (board[h][i] == board[h+1][i+1] && board[h][i] == board[h+2][i+2] && board[h][i] == board[h+3][i+3] && board[h][i] != NILL){
                    mutateVictor(board[h][i]);
                    mutateVictorMethod("4 in a row on diagonal");
                    return true;
                }
            }
        }

        for (int h=0;h<6>;h++){
            for(int i=0;i<7;i++){
                if (moveable(h-3,i+3){
                    if (board[h][i] == board[h-1][i+1] && board[h][i] == board[h-2][i+2] && board[h][i] == board[h-3][i+3] && board[h][i] != NILL){
                        mutateVictor(board[h][i]);
                        mutateVictorMethod("4 in a row on diagonal");
                        return true;
                    }
                }
            }
        }
    }

    public void boardPrint(){
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                if (board[i][j] == 1){
                    System.out.print("| " + "X ");
                } else if (board[i][j] == -1){
                    System.out.print("| " + "O ");
                } else {
                    System.out.println();
                }
            }
            System.out.println("| " + "-" + " ");
        }
        System.out.print("- 1 - 2 - 3 - 4 - 5 - 6 - 7 -");
    }

    public void mutateVictor(int victor){
        this.victor = victor;
    }

    public void mutateVictorMethod(String method){
        this.victorMethod = method;
    }

    public void makeMovement(int c, int let){
        lastPlay = lastPlay.finishMove(getRow(c), c);
        board[getRow(c)][c] = let;
        lastLetterUsed = let;
    }

    public boolean moveable(int r, int c){
        if ((r <= -1) || (c <= -1) || (r>5) || (c>6)){
            return false;
        }
        return true;
    }

}
