package front;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2269971701250845501L;
	private JPanel mainPanel = new JPanel();
	
//	private int frameWidth;
//	private int frameHeight;
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
		//start button
		int width = (int) (this.getWidth()/7);
		int height = (int) (this.getHeight()/7);
		int x = (int)((this.getWidth() - width)/2);
		int y = (int)((this.getHeight() - height)/2);
		ActionListener startButtonListener = new StartButtonListener();
		startButton = new JButton("Start");
		createButton(startButton, startButtonListener, width, height, x, y);
		//settings button
		width = (int) (this.getWidth()/9);
		height = (int) (this.getHeight()/9);
		x = (int)((this.getWidth() - width)/2);
		y = startButton.getY() + startButton.getHeight() + height;
		ActionListener settingsButtonListener = new SettingsButtonListener();
		settingsButton = new JButton("Settings");
		createButton(settingsButton, settingsButtonListener, width, height, x, y);
		
		welcomeLabel = new JLabel("Hello! You are in Denis game :-). Press ENTER to start...");
		welcomeLabel.setBounds(startButton.getX() - settingsButton.getWidth(), startButton.getY(), width*3, height);
		welcomeLabel.setVisible(false);
		mainPanel.add(welcomeLabel);
		
		add(mainPanel);
	}
	
	private void createButton(JButton button, ActionListener listener, int width, int height, int xCoord, int yCoord) {
		button.setBounds(xCoord, yCoord, width, height);
		button.addActionListener(listener);
		mainPanel.add(button);
	}
	
	private class StartButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			startButton.setVisible(false);
			settingsButton.setVisible(false);
			welcomeLabel.setVisible(true);
			repaint();
//			try {
//				java.lang.Thread.sleep(5000);
//			} catch (InterruptedException e) {}
			//Application.startGame();
			
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
//	private void createStartButton() {
//		JButton startButton = new JButton("Start");
//		int buttonWidth = (int)frameWidth/7;
//		int buttonHeight = (int)frameHeight/7;
//		startButton.setBounds((int)((frameWidth - buttonWidth)/2), (int)((frameHeight - buttonHeight)/2), buttonWidth, buttonHeight);
//		mainPanel.add(startButton);
//	}
//	
//	private void createSettingsButton() {
//		JButton settingsButton = new JButton("Settings");
//		int buttonWidth = (int)frameWidth/9;
//		int buttonHeight = (int)frameHeight/8;
//		settingsButton.setBounds((int)((frameWidth - buttonWidth)/2), (int)((frameHeight - buttonHeight)/2), buttonWidth, buttonHeight);
//		mainPanel.add(settingsButton);
//	}
		
}
