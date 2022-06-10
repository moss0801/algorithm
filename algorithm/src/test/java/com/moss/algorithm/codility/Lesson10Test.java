package com.moss.algorithm.codility;

import com.moss.algorithm.colidity.lesson10.CountFactors;
import com.moss.algorithm.colidity.lesson10.Flags;
import com.moss.algorithm.colidity.lesson10.Peaks;
import org.junit.jupiter.api.Test;

public class Lesson10Test {

    @Test
    public void countFactors() {
        CountFactors countFactors = new CountFactors();
        int result = countFactors.solution(Integer.MAX_VALUE);
        System.out.println(result);
    }

    @Test
    public void flags() {
        Flags flags = new Flags();
        int result = flags.solution(new int[] {1,5,3,4,3,4,1,2,3,4,6,2});
        System.out.println(result);
    }

    @Test
    public void peaks() {
        Peaks peaks = new Peaks();
        int result = peaks.solution(new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2});
        System.out.println(result);
    }
}
