package com.moss.algorithm.colidity.lesson8;

import java.util.HashMap;
import java.util.Map;

public class EquiLeader {
    public EquiLeader() {
    }

    public int solution(int[] A) {
        // n^2 은 100,000* 100,000이라서 Timeout
        // 1. leader 탐색
        // 2. index별로 leader 수를 couting 하면서 2곳 모두 leader여부 판단

        if (A.length == 1) {
            return 0;
        } else if (A.length == 2) {
            return A[0] == A[1] ? 1 : 0;
        }

        // 리더 찾기
        Map<Integer, Integer> numberCount = new HashMap<>();
        int leader = A[0];
        int maxCount = 1;
        for (int i = 0; i < A.length; i++) {
            int number = A[i];
            Integer count = numberCount.get(number);
            if (count != null) {
                count++;
                if (maxCount < count) {
                    maxCount = count;
                    leader = number;
                }
                numberCount.put(number, count);
            } else {
                numberCount.put(number, 1);
            }
        }

        // 리더 존재여부 확인
        if (!(maxCount > A.length / 2)) {
            return 0;
        }

        // equiLeader 찾기
        int count = 0;
        int leaderCount = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (leader == A[i]) {
                leaderCount++;
            }

            if ((leaderCount > (i+1)/2) && ((maxCount - leaderCount) > (A.length - i - 1)/2)) {
                count++;
            }
        }

        return count;
    }
}
