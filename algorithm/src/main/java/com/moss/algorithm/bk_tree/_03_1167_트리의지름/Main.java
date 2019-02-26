package com.moss.algorithm.bk_tree._03_1167_트리의지름;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 트리의 지름
// https://blog.myungwoo.kr/112
public class Main {
    static int NAN = -1;
    static int LENGTH;
    static List<List<Vertext>> list;
    static int[] distance;
    
    public static class Vertext {
        public int vertext;
        public int distance;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LENGTH = scanner.nextInt();
        
        list = new ArrayList<>(LENGTH + 1);
        for (int i = 0; i < LENGTH + 1; i++) {
            list.add(i, new ArrayList<>());
        }

        // 입력
        for (int i = 1; i <= LENGTH; i++) {
            int from = scanner.nextInt();
            while(true) {
                int to = scanner.nextInt();
                if (-1 == to) {
                    break;
                }
                int distance = scanner.nextInt();
                Vertext node = new Vertext();
                node.vertext = to;
                node.distance = distance;
                list.get(from).add(node);
            }
            
        }
        
        Vertext first = bfs(1);
        Vertext second = bfs(first.vertext);
        
        
        System.out.println(second.distance);
        scanner.close();
    }
    
    public static Vertext bfs(int start) {
        distance = new int[LENGTH + 1];
        for (int i = 1; i <= LENGTH; i++) {
            distance[i] = NAN;
        }
        Queue<Integer> queue = new LinkedList<>();
        distance[start] = 0;
        queue.offer(start);
        
        int max = 0;
        int maxVertex = start;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (Vertext child : list.get(from)) {
                if (distance[child.vertext] != NAN) {
                    continue;
                }
                distance[child.vertext] = distance[from] + child.distance;
                if (max < distance[child.vertext]) {
                    max = distance[child.vertext];
                    maxVertex = child.vertext;
                }
                queue.offer(child.vertext);
            }
        }
        Vertext result = new Vertext();
        result.vertext = maxVertex;
        result.distance = max;
        return result;
    }
}
