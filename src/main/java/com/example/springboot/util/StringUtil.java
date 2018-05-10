package com.example.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created with IDEA
 * Author: GuiqiHu
 * Created in: 2018/5/10 20:20
 */
public class StringUtil {

    static int flowNum = 0;

    /*获取连续的ID*/
    public static String getNewflowcode(String prefix) {
        String flowcode = prefix + StringUtil.timeToString(new Date(), "yyyyMMddHHmmss") + StringUtil.getNewFlowNum();
        return flowcode;
    }

    public static String getNewFlowNum() {
        if (flowNum >= 99999999) {
            flowNum = 0;
        }
        flowNum = flowNum + 1;
        String str = String.valueOf(flowNum);
        while (str.length() < 8) {
            str = "0" + str;
        }
        return str;
    }

    public static String timeToString(Date d, String format) {
        SimpleDateFormat localTime = new SimpleDateFormat(format);
        String date = localTime.format(d);
        return date;
    }

    /*  生成随机码，可以自定义长度和类型，比如length设置为6，设置为0123456789，就是出现6位，数字，
        类似的可以设置成不同的字母数字混合验证码*/
    public static String getRandomString(int length, String pw) {
        StringBuffer buffer = new StringBuffer(pw);
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i++) {
            sb.append(buffer.charAt(random.nextInt(range)));
        }
        return sb.toString();
    }
}
