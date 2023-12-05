package gasBooking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delivery extends Booking {
    public String delPersonName;
    public int customerOtp;

    
    public Delivery( String name, String street, String area, String pinCode, String phnumber, int numberOfCylinder) {
        super( name, street, area, pinCode, phnumber, numberOfCylinder );
        
	}

    
	public void amountCalc() {
       
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd/MM/yyyy");  
		
            long dayDiff = dt_2.getTime() - dt_1.getTime();  
            
            long newDaydiff = TimeUnit .MILLISECONDS.toDays(dayDiff);    
        
             System.out.print( " Difference between the two dates is: "+ newDaydiff);  
   
	}

	public void verifyOtp() 
	{
        if (status.equals("B")) 
        {
            System.out.println("Enter OTP: ");
            customerOtp = new Scanner(System.in).nextInt();
            
            if (customerOtp != otp) 
            {
                status = "C";
            }
            else
            {
                status = "D";
            }
        } 
        else 
        {
            System.out.println("No Booking found!!!");
        }
    }

   
	public  void delPersonDetails() {
		System.out.println("\n Enter Delivery Person Name : ");
        delPersonName = new Scanner(System.in).nextLine();	
    }
}





	
