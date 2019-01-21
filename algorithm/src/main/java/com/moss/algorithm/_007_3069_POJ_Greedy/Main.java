package com.moss.algorithm._007_3069_POJ_Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int range=0, length =0;
        while (true) {
            range = scanner.nextInt();
            length = scanner.nextInt();
            if (range == -1 && length == -1) {
                break;
            }
            int[] list = new int[length]; 
            for (int i = 0; i < length; i++) {
                list[i] = scanner.nextInt();
            }
            Arrays.sort(list);
            
            int pos = 0;
            int result = 0;
            while(pos < length) {
                // 왼쪽
                int start = list[pos];
                pos++;
                while (pos < length && list[pos] <= start + range) {
                    pos++;
                }
                
                // 오른쪽
                int point = list[pos - 1];
                while (pos < length && list[pos] <= point + range) {
                    pos++;
                }
                
                result++;
            }
            
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}
