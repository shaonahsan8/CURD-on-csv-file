package coreJava.Models;

public class Customer {
	int account;
	String fName;
	String lName;
//	int phone;
//	String addressLine;
//	String city;
//	String state;
//	int postalCode;
//	String country;
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	@Override
	public String toString() {
		return    account+"   "+fName+"    "+lName+"\r\n";
	}
	public Customer(int account, String fName, String lName) {
		super();
		this.account = account;
		this.fName = fName;
		this.lName = lName;
	}
	public Customer() {
	}
	
}
