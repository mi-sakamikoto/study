package work001;

import java.util.Scanner;

/**
 * 银行类
 * @author FYB
 */
public class Bank {
	private work001.Account Account;
	static Account[] users = new Account[10];
	static Account account = new Account();
	int num = 0;

	/**
	 * 将开户信息存到数组中
	 * @return 开户信息
	 */
	public static Account[] add(){
		for (int i = 0; i < users.length-1; i++){
			//？？？？？？
			users[i] = account.getId() + account.getPassword() + account.getName() + account.getPersonId() + account.getIdType();
		}
		return users;
	}
	/**
	 * 用户开户
	 * @return Account对象
	 */
	public Account create(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入账户号码:");
		Long id = sc.nextLong();
		Scanner sc2 = new Scanner(System.in);
		System.out.println("请输入账户密码:");
		String password = sc2.nextLine();
		System.out.println("请输入确认密码:");
		String repassword = sc2.nextLine();
		System.out.println("请输入姓名:");
		String name = sc2.nextLine();
		System.out.println("请输入身份证号码:");
		String personId = sc2.nextLine();
		System.out.println("账户类型:");
		String idType = sc2.nextLine();
		if("".equals(repassword) || !repassword.equals(password)){
			System.out.println("确认密码错误,重新开户");
			this.create();
		}else {
			account.setId(id);
			account.setPassword(password);
			account.setName(name);
			account.setPersonId(personId);
			account.setIdType(idType);
			add();
		}
		return Account;
	}

	/**
	 * 用户登录
	 * @return Account对象
	 */
	public Account login(){

		return Account;
	}

	/**
	 * 用户存款
	 * @return Account 对象
	 */
	public Account deposit(){

		return Account;
	}

	/**
	 * 用户取款
	 * @return Account 对象
	 */
	public Account withdrawal(){

		return Account;
	}
}
