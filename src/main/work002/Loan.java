package work002;

public interface Loan {
	/**
	 * 贷款
	 * @param requsetLoanMonet 贷款金额
	 */
	void requsetLoan (double requsetLoanMonet);

	/**
	 * 还贷
	 * @param payLoanmoney 还贷金额
	 */
	void payLoan(double payLoanmoney);

	/**
	 * 获取用户贷款总额
	 */
	void getLoan();
}
