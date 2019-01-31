package com.moss.algorithm.bk_dp._02_9095_123더하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            int n = scanner.nextInt();
            
            if (1 == n) {
                System.out.println(1);
                continue;
            } else if (2 == n) {
                System.out.println(2);
                continue;
            } else if (3 == n) {
                System.out.println(4);
                continue;
            }
            
            int result = 0;
            Queue<Counter> queue = new LinkedList<Counter>();
            queue.offer(new Counter(1, 1));
            queue.offer(new Counter(2, 1));
            queue.offer(new Counter(3, 1));
            while(!queue.isEmpty()) {
                Counter target = queue.poll();
                for (int j = 1; j <= 3; j++) {
                    if (target.current + j == n) {
                        result++;
                    } else if (target.current + j < n) {
                        queue.offer(new Counter(target.current + j, target.count + 1));
                    }
                }
            }
            
            System.out.println(result);
        }
        scanner.close();
    }
    
    public static class Counter {
        private int current;
        private int count;
        public Counter(int current, int count) {
            super();
            this.current = current;
            this.count = count;
        }
    }
}
