import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Gui extends JFrame implements ActionListener{
    
    GameState board;
    JPanel[][] Pieces = new JPanel[6][7];
    JPanel Gameboard = new JPanel();
    
    public Gui(GameState board){
        super("Connect 4");
        this.board = board;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Gameboard.setLayout(new GridLayout(7, 7));
        for (int j=0;j<7;j++){
            Piece p = new Piece(j+1);
            p.addActionListener(this);
            Gameboard.add(p);
        }
        for (int h=0;h<6;h++){
            for (int i=0;i<7;i++){
                Pieces[h][i] = new JPanel();
                Pieces[h][i].setBackground(Color.WHITE);
                Pieces[h][i].setBorder(BorderFactory.createLineBorder(Color.black));
                Gameboard.add(Pieces[h][i]);
            }
        }
        
        add(Gameboard, BorderLayout.CENTER);
        setSize(500,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent es) {
        if(!board.ifGameOver()) {
            switch (board.lastLetterUsed) {
            //If O played last, then X plays now (blue color)
                case GameState.O:
                    Piece piece = (Piece)es.getSource();
                    replace(piece);
                    board.makeMovement(piece.getcol()-1, State.X);
                    break;
                default:
                    break;
            }
        }
    }
    
    void replace(Piece p){
        Pieces[board.getRow(p.getcol()-1)][p.getcol()-1].setBackground(Color.BLUE);
    }
    
    void replace(int col){
        Pieces[board.getRow(col)][col].setBackground(Color.RED);
    }
}