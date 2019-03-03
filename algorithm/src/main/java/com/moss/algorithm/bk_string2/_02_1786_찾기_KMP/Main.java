package com.moss.algorithm.bk_string2._02_1786_찾기_KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://bowbowbow.tistory.com/6#comment5168448
// https://mygumi.tistory.com/61
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열
        String T = br.readLine();
        // 패턴
        String P = br.readLine();
        
        // PI배열
        int[] pi = getPi(P);
        // 일치하는 index
        int patternIndex = 0;
        
        char[] stringCharList = T.toCharArray();
        char[] patternCharList = P.toCharArray();
        int stringLength = T.length();
        int patternLength = P.length();
        
        List<Integer> resultList = new ArrayList<>();
        
        for (int i = 0; i < stringLength; i++) {
            while (patternIndex > 0 && stringCharList[i] != patternCharList[patternIndex]) {
                // 중간단계 건너뛰기
                // pi배열을 이용해서 최대한 재사용할 수 있는 부분 확인
                patternIndex = pi[patternIndex - 1];
            }
            
            if (stringCharList[i] == patternCharList[patternIndex]) {
                if (patternIndex == patternLength - 1) {
                    // 일치부분 확인
                    resultList.add(i - patternLength + 1 + 1);
                    // 다음 문자열을 찾기위한 설정
                    patternIndex = pi[patternIndex];
                } else {
                    patternIndex++;
                }
            }
        }
        
        // 결과 출력
        System.out.println(resultList.size());
        for (Integer index : resultList) {
            System.out.println(index);
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
