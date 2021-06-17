/**
 * @author nakhoon
 * @date Jun 17, 2021
 * @see https://www.acmicpc.net/problem/20040
 * @mem 164,460kb
 * @time 656ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <union-find> '사이클 게임'
public class BOJ20040 {
	static int N,M;
	static int [] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N];
		
		for(int i=0;i<N;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if(!union(v,w)) {
				System.out.println(i+1);
				return;
			}
		}
		
		System.out.println(0);
	}
	public static int find(int n) {
		if(n == parent[n]) return n;
		return parent[n] = find(parent[n]);
	}
	
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		
		parent[x] = y;
		return true;
	}
}