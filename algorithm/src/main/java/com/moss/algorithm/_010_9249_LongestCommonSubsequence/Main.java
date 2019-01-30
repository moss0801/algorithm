package com.moss.algorithm._010_9249_LongestCommonSubsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Suffix Automaton
// https://cp-algorithms.com/string/suffix-automaton.html
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte[] first = br.readLine().getBytes();
        byte[] second = br.readLine().getBytes();
        int[][] length = new int[2][second.length];
        
        int max = 0;
        int maxI = 0;
        for (int i = 0; i < first.length; i++) {
            if (max > first.length-i) {
                break;
            }
            for (int j = 0; j < second.length; j++) {
                if (first[i] == second[j]) {
                    if (i == 0 || j == 0) {
                        length[i%2][j] = 1;
                    } else {
                        length[i%2][j] = length[(i-1)%2][j-1] + 1;
                    }
                } else {
                    length[i%2][j] = 0;
                }
                if (length[i%2][j] > max) {
                    max = length[i%2][j];
                    maxI = i;
                }
            }
        }
        
        System.out.println(max);
        System.out.println(new String(first, maxI - max + 1, max));
    }
}
