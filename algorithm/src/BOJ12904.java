/**
 * @author nakhoon
 * @date Apr 27, 2021
 * @see https://www.acmicpc.net/problem/12904
 * @mem 14,844kb
 * @time 96ms
 * @caution
 * [고려사항] 거꾸로 생각하면 된다. T에서 S로...
 * 		StringBuffer 클래스의 reverse 함수가 유용했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <문자열> 'A와 B'
public class BOJ12904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		StringBuffer sb;
		while(S.length() < T.length()) {
			char c = T.charAt(T.length()-1);
			
			if(c == 'A') {
				T = T.substring(0,T.length()-1);
			}else {
				T = T.substring(0,T.length()-1);
				sb = new StringBuffer(T);
				T = sb.reverse().toString();
			}
		}
		System.out.println((S.equals(T)) ? 1 : 0);
	}
}