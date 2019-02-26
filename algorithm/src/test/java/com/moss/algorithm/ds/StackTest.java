package com.moss.algorithm.ds;

import java.util.Stack;

import org.junit.Test;

public class StackTest {

    @Test
    public void stack() {
        Stack<String> stack = new Stack<String>();
        stack.push("test");
        stack.pop();
    }
}
