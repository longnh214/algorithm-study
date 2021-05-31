/**
 * @author nakhoon
 * @date May 31, 2021
 * @see https://www.acmicpc.net/problem/9252
 * @mem 16,088kb
 * @time 112ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> 'LCS 2'
public class BOJ9252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		char [] str1 = br.readLine().toCharArray();
		char [] str2 = br.readLine().toCharArray();
		
		int [][] dp = new int[str1.length + 1][str2.length + 1];
		
		for(int i=1;i<=str1.length;i++) {
			for(int j=1;j<=str2.length;j++) {
				if(str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int answer = dp[str1.length][str2.length];
		
		System.out.println(answer);
		
		if(answer != 0) {
			int i = str1.length;
			int j = str2.length;
			
			while(i > 0 && j > 0) {
				if(dp[i][j] == dp[i-1][j]) {
					i--;
				}else if(dp[i][j] == dp[i][j-1]) {
					j--;
				}else {
					i--; j--;
					stack.push(str1[i]);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			System.out.println(sb);
		}
	}
}