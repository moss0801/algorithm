package com.moss.algorithm.baekjoon._1152_단어의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte[] input = br.readLine().getBytes();
        int count = 0;
        boolean isSpace = true;
        for (int i = 0; i < input.length; i++) {
            if (!isSpace && input[i] == ' ') {
                count++;
                isSpace = true;
            } else if (isSpace && input[i] == ' ') {
                continue;
            } else if (isSpace && input[i] != ' ') {
                isSpace = false;
            } else {
                // !isSpace && input[i] != ' '
            }
        }
        if (!isSpace) {
            count++;
        }
        System.out.println(count);
    }

}
