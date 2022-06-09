package com.moss.algorithm.colidity.lesson7;

import java.util.Stack;

public class Nesting {
    public int solution(String S) {
        if (S.length() == 0) {
            return 1;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                char top = stack.pop();
                if (top == '(' && c == ')') {
                    continue;
                } else {
                    return 0;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
