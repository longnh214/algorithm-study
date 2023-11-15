/**
 * @author nakhoon
 * @date 11/15/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12932
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '자연수 뒤집어 배열로 만들기'
public class Programmers12932 {
    public static int[] solution(long n) {
        String str = String.valueOf(n);
        int[] answer = new int[String.valueOf(n).length()];
        for(int i=0;i<str.length();i++){
            answer[i] = str.charAt(str.length() - i - 1) - '0';
        }
        return answer;
    }

    public static void main(String[] args) {
        long n = 12345;
        System.out.println(Arrays.toString(solution(n)));
    }
}
