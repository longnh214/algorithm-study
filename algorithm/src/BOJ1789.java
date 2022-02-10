/**
 * @author nakhoon
 * @date Feb 10, 2022
 * @see https://www.acmicpc.net/problem/1789
 * @mem 11,540kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 주어진 수의 범위가 int 형을 벗어나므로 long 형으로 처리했고, 
 * 연속된 수의 합과 S의 값 비교를 통해서 N을 도출해낼 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <그리디> '수들의 합'
public class BOJ1789 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		int cur = 1;
		while(true){
			sum += cur;
			if(sum > S) break;
			cur++;
		}
		System.out.println(cur-1);
	}
}