package com.moss.algorithm.colidity.lesson17;

/**
 * N 0~N-1
 * 배열 A, N 정수
 * square는 mark 가능
 * 게임 시작시 square에 0
 * pebble : 조약돌, 자갈
 * 최대값 반환
 */
public class NumberSolitaire {
    public int solution(int[] A) {
        int[] result = new int[A.length];
        result[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            int number = A[i];
            int max = Integer.MIN_VALUE;
            int endIndex = Math.max(0, i - 6);
            for (int j = i-1; j >= endIndex; j--) {
                max = Math.max(max, number + result[j]);
            }
            result[i] = max;
        }

        return result[A.length - 1];
    }
}
