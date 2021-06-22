/**
 * @author nakhoon
 * @date Jun 22, 2021
 * @see https://www.acmicpc.net/problem/5052
 * @mem 32,260kb
 * @time 568ms
 * @caution
 * [고려사항]
 * int 형을 정렬하는 것이 아니라 String을 정렬하면 123,1234,125,37로 정렬되기 때문에 접두어가 비슷한 문자열이 모이게 됩니다.
 * startsWith를 이용해 접두어가 맞는 지 판단하는 문제
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <문자열> '전화번호 목록'
public class BOJ5052 {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			String [] phoneNumber = new String[N];
			
			for(int i=0;i<N;i++) {
				phoneNumber[i] = br.readLine();
			}
			
			Arrays.sort(phoneNumber);
			
			if(isConsistent(N,phoneNumber)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
		br.close();
	}
	public static boolean isConsistent(int N, String [] phoneNumber) {
		for(int i=0;i<N-1;i++) {
			if(phoneNumber[i+1].startsWith(phoneNumber[i])) {
				return false;
			}
		}
		return true;
	}
}