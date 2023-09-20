package work002;

/**
 * 银行类
 *
 * @author FYB
 */
public class Bank {

	private static Bank bank = null;

	//私有构造
	private Bank(){
	}
	public static Bank bankCreate(){
		if (bank == null){
			bank = new Bank();
		}
		return bank;
	}
	private Account[] users = new Account[10];
	private int num = 0;

	double money = 0.0;

	/**
	 * 用户开户
	 * @param password 密码
	 * @param repassword 确认密码
	 * @param name 姓名
	 * @param personId 身份证号
	 * @param idType 账户类型
	 * @return 用户账户
	 */
	public Account create(String password, String repassword, String name, String personId, int idType) {
		Account account = null;
		//判断确认密码是否为空及是否正确
		if ("".equals(repassword) || !repassword.equals(password)) {
			System.out.println("确认密码错误,重新开户");
		} else {
			switch (idType) {
				case 0:
					account = new SavingAccount(password, name, personId);
					account.setPassword(password);
					account.setName(name);
					account.setPersonId(personId);

					break;
				case 1:
					account = new CreditAccount(password, name, personId);
					account.setPassword(password);
					account.setName(name);
					account.setPersonId(personId);

					break;
				case 2:
					account = new LoanSavingAccount(password, name, personId);
					account.setPassword(password);
					account.setName(name);
					account.setPersonId(personId);

					break;
				case 3:
					account = new LoanCreditAccount(password, name, personId);
					account.setPassword(password);
					account.setName(name);
					account.setPersonId(personId);

					break;
				default:
					System.out.println("输出错误，请重新输入");
			}
			users[num] = account;
			num++;
		}
		return account;
	}

	/**
	 * 用户登录
	 *
	 * @return Account对象
	 */
	public Account login(Long id, String password) {
		Account account = null;
		for (int i = 0; i < num; i++) {
			//判断用户id与用户密码
			if (id == users[i].getId() && password.equals(users[i].getPassword())) {
				account = users[i];
				break;
			}
		}
		if (account == null) {
			System.out.println("用户id或密码错误");
		}
		return account;
	}

	/**
	 * 创建管理员
	 * @param id 1
	 * @param password admin
	 * @return 创建好的管理员
	 */
	public Account loginAdmin(long id,String password){
		Account adminAcc = new SavingAccount(id,password);
		return adminAcc;
	}

	/**
	 * 贷款
	 * @param id 用户id
	 * @param requsetLoanMonet 贷款金额
	 * @return 执行完贷款的用户
	 */
	public Account adminrequsetLoan(long id, double requsetLoanMonet){
		Account account = null;
		for (int i = 0;i < num; i++){
			if (id == users[i].getId() && users[i] instanceof Loan){
				//判断用户id及是否为贷款用户
				((Loan)account).requsetLoan(requsetLoanMonet);
			} else {
				System.out.println("用户不存在");
			}
		}

		return account;
	}

	/**
	 * 还贷
	 * @param id 用户id
	 * @param payLoanmoney 还贷金额
	 * @return 执行完还贷的用户
	 */
	public Account adminpayLoan(long id,double payLoanmoney){
		Account account = null;
		for (int i = 0;i < num; i++){
			if (id == users[i].getId() && users[i] instanceof LoanSavingAccount){
				//判断用户id及是否为储蓄贷款用户
				((Loan)account).payLoan(payLoanmoney);
			} else if (id == users[i].getId() && users[i] instanceof LoanCreditAccount) {
				//判断用户id及是否为信用贷款用户
				((Loan)account).payLoan(payLoanmoney);
			} else {
				System.out.println("用户不存在");
			}
		}
		return account;
	}

	/**
	 * 计算所有用户的余额
	 * @return 总余额
	 */
	public double count() {
		for (int i = 0; i < num; i++) {
			money += users[i].getBalance();
		}
		return money;
	}

	/**
	 * 计算所有贷款金额
	 * @return 贷款总金额
	 */
	public double countLoan(){
		double allLoan1 = 0.0;
		double allLoan2 = 0.0;
		for (int i = 0; i < num; i++) {
			if (users[i] instanceof LoanSavingAccount){
				allLoan1 += ((LoanSavingAccount)users[i]).getLoanamount();
			}
			if (users[i] instanceof LoanCreditAccount){
				allLoan2 += ((LoanCreditAccount)users[i]).getLoanamount();
			}
			money = allLoan1 + allLoan2;
		}
		return money;
	}

	/**
	 * 计算所有透支金额
	 * @return 透支总金额
	 */
	public double countceiled(){
		double allceiled1 = 0.0;
		double allceiled2 = 0.0;
		for (int i = 0; i < num; i++) {
			if (users[i] instanceof CreditAccount){
				allceiled1 += ((CreditAccount)users[i]).getCeiled();
			}
			if (users[i] instanceof LoanCreditAccount){
				allceiled2 = ((LoanCreditAccount)users[i]).getCeiled();
			}
			money = allceiled1 + allceiled2;
		}
		return money;
	}

	/**
	 * 设置透支额度
	 * @param id 用户id
	 * @param loanamount 透支额度
	 * @return 设置完额度的用户
	 */
	public Account resetLoanamount(long id,double loanamount){
		Account account = null;
		for (int i = 0; i < num; i++){
			//判断用户id及是否为信用用户
			if (id == users[i].getId() && users[i] instanceof CreditAccount){
				account = users[i];
				((CreditAccount)account).setCeiling(loanamount);
			} else {
				System.out.println("用户不存在");
			}
		}
		return account;
	}

	/**
	 * 还透支款
	 * @param id 用户id
	 * @param amount 还透支金额
	 * @return 还完的用户
	 */
	public Account adminPayCeil(long id,double amount){
		Account account = null;
		for (int i = 0; i < num; i++){
			//判断用户id及是否为信用贷款用户
			if (id == users[i].getId() && users[i] instanceof CreditAccount){
				((CreditAccount)account).payCeil(amount);
			}
		}
		return account;
	}
}
