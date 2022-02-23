package com.sld;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: shaold
 * @since 2021-2-3 20:48
 */
public class LeetCode567 {
    public static void main(String[] args) {
        LeetCode567 leetCode567 = new LeetCode567();
        boolean b = leetCode567.checkInclusion("ab", "eidboaoo");
        System.out.println(b);

    }
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] s = s1.toCharArray();
        char[] chars = s2.toCharArray();
        for (char c : s) {
            need.merge(c, 1, Integer::sum);
        }

        Integer left = 0;
        Integer right = 0;
        Integer start = 0;
        Integer len = Integer.MAX_VALUE;
        Integer valid = 0;
        while (right < s2.length()){
            char aChar = chars[right];
            right++;
            if (need.get(aChar) != null){
                window.merge(aChar, 1, Integer::sum);
                if (window.get(aChar).equals(need.get(aChar))){
                    valid++;
                }
            }
            while(valid.equals(need.size())){
                // 判断修改结果
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                char aChar1 = chars[left];
                left++;

                Integer integer = window.get(aChar1);

                if (Objects.nonNull(need.get(aChar1))){
                    if (need.get(aChar1).equals(window.get(aChar1))){
                        valid--;
                    }
                    window.put(aChar1,integer-1);
                }
            }
        }
        return len == s1.length();
    }
}
