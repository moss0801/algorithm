package com.moss.algorithm.bk.baekjoon.bk_0226._02_11724_연결요소의개수;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        int[] connected = new int[N+1];
        
        
        List<List<Integer>> array = new ArrayList<>(N);
        for (int i = 0; i <= N; i++) {
            array.add(new ArrayList<>());
        }
        // 입력
        for (int i = 0; i < M; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            array.get(vertex1).add(vertex2);
            array.get(vertex2).add(vertex1);
        }
        
        // 계산
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (connected[i] == 0) {
                result++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                connected[i] = 1;
                while (!queue.isEmpty()) {
                    Integer from = queue.poll();
                    List<Integer> toList = array.get(from);
                    for (Integer to : toList) {
                        if (connected[to] == 1) {
                            continue;
                        }
                        connected[to] = 1;
                        queue.offer(to);
                    }
                }
            }
        }
        
        System.out.println(result);
        scanner.close();
    }

}
