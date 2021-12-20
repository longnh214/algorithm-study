/**
 * @author nakhoon
 * @date Dec 20, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/64064
 * @caution
 * [고려사항]
 * 순열을 통해 banned_id의 크기 만큼 user_id를 뽑고, 제재된 아이디인지 판별하면 되는 문제이다.
 * banned_id가 ["*****","*****"] 일 때 중복이 많이 발생할 수 있으므로 Set을 사용하되
 * String 배열에 대한 Set이 아닌 Set자체에 대한 Set을 사용하는 것이 중요하다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2019 카카오 겨울 인턴십> '불량 사용자'
public class Programmers64064 {
	static Set<Set<String>> caseSet = new HashSet<>();
	static String [] userId;
	static String [] bannedId;
	static boolean [] visited;
	static String [] temp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String [] banned_id = {"fr*d*", "abc1**"};
		System.out.println(solution(user_id, banned_id));
	}

	public static int solution(String[] user_id, String[] banned_id) {
		userId = user_id;
		bannedId = banned_id;
		visited = new boolean[userId.length];
		temp = new String[bannedId.length];
		
		perm(0);
		
        return caseSet.size();
    }
	
	public static boolean isMatch(String userId, String bannedId) {
		if(userId.length() != bannedId.length()) {
			return false;
		}
		
		for(int i=0;i<userId.length();i++) {
			if(bannedId.charAt(i) == '*') continue;
			
			if(userId.charAt(i) != bannedId.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void perm(int cnt) {
		if(cnt == bannedId.length) {
			int flag = 1;
			for(int i=0;i<temp.length;i++) {
				if(!isMatch(temp[i],bannedId[i])) {
					flag *= 0;
				}
			}
			
			if(flag == 0) return;
			
			Set<String> userCase = new HashSet<>();
			for(int i=0;i<temp.length;i++) {
				userCase.add(temp[i]);
			}
			caseSet.add(userCase);
			
			return;
		}
		
		for(int i=0;i<userId.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				temp[cnt] = userId[i];
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}
}