package work002;

/**
 * 账户类
 *
 * @author FYB
 */
public abstract class Account {

	/** 账户号码 */
	private long id;
	private static long number = 10;
	/** 账户密码 */
	private String password;
	/** 真实姓名 */
	private String name;
	/** 身份证号码 */
	private String personId;
	/** 账户余额 */
	private double balance;

	/**
	 * 无参构造
	 */
	public Account() {
	}

	/**
	 * 有参构造
	 * @param password 密码
	 * @param name 姓名
	 * @param personId 身份证号
	 */
	public Account(String password, String name, String personId) {
		id = createNextId();
		this.password = password;
		this.name = name;
		this.personId = personId;
	}

	/**
	 * 管理员构造
	 * @param id 账号号码
	 * @param password 密码
	 */
	public Account(long id, String password){
		this.id = id;
		this.password = password;

	}

	/**
	 * 只含balance构造
	 *
	 * @param balance 余额
	 */
	public Account(double balance) {
		this.balance = balance;
	}

	/**
	 * 存款
	 *
	 * @param depositNum 存款金额
	 */
	public final void deposit(double depositNum) {
		balance += depositNum;
		System.out.println("存款成功,余额为:" + balance);
	}

	/**
	 * 取款
	 *
	 * @param withdrawNum 取款金额
	 */
	public abstract void withdraw(double withdrawNum);

	public long getId() {
		return id;
	}

	/**
	 * number自增
	 *
	 * @return number
	 */
	private long createNextId() {
		number += 1;
		return number;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
