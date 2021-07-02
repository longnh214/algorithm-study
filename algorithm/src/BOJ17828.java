/**
 * @author nakhoon
 * @date Jul 2, 2021
 * @see https://www.acmicpc.net/problem/17828
 * @mem 78,896kb
 * @time 272ms
 * @caution
 * [고려사항]
 * num이 N보다 작을 경우에 !가 나오는 것을 생각하지 못해서 한번 틀렸던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '문자열 화폐'
public class BOJ17828 {
	static int [] arr;
	static int N;
	static int num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(st.nextToken());
		
		if(num > N * 26 || num < N) {
			System.out.println("!");
			return;
		}
		
		arr = new int[N];
		
		num -= N;
		
		Arrays.fill(arr, 1);
		
		int index = N-1;
		while(num != 0) {
			if(num >= 25) {
				arr[index--] += 25;
				num -= 25;
			}else {
				arr[index--] += num;
				num = 0;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append((char)('@' + arr[i]));
		}
		System.out.println(sb.toString());
	}
}