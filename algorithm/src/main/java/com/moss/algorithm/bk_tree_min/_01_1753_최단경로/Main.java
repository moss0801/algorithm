package com.moss.algorithm.bk_tree_min._01_1753_최단경로;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

// 다익스트라 알고리즘
// 단일 시작점(출발점) 최단경로 문제
public class Main {
    static int INF = Integer.MAX_VALUE;
    
    public static class Edge implements Comparable<Edge> {
        public int from;
        public int to;
        public int weight;
        
        @Override
        public int compareTo(Edge o) {
            if (this.weight == o.weight) {
                return 0;
            }
            return this.weight > o.weight ? 1 : -1;
        }
    }
    
    public static class Min implements Comparable<Min> {
        public int min;
        public int v;
        @Override
        public int compareTo(Min o) {
            if (this.min == o.min) {
                return 0;
            }
            return this.min > o.min ? 1 : -1;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        int start = scanner.nextInt();
        
        Map<Integer, List<Edge>> edgeMap = new HashMap<>();
        for (int i = 1; i <= V; i++) {
            edgeMap.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < E; i++) {
            Edge edge = new Edge();
            edge.from = scanner.nextInt();
            edge.to = scanner.nextInt();
            edge.weight = scanner.nextInt();
            
            edgeMap.get(edge.from).add(edge);
        }
        
        // 최단거리 계산
        int[] distance = new int[V+1];
        for (int i = 0; i < V+1; i++) {
            distance[i] = INF;
        }
        distance[start] = 0;

        PriorityQueue<Min> pq = new PriorityQueue<>();
        Min min = new Min();
        min.min = 0;
        min.v = start;
        pq.add(min);
        
        while(!pq.isEmpty()) {
            Min m = pq.poll();
            if (distance[m.v] < m.min) {
                continue;
            }

            List<Edge> edgeList = edgeMap.get(m.v);
            for (Edge edge : edgeList) {
                if (distance[edge.to] > distance[edge.from] + edge.weight) {
                    distance[edge.to] = distance[edge.from] + edge.weight;
                    Min newMin = new Min();
                    newMin.min = distance[edge.to];
                    newMin.v = edge.to;
                    pq.add(newMin);
                }
                
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
