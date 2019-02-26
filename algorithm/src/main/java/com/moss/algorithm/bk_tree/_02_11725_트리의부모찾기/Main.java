package com.moss.algorithm.bk_tree._02_11725_트리의부모찾기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int NAN = -1;
        // 입력
        Scanner scanner = new Scanner(System.in);
        int LENGTH = scanner.nextInt();
        
        // 초기화
        List<List<Integer>> list = new ArrayList<>(LENGTH + 1);
        for (int i = 0; i < LENGTH + 1; i++) {
            list.add(i, new ArrayList<>());
        }
        
        for (int i = 0; i< LENGTH - 1; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            
            list.get(vertex1).add(vertex2);
            list.get(vertex2).add(vertex1);
        }
        
        // 부모확인
        int[] result = new int[LENGTH + 1];
        for (int i = 0; i < LENGTH + 1; i++) {
            result[i] = NAN;
        }
        result[1] = 1;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (Integer child : list.get(parent)) {
                if (result[child] != NAN) {
                    continue;
                }
                result[child] = parent;
                queue.offer(child);
            }
        }
        
        // 결과출력
        for (int i = 2; i < LENGTH + 1; i++) {
            System.out.println(result[i]);
        }
        scanner.close();

    }

}
