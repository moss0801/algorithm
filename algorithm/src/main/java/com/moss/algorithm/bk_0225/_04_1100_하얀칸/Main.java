package com.moss.algorithm.bk_0225._04_1100_하얀칸;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 입력 및 계산
        Scanner scanner = new Scanner(System.in);
        int length = 8;
        int result = 0;
        for (int i = 0; i < length; i++) {
            String input = scanner.next();
            char[] rows = input.toCharArray();
            for (int j = 0; j < length; j++) {
                char check = rows[j];
                // 행열 index 합이 짝수이면서 'F' 인 경우
                if (( i + j) % 2 == 0 && check == 'F') {
                    result++;
                }
            }
        }
        // 결과
        System.out.println(result);
        scanner.close();
    }
}
