package com.sld.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shaold
 * @since rq 21:22
 */
public class Test8 {
    public static void main(String[] args) {
        String s = "0,0,0";
        String replace = s.replace(",0,", ",1,");
        System.out.println(replace);

        List<String> list = new ArrayList<>();
        Test8 test8 = new Test8();
        List<String> list1 = test8.getList();
        if (list1 != null){
            System.out.println(list1.size());
        }

        LocalDate now = LocalDate.now();
        System.out.println(now.toString());

        System.out.println("是合理的日期"+isValidDate("2020-12-15"));

    }

    private List<String> getList(){
        return null;
    }

    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }
}
