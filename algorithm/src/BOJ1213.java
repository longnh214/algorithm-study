/**
 * @author nakhoon
 * @date Feb 18, 2022
 * @see https://www.acmicpc.net/problem/1213
 * @mem 11,504kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 사전 식으로 가장 앞이여야 하기 때문에 앞부터 사전 순으로 가장 낮은 알파벳부터 채웠다.
 * 그리고 각 알파벳의 개수를 저장하는 배열을 선언했다.
 * 문자열의 길이가 짝수일 때와 홀수일 경우를 나누어서 분기 처리 하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <그리디> '팰린드롬 만들기'
public class BOJ1213 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int [] alpha = new int[26];
		int cur = 26;
		for(int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			alpha[c - 'A']++;
			cur = Math.min(cur, c - 'A');
		}
		//짝수
		char [] answer = new char[input.length()];
		if(input.length()%2 == 0) {
			if(oddCount(alpha) > 0) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
			for(int i=0;i<input.length()/2;i++) {
				if(alpha[cur] < 2) {
					cur = nextIndex(alpha, cur);
				}
				answer[i] = answer[input.length() - i - 1] = (char)('A' + cur);
				alpha[cur] -= 2;
			}
			System.out.println(String.valueOf(answer));
		}else {
			if(oddCount(alpha) != 1) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
			for(int i=0;i<input.length()/2;i++) {
				if(alpha[cur] < 2) {
					cur = nextIndex(alpha, cur);
				}
				answer[i] = answer[input.length() - i - 1] = (char)('A' + cur);
				alpha[cur] -= 2;
			}
			answer[input.length()/2] = (char)('A' + getOddIndex(alpha));
			System.out.println(String.valueOf(answer));
		}
	}

	public static int oddCount(int [] alpha) {
		int count = 0;
		for(int i=0;i<alpha.length;i++) {
			if(alpha[i]%2 == 1) {
				count++;
			}
		}
		return count;
	}
	
	public static int nextIndex(int [] alpha, int cur) {
		for(int i=cur+1;i<alpha.length;i++) {
			if(alpha[i] >= 2) {
				return i;
			}
		}
		return -1;
	}
	
	public static int getOddIndex(int [] alpha) {
		for(int i=0;i<alpha.length;i++) {
			if(alpha[i] % 2 == 1) {
				return i;
			}
		}
		return -1;
	}
}