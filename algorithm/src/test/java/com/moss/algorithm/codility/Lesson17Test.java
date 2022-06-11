package com.moss.algorithm.codility;

import com.moss.algorithm.colidity.lesson17.NumberSolitaire;
import org.junit.jupiter.api.Test;

public class Lesson17Test {
    @Test
    public void NumberSolitaire() {
        NumberSolitaire NumberSolitaire = new NumberSolitaire();
        //int result = NumberSolitaire.solution(new int[] {1,-2,0,9,-1,-2});
        int result = NumberSolitaire.solution(new int[] {1,2});
        System.out.println(result);
    }
}
