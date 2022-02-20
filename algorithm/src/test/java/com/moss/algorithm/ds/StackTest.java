package com.moss.algorithm.ds;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class StackTest {

    @Test
    public void stack() {
        Stack<String> stack = new Stack<String>();
        stack.push("test");
        stack.pop();
    }
}
