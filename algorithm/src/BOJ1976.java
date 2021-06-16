/**
 * @author nakhoon
 * @date Jun 16, 2021
 * @see https://www.acmicpc.net/problem/1976
 * @mem 15,724kb
 * @time 132ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <union-find> '여행 가자'
public class BOJ1976 {
	static int N,M;
	static int [] team;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		team = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			team[i] = i;
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == 1) {
					union(i,j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int parent = find(Integer.parseInt(st.nextToken()));
		boolean answer = true;
		while(st.hasMoreTokens()) {
			if(parent != find(Integer.parseInt(st.nextToken()))) {
				answer = false;
				break;
			}
		}
		
		System.out.println(answer ? "YES" : "NO");
	}
	public static int find(int x) {
		if(team[x] == x) return x;
		return team[x] = find(team[x]);
	}
	
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false;
		team[y] = x;
		return true;
	}
}