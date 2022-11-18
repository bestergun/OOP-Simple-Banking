package Homework2;

import java.util.ArrayList;


public class Bank {
	private String BankName;
	private String Code;
	public static ArrayList<Account>AccountList;
	public static ArrayList<Customer>CustomerList;
	
	
	public Bank(String BankName,String Code) {
		AccountList=new ArrayList();
		this.BankName=BankName;
		this.Code=Code;
	}
	
	public void createAccount(Account A)
	{
		this.AccountList.add(A);
	}
	public void createCustomer(Customer A)
	{
		this.CustomerList.add(A);
	}
	public String getBankName() {
		return BankName;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public ArrayList<Account> getList() {
	       return AccountList;
	   }
	public static Account Search(String a) {
		for(int i=0;i<AccountList.size();i++) {
			if(AccountList.get(i).AccountID.equals(a)) {
				return AccountList.get(i) ;
			}	
		}
		return AccountList.get(0);
	}
	public static int Search2(String a) {
		for(int i=0;i<AccountList.size();i++) {
			if(AccountList.get(i).AccountID.equals(a)) {
				return i;
			}	
		}
		return -1;
	}
	public void deposit(String a,double amt) {
		Search(a).Deposit(amt);
	}
	public void withdraw(String a,double amt) {
		Search(a).Withdraw(amt);
	}
	
}
