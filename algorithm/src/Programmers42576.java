import java.util.*;

//프로그래머스 코딩테스트 연습 <해쉬> - '완주하지 못한 선수' 문제
public class Programmers42576 {
    //Hash를 안썼을 때 2중 for문으로 짠 함수
    //O(n*n)으로 시간 초과
    public String solution1(String[] participant, String[] completion) {
        String answer = "";

        for(int i=0;i<participant.length;i++){
            for(int j=0;j<completion.length;j++){
                if(participant[i].equals(completion[j])){
                    participant[i] = null;
                    completion[j] = null;
                    break;
                }
            }
        }

        for(int i=0;i<participant.length;i++){
            if(participant[i] != null)
                answer += participant[i];
        }
        return answer;
    }

    //효율성 에러,  두 번째 생각한 방법
    //두 배열을 정렬한 후, 다르면 그 값을 출력하거나 끝까지 남은 part배열 마지막 값 출력
    //정렬은 안될 줄 알았는데 효율성 통과
    public String solution2(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for(i=0;i<completion.length;i++){
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }
        return participant[i];
    }

    //해쉬를 참고해서 해결한 코드.(다른 사람의 코드 참고)
    //HashMap : 키와 쌍을 이용해 키를 검색해서 값을 찾아낼 수 있는 유용한 자료구조? 알고리즘.
    //HashMap.getOrDefault(a,b)는 a라는 키에 대한 값이 없을 경우, 뒤의 b를 default로 한다.
    //HashMap.keySet()은 맵에 저장된 키들을 중복 없이 꺼낼 수 있는 메소드이다.
    public String solution3(String[] participant, String[] completion) {
        Map<String,Integer> hashMap = new HashMap<>();
        for(String player : participant)
            hashMap.put(player, hashMap.getOrDefault(player,0)+1);
        for(String player : completion)
            hashMap.put(player, hashMap.get(player)-1);
        for(String key : hashMap.keySet())
            if(hashMap.get(key)!=0)
                return key;
        return null;
    }
}
