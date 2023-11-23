/**
 * @author nakhoon
 * @date 11/24/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12935
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//프로그래머스 <연습문제> '제일 작은 수 제거하기'
public class Programmers12935 {
    public static void main(String[] args) {
        int [] arr = {4,3,2,1};
        System.out.println(solution(arr));
    }
    public static int[] solution(int[] arr) {
        if (arr.length == 1) {
            return List.of(-1).stream().mapToInt(i -> i).toArray();
        }

        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i > min).toArray();
    }
}