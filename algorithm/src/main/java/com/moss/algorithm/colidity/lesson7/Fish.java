package com.moss.algorithm.colidity.lesson7;

import java.util.Stack;

/**
 * A, B non-empty 배열, N개의 정수
 * A, B는 N개의 강의 voracious fish 를 나타냄
 * P < Q -> P는 Q의 upstream
 * 각 fish는 고유한 위치를 가짐
 * A[P] -> P의 크기, B[P] P의 방향, 0(upstream) or 1(downstream)
 * 두 물고리가 반대방향으로 향하다 만나면 1마리만 생성(큰 물고기가 작은 물고기를 먹음)
 * 모든 물고기의 속도는 같다. 같은 방향의 물고기는 절대 만나지 않음
 * 살아남는 물고기의 수를 찾아라
 *
 *
 */
public class Fish {
    public int solution(int[] A, int[] B) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            int size = A[i];
            int flow = B[i];
            if (flow == 1) {
                // Downstream
                stack.push(size);
                continue;
            }

            // Upstream (flow == 0)
            if (stack.isEmpty()) {
                // alive
                count++;
                continue;
            }
            while (!stack.isEmpty()) {
                if (stack.peek() > size) {
                    // top eat i
                    break;
                } else {
                    // i eat top
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                // alive
                count++;
            }
        }

        return count + stack.size();
    }
}
