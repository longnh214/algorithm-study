/**
 * @author nakhoon
 * @date Feb 2, 2022
 * @see https://www.acmicpc.net/problem/11509
 * @mem 83,276kb
 * @time 340ms
 * @caution
 * [고려사항]
 * 바로 직전의 풍선 높이만을 생각하는 문제인 줄 알았는데, 인덱스 차이에 상관없이 이전 중에 어느 인덱스의 풍선(화살)이라도 영향을 줄 수 있었다.
 * 화살의 개수를 저장할 수 있는 배열을 선언했고, 화살이 0개라면 현재 풍선 높이만큼 화살을 추가하면서 전체 화살을 더해주었다.
 * 최대 높이는 1000000만이지만 100만 1 높이의 화살도 존재할 수 있으므로 배열의 총 크기를 100만 2로 주어야 하는 점을 주의해야 했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '풍선 맞추기'
public class BOJ11509 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arrow = new int[1000002];
		int answer = 0;
		for(int i=0;i<N;i++) {
			int balloon = Integer.parseInt(st.nextToken());
			if(arrow[balloon+1] == 0) {
				arrow[balloon]++;
				answer++;
			}else {
				arrow[balloon+1]--;
				arrow[balloon]++;
			}
		}
		System.out.println(answer);
	}
}