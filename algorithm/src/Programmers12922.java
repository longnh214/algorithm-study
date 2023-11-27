/**
 * @author nakhoon
 * @date 11/27/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12922
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

//프로그래머스 <연습문제> '수박수박수박수박수박수?'
public class Programmers12922 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(solution(n));
    }

    public static String solution(int n) {
        if(n < 1) return "";
        StringBuilder sb = new StringBuilder();
        IntStream.range(1, n+1).forEach(i -> sb.append(i % 2 == 1 ? "수" : "박"));
        return sb.toString();
    }
}
