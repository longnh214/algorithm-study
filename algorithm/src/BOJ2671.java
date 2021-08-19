/**
 * @author nakhoon
 * @date Aug 19, 2021
 * @see https://www.acmicpc.net/problem/2671
 * @mem 11,576kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 정규 표현식의 반복에 대한 표현식을 이용하면 쉽게 풀 수 있는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <정규 표현식> '잠수함식별'
public class BOJ2671 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		if(input.matches("(100{1,}1{1,}|(01)){1,}")) System.out.println("SUBMARINE");
		else System.out.println("NOISE");
	}
}