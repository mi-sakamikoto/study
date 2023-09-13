package work001;

/**
 * 银行类
 * @author FYB
 */
public class Bank {
	static Account[] users = new Account[10];
	static int num = 0;
	public static long id = 100000;

	/**
	 * 用户开户
	 * @return Account对象
	 */
	public Account create(String password,String repassword,String name,String personId,String idType){
		Account account = null;
		//判断确认密码是否为空及是否正确
		if("".equals(repassword) || !repassword.equals(password)){
			System.out.println("确认密码错误,重新开户");
		}else {
			account = new Account();
			account.setId(id++);
			System.out.println(account.getId());
			account.setPassword(password);
			account.setName(name);
			account.setPersonId(personId);
			account.setIdType(idType);
			users[num] = account;
			num++;
			System.out.println("开户成功");
		}
		return account;
	}

	/**
	 * 用户登录
	 * @return Account对象
	 */
	public Account login(Long id,String password){
		Account account = new Account();
		boolean flag = true;
		while (flag){
			for (int i = 0; i < num; i++){
				//判断用户id与用户密码
				if (id == users[i].getId() && password.equals(users[i].getPassword())){
					System.out.println("登录成功");
					flag = false;
				}
			}break;
		}
		if(flag){
			System.out.println("用户id或密码错误");
		}
		return account;
	}

	/**
	 * 用户存款
	 * @return Account 对象
	 */
	public Account deposit(Long id,double deposit){
		double money = 0.0;
		Account account = new Account();
		boolean flag = true;
		while (flag){
			for (int i = 0; i < num; i++){
				//判断用户id
				if (id == users[i].getId()){
					money = users[i].getBalance() + deposit;
					users[i].setBalance(money);
					System.out.println("存款成功，余额为:" + users[i].getBalance());
					flag = false;
				}
			}
			break;
		}
		if (flag){
			System.out.println("用户id错误");
		}
		return account;
	}

	/**
	 * 用户取款
	 * @return Account 对象
	 */
	public Account withdrawNum(Long id,double withdrawNum){
		double money = 0.0;
		Account account = new Account();
		boolean flag = true;
		while (flag){
			for (int i = 0; i < num; i++){
				//判断用户id
				if (id == users[i].getId()){
					money = users[i].getBalance() - withdrawNum;
					//判断余额是否大于0
					if (money > 0){
						users[i].setBalance(money);
						System.out.println("取款成功，余额为:" + users[i].getBalance());
					}else {
						System.out.println("取款失败，余额不足，余额为:" + users[i].getBalance());
					}
					flag = false;
				}
			}break;
		}
		if (flag){
			System.out.println("用户id错误");
		}
		return account;
	}
}
