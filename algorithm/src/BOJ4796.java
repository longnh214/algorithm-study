/**
 * @author nakhoon
 * @date Feb 12, 2022
 * @see https://www.acmicpc.net/problem/4796
 * @mem 12,616kb
 * @time 128ms
 * @caution
 * [고려사항]
 * 몫과 나머지를 이용해서 최대로 사용할 수 있는 휴가를 구할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '캠핑'
public class BOJ4796 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int count = 1;
		while(!(str = br.readLine()).equals("0 0 0")) {
			StringTokenizer st = new StringTokenizer(str);
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int total = 0;
			total += ((V / P) * L);
			total += Math.min(V%P, L);
			
			System.out.println("Case " + (count++) +  ": " + total);
		}
	}
}