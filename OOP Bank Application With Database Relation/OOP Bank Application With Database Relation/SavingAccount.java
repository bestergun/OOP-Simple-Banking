package Best;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SavingAccount extends Account {

	private double Term;
	private double IntrestRate=0.02;
	
	public SavingAccount(String ID) throws SQLException {
		super(ID);
		 Connection connection;
		 Statement statement;

		connection = DriverManager.getConnection("jdbc:ucanaccess://L:/Data.accdb");
		statement =connection.createStatement();
		statement =connection.createStatement();
		 ResultSet rs=statement.executeQuery("select* from Table1 where [ID]="+ID);
		 Term=rs.getInt("TermofAccount");
		 statement.close();
		 connection.close(); 
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
		CurrentTime=GUI.time;
		double temp=this.Balance*Math.pow(1+this.Term*this.IntrestRate/12, (CurrentTime-AccountTime)/this.Term);
		return temp;
	}

	@Override
	public void CalculateBalance() {
		CurrentTime=GUI.time;
		this.Balance=this.Balance*Math.pow(1+this.Term*this.IntrestRate/12, (CurrentTime-AccountTime)/this.Term);
	}

}
