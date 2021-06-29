/**
 * @author nakhoon
 * @date Jun 29, 2021
 * @see https://www.acmicpc.net/problem/12931
 * @mem 11,744kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 거꾸로 생각해서 -1이나 2를 나눔으로써 모든 배열의 값을 0으로 만들면 되는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '두 배 더하기'
public class BOJ12931 {
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
		
		int count = 0;
		
		while(!isFinish()) {
			count++;
			if(isAllEven()) {
				for(int i=0;i<N;i++) {
					arr[i]/=2;
				}
				continue;
			}
			
			for(int i=0;i<N;i++) {
				if(arr[i] % 2 == 1) {
					arr[i]--;
					break;
				}
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean isFinish() {
		for(int i=0;i<N;i++) {
			if(arr[i] != 0)
				return false;
		}
		return true;
	}
	
	public static boolean isAllEven() {
		for(int i=0;i<N;i++) {
			if(arr[i] % 2 == 1)
				return false;
		}
		return true;
	}
}