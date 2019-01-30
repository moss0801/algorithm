package com.moss.algorithm;

import java.util.LinkedList;
import java.util.PriorityQueue;
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
    
    @Test
    public void priorityQueue() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.offer(100);
        priorityQueue.offer(5);
        priorityQueue.offer(3);
        priorityQueue.offer(200);
        
        while(priorityQueue.size() > 0) {
            System.out.println(priorityQueue.poll());
        }
    }
}
