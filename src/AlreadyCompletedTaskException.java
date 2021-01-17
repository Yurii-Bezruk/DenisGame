
public class AlreadyCompletedTaskException extends Exception {
	private static final long serialVersionUID = -7504285221131232605L;
	@Override
	public void printStackTrace() {
		System.err.println("This task is already completed!");
		super.printStackTrace();
	}
}
