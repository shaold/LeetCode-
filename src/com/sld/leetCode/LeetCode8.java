package com.sld.leetCode;

/**
 * 将字符串转换成一个 32 位有符号整数
 *
 * 题点：对于溢出的处理方式通常可以转换为 INT_MAX 字符串转数字*10时，先转为long和INT_MAX、INT_MIN比较
 * @Author: shaold
 * @since 2021-7-26 13:41
 */
public class LeetCode8 {
    public static void main(String[] args) {
        LeetCode8 leetCode8 = new LeetCode8();
        int i = leetCode8.myAtoi("2147483648");
        System.out.println(i);
    }

    public int myAtoi(String s) {
        // 先去除空格，再看有没有正负号，没有默认正，再取数字，如果不是数字直接返回0，如果是数字取32位，超出的话取极值
        char[] chars = s.toCharArray();
        String substring = s;
        boolean isPlus = true;
        // 去掉开头空格
        if (s.startsWith(" ")){
            int i = 0;
            for (char aChar : chars) {
                if (aChar == ' '){
                    i++;
                }else {
                    break;
                }
            }
            substring = s.substring(i);
        }
        // 判断是否有正负号
        if (substring.startsWith("-") || substring.startsWith("+")){
            if (substring.startsWith("-")){
                isPlus = false;
            }else {
                isPlus = true;
            }
            substring = substring.substring(1);
        }

        if (substring.startsWith("1") ||
                substring.startsWith("2") ||
                substring.startsWith("3") ||
                substring.startsWith("4") ||
                substring.startsWith("5") ||
                substring.startsWith("6") ||
                substring.startsWith("7") ||
                substring.startsWith("8") ||
                substring.startsWith("9") ||
                substring.startsWith("0")){
            // 进入数字处理方法 0?
            char[] chars1 = substring.toCharArray();
            StringBuilder temp = new StringBuilder();
            for (char c : chars1) {
                if (c == '1' || c == '2' || c == '3'|| c == '4'|| c == '5'|| c == '6'|| c == '7'|| c == '8'|| c == '9'|| c == '0'){
                    temp.append(c);
                }else {
                    break;
                }
            }
            String results = temp.toString();
            if (isPlus){
                // 正
                int sum = 0;
                for (int i = 0; i < results.length(); i++) {
                    char c = results.charAt(i);
                    long l = sum;
                    if (l*10 + c - '0' > (long) Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }else {
                        sum = sum*10 + c - '0';
                    }
                }
                return sum;
            }else {
                // 负
                int sum = 0;
                for (int i = 0; i < results.length(); i++) {
                    char c = results.charAt(i);
                    long l = sum;
                    if (l*10 - (c - '0') < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }else {
                        sum = sum*10 - (c - '0');
                    }
                }
                return sum;
            }
        }else {
            return 0;
        }
    }
}
