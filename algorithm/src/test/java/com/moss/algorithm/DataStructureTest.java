package com.moss.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class DataStructureTest {

    @Test
    public void stack() {
        // LIFO - Last In First Out
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println("Stack " + stack.peek());
        System.out.println("Stack " + stack.pop());
        
    }
    
    @Test
    public void queue() {
        // FIFO - First In First Out
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        System.out.println("Queue " + queue.peek());
        System.out.println("Queue " + queue.poll());
    }
    
    @Test
    public void def() {
        // DFS - Depth-First Search
        // P45. 부분 합 문제
        
    }
}
