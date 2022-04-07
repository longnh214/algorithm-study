/**
 * @author nakhoon
 * @date Apr 7, 2022
 * @see https://www.acmicpc.net/problem/14003
 * @mem 316,968kb
 * @time 1,032ms
 * @caution
 * [고려사항]
 * list에 이분탐색으로 자리를 찾아서 맞는 자리에 값을 치환해주고,
 * index 배열을 하나 만들어서 값을 list에 set 해줄 때마다 list의 크기를 기록해주었다.
 * LIS를 추출한 뒤에는 전체 배열을 뒤부터 돌면서 스택에 넣어줌으로써 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//백준 <LIS(NlogN)> '가장 긴 증가하는 부분 수열 5'
public class BOJ14003 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arr = new int[N];
		int [] indexArr = new int[N];
		List<Integer> list = new ArrayList<>();

		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		list.add(Integer.MIN_VALUE);

		for(int i = 0;i < N;i++){
			int num = arr[i];
			int left = 1;
			int right = list.size() - 1;

			if(num > list.get(list.size() - 1)) {
				list.add(num);
				indexArr[i] = list.size() - 1;
			}else{
				while(left < right){
					int mid = (left + right) / 2;

					if(list.get(mid) >= num) right = mid;
					else left = mid + 1;
				}
				list.set(right, num);
				indexArr[i] = right;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(list.size() - 1 + "\n");

		Stack<Integer> stack = new Stack();
		int index = list.size() - 1;

		for(int i=N-1;i>=0;i--){
			if(indexArr[i] == index){
				index--;
				stack.push(arr[i]);
			}
		}

		while (!stack.isEmpty()){
			sb.append(stack.pop() + " ");
		}

		System.out.println(sb.substring(0, sb.length()-1));
	}
}