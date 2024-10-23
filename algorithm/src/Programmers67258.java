/**
 * @author nakhoonchoi
 * @date 2024/10/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/67258
 * @caution
 * [고려사항]
 * 해시맵과 투 포인터(?)로 해결한 문제이다.
 * right를 0부터 gems의 length까지 순회하면서
 * left를 최대한 당겨와서 right - left의 최소값을 갱신하며 answer에 기입하면 되었다.
 *
 * gems의 종류 판별은 gems 배열을 리스트로 변환한 뒤에 hashSet의 생성자에 넣어 size를 출력했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2020 카카오 인턴십> '보석 쇼핑'

public class Programmers67258 {
    public static void main(String[] args) {
        String [] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};

        System.out.println(Arrays.toString(solution(gems)));
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];

        int jewelryKind = new HashSet<>(Arrays.asList(gems)).size();
        Map<String, Integer> jewelryCountMap = new HashMap<>();

        int left = 0;
        int minLength = gems.length;
        for(int right=0;right<gems.length;right++){
            jewelryCountMap.put(gems[right], jewelryCountMap.getOrDefault(gems[right], 0) + 1);

            while(left < right){
                if(jewelryCountMap.get(gems[left]) > 1){
                    jewelryCountMap.put(gems[left], jewelryCountMap.get(gems[left]) - 1);
                    left++;
                }else{
                    break;
                }
            }

            if(jewelryCountMap.keySet().size() == jewelryKind && minLength > right - left){
                minLength = right - left;
                answer[0] = left + 1;
                answer[1] = right + 1;
            }
        }

        return answer;
    }
}