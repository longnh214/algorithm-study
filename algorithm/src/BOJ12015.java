/**
 * @author nakhoon
 * @date Jul 21, 2021
 * @see https://www.acmicpc.net/problem/12015
 * @mem 125,340kb
 * @time 492ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <LIS(NlogN)> '가장 긴 증가하는 부분수열 2'
public class BOJ12015 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		int [] LIS = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		LIS[answer++] = arr[0];
		for(int i=1;i<N;i++) {
			if(LIS[answer-1] < arr[i]) {
				LIS[answer++] = arr[i];
			}else {
				int index = Arrays.binarySearch(LIS,0,answer,arr[i]);
				//Arrays.binarySearch 결과값이 음수일 경우
				//https://blog.daum.net/bang2001/12
				if(index < 0) index = (index * -1) - 1;
				LIS[index] = arr[i];
			}
		}
		System.out.println(answer);
	}
}