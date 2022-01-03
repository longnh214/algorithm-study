/**
 * @author nakhoon
 * @date Jan 4, 2022
 * @see https://www.acmicpc.net/problem/6068
 * @mem 12,192kb
 * @time 124ms
 * @caution
 * [고려사항]
 * 강의실 배정과 비슷한 문제였다. 처음 0초부터 첫 시작 시간까지 될 수 있는 경우의 수를 전부 파악해야했다.
 * 마감 시간 기준으로 일을 정렬해서 순서대로 처리하는 것이 중요했다.
 * 걸리는 시간 / 마감 시간으로 저장하는 것이 아니라 최대 시작 시간 / 마감 시간으로 저장했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '시간 관리하기'
public class BOJ6068 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] work = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int deadline = Integer.parseInt(st.nextToken());
			work[i][0] = deadline - time;
			work[i][1] = deadline;
		}
		
		Arrays.sort(work, new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int answer = -1;
		int start = work[0][0];
		int i=0;
		for(;i<=start;i++) {
			int curTime = i;
			boolean flag = true;
			for(int j=0;j<N;j++) {
				curTime += (work[j][1] - work[j][0]);
				if(curTime > work[j][1]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				answer = i;
			}else {
				break;
			}
		}
		System.out.println(answer);
	}
}