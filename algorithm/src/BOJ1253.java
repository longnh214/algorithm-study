/**
 * @author nakhoon
 * @date Aug 7, 2021
 * @see https://www.acmicpc.net/problem/1253
 * @mem 12,660kb
 * @time 156ms
 * @caution
 * [고려사항]
 * 투 포인터를 이용해서 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '좋다'
public class BOJ1253 {
	static int [] arr;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		Arrays.sort(arr);
		
		for(int i=0;i<N;i++) {
			if(isGood(i)) answer++;
		}
		
		System.out.println(answer);
	}
	
	static boolean isGood(int index) {
		int left = 0;
		int right = N-1;
		
		while(true) {
			if(left == index) left++;
			else if(right == index) right--;
			
			if(left >= right) break;
			
			int sum = arr[left] + arr[right];
			
			if(sum < arr[index]) left++;
			else if(sum > arr[index]) right--;
			else
				return true;
		}
		return false;
	}
}