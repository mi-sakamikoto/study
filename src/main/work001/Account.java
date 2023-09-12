package work001;

/**
 * 账户类
 * @author FYB
 */
public class Account {
	/** 属性 */
	/**
	 * 账户号码
	 */
	private long id;
	/**
	 * 账户密码
	 */
	private String password;
	/**
	 * 真实姓名
	 */
	private String name;
	/**
	 * 身份证号码
	 */
	private String personId;

	/**
	 * 类型
	 */
	private String idType;
	/**
	 * 账户余额
	 */
	private double balance;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	/**
	 * 无参构造
	 */
	public Account() {
	}

	/**
	 * 有参构造
	 */
	public Account(long id, String password, String name, String personId, String idType, double balance) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.personId = personId;
		this.idType = idType;
		this.balance = balance;
	}

	/**
	 * 只含balance构造
	 * @param balance 余额
	 */
	public Account(double balance) {
		this.balance = balance;
	}

	/**
	 * 存款
	 * @param depositNum 存款金额
	 */
	public void deposit(double depositNum) {
		double money = balance + depositNum;
		this.setBalance(money);
	}

	/**
	 * 取款
	 * @param withdrawNum 取款金额
	 */
	public void withdraw(double withdrawNum) {
		double money = balance - withdrawNum;
		if (money >= 0) {
			this.setBalance(money);
		} else {
			System.out.print("余额不足，");
		}
	}
}
