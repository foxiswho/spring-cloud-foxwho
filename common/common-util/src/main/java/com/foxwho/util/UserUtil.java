package com.foxwho.util;

import java.util.UUID;

public class UserUtil {
    /**
     * 匹配手机号码, 支持+86和86开头
     */
    private static final String REGX_MOBILENUM = "^((\\+86)|(86))?(13)\\d{10}$";

    /**
     * 匹配邮箱帐号
     */
    private static final String REGX_EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

    /**
     * 匹配手机号码（先支持1开头的手机号码）.
     *
     * @param inputStr the input str
     * @return the boolean
     */
    public static Boolean isMobileNumber(String inputStr) {
        return !ObjectEmptyNullUtil.isNull(inputStr) && inputStr.matches(REGX_MOBILENUM);
    }

    /**
     * Is email boolean.
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean isEmail(String str) {
        boolean bl = true;
        if (ObjectEmptyNullUtil.isSEmptyOrNull(str) || !str.matches(REGX_EMAIL)) {
            bl = false;
        }
        return bl;
    }

    /**
     * Uuid string.
     *
     * @return the string
     */
    public synchronized static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
