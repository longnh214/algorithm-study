/**
 * @author nakhoon
 * @date Jun 24, 2021
 * @see https://www.acmicpc.net/problem/2212
 * @mem 14,872kb
 * @time 148ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '센서'
public class BOJ2212 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		int [] diff = new int[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<N-1;i++) {
			diff[i] = arr[i+1] - arr[i]; 
		}
		
		Arrays.sort(diff);
		
		int answer = 0;
		for(int i=0;i<N-K;i++) {
			answer += diff[i];
		}
		
		System.out.println(answer);
	}
}