package com.moss.algorithm.bk_prime._05_9020_골드바흐의추측;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 소수 찾기
        int MAX = 10000;
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
        for (int i = 0; i < length; i++) {
            int input = scanner.nextInt();
            int maxPrime = 0;
            for (int j = 2; j <= input/2; j++) {
                if (prime[j] && prime[input - j]) {
                    maxPrime = j;
                }
            }
            System.out.println(maxPrime + " " + (input - maxPrime));
        }
        scanner.close();
    }
}
