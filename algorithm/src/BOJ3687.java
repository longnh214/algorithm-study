/**
 * @author nakhoon
 * @date Sep 21, 2021
 * @see https://www.acmicpc.net/problem/3687
 * @mem 11,908kb
 * @time 100ms
 * @caution
 * [고려사항]
 * N 개의 성냥개비로 만들 수 있는 수들 중 가장 큰 수는 그리디 알고리즘을 이용해서 구하기 쉬웠는데,
 * 가장 작은 수를 구하는 데에 어려운 점이 있었다.
 * 1차원 배열로 선언해서 0을 제외한 초기값을 선언하고, 값을 추가하면서 성냥개비로 만들 수 있는 수 중 가장 작은 값을 저장한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디,DP> '성냥개비'
public class BOJ3687 {
	static long [] minArr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		minArr = new long[101];
		Arrays.fill(minArr,  Long.MAX_VALUE);
		getMinInit();
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(minArr[N] + " " + getMax(N));
		}
	}
	
	public static void getMinInit() {
		//초기값 설정. 6번의 인덱스의 값은 원래 0이 6보다 더 적지만, 0은 첫번째 값으로 올 수 없다.
		//8의 경우에는 7을 뺀다면 성냥개비 1개로 만들 수 없으므로 8도 미리 초기 값을 설정한다.
		minArr[2] = 1;
		minArr[3] = 7;
		minArr[4] = 4;
		minArr[5] = 2;
		minArr[6] = 6;
		minArr[7] = 8;
		minArr[8] = 10;
		
		String [] add = {"0","0","1","7","4","2","0","8"};
		
		for(int i=9;i<101;i++) {
			for(int j=2;j<=7;j++) {
				String str = minArr[i-j]+ add[j];
				minArr[i] = Math.min(Long.parseLong(str), minArr[i]);
			}
		}
	}
	
	public static String getMax(int N) {
		StringBuilder sb = new StringBuilder();
		if(N%2 == 0) {
			for(int i=0;i<N/2;i++) {
				sb.append(1);
			}
		}else {
			sb.append(7);
			for(int i=0;i<N/2 - 1;i++) {
				sb.append(1);
			}
		}
		return sb.toString();
	}
}