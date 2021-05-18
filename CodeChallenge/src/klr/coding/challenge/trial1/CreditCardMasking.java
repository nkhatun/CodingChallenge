package klr.coding.challenge.trial1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

class CreditCardMasking {
	private static Logger log = Logger
			.getLogger(CreditCardMasking.class.getName());
	private static final int MASKIFY_SIZE = 6;
	private static final int LAST_DIGITS_NOT_TO_MASK = 4;
	private static int ccLength = 0;

	public static String maskify(String creditCardNumber) {
		// Check if the cc number is null
		if (creditCardNumber == null) {
			log.info("Throwing exception if the cc number is null");
			throw new IllegalArgumentException(
					"Invalid credit card number " + creditCardNumber);
		}
		// Check if the cc number is empty
		if (creditCardNumber.trim().isEmpty()) {
			return "";
		}
		ccLength = creditCardNumber.length();
		log.info("cc number length is:: " + ccLength);

		// Check if the cc number is less than MASKIFY_SIZE
		if (ccLength < MASKIFY_SIZE) {
			return creditCardNumber;
		}
		return convertMaskify(creditCardNumber);
	}

	// coverting the cc number to masked cc number
	private static String convertMaskify(String creditCardNumber) {
		StringBuilder sb = new StringBuilder();
		// check if not digit and within range, then skip maskify
		int maskifyLength = ccLength - LAST_DIGITS_NOT_TO_MASK;
		log.info("No Digits to mask " + maskifyLength);
		AtomicInteger index = new AtomicInteger();
		creditCardNumber.chars().forEach(cc -> {
			int currentIndex = index.getAndIncrement();
			if (Character.isDigit(cc) && currentIndex > 0
					&& currentIndex < maskifyLength) {
				sb.append("#");
			} else {
				sb.append(Character.toString((char) cc));
			}
		});
		return sb.toString();
	}
}