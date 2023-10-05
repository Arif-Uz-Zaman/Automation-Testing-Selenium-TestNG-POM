package Utility;

import java.util.Random;

public class RandomString {
	
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	public static String generateRandomString(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("Length must be greater than 0");
		}

		Random random = new Random();
		String[] randomStrings = new String[length];

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(CHARACTERS.length());
			randomStrings[i] = Character.toString(CHARACTERS.charAt(randomIndex));
		}
		//here we Join the elements of the randomStrings array into a single String
		return String.join("", randomStrings);
	}

}
