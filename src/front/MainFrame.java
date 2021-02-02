package front;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
import javax.xml.stream.events.StartDocument;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2269971701250845501L;
	private JPanel mainPanel = new JPanel();
	
	private int frameWidth;
	private int frameHeight;
	private JButton startButton;
	private JButton settingsButton;	
	
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		toFront();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = (int)(screenSize.width/1.5);
		frameHeight = (int)(screenSize.height/1.5);
		setSize(frameWidth, frameHeight);
		//establishing frame to center
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("MIR_FULL_DSC_3915.jpg").getImage());
		setTitle("DenisGame");
		setResizable(false);
		
		mainPanel.setLayout(null);
		
		addingContent();
		add(mainPanel);
		
		setVisible(true);
	}
	
	private void addingContent() {
		//start button
		int startButtonWidth = (int)frameWidth/7;
		int startButtonHeight = (int)frameHeight/7;
		int startXCoord = (int)((frameWidth - startButtonWidth)/2);
		int startYCoord = (int)((frameHeight - startButtonHeight)/2);
		createButton(startButton, "Start", startButtonWidth, startButtonHeight, startXCoord, startYCoord);
		//settings button
		int settingsButtonWidth = (int)frameWidth/9;
		int settingsButtonHeight = (int)frameHeight/9;
		int settingsXCoord = (int)((frameWidth - settingsButtonWidth)/2);
		int settingsYCoord = startYCoord + startButtonHeight + settingsButtonHeight;
		createButton(settingsButton, "Settings", settingsButtonWidth, settingsButtonHeight, settingsXCoord, settingsYCoord);
	}
	
	private void createButton(JButton button, String name, int width, int height, int xCoord, int yCoord) {
		button = new JButton(name);
		button.setBounds(xCoord, yCoord, width, height);
		mainPanel.add(button);
	}
	
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
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}
	
}

/*//Set the frame icon to an image loaded from a file.
 * Image img = new ImageIcon("*fileName*").getImage();
 * frame.setIconImage(new ImageIcon(imgURL).getImage());*/