package com.qiuming.mybatisgenerator.common.util;

public class StringUtil {
    /**
     * 判断字符串是否为空
     * @author QM
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || str == "" || str.length() == 0 || str.trim().length() == 0;
    }

    /**
     * 判断字符串是否不为空
     * @author QM
     * @param string
     * @return
     */
    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }
}
