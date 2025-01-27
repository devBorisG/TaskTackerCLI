package boris.enterprice.utils;

public final class UtilObject {
    private static final UtilObject INSTANCE = new UtilObject();
    private UtilObject() {}

    public static UtilObject getInstance() {
        return INSTANCE;
    }

    public <T> boolean isNull(T object) {
        return object == null;
    }

    public <T> T getDefaultIfNull(T object, T defaultValue) {
        return (isNull(object)) ? defaultValue : object;
    }
}
