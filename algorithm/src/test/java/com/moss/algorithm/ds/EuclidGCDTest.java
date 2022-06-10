package com.moss.algorithm.ds;

/**
 * 최소 공배수 : lcm(a,b) = a*b/gcd(a,b)
 */
public class EuclidGCDTest {
    // 최대 공약수
    static int gcd (int x , int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    static int lcm (int x, int y) {
        return x * y / gcd(x, y);
    }
}
