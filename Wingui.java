import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Wingui {
    JFrame frame = new JFrame();
    JLabel label;
    
    public Wingui(String win) {
        frame.setTitle("Win State");
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (win.equals("Player")) {
            label = new JLabel("You won. Congratulations!", SwingConstants.CENTER);
        }
        else if (win.equals("Com")) {
            label = new JLabel("The computer won. Better luck next time.", SwingConstants.CENTER);
        }
        else {
            label = new JLabel("You both have tied. Better luck next time.", SwingConstants.CENTER);
        }
        frame.getContentPane().add(label);
    }
}
