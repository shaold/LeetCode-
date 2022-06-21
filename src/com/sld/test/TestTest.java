package com.sld.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TreeMap;

/**
 * @Author: shaold
 * @since 2020-11-24 11:33
 */
public class TestTest {
    public static void main(String[] args) {
        Long ll = 3002485131L;
        if(ll>Integer.MAX_VALUE){
            System.out.println("大大大");
        }else {
            System.out.println("小小小");
        }

        TreeMap<String,String>  treeMap = new TreeMap<>();
        treeMap.put("aaa","bbb");
        treeMap.put("aaa","ccc");
        System.out.println(treeMap.get("aaa"));

        LocalDate resDate = getCurrentLocalDateWeek(true);
        LocalDateTime resDateTime = null;
        if (true) {
            resDateTime = LocalDateTime.of(resDate, LocalTime.MIN);

        } else {
            resDateTime = LocalDateTime.of(resDate, LocalTime.MAX);

        }
        System.out.println(resDateTime.toString().substring(0,10));
    }

    public static LocalDate getCurrentLocalDateWeek(Boolean isFirst) {

        LocalDate today = LocalDate.now();

        DayOfWeek week = today.getDayOfWeek();
        LocalDate resDate = null;
        int value = week.getValue();
        if (isFirst) {
            resDate = today.minusDays(value - 1);
        } else {
            resDate = today.plusDays(7 - value);
        }
        return resDate;
    }
}
