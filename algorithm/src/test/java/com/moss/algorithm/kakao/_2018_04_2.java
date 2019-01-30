package com.moss.algorithm.kakao;

import java.util.Arrays;

import org.junit.Test;

public class _2018_04_2 {
    @Test
    public void test() {
        int[] food_times = new int[] {6, 1, 3, 6};
        long k = 5;
        long sum = 0;
        for (int time : food_times) {
            sum += time;
        }
        if (sum <= k) {
            //return -1;
        }
        
        Food[] list = new Food[food_times.length];
        for (int i = 0; i < food_times.length; i++) {
            Food food = new Food();
            food.time = food_times[i];
            food.index = i+1;
            list[i] = food;
        }
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        long count = 0;
        int secondLastTime = 0;
        int lastTime = 0;
        int index = 0;
        for (int i = 0; i < list.length; i++) {
            if (lastTime != list[i].time) {
                count += (list.length - i)*(list[i].time - lastTime);
                if (k <= count) {
                    index = i;
                    break;
                }
                /*for (int j = 0; j < list[i].time - lastTime; j++) {
                    if (k - count - (list.length - i) < 0) {
                        break;
                    }
                    count += list.length - i;
                }*/
                secondLastTime = lastTime;
                lastTime = list[i].time;
            }
            
        }
        
        int answer = 0;
        if (k == count) {
            // 다음크기 첫번째
            for (int i = index; i < list.length; i++) {
                if (list[i].time > list[index].time) {
                    answer = list[i].index;
                    break;
                }
            }
        } else {
            long diff = (count - k) %(list.length - index);
            answer = list[(int) (index + diff)].index;
        }
        //return answer;
        System.out.println(index);
    }
    
    public static class Food implements Comparable<Food> {
        public int time;
        public int index;
        public int compareTo(Food o) {
            if (this.time > o.time) {
                return 1;
            } else if (this.time < o.time) {
                return -1;
            }
            if (this.index > o.index) {
                return 1;
            } else if (this.index < o.index) {
                return -1;
            }
            return 0;
        }
        
        @Override
        public String toString() {
            return time + " " + index;
        }
        
    }
}
