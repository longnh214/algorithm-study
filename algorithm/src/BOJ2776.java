/**
 * @author nakhoon
 * @date Jan 15, 2022
 * @see  https://www.acmicpc.net/problem/2776
 * @mem 333,708kb
 * @time 1,508ms
 * @caution
 * [고려사항]
 * 일반적인 이분 탐색 문제였지만 테스트 케이스의 개수도 입력을 받았고, System.out을 이용해 계속 출력해주면 시간 초과가 발생했다.
 * StringBuilder를 통해 가변적인 문자열을 만들어서 한번에 출력해야 통과할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <이분 탐색> '암기왕'
public class BOJ2776 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			int [] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				int target = Integer.parseInt(st.nextToken());
				
				int left = 0;
				int right = N-1;
				boolean flag = false;
				while(left <= right) {
					int mid = (left + right) / 2;
					
					if(target > arr[mid]) {
						left = mid + 1;
					}else if(target < arr[mid]){
						right = mid - 1;
					}else {
						flag = true;
						break;
					}
				}
				sb.append(flag ? "1" : "0").append("\n");
			}
			System.out.println(sb.substring(0,sb.length()-1));
		}
	}
}