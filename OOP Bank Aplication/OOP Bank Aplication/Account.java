package Homework2;

public abstract class  Account  {
		
		protected String AccountID;
		protected String Info;
		public int  AccountTime;
		protected double Balance=0;
		public static int CurrentTime;
		
		public Account(Bank B,Customer C,Integer AccountType,Integer AccountNumber){
			B.createAccount(this);
			this.Info=C.getCustomerName();
			AccountID=String.format("%s-%s-%d-%d",B.getCode(),C.getCustomerID(),AccountType,AccountNumber);
			this.AccountTime=Test.Month;
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

