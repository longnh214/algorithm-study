/**
 * @author nakhoon
 * @date May 25, 2021
 * @see https://www.acmicpc.net/problem/15922
 * @mem 44,176kb
 * @time 380ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '아우으 우아으이야!!'
public class BOJ15922 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Point [] pointArr = new Point[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pointArr[i] = new Point(a,b);
		}
		
		Arrays.sort(pointArr);
		
		int answer = 0;
		int standardX = pointArr[0].x;
		int standardY = pointArr[0].y;
		for(int i=1;i<N;i++) {
			if(standardY < pointArr[i].x) {
				answer += (standardY - standardX);
				standardX = pointArr[i].x;
				standardY = pointArr[i].y;
			}else if(standardY <= pointArr[i].y){
				standardY = pointArr[i].y;
			}else {
				continue;
			}
		}
		answer += (standardY - standardX);
		
		System.out.println(answer);
	}
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if(this.x == o.x)
				return Integer.compare(this.y, o.y);
			else
				return Integer.compare(this.x, o.x);
		}
	}
}