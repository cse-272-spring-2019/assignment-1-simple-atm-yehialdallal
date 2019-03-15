package yaraab;

public class trial implements ATM {
	@Override
	public  boolean validate(String x)
	{
		if (x.equals("5607"))
			return true;
		else
			return false;
	}
	
	private long balance;
	
	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public void deposit(String amount)
	{
		long x=Long.parseLong(amount);
		if (x>0)
		{
			balance = balance + x;
		}
				
	
	}
	public void withdraw(String amount)
	{
		long x=Long.parseLong(amount);
		if (x>0)
			if (x<balance)
			{
				balance = balance - x;
			}
	}

		
	


}
