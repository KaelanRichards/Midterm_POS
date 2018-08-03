package com.pucci;

import java.util.Scanner;

public class PaymentValidation {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		if (validateLuhn(scan)) {
			System.out.println("It works!");
		} else {
			System.out.println("Deu merda");
		}

	}

	public static boolean validateLuhn(Scanner scan) {
		int cardSum = 0;
		int i;
		int digit = 0;
		boolean isValid = false;

//		do {
			// Message to start getting input
			System.out.println("Enter card");
			String cardNumber = scan.nextLine();

			boolean contValidation = validateCompany(cardNumber);
			if (contValidation) {
				String[] digits = cardNumber.split("");
				for (i = 0; i < digits.length; i++) {
					
					//Getting the numbers in the reverse order
					digit = Integer.parseInt(digits[digits.length - i - 1]);
					

					// It will multiply by 2 if odd
					if (i % 2 == 1) {
						// System.out.println(digit);
						digit *= 2;
						// System.out.println("double: " + digit);

						// If the sum has 2 digits, it will subtract 9
						if (digit > 9) {
							digit = digit -9;
						}
					}

					cardSum += digit;
				}

				// The sum of the digits must be divisible by 10 to be valid
				if (cardSum % 10 == 0) {
					isValid = true;
				}
			}
//		} while (isValid == false);

		return isValid;
	}

	private static boolean validateCompany(String cardNumber) {
		//
		String regex = "^([5]{1})([1-5]{1})[0-9]{14}|" // MasterCard
				+ "^([6011]{4})([0-9]{12})|" // Discover
				+ "^([3]{1})([47]{1})([0-9]{13})|" // Amex
				+ "^([300]{3})([0-5]{1})([0-9]{10})|" // Diners Club - Carte Blanche
				+ "^([36]{2})([0-9]{12})|" // Diners Club - International
				+ "^([54]{2})([0-9]{14})"; // Diners Club - USA & Canada
		// + ""

		boolean isValid = cardNumber.matches(regex);

		return isValid;
	}

	// 79927398713

}
