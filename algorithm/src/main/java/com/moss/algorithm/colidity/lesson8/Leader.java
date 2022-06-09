package com.moss.algorithm.colidity.lesson8;

import java.util.*;

public class Leader {

    public int solution(int[] A) {
        if (A.length == 0) {
            return -1;  // not exist
        }
        if (A.length == 1) {
            return 0;  // index 0
        }

        // number별 index 목록 조회
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        int maxNumber = A[0];
        int maxCount = 1;
        for (int i = 0; i < A.length; i++) {
            Integer count = countMap.get(A[i]);
            if (count != null) {
                count++;
                if (maxCount < count) {
                    maxCount = count;
                    maxNumber = A[i];
                }
                countMap.put(A[i], count);
            } else {
                countMap.put(A[i], 1);
                indexMap.put(A[i], i);
            }
        }
        // 모두 동일한 값인 경우
        if (countMap.size() == 1) {
            return 0;  // index 0
        }

        // dominator가 존재하면 결과 반환
        if (maxCount > (A.length / 2)) {
            return indexMap.get(maxNumber);
        }
        // dominator가 없으면 -1 반환
        return -1;
    }
}
