package com.moss.algorithm.kakao;

import org.junit.Test;

public class _2018_04 {

    @Test
    public void test() {
        int[] food_times = new int[] {3, 1, 2};
        long k = 5;
        long sum = 0;
        for (int time : food_times) {
            sum += time;
        }
        if (sum <= k) {
            //return -1;
        }
        int index = 0;
        while (k > 0) {
            for(;;) {
                if (food_times[index] > 0) {
                    food_times[index]--;
                    break;
                }
                index = (index + 1) % food_times.length;
            }
            index = (index + 1) % food_times.length;
            k--;
        }
        int answer = 0;
        for (int i = 0; i < food_times.length; i++) {
            if (food_times[(index + i)%food_times.length] > 0) {
                answer = (index + i)%food_times.length + 1;
                break;
            }
        }
        //return answer;
    }
}
