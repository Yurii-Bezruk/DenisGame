
public class PlayerWinSignal extends Exception {
	private static final long serialVersionUID = -2982424155130395836L;
	private Player winner;
	
	public PlayerWinSignal(Player player) {
		winner = player;
	}
	
	public Player getWinner() {
		return winner;
	}
}
