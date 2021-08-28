/**
 * @author nakhoon
 * @date Aug 28, 2021
 * @see https://www.acmicpc.net/problem/6137
 * @mem 28,604kb
 * @time 160ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <문자열> '문자열 생성'
public class BOJ6137 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			sb.append(temp);
		}
		
		String S = sb.toString();
		String T = "";
		
		int start = 0;
		int end = N-1;
		
		while(start <= end) {
			if(S.charAt(start) < S.charAt(end)) {
				T += S.charAt(start++);
			}else if(S.charAt(end) < S.charAt(start)) {
				T += S.charAt(end--);
			}else {
				int tempS = start + 1;
				int tempE = end - 1;
				int size = T.length();
				while(tempS <= tempE) {
					if(S.charAt(tempS) < S.charAt(tempE)) {
						T += S.charAt(start++);
						break;
					}else if(S.charAt(tempE) < S.charAt(tempS)) {
						T += S.charAt(end--);
						break;
					}else {
						tempS++;
						tempE--;
					}
				}
				if(size == T.length()) T += S.charAt(start++);
			}
		}
		
		for(int i=0;i<T.length();i++) {
			if(i != 0 && i%80 == 0) System.out.println();
			System.out.print(T.charAt(i));
		}
	}
}