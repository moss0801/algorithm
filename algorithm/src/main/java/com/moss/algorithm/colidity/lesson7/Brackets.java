package com.moss.algorithm.colidity.lesson7;

import java.util.Stack;

public class Brackets {
    /**
     * S 는 문자열 N개 캐릭터
     * properly nested
     *  S is empty
     *  S (U) or [U] or {U} -> U is properly nested string
     *  S "VW" V and W ㅁㄱㄷ  properly nested string
     *
     *  {[()()]} -> properly nested
     *  ([)(] -> not
     * @param S
     * @return
     */
    public int solution(String S) {
        if (S.length() == 0) {
            return 1;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                char top = stack.pop();
                if ( (top == '(' && c == ')') || (top == '[' && c == ']') || (top == '{' && c == '}')) {
                    continue;
                } else {
                    return 0;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
