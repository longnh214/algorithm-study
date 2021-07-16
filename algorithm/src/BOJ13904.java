/**
 * @author nakhoon
 * @date Jul 16, 2021
 * @see https://www.acmicpc.net/problem/13904
 * @mem 12,396kb
 * @time 120ms
 * @caution
 * [고려사항]
 * 맨 뒤 날짜부터 거꾸로 봐서 과제 점수가 가장 높은 점수부터 챙기면 정답이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '과제'
public class BOJ13904 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Homework> homeworkList = new ArrayList<>();
		int maxDay = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			homeworkList.add(new Homework(day,score));
			maxDay = Math.max(day, maxDay);
		}
		
		int answer = 0;
		for(int i=maxDay;i>0;i--) {
			answer += getMaxScoreInDay(homeworkList,i);
		}
		System.out.println(answer);
	}
	
	public static int getMaxScoreInDay(List<Homework> homeworkList, int now) {
	    int idx = -1;
	    int result = 0;
	    for (int i = 0;i<homeworkList.size();i++) {
	    	if(homeworkList.get(i).day >= now && result < homeworkList.get(i).score) {
		    	idx = i;
			    result = homeworkList.get(i).score;
		   	}
	    }
	    
	    if (result == 0) {
	      return 0;
	    }

	    homeworkList.remove(idx);
	    return result;
	  }
	
	static class Homework{
		int day;
		int score;
		Homework(int day, int score){
			this.day = day;
			this.score = score;
		}
	}
}