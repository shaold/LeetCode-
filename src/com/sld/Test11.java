package com.sld;

/**
 * @Author: shaold
 * @since 2021-1-5 13:45
 */
public class Test11 {
    public static void main(String[] args) {
        Test11 test11 = new Test11();
        System.out.println(test11.intTime2String(1500));
    }

    private String intTime2String(Integer time){
        String result;
        if(time < 10){
            result = "000" + time;
        }else if(time < 100){
            result = "00" + time;
        }else if (time < 1000){
            result = "0" + time;
        }else {
            result = String.valueOf(time);
        }
        result = result.substring(0,2) + ":" + result.substring(2);
        return result;
    }


}
