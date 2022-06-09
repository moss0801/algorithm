package com.moss.algorithm.bk.baekjoon.bk_prime._01_1978_소수찾기;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 소수 찾기
        int MAX = 1000;
        boolean[] prime = new boolean[MAX+1];
        for (int i = 2; i <= MAX; i++) {
            prime[i] = true;
        }
        for (int i = 2; i <= MAX; i++) {
            if (prime[i]) {
                for (int j = i+i; j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }
        
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int result = 0;
        for (int i = 0; i < length; i++) {
            int input = scanner.nextInt();
            if (prime[input]) {
                result++;
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
