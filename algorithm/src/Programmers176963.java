/**
 * @author nakhoon
 * @date 11/1/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/176963
 * @mem
 * @time
 * @caution
 * [고려사항] 해시맵을 이용하면 쉽게 풀 수 있었던 문제. stream 으로 list to array 연습중
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> - '추억 점수'
public class Programmers176963 {
    public static void main(String[] args) {
        String [] name = {"may", "kein", "kain", "radi"};
        int [] yearning = {5, 10, 1, 3};
        String [][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        System.out.println(Arrays.toString(solution(name, yearning,photo)));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> scoreMap = new HashMap<>();
        for(int i=0;i<name.length;i++){
            scoreMap.put(name[i], yearning[i]);
        }

        for(String [] photoCase : photo){
            int sum = 0;
            for (String s : photoCase) {
                sum += scoreMap.getOrDefault(s, 0);
            }
            answerList.add(sum);
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
