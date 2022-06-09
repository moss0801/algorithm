package com.moss.algorithm.bk.baekjoon.bk_string2._01_2902_KMP는왜KMP일까;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] parts = input.split("-");
        for (int i = 0; i < parts.length; i++) {
            System.out.print(parts[i].charAt(0));
        }
        scanner.close();
    }

}
