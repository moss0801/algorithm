package com.moss.algorithm.bk.baekjoon.bk_0225._07_1935_후위표기식2;

import java.util.Scanner;
import java.util.Stack;

// http://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220781557098
/**
 * 1. 피연산자면 스택에 push한다.
 * 2. 연산자면 스택의 가장 위에 있는 값 2개를 꺼내 해당 연산자로 연산하여 그 결과를 다시 스택에 넣는다.
 *    이때 순서가 중요한데, top에 있던 걸 B, 그 아래 있던 걸 A라 하면 A ⊙ B 순이다.
 *    연산자를 만났는데 스택 크기가 1 이하일 때는 절대 없다. 그건 잘못된 후위표기식이다.
 * 3. 마지막에 스택에 남아있는 값이 최종 결과
 * @author moss
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String postfix = scanner.next();
        double[] numbers = new double[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        Stack<Double> stack = new Stack<>();
        for (char c : postfix.toCharArray()) {
            // 앞에서 부터 하나씩 처리
            if (c >= 'A' && c <= 'Z') {
                // 피연산자 : stack에 push
                stack.push(numbers[c - 'A']);
            } else {
                // 연산자 : stack에서 2개 pop해서 연산 후 다시 push
                // +, -, *, /
                Double number2 = stack.pop();
                Double number1 = stack.pop();
                if (c == '+') {
                    stack.push(number1 + number2);
                } else if (c == '-') {
                    stack.push(number1 - number2);
                } else if (c == '*') {
                    stack.push(number1 * number2);
                } else if (c == '/') {
                    stack.push(number1 / number2);
                } 
            }
        }
        
        // 결과 출력
        System.out.println(String.format("%.2f", stack.pop()));
        
        scanner.close();
        
    }
}
