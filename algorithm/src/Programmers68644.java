/**
 * @author nakhoon
 * @date 12/14/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/68644
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 조합과 TreeSet을 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '두 개 뽑아서 더하기'
public class Programmers68644 {
    static int [] temp = new int[2];
    static Set<Integer> answerSet;
    public static void main(String[] args) {
        int [] numbers = {2,1,3,4,1};

        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        answerSet = new TreeSet<>();

        comb(numbers, 0, 0);

        return answerSet.stream().mapToInt(i -> i).toArray();
    }

    public static void comb(int [] numbers, int cur, int count){
        if(count == temp.length){
            answerSet.add(temp[0] + temp[1]);

            return;
        }

        for(int i=cur;i<numbers.length;i++){
            temp[count] = numbers[i];
            comb(numbers, i+1, count+1);
        }
    }
}
