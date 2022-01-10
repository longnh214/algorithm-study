/**
 * @author nakhoon
 * @date Jan 10, 2022
 * @see https://www.acmicpc.net/problem/2805
 * @mem 171,836kb
 * @time 636ms
 * @caution
 * [고려사항]
 * long 자료형을 쓰지 않아서 틀렸던 문제이다. N의 개수가 최대 100만이고 나무의 높이가 10억보다 작거나 같기 때문에
 * total이 int 형을 훨씬 초과할 수 있었던 문제임을 고려했어야 했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <이분 탐색> '나무 자르기'
public class BOJ2805 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long [] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long min = 0;
		long max = arr[N-1];
		while(min <= max) {
			long mid = (min + max) / 2;
			
			long total = 0;
			for(int i=0;i<N;i++) {
				total += ((arr[i] >= mid) ? arr[i] - mid : 0);
			}
			
			if(total >= M) {
				min = mid + 1;
			}else {
				max = mid - 1;
			}
		}
		
		System.out.println(max);
	}
}