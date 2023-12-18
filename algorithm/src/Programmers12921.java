/**
 * @author nakhoonchoi
 * @date 2023/12/18
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12921
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 소수 구하는 메소드를 구현해서 for문을 순회하며 판별했다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '소수 찾기'
public class Programmers12921 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        for(int i=2;i<=n;i++){
            if(isPrime(i)){
                answer++;
            }
        }
        return answer;
    }

    private static boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
