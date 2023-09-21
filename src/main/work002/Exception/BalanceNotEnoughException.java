package work002.Exception;

public class BalanceNotEnoughException extends Exception{
	public BalanceNotEnoughException() {
	}

	public BalanceNotEnoughException(String message) {
		super(message);
	}
}
