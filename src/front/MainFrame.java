package front;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import back.Settings;


public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2269971701250845501L;
	private JPanel mainPanel;
	private JButton startButton;
	private JButton settingsButton;
	private JLabel welcomeLabel;
	private TaskPanel taskPanel;
	
	//private JPanel[] taskPanels;
//	private JTextField[] taskFields;
//	private JLabel[] numberLabels;
	
	
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
		mainPanel = new MainPanel() ;
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
	private void addTaskPanel(TaskPanel panel) {
		for (JTextField field : panel.getTextFields()) {
			mainPanel.add(field);
		}
		for (JLabel label : panel.getLabels()) {
			mainPanel.add(label);
		}
	}
	private class MainPanel extends JPanel{
		private static final long serialVersionUID = 7297869661769714605L;
		
		public void add(TaskPanel panel) {
//			for (Component component : panel.getComponents()) {
//				this.add(component);
//			}
			for (JTextField field : panel.getTextFields()) {
				this.add(field);
			}
			for (JLabel label : panel.getLabels()) {
				this.add(label);
			}
		}
		
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
			//welcomeLabel = new JLabel("Enter "+Settings.TASK_COUNT+" tasks, other will be blank:");
//			welcomeLabel.setBounds(taskFields[0].getWidth() / 2,
//								   taskFields[0].getY() - (int) (taskFields[0].getHeight() * 1.5),
//								   taskFields[0].getWidth(),
//								   taskFields[0].getHeight());
			
			//mainPanel.add(welcomeLabel);
//			for (int i = 0; i < Settings.MAX_TASK_COUNT; i++) {	
//				mainPanel.add(taskFields[i]);
//				mainPanel.add(numberLabels[i]);
//			}
			//mainPanel.add(taskPanel);
			taskPanel = new TaskPanel(startButton.getX(), startButton.getY(), startButton.getWidth(), startButton.getHeight(), MainFrame.this.getBounds());
			addTaskPanel(taskPanel);
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
}
