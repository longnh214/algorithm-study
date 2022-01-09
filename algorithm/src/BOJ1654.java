/**
 * @author nakhoon
 * @date Jan 9, 2022
 * @see https://www.acmicpc.net/problem/1654
 * @mem 15,504kb
 * @time 144ms
 * @caution
 * [고려사항]
 * 랜선의 길이는 0이 넘는 정수로 이루어지므로 최소는 1이다.
 * 그리고 int 최대값에 근접한 두 수의 평균을 구하게 되면 두 수를 더하는 순간 int 범위를 벗어나기 때문에 long 형으로 길이를 처리해주어야한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <이분 탐색> '랜선 자르기'
public class BOJ1654 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long [] arr = new long[K];
		for(int i=0;i<K;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long min = 1;
		long max = arr[K-1];
		
		while(min <= max) {
			long mid = (min + max) / 2;
			
			int count = 0;
			
			for(int i=0;i<K;i++) {
				count += arr[i] / mid;
			}
			
			if(count >= N) { //count가 기준보다 높다면 mid가 커져야된다.
				min = mid + 1;
			}else { //count가 기준보다 낮다면 mid가 작아져야된다.
				max = mid - 1;
			}
		}
		System.out.println(max);
	}
}