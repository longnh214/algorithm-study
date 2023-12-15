/**
 * @author nakhoon
 * @date 12/15/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/132267
 * @mem
 * @time
 * @caution
 * [고려사항]
 * while 반복문을 통해 최대한 빈 병의 수를 줄이고 count를 세었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '콜라 문제'
public class Programmers132267 {
    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int n = 20;

        System.out.println(solution(a, b, n));
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;

        while(n >= a){
            int newCola = n / a;
            answer += newCola * b;
            n = n - (a * newCola) + (newCola * b);
        }

        return answer;
    }
}
