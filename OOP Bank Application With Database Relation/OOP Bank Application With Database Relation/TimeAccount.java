package Best;

import java.sql.SQLException;

public class TimeAccount extends Account {
	
	
	private double IntrestRate=0.02;
	
	public TimeAccount(String ID) throws SQLException {
		super(ID);
		
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
		CurrentTime=GUI.time;
		double temp=this.Balance*Math.pow(1+this.IntrestRate/12, CurrentTime-AccountTime);
		return temp;
	} 
	public void CalculateBalance() {
		CurrentTime=GUI.time;
		this.Balance=this.Balance*Math.pow(1+this.IntrestRate/12, CurrentTime-AccountTime);
		
	}
}
