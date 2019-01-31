package com.moss.algorithm.bk_prime._04_4948_베르트랑공준;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 소수 찾기
        int MAX = 123456*2;
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
        while(true) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            int count = 0;
            for (int i = input+1; i <= input*2; i++) {
                if (prime[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
        

    }

}
