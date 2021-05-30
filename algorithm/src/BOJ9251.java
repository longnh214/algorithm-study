/**
 * @author nakhoon
 * @date May 30, 2021
 * @see https://www.acmicpc.net/problem/9251
 * @mem 15,644kb
 * @time 104ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> 'LCS'
public class BOJ9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
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
		System.out.println(dp[str1.length][str2.length]);
	}
}