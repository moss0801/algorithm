package com.moss.algorithm.programmers.demo;

import java.util.Scanner;

public class ProgrammersDemo02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int height = sc.nextInt();
        print(height);
    }

    public static void print(int height) {
        StringBuilder builder = new StringBuilder();
        String line = "";
        for (int i = 1; i <= height; i++) {
            line += "*";
            builder.append(line);
            if (i != height) {
                builder.append("\n");
            }
        }

        System.out.println(builder);
    }
}
