package com.moss.algorithm.colidity.lesson11;

import java.util.HashMap;
import java.util.Map;

/**
 * https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/
 * 배열 A, N개 정수
 * 항목별 non-divisor 수를 반환
 */
public class CountNonDivisible {
    public int[] solution(int[] A) {
        Map<Integer, Integer> numberCount = new HashMap<>();
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int number = A[i];
            Integer count = numberCount.get(number);
            if (null == count) {
                numberCount.put(number, 1);
            } else {
                numberCount.put(number, count + 1);
            }
            max = Math.max(number, max);
        }

        // 결과 찾기
        int[] result = new int[A.length];
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int number = A[i];
            Integer nonDivisorCount = resultMap.get(number);
            if (null != nonDivisorCount) {
                result[i] = nonDivisorCount;
                continue;
            }

            // O(n^2) : Timeout
            nonDivisorCount = 0;
            // division 합을 찾고, 전체에서 division 합을 빼서 non-division 탐색
            int end = (int)Math.sqrt(number);
            int divisionSum = 0;
            for (int j = 1; j <= end; j++) {
                if (number % j == 0) {
                    Integer count = numberCount.get(j);
                    divisionSum += null != count ? count : 0;

                    if (j*j == number) {
                        continue;
                    }
                    count = numberCount.get(number/j);
                    divisionSum += null != count ? count : 0;
                }
            }

            nonDivisorCount = A.length - divisionSum;
            resultMap.put(number, nonDivisorCount);
            result[i] = nonDivisorCount;
        }

        return  result;
    }
}
