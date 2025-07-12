package demo.qa;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Customer {
	private String name;
	private String email;
	private String address;
	
	public Customer(String name,String Email,String address) {
		this.name=name;
		this.email=Email;
		this.address=address;
		
	}
	
	public void setname(String name) {
		this.name=name;
		
	}
	public void setemail(String email) {
		this.email=email;
}
	public void setaddress(String address) {
		this.address=address;
	}
	public String Getname() {
		return name;
	}
	public String Getemail() {
		return email;
	}
	public String Getaddress() {
		return address;
	}
	}
	
