package work001;

/**
 * 银行类
 *
 * @author FYB
 */
public class Bank {
	private Account[] users = new Account[10];
	private int num = 0;

	/**
	 * 用户开户
	 *
	 * @return Account对象
	 */
	public Account create(String password, String repassword, String name, String personId, String idType) {
		Account account = null;
		//判断确认密码是否为空及是否正确
		if ("".equals(repassword) || !repassword.equals(password)) {
			System.out.println("确认密码错误,重新开户");
		} else {
			account = new Account(password, name, personId, idType);
			account.setPassword(password);
			account.setName(name);
			account.setPersonId(personId);
			account.setIdType(idType);
			users[num] = account;
			num++;
		}
		return account;
	}

	/**
	 * 用户登录
	 *
	 * @return Account对象
	 */
	public Account login(Long id, String password) {
		Account account = null;
		for (int i = 0; i < num; i++) {
			//判断用户id与用户密码
			if (id == users[i].getId() && password.equals(users[i].getPassword())) {
				account = users[i];
				System.out.println("登录成功");
				break;
			}
		}
		if (account == null) {
			System.out.println("用户id或密码错误");
		}
		return account;
	}

	/**
	 * 用户存款
	 *
	 * @return Account 对象
	 */
	public Account deposit(Account account,double depositNum) {
		/*account.deposit(depositNum);*/
		account.deposit(depositNum);
		return account;
	}

	/**
	 * 用户取款
	 *
	 * @return Account 对象
	 */
	public Account withdraw(Account account, double withdrawNum) {
		/*account.withdraw(withdrawNum)*/;
		return null;
	}

	/**
	 * 计算所有用户的余额
	 */
	public void count() {
		double money = 0.0;
		for (int i = 0; i < num; i++) {
			money += users[i].getBalance();
		}
	}
}
