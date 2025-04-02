package net.rotgruengelb.titanium.util;

import java.util.Arrays;

public class Util {

	public static String snakeCaseToTitleCase(String snakeCaseText) {
		String[] words = snakeCaseText.split("_");
		StringBuilder titleCaseText = new StringBuilder();

		for (String word : words) {
			if (!word.isEmpty()) {
				titleCaseText.append(Character.toUpperCase(word.charAt(0)))
						.append(word.substring(1)
								.toLowerCase())
						.append(" ");
			}
		}
		return titleCaseText.toString()
				.trim();
	}

	public static String snakeCaseWithOfNotation(String string) {
		String[] words = string.split(" ");
		if (words.length < 2) {
			return string;
		}

		String lastWord = words[words.length - 1]; // Get last word
		String rest = String.join(" ", Arrays.copyOf(words, words.length - 1)); // Join remaining words

		return lastWord + " of " + rest;
	}

	public static String tryGetTranslationKey(Object object) {
		try {
			return object.getClass()
					.getMethod("getTranslationKey")
					.invoke(object)
					.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
