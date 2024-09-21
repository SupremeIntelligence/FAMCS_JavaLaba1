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
        double x = 0.0;        int k = 0;        
        double eps = 0;        double javaResult = 0.0;        
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
        String frmtString = "The Taylor series result: %+30." + precision + "f%nThe Java.Math result: %+34."+ precision + "f";        
        
        Formatter frmt = new Formatter();
        frmt.format(frmtString, taylorResult, javaResult);
        System.out.println(frmt);
        
                if (taylorResult>javaResult)   System.out.println("Taylor result > Java.Math result.");
        else if (taylorResult == javaResult)   System.out.println("Taylor result == Java.Math result.");        
        else if (taylorResult < javaResult)    System.out.println("Taylor result < Java.Math result.");
                
                return javaResult;
    }    
    
        public static void BigTaylor()
    {        
    try {
               
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println ("Enter the value between -1 and 1: ");   //entering X
        String strNumber = reader.readLine();
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
        reader.close();
        
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
        //int width = precision + 5;
        String frmtString = "The Taylor series result: %+" + (precision+5) + "." + precision + "f %nThe Java.Math result: %+" + (precision+9) +"."+ precision + "f";        
        
        Formatter frmt = new Formatter();
        frmt.format(frmtString, BTaylorResult, javaResult);
        System.out.println(frmt);
        
        
        //System.out.println(BTaylorResult);
        //System.out.println(javaResult);
    }
    catch (IOException error)
        {
        System.out.println(error.getMessage());
        }
    }    
        
    public static void main(String[] args) 
    {
        
     Scanner scan = new Scanner (System.in); 
     boolean choice = false;
    System.out.println("Input FALSE if you want to use simple types and TRUE if you want to use BigInteger & BigDecimal types: ");    choice = scan.nextBoolean();
        if (choice == false)
        {        
            simpleTaylor();
        }    
        else 
        {        
        BigTaylor();
        }
    }
}
