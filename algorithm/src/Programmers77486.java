/**
 * @author nakhoonchoi
 * @date 2024/09/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/77486
 * @caution
 * [고려사항]
 * 부모와 인덱스를 map으로 저장하고, 타고 타고 올라가면서 이익을 배분한다.
 * 주의할 점은 이익이 1 미만이라면 break하고 본인이 전부 가진다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2021 데브매칭 백엔드> '다단계 칫솔 판매'

public class Programmers77486 {
    public static void main(String[] args){
        String [] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String [] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String [] seller  = {"young", "john", "tod", "emily", "mary"};
        int [] amount = {12,4,2,5,10};

        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> indexMap = new HashMap<>();
        Map<String, String> parentMap = new HashMap<>();
        int[] answer = new int[enroll.length];

        for(int i=0;i<enroll.length;i++){
            indexMap.put(enroll[i], i);
            parentMap.put(enroll[i], referral[i]);
        }

        for(int i=0;i<seller.length;i++){
            String cur = seller[i];
            int money = amount[i] * 100;

            while(!cur.equals("-")){
                int moneyForParent = money / 10;
                int myMoney = money - moneyForParent;

                answer[indexMap.get(cur)] += myMoney;

                cur = parentMap.get(cur);
                money /= 10;

                if(money < 1){
                    break;
                }
            }
        }
        return answer;
    }
}