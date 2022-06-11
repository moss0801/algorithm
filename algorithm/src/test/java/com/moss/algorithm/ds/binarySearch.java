package com.moss.algorithm.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class binarySearch {

    public static int bs(int[] A, int key) {
        int n = A.length;
        int start = 0;
        int end = n - 1;
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] <= key) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    @Test
    public void bsTest() {
        int[] A = new int[]{1,3,5,7,8};
        int[] inputs = new int[] {4,5,6,8};  // 1,2,2,4
        for (int input : inputs) {
            int index = bs(A, input);
            System.out.println(index);
        }
    }


    static int binarySearch(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;
        
        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
                // 검색 성공
                return pc;
            } else if (a[pc] < key) {
                // 검색범위를 뒤쪽 반으로 좁힘
                pl = pc + 1;
            } else {
                // 검색범위를 앞쪽 반으로 좁힘
                pr = pc - 1;
            } 
        } while(pl <= pr);
        
        // 검색실패
        return -1;
    }
    
    @Test
    public void test() {
        int[] arr = new int[] {
            1,2,3,4,5,6,7,8,9,10
        };
        System.out.println(binarySearch(arr, arr.length, 3));
        System.out.println(binarySearch(arr, arr.length, 100));
    }
    
    @Test
    public void binarySearch2() {
        int[] arr = new int[] {
                1,2,3,4,5,6,7,8,9,10
            };
        System.out.println(Arrays.binarySearch(arr, 2));
        int result = Arrays.binarySearch(arr, 100);
        System.out.println(result); // 못찾는 경우 1(arr.length + 1) 값 반환됨
        Assertions.assertEquals(-1 * (arr.length + 1), result);
        
        int result2 = Arrays.binarySearch(arr, -10);
        System.out.println(result2); // 못찾는 경우 -1
        Assertions.assertEquals(-1, result2);
        
        // 0보다 작으면 못 찾은거임
    }
    
    public static class Book {
        public int id;
        public String name;
    }
    
    @Test
    public void customBi() {
        Book key = null;
        Arrays.binarySearch(new Book[] {}, key, new Comparator<Book>() {

            // a negative integer, zero, or a positive integer as thefirst argument is less than, equal to, or greater than thesecond.
            @Override
            public int compare(Book o1, Book o2) {
                // TODO Auto-generated method stub
                if (o1.hashCode() < o2.hashCode()) {
                    return -1;
                } else if (o2.hashCode() > o2.hashCode()) {
                    return 1;
                }
                // 같은 경우
                return 0;
            }
            
        });
    }
    
    public static class Test2 implements Comparable<Test2> {

        @Override
        public int compareTo(Test2 o) {
            // TODO Auto-generated method stub
            return 0;
        }
        
    }
    
    @Test
    public void collectionBi() {
        List<Test2> list = new ArrayList<Test2>();
        list.add(new Test2());
        int result = Collections.binarySearch(list, new Test2());
        System.out.println(result);
    }
}
