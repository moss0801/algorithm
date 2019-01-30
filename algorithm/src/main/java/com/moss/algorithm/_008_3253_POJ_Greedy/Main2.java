package com.moss.algorithm._008_3253_POJ_Greedy;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// http://poj.org/problem?id=3253
// 하프만부호
public class Main2 {
    public static void main(String args[]) {
        // 미완료
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt(); 
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            int input = scanner.nextInt();
            Integer value = map.get(input);
            if (null != value) {
                map.put(input, value + 1);
            } else {
                map.put(input, 1);
            }
        }
        
        // 긴 길이부터
        int result = 0;
        while (!map.isEmpty()) {
            Integer a = getLow(map);
            Integer b = getLow(map);
            result += a + b;
            if (map.isEmpty()) {
                break;
            }
            add(map, a + b);
        }
        
        System.out.println(result);
        scanner.close();
    }
    
    public static Integer getLow(TreeMap<Integer, Integer> map) {
        Map.Entry<Integer,Integer> low = map.pollFirstEntry();
        int num = low.getKey();
        int count = low.getValue(); 
        if (count != 1) {
            map.put(num, count - 1);
        }
        return num;
    }
    
    public static void add(TreeMap<Integer, Integer> map, int num) {
        Integer count = map.get(num);
        if (null != count) {
            map.put(num, count + 1);
        } else {
            map.put(num, 1);
        }
    }
}
