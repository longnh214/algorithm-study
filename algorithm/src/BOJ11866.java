/**
 * @author nakhoon
 * @date Feb 3, 2022
 * @see https://www.acmicpc.net/problem/11866
 * @mem 27,272kb
 * @time 152ms
 * @caution
 * [고려사항]
 * 큐를 이용해서 문제를 해결할 수 있었다. 처음에는 두개의 큐를 사용하려 했으나 하나의 큐를 사용하는 것이 더 효율적일 것이라 생각했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <큐> '요세푸스 문제 0'
public class BOJ11866 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()) {
			for(int i=0;i<K-1;i++) {
				int temp = q.poll();
				q.offer(temp);
			}
			sb.append(q.poll()).append(", ");
		}
		sb = new StringBuilder(sb.substring(0,sb.length()-2));
		System.out.println(sb.append(">"));
	}
}