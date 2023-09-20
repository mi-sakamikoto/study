package work002;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Bank bank = Bank.bankCreate();
		Scanner sc = new Scanner(System.in);
		System.out.println(bank.bankCreate());

		while (true) {
			System.out.println("----------BAM自助系统--------");
			System.out.println("          系统功能：");
			System.out.println("           a、开户");
			System.out.println("           b、登录");
			System.out.println("           c、所有用户余额");
			System.out.println("           e、管理员登录");
			System.out.println("           d、退出");
			System.out.println("          请输入选择：");
			String choice = sc.nextLine();
			switch (choice) {
				case "a":
					// 开户
					System.out.println("请输入账户密码:");
					String password = sc.nextLine();
					System.out.println("请输入确认密码:");
					String repassword = sc.nextLine();
					System.out.println("请输入姓名:");
					String name = sc.nextLine();
					System.out.println("请输入身份证号码:");
					String personId = sc.nextLine();
					System.out.println("账户类型:0-储蓄账户 1-信用账户 2-可贷款储蓄帐号 3-可贷款信用账户");
					Scanner sci = new Scanner(System.in);
					int idType = sci.nextInt();
					Account acc = bank.create(password, repassword, name, personId, idType);
					if (acc != null) {
						System.out.println("欢迎" + acc.getName() + ",开户成功, 账户号码:" + acc.getId());
					} else {
						System.out.println("开户失败。");
					}

					break;
				case "b":
					// 登录
					Scanner s = new Scanner(System.in);
					System.out.println("请输入账户号码:");
					Long id = s.nextLong();
					System.out.println("请输入账户密码:");
					String password2 = sc.nextLine();
					Account account = bank.login(id, password2);
					if (account != null) {
						System.out.println("欢迎" + account.getName() + ",账户号码:" + account.getId());
						menu2(account);
					}

					break;
				case "c":
					//所有用户余额
					System.out.println("所有用户余额为:" + bank.countLoan());

					break;
				case "e":
					Scanner sa = new Scanner(System.in);
					//管理员
					System.out.println("请输入账户号码:");
					Long adminId = sa.nextLong();
					System.out.println("请输入账户密码:");
					String adminPassword = sc.nextLine();
					if (1 == adminId && "admin".equals(adminPassword)){
						System.out.println("管理员登陆成功");
						if (bank != null) {
							bank.loginAdmin(adminId,adminPassword);
						}
						menu3();
					} else {
						System.out.println("管理员id或密码错误");
					}

					break;
				case "d":
					//退出
					System.exit(0);
				default:
					System.out.println("输入错误");

					break;
			}
		}


	}

	public static void menu2(Account account) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("----------------");
			System.out.println("     c、存款     ");
			System.out.println("     d、取款     ");
			System.out.println("     e、查询余额   ");
			if (account instanceof CreditAccount) {
				System.out.println("     g、还透支款   ");
			}
			/*if (account instanceof LoanSavingAccount) {
				System.out.println("     h、贷款   ");
				System.out.println("     i、还贷   ");
				System.out.println("     j、贷款总额   ");
			}
			if (account instanceof LoanCreditAccount) {
				System.out.println("     k、贷款   ");
				System.out.println("     l、还贷   ");
				System.out.println("     m、贷款总额   ");
			}*/
			if (account instanceof Loan) {
				System.out.println("     i、还贷   ");;
				System.out.println("     h、贷款   ");
				System.out.println("     j、贷款总额   ");
			}

			/*if (account instanceof LoanSavingAccount) {
				System.out.println("     i、还贷   ");;
			}

			if (account instanceof LoanCreditAccount) {
				System.out.println("     l、还贷   ");
			}*/


			System.out.println("     z、退出     ");
			System.out.println("----------------");
			System.out.println("          请输入选择：");
			String choice2 = sc.nextLine();
			switch (choice2) {
				case "c":
					//存款
					System.out.println("请输入存款数额:");
					Scanner sc2 = new Scanner(System.in);
					double depositNum = sc2.nextDouble();
					account.deposit(depositNum);

					break;
				case "d":
					//取款
					System.out.println("请输入取款数额:");
					Scanner sc3 = new Scanner(System.in);
					double withdrawNum = sc3.nextDouble();
					account.withdraw(withdrawNum);

					break;
				case "e":
					//查询余额
					System.out.println("余额为:" + account.getBalance());

					break;
				case "g":
					//还透支款
					System.out.println("请输入还透支款数额:");
					Scanner sc4 = new Scanner(System.in);
					double amount = sc4.nextDouble();
					if (((CreditAccount) account) instanceof Account) {
						((CreditAccount) account).payCeil(amount);
					}

					break;
				case "h":
					System.out.println("请输入贷款金额:");
					Scanner sc5 = new Scanner(System.in);
					double requsetLoanMonet = sc5.nextDouble();
					((Loan)account).requsetLoan(requsetLoanMonet);
					/*if (((LoanSavingAccount) account) instanceof Account) {
						((LoanSavingAccount) account).requsetLoan(requsetLoanMonet);
					}*/

					break;
				case "i":
					System.out.println("请输入还贷金额:");
					Scanner sc6 = new Scanner(System.in);
					if (account instanceof LoanSavingAccount){
						double payLoanmoney = sc6.nextDouble();
						((Loan)account).payLoan(payLoanmoney);
					}
					else {
						double payLoanmoney2 = sc6.nextDouble();
						((Loan)account).payLoan(payLoanmoney2);
					}
					/*if (((LoanSavingAccount) account) instanceof Account) {
						((LoanSavingAccount) account).payLoan(payLoanmoney);
					}*/

					break;
				case "j":
					/*if (((LoanSavingAccount) account) instanceof Account) {
						((LoanSavingAccount)account).getLoan();
					}*/
					((Loan)account).getLoan();

					break;
				/*case "k":
					System.out.println("请输入贷款金额:");
					Scanner sc7 = new Scanner(System.in);
					double requsetLoanMonet2 = sc7.nextDouble();
					if (((LoanCreditAccount) account) instanceof Account) {
						((LoanCreditAccount) account).requsetLoan(requsetLoanMonet2);
					}

					break;*/
				//case "l":
					//System.out.println("请输入还贷金额:");
					//Scanner sc8 = new Scanner(System.in);
					//double payLoanmoney2 = sc8.nextDouble();
					/*if (((LoanCreditAccount) account) instanceof Account) {
						((LoanCreditAccount) account).payLoan(payLoanmoney2);
					}*/
					//((Loan)account).payLoan(payLoanmoney2);

					//break;
				/*case "m":
					if (((LoanCreditAccount) account) instanceof Account) {
						((LoanCreditAccount)account).getLoan();
					}

					break;*/
				case "z":
					//退出,返回上一级
					return;

				default:
					System.out.println("输入错误");
					break;
			}
		}
	}

	public static void menu3(){
		Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		Bank bank = Bank.bankCreate();
		System.out.println(bank.bankCreate());
		while (true){
			System.out.println("----------------");
			System.out.println("     a、贷款     ");
			System.out.println("     b、还贷     ");
			System.out.println("     c、查询余额  ");
			System.out.println("     d、贷款总额  ");
			System.out.println("     e、透支总额  ");
			System.out.println("     f、设置透支度");
			System.out.println("     g、还透支款  ");
			System.out.println("     z、退出     ");
			System.out.println("----------------");
			String choice = s.nextLine();
			switch (choice){
				case "a":
					//替用户贷款
					System.out.println("请输出入用户id:");
					long id = s.nextLong();
					System.out.println("请输出入贷款金额:");
					double requsetLoanMonet = s1.nextDouble();
					bank.adminrequsetLoan(id,requsetLoanMonet);

					break;
				case "b":
					//替用户还贷
					System.out.println("请输出入用户id:");
					long id2 = s.nextLong();
					System.out.println("请输出入还贷金额:");
					double payLoanmoney = s1.nextDouble();
					bank.adminpayLoan(id2,payLoanmoney);

					break;
				case "c":
					//计算所有用户的余额
					bank.count();

					break;
				case "d":
					//计算所有贷款金额
					bank.countLoan();

					break;
				case "e":
					//计算所有透支金额
					bank.countceiled();

					break;
				case "f":
					//设置透支额度
					System.out.println("请输出入用户id:");
					long id3 = s.nextLong();
					System.out.println("请输出透支额度:");
					double loanamount = s1.nextDouble();
					Account account = bank.resetLoanamount(id3,loanamount);
					System.out.println("设置成功，用户" + account.getId() + "的透支额度为:" + loanamount);

					break;
				case "g":
					//还透支款
					System.out.println("请输出入用户id:");
					long id4 = s.nextLong();
					System.out.println("请输出还款金额:");
					double amount = s1.nextDouble();
					Account account4 = bank.adminPayCeil(id4,amount);

					break;
				case "z":

					return;
				default:
					System.out.println("输入错误");
			}
		}
	}
}
