package boris.enterprice.utils;

public final class UtilText {
    private static final UtilText INSTANCE = new UtilText();
    public static final String EMPTY_STRING = "";
    private UtilText() {}

    public static UtilText getInstance() {
        return INSTANCE;
    }

    public boolean isNull(String text) {
        return UtilObject.getInstance().isNull(text);
    }

    public String getDefaultText(String text, String defaultText) {
        return UtilObject.getInstance().getDefaultIfNull(text, defaultText);
    }

    public String getDefaultText(String text) {
        return getDefaultText(text, EMPTY_STRING);
    }

    public String trim(String text) {
        return getDefaultText(text).trim();
    }

    public boolean isEmpty(String text) {
        return EMPTY_STRING.equals(trim(text));
    }

    public boolean validMatch(String text, String regex) {
        return getDefaultText(text).matches(getDefaultText(regex));
    }
}
