package com.moss.algorithm.colidity.lesson12;

/**
 * https://app.codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors/
 *
 * N, M 양수 2개
 * N, M의 prime divisor가 동일한지 확인
 *
 *
 * https://sustainable-dev.tistory.com/39
 *
 * 먼저, 두 수의 최대 공약수를 구해 준 후, 각 수를 최대 공약수와의 최대 공약수를 다시 구해주면된다.
 * 그리고 나서 각 수를 구한 최대 공약수로 나눈 후 다시 그 값과 위의 최대 공약수로 다시 최대공약수를 구해서 과정을 반복하면 된다.
 * 그리고 나서 gcd가 1이 되었을 때 값이 1이 아니라면 그 수가 공통되지 않은 인수가 된다. 이 시점에서 이미 공통되지 않는다는 사실이 나왔으므로 이 공통되지 않은 인수 값이 소수인지 아닌지를 판별할 필요는 없다.
 *
 * 결론은 각 수의 인수가 두 수의 최대 공약수의 인수와 같다면 인수가 같은 것으로 보면된다.

 * 처음에 논리를 생각하는 과정에서 공통되지 않은 인수가 소수인지 아닌지까지 판별해서 예외 처리를 하려다보니 조금 고생을 하긴했다.
 * 재귀적인 코드를 말로 설명하려니 복잡한데, 문제에서 예시로 들어준 값을 넣고 코드를 따라가다보면 더 이해하기가 쉬울 것이다.

 * 시간 복잡도는 O(Z * log(max(A) + max(B))**2)가 나왔다.
 */
public class CommonPrimeDivisors {
    public int solution(int[] A, int[] B) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (check(A[i], B[i])) {
                result++;
            }
        }
        return result;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public boolean check(int a, int b) {
        int gcd = gcd(a, b);
        int gcdA = 0;
        int gcdB = 0;

        while (gcdA != 1) {
            gcdA = gcd(a, gcd);
            a = a / gcdA;
        }

        while (gcdB != 1) {
            gcdB = gcd(b, gcd);
            b = b / gcdB;
        }

        return (a == 1 && b == 1) ? true : false;
    }
}
