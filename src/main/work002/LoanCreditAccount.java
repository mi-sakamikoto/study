package work002;

/**
 * 贷款信用账户类
 */
public class LoanCreditAccount extends CreditAccount implements Loan {

	/** 贷款金额 */
	private double loanamount;

	/**
	 * 无参构造
	 */
	public LoanCreditAccount() {
	}

	/**
	 * 有参构造
	 */
	public LoanCreditAccount(String password, String name, String personId) {
		super(password, name, personId);
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
		double ceilable = getCeiling() - getCeiled();
		double money = payLoanmoney- loanamount;
		double amountMoney = Math.abs(money);
		//判断输入的还贷金额是否大于贷款金额(没还完)
		if (money < 0){
			//判断还的钱是否大于账户余额
			if(payLoanmoney < getBalance()){
				setBalance(getBalance() - payLoanmoney);
				loanamount = amountMoney;
				System.out.println("还贷成功，剩余贷款为:" + loanamount + "。账户剩余金额为:" + getBalance());
				//还贷的钱大于账户余额，透支
			} else if (payLoanmoney >= getBalance() &&  (payLoanmoney-getBalance()) <= ceilable){
				loanamount = amountMoney;
				setCeiled(payLoanmoney + getCeiled());
				System.out.println("还贷成功，剩余贷款为:" + loanamount + "。账户余额为:0。透支金额为:" + (payLoanmoney - getBalance()));
				setBalance(0.0);
				//还贷的钱大于账户余额，大于最大透支额度
			} else {
				System.out.println("还贷失败，账户余额不足并且大于最大可透支额度");
			}
			//还贷金额大于贷款金额(还完了)
		} else {
			//判断还的钱是否大于账户余额
			if(payLoanmoney <= getBalance()){
				setBalance(getBalance() - loanamount);
				loanamount = 0.0;
				System.out.println("还贷成功。账户剩余金额为:" + getBalance());
				//还贷的钱大于账户余额，透支
			} else if (payLoanmoney > getBalance() &&  payLoanmoney <= ceilable){
				System.out.println("还贷成功。账户余额为:0。透支金额为:" + (loanamount - getBalance()));
				setCeiled(getCeiled() + loanamount -getBalance());
				setBalance(0.0);
				loanamount = 0.0;
				//还贷的钱大于账户余额，大于最大透支额度
			} else {
				System.out.println("还贷失败，账户余额不足并且大于最大可透支额度");
			}
		}

	}

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
}
