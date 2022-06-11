package com.moss.algorithm.colidity.lesson16;

/**
 * https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/
 * N개 라인
 * A, B로 시작과 끝 표시
 * 끝점을 기준으로 정렬
 *
 * 겹치치 않는 최대 라인 수
 */
public class MaxNonoverlappingSegments {
    public int solution(int[] A, int[] B) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            count++;
            int start = A[i];
            int end = B[i];
            // 마지막 라인 확인
            if (i + 1 == A.length) {
                break;
            }
            // 겹치는 라인 통과
            for (int j = i+1; j < A.length; j++) {
                int jStart = A[j];
                int jEnd = B[j];
                // 교차 하는 경우
                if (jStart <= end || end == jEnd) {
                    i++;
                    continue;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}
