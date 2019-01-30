package com.moss.algorithm._008_3253_POJ_Greedy;

import java.util.Scanner;

// http://poj.org/problem?id=3253
// 하프만부호
public class Main {
    public static void main(String args[]) {
        // 미완료
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] list = new int[length];
        
        for (int i = 0; i < length; i++) {
            int input = scanner.nextInt();
            list[i] = input;
        }
        
        
        // 긴 길이부터
        long result = 0;
        
        while (length > 1) {
            // 가장 짧은 것과 다음으로 짧은 것을 구한다.
            int low1 = 0, low2 = 1;
            if (list[low1] > list[low2]) {
                int tmp = low1;
                low1 = low2;
                low2 = tmp;
            }
            
            for (int i = 2; i < length; i++) {
                if (list[i] < list[low1]) {
                    low2 = low1;
                    low1 = i;
                } else if (list[i] < list[low2]) {
                    low2 = i;
                }
            }
            
            // 합
            int sum = list[low1] + list[low2];
            result += sum;
            
            if (low1 == length - 1) {
                int tmp = low1;
                low1 = low2;
                low2 = tmp;
            }
            list[low1] = sum;
            list[low2] = list[length - 1];
            length--;
        }

        System.out.println(result);
        scanner.close();
    }
}
