import org.junit.*;
import work002.Account;
import work002.SavingAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * 储蓄账户测试类
 */
public class SavingAccountTest {

	@BeforeClass
	public static void setUpClass() {
		// 类执行之前，所有测试方法执行之前，运行一次
		// 一般这里写数据库连接
	}

	@Before
	public void setUp() {
		// 每个测试方法执行之前运行
		// 准备每个测试方法的数据
	}


	/**
	 * 存款方法测试
	 */
	@Test
	public void testDeposit() {
		// 测试数据
		Account acc = new SavingAccount();
		final double AMOUNT = 1000;

		// 执行测试方法
		acc.deposit(AMOUNT);

		// 测试结果(期待值，实际值)
		assertEquals(AMOUNT, acc.getBalance(), 0.1);

		// 执行测试方法
		acc.deposit(557.31);

		// 测试结果(期待值，实际值)
		assertEquals(1557.31, acc.getBalance(), 0.001);

		// 异常测试写法
//		try {
//			// 执行测试方法
//
//			// 强制失败
//			fail();
//		} catch (Exception e) {
//			// 测试结果(期待值，实际值)
//
//		}
	}

	/**
	 * 取款方法测试
	 * 当前账户有余额
	 */
	@Test
	public void testWithdraw001() {
		// 测试数据
		Account acc = new SavingAccount();
		acc.setBalance(1000);

		// 执行测试方法
		acc.withdraw(300);

		// 测试结果(期待值，实际值)
		assertEquals(700, acc.getBalance(), 0.1);
	}

	/**
	 * 取款方法测试
	 * 当前账户余额不足
	 */
	@Test
	public void testWithdraw002() {
		// TODO
	}


	@After
	public void tearDown() {
		// 每个测试方法执行之后运行
		// 清理测试数据
	}

	@AfterClass
	public static void tearDownClass() {
		// 类完全执行之后，最后执行一次
		// 断开数据库
	}

}
