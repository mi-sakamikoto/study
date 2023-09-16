package work002;

/**
 * 贷款信用账户类
 */
public class LoanCreditAccount extends CreditAccount implements Loan{

	/** 贷款额度 */
	//暂时设置为2000
	private double loanable = 2000.0;
	/** 还贷金额 */
	private double repay;
	/** 贷款金额 */
	private double loanmoney;

	static boolean flag = true;
	/**
	 * 无参构造
	 */
	public LoanCreditAccount() {
	}

	/**
	 * 有参构造
	 * @param password 密码
	 * @param name 姓名
	 * @param personId 身份证号
	 * @param idType 开户类型
	 * @param balance 余额
	 * @param ceiled 已透支金额
	 * @param repay 还贷金额
	 * @param loanmoney 贷款金额
	 */
	public LoanCreditAccount(String password, String name, String personId, String idType, double balance, double ceiled, double repay,double loanmoney) {
		super(password, name, personId, idType, balance, ceiled);
		//this.loanable = loanable;
		this.repay = repay;
		this.loanmoney = loanmoney;
	}


	/**
	 * 贷款
	 * @param requsetLoanMonet 贷款金额
	 */
	@Override
	public void requsetLoan(double requsetLoanMonet) {
		//每个账号只能贷一次款，还完再贷
		if (flag){
			if (requsetLoanMonet <= loanable){
				System.out.println("贷款成功，贷款金额:" + requsetLoanMonet);
				setLoanmoney(requsetLoanMonet);
				flag = false;
			}
			else {
				System.out.println("超出贷款金额，最多贷款为:" + getLoanable());
			}
		}
		else {
			System.out.println("请先还款");
		}
	}

	/**
	 * 还贷
	 * @param repay 还贷金额
	 */
	///////////////////这方法有问题/////////////////////
	@Override
	public void payLoan(double repay) {
		//剩余贷款金额
		double remainMoney = loanmoney - repay;
		//判断是否还完
		if (remainMoney > 0){
			System.out.println("剩余应还贷款为:" + remainMoney);
			//从存款里挪钱
			withdraw(repay);
		} else if (remainMoney < 0) {
			System.out.println("还款应金额为:" + loanmoney + "剩余存入账户");
			withdraw(repay - loanmoney);
			flag = false;
		} else {
			System.out.println("已还完贷款");
			flag = true;
		}

	}

	@Override
	public void getLoan() {

	}

	public double getLoanable() {
		return loanable;
	}

	/*public void setLoanable(double loanable) {
		this.loanable = loanable;
	}*/

	public double getRepay() {
		return repay;
	}

	public void setRepay(double repay) {
		this.repay = repay;
	}

	public double getLoanmoney() {
		return loanmoney;
	}

	public void setLoanmoney(double loanmoney) {
		this.loanmoney = loanmoney;
	}
}
