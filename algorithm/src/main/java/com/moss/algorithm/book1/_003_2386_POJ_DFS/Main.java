package com.moss.algorithm.book1._003_2386_POJ_DFS;

import java.util.Scanner;

// DFS를 while로 풀려면 stack으로 해야 하는듯
public class Main {
    static char[][] arr = null;
    static int n,m;
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next().toCharArray();
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 'W') {
                    dfs(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
        scanner.close();
    }
    
    public static void dfs(int x, int y) {
        // 현재위치를 '.'로 치환
        arr[x][y] = '.';
        
        // 8방향 '.'로 치환
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 'W') {
                    dfs(nx, ny);
                }
                
            }
        }
        return ;
    }
}
