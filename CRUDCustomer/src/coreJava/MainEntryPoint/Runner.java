package coreJava.MainEntryPoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import coreJava.DAO.CustomerDAO;
import coreJava.Models.Customer;

public class Runner {
	public static void main(String[] args) throws IOException {
		// boolean temp=false;
		int a=0;
	do {
		 System.out.println(
			      "========================\r\n"
			    + "1. NEW CUSTOMER\r\n"
				+ "2. UPDATE CUSTOMER \r\n"
				+ "3. DELETE CUSTOMER\r\n"
				+ "4. SHOW CUSTOMER\r\n"
				+ "5. LIST ALL \r\n"
				+ "6. Exit\r\n"
				+ "========================");
	
    	//boolean temp=false;
    	Scanner sc= new Scanner(System.in);
	    System.out.println("Enter your choise (1-6)");
	    int choice = sc.nextInt();
	    Customer c=new Customer();
	    CustomerDAO cDAO=new CustomerDAO();
	    List<Customer>customerList =new ArrayList<Customer>();
	    customerList =cDAO.getCustomers();
	    switch (choice) {
	        case 1:{
	    	    System.out.println("Enter customer account number");
	    	    		c.setAccount(sc.nextInt());
	    	    		System.out.println("Enter customer first name");
	    	    		c.setfName(sc.next());	
	    	    		System.out.println("Enter customer last name");
	    	    		c.setlName(sc.next());
	    	    		cDAO.addCustomerToFile(customerList, c.getfName(), c.getlName(), c.getAccount());
	    	    }
	            break;
	        case 2:{
	        	System.out.println("Enter customer account number for update");
 	    		c.setAccount(sc.nextInt());
 	    		if(cDAO.ifCustomerExist(customerList, c.getAccount())) {
 	 	    		
 	    		System.out.println( "========================\r\n"
 	    			    + "1. Update first Name\r\n"
 	    				+ "2. Update last Name \r\n"
 	    				+ "========================");
 	    		int c1=(sc.nextInt());
 	    		 switch (c1) {
 	            case 1: {System.out.println("Enter customer's updated first name");
 	    					String name=sc.next();
 	    					cDAO.saveCustomer(cDAO.updateCustomer(customerList, c.getAccount(), name, c1));
 	    					}
 	                     break;
 	            case 2:  {System.out.println("Enter customer's updated last name");
 	           String name=sc.next();
				cDAO.saveCustomer(cDAO.updateCustomer(customerList, c.getAccount(), name, c1));}
 	                     break;
 	            default:  System.out.println(" wrong choise");;
 	                     break;
 	    		 }
 	    		}
	    	    }
	            break;
	        case 3:{
	        	System.out.println("Enter customer account number to delete");
 	    		c.setAccount(sc.nextInt());
 	    		cDAO.saveCustomer(cDAO.deleteCustomer(customerList, c.getAccount()));
	    	    }
	            break;
	        case 4:{
	        	System.out.println("Enter customer account number to view the record");
 	    		c.setAccount(sc.nextInt());
 	    		if(cDAO.ifCustomerExist(customerList, c.getAccount())) {
 	    		System.out.println(cDAO.findCustomer(customerList, c.getAccount()));
 	    		}
 	    		else System.out.println(" Customer account doesnt exist");
	    	    }
	            break;
	        case 5:{
	    	    System.out.println("All Customers!!!");
	    	    System.out.println(cDAO.allCustomer(customerList));
	    	    }
	            break;
	        case 6:{
	    	    //temp=true;
	        	a=6;
	        	System.out.println("Good Bye!!!!");
	    	    }
	            break;
	        default:
	    }
       
    }
	while(a!=6);
}
}