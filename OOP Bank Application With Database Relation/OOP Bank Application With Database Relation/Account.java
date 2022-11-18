package Best;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class  Account  {
		
		protected String AccountID;
		protected String Info;
		public int  AccountTime;
		protected static double Balance;
		public static int CurrentTime=0;
		
		protected static Connection connection;
		protected static Statement statement;
		
		public Account(String ID) throws SQLException{
			connection = DriverManager.getConnection("jdbc:ucanaccess://L:/Data.accdb");
			statement =connection.createStatement();
			 ResultSet rs=statement.executeQuery("select* from Table1 where [ID]="+ID);
			 AccountID=ID;
			 Info=rs.getString("CustomerID");
			 AccountTime=rs.getInt("LastTime");
			 Balance=rs.getDouble("Balance");
			 statement.close();
			 connection.close(); 
		}
		@Override
		public String toString() {
			return "Account [AccountID=" + AccountID + "]";
		}
		public abstract void Withdraw(double amt);
		public abstract void Deposit(double amt);
		public abstract double getBalance();
		public abstract void CalculateBalance();

		public String getAccountID() {
			return AccountID;
		}

		public void setAccountID(String accountID) {
			AccountID = accountID;
		}
		public static int getCurrentTime() {
			return CurrentTime;
		}

		public static void setCurrentTime(int currentTime) {
			CurrentTime = currentTime;
		}
		
		
	}




