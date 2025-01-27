package boris.enterprice.utils;

import java.util.Date;
import java.util.UUID;

public final class Constants {
    private Constants() {}

    public static final String EMPTY_STRING = "";
    public static final String DEFAULT_UUID_STRING = "00000000-0000-0000-0000-000000000000";
    public static final UUID DEFAULT_UUID = UtilUUID.getInstance().getUUIDFromString(DEFAULT_UUID_STRING);

    public static final Date DEFAULT_DATE = new Date(0);
}
