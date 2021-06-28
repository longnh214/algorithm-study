/**
 * @author nakhoon
 * @date Jun 28, 2021
 * @see https://www.acmicpc.net/problem/21939
 * @mem 64,540kb
 * @time 876ms
 * @caution
 * [고려사항]
 * 트리맵과 해시맵을 사용하여 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <우선순위 큐> '문제 추천 시스템 Version 1'
public class BOJ21939 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		TreeMap<Problem, Integer> tMap = new TreeMap<>();
		Map<Integer, Integer> hMap = new HashMap<>();
		
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			
			hMap.put(num, level);
			
			tMap.put(new Problem(num, level), tMap.getOrDefault(new Problem(num, level), 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			
			switch(cmd) {
			case "add":
				int problemNum = Integer.parseInt(st.nextToken());
				int level = Integer.parseInt(st.nextToken());
				
				hMap.put(problemNum, level);
				
				tMap.put(new Problem(problemNum, level), tMap.getOrDefault(new Problem(problemNum, level), 0) + 1);
				break;
			case "recommend":
				int index = Integer.parseInt(st.nextToken());
				if(index == 1) {
					Problem problem = tMap.lastKey();
					System.out.println(problem.num);
				}else {
					Problem problem = tMap.firstKey();
					System.out.println(problem.num);
				}
				break;
			case "solved":
				problemNum = Integer.parseInt(st.nextToken());
				
				level = hMap.get(problemNum);
				
				tMap.remove(new Problem(problemNum, level));
				
				hMap.remove(problemNum);
				break;
			}
		}
	}
	
	static class Problem implements Comparable<Problem>{
		int num;
		int level;
		
		Problem(int num, int level){
			this.num = num;
			this.level = level;
		}

		public int compareTo(Problem o) {
			if(this.level == o.level) {
				return Integer.compare(this.num, o.num);
			}
			return Integer.compare(this.level, o.level);
		}
	}
}