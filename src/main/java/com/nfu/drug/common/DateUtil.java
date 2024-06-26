package com.nfu.drug.common;


import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {


    public static String dataConvert(Date date) {
        //"yyyy-MM-dd HH:mm:ss"
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

}
