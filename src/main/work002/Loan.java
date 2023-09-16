package work002;

public interface Loan {
	/**
	 * 贷款
	 */
	void requsetLoan(double requsetLoanMonet);

	/**
	 * 还贷
	 */
	void payLoan(double payLoanmoney);

	/**
	 * 获取用户贷款总额
	 */
	void getLoan();
}
