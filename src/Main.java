
import java.util.Scanner;

import gasBooking.Delivery;

import java.text.SimpleDateFormat;
import java.util.Date;

class Main 
{
    private static String agencyCode = "YourAgencyCode", agencyName = "YourAgencyName", phNumber = "YourPhoneNumber";
    static int bcount = 0, ccount = 0, dcount = 0, pcount = 0 ;
    
	
    public static void cylinderCount(Delivery[] obj) 
	{
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for (Delivery delivery : obj) {
            int count = 0;

            System.out.println("In the month of " + (months[delivery.dt_2.getMonth()]) + " : ");
            System.out.println("* in " + delivery.area);

            
            if (delivery.status.equals("D")) 
            {
                count += delivery.numberOfCylinder;
            }
            System.out.println("- " + count + " Cylinder delivered");
        }

        System.out.println("\n");
    }

	
	
	
	
    public static void lateDelivery(Delivery[] obj) 
    {
        int[] month = new int[12];
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        
        for (Delivery delivery : obj)
        {
            if (delivery.status.equals("D") && delivery.amount == 785.25)
            {
                month[delivery.dt_2.getMonth()] += 1;
            }
        }

        System.out.println("-----------Late Delivery------------");
        for (int i = 0; i < 12; i++) 
        {
            if (month[i] != 0) 
            {
                System.out.println("* In " + months[i] + " There are " + month[i]);
            }
        }
        System.out.println("\n");
    }

    
    
    
    
    
    public static void noOfSingleCylinders(Delivery[] obj) 
    {
        System.out.println("-----------Single Cylinder Holder--------------");

        for (int i = 0; i < obj.length; i++) 
        {
            if (obj[i].numberOfCylinder == 1) 
            {
                System.out.println("Customer Name: " + obj[i].name);
                System.out.println("Customer Number: " + obj[i].phnumber);
                System.out.println("Gas Connection number " + (i + 101));
            }
        }
        System.out.println("\n");
    }

    
    
    
    
    public static void deliveryDetails(Delivery[] obj) {
        System.out.println("--------------Delivery Details--------------");
        System.out.println("Enter the name of Delivery Person");
        Scanner scanner = new Scanner(System.in);
        String dpname = scanner.nextLine();
        scanner.close();

        for (Delivery delivery : obj) {
            if (delivery.status.equals("D") && delivery.delPersonName.equals(dpname)) {
                System.out.println("Customer Name: " + delivery.name);
                System.out.println("- " + delivery.street + " , " + delivery.area + " , " + delivery.pinCode);
            }
        }
    }

    
    
       
    
    public static void printReport(Delivery[] obj) {
        for (int i = 0; i < obj.length; i++) {
            if (obj[i].status.equals("D")) {
                dcount = dcount + 1;
            } else if (obj[i].status.equals("B")) {
                bcount++;
            } else if (obj[i].status.equals("C")) {
                ccount++;
            } else if (obj[i].status.equals("P")) {
                pcount++;
            }
        }

               
        System.out.println("* Booked");
        System.out.println(" - " + bcount + " booked");

        System.out.println("* Delivered");
        System.out.println(" - " + dcount + " delivered");

        System.out.println(" Canceled ");
        System.out.println(" - " + ccount + " Cancelled");

        System.out.println(" Pending ");
        System.out.println(" - " + pcount + " Pending");
        System.out.println("\n");
    }

    
    
    
    
    
    public static void printInvoice(Delivery[] obj) {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String invoiceDate = sdf.format(currentDate);

        for (int i = 0; i < obj.length; i++) 
        {
            if (obj[i].status.equals("D")) 
            {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("                                 INVOICE");
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Gas Agency Code: " + agencyCode + "\t\t\t" + " Date of Invoice " + invoiceDate);
                System.out.println("Gas Agency Name: " + agencyName + "\t\t" + " Agency Phone Number " + phNumber);
                System.out.println("Gas Connection Number: " + (i + 101) + "\t\t\t" + "Customer Name: " + obj[i].name);
                System.out.println("Booking Date: " + sdf.format(obj[i].dt_1) + "\t\t" + "Customer Mobile Number: " + obj[i].phnumber);
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Amount: " + obj[i].amount);
                System.out.println("Refund: " + obj[i].refund);
                System.out.println("Total Amount: " + (obj[i].amount - obj[i].refund));
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Delivery Person Name: " + obj[i].delPersonName + "\t\t" + " Delivery Person Mobile " + obj[i].delmobileNum);
                System.out.println("Delivery Date: " + sdf.format(obj[i].dt_2));
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("\n\n");
            }
        }
    }

    
    
    
    public static void main(String[] args) {
        System.out.println("***************************************************************************");
        System.out.println("                         Bharat Gas Agency                                 ");
        System.out.println("***************************************************************************");

        Delivery[] deliveryObject = new Delivery[2]; // Create an array of Delivery objects

        
        deliveryObject[0] = new Delivery("Akshata", "4th Avenue", "Alpha - 2", "201345", "9990883379", 1);
        deliveryObject[1] = new Delivery("Suraj", "2nd Avenue", "Gamma-2", "201306", "9899616485", 2);
        /*deliveryObject[2] = new Delivery("Sanvi", "4th Avenue", "Alpha-2", "201308", "7838048146", 1);
        deliveryObject[3] = new Delivery("Ganga", "4th Avenue", "Alpha-2", "201308", "9765556171", 2);*/

        for (Delivery delivery : deliveryObject)
        {
            delivery.delPersonDetails();
            delivery.getLastDate();
            delivery.validate();
            delivery.amountCalc();
            delivery.verifyOtp();
        }

        System.out.println();
        
        cylinderCount (deliveryObject);
        lateDelivery (deliveryObject);
        noOfSingleCylinders (deliveryObject);
        deliveryDetails (deliveryObject);
        printReport (deliveryObject);
        printInvoice (deliveryObject);
    }
}

				
				

				