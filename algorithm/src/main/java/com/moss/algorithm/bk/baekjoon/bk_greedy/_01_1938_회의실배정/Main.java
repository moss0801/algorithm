package com.moss.algorithm.bk.baekjoon.bk_greedy._01_1938_회의실배정;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 회의수 (>=1, <=100000)
        int N = scanner.nextInt();
        
        // 입력(회의종료시간 오름차순, 회의시작시간 오름차순 정렬, )
        // 시간: O(nlogn), 공간: O(n)
        PriorityQueue<Meeting> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.offer(new Meeting(scanner.nextInt(), scanner.nextInt()));
        }
        
        // 결과(회의수)
        int meetingCount = 0;

        // 마지막 회의 종료 시간
        int lastMeetingEndTime = 0;
        while (!queue.isEmpty()) {
            Meeting meeting = queue.poll();
            if (meeting.getStart() >= lastMeetingEndTime) {
                meetingCount++;
                lastMeetingEndTime = meeting.getEnd();
            }
        }
        
        // 결과출력
        System.out.println(meetingCount);
        
        scanner.close();
    }
    
    public static class Meeting implements Comparable<Meeting>{
        // 시작시간
        private int start;
        // 종료시간
        private int end;
        
        public Meeting(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }
        public int getStart() {
            return start;
        }
        public int getEnd() {
            return end;
        }
        @Override
        public int compareTo(Meeting o) {
            // 종료시간 기준으로 오름차순 정렬
            if (this.end == o.end) {
                // 종료시간 같으면 시작시간 기준으로 오름차순 정렬
                if (this.start == o.start) {
                    return 0;
                }
                return this.start < o.start ? -1 : 1;
            }
            return this.end < o.end ? -1 : 1;
        }
    }

}
