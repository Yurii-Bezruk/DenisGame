package front;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import back.Settings;

public class TaskPanel extends JPanel {
	private static final long serialVersionUID = 1556441602606057108L;
	private JTextField[] taskFields;
	private JLabel[] numberLabels;
	
	public TaskPanel() {}
	public TaskPanel(Rectangle startButtonDimension, Rectangle frameDimension) {
		taskFields = new JTextField[Settings.MAX_TASK_COUNT];
		numberLabels = new JLabel[Settings.MAX_TASK_COUNT];		
		
		for (int i = 0; i < Settings.MAX_TASK_COUNT; i++) {
			taskFields[i] = new JTextField();
			taskFields[i].setBounds((int) (frameDimension.getX() - startButtonDimension.getWidth()),
									(i+1) * (int)(frameDimension.getY() - startButtonDimension.getHeight()/1.05),
									(int) (startButtonDimension.getWidth() * 5.5),
									(int) (startButtonDimension.getHeight() / 4));

			numberLabels[i] = new JLabel((i+1)+".");	
			numberLabels[i].setBounds(taskFields[i].getX() - (int) (taskFields[i].getHeight() * 1.5),
									  taskFields[i].getY(),
									  (int) startButtonDimension.getWidth() / 6,
									  (int) startButtonDimension.getHeight() / 4);
		}
		
	}
	public Component[] getComponents() {
		java.util.List<Component> list = new java.util.ArrayList<>();
		for (JTextField field : taskFields) 
			list.add(field);
		for (JLabel label : numberLabels) 
			list.add(label);
		return list.toArray(new Component[list.size()]);
	}
}
