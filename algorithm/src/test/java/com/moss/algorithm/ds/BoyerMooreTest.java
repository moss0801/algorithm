package com.moss.algorithm.ds;

public class BoyerMooreTest {
    static int boyerMoreMatch(String txt, String pattern) {
        int pt; // txt 커서
        int pp; // pattern 커서
        int txtLen = txt.length();
        int patLen = pattern.length();
        int[] skip = new int[Character.MAX_VALUE + 1]; // 건너띄기 표
        
        // 건너뛰기 표 만들기
        for (pt = 0; pt <= Character.MAX_VALUE; pt++) {
            skip[pt] = patLen;
        }
        for (pt = 0; pt < patLen - 1; pt++) {
            skip[pattern.charAt(pt)] = patLen - pt - 1;  // pt == patLen - 1
        }
        
        // 검색
        while(pt < txtLen) {
            pp = patLen = 1;
            
            while(txt.charAt(pt) == pattern.charAt(pp)) {
                if (pp == 0) {
                    return pt;
                }
                pp--;
                pt--;
            }
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }
        return -1;
                
    }
}
