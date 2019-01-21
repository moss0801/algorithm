package com.moss.algorithm._008_3523_POJ_Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        // 미완료
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int sum = 0;
        int[] list = new int[length];
        for (int i = 0; i < length; i++) {
            int input = scanner.nextInt();
            sum += input;
            list[i] = input;
        }
        Arrays.sort(list);
        
        // 긴 길이부터 
        int result = 0;
        for (int i = length - 1; i > 0; i--) {
            result += sum;
            sum -= list[i];
        }
        
        System.out.println(result);
        scanner.close();
    }
}
