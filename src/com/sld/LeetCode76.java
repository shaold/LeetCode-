package com.sld;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: shaold
 * @since 2021-2-3 16:36
 */
public class LeetCode76 {
    public static void main(String[] args) {
        LeetCode76 leetCode76 = new LeetCode76();
        String s = leetCode76.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd");
        System.out.println(s);

    }
    public String minWindow(String s, String t) {
        // 滑动窗口 需要两个map
        Map<Character, Integer> need = new HashMap<>();
        // window也只关心need中有的char
        Map<Character, Integer> window = new HashMap<>();
        char[] charst = t.toCharArray();
        char[] charss = s.toCharArray();
        // 初始化need
        for (char aChar : charst) {
            need.merge(aChar, 1, Integer::sum);
        }
        Integer valid = 0;
        Integer left = 0;
        Integer right = 0;
        Integer start = 0;
        Integer len = Integer.MAX_VALUE;
        while(right < s.length()){
            // 即将加入滑动窗口的char
            char c = charss[right];
            right++;
            if (need.get(c) != null ){
                if (window.get(c) == null){
                    window.put(c,1);
                }else {
                    Integer integer = window.get(c);
                    window.put(c,integer+1);
                }
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            // 如果滑动窗口中的字符串已经符合条件，左指针向右移
            while (valid.equals(need.size())){
                // 更新最小覆盖子串
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                // 要离开滑动窗口的char
                char c2 = charss[left];
                left++;

                Integer integer = window.get(c2);

                if (Objects.nonNull(need.get(c2))){
                    if (need.get(c2).equals(window.get(c2))){
                        valid--;
                    }
                    window.put(c2,integer-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
