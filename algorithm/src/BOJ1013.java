/**
 * @author nakhoon
 * @date Aug 18, 2021
 * @see https://www.acmicpc.net/problem/1013
 * @mem 15,700kb
 * @time 228ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <정규 표현식> 'Contact'
public class BOJ1013 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			String input = br.readLine();
			if(input.matches("(100+1+|01)+")) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}