package com.sld.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Test1 {
    private static final LocalDateTime endDateTime = LocalDateTime
            .ofEpochSecond(1596211200, 0, ZoneOffset.of("+8"));

    public static void main(String[] args) {
        //System.out.println(endDateTime);
        long updateVersion = getSimpleDateLong(LocalDate.now());
        System.out.println(updateVersion);

    }

    public static Long getSimpleDateLong(LocalDate localDate) {
        String pattern = "yyyyMMdd";
        String date = localDate.format(DateTimeFormatter.ofPattern(pattern));
        return getLongObj(date);
    }

    public static Long getLongObj(Object object) {
        return getLongObj(object, 0L);
    }

    public static Long getLongObj(Object object, Long defaultValue) {
        if (null == object) {
            return defaultValue;
        }
        if (object instanceof Number) {
            return ((Number) object).longValue();
        }
        try {
            return Long.parseLong(String.valueOf(object));
        } catch (Exception e) {
            //loggerParseError(e);
            return defaultValue;
        }
    }
}




