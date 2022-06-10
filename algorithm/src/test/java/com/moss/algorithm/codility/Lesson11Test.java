package com.moss.algorithm.codility;

import com.moss.algorithm.colidity.lesson11.CountNonDivisible;
import com.moss.algorithm.colidity.lesson11.CountSemiprimes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Lesson11Test {

    @Test
    public void countNonDivisible() {
        CountNonDivisible countNonDivisible = new CountNonDivisible();
        int[] result = countNonDivisible.solution(new int[] {3,1,2,3,6});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void countSemiprimes() {
        CountSemiprimes countSemiprimes = new CountSemiprimes();
        //countSemiprimes.solution(26, new int[]{1,4,16}, new int[]{26,10,20});

        countSemiprimes.solution(26, new int[]{1,4,5,7,4,4,4,4,16,16}, new int[]{26,26,26,26,25,26,27,11,20,23});
    }
}
