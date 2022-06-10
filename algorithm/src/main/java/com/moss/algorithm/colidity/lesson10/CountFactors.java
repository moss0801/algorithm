package com.moss.algorithm.colidity.lesson10;

/**
 * 양수 D는 양수 N의 factor -> N = D * M
 */
public class CountFactors {

    public int solution(int N) {
        int end = (int)Math.sqrt(N);
        int count = 0;
        for (int i = 1; i <= end; i++) {
            if (N % i == 0) {
                count += 2;
            }
        }

        if (end*end == N) {
            count--;
        }
        return count;
    }
}
