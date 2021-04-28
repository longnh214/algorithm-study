/**
 * @author nakhoon
 * @date Apr 28, 2021
 * @see https://www.acmicpc.net/problem/16916
 * @mem 29,672kb
 * @time 276ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <문자열/KMP> '부분 문자열'
public class BOJ16916 {
	static int answer=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		String second = br.readLine();
		KMP(first,second);
		System.out.println(answer);
	}
	
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j=0;
		for(int i=1;i<pattern.length();i++) {
			while(j>0 && pattern.charAt(i)!=pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(pattern.charAt(i)==pattern.charAt(j)) 
				pi[i] = ++j;
		}
		return pi;
	}
	
	static void KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		int j=0;
		for(int i=0;i<origin.length();i++) {
			while(j>0 && origin.charAt(i)!=pattern.charAt(j)) {
				j=pi[j-1];
			}
			if(origin.charAt(i)==pattern.charAt(j)) {
				if(j==pattern.length()-1) {
					answer=1;
					break;
				}
				else
					j++;
			}
		}
	}
}