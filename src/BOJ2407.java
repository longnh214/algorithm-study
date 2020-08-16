
/**
 * @author choi
 * @date Aug 16, 2020
 * @see https://www.acmicpc.net/problem/2407
 * @mem 13,080kb
 * @time 84ms
 * @caution
 * [고려사항] 100이 넘는 수를 Factorial 하다보면, long 형으로 커버가 안되는 큰 수가 나올 수 있다는 것을 알았다.
 * 		BigInteger 형을 처음 봤고, 
 * 		그리고 재귀를 이용하면 시간 초과가 나서 재귀가 아닌 반복문으로 factorial을 연산하여 조합 식인 nCr = n! / r!(n-r)!
 * 		을 이용해서 풀 수 있었다. n! / (n-r)!  = nPn-r+1 임을 이용하여 문제를 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
import java.math.BigInteger;
// 백준 <수학/조합> - '조합'
public class BOJ2407 {
    public static void main(String[] args) throws IOException {
        BigInteger answer = new BigInteger("0");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == M)
            answer = BigInteger.valueOf(1);
        else {
            answer = factorial(N, N - M);
            answer = answer.divide(factorial(M, 1));
        }
        System.out.println(answer);
    }

    // factorial 구하기
    static BigInteger factorial(long n, int d) {
        BigInteger result = new BigInteger("1");
        while (n > d) {
            result = result.multiply(BigInteger.valueOf(n));
            n--;
        }
        return result;
    }
}