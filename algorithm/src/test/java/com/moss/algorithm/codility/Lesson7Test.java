package com.moss.algorithm.codility;

import com.moss.algorithm.colidity.lesson7.StoneWall;
import org.junit.jupiter.api.Test;

public class Lesson7Test {

    @Test
    public void stoneWall() {
        StoneWall stoneWall = new StoneWall();
        int result = stoneWall.solution(new int[] {8,8,5,7,9,8,7,4,8});
        System.out.println(result);
    }
}
