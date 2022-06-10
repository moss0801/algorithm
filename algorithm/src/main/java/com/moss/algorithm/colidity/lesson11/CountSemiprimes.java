package com.moss.algorithm.colidity.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * semiprime : 두 prime(소수)의 곱 4,6,9,10,14 ...
 * 배열 P, Q 각각 M개 정수
 * K -> (P[K],Q[K]) 범위내 semiprimes 개수 찾기
 *
 * N은 최대 수
 *
 * 다시 풀어야 한다. 틀림 22%
 *
 */
public class CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {
//        System.out.println(Arrays.toString(P));
//        System.out.println(Arrays.toString(Q));
        // 소수 찾기
        int primeEnd = N;
        int[] primeCandidates = new int[primeEnd+1];
        primeCandidates[0] = 1;
        primeCandidates[1] = 1;
        int primeCount = 0;
        for (int i = 2; i<=primeEnd; i++) {
            if (primeCandidates[i] == 0) {
                primeCount++;
                int check =  i+i;
                while (check <= primeEnd) {
                    primeCandidates[check] = 1;
                    check += i;
                }
            }
        }

        int[] primes = new int[primeCount];
        int index = 0;
        for (int i = 2; i <= primeEnd; i++) {
            if (primeCandidates[i] == 0) {
                primes[index] = i;
                index++;
            }
        }
//        System.out.println(Arrays.toString(primes));

        // semiprime
        List<Integer> semiprimeList = new ArrayList<>();
        int semiEndIndex = Arrays.binarySearch(primes, N/2);
        index = 0;
        for (int i = 0; i <= semiEndIndex; i++) {
            for (int j = i; j <= semiEndIndex; j++) {
                semiprimeList.add(primes[i]*primes[j]);
                index++;
            }
        }
        Integer[] semiprimes = semiprimeList.toArray(Integer[]::new);
        Arrays.sort(semiprimes);
//        System.out.println(Arrays.toString(semiprimes));

        // 정답 찾기
        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i];
            int startIndex = Arrays.binarySearch(semiprimes, start);
            if (startIndex < 0) {
                startIndex = -startIndex - 1;
            }
            int endIndex = Arrays.binarySearch(semiprimes, end);
            if (endIndex < 0) {
                endIndex = -endIndex - 1;
            }
            result[i] = endIndex - startIndex;
            if (startIndex >= 0 && startIndex < semiprimes.length && semiprimes[startIndex] >= start) {
                result[i]++;
            }
            if (endIndex >= 0 && endIndex < semiprimes.length && semiprimes[endIndex] > end) {
                result[i]--;
            }
        }

//        System.out.println(Arrays.toString(result));

        return result;
    }
}
