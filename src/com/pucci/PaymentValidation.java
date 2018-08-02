package com.pucci;

import java.util.Arrays;
import java.util.Scanner;

public class PaymentValidation {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		isValidCard(scan);

	}

	public static void validateLuhn (Scanner scan) {
		int cardSum = 0;
		int i;
		int digit = 0;
		boolean isValid = false;

		do {
			// Message to start getting input
			System.out.println("Enter card");
			String cardNumber = scan.nextLine();
			validateCompany(cardNumber);
			String[] digits = cardNumber.split("");
			for (i = 0; i < digits.length; i++) {

				digit = Integer.parseInt(digits[i]);

				// It will multiply by 2 if odd
				if (i % 2 == 1) {
					System.out.println(digit);
					digit *= 2;
					System.out.println("double: " + digit);
					
					//If the sum has 2 digits, it will sum both
					if (digit > 9) {
						String[] doubleDigit = Integer.toString(digit).split("");
						int temp = Integer.parseInt(doubleDigit[0]);
						int temp1 = Integer.parseInt(doubleDigit[1]);
						digit = temp + temp1;
						System.out.println("double value: " + digit);
					}
				}

				cardSum += digit;
			}

			//The sum of the digits must be divisible by 10 to be valid
			if (cardSum % 10 == 0) {
				isValid = true;
			}

		} while (isValid);
	}

	private static void validateCompany(String cardNumber) {
		//
		String regex = "^([5]{1})([1-5]{1})[0-9]{14}|" //MasterCard
				+ "^([6011]{4})([0-9]{12})|" //Discover
				+ "^([3]{1})([47]{1})([0-9]{13})|" //Amex
				+ "^([300]{3})([0-5]{1})([0-9]{10})|" //Diners Club - Carte Blanche
				+ "^([36]{2})([0-9]{12})|" //Diners Club - International
				+ "" 
				
		
		boolean isValid = cardNumber.matches(regex);
	}
	
	

	// 79927398713

}
