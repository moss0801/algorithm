package com.moss.algorithm.colidity.demo;

import java.util.Arrays;

public class Demo {
    public int solution(int[] A) {
        Arrays.sort(A);
        int min = 1;
        for (int i = 0; i < A.length; i++) {
            int number = A[i];
            if (number <= 0) {
                continue;
            }
            // 가장 작은 수 발견
            if (number > min) {
                return min;
            }
            // 같은 수 발견
            while (i + 1 < A.length) {
                if (A[i + 1] == min) {
                    i++;
                } else {
                    break;
                }
            }
            min++;
        }
        return min;
    }
}
