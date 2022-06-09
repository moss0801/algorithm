package com.moss.algorithm.bk.baekjoon.bk_0225._06_1918_후위표기식;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// http://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220781557098
// https://blog.naver.com/occidere/220955593674
/**
 * 1. 피연산자를 만났다면, 바로 출력한다.
 * 2. 사칙연산자를 만났을 경우, 스택이 비어 있거나, top이 여는 괄호거나, 이번 연산자가 스택의 top 연산자보다 우선순위가 높을 경우 push한다.
 * 아니라면, 앞의 조건을 만족할 때까지 차례차례 pop해서 출력한다. 그리고 이번 연산자를 push한다.
 * 3. 여는 괄호를 만났을 경우, (를 스택에 push한다.
 * 4. 닫는 괄호를 만났을 경우, (가 나올 때까지 스택을 계속 pop하여 pop한 연산자를 출력하고, 마지막에 (도 pop한다.
 * @author moss
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        String input = scanner.next();
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                // 피연산자는 출력
                queue.offer(c);
            } else if (c == '(') {
                // 여는 괄호는 stack에 넣는다 c;
                stack.push(c);
            } else if (c == ')') {
                // 닫는 괄호는 '('를 만날때 까지 pop 하면서 출력한다.
                // '('는 출력하지 않고 pop()만 한다.
                while(true) {
                    char pop = stack.pop();
                    if (pop == '(') {
                        break;
                    } else {
                        queue.offer(pop);
                    }
                }
            } else {
                // +, -, *, /
                char operator = c;
                while(true) {
                    if (stack.isEmpty() || stack.peek() == '(' || ((operator == '*' || operator == '/') && (stack.peek() == '+' || stack.peek() == '-'))) {
                        stack.push(operator);
                        break;
                    } else {
                        queue.offer(stack.pop());
                    }
                }
            }
        }
        
        // Stack에 남은 것 Pop 하면서 출력
        while(!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // 출력
        while(!queue.isEmpty()) {
            System.out.print(queue.poll());
        }
        
        scanner.close();
    }

}
