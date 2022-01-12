/**
 * @author nakhoon
 * @date Jan 12, 2022
 * @see https://www.acmicpc.net/problem/1920
 * @mem 65,400kb
 * @time 1,840ms
 * @caution
 * [고려사항]
 * 이분 탐색 알고리즘을 연습하기 위해 풀었지만, 맵을 이용해서 풀면 시간이 많이 단축 될 것 같다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <이분 탐색> '수 찾기'
public class BOJ1920 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int target = Integer.parseInt(st.nextToken());
			int left = 0;
			int right =N-1;
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
			
			System.out.println(flag ? "1" : "0");
		}
	}
}