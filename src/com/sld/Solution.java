package com.sld;

/**
 * @Author: shaold
 * @since 11:46
 */
class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();

        //System.out.println(s.isReverse("a".toCharArray()));
        System.out.println(s.longestPalindrome("babad"));
        //System.out.println("aaaaaa".substring(0,0));
        //System.out.println(s.isReverse("a".toCharArray()));
    }
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int maxlength = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[chars.length-1]){
                continue;
            }
            for (int j = i; j < chars.length; j++) {
                String substring = s.substring(i, j+1);

                if (isReverse(substring.toCharArray())){
                    if (maxlength < (j - i + 1)){
                        maxlength = j - i + 1;
                        start = i;
                        end = j + 1;
                    }
                }
            }
        }
        return s.substring(start,end);
    }

    public Boolean isReverse(char[] c){
        if (c.length == 1){
            return true;
        }
        int i = 0;
        int j = c.length-1;
        if (i < j){
            while (i < j){
                if (c[i] == c[j]){
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
