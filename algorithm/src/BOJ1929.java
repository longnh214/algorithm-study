/**
 * @author nakhoon
 * @date Jan 29, 2022
 * @see https://www.acmicpc.net/problem/1929
 * @mem 37,428kb
 * @time 1,016ms
 * @caution
 * [고려사항]
 * 에라토스테네스의 체를 구현해서 문제를 해결할 수 있었다. 초기화를 할 때 0과 1도 소수가 아님을 표시 했어야 했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '소수 구하기'
public class BOJ1929 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean [] arr = new boolean[1000001];
		for(int i=2;i<=Math.sqrt(1000000);i++) {
			for(int j=2;i*j<1000001;j++) {
				arr[i*j] = true;
			}
		}
		arr[0] = true;
		arr[1] = true;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=M;i<=N;i++) {
			if(!arr[i]) System.out.println(i);
		}
	}
}