package com.sld.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: shaold
 * @since 2021-2-4 11:32
 */
public class LeetCode438 {

    public static void main(String[] args) {
        LeetCode438 leetCode438 = new LeetCode438();
        List<Integer> anagrams = leetCode438.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);

    }
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        char[] c1 = p.toCharArray();
        char[] c2 = s.toCharArray();
        for (char c : c1) {
            need.merge(c, 1, Integer::sum);
        }

        Integer left = 0;
        Integer right = 0;
        Integer valid = 0;
        while(right < s.length()){
            char c = c2[right];
            right++;

            if (need.get(c) != null){
                window.merge(c, 1, Integer::sum);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            System.out.println(s.substring(left,right));
            while (valid == need.size()){
                // 符合条件
                if (right-left == p.length()){
                    result.add(left);
                }

                // 滑出窗口
                char c3 = c2[left];
                left++;
                if (need.get(c3) != null){
                    if (window.get(c3).equals(need.get(c3))){
                        valid--;
                    }
                    window.put(c3,window.get(c3)-1);
                }
            }
        }
        return  result;
    }
}
