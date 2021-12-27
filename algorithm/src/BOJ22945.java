/**
 * @author nakhoon
 * @date Dec 28, 2021
 * @see https://www.acmicpc.net/problem/22945
 * @mem 22,516kb
 * @time 224ms
 * @caution
 * [고려사항]
 * A와 B 사이의 개발자 수는 한 칸 움직이면 무조건 줄어든다고 가정했을 때, 뒤에 곱해지는 수가 A,B의 능력치 중 작은 수와 곱해지기 때문에,
 * A,B의 능력치 중 작은 값을 갱신하면서 투 포인터 알고리즘을 적용하면 되었던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <투 포인터> '팀 빌딩'
public class BOJ22945 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		int max = Integer.MIN_VALUE;
		
		while(left < right) {
			int temp = (right - left - 1) * Math.min(arr[left], arr[right]);
			
			max = Math.max(max, temp);
			
			if(arr[left] < arr[right]) {
				left++;
			}else {
				right--;
			}
		}
		System.out.println(max);
	}
}