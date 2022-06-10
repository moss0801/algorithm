package com.moss.algorithm.colidity.lesson10;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
 * 정수 N, 직사각형 넓이
 * 넓이 N인 직사각형의 최소 주변 길이 찾기
 * 1. /2 한 값의 곱의 조합을 찾고 두 값의 합이 가장 작은 값의 *2 를 결과로 반환
 */
public class MinPerimeterRectangle {
    public int solution(int N) {
        int end = (int) Math.sqrt(N);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= end; i++) {
            if (N % i != 0) {
                continue;
            }

            int sum = i + (N / i);
            if (min > sum) {
                min = sum;
            }
        }
        return min*2;
    }
}
