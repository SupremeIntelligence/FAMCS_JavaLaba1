package org.famcs.JavaLaba1;

import java.util.Scanner;

/**
 *
 * @author supre
 */

public class Java_Laba1 {
        
    public static void main(String[] args) 
    {
     Scanner scan = new Scanner (System.in); 
     int choice;
     String menuMessage = "Input 1, 2 or 3: %n1. Simple data types %n2. BigDecimal & BigInteger data types %n3. Exit %n";
    System.out.printf(menuMessage);  
      menuMessage = "%n" + menuMessage;
    choice = scan.nextInt();
    while (choice != 3)
    {
            switch(choice)
        {
        case 1:
        {        
            TaylorClass.simpleTaylor(TaylorClass.scannerGetX(scan), TaylorClass.scannerGetK(scan));
            System.out.printf(menuMessage);
            choice = scan.nextInt();
            break;
        }    
        case 2:
        {        
            TaylorClass.BigTaylor();
            System.out.printf(menuMessage);
            choice = scan.nextInt();
            break;
        }
        default:
        {
            System.out.printf(menuMessage);
            choice = scan.nextInt();
            break;  
        }
    }
    System.out.print("Exiting the program");      
    }
    }
 }

