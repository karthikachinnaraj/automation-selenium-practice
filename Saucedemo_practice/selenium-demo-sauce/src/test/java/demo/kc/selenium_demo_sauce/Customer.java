package demo.kc.selenium_demo_sauce;

public class Customer {

	private String Firstname;
	private String Lastname;
	private String  Postalcode;
	
	public Customer(String Firstname,String Lastname,String Postalcode) {
		this.Firstname=Firstname;
		this.Lastname=Lastname;
		this.Postalcode=Postalcode;
	}
		public String getFirstname() {
			return Firstname;
	}
		
		public String getLastname() {
			return Lastname;
	}
		public String getPostalcode() {
			return Postalcode;
	}
		public void SetFirstname(String Firstname) {
			this.Firstname=Firstname;
	}
		
		public void SetLastname(String Lastname) {
			this.Lastname=Lastname;
	}
		public void SetPostalcode(String Postalcode) {
			this.Postalcode=Postalcode;
	}
		
		
}
