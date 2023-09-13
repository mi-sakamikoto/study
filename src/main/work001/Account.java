package work001;

/**
 * 账户类
 *
 * @author FYB
 */
public class Account {

	/** 账户号码 */
	private static long id = 100000;
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
	public Account(String password, String name, String personId, String idType, double balance) {
		id += 1;
		this.password = password;
		this.name = name;
		this.personId = personId;
		this.idType = idType;
		this.balance = balance;
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
			System.out.print("余额不足，");
		}
	}

	public long getId() {
		return id;
	}

	/**
	 * TODO
	 *
	 * @return
	 */
	public void createNextId() {
		id += 1;
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
