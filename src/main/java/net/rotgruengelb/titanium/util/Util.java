package net.rotgruengelb.titanium.util;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Util {

    /**
     * Converts a snake_case titleCaseString to Title Case.
     *
     * @param snakeCaseString the snake_case titleCaseString to convert
     * @return the converted Title Case titleCaseString
     */
	public static @NotNull String snakeCaseToTitleCase(@NotNull String snakeCaseString) {
		String[] words = snakeCaseString.split("_");
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

    /**
     * Converts a Title Case titleCaseString into a Title Case titleCaseString with "of" Notation
     * For example, {@code "Iron Block"} becomes {@code "Block of Iron"}.
     * <p>
     * If the input titleCaseString contains fewer than two words, the original titleCaseString is returned unchanged.
     *
     * @param titleCaseString the Title Case titleCaseString to convert
     * @return the converted Title Case titleCaseString now with "of" Notation
     */
	public static @NotNull String titleCaseWithOfNotation(@NotNull String titleCaseString) {
		String[] words = titleCaseString.split(" ");
		if (words.length < 2) {
			return titleCaseString;
		}

		String lastWord = words[words.length - 1]; // Get last word
		String rest = String.join(" ", Arrays.copyOf(words, words.length - 1)); // Join remaining words

		return lastWord + " of " + rest;
	}

	public static String tryGetTranslationKey(Object object) throws RuntimeException {
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
