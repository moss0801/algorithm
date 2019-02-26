package com.moss.algorithm.ds;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class QueueTest {

    @Test
    public void queue() {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("Itme");
        queue.poll();
    }
}
