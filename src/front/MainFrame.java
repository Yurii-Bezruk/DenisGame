package front;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2269971701250845501L;
	private JPanel mainPanel;
	
	public MainFrame() {
		//creating a window with name
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//adjusting window size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)(screenSize.width/1.5), (int)(screenSize.height/1.5));
		setLocationRelativeTo(null);
		//setBounds(screenSize.width/6, screenSize.height/6, (int)(screenSize.width/1.5), (int)(screenSize.height/1.5));
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}
	
}
