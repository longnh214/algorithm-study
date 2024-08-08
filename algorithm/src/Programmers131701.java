/**
 * @author nakhoonchoi
 * @date 2024/08/08
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/131701
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 3중 포문으로 인해 O(N^3) 의 시간 복잡도를 가지는 점이 아쉬웠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//프로그래머스 <레벨2> '연속 부분 수열 합의 개수'

public class Programmers131701 {
    public static void main(String[] args) throws IOException{
        int [] elements = {7,9,1,1,4};
        System.out.println(solution(elements));
    }

    public static int solution(int[] elements) {
        Set<Integer> numSet = new HashSet<>();

        for(int count=1;count<=elements.length;count++){
            for(int start=0;start<elements.length;start++){
                int sum = 0;
                for(int i=0;i<count;i++){
                    sum += elements[(start + i) % elements.length];
                }
                numSet.add(sum);
            }
        }

        return numSet.size();
    }
}
