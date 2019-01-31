package com.moss.algorithm.bk_dp._01_1463_1로_만들기;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int INF = Integer.MAX_VALUE;
        
        int[] arr = new int[n + 1];
        arr[1] = 0;
        for (int i = 2; i <= n; i++) {
            int divide3 = INF;
            int divide2 = INF;
            if (i % 3 == 0) {
                divide3 = i / 3;
            }
            if (i % 2 == 0) {
                divide2 = i / 2;
            }
            
            int min = INF;
            if (divide3 != INF) {
                min = arr[divide3];
            }
            if (divide2 != INF) {
                min = Math.min(min, arr[divide2]);
            }
            min = Math.min(arr[i - 1], min);
            
            arr[i] = min+1;
        }
        
        System.out.println(arr[n]);
        scanner.close();
    }

}
