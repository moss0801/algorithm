package com.moss.algorithm.baekjoon._9498_시험성적;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        
        String result = null;
        if (input < 60) {
            result = "F";
        } else if (input < 70) {
            result = "D";
        } else if (input < 80) {
            result = "C";
        } else if (input < 90) {
            result = "B";
        } else {
            result = "A";
        }
        System.out.println(result);
        scanner.close();

    }

}
