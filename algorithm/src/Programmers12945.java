/**
 * @author nakhoon
 * @date 1/5/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12945
 * @mem
 * @time
 * @caution
 * [고려사항]
 * dp 문제였다. 나머지 계산을 반복문 안에서 해주어서 해결하였다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '피보나치 수'
public class Programmers12945 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int [] dp = new int[100001];

        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=100000;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }
}
