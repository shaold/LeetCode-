package com.sld.test;

import java.time.LocalDate;

/**
 * @Author: shaold
 * @since 2021-1-14 10:28
 */
public class Test12 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        for (int i = 0; i < 300; i++) {
            now = now.plusDays(1);
            String s = "INSERT INTO `fancy_app`.`fancy_token_task`(`id`, `expect_token_amount`, `current_token_amount`, `expect_exchange_money`, `current_exchange_money`, `token_per_value`, `min_change_money`, `max_change_money`, `start_time`, `end_time`, `add_time`, `update_time`, `deleted`, `source`, `times_per_day`) VALUES (NULL, 50000, 0, 300, 0.0000, 0.006000000, 1.00, 6.0000, '"+now+" 00:00:00', '"+now+" 23:59:59', NOW(), NOW(), 0, 'platform', 1);";
            System.out.println(s);
        }

        String s = "一二三四五六七八九十十一十二";
        System.out.println(s.length());
        String substring = s.substring(5,6);
        System.out.println(substring);

    }
}
