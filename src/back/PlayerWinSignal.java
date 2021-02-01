package back;
/**
 * <p>
 * This class represents specific signal used in program to stop the game if some player wins.
 * Instance of this class throwing where player unlocked all blank tasks from other players'
 * task list, or completed all "real" tasks with task text (missions). {@code PlayerWinSignal}
 * object contains {@code Player} object, that represents the winner. This signal cannot be 
 * instantiated without a winner (simple constructor undefined).
 * </p>
 * <p>
 * As {@code Serializable}, this object contains auto-generated <i>serialVersionUID</i> field
 * for serializing its instance.
 * </p>
 * 
 * @author Yurii Bezruk
 * @version 1.0
 * @see back.Player
 */
public class PlayerWinSignal extends Throwable {
	private static final long serialVersionUID = -2982424155130395836L;
	private Player winner;
	
	/**
	 * Initializes a newly created {@code PlayerWinSignal} object with given {@code Player}
	 * object as a winner of the game.
	 * 
	 * @param player {@code Player} object, which represents the winner of the game.
	 * @see back.Player
	 */
	public PlayerWinSignal(Player player) {
		winner = player;
	}
	
	/**
	 * Returns {@code Player} object, which represents the winner of the game.
	 * @return winner of the game.
	 */
	public Player getWinner() {
		return winner;
	}
}