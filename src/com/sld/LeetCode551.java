package com.sld;

/**
 * 学生出勤记录 I
 *
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 *
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 *
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: shaold
 * @since 2021-8-17 21:31
 */
public class LeetCode551 {
    public static void main(String[] args) {
        LeetCode551 leetCode511 = new LeetCode551();
        boolean b = leetCode511.checkRecord("PPALLL");
        System.out.println(b);
    }

    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int countA = 0;
        int conutL = 0;
        boolean a = true;
        boolean l = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A'){
                countA++;
                if (countA >= 2){
                    a = false;
                    break;
                }
                conutL = 0;
            }else if (chars[i] == 'L'){
                conutL++;
                if (conutL == 3){
                    l = false;
                    break;
                }
            }else {
                conutL = 0;
            }
        }
        return a && l;
    }
}
