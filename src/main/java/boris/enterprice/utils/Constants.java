package boris.enterprice.utils;

import java.util.Date;
import java.util.UUID;

/**
 * Class that contains the constants used in the application.
 */
public final class Constants {

    /**
     * Private constructor to avoid instantiation.
     */
    private Constants() {}

    /**
     * The empty string.
     */
    public static final String EMPTY_STRING = "";

    /**
     * The default UUID string.
     */
    public static final String DEFAULT_UUID_STRING = "00000000-0000-0000-0000-000000000000";

    /**
     * The default UUID.
     */
    public static final UUID DEFAULT_UUID = UtilUUID.getInstance().getUUIDFromString(DEFAULT_UUID_STRING);

    /**
     * The default date.
     */
    public static final Date DEFAULT_DATE = new Date(0);
}
