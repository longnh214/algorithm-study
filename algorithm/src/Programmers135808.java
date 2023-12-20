/**
 * @author nakhoon
 * @date 12/20/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/135808
 * @mem
 * @time
 * @caution
 * [고려사항]
 * int 배열을 뒤집는데 고민을 많이 했고, 배열의 index를 지정하는 것도 오래 걸렸다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.util.stream.*;

//프로그래머스 <연습문제> '과일 장수'
public class Programmers135808 {
    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int [] score = {1,2,3,1,2,3,1};
        System.out.println(solution(k, m, score));
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        List<Integer> scoreList = Arrays.stream(score).boxed().collect(Collectors.toList());

        Collections.sort(scoreList);

        Collections.reverse(scoreList);

        for(int i=0;i<scoreList.size() / m;i++){
            answer += (scoreList.get((i + 1) * m - 1) * m);
        }
        return answer;
    }
}