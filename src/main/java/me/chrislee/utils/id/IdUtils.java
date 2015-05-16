package me.chrislee.utils.id;

import java.util.UUID;

/**
 * Created by ChrisLee on 15-5-16.
 * 用来生成唯一ID
 */
public class IdUtils {
    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }
}
