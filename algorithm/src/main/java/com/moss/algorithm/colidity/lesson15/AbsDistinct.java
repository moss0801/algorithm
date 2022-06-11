package com.moss.algorithm.colidity.lesson15;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/15-caterpillar_method/abs_distinct/
 *
 * 배열 A, N개 숫자
 * 배열은 오름차순 정렬
 * 절대값 고유 개수 구하기 1, -1은 1개
 */
public class AbsDistinct {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(Math.abs(A[i]));
        }
        return set.size();
    }
}
