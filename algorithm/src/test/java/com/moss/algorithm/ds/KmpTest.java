package com.moss.algorithm.ds;

import org.junit.Test;

public class KmpTest {
    
    @Test
    public void kmp() {
        System.out.println(kmpMatch("AAABCABDEE", "ABCABD"));
    }

    static int kmpMatch(String txt, String pattern) {
        int pt = 1; // txt 커서
        int pp = 0; // pat 커서
        int[] skip = new int[pattern.length() + 1];
        
        // 건너뛰기 표를 만듭니다.
        skip[pt] = 0;
        // pt - 현재 패턴 index
        // pp - 비교 패턴 index
        while (pt != pattern.length()) {
            if (pattern.charAt(pt) == pattern.charAt(pp)) {
                // 일치
                skip[++pt] = ++pp;
            }  else if (pp == 0) {
                // 처음
                skip[++pt] = pp;
            } else {
                pp = skip[pp];
            }
        }
        
        // 검색
        pt = pp = 0;
        while(pt != txt.length() && pp != pattern.length()) {
            if (txt.charAt(pt) == pattern.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0) {
                pt++;
            } else {
                pp = skip[pp];
            }
        }
        
        if (pp == pattern.length()) {
            return pt - pp;
        }
        return -1;
    }
}
