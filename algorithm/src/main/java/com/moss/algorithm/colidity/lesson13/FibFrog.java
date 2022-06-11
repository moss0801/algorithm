package com.moss.algorithm.colidity.lesson13;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * -1 => N
 * jump F(K) -> K번째 피보나치 수
 * N 방향으로만 점프 가능
 * 나뭇잎은 배열 A에 표현 0: 나뭇잎 없음. 1: 나뭇잎 있음
 * 최소 점프 수
 * N에 도착할 수 없다면 -1 반환
 *
 * https://jackjeong.tistory.com/47
 * 
 * 내가 다시 고민해야 하는 문제
 * Edge Case를 너무 틀린다.
 */
public class FibFrog {
    public int solution(int[] A) {
        int N = A.length;
        if (N == 0 || N == 1) {
            return 1;
        }

        int count = 0;

        // 피보나치 수열
        Integer[] fiboList = new Integer[N+3];
        fiboList[0] = 0;
        fiboList[1] = 1;
        int fiboLen = 2;
        for (int i = 2; i < N+3; i++) {
            fiboList[i] = fiboList[i-1] + fiboList[i-2];
            fiboLen++;
            if (fiboList[i] > N) {
                break;
            }
        }
        fiboList = Arrays.copyOf(fiboList, fiboLen);
        Arrays.sort(fiboList, Collections.reverseOrder());
        //System.out.println(Arrays.toString(fiboList));

        // 점프
        Queue<Point> queue = new LinkedList<>();
        boolean[] check = new boolean[N+1];

        queue.add(new Point(-1, 0));

        while(!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int fibo : fiboList) {
                int next = currentPoint.x + fibo;
                if (next == N) {
                    return currentPoint.count + 1;
                } else if (next < N && next >= 0) {
                    if (A[next] == 1 && !check[next]) {
                        check[next] = true;
                        Point point = new Point(next, currentPoint.count + 1);
                        queue.add(point);
                    }
                }
            }
        }

        return -1;
    }

    public static class Point {
        public int x;
        public int count;

        public Point(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
