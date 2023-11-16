/**
 * @author nakhoon
 * @date 11/16/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12933
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 스트림으로 풀 수 있도록 수정해야할 듯.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '정수 내림차순으로 배치하기'
public class Programmers12933 {
    public static long solution(long n) {
        char [] numToChar = String.valueOf(n).toCharArray();
        Arrays.sort(numToChar);

        StringBuilder sb = new StringBuilder();
        for(int i=numToChar.length - 1;i>=0;i--){
            sb.append(numToChar[i]);
        }
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        long n = 118372;

        System.out.println(solution(n));
    }
}