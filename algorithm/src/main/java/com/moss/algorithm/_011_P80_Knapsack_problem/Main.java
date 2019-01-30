package com.moss.algorithm._011_P80_Knapsack_problem;

import java.util.Scanner;


// 갯수에 제한 없는 배날 문제
// 3중배열 -> 너무 느림
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
                for (int k = 0; k*w[i] <= j; k++) {
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j - k * w[i]] + k*v[i]);
                }
            }
        }
        
        System.out.println(dp[n][W]);
    }
}
