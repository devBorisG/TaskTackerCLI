package boris.enterprice.utils;

import java.util.UUID;

import static boris.enterprice.utils.Constants.DEFAULT_UUID;
import static boris.enterprice.utils.Constants.DEFAULT_UUID_STRING;

/**
 * Utility class for UUID operations.
 */
public final class UtilUUID {

    /**
     * Private constructor to prevent instantiation.
     */
    private static final UtilUUID INSTANCE = new UtilUUID();

    /**
     * Private constructor to prevent instantiation.
     */
    private UtilUUID() {}

    /**
     * Gets the instance of UtilUUID.
     *
     * @return the instance
     */
    public static UtilUUID getInstance() {
        return INSTANCE;
    }

    /**
     * Gets the default UUID if the given UUID is null.
     *
     * @param uuid the UUID to check
     * @return the default UUID if the given UUID is null
     */
    public UUID getDefaulUUID(final UUID uuid) {
        return UtilObject.getInstance().getDefaultIfNull(uuid, DEFAULT_UUID);
    }

    /**
     * Checks if two UUIDs are equal.
     *
     * @param uuid1 the first UUID
     * @param uuid2 the second UUID
     * @return true if the UUIDs are equal, false otherwise
     */
    public boolean isEquals(final UUID uuid1, final UUID uuid2) {
        return getDefaulUUID(uuid1).equals(getDefaulUUID(uuid2));
    }

    /**
     * Gets a new UUID.
     *
     * @return the new UUID
     */
    public UUID getNewUUID() {
        UUID uuid;
        do uuid = UUID.randomUUID();
        while (isEquals(uuid, DEFAULT_UUID));
        return uuid;
    }

    /**
     * Gets a UUID from a string.
     *
     * @param uuidString the string to convert
     * @return the UUID from the string
     */
    public UUID getUUIDFromString(final String uuidString) {
        UUID uuid = DEFAULT_UUID;
        if(!UtilText.getInstance().isEmpty(uuidString)) {
            try {
                uuid = UUID.fromString(uuidString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return uuid;
    }

    /**
     * Checks if a UUID is null.
     *
     * @param value the UUID to check
     * @return true if the UUID is null, false otherwise
     */
    public boolean isNull(UUID value){
        return UtilObject.getInstance().isNull(value);
    }

    /**
     * Gets a string from a UUID.
     *
     * @param uuid the UUID to convert
     * @return the string from the UUID
     */
    public String getStringFromUUID(final UUID uuid) {
        String uuidString = DEFAULT_UUID_STRING;
        if (!isNull(uuid)) {
            uuidString = uuid.toString();
        }
        return uuidString;
    }
}
