/**
 * @author nakhoon
 * @date 10/31/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/161989?language=java
 * @mem
 * @time
 * @caution
 * [고려사항] 그리디 문제였다. section 배열의 크기는 무조건 1 이상이기 때문에 칠할 곳은 있다.
 *          최소 한 번 칠한다고 가정하고, 다음 section을 선형 탐색하면서 새로 칠할 것인지 아닌지 판별해서 횟수를 count한다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> - 덧칠하기
public class Programmers161989 {
    public static void main(String[] args) {
        int n = 5;
        int m = 2;
        int [] section = {1,2,5};

        System.out.println(solution(n, m, section));
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];
        for(int next : section){
            if(start + m > next){
                continue;
            }
            start = next;
            answer++;
        }

        return answer;
    }
}
