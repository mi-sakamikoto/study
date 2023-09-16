package work002;

/**
 * 贷款储蓄账户类
 */
public class LoanSavingAccount extends  SavingAccount implements Loan{

	/**
	 * 无参构造
	 */
	public LoanSavingAccount() {
	}

	/**
	 * 有参构造
	 * @param password 密码
	 * @param name 姓名
	 * @param personId 身份证号
	 * @param idType 类型
	 * @param balance 余额
	 */
	public LoanSavingAccount(String password, String name, String personId, String idType, double balance) {
		super(password, name, personId, idType, balance);
	}

	@Override
	public void requsetLoan(double requsetLoanMonet) {

	}

	@Override
	public void payLoan(double payLoanmone) {

	}

	@Override
	public void getLoan() {

	}
}
