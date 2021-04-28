import javax.swing.*;

public class Piece extends JButton {
	public int column;
	
	public Piece(int c) {
		this.column = c;
	}
	
	public int getcol() {
		return column;
	}
}
