package com.moss.algorithm.ds;

import org.junit.jupiter.api.Test;

public class CardConvRev {

    
    // 정수값 x를 r진수로 변환하여 배열 d에 아랫자리부터 넣어두고 자릿수를 반환합니다.
    static int cardConvR(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);
        return digits;
    }
    
    @Test
    public void convert() {
        char[] output = new char[100];
        int length = cardConvR(100, 16, output);
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(output[i]);
        }
    }
}
