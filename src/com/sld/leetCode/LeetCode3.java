package com.sld.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shaold
 * @since 2021-2-4 11:31
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)){
            return 0;
        }
        int count = 1;
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                Map<Character, Character> check = new HashMap();
                for(int k = i; k <= j; k++){
                    if(check.containsKey(chars[k])){
                        check.clear();
                        i++;
                        break;
                    }else{
                        check.put(chars[k],chars[k]);
                    }
                }
                if (count < check.size()){
                    count = check.size();
                }
            }
        }
        return count;
    }
}
