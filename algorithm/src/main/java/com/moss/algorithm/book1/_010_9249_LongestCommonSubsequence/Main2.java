package com.moss.algorithm.book1._010_9249_LongestCommonSubsequence;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte[] first = scanner.next().getBytes();
        byte[] second = scanner.next().getBytes();
        int[][] length = new int[first.length][second.length];
        
        int max = 0;
        int maxI = 0;
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i] == second[j]) {
                    if (i == 0 || j == 0) {
                        length[i][j] = 1;
                    } else {
                        length[i][j] = length[i-1][j-1] + 1;
                    }
                } else {
                    length[i][j] = 0;
                }
                if (length[i][j] > max) {
                    max = length[i][j];
                    maxI = i;
                }
            }
        }
        
        System.out.println(max);
        System.out.println(new String(first, maxI - max + 1, max));
        scanner.close();
    }
}
