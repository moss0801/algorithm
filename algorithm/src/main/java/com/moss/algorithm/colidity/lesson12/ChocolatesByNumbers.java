package com.moss.algorithm.colidity.lesson12;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/
 * 양수 N,M
 * N : 초콜렉 수 (0 ~ N-1)
 * 0 부터 먹기 시작, 다음 M-1 omit or wrapper
 * 다음 먹는 초콜렛 (N+M)%N
 * empty wrapper를 만나면 멈춤
 *
 * 유클리드 알고리즘 gcd, 최대공약수 구하기(
 * if b | a, then gcd(a, b) = b,
 * otherwise gcd(a, b) = gcd(b, a mod b).]
 * gcd(24,9) -> 24 mod 9 = 6 -> gcd(9,6) -> 9 mod 6 = 3 -> gcd(6,3) -> 6 mod 3 = 0 -> 3
 *
 * 틀림
 */
public class ChocolatesByNumbers {
    public int solution(int N, int M) {
        int gcd = gcd(N, M);
        return N / gcd;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
