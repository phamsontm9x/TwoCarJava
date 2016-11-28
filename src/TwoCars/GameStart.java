package TwoCars;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameStart extends JFrame implements Constants {
	public GameStart() {
		add (new GamePlay());
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		setTitle("TwoCar");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new GameStart();
	}
}
