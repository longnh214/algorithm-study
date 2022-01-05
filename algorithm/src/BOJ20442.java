/**
 * @author nakhoon
 * @date Jan 5, 2022
 * @see https://www.acmicpc.net/problem/20442
 * @mem 137,476kb
 * @time 632ms
 * @caution
 * [고려사항]
 * 계산할 때마다 K의 개수와 R의 개수를 세려고 하니 시간 초과가 났다.
 * 처음에 입력을 받자마자 R이전의 K개수와 이후의 K개수를 저장해주면 해결할 수 있었던 문제이다.
 * 그리디와 투 포인터가 접목된 문제라 많이 어려웠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <투 포인터> 'ㅋㅋ루ㅋㅋ'
public class BOJ20442 {
	static List<Integer> leftKList;
	static List<Integer> rightKList;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		leftKList = new ArrayList<>();
		rightKList = new ArrayList<>();
		int kCount = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == 'K') kCount++;
			else if(str.charAt(i) == 'R')
				leftKList.add(kCount);
		}
		kCount = 0;
		for(int i=str.length()-1;i>=0;i--) {
			if(str.charAt(i) == 'K') kCount++;
			else if(str.charAt(i) == 'R')
				rightKList.add(kCount);
		}
		Collections.sort(rightKList, Comparator.reverseOrder());
		int left = 0;
		int right = rightKList.size()-1;
		int answer = 0;
		
		while(left <= right) {
			answer = Math.max(answer, Math.min(leftKList.get(left), rightKList.get(right)) * 2 + (right - left + 1));
			
			if(leftKList.get(left) < rightKList.get(right)) {//양쪽 끝부터 K 개수를 셌을 때 더 작은 값을 갱신
				left++;
			}else {
				right--;
			}
		}
		System.out.println(answer);
	}
}