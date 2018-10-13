package com.foxwho.util;

public class ConvertUtil {
    /**
     * 分割数组
     *
     * @param s
     * @param delimiter
     * @return
     */
    public static final String[] splitToArr(String s, String delimiter) {
        return s.split(delimiter);
    }

    /**
     * 换行符 分割为数组
     *
     * @param s
     * @return
     */
    public static final String[] newLineSplitToArr(String s) {
        return splitToArr(s, "\r");
    }

    /**
     * 回车符 分割为数组
     *
     * @param s
     * @return
     */
    public static final String[] enterSplitToArr(String s) {
        return splitToArr(s, "\n");
    }

    /**
     * 制表符 分割为数组
     *
     * @param s
     * @return
     */
    public static final String[] tabsSplitToArr(String s) {
        return splitToArr(s, "\t");
    }

    /**
     * 逗号 分割为数组
     *
     * @param s
     * @return
     */
    public static final String[] commaSplitToArr(String s) {
        return splitToArr(s, ",");
    }
}
