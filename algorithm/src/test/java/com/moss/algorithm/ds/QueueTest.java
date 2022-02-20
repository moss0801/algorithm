package com.moss.algorithm.ds;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    @Test
    public void queue() {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("Itme");
        queue.poll();
    }
}
