/**
 * @author nakhoon
 * @date Jan 13, 2022
 * @see https://www.acmicpc.net/problem/10815
 * @mem 141,848kb
 * @time 1,088ms
 * @caution
 * [고려사항]
 * 이 문제도 이분 탐색 연습용으로 문제를 풀었지만, Map을 사용한다면 더 빠른 시간 복잡도로 풀 수 있을 것 같다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <이분 탐색> '숫자 카드'
public class BOJ10815 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		StringTokenizer st  = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			int target = Integer.parseInt(st.nextToken());
			
			int left = 0;
			int right = N-1;
			boolean flag = false;
			while(left <= right) {
				int mid = (left + right) / 2;
				
				if(target < arr[mid]) {
					right = mid - 1;
				}else if(target > arr[mid]) {
					left = mid + 1;
				}else {
					flag = true;
					break;
				}
			}
			sb.append(flag ? 1 : 0).append(" ");
		}
		System.out.println(sb.substring(0, sb.length()-1));
	}
}