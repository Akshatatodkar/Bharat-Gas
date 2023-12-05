package customers;

import java.text.*;
import java.util.*;
public class GasConnection extends Customer {
    public int numberOfCylinder;
    static int connectionNumber = 100;

    {
        connectionNumber += 1;
    }

    Date lastDate=null;
    SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

    public GasConnection( String name, String street, String area, String pinCode, String phnumber, int numberOfCylinder) 
    {
        super(name, street, area, pinCode, phnumber);
        this.numberOfCylinder = numberOfCylinder;
    }


    public void getLastDate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Gas Last Date: ");
        String date = sc.nextLine();

        try {
			lastDate = dateformat.parse(date);
			} 
        catch (ParseException e) 
        {
		    System.out.println("error in getLastDate" + e);
    }
}
}

	
