package com.sld.leetCode;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Author: shaold
 * @since 2021-2-1 19:32
 */
public class LeetCode752 {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        LeetCode752 leetCode752 = new LeetCode752();
        String[] strings = {"0201","0101","0102","1212","2002"};
        int i = leetCode752.openLock(strings, "0202");
        System.out.println(i);
        System.out.println(LocalDateTime.now());

    }

    public int openLock(String[] deadends, String target) {
        // 这里必须用set，如果用arrayList或者LinkedList都会超时
        Set<String> deaded = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            deaded.add(deadend);
        }
        Queue<String> queue = new ArrayDeque<>();
        String s = "0000";
        if (deaded.contains("0000")){
            return -1;
        }
        queue.offer(s);
        visited.add(s);
        // why 0
        Integer depth = 0;
        while (!queue.isEmpty()){
            int sz = queue.size();
            // 广度遍历
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();

                if (curr.equals(target)){
                    return depth;
                }
                if (deaded.contains(curr)){
                    continue;
                }
                // 遍历8种情况
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 2; k++) {
                        char[] chars = curr.toCharArray();
                        char c = chars[j];
                        if (k == 0){
                            if (c == '9'){
                                c = '0';
                                chars[j] = c;
                            }else {
                                c += 1;
                                chars[j] = c;
                            }
                        } else {
                            if(c == '0'){
                                c = '9';
                                chars[j] = c;
                            }else {
                                c -= 1;
                                chars[j] = c;
                            }
                        }
                        String s1 = String.valueOf(chars);
                        if (visited.contains(s1)){
                            continue;
                        }
                        visited.add(s1);
                        queue.offer(s1);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}
