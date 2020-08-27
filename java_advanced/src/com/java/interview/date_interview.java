package com.java.interview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class date_interview {
    public static void main(String[] args) throws ParseException {
        // 请问"2019-11-04 09:30:30"往后1天15小时30分29秒后的时间是多少
//        SimpleDateFormat
        //定义一个字符串
        String date = "2019-11-04 09:30:30";
        //把字符串时间解析成Date日期对象
        // 1 创建一个简单日期格式化对象解析字符串的时间成为日期对象
        // 参数必须与字符串格式完全一致
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //开始解析成日期对象
        Date d1 = sdf.parse(date);
        // L是直接转为long型  得到时间毫秒值 往后+
        long time = d1.getTime() + (24L * 60 * 60 + 15 * 60 * 60 + 30 * 60 + 29) * 1000;
        //得到时间毫秒值 往后+
        System.out.println(sdf.format(time));

    }
}
