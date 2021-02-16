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
		Rectangle bounds = new Rectangle();
		bounds.width = (int) (this.getWidth()/7);
		bounds.height = (int) (this.getHeight()/7);
		bounds.x = (int)((this.getWidth() - bounds.width)/2);
		bounds.y = (int)((this.getHeight() - bounds.height)/2);		
		startButton = new Button("Start game", new StartButtonListener(), bounds);
		mainPanel.add(startButton);
		
		bounds.width = (int) (this.getWidth()/9);
		bounds.height = (int) (this.getHeight()/9);
		bounds.x = (int)((this.getWidth() - bounds.width)/2);
		bounds.y = startButton.getY() + startButton.getHeight() + bounds.height;
		settingsButton = new Button("Settings", new SettingsButtonListener(), bounds);
		mainPanel.add(settingsButton);
		
		welcomeLabel = new JLabel("Hello! You are in Denis game :-). Press Start to play))");
		welcomeLabel.setBounds(startButton.getX() - startButton.getWidth()/2, startButton.getY() - startButton.getHeight(), startButton.getWidth()*3, bounds.height);
		mainPanel.add(welcomeLabel);
		
		add(mainPanel);
	}
	
	private class Button extends JButton{
		private static final long serialVersionUID = -1481865445568228684L;		
		public Button(String text, ActionListener listener, Rectangle bounds) {
			super(text);
			setBounds(bounds);
			addActionListener(listener);
		}		
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
