/**
 * @author nakhoon
 * @date Jan 8, 2022
 * @see https://www.acmicpc.net/problem/10816
 * @mem 182,528kb
 * @time 1,164ms
 * @caution
 * [고려사항]
 * 자바에는 upper_bound와 lower_bound 메소드가 존재하지 않기 때문에 구현하는 연습으로 풀었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <이분탐색> '숫자 카드 2'
public class BOJ10816 {
	static int [] arr;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int target = Integer.parseInt(st.nextToken());
			int low = lowerBound(target);
			int high = upperBound(target);
			sb.append(high - low).append(" ");
		}
		
		System.out.println(sb.substring(0,sb.length()-1));
	}
	
	public static int lowerBound(int target) {
		int left = 0;
		int right = N;
		int mid;
		while(left < right) {
			mid = (left + right) / 2;
			if(arr[mid] >= target) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		return right;
	}
	
	public static int upperBound(int target) {
		int left = 0;
		int right = N;
		int mid;
		while(left < right) {
			mid = (left + right) / 2;
			if(arr[mid] > target) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		return right;
	}
}