package work001;

/**
 * 信用账户类
 *
 * @author FYB
 */
public class CreditAccount extends Account {
	/** 可透支额度 */
	private double ceiling;
	/** 已透支额度 */
	private double ceiled;

	/**
	 * 无参构造
	 */
	public CreditAccount() {
	}

	/**
	 * 有参构造
	 *
	 * @param ceiling 可透支金额
	 * @param ceiled  已透支金额
	 */
	public CreditAccount(double ceiling, double ceiled) {
		super();
		this.ceiling = ceiling;
		this.ceiled = ceiled;
	}

	/**
	 * 信用账户还款
	 *   还款和存款一样吗？还是说需要还款和重写Account的取款  一共2个方法
	 * @param amount 还款金额
	 */
	public void payCeil(double amount) {
		double money = getBalance() + amount;
		if (money < 0) {
			double amountMoney = Math.abs(money);
			System.out.println("还款成功，还剩透支金额:" + amountMoney);
		} else {
			System.out.println("还款成功，剩余金额:" + money);
		}
		setBalance(money);
	}

	/**
	 * 信用账户取款
	 *
	 * @param withdrawNum 取款金额
	 */
	public void withdraw(double withdrawNum) {
		double money = getBalance() - withdrawNum;
		if (money < 0) {
			double withdrawMoney = Math.abs(money);
			System.out.println("取款成功，透支金额:" + withdrawMoney);
		} else {
			System.out.println("取款成功，剩余金额:" + money);
		}
		setBalance(money);
	}

	/**
	 * set get
	 */
	public double getCeiling() {
		return ceiling;
	}

	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}

	public double getCeiled() {
		return ceiled;
	}

	public void setCeiled(double ceiled) {
		this.ceiled = ceiled;
	}
}
