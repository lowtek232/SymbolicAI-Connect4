import java.swingx.*;

public class Wingui {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    
    public Wingui(String win) {
        frame.setTitle("Win State");
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (win == "Player") {
            label.setText("You won. Congratulations!");
        }
        else if (win == "Com") {
            label.setText("The computer won. Better luck next time.");
        }
        else {
            label.setText("You both have tied. Better luck next time.");
        }
        label.setHorizontalTextPosition(JLabel.CENTER);
    }
}
