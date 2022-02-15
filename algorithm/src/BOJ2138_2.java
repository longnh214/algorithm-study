/**
 * @author nakhoon
 * @date Feb 15, 2022
 * @see https://www.acmicpc.net/problem/2138
 * @mem 15,368kb
 * @time 124ms
 * @caution
 * [고려사항]
 * 인덱스 0의 스위치를 누르는 경우와 누르지 않는 경우를 따로 생각 해야 문제를 해결할 수 있었다.
 * 첫 제출 때에 메모리 초과가 발생했는데, 매번 스위치 누를 때마다 정답과 비교하지 않고
 * 모든 스위치를 누른 뒤에 맨 마지막 인덱스의 값이 같은 지만 비교하면 AC를 받을 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '전구와 스위치'
public class BOJ2138_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char [] first, copyFirst;
		first = br.readLine().toCharArray();
		copyFirst = Arrays.copyOf(first, first.length);
		char [] target = br.readLine().toCharArray();
		
		int answer = Integer.MAX_VALUE;
		//0번 스위치를 안 누를 경우
		int count = 0;
		for(int i=1;i<first.length;i++) {
			if(first[i-1] != target[i-1]) {
				push(first, i);
				count++;
			}
		}
		if(first[N-1] == target[N-1]) {
			answer = Math.min(answer, count);
		}
		
		//0번 스위치를 누를 경우
		count = 1;
		push(copyFirst,0);
		for(int i=1;i<copyFirst.length;i++) {
			if(copyFirst[i-1] != target[i-1]) {
				push(copyFirst, i);
				count++;
			}
		}
		if(copyFirst[N-1] == target[N-1]) {
			answer = Math.min(answer, count);
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	public static void push(char [] arr, int switchNum) {
		for(int i=switchNum-1;i<=switchNum+1;i++) {
			if(i < 0 || i >= arr.length) continue;
			arr[i] = (arr[i] == '0') ? '1' : '0';
		}
	}
}