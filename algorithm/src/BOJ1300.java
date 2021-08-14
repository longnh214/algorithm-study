/**
 * @author nakhoon
 * @date Aug 14, 2021
 * @see https://www.acmicpc.net/problem/1300
 * @mem 11,508kb
 * @time 128ms
 * @caution
 * [고려사항]
 * getCount 함수에서 현재 수가 몇 번째인 지 알 수 있고, 이 반환 값을 가지고 이분탐색을 한다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <이분탐색> 'K번째 수'
public class BOJ1300 {
	static int N,K;
	static int [][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		long left = 1;
		long right = K;
		long answer = -1;
		
		while(left <= right) {
			long mid = (left + right)/2;
			long index = getCount(mid);
			
			//이분 탐색 반으로 자르기			
			if(index < K) {
				left = mid + 1;
			}else {
				answer = mid;
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
	
	public static long getCount(long num) {
		long count = 0;
		
		for(int i=1;i<=N;i++) {
			count += Math.min(num/i, N);
		}
		return count; 
	}
}