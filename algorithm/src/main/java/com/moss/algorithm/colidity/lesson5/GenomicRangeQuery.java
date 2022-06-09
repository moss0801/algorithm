package com.moss.algorithm.colidity.lesson5;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 * reference : https://stroot.tistory.com/96
 *
 */
public class GenomicRangeQuery {
    // A, C, G, T
    public int[] solution(String S, int[] P, int[] Q) {
        // A,C,G,T 별 해당 값이 존재할 때 +1 한 prefixSums 계산
        int[][] prefixSums = new int[5][S.length() + 1];
        for (int i = 1; i <= S.length(); i++) {
            char c = S.charAt(i - 1);
            int index = 0;
            switch (c) {
                case 'A': index = 1; break;
                case 'C': index = 2; break;
                case 'G': index = 3; break;
                default: index = 4; // T
            }
            if (i == 1) {
                prefixSums[index][i] = 1;
                continue;
            }

            for (int j = 1; j <= 4; j++) {
                if (j == index) {
                    prefixSums[j][i] = prefixSums[j][i-1] + 1;
                } else {
                    prefixSums[j][i] = prefixSums[j][i-1];
                }
            }
        }

        // prefixSums의 start - 1와 end 의 값이 다르면 중간에 해당 값이 존재
        // A,C,G,T 순으로 존재여부 체크하
        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int start = P[i] + 1;
            int end = Q[i] + 1;

            for (int j = 1; j <=4 ; j++) {
                if (prefixSums[j][end] - prefixSums[j][start - 1] > 0) {
                    result[i] = j;
                    break;
                }
            }
        }

        return result;
    }
}
