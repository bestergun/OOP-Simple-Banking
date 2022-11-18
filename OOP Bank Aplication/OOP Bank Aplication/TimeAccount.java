package Homework2;

public class TimeAccount extends Account {
	
	private double IntrestRate=0.02;
	public static int count;
	
	public TimeAccount(Bank B, Customer C) {
		super(B, C, 1,count++);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void Withdraw(double amt) {
		if(amt>this.Balance)
		{
		 CalculateBalance();
		}
		else
		{
			CalculateBalance();
			this.Balance-=amt;
			AccountTime=CurrentTime;
		}
	}
	
	@Override
	public void Deposit(double amt) {
		CalculateBalance();
		this.Balance += amt;
		AccountTime=CurrentTime;
	}

	@Override
	public double getBalance() {
		CurrentTime=Test.Month;
		double temp=this.Balance*Math.pow(1+this.IntrestRate/12, CurrentTime-AccountTime);
		return temp;
	} 
	public void CalculateBalance() {
		CurrentTime=Test.Month;
		this.Balance=this.Balance*Math.pow(1+this.IntrestRate/12, CurrentTime-AccountTime);
		
	}
}
