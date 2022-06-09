package com.moss.algorithm.bk.baekjoon.bk_0226._04_1987_알파벳;

import java.util.Scanner;

public class Main {
    static int R;
    static int C;
    static char[][] array;
    static boolean[] used = new boolean['Z' - 'A' + 1];
    static int result = 1;
    
    public static char EMPTY = '1';

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        array = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                array[i][j] = EMPTY;
            }
        }
        for (int i = 0; i < R; i++) {
            char[] row = scanner.next().toCharArray();
            array[i] = row;
        }
        
        DFS(0, 0, 1);
      
        System.out.println(result);
        scanner.close();
    }
    
    public static void DFS(int r, int c, int length) {
        int index = array[r][c] - 'A';
        used[index] = true;
        
        boolean canFindPath = false;
        // 상
        if (r > 0) {
            int up = array[r - 1][c];
            if (up != EMPTY && !used[up - 'A']) {
                canFindPath = true;
                DFS(r - 1, c, length + 1);
            }
        }
        // 하
        if (r < R - 1) {
            int down = array[r + 1][c];
            if (down != EMPTY && !used[down - 'A']) {
                canFindPath = true;
                DFS(r + 1, c, length + 1);
            }
        }
        
        // 좌
        if (c > 0) {
            int left = array[r][c - 1];
            if (left != EMPTY && !used[left - 'A']) {
                canFindPath = true;
                DFS(r, c - 1, length + 1);
            }
        }
        
        // 우
        if (c < C - 1) {
            int right = array[r][c + 1];
            if (right != EMPTY && !used[right - 'A']) {
                canFindPath = true;
                DFS(r, c + 1, length + 1);
            }
        }
        used[index] = false;
        
        // 막다른 길인경우 최장길이 확인 후 업데이트
        if (!canFindPath && result < length) {
            result = length;
        }
    }

}
