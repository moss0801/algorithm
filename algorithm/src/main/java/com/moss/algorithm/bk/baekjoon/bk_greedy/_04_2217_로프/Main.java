package com.moss.algorithm.bk.baekjoon.bk_greedy._04_2217_로프;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 로프 수
        int N = scanner.nextInt();
        
        // k개로프, 중량 w -> 각 로프에 고르지 w/k 중량이 걸림
        int[] inputs = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = scanner.nextInt();
        }
        
        // 정렬
        Arrays.sort(inputs);
        
        // 결과 계산
        int max = 0;
        for (int i = 0; i < N; i++) {
            // 가장 작은 중략을 들수 있는 로프와 나머지 로프수의 곱 확인
            int weight = (inputs[i])*(inputs.length - i);
            if (weight > max) {
                // 최대값 체크
                max = weight;
            }
        }
        
        // 결과 출력
        System.out.println(max);
        
        scanner.close();
    }

}
