package com.moss.algorithm.colidity.lesson9;

/**
 * https://sustainable-dev.tistory.com/25
 */
public class MaxDoubleSliceSum {
    public int solution(int[] A) {
        if (A.length == 3) {
            return 0;
        }

        int[] headSum = new int[A.length];
        int[] tailSum = new int[A.length];

        for (int i = 1; i < A.length - 1; i++) {
            headSum[i] = Math.max(0, headSum[i-1] + A[i]);
        }

        for (int i = A.length - 2; i >= 1; i--) {
            tailSum[i] = Math.max(0, tailSum[i+1] + A[i]);
        }

        int maxSum = 0;

        for (int i = 1; i < A.length - 1; i++) {
            maxSum = Math.max(maxSum, headSum[i-1] + tailSum[i + 1]);
        }

        return maxSum;
    }
}
