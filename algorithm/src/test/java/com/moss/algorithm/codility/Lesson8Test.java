package com.moss.algorithm.codility;

import com.moss.algorithm.colidity.lesson8.EquiLeader;
import com.moss.algorithm.colidity.lesson8.Leader;
import org.junit.jupiter.api.Test;

public class Lesson8Test {

    @Test
    public void leader() {
        Leader leader = new Leader();
        int result = leader.solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3});
        System.out.println(result);
    }

    @Test
    public void equiLeader() {
        EquiLeader equiLeader = new EquiLeader();
        int result = equiLeader.solution(new int[] {4, 3, 4, 4, 4, 2});
    }

}
