/**
 * @author nakhoon
 * @date Oct 4, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/72411
 * [고려사항]
 * 조합을 해서 가장 인기 있는 개수의 조합(두 음식의 조합 중 인기도, 세 음식의 조합 중 인기도) 중 가장 많은 인기도를 가진 음식 조합을 찾는 문제이다.
 * 부분집합, 조합을 통해 해결할 수 있었다. 문제가 이해가 잘 안됐던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <카카오 2021 블라인드 공채> '메뉴 리뉴얼'
public class Programmers72411 {
	public static Map<String, Integer> [] map;
	public static boolean []  visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int [] course = {2,3,4};
		System.out.println(Arrays.toString(solution(orders, course)));
	}


	public static String[] solution(String[] orders, int[] course) {
		map = new HashMap[course[course.length-1] + 1];
		
		for(int i=0;i<course.length;i++) {
			map[course[i]] = new HashMap<>();
		}
		
		for(int i=0;i<orders.length;i++) {
			visited = new boolean[10];
			
			char [] arr = orders[i].toCharArray();
			
			Arrays.sort(arr);
			
			subset(arr,0,course[course.length-1]);
		}
		
		List<String> answerList = new ArrayList<>();
		
		for(int i=0;i<course.length;i++) {
			int max = -1;
			for(String key : map[course[i]].keySet()) {
				max = Math.max(map[course[i]].get(key), max);
			}
			if(max > 1) {
				for(String key : map[course[i]].keySet()) {
					if(map[course[i]].get(key) == max) {
						answerList.add(key);
					}
				}
			}
		}
		
		Collections.sort(answerList);
		String [] answer = new String[answerList.size()];
		for(int i=0;i<answer.length;i++) {
			answer[i] = answerList.get(i);
		}
		
		return answer;
	}
	
	public static void subset(char [] arr, int cnt, int max) {
		if(cnt == arr.length) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<arr.length;i++) {
				if(visited[i]) {
					sb.append(arr[i]);
				}
			}
			
			if(sb.length() < 2) return;
			else {
				if(sb.length() <= max && map[sb.length()] != null) {
					map[sb.length()].put(sb.toString(), map[sb.length()].getOrDefault(sb.toString(), 0) + 1);
				}else {
					return;
				}
			}
			return;
		}
		
		visited[cnt] = true;
		subset(arr, cnt+1,max);
		visited[cnt] = false;
		subset(arr,cnt+1,max);
	}
}