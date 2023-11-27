/**
 * @author nakhoon
 * @date 11/28/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/77884
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

//프로그래머스 <연습문제> '약수의 개수와 덧셈'
public class Programmers77884 {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        System.out.println(solution(left, right));
    }

    public static int solution(int left, int right) {
        return IntStream.range(left, right + 1).map(i -> modCount(i) % 2 == 0 ? i : i * -1).sum();
    }

    public static int modCount(int num){
        int count = 0;
        for(int i=1;i<=num;i++){
            if(num % i == 0){
                count++;
            }
        }
        return count;
    }
}
