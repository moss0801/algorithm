package com.moss.algorithm._006_3617_POJ_Greedy;

import java.util.Scanner;

// http://poj.org/problem?id=3617
public class Main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        char[] input = new char[length];
        for (int i = 0; i < length; i++) {
            input[i] = scanner.next().toCharArray()[0];
        }
        char[] result = new char[length];
        int resultCount = 0;
        int left = 0, right = length - 1;
        while(left <= right) {
            boolean front = true;
            for (int i = 0; left + i <= right; i++) {
                if (input[left + i] > input[right - i]) {
                    front = false;
                    break;
                } else if (input[left + i] < input[right - i]){
                    front = true;
                    break;
                }
            }
            if (front) {
                result[resultCount] = input[left];
                left++;
            } else {
                result[resultCount] = input[right];
                right--;
            }
            resultCount++;
        }
        
        // 80개씩 나눠서 출력
        int printLength = length / 80;
        if (length % 80 != 0) {
            printLength++;
        }
        String resultString = new String(result);
        for (int i = 0; i < printLength; i++) {
            if (i == printLength - 1) {
                System.out.println(resultString.substring(i*80));
            } else {
                System.out.println(resultString.substring(i*80, (i+1)*80));
            }
            
        }
        
        scanner.close();
    } 
}
