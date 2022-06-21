package com.sld.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: shaold
 * @since rq 20:13
 */
public class Test9 {
    public static void main(String[] args) throws ParseException {

        String s = "1,2,3";
        String[] split = s.split(",");
        int[] array = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        List<Integer> list2 = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(list2);

        String now = LocalTime.now().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        String format = sdf.format(new Date());

        System.out.println(format);

        String s1 = null;
        //s1 = "233";
        if(s1 == null){
            System.out.println("2333333");
        }else{
            System.out.println("11111111111111111");
        }
        LocalDateTime tbPaidTime = LocalDateTime.now();
        String format1 = tbPaidTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(format1);
        String format2 = tbPaidTime.format(DateTimeFormatter.ofPattern("HHmm"));
        System.out.println(format2);



    }
}
