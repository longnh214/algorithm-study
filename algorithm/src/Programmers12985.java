/**
 * @author nakhoon
 * @date 1/10/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12985
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 2,3과 4,5는 같은 라운드에서 만날 수 없기 때문에 1 차이의 값으로는 만날 수 없다.
 * 다른 조건이 필요한데 한 번 더 2로 나누고 값이 같은 지 다른 지 비교를 통해 조건을 변경했다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '예상 대진표'
public class Programmers12985 {
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(solution(n, a, b));
    }

    public static int solution(int n, int a, int b) {
        int answer = 0;

        while(a != b){
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
}