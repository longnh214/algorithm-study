/**
 * @author nakhoon
 * @date 11/6/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/76501
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//프로그래머스 <연습문제> '음양 더하기'
public class Programmers76501 {
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0;i< absolutes.length;i++){
            answer += (signs[i] ? absolutes[i] : -1 * absolutes[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] absolutes = {4,7,12};
        boolean [] signs = {true, false, true};

        System.out.println(solution(absolutes, signs));
    }
}