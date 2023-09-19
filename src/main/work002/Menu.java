package work002;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);

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
				/*case "e":
					Scanner sa = new Scanner(System.in);
					//管理员
					System.out.println("请输入账户号码:");
					Long adminId = sa.nextLong();
					System.out.println("请输入账户密码:");
					String adminPassword = sc.nextLine();
					Account accountAdmin = bank.login(adminId,adminPassword);
					menu3((CreditAccount) accountAdmin);

					break;*/
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
			if (account instanceof LoanSavingAccount) {
				System.out.println("     h、贷款   ");
				System.out.println("     i、还贷   ");
				System.out.println("     j、贷款总额   ");
			}
			if (account instanceof LoanCreditAccount) {
				System.out.println("     k、贷款   ");
				System.out.println("     l、还贷   ");
				System.out.println("     m、贷款总额   ");
			}

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
					if (((LoanSavingAccount) account) instanceof Account) {
						((LoanSavingAccount) account).requsetLoan(requsetLoanMonet);
					}

					break;
				case "i":
					System.out.println("请输入还贷金额:");
					Scanner sc6 = new Scanner(System.in);
					double payLoanmoney = sc6.nextDouble();
					if (((LoanSavingAccount) account) instanceof Account) {
						((LoanSavingAccount) account).payLoan(payLoanmoney);
					}

					break;
				case "j":
					if (((LoanSavingAccount) account) instanceof Account) {
						((LoanSavingAccount)account).getLoan();
					}

					break;
				case "k":
					System.out.println("请输入贷款金额:");
					Scanner sc7 = new Scanner(System.in);
					double requsetLoanMonet2 = sc7.nextDouble();
					if (((LoanCreditAccount) account) instanceof Account) {
						((LoanCreditAccount) account).requsetLoan(requsetLoanMonet2);
					}

					break;
				case "l":
					System.out.println("请输入还贷金额:");
					Scanner sc8 = new Scanner(System.in);
					double payLoanmoney2 = sc8.nextDouble();
					if (((LoanCreditAccount) account) instanceof Account) {
						((LoanCreditAccount) account).payLoan(payLoanmoney2);
					}

					break;
				case "m":
					if (((LoanCreditAccount) account) instanceof Account) {
						((LoanCreditAccount)account).getLoan();
					}

					break;
				case "z":
					//退出,返回上一级
					return;

				default:
					System.out.println("输入错误");
					break;
			}
		}
	}

	public static void menu3(CreditAccount account){
		Scanner s = new Scanner(System.in);
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
			String choice = s.nextLine();
			switch (choice){
				case "a":

					break;
				case "b":

					break;
				case "c":

					break;
				case "d":

					break;
				case "e":

					break;
				case "f":

					break;
				case "g":

					break;
				case "z":

					break;
				default:
					System.out.println("");
			}
		}
	}
}
