package com.moss.algorithm._012_P80_Knapsack_problem2;

import java.util.Scanner;

// dp[i+1][j] = max(dp[i][j], dp[i+1][j - w[i]] + v[i]);
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int W = scanner.nextInt();
        int[] w = new int[n+1];
        int[] v = new int[n+1];
        for (int i = 0;i < n; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }
        int[][] dp = new int[n+1][W+1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i+1][j] = dp[i][j];
                } else {
                    dp[i+1][j] = Math.max(dp[i][j], dp[i+1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }
}
