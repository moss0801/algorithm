package com.moss.algorithm;

import org.junit.Test;

public class FibTest {
    int input = 40;
    int memo[] = new int[input+1];
    
    @Test
    public void test() {
        System.out.println(fib(input));
    }
    
    private int fib(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = fib(n - 1) + fib(n - 2);
    }
}
