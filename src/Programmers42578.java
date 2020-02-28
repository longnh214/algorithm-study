import java.util.*;

//프로그래머스 코딩테스트 연습 <해쉬> - '위장' 문제
public class Programmers42578 {
    public static void main(String [] args){
        String [][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
    //getOrDefault를 이용해 옷 분류(key)마다의 개수를 hashMap에 입력
    //해당 옷 분류(key)의 옷을 입지 않을 경우의 수를 포함해서
    //예를 들어 옷 분류 종류가 3가지라면 (A 해쉬 값 + 1)*(B 해쉬 값 + 1)*(C 해쉬 값 + 1)-1이 모든 경우의 수가 된다.
    //경우의 수 공식 찾가 매우 어려웠던 문제.
    public static int solution(String [][] clothes){
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String [] item: clothes){
            hashMap.put(item[1],hashMap.getOrDefault(item[1],0)+1);
        }
        int answer = 1;
        //values()를 이용해 모든 value 를 가져온다.
        for(int value : hashMap.values())
            answer *= (value+1);
        answer-=1;
        return answer;
    }
}
