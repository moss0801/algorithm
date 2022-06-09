package com.moss.algorithm.colidity.lesson9;

/**
 * Edge Case 조심조심
 * 92% 쉽지 않다.
 * https://sustainable-dev.tistory.com/23?category=809125
 * https://sustainable-dev.tistory.com/24?category=811591
 */
public class MaxSliceSum {
    public int solution(int[] A) {
        if (A.length == 1) {
            return A[0];
        }

        int localMax = A[0];
        int globalMax = A[0];

        for (int i = 1; i < A.length; i++) {
            localMax = Math.max(A[i], localMax + A[i]);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }
}
