/**
 * @author nakhoon
 * @date Jul 6, 2021
 * @see https://www.acmicpc.net/problem/2437
 * @mem 11,844kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 맨 처음 최솟값은 1이며, 정렬된 배열을 전부 탐색하면서 최솟값보다 저울이 작다면 최솟값에 저울 값을 더해준다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '저울'
public class BOJ2437 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int min = 1;
		for(int i=0;i<N;i++) {
			if(arr[i] > min) {
				break;
			}else {
				min += arr[i];
			}
		}
		System.out.println(min);
	}
}