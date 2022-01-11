/**
 * @author nakhoon
 * @date Jan 11, 2022
 * @see https://www.acmicpc.net/problem/2110
 * @mem 21,508kb
 * @time 220ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <이분탐색> '공유기 설치'
public class BOJ2110 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int [] house = new int[N];
		for(int i=0;i<N;i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
		
		int left = 1;
		int right = house[N-1] - house[0];
		int distance = 0;
		int answer = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int start = house[0];
			int count = 1;
			for(int i=0;i<N;i++) {
				distance = house[i] - start;
				if(distance >= mid) {
					count++;
					start = house[i];
				}
			}
			
			if(count >= C) {
				answer = mid;
				left = mid + 1; //더 많은 차이에도 공유기를 제한된 갯수로 설치할 수 있는 지
			}else {
				right = mid - 1; //더 적은 차이에도 공유기를 제한된 갯수로 설치할 수 있는 지
			}
		}
		System.out.println(answer);
	}
}