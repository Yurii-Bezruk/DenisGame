package front;
import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import back.Settings;

public class TaskPanel extends JPanel {
	private static final long serialVersionUID = 1556441602606057108L;
	//private Rectangle frameBounds;
	//private JPanel[] taskPanels;
	private JTextField[] taskFields;
	private JLabel[] numberLabels;
	
	public TaskPanel() {}
	public TaskPanel(int x, int y, int width, int height, Rectangle frameDimension) {
		taskFields = new JTextField[Settings.MAX_TASK_COUNT];
		numberLabels = new JLabel[Settings.MAX_TASK_COUNT];		
		
		for (int i = 0; i < Settings.MAX_TASK_COUNT; i++) {
			taskFields[i] = new JTextField();
			taskFields[i].setBounds((int) frameDimension.getX() - width,
									(i+1) * (int)(this.getY() - height/1.05),
									(int)(width * 5.5),
									height / 4);

			numberLabels[i] = new JLabel((i+1)+".");	
			numberLabels[i].setBounds(taskFields[i].getX() - (int) (taskFields[i].getHeight() * 1.5),
									  taskFields[i].getY(),
									  width / 6,
									  height / 4);
		}
		
	}
	public JTextField[] getTextFields() {
		return taskFields;
	}
	public JLabel[] getLabels() {
		return numberLabels;
	}
	public Component[] getComponents() {
		java.util.List<Component> list = new java.util.ArrayList<>();
		for (JTextField field : taskFields) 
			list.add(field);
		for (JLabel label : numberLabels) 
			list.add(label);
		return list.toArray(new Component[list.size()]);
	}
//	private void addContent() {
//		for (int i = 0; i < Settings.MAX_TASK_COUNT; i++) {	
//			taskPanels[i].add(numberLabels[i]);
//			taskPanels[i].add(taskFields[i]);
//			
//		}
//		for (JPanel panel : taskPanels) 
//			this.add(panel);
//	}
//	private void removeContent() {
//		for (int i = 0; i < Settings.MAX_TASK_COUNT; i++) {
//			for (int j = 0; j < Settings.MAX_TASK_COUNT + 1; j++) {
//				taskPanels[i].remove(taskFields[i][j]);
//				if(j < Settings.MAX_TASK_COUNT)
//					taskPanels[i].remove(numberLabels[i][j]);
//			}
//		}
//		for (JPanel panel : taskPanels) 
//			this.remove(panel);
//	}
}
