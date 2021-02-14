package front;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2269971701250845501L;
	private JPanel mainPanel = new JPanel();
	private JButton startButton;
	private JButton settingsButton;
	private JLabel welcomeLabel;
	
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)(screenSize.width/1.5), (int)(screenSize.height/1.5));
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("icon.jpg").getImage());
		setTitle("DenisGame");
		setResizable(false);		
			
		addingContent();		
				
		setVisible(true);
		toFront();
	}
	
	private void addingContent() {
		mainPanel.setLayout(null);	
		int width = (int) (this.getWidth()/7);
		int height = (int) (this.getHeight()/7);
		int x = (int)((this.getWidth() - width)/2);
		int y = (int)((this.getHeight() - height)/2);		
		startButton = createButton("Start", new StartButtonListener(), width, height, x, y);
		mainPanel.add(startButton);
		
		width = (int) (this.getWidth()/9);
		height = (int) (this.getHeight()/9);
		x = (int)((this.getWidth() - width)/2);
		y = startButton.getY() + startButton.getHeight() + height;
		settingsButton = createButton("Settings", new SettingsButtonListener(), width, height, x, y);
		mainPanel.add(settingsButton);
		
		welcomeLabel = new JLabel("Hello! You are in Denis game :-). Press Start to play))");
		welcomeLabel.setBounds(startButton.getX() - startButton.getWidth()/2, startButton.getY() - startButton.getHeight(), startButton.getWidth()*3, height);
		mainPanel.add(welcomeLabel);
		
		add(mainPanel);
	}
	
	private JButton createButton(String text, ActionListener listener, int width, int height, int x, int y) {
		JButton button = new JButton(text); 
		button.setBounds(x, y, width, height);
		button.addActionListener(listener);
		return button;
	}
	
	private class StartButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			mainPanel.remove(startButton);
			mainPanel.remove(settingsButton);
			mainPanel.remove(welcomeLabel);
			repaint();			
		}
	}
	
	
	private class SettingsButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			/*
			 * открытие окна настроек
			 */
		}
	}
//	class Player1NameListener implements TextListener{
//		@Override
//		public void textValueChanged(TextEvent e) {
//			Settings.PLAYER_1_NAME = ""; //= something		
//		}	
//	}

		
}
