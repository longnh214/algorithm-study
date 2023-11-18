/**
 * @author nakhoonchoi
 * @date 2023/11/18
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12912
 * @mem
 * @time
 * @caution
 * [고려사항] Math.max, Math.min을 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '두 정수 사이의 합'
public class Programmers12912 {
    public static void main(String[] args) {
        int a = 3;
        int b = 3;
        System.out.println(solution(a,b));
    }
    public static long solution(int a, int b){
        long answer = 0;
        for(int i=Math.min(a,b);i<=Math.max(a,b);i++){
            answer += i;
        }
        return answer;
    }
}
