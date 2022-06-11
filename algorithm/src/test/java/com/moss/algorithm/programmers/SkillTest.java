package com.moss.algorithm.programmers;

import com.moss.algorithm.programmers.skilltest.Solution01;
import com.moss.algorithm.programmers.skilltest.Solution02;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SkillTest {

    @Test
    public void Solution01() {
        Solution01 Solution01 = new Solution01();
        //int[] result = Solution01.solution(new int[] {4,3,2,1});
        int[] result = Solution01.solution(new int[] {10});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void Solution02() {
        Solution02 Solution02 = new Solution02();
//        int result = Solution02.solution(
//                new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}
//        );
//        int result = Solution02.solution(
//                new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}
//        );
        int result = Solution02.solution(
                new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 1}}
        );

        System.out.println(result);
    }
}
