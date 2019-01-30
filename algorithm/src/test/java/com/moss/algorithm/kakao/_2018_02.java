package com.moss.algorithm.kakao;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

public class _2018_02 {

    @Test
    public void test() {
        int N = 5;
        int[] stages = new int[] {2, 1, 2, 6, 2, 4, 3, 3};
        int[] count = new int[N + 2];
        for (int stage : stages) {
            count[stage]++;
        }
        PriorityQueue<Stage> queue = new PriorityQueue<Stage>();
        int rest = stages.length;
        for (int i = 1; i <= N; i++) {
            Stage stage = new Stage();
            System.out.println(count[i] + "/" + rest);
            stage.failRatio = count[i]/(double)rest;
            if (i > N) {
                stage.stage = N;
            } else {
                stage.stage = i;
            }
            queue.offer(stage);
            
            rest -= count[i]; 
        }
        
        int[] answer = new int[queue.size()];
        int index = 0;
        while(queue.size() > 0) {
            answer[index] = queue.poll().stage;
            index++;
        }
        //return answer;
        
        System.out.println(Arrays.toString(answer));
        //int[] answer = {};
    }
    
    public static class Stage implements Comparable<Stage> {
        // 실패율
        public Double failRatio;
        
        // 스테이지
        public Integer stage;
        
        public int compareTo(Stage o) {
            if (this.failRatio < o.failRatio) {
                return 1;
            } else if (this.failRatio > o.failRatio) {
                return -1;
            }
            
            if (this.stage < o.stage) {
                return -1;
            } else if (this.stage > o.stage) {
                return 1;
            }
            return 0;
        }
        
        @Override
        public String toString() {
            return stage + " " + failRatio;
        }
    }
    
    
}
