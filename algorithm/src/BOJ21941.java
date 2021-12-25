/**
 * @author nakhoon
 * @date Dec 25, 2021
 * @see https://www.acmicpc.net/problem/21941
 * @mem 14,952kb 
 * @time 136ms
 * @caution
 * [고려사항]
 * 분류에는 DP로 되어있었지만, 그리디(?)하게 문제를 해결했다. 점수가 높고, 문자열의 길이가 짧은 것부터 점수화하려고 했었지만
 * 이 부분을 하나의 변수로 만들어서 점수/문자열의 길이의 변수를 double 형으로 만들어주었다.
 * 이 과정에서 우선순위 큐에 각 문자열, 점수 값을 넣을 때 고려해야할 점이 있었다. 문자열의 길이보다 점수가 낮으면 큐에 넣으면 안된다는 점 이였다.
 * 하지만 double 형으로 나누기만 하면 int 형의 나눗셈이 되어 소수점이 버려지게 되어 형 변환을 해주어야 했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '문자열 제거'
public class BOJ21941 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		PriorityQueue<Str> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			if(str.length() >= score) {
				continue;
			}
			
			pq.offer(new Str(str, score));
		}
		int output = 0;
		
		while(!pq.isEmpty()) {
			Str cur = pq.poll();
			while(input.contains(cur.str)) {
				input = input.replaceFirst(cur.str, "_");
				output += cur.score;
			}
		}
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i) != '_') {
				output++;
			}
		}
		System.out.println(output);
	}
	
	static class Str implements Comparable<Str>{
		String str;
		int score;
		double calScore;
		
		Str(String str, int score){
			this.str = new String(str);
			this.score = score;
			this.calScore = (double) score / str.length();
		}
		@Override
		public int compareTo(Str o) {
			// TODO Auto-generated method stub
			return Double.compare(this.calScore, o.calScore) * -1;
		}
	}
}