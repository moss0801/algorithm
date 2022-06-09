package com.moss.algorithm.bk.baekjoon.bk_dp._03_2579_계단_오르기;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int[] step0 = new int[n+1];  // 2칸 이동한 경우
        int[] step1 = new int[n+1];  // 1칸 1번 이동한 경우
        
        step1[1] = arr[1];
        if (n > 1) {
            step0[2] = arr[2];
            step1[2] = step1[1] + arr[2];
        }
        
        for (int i = 3; i <= n; i++) {
            step0[i] = Math.max(step0[i -2], step1[i - 2]) + arr[i];
            step1[i] = step0[i-1] + arr[i];
        }
        System.out.println(Math.max(step0[n],step1[n]));
        scanner.close();
    }

}
