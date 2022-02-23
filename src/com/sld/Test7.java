package com.sld;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: shaold
 * @since 2020-12-7 21:14
 */
public class Test7 {
    public static void main(String[] args) {
        Integer i = 666;
        System.out.println(i);
        Map map = new HashMap<>();
        map.put("qw",i);
        //System.out.println(map);

        double x1 = 0.026;
        System.out.println(String.format("%.2f", x1));
        AtomicReference<Integer> i3 = new AtomicReference<>();
        Optional<Integer> i1 = Optional.ofNullable(i);
        i1.ifPresent(ii -> {
            i3.set(ii);
    });
        System.out.println(i3);
    }
}
