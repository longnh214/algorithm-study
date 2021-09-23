/**
 * @author nakhoon
 * @date Sep 24, 2021
 * @see https://www.acmicpc.net/problem/1484
 * @mem 11,728kb
 * @time 96ms
 * @caution
 * [고려사항]
 * 투 포인터 알고리즘을 이용해서 해결할 수 있었다. 제곱의 차가 G보다 작거나, 같거나, 큰 경우의 수 세 가지로 나누어서 로직을 구현해야한다.
 * 그리고 while 반복문의 조건에 end 제곱 - (end-1)제곱의 값이 G보다 크면 반복문을 탈출하도록 구현했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <두 포인터> '다이어트'
public class BOJ1484 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		List<Integer> answerList = new ArrayList<>();
		int start = 1;
		int end = 1;
		while(multiDiff(end-1, end) <= G) {
			if(multiDiff(start, end) < G) {
				end++;
			}else if(multiDiff(start, end) == G) {
				answerList.add(end);
				end++;
			}else {
				start++;
			}
		}
		
		if(answerList.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		for(int answer :answerList) {
			System.out.println(answer);
		}
	}

	public static long multiDiff(int low, int high) {
		return high * high - low * low;
	}
}