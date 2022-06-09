package com.moss.algorithm.bk.baekjoon.bk_bfs._01_7569_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final int RIPE = 1;
    private static final int RAW = 0;
    private static final int EMPTY = -1;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 상자가로
        int M = scanner.nextInt();
        // 상자세로
        int N = scanner.nextInt();
        // 상자높이
        int H = scanner.nextInt();
        
        int[][][] boxes = new int[M][N][H];
        
        int totalCount = 0;
        int completedCount = 0;
        Queue<Position> queue = new LinkedList<>();
        int max = 0;
        // 입력(1: 익은 토마토, 0: 익지않은 토마토, -1: 토마토가 들어있지 않는 칸)
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    boxes[m][n][h] = scanner.nextInt();
                    if (boxes[m][n][h] == EMPTY) {
                        // 토마토가 없는 경우
                        continue;
                    }
                    // 전체 토마토개수 카운트
                    totalCount++;
                    if (boxes[m][n][h] == RIPE) {
                        // 익은 토마토 카운트
                        completedCount++;
                        queue.offer(new Position(m, n, h));
                    }
                }
            }
        }
        
        if (totalCount == completedCount) {
            // 모두익은상태
            System.out.println("0");
            scanner.close();
            return;
        }
        
        while(!queue.isEmpty()) {
            Position position = queue.poll();
            int m = position.getM();
            int n = position.getN();
            int h = position.getH();
            // 위
            if (h < H-1 && boxes[m][n][h+1] == RAW) {
                completedCount++;
                boxes[m][n][h+1] = boxes[m][n][h] + 1;
                if (max < boxes[m][n][h+1]) {
                    max = boxes[m][n][h+1];
                }
                queue.offer(new Position(m, n, h+1));
            }
            // 아래
            if (h > 0 && boxes[m][n][h-1] == RAW) {
                completedCount++;
                boxes[m][n][h-1] = boxes[m][n][h] + 1;
                queue.offer(new Position(m, n, h-1));
                if (max < boxes[m][n][h-1]) {
                    max = boxes[m][n][h-1];
                }
            }
            // 왼쪽
            if (m > 0 && boxes[m-1][n][h] == RAW) {
                completedCount++;
                boxes[m-1][n][h] = boxes[m][n][h] + 1;
                queue.offer(new Position(m-1, n, h));
                if (max < boxes[m-1][n][h]) {
                    max = boxes[m-1][n][h];
                }
            }
            // 오른쪽
            if (m < M-1 && boxes[m+1][n][h] == RAW) {
                completedCount++;
                boxes[m+1][n][h] = boxes[m][n][h] + 1;
                queue.offer(new Position(m+1, n, h));
                if (max < boxes[m+1][n][h]) {
                    max = boxes[m+1][n][h];
                }
            }
            // 앞
            if (n > 0 && boxes[m][n-1][h] == RAW) {
                completedCount++;
                boxes[m][n-1][h] = boxes[m][n][h] + 1;
                queue.offer(new Position(m, n-1, h));
                if (max < boxes[m][n-1][h]) {
                    max = boxes[m][n-1][h];
                }
            }
            // 뒤
            if (n < N-1 && boxes[m][n+1][h] == RAW) {
                completedCount++;
                boxes[m][n+1][h] = boxes[m][n][h] + 1;
                queue.offer(new Position(m, n+1, h));
                if (max < boxes[m][n+1][h]) {
                    max = boxes[m][n+1][h];
                }
            }
        }
        
        // 모두 익지 못한 상태
        if (totalCount != completedCount) {
            System.out.println("-1");
            return;
        }
        
        // 결과출력
        System.out.println(max-1);
        
        scanner.close();
        
    }
    
    public static class Position {
        // 가로
        private Integer m;
        // 세로
        private Integer n;
        // 높이
        private Integer h;
        
        public Position(Integer m, Integer n, Integer h) {
            super();
            this.m = m;
            this.n = n;
            this.h = h;
        }
        public Integer getM() {
            return m;
        }
        public Integer getN() {
            return n;
        }
        public Integer getH() {
            return h;
        }
    }
}
