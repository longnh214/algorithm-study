/**
 * @author nakhoon
 * @date 11/8/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12928
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//프로그래머스 <연습문제> '약수의 합'
public class Programmers12928 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(solution(n));
    }
    public static int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(n % i == 0){
                answer += i;
            }
        }
        return answer;
    }
}
