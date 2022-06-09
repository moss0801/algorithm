package com.moss.algorithm.bk.baekjoon.bk_0226._03_2667_단지번호붙이기;

import java.util.LinkedList;
import java.util.PriorityQueue;
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
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력
        int N = scanner.nextInt();
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] row = scanner.next().toCharArray();
            for (int j = 0; j < N; j++) {
                array[i][j] = (row[j] == '0' ? 0 : 1); 
            }
        }
        
        PriorityQueue<Integer> result = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (array[i][j] == 1) {
                    int count = 1;
                    array[i][j] = 0;
                    Queue<Position> queue = new LinkedList<>();
                    queue.offer(new Position(i, j));
                    while(!queue.isEmpty()) {
                        Position target = queue.poll();
                        if (target.m > 0 && array[target.m - 1][target.n] == 1) {
                            count++;
                            array[target.m - 1][target.n] = 0;
                            queue.offer(new Position(target.m - 1, target.n));
                        }
                        if (target.n > 0 && array[target.m][target.n - 1] == 1) {
                            count++;
                            array[target.m][target.n - 1] = 0;
                            queue.offer(new Position(target.m, target.n - 1));
                        }
                        if (target.m < N - 1 && array[target.m + 1][target.n] == 1) {
                            count++;
                            array[target.m + 1][target.n] = 0;
                            queue.offer(new Position(target.m + 1, target.n));
                        }
                        if (target.n < N - 1 && array[target.m][target.n + 1] == 1) {
                            count++;
                            array[target.m][target.n + 1] = 0;
                            queue.offer(new Position(target.m, target.n + 1));
                        }
                    }
                    result.offer(count);
                }
            }
        }
        
        System.out.println(result.size());
        while(!result.isEmpty()) {
            System.out.println(result.poll());
        }
        
        scanner.close();

    }

}
