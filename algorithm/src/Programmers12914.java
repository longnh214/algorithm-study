/**
 * @author nakhoon
 * @date 1/11/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12914
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 기본적인 DP 문제였다. 점화식을 세워서 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '멀리 뛰기'
public class Programmers12914 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    public static long solution(int n) {
        long [] dp = new long[2001];

        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<2001;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }
}