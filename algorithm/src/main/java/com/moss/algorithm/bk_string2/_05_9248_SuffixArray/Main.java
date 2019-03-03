package com.moss.algorithm.bk_string2._05_9248_SuffixArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// SuffixArray
// Suffix Array: https://www.crocus.co.kr/613
// LCP: https://www.crocus.co.kr/614
// https://blog.myungwoo.kr/57
public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    
    /*public static Suffix[] createSuffixArray(String string) {
        Suffix[] suffix = new Suffix[string.length()];
        for (int i=0; i<string.length(); i++) {
            suffix[i] = new Suffix(string.substring(i), i + 1);
        }
        alphabeticalOrder(suffix);
        for (int i=0; i<suffix.length; i++) {
            suffix[i].setIndex(i + 1);
        }
        return suffix;
    }
    
    public static class Suffix {
        private String text;
        private int index;
    }*/
}
