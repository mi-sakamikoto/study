package work002;

/**
 * 贷款储蓄账户类
 */
public class LoanSavingAccount extends SavingAccount implements Loan {

	/** 贷款金额 */
	private double loanamount;
	/** 已还金额 */
	private double repay;

	/**
	 * 无参构造
	 */
	public LoanSavingAccount() {
	}

	/**
	 * 有参构造
	 *
	 * @param password   密码
	 * @param name       姓名
	 * @param personId   身份证号
	 */
	public LoanSavingAccount(String password, String name, String personId) {
		super(password, name, personId);
	}

	/**
	 * 取款
	 * @param withdrawNum 取款金额
	 */
	@Override
	public void withdraw(double withdrawNum) {
		double money = getBalance() - withdrawNum;
		//判断余额是否大于0
		if (money >= 0) {
			setBalance(money);
			System.out.println("取款成功,余额为:" + getBalance());
		} else {
			System.out.println("余额不足，余额为:" + getBalance());
		}
	}

	/**
	 * @inheritDoc 贷款
	 */
	@Override
	public void requsetLoan(double requsetLoanMonet) {
		loanamount += requsetLoanMonet;
		System.out.println("贷款成功，金额:" + loanamount + "。账户余额:" + getBalance());
	}

	/**
	 * @inheritDoc 还贷
	 */
	@Override
	public void payLoan(double payLoanmoney) {
		double money = payLoanmoney- loanamount;
		double amountMoney = Math.abs(money);
		//判断输入的还贷金额是否大于贷款金额
		if (money < 0){
			//判断还的钱是否大于账户余额
			if(payLoanmoney <= getBalance()){
				setBalance(getBalance() - payLoanmoney);
				loanamount = amountMoney;
				System.out.println("还贷成功，剩余贷款为:" + loanamount + "。账户剩余金额为:" + getBalance());
			//还贷的钱大于账户余额
			} else {
				System.out.println("还贷失败，账户余额不足,账户余额为:" + getBalance());
			}
		//还贷金额大于贷款金额
		} else {
			//判断还的钱是否大于账户余额
			if(payLoanmoney <= getBalance()){
				setBalance(getBalance() - loanamount);
				loanamount = 0.0;
				System.out.println("还贷成功，账户剩余金额为:" + getBalance());
				//还贷的钱大于账户余额
			} else {
				System.out.println("还贷失败，账户余额不足,账户余额为:" + getBalance());
			}
		}

	}

	/**
	 * @inheritDoc 贷款总额
	 */
	@Override
	public void getLoan() {
		System.out.println("贷款总额为:" + loanamount);
	}

	public double getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(double loanamount) {
		this.loanamount = loanamount;
	}

	public double getRepay() {
		return repay;
	}

	public void setRepay(double repay) {
		this.repay = repay;
	}
}
