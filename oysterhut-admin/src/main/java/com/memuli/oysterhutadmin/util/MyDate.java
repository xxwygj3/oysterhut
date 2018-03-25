package com.memuli.oysterhutadmin.util;

import com.memuli.oysterhutadmin.controller.RotatePicController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
    private static final Logger LOGGER = LoggerFactory.getLogger(RotatePicController.class);

    //String 转 Date
    public static Date stringToDate(String str, String format) {
        if (StringUtils.isBlank(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = dateFormat.parse(str);
        } catch (ParseException e) {
            LOGGER.error("String类型 转 Date类型出错：" + e);
        }
        return date;
    }

    //Date 转 String
    public static String dateToString(Date date, String format) {
        if (StringUtils.isBlank(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        String strDate = null;
        try {
            if (date != null) {
                strDate = dateFormat.format(date);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            LOGGER.error("Date类型 转 String类型出错：" + e);
        }
        return strDate;
    }
}
