/**
 * @author nakhoon
 * @date Aug 9, 2021
 * @see https://www.acmicpc.net/problem/1214
 * @mem 11,492kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 최소한의 범위로 찾아야 했으므로 D ~ D + max 값 중 맞는 가장 최솟값을 출력했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> '쿨한 물건 구매'
public class BOJ1214 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		if(D % P == 0 || D % Q == 0) {
			System.out.println(D);
			return;
		}
		
		int max = Math.max(P, Q);
		int min = Math.min(P, Q);
		int answer = max * ((D / max) + 1);
		int temp;
		
		for(int i=D/max;i>=0;i--) {
			int div = (D - (i * max)) / min;
			int mod = (D - (i * max)) % min;
			
			if(mod == 0) {
				System.out.println(D);
				return;
			}
			
			temp = (i * max) + ((div + 1) * min);
			
			if(temp == answer) break;
			answer = Math.min(answer,  temp);
		}
		
		System.out.println(answer);
	}
}