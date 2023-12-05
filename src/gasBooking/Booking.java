package gasBooking;

import customers.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.*;

public class Booking extends GasConnection
{
	public double otp=5678, amount=900.0, refund=0;
	public String deldate, status, delmobileNum="565329354";
    public Date dt_1,dt_2, lastDate;
    
    
    
	public Booking( String name, String street, String area, String pinCode, String phnumber, int numberOfCylinder) {
		super(name, street, area, pinCode, phnumber, numberOfCylinder);
	}
	
	 public void getLastDate() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Gas Last Date: ");
	        String lastD = sc.nextLine();
	        
	        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

	        try {
				dt_1 = dateformat.parse(lastD);
				lastDate = dt_1;
			} 
	        catch (Exception e) 
	        {
			    System.out.println("error in getLastDate : " + e);
	        }
	        
	 
        
        //Delivery Details
	        System.out.println("Enter Gas Delivery Date: ");
	        deldate = new Scanner(System.in).nextLine();
	        
	       
	        dt_2 = null;
	        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd/MM/yyyy");

	        try {
				dt_2 = dateformat2.parse(deldate);
			} 
	        catch (Exception e) 
	        {
			    System.out.println("error in getDeliveryDate : " + e);
	        }
      
	        
     //finding difference between two dates
         try
         {
    	 long difference = dt_2.getTime() - dt_1.getTime();
    	 long newDifference = TimeUnit.DAYS.convert(difference,TimeUnit.MILLISECONDS);
    	 System.out.println("Difference between last date and Booking date is: "+newDifference);
    	 
    	 if(newDifference > 7) 
    		 status= "p";   
         }
         
    	 catch(Exception e)
         {
    		 System.out.println("error while finding difference : "+ e);
    	 }
	  
	 }
	 
	 
	public void validate() {
		

        long difference = dt_1.getTime() - lastDate.getTime();
        long differenceInDay = TimeUnit.MILLISECONDS.toDays(difference);


	        if (numberOfCylinder == 1)
	        {
	            if (differenceInDay < 30) 
	            {
	                status = "C";  
	            } 
	            else
	            {
	                status = "B";  
					lastDate = dt_1;
	            }
	            
	        } 
	        
	        else if (numberOfCylinder == 2) {
	            if (differenceInDay < 50)
	            {
	                status = "C"; 
	            } 
	            else 
	            {
	                status = "B";  
	                lastDate = dt_1;
	            }
	        }
	  }
}
    	 