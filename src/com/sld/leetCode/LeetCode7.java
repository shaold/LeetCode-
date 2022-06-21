package com.sld.leetCode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: shaold
 * @since 2021-7-13 10:10
 */
public class LeetCode7 {

    public static void main(String[] args) {
        LeetCode7 leetCode7 = new LeetCode7();
        int reverse = leetCode7.reverse(-123);
    }

    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        int a = x;
        if (x == 0){
            return 0;
        }
        if (a > 0){
            while (a > 0){
                int i = a%10;
                sb.append(i);
                a = a/10;
            }
            String s = sb.toString();
            System.out.println(s);
            try{
                int integer = Integer.parseInt(s);
                return integer;
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }
        }else {
            while (a < 0){
                int i = a%10;
                sb.append(-i);
                a = a/10;
            }
            String s = sb.toString();
            s = "-"+s;
            try{
                int integer = Integer.parseInt(s);
                return integer;
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }
        }
    }
}
