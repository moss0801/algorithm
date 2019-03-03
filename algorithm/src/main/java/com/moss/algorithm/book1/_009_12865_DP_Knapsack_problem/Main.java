package com.moss.algorithm.book1._009_12865_DP_Knapsack_problem;

import java.util.Scanner;

public class Main {
    static int[][] dp;
    static int[] weightList;
    static int[] valueList;
    public static void main(String args[]) {
        // 입력
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int weight = scanner.nextInt();
        weightList = new int[length];
        valueList = new int[length];
        for (int i = 0; i < length; i++) {
            weightList[i] = scanner.nextInt();
            valueList[i] = scanner.nextInt();
        }
        dp = new int[length+1][weight+1];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= weight; j++) {
                dp[i][j] = -1;
            }
        }
        
        System.out.println(rec(length, 0, weight));
        
        scanner.close();
    }
    
    public static int rec(int length, int i, int j) {
        if (dp[i][j] >= 0) {
            return dp[i][j];
        }
        if (length == i) {
            dp[i][j] = 0;
        } else if (j < weightList[i]) {
            dp[i][j] = rec(length, i+1, j); 
            return rec(length, i+1, j);
        } else {
            int notChoice = rec(length, i+1, j);
            int choice = rec(length, i+1, j - weightList[i]) + valueList[i];
            dp[i][j] = notChoice > choice ? notChoice : choice;
        }
        return dp[i][j];
    }
}
