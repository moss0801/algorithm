package com.moss.algorithm.colidity.lesson10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/
 *
 * 배열 A, N개 정수
 * peak 는 이웃 값 보다 큰 항목
 *
 *
 * 1. flag 위치 및 총 개수를 구함
 * 2. flag의 최대 개수를 어떻게 구할까?
 *
 */
public class Flags {
    public int solution(int[] A) {
        if (A.length <= 2) {
            return 0;
        }

        // peak 찾기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i-1] < A[i] && A[i] > A[i+1]) {
                queue.offer(i);
                i++;
            }
        }
        // flag가 2개 미만
        if (queue.size() < 2) {
            return queue.size();
        }

        // 거리는 총 꼽는 깃발 개수
        // 각 깃발은 꼽는 깃발 개수만큼 거리가 떨어져야 함
        int totalFlagCount = queue.size();
        int[] flags = new int[totalFlagCount];
        for (int i = 0; i < totalFlagCount; i++) {
            flags[i] = queue.poll();
        }

        int max = 0;
        for (int distance = 2; distance <= totalFlagCount; distance++) {
            int start = flags[0];
            int count = 1;
            for (int i = 1; i < flags.length; i++) {
                int end = flags[i];
                int d = end - start;
                // distance 확인
                if (d >= distance) {
                    count++;
                    start = end;
                    // count가 distance에 도달 확인
                    if (count == distance) {
                        break;
                    }
                }
            }

            // 깃발 개수 증가여부 확인
            if (count > max) {
                max = count;
            } else {
                // 더이상 증가하지않으면 종료
                // distance가 증가하여 더 큰 값이 나오기 어려움
                break;
            }
        }
        return max;
    }
}
