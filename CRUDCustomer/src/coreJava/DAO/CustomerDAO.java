package coreJava.DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import coreJava.Models.Customer;


public class CustomerDAO {
	public List<Customer>  getCustomers() throws IOException{
		List<String> lines = Files.readAllLines(Paths.get("customers.csv"));
		//System.out.println(lines.size());
		List<Customer> cus = new ArrayList<Customer>();
		String splitBy = ","; 
		for(int i=0;i<lines.size();i++) {
			String[] st = lines.get(i).split(splitBy);
			Customer s =new Customer(Integer.parseInt(st[0]),st[1],st[2]);
			cus.add(i, s);
			// System.out.println(s.toString());
		}
		return cus;
 
	}
	// validate customer
		public boolean ifCustomerExist(List<Customer> customerList, int account){
			boolean temp = false;
			for(int i=0;i<customerList.size();i++) {
				if((customerList.get(i).getAccount()==account ) ){
					temp=  true;
				}
			}
			return temp;
		}
		 public void addCustomerToFile(List<Customer> customerList,String fName, String lName, int account) throws IOException{
		    	boolean temp = false;
				for(int i=0;i<customerList .size();i++) { 
					if(customerList .get(i).getAccount()==(account  )) {
						temp=  true;
						
						break;
					}
					else temp= false;
				}
				if(temp==false) {
					Customer  c =new Customer(account  ,fName ,lName );
					 List<Customer > cus = new ArrayList<>(); 
					 cus.add(c);
					 addCustomer(cus);
				}
				else System.out.println("Already a customer!!!");
		    } 
		 public void saveCustomer(List<Customer> customerList) throws IOException{
		    	String fileName = "customers.csv";
		    	PrintWriter pw = null;
		    	pw = new PrintWriter(new FileWriter(fileName));
		    	StringBuilder sb = new StringBuilder();
		    	for(int i=0;i<customerList .size();i++) { 
		    	//sb.append('\n');
		        sb.append(customerList.get(i).getAccount());
		        sb.append(',');
		        sb.append(customerList.get(i).getfName());
		        sb.append(',');
		        sb.append(customerList.get(i).getlName());
		        sb.append('\n');

		      //  pw.write(sb.toString());
		    	}
		    	 pw.write(sb.toString());
		        pw.close();
		        System.out.println("done !");

		    }
		 public void addCustomer(List<Customer> customerList) throws IOException{
		    	String fileName = "customers.csv";
		    	PrintWriter pw = null;
		    	pw = new PrintWriter(new FileWriter(fileName,true));
		    	StringBuilder sb = new StringBuilder();
		    	//sb.append('\n');
		        sb.append(customerList.get(0).getAccount());
		        sb.append(',');
		        sb.append(customerList.get(0).getfName());
		        sb.append(',');
		        sb.append(customerList.get(0).getlName());
		        sb.append('\n');

		      //  pw.write(sb.toString());
		    	
		    	 pw.write(sb.toString());
		        pw.close();
		        System.out.println("done !");

		    }
		 public List<Customer> findCustomer(List<Customer> customerList, int account) throws IOException{
			 List<Customer > cus = new ArrayList<>(); 
			 for(int i=0;i<customerList .size();i++) { 
					if(customerList .get(i).getAccount()==(account  )) {
						cus.add(customerList .get(i));
						break;
					}
				}
				return cus;
				
		    } 
		 public List<Customer> updateCustomer(List<Customer> customerList, int account, String name, int ch) throws IOException{
			 List<Customer > cus = new ArrayList<>(); 
			 Customer c1=new Customer();
			 if(ch==1) {
			 for(int i=0;i<customerList .size();i++) { 
					if(customerList .get(i).getAccount()==(account  )) {
						c1.setAccount(account);
						c1.setfName(name);
						c1.setlName(customerList.get(i).getlName());
						cus.add(c1);
					}
					else cus.add(customerList .get(i));
				}
			 }
			 else if(ch==2) {
				 for(int i=0;i<customerList .size();i++) { 
						if(customerList .get(i).getAccount()==(account  )) {
							c1.setAccount(account);
							c1.setfName(customerList.get(i).getfName());
							c1.setlName(name);
							cus.add(c1);
						}
						else cus.add(customerList .get(i));
					}
				 }
				return cus;
			 
		    } 
		 public List<Customer> deleteCustomer(List<Customer> customerList, int account) throws IOException{
			 List<Customer > cus = new ArrayList<>(); 
			 Customer c1=new Customer();
			 
			 for(int i=0;i<customerList .size();i++) { 
					if(customerList .get(i).getAccount()==(account  )) {
						continue;
					}
					else cus.add(customerList .get(i));
				
			
				 }
				return cus;
			 
		    } 
		 public List<Customer> allCustomer(List<Customer> customerList) throws IOException{
			 List<Customer > cus = new ArrayList<>(); 
			 for(int i=0;i<customerList .size();i++) { 
						cus.add(customerList .get(i));
				}
				return cus;
				
		    } 
}
