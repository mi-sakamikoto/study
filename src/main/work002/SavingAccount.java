package work002;

import work002.Exception.BalanceNotEnoughException;

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
	 * 管理员构造
	 * @param id 管理员id
	 * @param password 管理员密码
	 */
	public SavingAccount(long id,String password){
		super(id,password);
	}

	/**
	 * 取款
	 *
	 */
	public void withdraw(double withdrawNum) throws BalanceNotEnoughException {
		double money = getBalance() - withdrawNum;
		//判断余额是否大于0
		if (money >= 0) {
			setBalance(money);
			System.out.println("取款成功,余额为:" + getBalance());
		} else {
			//System.out.println("余额不足，余额为:" + getBalance());
			throw new BalanceNotEnoughException("余额不足");
		}
	}
}
