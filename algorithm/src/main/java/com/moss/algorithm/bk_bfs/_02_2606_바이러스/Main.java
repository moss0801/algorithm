package com.moss.algorithm.bk_bfs._02_2606_바이러스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> graph = new ArrayList<>();
        // 컴퓨터 수
        int computerNum = scanner.nextInt();
        // 그래프 초기화
        for (int i = 0; i <= computerNum; i++) {
            graph.add(new ArrayList<>());
        }
        // 연결 수
        int edgeCount = scanner.nextInt();
        // 입력
        for (int i = 0; i < edgeCount; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        
        // 연결된 컴퓨터 수 계산
        int connectedCount = 0;
        // 방문여부 체크
        boolean[] visitList = new boolean[computerNum + 1];
        Queue<Integer> queue = new LinkedList<>();
        // 1번컴퓨터 처리
        queue.offer(1);
        connectedCount++;
        visitList[1] = true;
        
        
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            // 연결된 노드중 체크되지 않은 노드 추가
            for (Integer to : graph.get(node)) {
                if (visitList[to] == true) {
                    // 이미 방문하였다면 패스
                    continue;
                }
                // 방문여부 체크
                visitList[to] = true;
                // 결과 수 증가
                connectedCount++;
                queue.offer(to);
            }
        }
        
        // 결과 출력
        System.out.println(connectedCount - 1);
        
        scanner.close();
    }
}
