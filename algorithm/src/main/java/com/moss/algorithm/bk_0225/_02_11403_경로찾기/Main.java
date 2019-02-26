package com.moss.algorithm.bk_0225._02_11403_경로찾기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 정점개수
    static int N;
    // 입력
    static int[][] input;
    // 도달여부
    static boolean[] reach;
    // 결과
    static int[][] result;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        input = new int[N][N];
        
        // 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = scanner.nextInt();
            }
        }
        
        // 도달여부
        reach = new boolean[N];
        
        // 결과
        result = new int[N][N];
        
        // 계산
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                if (input[i][j] == 1) {
                    result[i][j] = 1;
                    queue.offer(j);
                }
            }
            while(!queue.isEmpty()) {
                int j = queue.poll();
                for (int k = 0; k < N; k++) {
                    // j->k 경로가 없거나 i->k 경로이 이미 표시한 경우 무시
                    if (input[j][k] == 0 || result[i][k] == 1) {
                        continue;
                    }
                    queue.add(k);
                    result[i][k] = 1;
                }
            }
        }
        
        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}


/*for (int i = 1; i <= N; i++) {
    for (int j = 1; j <= N; j++) {
        int isExist = scanner.nextInt();
        if (isExist == 1) {
            // 추가여부
            boolean added = false;
            // 그룹별 한쪽 정점이 존재하면 추가
            for (Set<Integer> group : groups) {
                if (group.contains(i) || group.contains(j)) {
                    group.add(i);
                    group.add(j);
                    added = true;
                    
                    break;
                }
            }
            // 어떤 그룹에도 추가되지 못하였다면 새 그룹 추가
            if (!added) {
                Set<Integer> group = new HashSet<>();
                group.add(i);
                group.add(j);
                groups.add(group);
            }
        }
    }
}

// 결과 생성
for (Set<Integer> group : groups) {
    for (Integer i : group) {
        for (Integer j : group) {
            result[i-1][j-1] = 1;
        }
    }
}*/