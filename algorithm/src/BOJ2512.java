/**
 * @author nakhoon
 * @date Jan 14, 2022
 * @see https://www.acmicpc.net/problem/2512
 * @mem 13,992kb
 * @time 128ms
 * @caution
 * [고려사항]
 * 이분 탐색의 범위를 arr[0]부터 arr[N-1]이 아닌 0부터 arr[N-1]으로 생각했어야 했다.
 * 총 예산의 최소값이 N이기 때문에 상한액이 arr[0]보다 작을 수도 있는 것이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <이분 탐색> '예산'
public class BOJ2512 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long [] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		long totalBudget = Long.parseLong(br.readLine());
		long left = 0;
		long right = arr[N-1];
		long answer = -1;
		while(left <= right) {
			long mid = (left + right) / 2;
			
			long total = 0;
			for(int i=0;i<N;i++) {
				total += ((arr[i] >= mid) ? mid : arr[i]);
			}
			
			if(total <= totalBudget) {
				answer = Math.max(mid, answer);
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}