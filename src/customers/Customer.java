package customers;
import gasSupplier.gasAgency;

public class Customer implements gasAgency{
	public String name;
	public String street;
	public String area;
	public String pinCode;
	public String phnumber;
	
	public Customer(String name, String street, String area, String pinCode, String phnumber) 
	{
		this.name=name;
		this.street=street;
		this.area=area;
		this.pinCode=pinCode;
		this.phnumber=phnumber;
	}
}
