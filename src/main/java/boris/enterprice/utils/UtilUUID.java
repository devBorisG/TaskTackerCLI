package boris.enterprice.utils;

import java.util.UUID;

import static boris.enterprice.utils.Constants.DEFAULT_UUID;
import static boris.enterprice.utils.Constants.DEFAULT_UUID_STRING;

public final class UtilUUID {
    private static final UtilUUID INSTANCE = new UtilUUID();
    private UtilUUID() {}

    public static UtilUUID getInstance() {
        return INSTANCE;
    }

    public UUID getDefaulUUID(final UUID uuid) {
        return UtilObject.getInstance().getDefaultIfNull(uuid, DEFAULT_UUID);
    }

    public boolean isEquals(final UUID uuid1, final UUID uuid2) {
        return getDefaulUUID(uuid1).equals(getDefaulUUID(uuid2));
    }

    public UUID getNewUUID() {
        UUID uuid;
        do uuid = UUID.randomUUID();
        while (isEquals(uuid, DEFAULT_UUID));
        return uuid;
    }

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

    public boolean isNull(UUID value){
        return UtilObject.getInstance().isNull(value);
    }

    public String getStringFromUUID(final UUID uuid) {
        String uuidString = DEFAULT_UUID_STRING;
        if (!isNull(uuid)) {
            uuidString = uuid.toString();
        }
        return uuidString;
    }
}
