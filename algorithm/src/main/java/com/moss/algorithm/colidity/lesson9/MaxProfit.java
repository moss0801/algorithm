package com.moss.algorithm.colidity.lesson9;

public class MaxProfit {
    public int solution(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return 0;
        }

        int min = A[0];
        int max = A[0];
        int maxProfit = 0;
        for (int i = 1; i < A.length; i++) {
            int price = A[i];
            if (min > price) {
                min = price;
                max = price;
            } else if (max < price) {
                max = price;
                int profit = max - min;
                if (maxProfit < profit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit > 0 ? maxProfit : 0;
    }
}
