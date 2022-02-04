/**
 * @author nakhoon
 * @date Feb 4, 2022
 * @see https://www.acmicpc.net/problem/7568
 * @mem 11,584kb
 * @time 76ms
 * @caution
 * [고려사항]
 * O(N^2)로 문제를 해결할 수 있었다. 등수를 정할 때 부등호를 잘못 생각해서 틀렸던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '덩치'
public class BOJ7568 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] data = new int[N][2];
		int [] grade = new int[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i == j) continue;
				
				if(data[i][0] < data[j][0] && data[i][1] < data[j][1]) {
					grade[i]++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(grade[i] + 1).append(" ");
		}
		System.out.println(sb.substring(0, sb.length()-1));
	}
}