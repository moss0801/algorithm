package com.moss.algorithm.book1._009_12865_DP_Knapsack_problem2;

import java.util.Scanner;

// 이해가 안된다.
// https://www.acmicpc.net/problem/12865
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
        
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j <= weight; j++) {
                if (j < weightList[i]) {
                    dp[i][j] = dp[i+1][j];
                } else {
                    int left = dp[i+1][j];
                    int right = dp[i+1][j - weightList[i]] + valueList[i];
                    dp[i][j] = left > right ? left : right;
                }
            }
        }
        
        System.out.println(dp[0][weight]);
        scanner.close();
    }
}
