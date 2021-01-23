package back;
import java.util.Arrays;
import java.util.Objects;

/**
 * 
 * @author Yurii Bezruk
 * @version 1.0
 */
public class Player {
	private Task[] tasks;
	private String name;
	private double points;
	
	public double getPoints() {
		return points;
	}

	public void appendPoints(double points) {
		this.points += points;
	}

	public Player(String name, int taskCount) {
		this.name = name;
		tasks = new Task[taskCount];
		for (int i = 0; i < tasks.length; i++)
			tasks[i] = new Task();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setTask(int number, String task) {
		tasks[number-1].setTaskText(task);
	}
	public Task getTask(int number) {
		return tasks[number-1];
	}
	public void printTasks() {
		System.out.println(name+" tasks state: ");
		for (int i = 0; i < tasks.length; i++) 
			System.out.println((i+1) + ". " + tasks[i]);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(tasks);
		result = prime * result + Objects.hash(name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;		
		if (obj == null) 
			return false;		
		if (getClass() != obj.getClass()) 
			return false;		
		Player other = (Player) obj;
		return Objects.equals(name, other.name) && Arrays.equals(tasks, other.tasks);
	}
}
