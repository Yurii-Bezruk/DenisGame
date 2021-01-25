package front;
import back.Player;
import back.PlayerWinSignal;
import back.Task;
import validation.ValidScanner;

public class Application {
	private static int MAX_TASK_COUNT = 10;			//общее количество заданий
	private static int TASK_COUNT = 3;			//сколько из них являются непустыми заданиями
	private static final double WIN_POINTS = MAX_TASK_COUNT;		//сколько нужно очков для победы
	private static double TASK_POINTS = WIN_POINTS / TASK_COUNT + 0.001;		//сколько очков даётся за выполненное задание
	private static double BLANK_POINTS = WIN_POINTS / (MAX_TASK_COUNT - TASK_COUNT)  + 0.001;	//сколько очков дается за пустое задание. 
	//очки рассчитаны таким образом, что выполнение всех заданий или выбивание всех пустых заданий приносит победу.
	
	private static Player player1;
	private static Player player2;
	private static ValidScanner scanner;
	
	public static void main(String[] args) {
		scanner = new ValidScanner(System.in);
		scanner.setValidMin(1);
		scanner.setValidMax(MAX_TASK_COUNT);
		
		player1 = new Player("Anna", MAX_TASK_COUNT);
		player2 = new Player("Yurii", MAX_TASK_COUNT);
		
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
		for(int i = 0; i < TASK_COUNT; i++) {
			System.out.println("Enter number of task:");
			int number;
			number = scanner.nextInt();
			System.out.println("Enter your task:");
			String task = scanner.nextLine();
			player.setTask(number, task);
		}
	}
	private static void doTask(Player player) throws PlayerWinSignal{		
		Player other;
		if(player.equals(player1))
			other = player2;
		else
			other = player1;
		
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
				player.appendPoints(BLANK_POINTS);
				break;
			}
			else {
				System.out.println("The Task is: "+task.getTaskText());
				System.out.println("Waiting for compliting..."
						+ " Press COMPLETE if task completed,"
						+ " or DENIAL if player denied.");
				if(scanner.next().equals("COMPLETE")) {
					task.complete();
					player.appendPoints(TASK_POINTS);
					break;
				}
				else 
					throw new PlayerWinSignal(other);				
			}			
		}while(true);		
		if(player.getPoints() >= WIN_POINTS) 
			throw new PlayerWinSignal(player);
		
	}
}
