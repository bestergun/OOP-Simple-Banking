package Homework2;

public class SavingAccount extends Account {

	private double IntrestRate=0.02;
	private int Term=3;
	public static int count=0;
	
	public SavingAccount(Bank B, Customer C) {
		super(B, C, 2,++count);
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
	public double getBalance(){
		CurrentTime=Test.Month;
		double temp=this.Balance*Math.pow(1+this.Term*this.IntrestRate/12, (CurrentTime-AccountTime)/this.Term);
		return temp;
	}

	@Override
	public void CalculateBalance() {
		CurrentTime=Test.Month;
		this.Balance=this.Balance*Math.pow(1+this.Term*this.IntrestRate/12, (CurrentTime-AccountTime)/this.Term);
	}

}
