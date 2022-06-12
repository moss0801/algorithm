package com.moss.algorithm.programmers.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProgrammersDemo03Test {
    @Test
    public void case1() {
        test(3, new int[] {1,2,3});
    }

    @Test
    public void case2() {
        test(5, new int[] {1,2,3,4,5});
    }

    private void test(int n, int[] answer) {
        ProgrammersDemo03 programmersDemo03 = new ProgrammersDemo03();
        int[] result = programmersDemo03.solution(n);
        Assertions.assertEquals(answer.length, result.length);
        for (int i = 0; i < answer.length; i++) {
            Assertions.assertEquals(answer[i], result[i]);
        }
    }
}
