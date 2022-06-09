package com.moss.algorithm.bk.baekjoon.bk_dp._05_1149_RGB거리;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] red = new int[n + 1];
        int[] green = new int[n + 1];
        int[] blue = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            red[i] = scanner.nextInt();
            green[i] = scanner.nextInt();
            blue[i] = scanner.nextInt();
        }
        
        int[] calcRed = new int[n + 1];
        int[] calcGreen = new int[n + 1];
        int[] calcBlue = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            calcRed[i] = Math.min(calcGreen[i-1], calcBlue[i-1]) + red[i];
            calcGreen[i] = Math.min(calcRed[i-1], calcBlue[i-1]) + green[i];
            calcBlue[i] = Math.min(calcGreen[i-1], calcRed[i-1]) + blue[i];
        }
        
        int min = Math.min(calcRed[n], calcGreen[n]);
        min = Math.min(min, calcBlue[n]);
        System.out.println(min);
        
        scanner.close();
    }

}
