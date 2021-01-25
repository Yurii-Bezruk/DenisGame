package back;

public final class Settings {
	public static String PLAYER_1_NAME = "Player 1";
	public static String PLAYER_2_NAME = "Player 2";
	public static int MAX_TASK_COUNT = 10;			//общее количество заданий
	public static int TASK_COUNT = 3;			//сколько из них являются непустыми заданиями
	public static double WIN_POINTS = MAX_TASK_COUNT;		//сколько нужно очков для победы
	public static double TASK_POINTS = evaluateTaskPoints();	//сколько очков даётся за выполненное задание
	public static double BLANK_POINTS = evaluateBlankPoints();	//сколько очков дается за пустое задание. 
	//очки рассчитаны таким образом, что выполнение всех заданий или выбивание всех пустых заданий приносит победу.
	
	public static void refresh() {
		WIN_POINTS = MAX_TASK_COUNT;	
		TASK_POINTS = evaluateTaskPoints();
		BLANK_POINTS = evaluateBlankPoints();
	}
	private static double evaluateTaskPoints() {
		return WIN_POINTS / TASK_COUNT + 0.001;
	}
	private static double evaluateBlankPoints() {
		return WIN_POINTS / (MAX_TASK_COUNT - TASK_COUNT)  + 0.001;
	}
}
