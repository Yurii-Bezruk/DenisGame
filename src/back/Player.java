package back;
import java.util.Arrays;
import java.util.Objects;

/**
 * Represents the player, who is playing in this game. Player have his name, tasks and points.
 * First player who gains the number of points required to win, wins. 
 * 
 * @author Yurii Bezruk
 * @version 1.0
 * @see back.Task
 * @see back.PlayerWinSignal
 */
public class Player {
	private Task[] tasks;
	private String name;
	private double points;	

	/**
	 * Initializes a newly created {@code Player} object with given player's name and task count.
	 * All {@code Task} object initiating here with simple constructor.
	 * 
	 * @param name name for new player.
	 * @param taskCount number of tasks for new player.
	 */
	public Player(String name, int taskCount) {
		this.name = name;
		tasks = new Task[taskCount];
		for (int i = 0; i < tasks.length; i++)
			tasks[i] = new Task();
	}
	
	/**
	 * Return player's current point count.
	 * 
	 * @return player's points.
	 */
	public double getPoints() {
		return points;
	}
	
	/**
	 * Appends given points to this player's points. 
	 * 
	 * @param points point to be appended to player's ones.
	 */
	public void appendPoints(double points) {
		this.points += points;
	}
	
	/**
	 * Return player's current name.
	 * 
	 * @return player's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets specific player's name for this {@code Player} object.
	 * 
	 * @param name name to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets task text (mission) to given number of player's tasks, which is index+1 in tasks array.
	 * Since all {@code Task} objects already have been created, this method just setting task text
	 * to already existing task (usually blank), which have index equal to (its number)-1.
	 * 
	 * @param number number of task, which is index+1 in {@code Player} tasks array.
	 * @param task task text (mission) to be set for given task.
	 */
	public void setTask(int number, String task) {
		tasks[number-1].setTaskText(task);
	}
	
	/**
	 * Returns {@code Task} object, which is at the specific number in player's tasks, which is index+1
	 * in {@code Task}'s array of this {@code Player} object. 
	 * 
	 * @param number number of task to be returned.
	 * @return {@code Task} object which is at the specific number in player's tasks. 
	 */
	public Task getTask(int number) {
		return tasks[number-1];
	}
	
	/**
	 * Utility method for printing all player's tasks' state using overridden method Task.toString()
	 * such as:				<br>
	 * 1. Play the guitar + <br>
	 * 2. --- -				<br>
	 * 3. Sing some song -  <br> 
	 * 4. --- + 			<br>
	 * 5. ...				<br>
	 * ...
	 */
	public void printTasks() {
		System.out.println(name+" tasks state: ");
		for (int i = 0; i < tasks.length; i++) 
			System.out.println((i+1) + ". " + tasks[i]);
	}
	
	/**
	 * Returns the hash-code for this {@code Player} object using methods {@link Objects#hash(Object...)},
	 * and {@link Arrays#hashCode(Object[])}
	 * 
	 * @return hash-code for this Player object
	 * @see java.util.Objects#hash(Object...)
	 * @see java.util.Arrays#hashCode(Object[])
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(tasks);
		result = prime * result + Objects.hash(name);
		return result;
	}
	
	/**
	 * Returns {@code true} if the argument and this object are equal. Method is auto-generated
	 * using Eclipse IDE according to standards of equals() writing: comparing the links
	 * of object (object and parameter a the same object), checking whether parameter is
	 * {@code null}, comparing the classes and, eventually, fields, using 
	 * {@link Objects#equals(Object, Object)} and {@link Arrays#equals(Object[], Object[])}.
	 * 
	 * @param obj an object to be compared with this player object for equality.
	 * @return {@code true} if objects are equal, {@code false} otherwise.
	 * @see java.lang.Object#equals(Object)
	 * @see java.util.Objects#equals(Object, Object)
	 * @see java.util.Arrays#equals(Object[], Object[])
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
		Player other = (Player) obj;
		return Objects.equals(name, other.name) && Arrays.equals(tasks, other.tasks);
	}
}