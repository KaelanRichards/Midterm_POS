package com.pucci;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Camila Brasil
 *
 */

public class PaymentValidation {

	/**
	 * @param Scanner
	 *            scan
	 * @return boolean
	 */
	public static boolean isValidCard(Scanner scan) {

		boolean isValidCard = false;

		do {
			String cardNumber = Long.toString(Validator.getLong(scan, "Please, enter the card number: "));

			String securityCode = Integer.toString(Validator.getInt(scan, "Please, enter the security code: "));

			System.out.println();
			String expirationDate = Validator.getString(scan, "Please, enter the expiration date: ");

			String cardCompany = CreditCard.getMatchingCreditCard(cardNumber, securityCode);

			if (cardCompany != null) {
				if (isValidLuhn(cardNumber)) {
					if (isValidDate(expirationDate)) {
						isValidCard = true;
					}
				}
				System.out.println("Payment method: " + cardCompany + ".\nApproved.");
			} else {
				System.out.println("This is not a valid card");
			}

		} while (!isValidCard);

		return isValidCard;

	}

	/**
	 * @param String
	 *            cardNumber
	 * @return boolean
	 */
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

	/**
	 * @param String
	 *            expirationDate
	 * @return boolean
	 */
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

	/**
	 * @param Scanner
	 *            scan
	 * @return boolean
	 */
	public static boolean isValidCheck(Scanner scan) {

		boolean isValid = false;

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

	/**
	 * @param double
	 *            sumTotal
	 * @param Scanner
	 *            scan
	 * @return double
	 */
	public static double usersChange(double sumTotal, Scanner scan) {

		double usersMoney;

		do {
			usersMoney = Validator.getDouble(scan, "Please enter the amount of cash tendered: ");
			
//			System.out.println("Please enter the amount of cash tendered: ");
//			usersMoney = scan.nextDouble();
			if (usersMoney < sumTotal) {
				System.out.println("The amount needs to be greater or equal to: " + sumTotal);
			}
		} while (usersMoney < sumTotal);

		double change = Math.round(usersMoney - sumTotal);

		return change;
	}

}
