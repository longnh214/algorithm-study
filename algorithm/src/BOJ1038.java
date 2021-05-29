/**
 * @author nakhoon
 * @date May 29, 2021
 * @see https://www.acmicpc.net/problem/1038
 * @mem 11,644kb
 * @time 80ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> '감소하는 수'
public class BOJ1038 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N > 1022) {
			System.out.println(-1);
		}else if(N < 10) {
			System.out.println(N);
		}else {
			Queue<Long> q = new LinkedList<>();
			int cnt = 0;
			for(int i=1;i<10;i++) {
				q.offer(new Long(i));
				cnt++;
			}
			while(cnt < N) {
				long cur = q.poll();
				long temp = cur % 10;
				for(int i=0;i<temp;i++) {
					q.offer(cur * 10 + i);
					cnt++;
					if(cnt == N) {
						System.out.println(cur * 10 + i);
						break;
					}
				}
			}
		}
	}
}