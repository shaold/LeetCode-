package com.sld;

import java.math.BigDecimal;

/**
 * @Author: shaold
 * @since 2020-12-23 11:39
 */
public class Test10 {
    public static void main(String[] args) {
        //System.out.println(countFlashPrice(BigDecimal.valueOf(100)));
        long l = System.currentTimeMillis();
        System.out.println(l);
    }

    private static BigDecimal countFlashPrice(BigDecimal price){
        BigDecimal result;
        if (price.compareTo(BigDecimal.valueOf(100.0)) > -1){
            // 向上取整
            result = price.subtract(BigDecimal.valueOf(50.0)).setScale(0, BigDecimal.ROUND_UP );
        }else {
            result = price.divide(BigDecimal.valueOf(2.0),0,BigDecimal.ROUND_CEILING);
        }

        return result;
    }
}
