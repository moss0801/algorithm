package com.moss.algorithm.bk_tree_min._01_1753_최단경로;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 벨만-포드 알고리즘
// 단일 시작점(출발점) 최단경로 문제
public class Main2 {
    static int INF = Integer.MAX_VALUE;
    
    public static class Edge {
        public int from;
        public int to;
        public int weight;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        int start = scanner.nextInt();
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            Edge edge = new Edge();
            edge.from = scanner.nextInt();
            edge.to = scanner.nextInt();
            edge.weight = scanner.nextInt();
            edgeList.add(edge);
        }
        
        // 최단거리 계산
        int[] distance = new int[V+1];
        for (int i = 0; i < V+1; i++) {
            distance[i] = INF;
        }
        distance[start] = 0;
        
        while (true) {
            boolean update = false;
            for (int i = 0; i < E; i++) {
                Edge edge = edgeList.get(i);
                if (distance[edge.from] != INF && distance[edge.to] > distance[edge.from] + edge.weight) {
                    distance[edge.to] = distance[edge.from] + edge.weight;
                    update = true;
                }
            }
            if (!update) {
                break;
            }
        }
        
        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
        
        scanner.close();
    }

}
