package Best;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

		


	public class Bank {
	
		protected static Connection connection;
		protected static Statement statement;
		
		
		
		public static String seebalance(String ID) throws SQLException {
		
			connection = DriverManager.getConnection("jdbc:ucanaccess://L:/Data.accdb");
			statement =connection.createStatement();
			 ResultSet rs=statement.executeQuery("select [AccountType] from Table1");
			
			 if(rs!=null)
			 {
				 if(0==rs.getInt("AccountType")) {
					return Double.toString(new SavingAccount(ID).getBalance());
				 }
				 else
					return Double.toString(new TimeAccount(ID).getBalance());
			 }
			
			 statement.close();
			 connection.close();
		  return "it is null";
	}
		public static boolean withdraw(String ID, double amt) throws SQLException {
			
			connection = DriverManager.getConnection("jdbc:ucanaccess://L:/Data.accdb");
			statement =connection.createStatement();
			 ResultSet rs=statement.executeQuery("select [ID] from Table1 where [ID]="+ID);
			
			 if(rs!=null)
			 {
				 if(0==rs.getInt("AccountType")) {
					 if(amt<=rs.getDouble("Balance")) {
					 new SavingAccount(ID).Withdraw(amt);
					 statement.execute("Update [Table1] SET Balance='"+(((SavingAccount) rs).getBalance())+"' where [ID]="+ID);
					 return true;
					 }
					 else
						 return false;
				 }
				 if(amt<=rs.getDouble("Balance")) {
					 new TimeAccount(ID).Withdraw(amt);
					 statement.execute("Update [Table1] SET Balance='"+(((TimeAccount) rs).getBalance())+"' where [ID]="+ID);
					 return true;
					 }
					 else
						return false;
				 }
			
			 statement.close();
			 connection.close();
		  return false;
	}
	public static void deposit(String ID, double amt) throws SQLException {
			
			connection = DriverManager.getConnection("jdbc:ucanaccess://L:/Data.accdb");
			statement =connection.createStatement();
			 ResultSet rs=statement.executeQuery("select [ID] from Table1 where [ID]="+ID);
			
			 if(rs!=null)
			 {
				 if(0==rs.getInt("AccountType")) {
					 
					 new SavingAccount(ID).Deposit(amt);
					 statement.execute("Update [Table1] SET Balance='"+(((SavingAccount) rs).getBalance())+"' where [ID]="+ID);
		
				 }
				 else {
					 new TimeAccount(ID).Deposit(amt);
					 statement.execute("Update [Table1] SET Balance='"+(((TimeAccount) rs).getBalance())+"' where [ID]="+ID);}
				 }
			
			 statement.close();
			 connection.close();
		 
	}
	public static boolean Transfer(String IDsender,String IDreceiver, double amt) throws SQLException {
		connection = DriverManager.getConnection("jdbc:ucanaccess://L:/Data.accdb");
		statement =connection.createStatement();
		 ResultSet rs=statement.executeQuery("select [ID] from Table1 where [ID]="+IDsender);
		 ResultSet rs1=statement.executeQuery("select [ID] from Table1 where [ID]="+IDreceiver);
		 
		 if(rs.getInt("BankCode")==rs1.getInt("BankCode")) {
			boolean a= withdraw(IDsender,amt+3);
			if(a==true)
			deposit(IDreceiver,amt);
			 statement.close();
			 connection.close();
		 
			return a;
		 }
		 else {
			 boolean a=withdraw(IDsender,amt*(1+0.02));
			 if(a==true)
			 deposit(IDreceiver,amt);
			 statement.close();
			 connection.close();
			 return a;
		 }

	}	
	
	}

