/**
 * @author nakhoon
 * @date Jan 31, 2022
 * @see https://programmers.co.kr/learn/courses/30/lessons/92342
 */
import java.util.*;
//프로그래머스 <2022 카카오 공채> '양궁대회'
public class Programmers92342 {
	static int [] ryanInfo = new int[11];
	static int [] apeechInfo;
	static List<ScoreBoard> sbList;
	public static void main(String[] args) {
		int n = 10;
		int [] info = {0,0,0,0,0,0,0,0,3,4,3};

		System.out.println(solution(n, info));
	}
	
	public static int[] solution(int n, int[] info) {
		apeechInfo = info;
		sbList = new ArrayList<>();
		
		perm(n,0);
		
		Collections.sort(sbList);
		
		int [] answer = {};
		
		if(sbList.size() == 0) {
			answer = new int[1];
			answer[0] = -1;
		}else {
			answer = sbList.get(0).info;
		}
        return answer;
    }
	
	static class ScoreBoard implements Comparable<ScoreBoard>{
		int [] info;
		int score;
		
		public ScoreBoard(int [] info, int score) {
			this.info = new int[info.length];
			for(int i=0;i<info.length;i++) {
				this.info[i] = info[i];
			}
			this.score = score;
		}

		@Override
		public int compareTo(ScoreBoard o) {
			if(this.score == o.score) {
				for(int i=this.info.length-1;i>=0;i--) {
					if(this.info[i] == o.info[i]) continue;
					return Integer.compare(this.info[i], o.info[i]) * -1;
				}
			}
			return  Integer.compare(this.score, o.score) * -1;
		}
	}

	public static void perm(int remainCount, int index) {
		if(remainCount == 0) {
			//여기서 계산
			int ryanScore = 0;
			int apeechScore = 0;
			for(int i=0;i<11;i++) {
				if(apeechInfo[i] == 0 && ryanInfo[i] == 0) continue;
				if(apeechInfo[i] >= ryanInfo[i]) {
					apeechScore += (10 - i);
				}else {
					ryanScore += (10 - i);
				}
			}
			if(ryanScore - apeechScore > 0)
				sbList.add(new ScoreBoard(ryanInfo,ryanScore - apeechScore));
			return;
		}
		
		for(int i=index;i<ryanInfo.length;i++) {
			for(int j=0;j<=remainCount;j++) {
				ryanInfo[i] = j;
				perm(remainCount - j, i+1);
				ryanInfo[i] = 0;
			}
		}
	}
}