package com.moss.algorithm.bk_greedy._02_11047_동전0;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 동전종류
        int N = scanner.nextInt();
        
        // 만들어야 하는 동전가치
        int K = scanner.nextInt();
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); 
        for (int i = 0; i < N; i++) {
            queue.offer(scanner.nextInt());
        }
        
        // 동전개수
        int result = 0;
        while(!queue.isEmpty()) {
            Integer value = queue.poll();
            while (K >= value) {
                K -= value;
                result++;
            }
        }
        // 결과 출력
        System.out.println(result);
        
        scanner.close();
    }

}
