/**
 * @author nakhoon
 * @date Feb 7, 2022
 * @see https://www.acmicpc.net/problem/10799
 * @mem 13,940kb
 * @time 100ms
 * @caution
 * [고려사항]
 * 분기 처리를 적절히 해서 쇠막대기 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <구현> '쇠막대기'
public class BOJ10799 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int answer = 0;
		int stick = 0;
		for(int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			if(c == '(') {
				stick++;
			}else {
				stick--;
				if(input.charAt(i-1) == '(') {
					answer += stick;
				}else {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}