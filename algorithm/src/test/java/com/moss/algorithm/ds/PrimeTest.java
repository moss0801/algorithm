package com.moss.algorithm.ds;

public class PrimeTest {


    public int[] findPrime(int N) {
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
        return primes;
    }
}
