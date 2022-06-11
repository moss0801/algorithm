package com.moss.algorithm.codility;

import com.moss.algorithm.colidity.lesson13.FibFrog;
import org.junit.jupiter.api.Test;

public class Lesson13Test {

    @Test
    public void FibFrog() {
        FibFrog FibFrog = new FibFrog();
//        FibFrog.solution(new int[] {0,0,0,1,1,0,1,0,0,0,0});
        int result = FibFrog.solution(new int[] {0,0});
        System.out.println(result);
    }
}
