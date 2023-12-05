package gasSupplier;

public interface gasAgency {
	public String agencyName= "BharatGas";
	public int agencyCode= 1234;
	public double phNumber= 9856321456d;
	public int pinCode=4321;
	
	default void agencyDisplay() {
		System.out.println("The Agency Name: "+ agencyName);
		System.out.println("The Agency Code: "+ agencyCode);
		System.out.println("The Agency phone Number" + phNumber);
		System.out.println("The Agency PinCode: "+ pinCode);
	}
	
  
}
