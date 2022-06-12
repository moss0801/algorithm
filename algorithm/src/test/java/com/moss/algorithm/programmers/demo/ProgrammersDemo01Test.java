package com.moss.algorithm.programmers.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProgrammersDemo01Test {
    @Test
    public void case1() {
        test(new int[][]{{1,4},{3,4},{3,10}}, new int[] {1,10});
    }

    @Test
    public void case2() {
        test(new int[][]{{1,1},{2,2},{1,2}}, new int[] {2,1});
    }

    private void test(int[][] v, int[] answer) {
        ProgrammersDemo01 programmersDemo01 = new ProgrammersDemo01();
        int[] result = programmersDemo01.solution(v);
        Assertions.assertEquals(answer.length, result.length);
        for (int i = 0; i < answer.length; i++) {
            Assertions.assertEquals(answer[i], result[i]);
        }
    }
}
