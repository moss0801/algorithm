package com.moss.algorithm.bk.baekjoon.bk_0226._01_1012_유기농배추;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    
    public static class Position {
        public int m;
        public int n;
        public Position(int m, int n) {
            super();
            this.m = m;
            this.n = n;
        }
        
        @Override
        public String toString() {
            return "{" + this.m + ", " + this.n + "}";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T != 0) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] array = new int[M][N];
            for (int i = 0; i < K; i++) {
                array[scanner.nextInt()][scanner.nextInt()] = 1;
            }
            
            int result = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (array[i][j] == 1) {
                        result++;
                        Queue<Position> queue = new LinkedList<>();
                        array[i][j] = 0;
                        queue.offer(new Position(i, j));
                        while(!queue.isEmpty()) {
                            Position target = queue.poll();
                            if (target.m > 0 && array[target.m - 1][target.n] == 1) {
                                array[target.m - 1][target.n] = 0;
                                queue.offer(new Position(target.m - 1, target.n));
                            }
                            if (target.n > 0 && array[target.m][target.n - 1] == 1) {
                                array[target.m][target.n - 1] = 0;
                                queue.offer(new Position(target.m, target.n - 1));
                            }
                            if (target.m < M - 1 && array[target.m + 1][target.n] == 1) {
                                array[target.m + 1][target.n] = 0;
                                queue.offer(new Position(target.m + 1, target.n));
                            }
                            if (target.n < N - 1 && array[target.m][target.n + 1] == 1) {
                                array[target.m][target.n + 1] = 0;
                                queue.offer(new Position(target.m, target.n + 1));
                            }
                        }
                        
                    }
                }
            }
            System.out.println(result);
            T--;
        }
        scanner.close();
    }

}
