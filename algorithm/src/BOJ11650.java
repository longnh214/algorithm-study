/**
 * @author nakhoon
 * @date Feb 19, 2022
 * @see https://www.acmicpc.net/problem/11650
 * @mem 56,640kb
 * @time 564ms
 * @caution
 * [고려사항]
 * 리스트 정렬을 했을 때 시간 초과가 발생해서 2차원 배열을 정렬하는 방식으로 바꿔서 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> - '좌표 정렬하기'
public class BOJ11650 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] pointArr = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pointArr[i][0] = Integer.parseInt(st.nextToken());
			pointArr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(pointArr, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
				else return Integer.compare(o1[1],o2[1]);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(pointArr[i][0]).append(" ").append(pointArr[i][1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}