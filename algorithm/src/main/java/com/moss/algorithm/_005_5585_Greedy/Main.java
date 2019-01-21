package com.moss.algorithm._005_5585_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int coinList[] = new int[] {500, 100, 50, 10, 5, 1};
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rest = 1000 - Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < coinList.length; i++) {
            count += rest/coinList[i];
            rest = rest % coinList[i];
        }
        System.out.println(count);
    }
}
