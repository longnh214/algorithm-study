/**
 * @author nakhoon
 * @date May 28, 2021
 * @see https://www.acmicpc.net/problem/10974
 * @mem 49,492kb
 * @time 1164ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <브루트포스> '모든 순열'
public class BOJ10974 {
	static int N;
	static int [] temp;
	static boolean [] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		temp = new int[N];
		perm(0);
	}
	public static void perm(int cnt) {
		if(cnt == N) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<temp.length;i++) {
				sb.append(temp[i]).append(" ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				temp[cnt] = i;
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}
}