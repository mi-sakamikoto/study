package work001;

import java.util.Scanner;

/**
 * 银行类
 * @author FYB
 */
public class Bank {

	static Account[] users = new Account[10];
	int num = 0;

	/**
	 * 将开户信息存到数组中
	 * @return 开户信息
	 */
	public static Account[] add(){
		for (int i = 0; i < users.length-1; i++){
			//？？？？？？
			//users[i] = account.getId() + account.getPassword() + account.getName() + account.getPersonId() + account.getIdType();
		}
		return users;
	}
	/**
	 * 用户开户
	 * @return Account对象
	 */
	public Account create(long id,String password,String repassword,String name,String personId,String idType){
		/**/
		if("".equals(repassword) || !repassword.equals(password)){
			System.out.println("确认密码错误,重新开户");
			//create(id,password,repassword,name,personId,idType);
		}else {
			// TODO
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
		// TODO
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
