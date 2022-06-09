package com.moss.algorithm.colidity.lesson5;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 * reference : https://cheolhojung.github.io/posts/algorithm/Codility-MinAvgTwoSlice.html
 *
 * a <= b 일 떄, a와 b의 평균은 a 이상 (a = b 일 때, a와 b의 평균은 a, 즉 두 수가 같은 경우는 a 혹은 b)
 * (a+b) <= (c+d) 일 때, (a,b)와 (c,d)의 평균은 (a+b) 이상이 된다.
 * 결국, 원소가 4개(a,b,c,d)인 그룹은 (a,b)와 (c,d)를 나우었을 때, 각각의 평균의 작은 값 이상이 된다.
 *   2개인 그룹이 작은 값이 되므로 4개의 그룹은 고려할 필요가 없어진다.
 * 예외로 원소가 3개인 그룹에서 2개인 그룹과 1개인 그룹의 경우를 확인해야 하지만, 문제에서 주어진 조건에 의하면 그룹의 원소는 2개 이상이므로 2개와 3개인 그룹만 비교한다.
 */
public class MinAvgTwoSlice {
    public int solution(int[] A) {
        float minAvg = (A[0] + A[1]) / 2f;
        int minIndex =0;

        for (int i = 2; i < A.length; i++) {
            float avg = (A[i - 2] + A[i - 1] + A[i]) / 3f;
            if (minAvg > avg) {
                minAvg = avg;
                minIndex = i -2;
            }

            avg = (A[i - 1] + A[i]) / 2f;
            if (minAvg > avg) {
                minAvg = avg;
                minIndex = i - 1;
            }
        }

        return minIndex;
    }
}
