package work001;

/**
 * 储蓄账户类
 *
 * @author FYB
 */
public class SavingAccount extends Account {
	/**
	 * 无参构造
	 */
	public SavingAccount() {
	}

	/**
	 * 有参构造
	 */
	public SavingAccount(String password, String name, String personId, String idType) {
		super(password, name, personId, idType);
	}

	/**
	 * 存款
	 *
	 * @param depositNum 存款金额
	 */
	public void deposit(double depositNum) {
		super.deposit(depositNum);
	}

	/**
	 * 取款
	 *
	 * @param withdrawNum 取款金额
	 */
	public void withdraw(double withdrawNum) {
		super.withdraw(withdrawNum);
	}
}
