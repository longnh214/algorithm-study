/**
 * @author nakhoon
 * @date 12/2/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12940
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 최대공약수 GCD 함수를 재귀로 구현해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '최대공약수와 최소공배수'
public class Programmers12940 {
    public static void main(String[] args) {
        int n = 5;
        int m = 2;
        System.out.println(Arrays.toString(solution(n, m)));
    }

    public static int[] solution(int n, int m) {
        return Arrays.asList(gcd(n,m), (n * m / gcd(n,m))).stream().mapToInt(i -> i).toArray();
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}