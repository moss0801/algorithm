package com.moss.algorithm.baekjoon._2839_설탕배달;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        
        int result = -1;
        for (int i = input / 5; i >= 0; i--) {
            if ((input - i*5)%3 == 0) {
                result = i + (input - i*5)/3;
                break;
            }
        }
        
        System.out.println(result);
        scanner.close();
    }

}
