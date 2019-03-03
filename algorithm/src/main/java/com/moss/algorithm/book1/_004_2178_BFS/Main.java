package com.moss.algorithm.book1._004_2178_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static char[][] arr = null;
    static int[][] arrLength = null;
    static int n,m;
    static int xDirection[] = {-1 ,0 , 1, 0 };
    static int yDirection[] = {0 ,-1 , 0, 1 };
    static int big = 100000;
    
    public static class Position {
        private int x;
        private int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
    }
    
    public static void main(String args[]) {
        // 입력
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        
        arr = new char[n][m];
        arrLength = new int[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next().toCharArray();
        }
        
        // 거리정보를 저장할 배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrLength[i][j] = big;
            }
        }
        
        // 출발지점 초기화
        Queue<Position> queue = new LinkedList<Position>();
        queue.offer(new Position(0, 0));
        arrLength[0][0] = 1;
        
        // 모든 지점 탐색
        while(!queue.isEmpty()) {
            Position current = queue.poll();
            int x = current.getX();
            int y = current.getY();
            int length = arrLength[x][y];
            
            if (x == n - 1 && y == m - 1) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + xDirection[i];
                int ny = y + yDirection[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == '1' && (length + 1 < arrLength[nx][ny])) {
                    arrLength[nx][ny] = length + 1;
                    queue.offer(new Position(nx, ny));
                }
            }
            
        }
        
        System.out.println(arrLength[n - 1][m - 1]);
        scanner.close();
    }
}
