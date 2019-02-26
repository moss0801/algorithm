package com.moss.algorithm.bk_0225._03_6603_로또;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] array;
    static int[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            // 길이입력
            N = scanner.nextInt();
            array = new int[N];
            result = new int[N];
            
            // 종료조건 확인
            if (N == 0) {
                break;
            }
            // 입력
            for (int i = 0; i < N; i++ ) {
                array[i] = scanner.nextInt();
            }
            
            // 정렬
            Arrays.sort(array);
            
            
            // 출력 (길이 6) - DFS
            DFS(0, 0);
            System.out.println();
        }
        
        scanner.close();

    }
    public static void DFS(int start, int depth){
        if(depth == 6){
            print();
        }
        for(int i = start; i < N; i++){
            result[i] = 1;
            DFS(i+1, depth+1);
            result[i] = 0;
        }
        
    }
    public static void print(){
        for(int i=0; i<N; i++){
            if(result[i] == 1)
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
