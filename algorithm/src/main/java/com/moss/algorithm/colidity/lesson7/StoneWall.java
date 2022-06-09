package com.moss.algorithm.colidity.lesson7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * H[0] 왼쪽 높이, H[N-1] 오른쪽 높이
 * 최소 블록 개수
 * [8,8,5,7,9,8,7,4,8]
 * 첫 높이보다 작은 높이가 나오기 전까지 묶어서 첫번째 항목의 높이와 누적된 길이로 하나의 블록을 생성
 * 나머지 부분도 같은 작업을 남는 부분이 없을 때 까지 반복
 *
 * Reference ; https://jobjava00.github.io/algorithm/codility/lesson7/StoneWall/
 * 돌담의 이전 높이를 기준으로 현재 높이가 낮으면 현재 높이 기준으로 기준점이 낮춰지고 이전 높았던 높이는 별개의 블럭이 되면서 제거
 *   - 현재 높이보다 이전 블록이 낮아질때까지 계속 제거 해 나감
 *   - 현재 높이랑 이전 블록이 같으면 같은 블럭으로 통합 가능하기 때문에 그냥 유지함
 * 이전 높이 보다 현재 높이가 높으면 카운트 증가, 스택 추가
 * 이전 높이 보다 현재 높이가 적으면 높아질 떄까지 스택 제거
 *
 * 이해가 잘 안된다.
 * Ref2: https://mingmi-programming.tistory.com/116
 */
public class StoneWall {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < H.length; i++) {
            while (!stack.isEmpty() && stack.peek() > H[i]) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < H[i]) {
                stack.push(H[i]);
                count++;
            }
        }
        return count;
    }
}
