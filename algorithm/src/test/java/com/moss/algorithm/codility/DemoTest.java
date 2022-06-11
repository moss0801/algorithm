package com.moss.algorithm.codility;

import com.moss.algorithm.colidity.demo.Demo;
import org.junit.jupiter.api.Test;

public class DemoTest {

    @Test
    public void demo() {
        Demo demo = new Demo();
        //int result = demo.solution(new int[] {1,3,6,4,1,2});
        //int result = demo.solution(new int[] {1,2,3});
        int result = demo.solution(new int[] {-1,-3});
        System.out.println(result);
    }
}
