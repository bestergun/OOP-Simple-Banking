package Homework2;

import java.util.ArrayList;

public class Test {
	public static int Month;
	public Test(int T) {
		this.Month=T;
	}
	public static void addMonth() {
		Month++;
	}
	public static void addMonth(int a) {
		Month=Month+a;
	}
	public static ArrayList<Bank>Banks=new ArrayList<Bank>();

	public static void main(String[] args) {
		Test T=new Test(0);
		addMonth();
		Customer A =new Customer("Beyazit");
		Customer B =new Customer("Bestami");
		Customer C =new Customer("Ergun");
		
		
		
		Bank Akbank=new Bank("Akbank","1");
		Bank Garanti=new Bank("Garanti","2");
		Bank Ziraat=new Bank("Ziraat","3");
		
		
		Banks.add(Akbank);
		Banks.add(Garanti);
		Banks.add(Ziraat);
		
		Account AB=new SavingAccount(Akbank,A);
		Account AE=new TimeAccount(Akbank,A);
		
		Account AC=new SavingAccount(Akbank,B);
		Account AD=new TimeAccount(Garanti,A);
		
		
		Akbank.createAccount(AB);
		Akbank.createAccount(AC);
		Garanti.createAccount(AD);
		Akbank.createAccount(AE);
		

		System.out.println("How to work deposit");
		System.out.println("1-1-2-1"+"Deposit 1100 TL");
		deposit("1-1-2-1",1100);
		System.out.println("1-1-2-1 Balance:");
		seeBalance("1-1-2-1");
		
		System.out.println("How to work withdraw");
		System.out.println("1-1-2-1"+" Whitdraw 100 TL");
		withdraw("1-1-2-1",100);
		seeBalance("1-1-2-1");

		
		System.out.println("====================");
		System.out.println("How to work intrest with SavingAccount");
		seeBalance("1-1-2-1");
		addMonth(5);
		System.out.print("5 month later balance:");
		seeBalance("1-1-2-1");
		System.out.println();
		
		System.out.println("How to work intrest with TimeAccount");
		deposit("1-1-1-0",1100);
		seeBalance("1-1-1-0");
		addMonth(6);
		System.out.print("6 months later: ");
		seeBalance("1-1-1-0");
		
		
		System.out.println("====================");
		System.out.println("Transfer between the same bank");
		System.out.print("1-1-2-1"+" Balance Before Transfer: ");
		seeBalance("1-1-2-1");
		System.out.println("1-1-2-1"+" Trasfer 100 TL to 1-2-2-2"+"(Trasfer Cost= Amount*0.02)");
		transfer("1-1-2-1","1-2-2-2",100);
		System.out.print("1-1-2-1"+" Balance: ");
		seeBalance("1-1-2-1");
		System.out.print("1-2-2-2"+" Balance: ");
		seeBalance("1-2-2-2");
		
		System.out.println("====================");
		System.out.println("Transfer to other bank");
		System.out.println("1-1-2-1"+" Trasfer 100 TL to 2-1-1-1 "+"(Trasfer cost 3 TL)");
		transfer("1-1-2-1","2-1-1-1",100);
		System.out.print("1-1-2-1"+" Balance: ");
		seeBalance("1-1-2-1");
		System.out.print("2-1-1-1"+" Balance: ");
		seeBalance("2-1-1-1");
		
	}
	public static void seeBalance(String a) {
		for(int i=0;i<Banks.size();i++) {
			if(Banks.get(i).Search(a).AccountID.equals(a)) {
			 System.out.println(Banks.get(i).Search(a).getBalance());
			 break;
				}
			}
	}
		
	public static void deposit(String ID,double amt) {
		for(int i=0;i<Banks.size();i++) {
			if(Banks.get(i).Search(ID).AccountID.equals(ID)) {
			 Banks.get(i).deposit(ID, amt);
			 break;
			}
			else {
				System.out.println("Account isnot founded");
				break;
				}
		}
	
	}public static void withdraw(String ID,double amt) {
		for(int i=0;i<Banks.size();i++) {
			if(Banks.get(i).Search(ID).AccountID.equals(ID)) {
				Banks.get(i).withdraw(ID, amt);
				break;
			}
			else {
				System.out.println("Account isnot founded");
				break;
				}
		}
		
	}
	public static void transfer(String sender,String receiver,double amt) {
		for(int i=0;i<Banks.size();i++) {
			if(Banks.get(i).Search2(receiver)==Banks.get(i).Search2(sender)) {
				withdraw(sender,amt+3);
				deposit(receiver,amt);
				break;
		}
		else {
			withdraw(sender,amt*(1+0.02));
			deposit(receiver,amt);
			break;
			}
		}
	}	
}
