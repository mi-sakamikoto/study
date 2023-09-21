package work002;

import work002.Exception.BalanceNotEnoughException;
import work002.Exception.LoanException;

public interface Loan {
	/**
	 * 贷款
	 * @param requsetLoanMonet 贷款金额
	 */
	void requsetLoan (double requsetLoanMonet) throws LoanException;

	/**
	 * 还贷
	 * @param payLoanmoney 还贷金额
	 */
	void payLoan(double payLoanmoney) throws BalanceNotEnoughException;

	/**
	 * 获取用户贷款总额
	 */
	void getLoan();
}
