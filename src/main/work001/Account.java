package work001;

public class Account {
	//属性
	private long id;
	private String password;
	private String name;
	private String personId;
	private double balance;
	
	//get set
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//构造
	public Account() {
		super();
	}
	public Account(long id, String password, String name, String personId, double balance) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.personId = personId;
		this.balance = balance;
	}
	//balance构造
	public Account(double balance) {
		super();
		this.balance = balance;
	}
	
	//存款
	public double deposit(double depositNum){
		double money = 0.0;
		money = balance + depositNum;
		this.setBalance(money);
		//System.out.println(money);
		return money;
	}

	//取款
	public double withdraw(double withdrawNum){
		double money = 0.0;
		money = balance - withdrawNum;
		if(money >= 0){
			this.setBalance(money);
			//System.out.println(money);
			return money;
		}else{
			System.out.print("余额不足，");
			return 0.0;
		}
	}
}
