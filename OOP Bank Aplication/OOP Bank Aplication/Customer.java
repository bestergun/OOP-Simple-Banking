package Homework2;

public class Customer {

	public String CustomerName;
	public Integer CustomerID=0;
	public static int count=0;
	
	
	public Customer(String CustomerName) {
		count++;
		this.CustomerID=count;
		this.CustomerName=CustomerName;
		
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public Integer getCustomerID() {
		return CustomerID;
	}

	

}
