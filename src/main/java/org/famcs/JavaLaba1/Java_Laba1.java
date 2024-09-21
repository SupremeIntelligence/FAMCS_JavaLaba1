package org.famcs.JavaLaba1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author supre
 */

public class Java_Laba1 {

    public static double simpleTaylor ()
    {        
        Scanner scan = new Scanner (System.in);
        double x;        int k;        
        double eps;        double javaResult;       
        int denominator = 2;   
        
        System.out.println ("Enter the value between -1 and 1: ");        
        x = scan.nextDouble(); 
        
        while (x < -1 || x >= 1)
        {                        
            System.out.println ("The value should be between -1 and 1: ");
            x = scan.nextDouble();                
        }
        
        System.out.println ("Enter the degree of the epsilon: ");
        k = scan.nextInt();                eps = Math.pow(10, -k);
        double origX = x;        
        double taylorResult = -x;        
        double term = 1.0;        
      
        javaResult = Math.log(1 - x);       
        
        while (Math.abs(term)>eps)        
        {            
            x *= origX;            
            term = x/denominator;            
            taylorResult -= term;
            denominator++;               
        }
        int precision = k+1;
        String frmtString = "Taylor series result: %+30." + precision + "f%nJava.Math result: %+34."+ precision + "f";        
        
        Formatter frmt = new Formatter();
        frmt.format(frmtString, taylorResult, javaResult);
        System.out.println(frmt);
        
                if (taylorResult>javaResult)   System.out.println("Taylor result > Java.Math result.");
        else if (taylorResult == javaResult)   System.out.println("Taylor result == Java.Math result.");        
        else if (taylorResult < javaResult)    System.out.println("Taylor result < Java.Math result.");
        long roundedResult = Math.round(taylorResult);
        System.out.printf("Taylor result in the octal system: %4o%n", roundedResult);
        System.out.printf("Taylor result in the hexadecimal system: %4o%n", roundedResult);
                
                return javaResult;
    }    
    
        public static void BigTaylor()
    {        
    try {
               
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println ("Enter the value between -1 and 1: ");   //entering X
        String strNumber = reader.readLine();
        strNumber = strNumber.replace(',', '.');        //changing , to . for correct work of BufferedReader
        double numbX = Double.parseDouble(strNumber);
        while (numbX < -1 || numbX >= 1)
        {                        
            System.out.println ("The value should be between -1 and 1: "); 
            strNumber = reader.readLine();
            numbX = Double.parseDouble(strNumber);
        }
        BigDecimal X = BigDecimal.valueOf(numbX);
        
        System.out.println ("Enter the degree of the epsilon: ");    //entering K and EPS
        strNumber = reader.readLine();
        long numbK = Long.parseLong(strNumber);
        BigInteger K = BigInteger.valueOf(numbK);
        BigDecimal EPS = BigDecimal.valueOf(Math.pow(10, (-1)*K.doubleValue()));
        //reader.close();
        
        BigDecimal Denominator = BigDecimal.valueOf(2.0);
        
        BigDecimal origX = X;
        BigDecimal BTaylorResult = X.multiply(BigDecimal.valueOf(-1.0));
        BigDecimal BTerm = BigDecimal.ONE;
        
        double javaResult = Math.log(1-X.doubleValue());
        
        while (BTerm.abs().compareTo(EPS) == 1)
        {
            X = X.multiply(origX);
            BTerm = X.divide(Denominator, RoundingMode.HALF_UP);
            BTaylorResult = BTaylorResult.subtract(BTerm);
            Denominator = Denominator.add(BigDecimal.ONE);
        }
        
        int precision = (int)numbK+1;
        String frmtString = "Taylor series result: %+" + (precision+5) + "." + precision + "f %nJava.Math result: %+" + (precision+9) +"."+ precision + "f";        
        
        Formatter frmt = new Formatter();
        frmt.format(frmtString, BTaylorResult, javaResult);
        System.out.println(frmt);
        
        double doubleTResult = BTaylorResult.doubleValue();
        if (doubleTResult>javaResult)   System.out.println("Taylor result > Java.Math result.");
        else if (doubleTResult == javaResult)   System.out.println("Taylor result == Java.Math result.");        
        else if (doubleTResult < javaResult)    System.out.println("Taylor result < Java.Math result.");

        long roundedResult = Math.round(doubleTResult);
        System.out.printf("Taylor result in the octal system: %4o%n", roundedResult);
        System.out.printf("Taylor result in the hexadecimal system: %4o%n", roundedResult);
    }
    catch (IOException error)
        {
        System.out.println(error.getMessage());
        }
    }    
        
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
            simpleTaylor();
            System.out.printf(menuMessage);
            choice = scan.nextInt();
            break;
        }    
        case 2:
        {        
            BigTaylor();
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

