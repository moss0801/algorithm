package com.moss.algorithm.codility;

import com.moss.algorithm.colidity.lesson15.AbsDistinct;
import org.junit.jupiter.api.Test;

public class Lesson15Test {

    @Test
    public void absDistinct() {
        AbsDistinct AbsDistinct = new AbsDistinct();
        int result = AbsDistinct.solution(new int[] {-5,-3,-1,0,3,6});
        System.out.println(result);
    }
}
