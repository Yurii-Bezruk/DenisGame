
package front;
import back.*;
import validation.*;

public class Application {	
	private static Player player1;
	private static Player player2;
	private static ValidScanner scanner;
	
	public static void main(String[] args) {
		scanner = new ValidScanner(System.in);
		scanner.setValidMin(1);
		scanner.setValidMax(Settings.MAX_TASK_COUNT);
		
		Settings.PLAYER_1_NAME = "Yurii";
		Settings.PLAYER_2_NAME = "Anna";
		Settings.MAX_TASK_COUNT = 5;
		Settings.TASK_COUNT = 2;
		Settings.refresh();
		
		player1 = new Player(Settings.PLAYER_1_NAME, Settings.MAX_TASK_COUNT);
		player2 = new Player(Settings.PLAYER_2_NAME, Settings.MAX_TASK_COUNT);
		startGame();		
	}
	public static void startGame() {
		System.out.println("Hello! You are in Denis game :-). Press ENTER to start...");
		scanner.next();
		establishTasks(player1);
		establishTasks(player2);
		
		System.out.println("Game starting...");
		while(true) {
			try {
				doTask(player1);			
				doTask(player2);
			}catch(PlayerWinSignal signal) {
				System.out.println(signal.getWinner().getName()+" wins!!");
				break;
			}
		}
		player1.printTasks();
		player2.printTasks();
	}
	private static void establishTasks(Player player) {
		System.out.println(player.getName()+", enter your tasks: ");
		for(int i = 0; i < Settings.TASK_COUNT; i++) {
			System.out.println("Enter number of task:");
			int number;
			number = scanner.nextInt();
			System.out.println("Enter your task:");
			String task = scanner.nextLine();
			if(! player.getTask(number).isBlank()) {
				i--;
				System.out.print("You want overwrite previous task? Enter Y/N: ");
				String answer = scanner.next();
				if(answer.equals("Y") || answer.equals("y")) {
					System.out.println("Overwriting old task");					
				}
				else {
					continue;
				}
			}
			player.setTask(number, task);
		}
	}
	private static void doTask(Player player) throws PlayerWinSignal{		
		Player other = (player.equals(player1) ? player2 : player1);		
		
		System.out.println(player.getName()+", choose the task number:");
		int number;
		Task task;
		do {
			number = scanner.nextInt();
			task = other.getTask(number);
			if(task.isCompleted()) {
				System.out.println("This task is already completed! Try another:");
				continue;
			}
			else if(task.isBlank()) {
				System.out.println("The task is blank!))");
				task.complete();
				player.appendPoints(Settings.BLANK_POINTS);
				break;
			}
			else {
				System.out.println("The Task is: "+task.getTaskText());
				System.out.println("Waiting for compliting..."
						+ " Press COMPLETE if task completed,"
						+ " or DENIAL if player denied.");
				if(scanner.next().equals("COMPLETE")) {
					task.complete();
					player.appendPoints(Settings.TASK_POINTS);
					break;
				}
				else 
					throw new PlayerWinSignal(other);				
			}			
		}while(true);		
		if(player.getPoints() >= Settings.WIN_POINTS) 
			throw new PlayerWinSignal(player);
		
	}
}