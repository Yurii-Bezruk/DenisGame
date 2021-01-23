package back;
import java.util.Objects;

/**
 * Represents the task, which can be completed by players. Default state:
 * uncompleted, task text: "---" (blank task). During the game, players can
 * establish task text how they want. If the task is blank,, and player choose
 * it, task change state to completed without doing some mission.
 * 
 * @author Yurii Bezruk
 * @version 1.0
 * @see back.Player
 */
public class Task {
	private boolean completed = false;
	private String taskText = "---";
	
	/**
	 * Returns the current task state.
	 * @return {@code true} if the task is completed, {@code false} otherwise. 
	 */
	public boolean isCompleted() {
		return completed;
	}
	
	/**
	 * Returns true if the type of task is blank (task without mission).
	 * @return {@code true} if the task is blank (task text equals "---"),
	 * {@code false} otherwise. 
	 */
	public boolean isBlank() {
		return taskText.equals("---");
	}
	
	/**
	 * Changes task state to <strong>completed</strong>
	 */
	public void complete() {
		completed = true;
	}
	
	/**
	 * Returns current task text (mission).
	 * @return {@code taskText value}
	 */
	public String getTaskText() {
		return taskText;
	}
	
	/**
	 * Sets task text by given string.
	 * @param taskText String, which should be set as current task text (mission).
	 */
	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}
	
	/**
	 * Returns the string representation of the {@code Task} object. The string includes
	 * task text and final symbol, which represents task state (+ if <strong>completed</strong>
	 * ; - otherwise), for example:
	 * 		"Play the guitar!) -"
	 * @return string representation of task.
	 */
	@Override
	public String toString() {
		return taskText + (completed ? " +" : " -");
	}
	@Override
	public int hashCode() {
		return Objects.hash(completed, taskText);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return completed == other.completed && Objects.equals(taskText, other.taskText);
	}	
}
