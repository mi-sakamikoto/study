package work001;

import java.util.Scanner;

public class BankTest {
	public static void main(String[] args) {
		while (true){
			System.out.println("----------BAM自助系统--------");
			System.out.println("          系统功能：");
			System.out.println("           a、开户");
			System.out.println("           b、登录");
			System.out.println("           c、存款");
			System.out.println("           d、取款");
			System.out.println("           e、退出");
			System.out.println("          请输入选择：");
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			switch (choice){
				case"a":
					Bank b = new Bank();
					Account account = new Account();
					System.out.println("账户号码:" + Bank.id);
					//Long id = sc.nextLong();
					Scanner sc2 = new Scanner(System.in);
					System.out.println("请输入账户密码:");
					String password = sc2.nextLine();
					System.out.println("请输入确认密码:");
					String repassword = sc2.nextLine();
					System.out.println("请输入姓名:");
					String name = sc2.nextLine();
					System.out.println("请输入身份证号码:");
					String personId = sc2.nextLine();
					System.out.println("账户类型:");
					String idType = sc2.nextLine();
					b.create(password,repassword,name,personId,idType);
					break;
				case"b":
					Bank b2 = new Bank();
					System.out.println("请输入账户号码:");
					Scanner sc3 = new Scanner(System.in);
					Long id2 = sc3.nextLong();
					System.out.println("请输入账户密码:");
					Scanner sc4 = new Scanner(System.in);
					String password2 = sc4.nextLine();
					b2.login(id2,password2);
					break;
				case"c":
					Bank b3 = new Bank();
					System.out.println("请输入账户号码:");
					Scanner sc5 = new Scanner(System.in);
					Long id3 = sc5.nextLong();
					System.out.println("请输入存款数额");
					Scanner sc6 = new Scanner(System.in);
					double deposit = sc6.nextDouble();
					b3.deposit(id3,deposit);
					break;
				case"d":
					Bank b4 = new Bank();
					System.out.println("请输入账户号码:");
					Scanner sc7 = new Scanner(System.in);
					Long id4= sc7.nextLong();
					System.out.println("请输入取款数额");
					Scanner sc8 = new Scanner(System.in);
					double withdrawNum = sc8.nextDouble();
					b4.withdrawNum(id4,withdrawNum);
					break;
				case"e":
					System.exit(0);
				default:
					System.out.println("输入错误");
					break;
			}
		}
	}
}
