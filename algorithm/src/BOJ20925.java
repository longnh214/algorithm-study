/**
 * @author nakhoon
 * @date Sep 5, 2021
 * @see https://www.acmicpc.net/problem/20925
 * @mem 19,100kb
 * @time 552ms
 * @caution
 * [고려사항]
 * dp의 값 갱신 조건을 잘 줘야했던 문제이다. 이동 시간과 각 사냥터의 최소 경험치를 고려해야 사냥터를 접근할 수 있다는 점을 잊지 말아야 한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '메이플스토리'
public class BOJ20925 {
	static Field [] fieldArr;
	static int [][] dp;
	static int [][] move;
	static int N,T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		fieldArr = new Field[N];
		dp = new int [N][T+1];
		move = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int minExp = Integer.parseInt(st.nextToken());
			int expValue = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
			fieldArr[i] = new Field(minExp, expValue);
			if(minExp == 0) dp[i][0] = 0;
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				move[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(getMaxExp(1));
	}
	
	public static int getMaxExp(int curTime) {
		//재귀 탈출 조건
		if(curTime > T) {
			int result = 0;
			for(int i=0;i<N;i++) {
				result = Math.max(result, dp[i][T]);
			}
			return result;
		}
		
		for(int i=0;i<N;i++) {
			if(dp[i][curTime-1] != -1) dp[i][curTime] = dp[i][curTime-1] + fieldArr[i].expValue;
			for(int j=0;j<N;j++) {
				if(i == j) continue;
				int duration = curTime - move[j][i];
				if(duration > 0 && dp[j][duration] >= fieldArr[i].minExp)
					dp[i][curTime] = Math.max(dp[i][curTime], dp[j][duration]);
			}
		}
		
		return getMaxExp(curTime + 1);
	}
	
	static class Field{
		int minExp;
		int expValue;
		
		Field(int minExp, int expValue){
			this.minExp = minExp;
			this.expValue = expValue;
		}
	}
}