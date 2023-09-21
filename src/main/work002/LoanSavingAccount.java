package work002;

import work002.Exception.BalanceNotEnoughException;
import work002.Exception.LoanException;

/**
 * 贷款储蓄账户类
 */
public class LoanSavingAccount extends SavingAccount implements Loan {

	/** 贷款金额 */
	private double loanamount;

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
	 * @inheritDoc 贷款
	 */
	@Override
	public void requsetLoan(double requsetLoanMonet) throws LoanException {
		if (requsetLoanMonet >=0 ){
			loanamount += requsetLoanMonet;
			System.out.println("贷款成功，金额:" + loanamount + "。账户余额:" + getBalance());
		} else {
			throw new LoanException("贷款额不能是负数");
		}
	}

	/**
	 * @inheritDoc 还贷
	 */
	@Override
	public void payLoan(double payLoanmoney) throws BalanceNotEnoughException {
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
				//System.out.println("还贷失败，账户余额不足,账户余额为:" + getBalance());
				throw new BalanceNotEnoughException("还贷失败，账户余额不足");
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
				//System.out.println("还贷失败，账户余额不足,账户余额为:" + getBalance());
				throw new BalanceNotEnoughException("还贷失败，账户余额不足");
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

}
