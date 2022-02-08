/**
 * @author nakhoon
 * @date Feb 8, 2022
 * @see https://www.acmicpc.net/problem/10610
 * @mem 22,948kb
 * @time 260ms
 * @caution
 * [고려사항]
 * 30의 배수의 특징을 이용해서 그리디하게 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '30'
public class BOJ10610 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int total = 0;
		Integer [] digit = new Integer[input.length()];
		for(int i=0;i<input.length();i++) {
			int num = input.charAt(i) - '0';
			digit[i] = num;
			total += num;
		}
		Arrays.sort(digit, Collections.reverseOrder());
		if(total % 3 != 0 || digit[input.length()-1] != 0) {
			System.out.println(-1);
		}else {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<digit.length;i++) {
				sb.append(digit[i]);
			}
			System.out.println(sb.toString());
		}
	}
}