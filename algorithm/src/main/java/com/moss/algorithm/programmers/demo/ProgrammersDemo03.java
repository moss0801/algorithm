package com.moss.algorithm.programmers.demo;

import java.util.Scanner;

public class ProgrammersDemo03 {
    public int[] solution(int n) {
        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            answer[i] = i+1;
        }

        return answer;
    }
}
