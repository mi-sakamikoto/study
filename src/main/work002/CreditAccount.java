package work002;

/**
 * 信用账户类
 *
 * @author FYB
 */
public class CreditAccount extends Account {
	/** 可透支额度 */
	//暂时设置为3000
	private double ceiling = 3000.0;
	/** 已透支额度 */
	private double ceiled;

	/**
	 * 无参构造
	 */
	public CreditAccount() {
	}

	/**
	 * 有参构造
	 * @param password 密码
	 * @param name 姓名
	 * @param personId 身份证号
	 * @param idType 类型
	 * @param ceiled 已透支金额
	 */
	public CreditAccount(String password, String name, String personId, String idType, double balance, double ceiled) {
		super(password, name, personId, idType, balance);
		this.ceiled = ceiled;
	}

	/**
	 * 存款
	 */
	public void deposit() {
	}

	/**
	 * 取款
	 * @param withdrawNum 取款金额
	 */
	public void withdraw(double withdrawNum){
		double ceilable = getCeiling() - getCeiled();
		double money = getBalance() - withdrawNum;
		//余额够用
		if (money >= 0){
			System.out.println("取款成功，剩余金额:" + money);
			setBalance(money);
		}
		//透支
		else {
			double withdrawMoney = Math.abs(money); //透支的钱
			//透支额度够用,判断第一次取款是否直接大于额度
			if (withdrawMoney <= getCeiling() && withdrawMoney <= ceilable){
				System.out.println("取款成功，透支金额:" + withdrawMoney);
				setBalance(0.0);
				setCeiled(withdrawMoney);
			}
			//透支额度不够
			else {
				System.out.println("取款失败，超出可透支额度");
			}
		}
	}


	/**
	 * 还款
	 *
	 * @param amount 还款金额
	 */
	public void payCeil(double amount) {
		double money = amount - getCeiled();
		//判断还完款后是否仍然欠款
		if (money < 0) {
			double amountMoney = Math.abs(money);
			System.out.println("还款成功，目前透支金额:" + amountMoney);
			setCeiled(amountMoney);
		} else {
			setBalance(money);
			System.out.println("还款成功，剩余金额:" + getBalance());
			setCeiled(0.0);
		}
		setBalance(money);
	}

	/**
	 * set get
	 */
	public double getCeiling() {
		return ceiling;
	}

	/*public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}*/

	public double getCeiled() {
		return ceiled;
	}

	public void setCeiled(double ceiled) {
		this.ceiled = ceiled;
	}
}
