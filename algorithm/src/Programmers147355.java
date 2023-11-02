/**
 * @author nakhoon
 * @date 11/2/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/147355
 * @mem
 * @time
 * @caution
 * [고려사항] p의 자리가 18자리까지 가능하므로 Integer의 범위를 벗어난다. 그러므로 Long 형으로 변환해야 문제를 해결할 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

public class Programmers147355 {
    public static void main(String[] args) {
        String t = "3141592";
        String p = "271";
        System.out.println(solution(t, p));
    }

    public static int solution(String t, String p) {
        int checkLength = p.length();
        long checkNum = Long.parseLong(p);
        int answer = 0;

        for(int i=0;i<t.length() - checkLength + 1;i++){
            String subString = t.substring(i, i + checkLength);

            if(Long.parseLong(subString) <= checkNum){
                answer++;
            }
        }

        return answer;
    }
}
