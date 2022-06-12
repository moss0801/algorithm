package com.moss.algorithm.programmers.demo;

public class ProgrammersDemo01 {

    public int[] solution(int[][] v) {
        int x = 0, y = 0;
        int[] point1 = v[0];
        int[] point2 = v[1];
        int[] point3 = v[2];

        int candidateX = point1[0];
        int candidateY = point1[1];
        if (candidateX == point2[0]) {
            x = point3[0];
        } else {
            x = candidateX == point3[0] ? point2[0] : candidateX;
        }

        if (candidateY == point2[1]) {
            y = point3[1];
        } else {
            y = candidateY == point3[1] ? point2[1] : candidateY;
        }

        return new int[] {x, y};
    }
}
