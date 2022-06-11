package com.moss.algorithm.codility;

import com.moss.algorithm.colidity.lesson16.MaxNonoverlappingSegments;
import org.junit.jupiter.api.Test;

public class Lessson16Test {

    @Test
    public void MaxNonoverlappingSegments() {
        MaxNonoverlappingSegments MaxNonoverlappingSegments = new MaxNonoverlappingSegments();
        //int result = MaxNonoverlappingSegments.solution(new int[] {1,3,7,9,9}, new int[] {5,6,8,9,10});
        int result = MaxNonoverlappingSegments.solution(new int[] {1,3,7,9,9,11}, new int[] {5,6,8,9,10,12});
        System.out.println(result);
    }
}
