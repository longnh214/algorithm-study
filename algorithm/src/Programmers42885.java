/**
 * @author nakhoon
 * @date 1/9/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/42885
 * @mem
 * @time
 * @caution
 * [고려사항]
 * people 배열을 정렬 한 뒤에 앞과 뒤 값을 합해서 limit 보다 작으면 앞을 조절하고
 * 뒤 좌표는 판별한 뒤에 바로 반복문에서 --를 해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '구명보트'
public class Programmers42885 {
    public static void main(String[] args) {
        int [] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int min = 0;
        for(int max = people.length-1;min<=max;max--){
            if(people[min] + people[max] <= limit) {
                min++;
            }
            answer++;
        }
        return answer;
    }

    public static int solution1(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int max = people.length - 1;
        for(int min = 0;min<=max;max--){
            if(people[min] + people[max] <= limit) {
                min++;
            }
            answer++;
        }
        return answer;
    }
}
