/**
 * @author nakhoon
 * @date Jan 7, 2022
 * @see https://www.acmicpc.net/problem/16953
 * @mem 11,544kb
 * @time 76ms
 * @caution
 * [고려사항]
 * BFS로 풀 수도 있었지만 거꾸로 생각해서 B에서 A를 만들 수 있는 지 없는 지 판별할 수 있겠다고 생각했고, 조건에 따라 나눠주기만 했으면 되었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> 'A->B'
public class BOJ16953 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int count = 1;
		while(B > A) {
			if(B % 10 == 1) {
				B /= 10;
				count++;
			}
			else if(B % 2 == 0) {
				B /= 2;
				count++;
			}else {
				break;
			}
		}
		
		System.out.println(A == B ? count : -1);
	}
}