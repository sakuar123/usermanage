package com.sakura.usermanage.common.util;

import java.util.Random;
import java.util.UUID;

public class CommonsUtil {

    /**
     * 获取ticketID
     * @return ticketID
     */
    public static String getTicketid() {
        return UUID.randomUUID().toString().toLowerCase() + getRandomNumber(0, 999);
    }

    private static int getRandomNumber(int min, int max) {
        Random rd = new Random();
        int ret = rd.nextInt(max);
        while (ret < min)
            ret += rd.nextInt(max - min);
        return ret;
    }
}
