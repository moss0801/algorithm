package com.moss.algorithm.bk_prime._03_1929_소수구하기;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 소수 찾기
        int MAX = 1000000;
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
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        StringBuilder builder = new StringBuilder(); 
        for (int i = m; i <= n; i++) {
            if (prime[i]) {
                builder.append(i).append("\n");
            }
        }
        
        System.out.println(builder);
        scanner.close();

    }

}
