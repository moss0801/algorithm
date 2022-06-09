package com.moss.algorithm.bk.baekjoon.bk_string2._03_1701_Cubeeditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        // 앞에서부터 한글자씩 줄여가면되 max값 찾기
        int max = 0;
        for (int i = 0; i < input.length(); i++) {
            int subStringMax = getMax(input.substring(i, input.length()));
            if (max < subStringMax) {
                max = subStringMax;
            }
        }
        System.out.println(max);
    }
    
    // PI배열 생성: O(n)
    // PI배열을 구할 때도 만들어진 PI배열을 이용해서 KMP 원리 활용
    // 문자열의 2번이상 발생하는 최대길이 찾기
    // KMP의 PI배열 생성 로직을 사용 - 1이상이면 적어도 2번이상 발생한다는 것임
    public static int getMax(String pattern) {
        int max = 0;
        int length = pattern.length();
        int matchLength = 0;
        // pattern의 char list
        char[] patternCharList = new char[length];
        // pi배열
        int[] pi = new int[length];
        
        patternCharList = pattern.toCharArray();
        
        for (int i = 1; i < length; i++) {
            while (matchLength > 0 && patternCharList[i] != patternCharList[matchLength]) {
                matchLength = pi[matchLength - 1];
            }
            if (patternCharList[i] == patternCharList[matchLength]) {
                pi[i] = ++matchLength;
                if (max < matchLength) {
                    max = matchLength;
                }
            }
        }
        return max;
    }
}
