/**
 * @author nakhoonchoi
 * @date 2024/10/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12938
 * @caution
 * [고려사항]
 * 수학 문제인가...? 싶은게
 * 총 합이 s이며 n개로 나누려면 각 배열의 값을 골고루 나누는 게 좋았다.
 * 예를 들어 n이 5이고, s가 10인 경우
 * [2,2,2,2,2]로 나눴을 때 곱이 32로 최대이다.
 * 고로 n만큼 순회하면서 s에서 s/n을 빼며 n이 1이 될 때까지 값을 넣으면 값에 맞게 분배된다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <연습문제> '최고의 집합'

public class Programmers12938 {
    public static void main(String[] args) {
        int n = 2;
        int s = 9;

        System.out.println(Arrays.toString(solution(n, s)));
    }

    public static int[] solution(int n, int s) {
        if(n > s){
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int index = 0;

        while(n > 0){
            answer[index++] = s / n;
            s -= (s / n);
            n--;
        }

        return answer;
    }
}