/**
 * @author nakhoon
 * @date Aug 23, 2021
 * @see https://www.acmicpc.net/problem/6443
 * @mem 36,672kb
 * @time 288ms
 * @caution
 * [고려사항]
 * C++의 next_permutation 알고리즘을 통해 다음 순열이 있으면 출력하고 아니면 while문을 탈출하는 식으로 해결하였다.
 * 마지막 개행 문자를 제거해주어야 문제의 답에 맞는 출력 형식이 나올 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <문자열> '애너그램'
public class BOJ6443 {
	static char [] str;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			str = br.readLine().toCharArray();
			Arrays.sort(str);
			
			for(int i=0;i<str.length;i++) {
				sb.append(str[i]);
			}
			sb.append("\n");
			while(next_permutation()) {
				for(int i=0;i<str.length;i++) {
					sb.append(str[i]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString().substring(0,sb.length()-1));
			sb.setLength(0);
		}
	}
	
	public static boolean next_permutation() {
		int i = str.length-1;
		while(i>0 && str[i-1] >= str[i])
			i--;
		if(i <= 0) return false;
		
		i--;
		int j = str.length-1;
		while(str[i] >= str[j])
			j--;
		
		char temp = str[j];
		str[j] = str[i];
		str[i] = temp;
		
		Arrays.sort(str,i+1,str.length);
		return true;
	}
}