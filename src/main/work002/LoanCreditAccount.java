package work002;

import work002.Exception.BalanceNotEnoughException;
import work002.Exception.LoanException;

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
		double ceilable = getCeiling() - getCeiled();  //还能再透支ceilable数额的钱
		double money = payLoanmoney- loanamount;  //money是判断还贷，还没还完
		double amountMoney = Math.abs(money);
		if (money < 0){
			//判断输入的还贷金额是否大于贷款金额(没还完)
			if(payLoanmoney < getBalance()){
				//判断还的钱是否大于账户余额
				setBalance(getBalance() - payLoanmoney);
				loanamount = amountMoney;
				System.out.println("还贷成功，剩余贷款为:" + loanamount + "。账户剩余金额为:" + getBalance() + "透支金额为:" + getCeiled());//余额有没有钱跟透支没关系
			} else if (payLoanmoney >= getBalance() &&  (payLoanmoney-getBalance()) <= ceilable){
				//还贷的钱大于账户余额，透支
				loanamount = amountMoney;
				setCeiled(payLoanmoney - getBalance() + getCeiled());
				setBalance(0.0);
				System.out.println("还贷成功，剩余贷款为:" + loanamount + "。账户余额为:0。透支金额为:" + getCeiled());
			} else {
				//还贷的钱大于账户余额，大于最大透支额度
				//System.out.println("还贷失败，账户余额不足并且大于最大可透支额度");
				throw new BalanceNotEnoughException("还贷失败，账户余额不足并且大于最大可透支额度");
			}
		} else {
			//还贷金额大于贷款金额(还完了)
			if(payLoanmoney <= getBalance()){
				//判断还的钱是否大于账户余额
				setBalance(getBalance() - loanamount);
				loanamount = 0.0;
				System.out.println("还贷成功。账户剩余金额为:" + getBalance() + "透支金额为:" + getCeiled());//余额有没有钱跟透支没关系
			} else if (loanamount > getBalance() && loanamount <= ceilable){
				//还贷的钱大于账户余额，透支(账户原来有钱)
				//还完之后，无论输入还款多少，还的其实都是贷款的数额，因为处在还完的分支下
				setCeiled(loanamount - getBalance() + getCeiled());
				System.out.println("还贷成功。账户余额为:0。透支金额为:" + getCeiled());
				setBalance(0.0);
				loanamount = 0.0;
			} else {
				//还贷的钱大于账户余额，大于最大透支额度
				//System.out.println("还贷失败，账户余额不足并且大于最大可透支额度");
				throw new BalanceNotEnoughException("还贷失败，账户余额不足并且大于最大可透支额度");
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


