package com.moss.algorithm.bk_0225._05_10808_알파벳개수;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 입력받기
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        
        // 카운트
        int[] result = new int['z' - 'a' + 1];
        for (char c : input.toCharArray()) {
            result[c-'a']++;
        }
        
        // 결과출력
        for (int count : result) {
            System.out.print(count + " ");
        }
        
        scanner.close();
    }
}
