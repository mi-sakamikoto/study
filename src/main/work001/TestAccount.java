package work001;

import java.util.Scanner;

public class TestAccount {
	public static void main(String[] args) {
		Account a = new Account(500.00);;
		a.withdraw(150.00);
		a.deposit(22.50);
		a.withdraw(47.62);
		System.out.println("余额为:" + a.getBalance());

	}
}
