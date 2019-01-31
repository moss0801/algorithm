package com.moss.algorithm.bk_prime._02_2581_소수;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 소수 찾기
        int MAX = 10000;
        // O(n)
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
        
        int min = -1;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        for (int i = m; i <= n; i++) {
            if (prime[i]) {
                sum += i;
                if (min < 0) {
                    min = i;
                }
            }
        }
        if (min < 0) {
            System.out.println(min);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
        
        scanner.close();

    }

}
