package com.moss.algorithm.book1._002_4307개미;

import java.util.Scanner;

// POJ1852: http://poj.org/problem?id=1852
// https://www.acmicpc.net/problem/4307
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int caseCount  = scanner.nextInt();
        for (int i = 0; i < caseCount; i++) {
            int length = scanner.nextInt();
            int antList[] = new int[scanner.nextInt()];
            for (int j = 0; j < antList.length; j++) {
                antList[j] = scanner.nextInt();
            }
            
            int min = 0, max = 0;
            for (int j = 0; j < antList.length; j++) {
                int input = antList[j];
                
                // 최소값
                int minCompare = input < (length - input) ? input : (length - input);
                min = min > minCompare ? min : minCompare;
                
                // 최대값
                int maxCompare = input > (length - input) ? input : (length - input);
                max = max > maxCompare ? max : maxCompare;
            }
            
            System.out.println(min + " " + max);
        }
    }
}
