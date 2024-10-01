package org.famcs.JavaLaba1;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Formatter;
import java.util.Scanner;


public class TaylorClass
{

public static double scannerGetX (Scanner scan)
{
    double x;
    System.out.println ("Enter the value between -1 and 1: ");        
        x = scan.nextDouble(); 

    while (x < -1 || x >= 1)
        {                        
            System.out.println ("The value should be between -1 and 1: ");
            x = scan.nextDouble();                
        }
    return x;
}

public static int scannerGetK (Scanner scan)
{       
    System.out.println ("Enter the degree of the epsilon: ");
    return scan.nextInt();
}

public static void formattedResults (int precision, double taylorResult, double javaResult)
{
        String frmtString = "Taylor series result: %+" + (precision+5)+ "." + precision + "f%nJava.Math result: %+"+ (precision+9) + "." + precision + "f";        
        
        Formatter frmt = new Formatter();
        frmt.format(frmtString, taylorResult, javaResult);
        System.out.println(frmt);
        
                if (taylorResult>javaResult)   System.out.println("Taylor result > Java.Math result.");
        else if (taylorResult == javaResult)   System.out.println("Taylor result == Java.Math result.");        
        else if (taylorResult < javaResult)    System.out.println("Taylor result < Java.Math result.");
        long roundedResult = Math.round(taylorResult);
        System.out.printf("Taylor result in the octal system: %4o%n", roundedResult);
        System.out.printf("Taylor result in the hexadecimal system: %4x%n", roundedResult);
}

public static double simpleTaylor (double x, int k)
    {        
        
        double eps;        
        double javaResult;       
        int denominator = 2;   
        
        eps = Math.pow(10, -k);
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
        formattedResults(precision, taylorResult, javaResult);
        return taylorResult;
    }    

    public static double readerGetX (BufferedReader reader)
    {
    try
    {
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
        return numbX;
    }
    catch (IOException error)
    {
        System.out.println(error.getMessage());
    }    
    return 0;
    }

    public static long readerGetK(BufferedReader reader)
    {
    try 
    {
        System.out.println ("Enter the degree of the epsilon: ");   
        String strNumber = reader.readLine();
        long numbK = Long.parseLong(strNumber);
        return numbK;
    }
    catch (IOException error)
    {
        System.out.println(error.getMessage());
    }   
    return 0;
    }

    public static double BigTaylor(double numbX, long numbK)
    {        
        BigDecimal X = BigDecimal.valueOf(numbX);
        
        BigInteger K = BigInteger.valueOf(numbK);
        BigDecimal EPS = BigDecimal.valueOf(Math.pow(10, (-1)*K.doubleValue()));
        
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
        formattedResults(precision, BTaylorResult.doubleValue(), javaResult);

        return BTaylorResult.doubleValue();
    }
    
}

 