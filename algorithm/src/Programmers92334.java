/**
 * @author nakhoon
 * @date Jan 26, 2022
 * @see https://programmers.co.kr/learn/courses/30/lessons/92334
 */
import java.util.*;
//프로그래머스 <2022 카카오 공채> '신고 결과 받기'
public class Programmers92334 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] id_list = {"con", "ryan"};
		String [] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 3;
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String,Set<String>> reportedMap = new HashMap<>();
        Map<String,Set<String>> reportMap = new HashMap<>();
        
        for(int i=0;i<id_list.length;i++) {
        	reportedMap.put(id_list[i], new HashSet<>());
        	reportMap.put(id_list[i], new HashSet<>());
        }
        
        for(int i=0;i<report.length;i++) {
        	String from = report[i].split(" ")[0];
        	String  to = report[i].split(" ")[1];
        	
        	reportedMap.get(to).add(from);
        	reportMap.get(from).add(to);
        }
        
        for(int i=0;i<id_list.length;i++) {
        	int mailCount = 0;
        	for(String target : reportMap.get(id_list[i])) {
        		if(reportedMap.get(target).size() >= k) {
        			mailCount++;
        		}
        	}
        	answer[i] = mailCount;
        }
        return answer;
    }
}