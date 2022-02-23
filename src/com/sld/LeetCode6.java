package com.sld;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 思路：
 * 想成N，用二维数组去填，有点麻烦了，要考虑奇数情况头尾为空
 * @Author: shaold
 * @since 2021-7-9 17:38
 */
public class LeetCode6 {
    public static void main(String[] args) {

        LeetCode6 leetCode6 = new LeetCode6();
        String s = "PAYPALISHIRING";
        String paypalishiring = leetCode6.convert(s, 3);
        System.out.println(paypalishiring);


    }


    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        // 注意特殊条件
        if(numRows == 1){
            return s;
        }
        int num = chars.length/(numRows+numRows-2);
        int i = chars.length%(numRows+numRows-2);
        if (i>numRows){
            num = num*2 + 2;
        }else if (i>0){
            num = num*2 + 1;
        }else {
            num = num*2;
        }
        char[][] newChars = new char[numRows][num];
        int nn = 0;
        for (int j = 0; j < num; j++) {
            if (j%2 == 0){
                // 奇数，全
                for (int k = 0; k < numRows; k++) {
                    if (nn < chars.length){
                        newChars[k][j] = chars[nn];
                    }else {
                        newChars[k][j] = ' ';
                    }
                    nn++;
                }
            }else {
                // 偶数，头尾为空
                newChars[0][j] = ' ';
                newChars[numRows-1][j] = ' ';
                for (int k = numRows-2; k >= 1; k--) {
                    if (nn < chars.length){
                        newChars[k][j] = chars[nn];
                    }else {
                        newChars[k][j] = ' ';
                    }
                    nn++;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < num; k++) {
                char c = newChars[j][k];
                stringBuffer.append(c);
            }
        }
        String s1 = stringBuffer.toString();
        String replace = s1.replace(" ", "");
        return replace;
    }
}
