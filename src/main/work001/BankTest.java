package work001;

import java.util.Scanner;

public class BankTest {
	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("----------BAM自助系统--------");
			System.out.println("          系统功能：");
			System.out.println("           a、开户");
			System.out.println("           b、登录");
			System.out.println("           e、退出");
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
					System.out.println("账户类型:");
					String idType = sc.nextLine();
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
						while (true) {
							System.out.println("----------------");
							System.out.println("     c、存款     ");
							System.out.println("     d、取款     ");
							System.out.println("     e、退出"     );
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
									//退出
									//返回上一级
									break;
								default:
									System.out.println("输入错误");
									break;
							}
						}

					}

				case "e":
					System.exit(0);
				default:
					System.out.println("输入错误");
					break;
			}
		}


	}
}
