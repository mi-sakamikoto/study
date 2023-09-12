package work001;

import java.util.ArrayList;
import java.util.List;
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
					System.out.println("请输入账户号码:");
					Long id = sc.nextLong();
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
					b.create(id,password,repassword,name,personId,idType);
				case"b":

				case"c":

				case"d":

				case"e":
					System.exit(0);
				default:
					System.out.println("输入错误");
					break;
			}
		}
	}
}
