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
	 * 
	 * @return {@code true} if the task is completed, {@code false} otherwise. 
	 */
	public boolean isCompleted() {
		return completed;
	}
	
	/**
	 * Returns true if the type of task is blank (task without mission).
	 * 
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
	 * 
	 * @return {@code taskText value}
	 */
	public String getTaskText() {
		return taskText;
	}
	
	/**
	 * Sets task text by given string.
	 * 
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
	 * 
	 * @return string representation of task.
	 */
	@Override
	public String toString() {
		return taskText + (completed ? " +" : " -");
	}
	
	/**
	 * Returns the hash-code for object using {@link Objects#hash(Object...)} method.
	 * 
	 * @return hash-code for this Task object
	 * @see java.util.Objects#hash(Object...)
	 */
	@Override
	public int hashCode() {
		return Objects.hash(completed, taskText);
	}
	
	/**
	 * Returns {@code true} if the argument and this object are equal. Method is auto-generated
	 * using Eclipse IDE according to standards of equals() writing: comparing the links
	 * of object (object and parameter a the same object), checking whether parameter is
	 * {@code null}, comparing the classes and, eventually, fields, using 
	 * {@link Objects#equals(Object, Object)}.
	 * 
	 * @param obj an object to be compared with this task object for equality
	 * @return {@code true} if objects are equal, {@code false} otherwise.
	 * @see java.lang.Object#equals(Object)
	 * @see java.util.Objects#equals(Object, Object)
	 * @see java.lang.Class 
	 */
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
