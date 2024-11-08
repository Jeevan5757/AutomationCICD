package Practise;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class Day5_NumberFormatClass {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	        double payment = scanner.nextDouble();
	        scanner.close();
	        
NumberFormat.getInstance();
			//	        String my_string = NumberFormat.getInstance().format(payment) ;
//	        NumberFormat us = NumberFormat.getInstance(Locale.US);
//	        System.out.println(us);
//	       Number myNumber = us.parse(my_string);
//	       System.out.println(myNumber);
	        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
	        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
	        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
	        String india = NumberFormat.getCurrencyInstance(new Locale("en","IN")).format(payment);
	        
	        
	        System.out.println("US: " + us);
	        System.out.println("India: " + india);
	        System.out.println("China: " + china);
	        System.out.println("France: " + france);
	        System.out.println("Changes done in develope branch");

	}

}
