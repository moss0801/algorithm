package com.moss.algorithm.programmers.skilltest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 가장 작은 수를 제거한 배열을 리턴하는 함수
 * 빈 배열인 경우 배열에 -1을 채워서 리컨
 */
public class Solution01 {
    public int[] solution(int[] arr) {
        if (arr.length <= 1) {
            return new int[] {-1};
        }

        int[] sort = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sort);
        int min = sort[0];
        int startIndex = 0;
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            if (number != min) {
                answerList.add(number);
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
