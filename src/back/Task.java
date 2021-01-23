package back;
import java.util.Objects;

public class Task {
	private boolean completed = false;
	private String taskText = "---";
	
	public boolean isCompleted() {
		return completed;
	}
	public boolean isBlank() {
		return taskText.equals("---");
	}
	public void complete() {
		completed = true;
	}
	public String getTaskText() {
		return taskText;
	}
	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}
	
	@Override
	public String toString() {
		return taskText + (completed ? " +" : " x");
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
