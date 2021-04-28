/**
 * @author nakhoon
 * @date Apr 28, 2021
 * @see https://www.acmicpc.net/problem/1747
 * @mem 18,912kb
 * @time 184ms
 * @caution
 * [고려사항]
 * 소수 판별 알고리즘을 착각해서 오래 걸렸었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <문자열> '소수&팰린드롬'
public class BOJ1747 {
	static boolean [] isPrime;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		isPrime = new boolean[1003003];
		isPrime[0] = true;
		isPrime[1] = true;
		for(int i=2;i*i<=1003002;i++) {
			for(int j=2;j*i<=1003002;j++) {
				isPrime[i*j] = true;
			}
		}

		for(int i=0;i<1003002;i++) {
			if(!isPrime[i]) {
				isPrime[i] = isPalindrome(Integer.toString(i));
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=N;i<1003002;i++) {
			if(!isPrime[i]) {
				System.out.println(i);
				return;
			}
		}
	}
	public static boolean isPalindrome(String str) {
		for(int i=0;i<((double)(str.length()-1)/2.0);i++) {
			if(str.charAt(i) != str.charAt(str.length()-i-1))
				return true;
		}
		return false;
	}
}