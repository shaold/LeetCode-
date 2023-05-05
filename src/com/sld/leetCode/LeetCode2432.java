package com.sld.leetCode;

public class LeetCode2432 {

    public static void main(String[] args) {
        int[][] logs = {{1,1},{3,7},{2,12},{7,17}};
        int i = new LeetCode2432().hardestWorker(26, logs);
        System.out.println(i);
    }

    public int hardestWorker(int n, int[][] logs) {
        if (logs.length == 1) {
            return logs[0][0];
        }
        int theWorker = logs[0][0];
        int lastEndTime = logs[0][1];
        int maxWorkTime = logs[0][1];
        for (int i = 1; i < logs.length ; i++) {
            int[] log = logs[i];
            int newEndTime = log[1];
            if (newEndTime - lastEndTime > maxWorkTime) {
                theWorker = log[0];
                maxWorkTime = newEndTime - lastEndTime;
            } else if (newEndTime - lastEndTime == maxWorkTime) {
                theWorker = Math.min(theWorker, log[0]);
            }
            lastEndTime = newEndTime;
        }
        return theWorker;
    }
}
