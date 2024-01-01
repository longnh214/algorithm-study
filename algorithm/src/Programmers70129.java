/**
 * @author nakhoon
 * @date 1/1/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/70129
 * @mem
 * @time
 * @caution
 * [고려사항]
 * Integer.toString(num, radix)를 이용해서 2진법으로 변환해서 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '이진 변환 반복하기'
public class Programmers70129 {
    public static void main(String[] args) {
        String s = "1111111";
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int totalCount = 0;
        int eraseZeroCount = 0;
        while(!s.equals("1")) {
            int beforeLength = s.length();
            s = s.replace("0","");
            int afterLength = s.length();
            eraseZeroCount += (beforeLength - afterLength);
            totalCount++;
            s = Integer.toString(afterLength, 2);
        }
        answer[0] = totalCount;
        answer[1] = eraseZeroCount;
        return answer;
    }
}
