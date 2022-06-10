package com.moss.algorithm.colidity.lesson10;

import java.util.*;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/
 * 배열 A, N개 정수
 * peak : 이웃보다 큰 항목
 * 배열을 같은 수를 가지는 배열로 쪼갠다
 * 모든 블록이 적어도 1개의 peak를 가져야 함
 * 배열의 끝 값도 peak 가능
 * 최대 블록 수를 구하라
 */
public class Peaks {
    public int solution(int[] A) {
        if (A.length <= 2) {
            return 0;
        }

        // peak 탐색
        Set<Integer> flagSet = new HashSet<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i -1] < A[i] && A[i] > A[i + 1]) {
                flagSet.add(i);
            }
        }

        // 나눌수 있는 경우의 수 체크
        int end = (int) Math.sqrt(A.length);
        int max = 0;
        for (int i = 1;  i <= end; i++) {
            if (A.length % i == 0) {
                if (i <= flagSet.size()) {
                    max = Math.max(max, check(A, flagSet, i));
                }
                if ((A.length / i) <= flagSet.size()) {
                    max = Math.max(max, check(A, flagSet, A.length / i));
                }
            }
        }
        return max;
    }

    private int check(int[] A, Set<Integer> flagSet, int divide) {
        int length = A.length / divide;
        int start = 0;
        while (start < A.length) {
            boolean hasFlag = false;
            for (int i = start; i < start + length; i++) {
                if (flagSet.contains(i)) {
                    hasFlag = true;
                    break;
                }
            }
            if (!hasFlag) {
                return 0;
            }
            start += length;
        }
        return divide;
    }
}
