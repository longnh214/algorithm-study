/**
 * @author nakhoon
 * @date Jun 23, 2021
 * @see https://www.acmicpc.net/problem/13164
 * @mem 64,484kb
 * @time 496ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '행복 유치원'
public class BOJ13164 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N];
		int [] diff = new int[N-1];
		
		st = new StringTokenizer(br.readLine());
	
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N-1;i++) {
			diff[i] = arr[i+1] - arr[i];
		}
		
		Arrays.sort(diff);
		
		int sum = 0;
		for(int i=0;i<N-K;i++) {
			sum += diff[i];
		}
		
		System.out.println(sum);
	}
}