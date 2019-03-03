package com.moss.algorithm.bk_string2._04_4354_문자열제곱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 제곱
// 전체길이: PI배열(실패함수) 마지막 값이 반복되는 문자의 길이
// 반복수 = 전체길이 / (전체길이 - 실패함수 마지막 값)
// https://www.crocus.co.kr/608
// https://deque.tistory.com/81
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = br.readLine();
            if (".".equals(input)) {
                break;
            }
            
            // PI배열 생성
            int[] pi = getPi(input);
            
            // 반복되는 문자열 길이: 문자열 길이 - PI배열(실패함수) 마지막 값
            // 반복수 = 전체길이 / (전체길이 - 실패함수 마지막 값)
            
            // 마지막 PI값
            int lastPiValue = pi[input.length() - 1];
            // 반복문자열 길이
            int repeatPatternLength = input.length() - lastPiValue;
            if (lastPiValue == 0 || input.length() % repeatPatternLength != 0 || (input.length() / 2 < repeatPatternLength)) {
                // 반복 없음
                // 반복패턴길이가 문자열길이로 나누어 떨어지지 않음
                // 반복패턴길이가 문자열 절반보다 긴경우
                System.out.println("1");
            } else {
                System.out.println(input.length() / (input.length() - lastPiValue));
            }
        }
        
    }
    
    // PI배열 생성: O(n)
    // PI배열을 구할 때도 만들어진 PI배열을 이용해서 KMP 원리 활용
    public static int[] getPi(String pattern) {
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
            }
        }
        
        return pi;
    }
}
