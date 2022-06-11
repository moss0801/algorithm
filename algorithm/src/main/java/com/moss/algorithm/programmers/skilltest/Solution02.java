package com.moss.algorithm.programmers.skilltest;

/**
 * 지갑 크기 정하기
 *
 * 모든 명함을 수납할 수 있는 가장 작은 지갑 구하기기 */
public class Solution02 {
    public int solution(int[][] sizes) {
        int resultW = 0;
        int resultH = 0;
        int resultSize = 0;
        for (int i = 0; i < sizes.length; i++) {
            int[] size = sizes[i];
            int w = size[0];
            int h = size[1];

            if (resultW >= w && resultH >= h) {
                continue;
            }

            // 세로 가로 길이 결정
            // 1. normal
            int normalW = Math.max(resultW, w);
            int normalH = Math.max(resultH, h);
            int normalSize = normalW * normalH;

            // 2. change
            int changeW = Math.max(resultW, h);
            int changeH = Math.max(resultH, w);
            int changeSize = changeW*changeH;

            if (normalSize < changeSize) {
                resultW = normalW;
                resultH = normalH;
                resultSize = normalSize;
            } else {
                resultW = changeW;
                resultH = changeH;
                resultSize = changeSize;
            }
        }

        return resultSize;
    }
}
