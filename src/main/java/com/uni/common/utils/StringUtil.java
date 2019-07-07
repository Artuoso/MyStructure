package com.uni.common.utils;

/**
* @Description 字符串工具类
*
* @author Created by zc on 2019/7/3
*/
public class StringUtil {

    /**
     * 判断传入字符串是否是有效字符串，null、空格、空字符串都是无效字符串
     *
     * @author Created by zc on 2019/7/3
     */
    public static boolean isValid(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * 判断传入字符串是否是无效字符串，null、空格、空字符串都是无效字符串
     *
     * @author Created by zc on 2019/7/3
     */
    public static boolean isInvalid(String str) {
        return !isValid(str);
    }

    /**
     * 将包含Unicode的字符串解码
     *
     * @author Created by zc on 2019/6/12
     */
    public static String decodeUnicode(String includeUnicodeStr) {
        String[] strArr = includeUnicodeStr.split("\\\\U|\\\\u");
        StringBuilder resultStrBud = new StringBuilder(strArr[0]);
            for (int i = 1; i < strArr.length; i++) {
                String code = strArr[i];
                resultStrBud.append((char) Integer.parseInt(code.substring(0, 4), 16));
                if (code.length() > 4){
                    resultStrBud.append(code.substring(4));
                }
            }
        return resultStrBud.toString();
    }

}
