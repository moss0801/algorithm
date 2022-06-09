package com.moss.algorithm.bk.baekjoon.bk_greedy._03_11399_ATM;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력 수
        int N = scanner.nextInt();
        // 대기시간 오름차순으로 입력받음
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.offer(scanner.nextInt());
        }
        
        // 누적시간
        int accumulateTime = 0;
        // 결과
        int result = 0;
        while (!queue.isEmpty()) {
            int time = queue.poll();
            accumulateTime += time;
            result += accumulateTime;
        }
        
        // 결과출력
        System.out.println(result);
        
        scanner.close();
    }
}
