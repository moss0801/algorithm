package com.moss.algorithm.bk_0226._05_1316_그룹단어체커;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int result = 0;
        for (int i = 0; i < length; i++) {
            boolean[] used = new boolean['z' - 'a' + 1];
            char[] input = scanner.next().toCharArray();
            boolean isGroup = true;
            char prev = input[0];
            for (int j = 1; j < input.length; j++) {
                if (used[input[j] - 'a']) {
                    isGroup = false;
                    break;
                } else if (prev == input[j]) {
                    continue;
                } else {
                    // prev != input[j]
                    used[prev - 'a'] = true;
                    prev = input[j];
                }
            }
            if (isGroup) {
                result++;
            }
        }
        
        System.out.println(result);
        scanner.close();

    }

}
