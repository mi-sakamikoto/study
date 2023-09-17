package work002;

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
	 * @param password 密码
	 * @param name 姓名
	 * @param personId 身份证号
	 */
	public SavingAccount(String password, String name, String personId) {
		super(password, name, personId);
	}



	/**
	 * 取款
	 *
	 */
	public void withdraw(double withdrawNum) {
		double money = getBalance() - withdrawNum;
		//判断余额是否大于0
		if (money >= 0) {
			setBalance(money);
			System.out.println("取款成功,余额为:" + getBalance());
		} else {
			System.out.println("余额不足，余额为:" + getBalance());
		}
	}
}
