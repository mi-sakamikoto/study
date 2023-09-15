package work001;

/**
 * 账户类
 *
 * @author FYB
 */
public class Account {

	/** 账户号码 */
	private long id;
	private static long number = 0;
	/** 账户密码 */
	private String password;
	/** 真实姓名 */
	private String name;
	/** 身份证号码 */
	private String personId;
	/** 类型 */
	private String idType;
	/** 账户余额 */
	private double balance;

	/**
	 * 无参构造
	 */
	public Account() {
	}

	/**
	 * 有参构造
	 */
	public Account(String password, String name, String personId, String idType) {
		id = createNextId();
		this.password = password;
		this.name = name;
		this.personId = personId;
		this.idType = idType;
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
	public void deposit(double depositNum) {
		double money = balance + depositNum;
		System.out.println("存款成功,余额为:" + this.getBalance());
		this.setBalance(money);
	}

	/**
	 * 取款
	 *
	 * @param withdrawNum 取款金额
	 */
	public void withdraw(double withdrawNum) {
		double money = balance - withdrawNum;
		//判断余额是否大于0
		if (money >= 0) {
			this.setBalance(money);
		} else {
			System.out.print("余额不足，余额为:" + this.getBalance());
		}
	}

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

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
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
