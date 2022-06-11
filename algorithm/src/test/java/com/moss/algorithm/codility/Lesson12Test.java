package com.moss.algorithm.codility;

import com.moss.algorithm.colidity.lesson12.ChocolatesByNumbers;
import com.moss.algorithm.colidity.lesson12.CommonPrimeDivisors;
import org.junit.jupiter.api.Test;

public class Lesson12Test {

    @Test
    public void ChocolatesByNumbers() {
        ChocolatesByNumbers ChocolatesByNumbers = new ChocolatesByNumbers();
        int result = ChocolatesByNumbers.solution(10, 4);
//        int result = ChocolatesByNumbers.solution(10, 3);
        //int result = ChocolatesByNumbers.solution(1, 1);
        //int result = ChocolatesByNumbers.solution(4, 2);
        System.out.println(result);

    }

    @Test
    public void CommonPrimeDivisors() {
        CommonPrimeDivisors CommonPrimeDivisors = new CommonPrimeDivisors();
        CommonPrimeDivisors.solution(new int[] {15,10,3}, new int[] {75,30,5});
    }
}
