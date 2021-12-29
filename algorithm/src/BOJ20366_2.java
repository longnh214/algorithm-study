/**
 * @author nakhoon
 * @date Dec 29, 2021
 * @see https://www.acmicpc.net/problem/20366
 * @mem 12,220kb
 * @time 316ms
 * @caution
 * [고려사항]
 * 조합으로 풀었던 문제를 투 포인터로 해결하니 메모리와 시간이 전부 단축 되었다.
 * 이중 포문을 통해 하나의 눈사람을 정해두고, 그 사이의 값들 중 투 포인터를 이용해서 다른 눈사람의 크기를 찾는 방식이다.
 * 이동할 포인터를 정할 조건문에서 둘 중에 어느 눈사람의 크기가 더 큰 지에 따라 움직여야 하는 포인터가 달랐다. 
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <투 포인터> '같이 눈사람 만들래?'
public class BOJ20366_2 {
	static int N;
	static int [] size;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		size = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(size);
		
		int answer = Integer.MAX_VALUE;
		
		for(int i=0;i<N-3;i++) {
			for(int j=i+3;j<N;j++) {
				int left = i+1;
				int right = j-1;
				
				int standard = size[i] + size[j];
				
				while(left < right) {
					int temp = standard - (size[left] + size[right]);
					
					answer = Math.min(answer, Math.abs(temp));
					
					if(temp > 0) {
						left++;
					}else {
						right--;
					}
				}
			}
		}
		System.out.println(answer);
	}
}