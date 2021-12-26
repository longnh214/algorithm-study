/**
 * @author nakhoon
 * @date Dec 26, 2021
 * @see https://www.acmicpc.net/problem/3151
 * @mem 14,240kb
 * @time 3,380ms
 * @caution
 * [고려사항]
 * Java에는 binarySearch 메소드가 있지만 배열에서 값에 대한 최소 인덱스와 최대 인덱스를 가져오는 lower_bound, upper_bound 메소드가
 * 없어 직접 구현해야했다.
 * 정답이 커질 수도 있으므로 long 형이여야 하는 것도 고려해야 했던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <이분탐색> '합이 0'
public class BOJ3151 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long answer = 0;
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				int findNum = (arr[i] + arr[j]) * -1;
				int index1 = lowerBound(arr, j+1, N, findNum);
				int index2 = upperBound(arr, j+1, N, findNum);
				
				answer += (index2 - index1);
			}
		}
		System.out.println(answer);
	}
	
	public static int lowerBound(int [] arr, int left, int right, int key) {
		int mid;
		while(left < right) {
			mid = (left + right) / 2;
			if(arr[mid] >= key) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return right;
	}
	
	public static int upperBound(int [] arr, int left, int right, int key) {
		int mid;
		while(left < right) {
			mid = (left + right) / 2;
			if(arr[mid] > key) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return right;
	}
}