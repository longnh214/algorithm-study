/**
 * @author nakhoon
 * @date Jul 8, 2021
 * @see https://www.acmicpc.net/problem/7983
 * @mem 286,076kb
 * @time 1,464ms 
 * @caution
 * [고려사항]
 * 객체 배열보다 객체 리스트를 정렬하는 것 더 시간이 적게 들었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '내일 할거야'
public class BOJ7983 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Homework> hwList = new ArrayList<>();
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int deadline = Integer.parseInt(st.nextToken());
			
			hwList.add(new Homework(day, deadline));
		}
		
		Collections.sort(hwList);
		
		int standard = hwList.get(0).deadline + 1;
		
		for(Homework hw : hwList) {
			if(standard > hw.deadline) {
				standard = hw.deadline;
			}
			
			if(standard > standard - hw.day) {
				standard = standard - hw.day;
			}
		}
		
		System.out.println(standard);
	}
	
	static class Homework implements Comparable<Homework>{
		int day;
		int deadline;
		
		public Homework(int day, int deadline) {
			this.day = day;
			this.deadline = deadline;
		}

		@Override
		public int compareTo(Homework o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.deadline, o.deadline) * -1;
		}
	}
}