/**
 * @author nakhoon
 * @date 12/22/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/136798
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '기사단원의 무기'
public class Programmers136798 {
    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;
        System.out.println(solution(number, limit, power));
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            answer += modCount(i) > limit ? power : modCount(i);
        }
        return answer;
    }

    private static int modCount(int n){
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) count++;
            else if (n % i == 0) count += 2;
        }
        return count;
    }
}
