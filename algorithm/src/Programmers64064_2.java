/**
 * @author nakhoonchoi
 * @date 2024/10/27
 * @see https://programmers.co.kr/learn/courses/30/lessons/64064
 * @caution
 * [고려사항]
 * 기존에 풀었던 문제 중 방문 처리를 BitSet을 이용해서 풀었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2019 카카오 겨울 인턴십> '불량 사용자'

public class Programmers64064_2 {
    static Set<BitSet> caseSet;
    static BitSet visited;
    static String [] userId;
    static String [] bannedId;
    public static void main(String[] args) {
        String [] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String [] banned_id = {"fr*d*", "abc1**"};
        System.out.println(solution(user_id, banned_id));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        userId = user_id;
        bannedId = banned_id;
        caseSet = new HashSet<>();
        visited = new BitSet(user_id.length);

        perm(0);

        return caseSet.size();
    }

    public static void perm(int cnt){
        if(cnt == bannedId.length){
            caseSet.add((BitSet) visited.clone());
            return;
        }

        for(int i=0;i<userId.length;i++){
            if(!visited.get(i) && isMatch(userId[i], bannedId[cnt])){
                visited.set(i); //true 처리 visited[i] = true;
                perm(cnt+1);
                visited.clear(i); //false 처리 visited[i] = false;
            }
        }
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
}