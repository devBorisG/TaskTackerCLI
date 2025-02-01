package boris.enterprice.utils;

/**
 * Utility class for text operations.
 */
public final class UtilText {

    /**
     * The singleton instance of this class.
     */
    private static final UtilText INSTANCE = new UtilText();

    /**
     * The empty string.
     */
    public static final String EMPTY_STRING = "";

    /**
     * Private constructor for UtilText.
     */
    private UtilText() {}

    /**
     * Gets the singleton instance of UtilText.
     *
     * @return the instance
     */
    public static UtilText getInstance() {
        return INSTANCE;
    }

    /**
     * Gets the default text if the given text is null.
     *
     * @param text the text to check
     * @param defaultText the default text
     * @return the text or the default text
     */
    public String getDefaultText(String text, String defaultText) {
        return UtilObject.getInstance().getDefaultIfNull(text, defaultText);
    }

    /**
     * Gets the default text if the given text is null.
     *
     * @param text the text to check
     * @return the text or the empty string
     */
    public String getDefaultText(String text) {
        return getDefaultText(text, EMPTY_STRING);
    }

    /**
     * Trims the given text.
     *
     * @param text the text to trim
     * @return the trimmed text
     */
    public String trim(String text) {
        return getDefaultText(text).trim();
    }

    /**
     * Checks if the given text is empty.
     *
     * @param text the text to check
     * @return true if the text is empty, false otherwise
     */
    public boolean isEmpty(String text) {
        return EMPTY_STRING.equals(trim(text));
    }

    /**
     * Checks if the given text is equal to the given regex.
     *
     * @param text the text to check
     * @param regex the regex to match
     * @return true if the text matches the regex, false otherwise
     */
    public boolean validMatch(String text, String regex) {
        return getDefaultText(text).matches(getDefaultText(regex));
    }
}
