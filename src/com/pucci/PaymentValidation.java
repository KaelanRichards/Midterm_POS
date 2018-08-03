package com.pucci;

import java.time.LocalDate;
import java.util.Scanner;

public class PaymentValidation {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// if (isValidCard(scan)) {
		// System.out.println("It works!");
		// } else {
		// System.out.println("Deu merda");
		// }

		if (isValidCheck(scan)) {
			System.out.println("it works");
		} else {
			System.out.println("nope");
		}

	}

	public static boolean isValidCard(Scanner scan) {

		boolean isValidCard = false;

		do {
			System.out.println("Please, enter the card number: ");
			String cardNumber = scan.nextLine();

			System.out.println("Please, enter the security code: ");
			String securityCode = scan.nextLine();

			System.out.println("Please, enter the expiration date: ");
			String expirationDate = scan.nextLine();

			if (isValidCompany(cardNumber, securityCode)) {
				if (isValidLuhn(cardNumber)) {
					if (isValidDate(expirationDate)) {
						isValidCard = true;
					}
				}
			} else {
				System.out.println("This is not a valid card");
			}

		} while (!isValidCard);

		return isValidCard;

	}

	public static boolean isValidLuhn(String cardNumber) {
		int cardSum = 0;
		int i;
		int digit = 0;
		boolean isValid = false;

		String[] digits = cardNumber.split("");
		for (i = 0; i < digits.length; i++) {

			// Getting the numbers in the reverse order
			digit = Integer.parseInt(digits[digits.length - i - 1]);

			// It will multiply by 2 if odd
			if (i % 2 == 1) {
				digit *= 2;

				// If the sum has 2 digits, it will subtract 9
				if (digit > 9) {
					digit = digit - 9;
				}
			}
			cardSum += digit;
		}

		// The sum of the digits must be divisible by 10 to be valid
		if (cardSum % 10 == 0) {
			isValid = true;
		}

		return isValid;

	}

	public static boolean isValidCompany(String cardNumber, String securityCode) {
		boolean isValid = false;
		// Validating the first digits and the lenght

		// Validation for MasterCard, Discover and Visa
		String regex1 = "^([5]{1})([1-5]{1})[0-9]{14}|^([6011]{4})([0-9]{12})|^([4]{1})([0-9]{13})";

		// Validation for Amex, Diners Club (Carte Blance, International and USA &
		// Canada
		String regex2 = "^([3]{1})([47]{1})([0-9]{13})|^([30]{2})([0-5]{1})([0-9]{11})|^([36]{2})([0-9]{12})|^([54]{2})([0-9]{14})";

		// Regex 3 - Security Code for Visa, MasteraCard and Discover
		String regex3 = "^([0-9]{3})";

		// Regex 4 - Security Code for Amex
		String regex4 = "^([0-9]{4})";

		// boolean isValid = cardNumber.matches(regex);
		// If is Visa, Master or Discover
		if (cardNumber.matches(regex1)) {
			if (securityCode.matches(regex3)) {
				isValid = true;
			}
		} else if (cardNumber.matches(regex2)) {
			if (securityCode.matches(regex4)) {
				isValid = true;
			}
		}

		return isValid;

	}

	public static boolean isValidDate(String expirationDate) {

		boolean isValid = false;

		// Separating the users input into month and year
		String[] date = expirationDate.split("/");
		int userMonth = Integer.parseInt(date[0]);
		int userYear = Integer.parseInt(date[1]);

		// Getting the month and the year from now
		LocalDate todaysDate = LocalDate.now();
		int monthNow = todaysDate.getMonthValue();
		String fullYearNow = Integer.toString(todaysDate.getYear());
		int yearNow = Integer.parseInt(fullYearNow.substring(2, 4));

		if (userYear >= yearNow && userMonth >= monthNow) {
			isValid = true;
		}

		return isValid;
	}

	public static boolean isValidCheck(Scanner scan) {

		boolean isValid = false;

		// // Regex to validate the first 2 digits
		// String regex = "^([00]{2})|" // United States Government
		// + "^([01]{1})([0-2]{1})|" // Federal Reserve Banks
		// + "^([23]{1})([12]{1})|" // Thrift Institutions
		// + "^([67]{1})([12]{1})|" // Special purpose
		// + "^([80]{2})"; //Travel Check

		System.out.println("Please enter the 9 digits in the bottom left of your check: ");
		String checkNum = scan.nextLine();

		String[] checkNumArr = checkNum.split("");

		int[] checkDigits = new int[checkNumArr.length];
		for (int i = 0; i < checkNumArr.length; i++) {
			checkDigits[i] = Integer.parseInt(checkNumArr[i]);
		}

		// Checking if the numbers are valid according with the algorithm
		int sumABA = 3 * (checkDigits[0] + checkDigits[3] + checkDigits[6])
				+ 7 * (checkDigits[1] + checkDigits[4] + checkDigits[7])
				+ (checkDigits[2] + checkDigits[5] + checkDigits[8]);

		// if (checkNum.matches(regex)) {
		if (sumABA % 10 == 0) {
			isValid = true;
		}
		// }

		return isValid;
	}
	
	
	public static double usersChange (double sumTotal, Scanner scan) {
		
		System.out.println("Please enter the amount: ");
		double usersMoney = scan.nextDouble();
		
		
		
		return 0.0;
	}

}
