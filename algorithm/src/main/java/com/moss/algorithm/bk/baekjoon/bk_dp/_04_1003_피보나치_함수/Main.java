package com.moss.algorithm.bk.baekjoon.bk_dp._04_1003_피보나치_함수;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            int n = scanner.nextInt();
            int[] _0 = new int[n+1];
            int[] _1 = new int[n+1];
            _0[0] = 1;
            _1[0] = 0;
            if (n > 0) {
                _0[1] = 0;
                _1[1] = 1;
            }
            for (int j = 2; j <= n; j++) {
                _0[j] = _0[j-1] + _0[j-2];
                _1[j] = _1[j-1] + _1[j-2];
            }
            
            System.out.println(_0[n] + " " +_1[n]);
            
        }
        scanner.close();
    }
}
