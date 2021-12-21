/**
 * @author nakhoon
 * @date Dec 21, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/12900
 * @caution
 * [고려사항]
 * 최근 코딩테스트에 dp 문제가 나와서 연습 겸 풀어본 문제이다.
 * 규칙을 찾을 수 있는 문제였다.
 * [입력사항]
 * [출력사항]
 */
//프로그래머스 <연습문제> '2 x n 타일링'
public class Programmers12900 {
	static final int MOD = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int [] dp = new int[60001];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<dp.length;i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % MOD;
		}
        return dp[n];
    }

}