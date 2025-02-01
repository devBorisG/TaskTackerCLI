package boris.enterprice.utils;

/**
 * Utility class for object operations.
 */
public final class UtilObject {

    /**
     * The singleton instance of the class.
     */
    private static final UtilObject INSTANCE = new UtilObject();

    /**
     * Private constructor to prevent instantiation.
     */
    private UtilObject() {}

    /**
     * Returns the singleton instance of the class.
     *
     * @return the singleton instance
     */
    public static UtilObject getInstance() {
        return INSTANCE;
    }

    /**
     * Checks if the given object is null.
     *
     * @param object the object to check
     * @param <T> the type of the object
     * @return true if the object is null, false otherwise
     */
    public <T> boolean isNull(T object) {
        return object == null;
    }

    /**
     * Returns the default value if the given object is null.
     *
     * @param object the object to check
     * @param defaultValue the default value
     * @param <T> the type of the object
     * @return the object if it is not null, the default value otherwise
     */
    public <T> T getDefaultIfNull(T object, T defaultValue) {
        return (isNull(object)) ? defaultValue : object;
    }
}
